package com.cerberus_crypt.main;

import java.io.Serializable;
import java.util.ArrayList;

public class Trader extends Mob implements Serializable{
    
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private ArrayList<Consumable> consumables = new ArrayList<Consumable>();
    private static final long serialVersionUID = 2L;
    private String file;
    
    public Trader(String name, int health, String enviornment, ArrayList<Consumable> consumables, ArrayList<Weapon> weapons, String file){
        super(name, health, enviornment, "Trader");
        this.weapons = weapons;
        this.consumables = consumables;
        this.file = file;
    }
    
    public ArrayList<Weapon> getWeapons(){
    	return weapons;
    }
    
    public ArrayList<Consumable> getConsumables(){
    	return consumables;
    }
    
    public String getFile() {
    	return file;
    }
    
    public void trade(){
        System.out.println("CONSUMABLES");
        for(int i = 0; i < consumables.size(); i++){
            System.out.println("[" + (i + 1) + "]" + consumables.get(i).getName());
            System.out.println("cost: " + consumables.get(i).getCost() + " healing: " + consumables.get(i).getHealing());
        }
        System.out.println("\nWEAPONS");
        for(int n = 0; n < weapons.size(); n++){
            System.out.println("[" + (n + consumables.size() + 1) + "]" + weapons.get(n).getName());
            System.out.println("cost: " + weapons.get(n).getCost() + " damage: " + weapons.get(n).getDamage());
        }
        System.out.println("Enter 0 to leave");
    }
    
    public void buy(int index, Player player){
        if(index > (consumables.size() + weapons.size())){
            
        }
        else if(index >= consumables.size()){
            index = index - consumables.size();
            if(player.getGold() < weapons.get(index).getCost()){
                
            }
            else{
                player.setGold(player.getGold() - weapons.get(index).getCost());
                player.addWeapon(weapons.get(index));
            }
        }
        else{
            if(player.getGold() < consumables.get(index).getCost()){
                
            }
            else{
                player.setGold(player.getGold() - consumables.get(index).getCost());
                player.addConsumable(consumables.get(index));
            }
        }
    }
}