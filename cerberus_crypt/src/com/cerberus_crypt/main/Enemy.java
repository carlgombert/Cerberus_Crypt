package com.cerberus_crypt.main;

import java.io.Serializable;
import java.util.Random;

/*

The enemy class handles enemies that the player can encounter while exploring in the game


*/

public class Enemy extends Mob implements Serializable{
    
    private int intelligence; //intelligence is on a 1 to 10 scale and determines how easy an enemy is to escape
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
    
    //attacks given player
    public void attack(Player player){
        Random rand = new Random();
        int damage = (int)Math.floor(Math.random()*(damageMax-damageMin+1)+damageMin);
        player.damage(damage);
    }
    
    //drops gold once killed
    public int dropGold(){
    	//if the player was able to kill the enemy in one hit don't drop any gold
    	if(super.getHealth() <= Game.player.getDamage()) {
    		return 0;
    	}
    	return (super.getHealth() * damageMax) / 100;
    }
}