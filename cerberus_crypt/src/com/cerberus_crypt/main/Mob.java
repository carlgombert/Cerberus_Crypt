package com.cerberus_crypt.main;

import java.io.Serializable;

public class Mob implements Serializable{
    
    private int health;
    private String name;
    private String type;
    private String enviornment;
    private static final long serialVersionUID = 4L;
    
    public Mob(String name, int health, String enviornment, String type){
        this.name = name;
        this.health = health;
        this.enviornment = enviornment;
        this.type = type;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setHealh(int health){
        this.health = health;
    }
    
    public void damage(int damage){
        health = health - damage;
    }
    
    public String getEnviorment(){
        return enviornment;
    }
    
    public void setEnviornment(String enviornment){
        this.enviornment = enviornment;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
}