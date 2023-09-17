package com.cerberus_crypt.main;

import java.io.Serializable;
/*
 
 the item class is the superclass of both weapons and consumables. an item is something
 that can be held and bought by the player
 
 
*/
public class Item implements Serializable{
    private String type;
    private String name;
    private int cost;
    private static final long serialVersionUID = 6L;
    
    public Item(String type, String name, int cost){
        this.type = type;
        this.name = name;
        this.cost = cost;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getCost(){
        return cost;
    }
    
    public void setCost(int cost){
        this.cost = cost;
    }
    
    public String toString(){
        return name + "(" + type + ") costs " + cost + " gold";
    }
}