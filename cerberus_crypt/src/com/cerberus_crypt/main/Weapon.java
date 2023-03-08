package com.cerberus_crypt.main;

import java.io.Serializable;

public class Weapon extends Item implements Serializable{
    
    private int damage;
    private static final long serialVersionUID = 1L;
    private String file;
    
    public Weapon(String name, int cost, int damage, String file){
        super("Weapon", name, cost);
        this.damage = damage;
        System.out.println(name);
        this.file = file;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void setDamage(int damage){
        this.damage = damage;
    }
    
    public String getFile() {
    	return file;
    }
    
    @Override
    public String toString(){
        return super.getName() + "(" + super.getType() + ") costs " + super.getCost() + " gold and does " + damage + " damage";
    }
}