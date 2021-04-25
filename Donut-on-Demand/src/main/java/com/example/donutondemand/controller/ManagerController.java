package com.example.donutondemand.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.donutondemand.model.CartInfo;
import com.example.donutondemand.model.Cooking;
import com.example.donutondemand.model.DonutRecipe;
import com.example.donutondemand.model.Dough;
import com.example.donutondemand.model.Employee;
import com.example.donutondemand.model.Flavor;
import com.example.donutondemand.model.Mix;
import com.example.donutondemand.model.OrderInfo;
import com.example.donutondemand.model.Topping;
import com.example.donutondemand.service.DonutRecipeService;
import com.example.donutondemand.service.EmployeeService;
import com.example.donutondemand.util.Utils;
import com.example.donutondemand.validation.EmployeeValidator;


@Controller
//@RequestMapping("/manager")
public class ManagerController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	@Autowired
	private DonutRecipeService donutService;
	
	@RequestMapping(path = "/createEmployee", method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("employee", new Employee());
		return "createEmployee.jsp";
	}
	
	@RequestMapping(path = "/createEmployee", method=RequestMethod.POST)
	public String createEmployee( @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Principal principal) {
		employeeValidator.validate(employee, bindingResult);
		
		if (bindingResult.hasErrors()) {
            return "createEmployee.jsp";
        }
		
		Employee manager = employeeService.findByUsername(principal.getName());
		employee.setShopE(manager.getShopE());
		employeeService.save(employee);
		
		return "redirect:/homeEmployee";
	}
	
	
	@RequestMapping(path = "/addDonutRecipee", method=RequestMethod.GET)
	public ModelAndView donutRecipee(Model model) {
		model.addAttribute("newDonutRecipee", new DonutRecipe());
		
		ModelAndView mv = new ModelAndView("addRecipee.jsp");
		List<DonutRecipe> donuts = donutService.findAllDonuts();
		mv.addObject("donuts" , donuts);
		mv.addObject("cookings", Cooking.values());
		mv.addObject("mixs", Mix.values());
		mv.addObject("doughs", Dough.values());
		mv.addObject("flavors", Flavor.values());
		mv.addObject("toppings", Topping.values());
		return mv;
	}
	
	@RequestMapping(value = { "/addDonutRecipee" }, method = RequestMethod.POST)
    public String addDonutRecipee(@ModelAttribute("newDonutRecipee") DonutRecipe donutRecipe) {
  
    	double price = donutRecipe.getDough().getPrice() + donutRecipe.getFlavor().getPrice() 
    			+ donutRecipe.getTopping().getPrice();
    	
    	donutRecipe.setPrice(price);
    	
    	donutService.addDonutRecipe(donutRecipe);
        // Redirect to Confirmation page.
        return "redirect:/addDonutRecipee";
    }

	
	@RequestMapping({ "/deleteDonutRecipee" })
    public String deleteDonutRecipee(HttpServletRequest request, Model model,
    		@RequestParam(value = "id", defaultValue = "") int id) {
		
		donutService.deleteDonut(id);
	
		return "redirect:/addDonutRecipee";
	}
}
