package com.example.donutondemand.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.example.donutondemand.dao.OrderJPADao;
import com.example.donutondemand.model.CartInfo;
import com.example.donutondemand.model.CartLineInfo;
import com.example.donutondemand.model.Customer;
import com.example.donutondemand.model.Order;
import com.example.donutondemand.model.OrderInfo;
import com.example.donutondemand.model.OrderLine;
import com.example.donutondemand.model.Shop;
import com.example.donutondemand.model.Status;


@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	OrderJPADao orderDao;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ShopService shopService;
	
	@Override
	public void save(CartInfo cart) {
		Order newOrder = new Order();
				
		OrderInfo orderInfo = cart.getOrderInfo();
		
		Shop s = shopService.findById(orderInfo.getShop().getId());
		newOrder.setShopO(s);
		
		System.out.println(s.getName());
		System.out.println(orderInfo.toString());
		
		Customer customer = new Customer();
		customer.setFirstname(orderInfo.getFirstname());
		customer.setLastname(orderInfo.getLastname());
		customer.setEmail(orderInfo.getEmail());
		customer.setPhone(orderInfo.getPhone());
		newOrder.setCustomer(customer);
		
		newOrder.setStatus(Status.PROCESSING);
		
		Set<OrderLine> orderlines = new HashSet<>();
		
		for(CartLineInfo cl : cart.getCartLines() ) {
			OrderLine ol = new OrderLine();
			ol.setDonut(cl.getDonutRecipe());
			ol.setPrice(cl.getAmount());
			ol.setQuantity(cl.getQuantity());
			ol.setOrder(newOrder);
			orderlines.add(ol);
		}
		
		newOrder.setOrderlines(orderlines);
		
		
		newOrder.setPickUpDate(LocalDate.parse(orderInfo.getPickUpDate()));
		newOrder.setPickUpTime(LocalTime.parse(orderInfo.getPickUpTime() + ":00"));;
		
		try {
			orderDao.save(newOrder);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			System.out.println("TETSTSTSTSTSTSTS");
		}
		
		
		
		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setTo(customer.getEmail());
		emailMsg.setText("Thank you for your Order !" + '\n' + "Your order num is : " + newOrder.getId() );
		emailMsg.setSubject("Order successful!");
		emailMsg.setFrom("manager@donuttc.asia");

		try {
			emailService.sendEmail(emailMsg);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

}
