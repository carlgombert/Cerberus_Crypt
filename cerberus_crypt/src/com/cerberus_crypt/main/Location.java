package com.cerberus_crypt.main;

import java.awt.Image;
import java.io.Serializable;
import java.util.*;

public class Location implements Serializable{
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Trader trader;
    private String name;
    private static final long serialVersionUID = 5L;
    
    public Location(String name, Trader trader, ArrayList<Enemy> enemies){
        this.name = name;
        this.enemies = enemies;
        this.trader = trader;
    }
    
    public Trader trader(){
        return trader;
    }
    
    public Enemy spawnEnemy(){
        Random rand = new Random();
        int num = rand.nextInt(enemies.size());
        return enemies.get(num);
    }
    
    public String toString(){
        return name;
    }
}