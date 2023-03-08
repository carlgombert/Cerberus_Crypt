package com.cerberus_crypt.main;

import java.io.Serializable;

public class Consumable extends Item implements Serializable{
    
    private int healing;
    private static final long serialVersionUID = 8L;
    
    public Consumable(String name, int cost, int healing){
        super("Consumable", name, cost);
        this.healing = healing;
    }
    
    public int getHealing(){
        return healing;
    }
    
    public void setHealing(int healing){
        this.healing = healing;
    }
    
    public String toString(){
        return super.getName() + "(" + super.getType() + ") costs " + super.getCost() + " gold and gives " + healing + " points of health";
    }
}