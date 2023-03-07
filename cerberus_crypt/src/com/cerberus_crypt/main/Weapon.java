package com.cerberus_crypt.main;

import java.io.Serializable;

public class Weapon extends Item implements Serializable{
    
    private int damage;
    private static final long serialVersionUID = 1L;
    
    public Weapon(String name, int cost, int damage){
        super("Weapon", name, cost);
        this.damage = damage;
        System.out.println(name);
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void setDamage(int damage){
        this.damage = damage;
    }
    
    @Override
    public String toString(){
        return super.getName() + "(" + super.getType() + ") costs " + super.getCost() + " gold and does " + damage + " damage";
    }
}