package com.example.donutondemand.model;

public class CartLineInfo {
	
	private DonutRecipe donutRecipe;
    
	private int quantity;
 
    public CartLineInfo() {
        this.quantity = 0;
    }
 
    public DonutRecipe getDonutRecipe() {
        return this.donutRecipe;
    }
 
    public void setDonutRecipe(DonutRecipe donutRecipe) {
        this.donutRecipe = donutRecipe;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    public double getAmount() {
        return this.donutRecipe.getPrice() * this.quantity;
    }
}
