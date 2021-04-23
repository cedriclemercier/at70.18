package com.example.donutondemand.controller;

import java.util.List;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.donutondemand.model.CartInfo;
import com.example.donutondemand.model.DonutRecipe;
import com.example.donutondemand.model.OrderInfo;
import com.example.donutondemand.model.Shop;
import com.example.donutondemand.service.DonutRecipeService;
import com.example.donutondemand.service.OrderService;
import com.example.donutondemand.service.ShopService;
import com.example.donutondemand.util.Utils;
import com.example.donutondemand.validation.OrderValidator;


@Controller
public class UserController {
	
	
	@Autowired
	private DonutRecipeService donutService;
	
	@Autowired
	private OrderValidator orderValidator;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(path = {"", "/home"})
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
    
    // GET: Enter customer information.
    @RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.GET)
    public ModelAndView shoppingCartCustomerForm(HttpServletRequest request, Model model) {
 
    	ModelAndView mv = new ModelAndView("shoppingCartCustomer.jsp");
        CartInfo cartInfo = Utils.getCartInSession(request);
      
        // Cart is empty.
        if (cartInfo.isEmpty()) {
             
        	mv = new ModelAndView("redirect:/shoppingCart");
            return mv;
        }
 
        OrderInfo orderInfo = cartInfo.getOrderInfo();
        if (orderInfo == null) {
        	orderInfo = new OrderInfo();
        }
        
        List<Shop> shops = shopService.findAllShops();
        mv.addObject("shops",shops);
        model.addAttribute("orderInfoForm", orderInfo);
 
        return mv;
    }
    
    // POST: Save customer information.
    @RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.POST)
    public String shoppingCartCustomerSave(HttpServletRequest request,
            @ModelAttribute("orderInfoForm") OrderInfo orderInfo, 
            BindingResult result) {
  
    	orderValidator.validate(orderInfo, result);
        // If has Errors.
        if (result.hasErrors()) {
        	orderInfo.setValid(false);
            return "redirect:/shoppingCartCustomer";
        }
        
        orderInfo.setValid(true);
        CartInfo cartInfo = Utils.getCartInSession(request);
 
        cartInfo.setOrderInfo(orderInfo);
 
        // Redirect to Confirmation page.
        return "redirect:/shoppingCartConfirmation";
    }
    
    
 
    @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.GET)
    public String shoppingCartConfirmationHandler(HttpServletRequest request, Model model) {
        CartInfo myCart = Utils.getCartInSession(request);
       
     // Cart have no products.
        if (myCart.isEmpty()) {
            // Redirect to shoppingCart page.
            return "redirect:/shoppingCart";
        } else if (!myCart.isValidOrder()) {
            // Enter customer info.
            return "redirect:/shoppingCartCustomer";
        }
        
        model.addAttribute("cartInfo", myCart);
        return "shoppingCartConfirmation.jsp";
    }
    
    @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.POST)
    // Avoid UnexpectedRollbackException (See more explanations)
    //@Transactional(propagation = Propagation.NEVER)
    public String shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
        CartInfo cartInfo = Utils.getCartInSession(request);
 
        // Cart have no products.
        if (cartInfo.isEmpty()) {
            // Redirect to shoppingCart page.
            return "redirect:/shoppingCart";
        } else if (!cartInfo.isValidOrder()) {
            // Enter customer info.
            return "redirect:/shoppingCartCustomer";
        }
        
        try {
        	
            orderService.save(cartInfo);
        } catch (Exception e) {
            // Need: Propagation.NEVER?
            return "shoppingCartConfirmation.jsp";
        }
        // Remove Cart In Session.
        Utils.removeCartInSession(request);
         
        // Store Last ordered cart to Session.
        Utils.storeLastOrderedCartInSession(request, cartInfo);
 
        // Redirect to successful page.
        return "redirect:/shoppingCartFinalize";
    }
    
    @RequestMapping(value = { "/shoppingCartFinalize" }, method = RequestMethod.GET)
    public String shoppingCartFinalize(HttpServletRequest request, Model model) {
 
        CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);
 
        if (lastOrderedCart == null) {
            return "redirect:/shoppingCart";
        }
 
        return "shoppingCartFinalize.jsp";
    }
 
    
}
