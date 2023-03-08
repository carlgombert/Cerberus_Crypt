package com.cerberus_crypt.main;

import java.io.Serializable;
import java.util.Random;

public class Enemy extends Mob implements Serializable{
    
    private int intelligence;
    private int damageMax;
    private int damageMin;
    private static final long serialVersionUID = 7L;
    
    public Enemy(String name, int health, String enviornment, int damageMax, int damageMin, int intelligence){
        super(name, health, enviornment, "Enemy");
        this.damageMax = damageMax;
        this.damageMin = damageMin;
        this.intelligence = intelligence;
    }
    
    public int getIntelligence(){
        return intelligence;
    }
    
    public void attack(Player player){
        Random rand = new Random();
        int damage = (int)Math.floor(Math.random()*(damageMax-damageMin+1)+damageMin);
        player.damage(damage);
    }
    
    public int dropGold(){
        return (super.getHealth() * damageMax) / 100;
    }
}