package com.cerberus_crypt.main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Game {
	
transient public static Frame frame;

	public static Player player = new Player(100, 20, null);
	
	public static String text;
	
	transient static ArrayList<Enemy> grasslandsEnemies = new ArrayList<Enemy>();
	transient static ArrayList<Enemy> forestEnemies = new ArrayList<Enemy>();
	transient static ArrayList<Enemy> deepForestEnemies = new ArrayList<Enemy>();
	transient static ArrayList<Enemy> caveEnemies = new ArrayList<Enemy>();
	transient static ArrayList<Enemy> swampEnemies = new ArrayList<Enemy>();
	transient static ArrayList<Enemy> mountainsEnemies = new ArrayList<Enemy>();
	transient static ArrayList<Enemy> tundraEnemies = new ArrayList<Enemy>();
	transient static ArrayList<Enemy> desertEnemies = new ArrayList<Enemy>();
    
	transient static ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	transient static ArrayList<Consumable> consumables = new ArrayList<Consumable>();
    
	transient static ArrayList<Weapon> elvenWeapons = new ArrayList<Weapon>();
	transient static ArrayList<Consumable> elvenConsumables = new ArrayList<Consumable>();
    
	transient static ArrayList<Weapon> humanWeapons = new ArrayList<Weapon>();
	transient static ArrayList<Consumable> humanConsumables = new ArrayList<Consumable>();
    
	transient static ArrayList<Weapon> dwarfWeapons = new ArrayList<Weapon>();
	transient static ArrayList<Consumable> dwarfConsumables = new ArrayList<Consumable>();
    
	transient static ArrayList<Weapon> dragonbornWeapons = new ArrayList<Weapon>();
	transient static ArrayList<Consumable> dragonbornConsumables = new ArrayList<Consumable>();
    
	transient static ArrayList<Trader> traders = new ArrayList<Trader>();
    transient static ArrayList<Location> locations = new ArrayList<Location>();
    transient static ArrayList<String> log = new ArrayList<String>();
	
    public static Consumable apple = new Consumable("Apple", 10, 18);
    public static Consumable bread = new Consumable("Bread", 5, 10);
    public static Consumable salmon = new Consumable("Salmon", 12, 22);
    public static Consumable cheese = new Consumable("Cheese", 8, 15);
    public static Consumable pork = new Consumable("Pork", 11, 20);
    public static Consumable healingPotion = new Consumable("Healing Potion", 100, 200);
    public static Consumable stew = new Consumable("Stew", 20, 40);
    public static Consumable cabbage = new Consumable("Cabbage", 3, 5);
    public static Consumable berries = new Consumable("Berries", 4, 8);
    public static Consumable mushroom = new Consumable("Mushroom",2, 3);
    public static Consumable frog = new Consumable("Frog", 12, 21);
    public static Consumable elixer = new Consumable("Elixer", 50, 100);
    public static Consumable treeBark = new Consumable("Tree Bark", 1, 2);
    public static Consumable beef = new Consumable("Beef", 11, 20);
    public static Consumable mutton = new Consumable("Mutton", 10, 19);
    public static Consumable meatStew = new Consumable("Meat Stew", 25, 50);
    public static Consumable fireStew = new Consumable("Fire Stew", 35, 70);
    public static Consumable beer = new Consumable("Beer", 10, 19);
    public static Consumable ale = new Consumable("Ale", 10, 19);
    //}
    //weapons{
    public static Weapon dagger = new Weapon("Dagger", 17, 25);
    public static Weapon battleAxe = new Weapon("Battle Axe", 25, 35);
    public static Weapon huntingBow = new Weapon("Hunting Bow", 30, 38);
    public static Weapon ironSword = new Weapon("Iron Sword", 35, 40);
    public static Weapon mace = new Weapon("Mace", 35, 40);
    public static Weapon spear = new Weapon("Spear", 55, 48);
    public static Weapon morningStar = new Weapon("Morning Star", 75, 60);
    public static Weapon steelSword = new Weapon("Steel Sword", 75, 55);
    public static Weapon longBow = new Weapon("Long Bow", 100, 68);
    public static Weapon crossbow = new Weapon("Crossbow", 100, 70);
    public static Weapon steelGreatSword = new Weapon("Steel Greatsword", 120, 80);
    public static Weapon trident = new Weapon("Trident", 200, 90);
    public static Weapon ephorosHammer = new Weapon("Ephoros Hammer", 260, 100);
    public static Weapon miraaksSword = new Weapon("Miraak's Sword", 300, 120);
    public static Weapon magos = new Weapon("Magos", 380, 160);
    //}
    //Enemies{
    public static Enemy cyclops = new Enemy("Cyclops", 250, "Tundra", 20, 10, 1);
    public static Enemy giant = new Enemy("Giant", 300, "Forest", 20, 10, 1);
    public static Enemy cerberus = new Enemy("Cerberus", 100, "Cave", 30, 10, 5);
    public static Enemy bandit = new Enemy("Bandit", 70, "Grasslands", 25, 0, 3);
    public static Enemy ghost = new Enemy("Ghost", 40, "Cave", 30, 0, 2);
    public static Enemy skeleton = new Enemy("Skeleton", 50, "Cave", 40, 10, 3);
    public static Enemy wolf = new Enemy("Wolf", 40, "Forest", 30, 0, 6);
    public static Enemy wildDog = new Enemy("Wild Dog", 40, "Grasslands", 30, 0, 6);
    public static Enemy blight = new Enemy("Blight", 100, "Swamp", 30, 0, 9);
    public static Enemy yeti = new Enemy("Yeti", 140, "Mountains", 30, 0, 4);
    public static Enemy goblin = new Enemy("Goblin", 30, "Cave", 60, 0, 8);
    public static Enemy barlgura = new Enemy("Barlgura", 350, "Deep Forest", 60, 0, 4);
    public static Enemy drider = new Enemy("Drider", 120, "Deep Forest", 40, 0, 4);
    public static Enemy bonedevil = new Enemy("Bone Devil", 400, "Desert", 50, 0, 5);
    public static Enemy witch = new Enemy("Witch", 80, "Swamp", 40, 0, 9);
    //}
    //traders{
    public static Trader trader = new Trader("Trader", 100, "Grassland", humanConsumables, humanWeapons);
    public static Trader dwarfTrader = new Trader("Dwarf Trader", 100, "Cave", dwarfConsumables, dwarfWeapons);
    public static Trader dragonbornTrader = new Trader("Dragonborn Trader", 100, "Tundra", dragonbornConsumables, dragonbornWeapons);
    public static Trader elvenTrader = new Trader("Elven Trader", 100, "Forest", elvenConsumables, elvenWeapons);
    //}
    //locations{
    public static Location grasslands = new Location("Grasslands", trader, grasslandsEnemies);
    public static Location caves = new Location("Caves", trader, caveEnemies);
    public static Location forest = new Location("Forest", elvenTrader, forestEnemies);
    public static Location deepForest = new Location("Deep Forest", elvenTrader, deepForestEnemies);
    public static Location swamp = new Location("Swamp", elvenTrader, swampEnemies);
    public static Location mountains = new Location("Mountains", dwarfTrader, mountainsEnemies);
    public static Location tundra = new Location("Tundra", dragonbornTrader, tundraEnemies);
    public static Location desert = new Location("Desert", dwarfTrader, desertEnemies);
    //}
    
    public static Random rand = new Random();
	
    private static ArrayList<String> codeList;
    private static ArrayList<String> textList;
    private static ArrayList<ArrayList<Object>> data;
    
    public Game() {
    	consumables.add(treeBark);
        consumables.add(mushroom);
        consumables.add(cabbage);
        consumables.add(bread);
        consumables.add(cheese);
        consumables.add(apple);
        consumables.add(ale);
        consumables.add(beer);
        consumables.add(mutton);
        consumables.add(beef);
        consumables.add(pork);
        consumables.add(salmon);
        consumables.add(frog);
        consumables.add(stew);
        consumables.add(meatStew);
        consumables.add(fireStew);
        consumables.add(elixer);
        consumables.add(healingPotion);
        elvenConsumables.add(treeBark);
        elvenConsumables.add(mushroom);
        humanConsumables.add(cabbage);
        humanConsumables.add(bread);
        humanConsumables.add(cheese);
        humanConsumables.add(apple);
        dwarfConsumables.add(ale);
        humanConsumables.add(beer);
        dwarfConsumables.add(mutton);
        humanConsumables.add(beef);
        dwarfConsumables.add(pork);
        humanConsumables.add(salmon);
        elvenConsumables.add(frog);
        humanConsumables.add(stew);
        dwarfConsumables.add(meatStew);
        dragonbornConsumables.add(fireStew);
        elvenConsumables.add(elixer);
        humanConsumables.add(healingPotion);
        //}
        //weapons{
        weapons.add(dagger);
        weapons.add(battleAxe);
        weapons.add(huntingBow);
        weapons.add(ironSword);
        weapons.add(mace);
        weapons.add(spear);
        weapons.add(morningStar);
        weapons.add(steelSword);
        weapons.add(longBow);
        weapons.add(crossbow);
        weapons.add(steelGreatSword);
        weapons.add(trident);
        weapons.add(ephorosHammer);
        weapons.add(miraaksSword);
        weapons.add(magos);
        humanWeapons.add(dagger);
        dwarfWeapons.add(battleAxe);
        elvenWeapons.add(huntingBow);
        humanWeapons.add(ironSword);
        dwarfWeapons.add(mace);
        humanWeapons.add(spear);
        dwarfWeapons.add(morningStar);
        humanWeapons.add(steelSword);
        elvenWeapons.add(longBow);
        dragonbornWeapons.add(crossbow);
        humanWeapons.add(steelGreatSword);
        dragonbornWeapons.add(trident);
        dwarfWeapons.add(ephorosHammer);
        dragonbornWeapons.add(miraaksSword);
        humanWeapons.add(magos);
        //}
        //Enemies{
        tundraEnemies.add(cyclops);
        forestEnemies.add(giant);
        caveEnemies.add(cerberus);
        grasslandsEnemies.add(bandit);
        caveEnemies.add(ghost);
        caveEnemies.add(skeleton);
        forestEnemies.add(wolf);
        grasslandsEnemies.add(wildDog);
        swampEnemies.add(blight);
        mountainsEnemies.add(yeti);
        caveEnemies.add(goblin);
        deepForestEnemies.add(barlgura);
        deepForestEnemies.add(drider);
        desertEnemies.add(bonedevil);
        swampEnemies.add(witch);
        //}
        //traders{
        traders.add(trader);
        traders.add(dwarfTrader);
        traders.add(dragonbornTrader);
        traders.add(elvenTrader);
        //}
        //locations{
        locations.add(grasslands);
        locations.add(caves);
        locations.add(forest);
        locations.add(deepForest);
        locations.add(swamp);
        locations.add(mountains);
        locations.add(tundra);
        locations.add(desert);
        //}
        initializePlayer();
        int random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
    }
    
    
	public static HashMap<JButton, Integer> createOptions(ArrayList<String> codeList, ArrayList<String> textList, ArrayList<ArrayList<Object>> data){
		
		if(codeList.get(0).equals("7")) {
			Frame.exploreExitButton.setVisible(true);
		}
		
		Frame.updateHUD();
		System.out.println(player.getHealth());
		Frame.optionPane.removeAll();
		Frame.optionPane.repaint();
		
		Frame.exploreText.setText(text);
		
		HashMap<JButton, Integer> map = new HashMap<JButton, Integer>();
		int border = (Frame.unit/15);
		int thickness;
		if(codeList.size() > 6) {
			thickness = (Frame.unit * 6)/codeList.size();
		}
		else {
			thickness = Frame.unit;
		}
		
		for(int i = 0; i < codeList.size(); i++) {
			System.out.println(textList.get(i));
			
			String code = codeList.get(i);
			ArrayList<Object> list = data.get(i);
			
			JButton button = Frame.createButton(new JButton(), 0 + border, (i*thickness) + border, Frame.unit*13 - (border * 2), thickness - border, textList.get(i), true, Frame.fireBrick, Frame.gold, Frame.font);
			button.addActionListener(e -> decoder(code, list));
			map.put(button, i);
			Frame.optionPane.add(button);
		}
		System.out.println("");
		return map;
	}
	
	//method code: 1
    public static void encounter(){
    	codeList = new ArrayList<String>();
    	textList = new ArrayList<String>();
    	data = new ArrayList<ArrayList<Object>>();
    	
    	ArrayList<Object> data1 = new ArrayList<Object>();
    	ArrayList<Object> data2 = new ArrayList<Object>();
    	
        int chance = rand.nextInt(100);
        
        if(chance < 70){
        	Frame.exploreExitButton.setVisible(false);
        	
            Enemy enemy = player.getLocation().spawnEnemy();
            
            text = "You have encountered a " + enemy.getName() + ". what will you do?";
            
            codeList.add("3");
            codeList.add("5");
            
            textList.add("fight");
            textList.add("flee");
            
            data1.add(enemy);
            data1.add(0);
            data1.add(player.getHealth());
            data1.add(false);
            
            data2.add(enemy);
            
            data.add(data1);
            data.add(data2);
            
            createOptions(codeList, textList, data);
        }
        else{
            Trader trader = player.getLocation().trader();
            
            text = "You have encountered a " + trader.getName();
            
            codeList.add("2");
            codeList.add("7");
            
            textList.add("trade");
            textList.add("leave");
            
            data1.add(trader);
            
            data.add(data1);
            data.add(data2);
            
            createOptions(codeList, textList, data);
        }
    }
    
    //method code 2
    public static void trade(Trader trader){
    	codeList = new ArrayList<String>();
    	textList = new ArrayList<String>();
    	data = new ArrayList<ArrayList<Object>>();
    	
    	ArrayList<Object> data1 = new ArrayList<Object>();
    	
    	//trade code
    	
    	
    	codeList.add("7");
        
        textList.add("continue");
        
        data.add(data1);
    	
        trader.trade();
        
        createOptions(codeList, textList, data);
        
    }
    
    //method code 3
    public static void battle(Enemy enemy, int counter, int health, boolean attacked){
    	codeList = new ArrayList<String>();
    	textList = new ArrayList<String>();
    	data = new ArrayList<ArrayList<Object>>();
    	
    	ArrayList<Object> data1 = new ArrayList<Object>();
    	ArrayList<Object> data2 = new ArrayList<Object>();
        int counterCap = enemy.getHealth();
        
        if(counter >= counterCap){
            int droppedGold = enemy.dropGold();
            player.addGold(droppedGold);
            
            text = "<html>You killed the " + enemy.getName() + "!<br/>It dropped " + droppedGold + " gold coins.</html>";
            
            codeList.add("7");
            
            textList.add("continue");
            
            data.add(data1);
            
            createOptions(codeList, textList, data);
        }
        else if(attacked == false){
            
            text = "You are fighting a " + enemy.getName() + " with " + (counterCap - counter) + " health";
            counter += player.getDamage();
            
            codeList.add("3");
            codeList.add("8");
            
            textList.add("attack");
            textList.add("surrender");
            
            data1.add(enemy);
            data1.add(counter);
            data1.add(player.getHealth());
            data1.add(true);
            
            data2.add(enemy);
            
            data.add(data1);
            data.add(data2);
            
            createOptions(codeList, textList, data);
            
        }
        else if(attacked == true){
        	
        	enemy.attack(player);
        	
        	if(player.getHealth() <= 0) {
            	die("a " + enemy.getName() + " killed you");
            	
            }
        	
        	else {
	            text = "<html>You are fighting a " + enemy.getName() + " with " + (counterCap - counter) + " health<br/>The " + enemy.getName() + " dealt " + (health - player.getHealth()) + " damage.</html>";
	            counter += player.getDamage();
	            
	            codeList.add("3");
	            codeList.add("8");
	            
	            textList.add("attack");
	            textList.add("surrender");
	            
	            data1.add(enemy);
	            data1.add(counter);
	            data1.add(player.getHealth());
	            data1.add(true);
	            
	            data2.add(enemy);
	            
	            data.add(data1);
	            data.add(data2);
	            
	            createOptions(codeList, textList, data);
        	}
        }
    }
    
    //method code 4
    public static void die(String cause){
    	codeList = new ArrayList<String>();
    	textList = new ArrayList<String>();
    	data = new ArrayList<ArrayList<Object>>();
    		
    	ArrayList<Object> data1 = new ArrayList<Object>();
    	
    	text = "YOU HAVE DIED... " + cause;
    	
        initializePlayer();
        
        codeList.add("7");
        textList.add("continue...");
        
        data.add(data1);
        
        createOptions(codeList, textList, data);
        
    }
    
    private static void initializePlayer() {
    	player.clearConsumables();
		int random = rand.nextInt(consumables.size());
		player.setHealth(100);
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        random = rand.nextInt(consumables.size());
        player.addConsumable(consumables.get(random));
        player.setLocation(locations.get(0));
        player.setGold(20);
	}


	//method code 5
    public static void flee(Enemy enemy){
    	
    	codeList = new ArrayList<String>();
    	textList = new ArrayList<String>();
    	data = new ArrayList<ArrayList<Object>>();
    		
    	ArrayList<Object> data1 = new ArrayList<Object>();
    	
        Scanner input = new Scanner(System.in);
        double intel = enemy.getIntelligence();
        double boost = intel / 10;
        double val = 1 + boost;
        double num = val * 5;
        Random rand = new Random();
        int chance = rand.nextInt(10);
        if(chance >= num){
            text = "You have escaped the " + enemy.getName() + "!";
            
            codeList.add("7");
            textList.add("continue");
            
            data.add(data1);
            
            createOptions(codeList, textList, data);
        }
        else{
        	
        	text = "The "+ enemy.getName() + " has caught up to you!";
        	
        	codeList.add("3");
            textList.add("continue");
        	
            data1.add(enemy);
            data1.add(0);
            data1.add(player.getHealth());
            data1.add(false);
            
            data.add(data1);
            
            createOptions(codeList, textList, data);
        }
    }
    
    //method code 6
    public static void loot(){
    	
    	codeList = new ArrayList<String>();
    	textList = new ArrayList<String>();
    	data = new ArrayList<ArrayList<Object>>();
    		
    	ArrayList<Object> data1 = new ArrayList<Object>();
    	
        int chance = rand.nextInt(100);
        if(chance < 50) {
            int num = rand.nextInt(10) + 1;
            text = "You have found " + num + " gold coins on the ground!";
            player.addGold(num);
            
            codeList.add("7");
            textList.add("pick up coins and continue");
            
            data.add(data1);
            
            createOptions(codeList, textList, data);
        }
        else if(chance > 49 || chance < 75) {
            int num = rand.nextInt(consumables.size());
            
            System.out.println("You have found a " + consumables.get(num).getName() + " on the ground. would you like to pick it up?");
            text = "You have found a " + consumables.get(num).getName() + " on the ground!";
            player.addConsumable(consumables.get(num));
            
            codeList.add("7");
            textList.add("pick up " + consumables.get(num).getName() + " and continue");
            
            data.add(data1);
            
            createOptions(codeList, textList, data);
            
        }
        else {
            int num = rand.nextInt(30) + 1;
            text = "You have found " + num + " gold coins on the ground!";
            player.addGold(num);
            
            codeList.add("7");
            textList.add("pick up coins and continue");
            
            data.add(data1);
            
            createOptions(codeList, textList, data);
        }
    }
    
    //method code 7
    public static void explore() {
    	Random rand = new Random();
        int chance = rand.nextInt(100);
        if(chance < 90){
            encounter();
        }
        else{
            loot();
        }
    }
    
    //method code 8
    public static void surrender(Enemy enemy) {
    	player.clearConsumables();
    	
    	codeList = new ArrayList<String>();
    	textList = new ArrayList<String>();
    	data = new ArrayList<ArrayList<Object>>();
    	
    	ArrayList<Object> data1 = new ArrayList<Object>();
    	
    	text = "<html>the " + enemy.getName() + " took all your consumables and ran off.<br/>You are lucky to still be alive";
    	
    	codeList.add("7");
        textList.add("continue");
        
        data.add(data1);
        
        createOptions(codeList, textList, data);
    }
    
    public static void decoder(String num, ArrayList<Object> data) {
    	if(Integer.valueOf(num) == 1) {
    		encounter();
    	}
    	else if(Integer.valueOf(num) == 2) {
    		trade((com.cerberus_crypt.main.Trader) data.get(0));
    	}
    	else if(Integer.valueOf(num) == 3) {
    		battle((com.cerberus_crypt.main.Enemy)data.get(0), (int)data.get(1), (int)data.get(2), (boolean)data.get(3));
    	}
    	else if(Integer.valueOf(num) == 4) {
    		die((String)data.get(0));
    	}
    	else if(Integer.valueOf(num) == 5) {
    		flee((com.cerberus_crypt.main.Enemy)data.get(0));
    	}
    	else if(Integer.valueOf(num) == 6) {
    		loot();
    	}
    	else if(Integer.valueOf(num) == 7) {
    		explore();
    	}
    	else if(Integer.valueOf(num) == 8) {
    		surrender((com.cerberus_crypt.main.Enemy)data.get(0));
    	}
    }
    
    public static void consume(int i) {
    	player.eat(i);
    	Frame.addInventory(i/6);
    }
    
}
