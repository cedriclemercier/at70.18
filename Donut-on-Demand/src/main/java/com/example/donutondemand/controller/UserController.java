package com.example.donutondemand.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.donutondemand.model.CartInfo;
import com.example.donutondemand.model.DonutRecipe;
import com.example.donutondemand.service.DonutRecipeService;
import com.example.donutondemand.util.Utils;


@Controller
public class UserController {
	
	
	@Autowired
	private DonutRecipeService donutService;
	
	@RequestMapping(path = "/home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping(path = "/donutList" , method=RequestMethod.GET)
	public ModelAndView listDonutHandler(Model model) {
		
		ModelAndView mv = new ModelAndView("donutList.jsp");
		List<DonutRecipe> donuts = donutService.findAllDonuts();
		mv.addObject("donuts" , donuts);

		//model.addAttribute("order", new Order());
		
		
		return mv;
	}

	
	@RequestMapping({ "/addDonut" })
    public String listProductHandler(HttpServletRequest request, Model model, //
            @RequestParam(value = "id", defaultValue = "") int id) {

        DonutRecipe donutR = donutService.findById(id);

        if (donutR != null) {
 
            // Cart info stored in Session.
            CartInfo cartInfo = Utils.getCartInSession(request);
  
            cartInfo.addDonut(donutR, 1);
        }
        
        
        // Redirect to shoppingCart page.
        return "redirect:/shoppingCart";
    }
	
	
	// GET: Show Cart
    @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.GET)
    public String shoppingCartHandler(HttpServletRequest request, Model model) {
        CartInfo myCart = Utils.getCartInSession(request);
        
        model.addAttribute("cartForm", myCart);
        return "shoppingCart.jsp";
    }
    
    
    @RequestMapping({ "/shoppingCartRemoveProduct" })
    public String removeDonutéHandler(HttpServletRequest request, Model model, 
    		@RequestParam(value = "id", defaultValue = "") int id) {
    	DonutRecipe donutR = donutService.findById(id);
        if (donutR != null) {
 
            // Cart Info stored in Session.
            CartInfo cartInfo = Utils.getCartInSession(request);
  
            cartInfo.removeDonut(donutR);
 
        }
        // Redirect to shoppingCart page.
        return "redirect:/shoppingCart";
    }
 
    // POST: Update quantity of products in cart.
    @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.POST)
    public String shoppingCartUpdateQty(HttpServletRequest request,
            Model model, 
            @ModelAttribute("cartForm") CartInfo cartForm) {
 
        CartInfo cartInfo = Utils.getCartInSession(request);
        cartInfo.updateQuantity(cartForm);
 
        // Redirect to shoppingCart page.
        return "redirect:/shoppingCart";
    }
}
