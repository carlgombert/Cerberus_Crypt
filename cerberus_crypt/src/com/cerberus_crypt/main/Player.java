package com.cerberus_crypt.main;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable{
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private ArrayList<Consumable> consumables = new ArrayList<Consumable>();
    private int health;
    private int gold;
    private int damage;
    transient private Location location;
    private static final long serialVersionUID = 3L;
    private Weapon currentWeapon;
    
    public Player(int health, int gold, Location location){
        this.health = health;
        this.gold = gold;
        this.location = location;
        this.damage = 1;
    }
    
    public Location getLocation(){
        return location;
    }
    
    public void setLocation(Location location){
        this.location = location;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }
    
    public void equipWeapon(Weapon weapon) {
    	damage = weapon.getDamage();
    	currentWeapon = weapon;
    	Frame.addInventory(Frame.inventoryPosition);
    }
    
    public void setWeapon(Weapon weapon) {
    	damage = weapon.getDamage();
    	currentWeapon = weapon;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int health){
        this.health = health;
        if(this.health > 100){
            this.health = 100;
        }
    }
    
    public int getGold(){
        return gold;
    }
    
    public void setGold(int gold){
        this.gold = gold;
    }
    
    public void addGold(int gold){
        this.gold += gold;
    }
    
    public void addConsumable(Consumable consumable){
        consumables.add(consumable);
    }
    
    public void clearConsumables(){
        consumables.clear();
    }
    
    public void wipeInventory(){
        consumables.clear();
        weapons.clear();
    }
    
    public void eat(int i){
        health += consumables.get(i).getHealing();
        if(health > 100){
            health = 100;
        }
        consumables.remove(i);
    }
    
    public void consumableMenu(){
        int i = 0;
        for(Consumable x: consumables){
            i++;
        }
    }
    
    public void damage(int damage){
        health = health - damage;
    }
    
    public void attack(Mob mob){
        mob.damage(damage);
    }
    
    public ArrayList<Consumable> getConsumables(){
    	return consumables;
    }
    
    public String toString() {
    	return "health: " + health + ", gold: " + gold;
    }

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	
	public Weapon getWeapon() {
		return currentWeapon;
	}
}