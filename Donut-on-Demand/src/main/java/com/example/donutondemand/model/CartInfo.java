package com.example.donutondemand.model;

import java.util.ArrayList;

import java.util.List;

public class CartInfo {
	private int orderNum;
	  
	private OrderInfo orderInfo;
	
    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
 
    public CartInfo() {
 
    }
 
    public int getOrderNum() {
        return orderNum;
    }
 
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
 
    public OrderInfo getOrderInfo() {
        return orderInfo;
    }
 
    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
 
    public List<CartLineInfo> getCartLines() {
        return this.cartLines;
    }
 
    private CartLineInfo findLineById(int id) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getDonutRecipe().getId() == id) {
                return line;
            }
        }
        return null;
    }
 
    public void addDonut(DonutRecipe donutRecipe, int quantity) {
        CartLineInfo line = this.findLineById(donutRecipe.getId());
 
        if (line == null) {
            line = new CartLineInfo();
            line.setQuantity(0);
            line.setDonutRecipe(donutRecipe);
            this.cartLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }
 
 
    public void updateDonut(int id, int quantity) {
        CartLineInfo line = this.findLineById(id);
 
        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }
 
    public void removeDonut(DonutRecipe donutRecipe) {
        CartLineInfo line = this.findLineById(donutRecipe.getId());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }
 
    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }
 
    public boolean isValidOrder() {
        return this.orderInfo != null && this.orderInfo.isValid();
    }
 
    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }
 
    public double getAmountTotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getAmount();
        }
        return total;
    }
 
    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateDonut(line.getDonutRecipe().getId(), line.getQuantity());
            }
        }
 
    }
    
    
    
}
