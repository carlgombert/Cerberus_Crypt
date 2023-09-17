package com.cerberus_crypt.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


/*
 
 The frame class handles all the visual aspects of the program.
 
 
 */
public class Frame{
	
	//creating all the visual objects
	
	public static JFrame frame;
	
	public static int width;
	public static int height;
	public static int unit;
	public static int inventoryPosition;
	public static int tradePosition;
	
	public static JPanel mainPanel;
	public static JPanel homePanel;
	public static JPanel startPanel;
	public static JPanel HUD;
	public static JPanel savePanel;
	public static JPanel explorePanel;
	public static JPanel inventoryPanel;
	public static JPanel inventoryItemPanel;
	public static JPanel tradeItemPanel;
	public static JPanel tradePanel;
	public static JPanel traderImageFrame;
	public static JPanel weaponImageFrame;
	
	public static JLabel enterName;
	public static JLabel startlogo;
	public static JLabel homeScreenWizard;
	public static JLabel map;
	public static JLabel homeLogo;
	public static JLabel playerHealth;
	public static JLabel playerLocation;
	public static JLabel playerGold;
	public static JLabel exploreText;
	public static JLabel inventoryWeaponInfo;
	public static JLabel traderImage;
	public static JLabel traderText;
	public static JLabel saveNameText;
	public static JLabel loadNameText;
	
	public static JButton startButton;
	public static JButton explorebutton;
	public static JButton inventorybutton;
	public static JButton savebutton;
	public static JButton mapbutton;
	public static JButton mapgrasslandsbutton;
	public static JButton mapcavesbutton;
	public static JButton mapforestbutton;
	public static JButton mapdeepForestbutton;
	public static JButton mapswampbutton;
	public static JButton mapmountainsbutton;
	public static JButton maptundrabutton;
	public static JButton mapdesertbutton;
	public static JButton mapexitbutton;
	public static JButton saveEnterButton;
	public static JButton loadEnterButton;
	public static JButton saveExitButton;
	public static JButton exploreExitButton;
	public static JButton inventoryExitButton;
	public static JButton inventoryNextButton;
	public static JButton inventoryBackButton;
	public static JButton tradeExitButton;
	public static JButton tradeBackButton;
	public static JButton tradeNextButton;
	public static JButton battleInventoryExitButton;
	public static JButton exploreInventoryButton;
	
	public static JScrollPane optionPane;
	public static JScrollPane exploreTextPane;
	
	public static JTextField saveTextField;
	public static JTextField loadTextField;
	
	public static Font font;
	public static Font font2;
	
	public static Color burlyWood = new Color(188,123,25);
	public static Color lightBurlyWood = new Color(169,111,23); // darker than burly wood
	public static Color fireBrick = new Color(178,34,34);
	public static Color gold = new Color(212,175,55);
	public static Color lightGrey = Color.LIGHT_GRAY;
	public static Color darkGrey = new Color(20,20,20);
	public static Color white = Color.white;
	public static Color black = Color.BLACK;
	
	public static ArrayList<JPanel> inventoryPanels;
	public static ArrayList<JPanel> tradePanels;
	
	public Frame(int width, int height){
		
		Frame.width = width;
		Frame.height = height;
		
		/*
		
		Units are used to determine the size of objects on the screen instead of pixels 
		to allow the game to scale. One unit is one 15th of the width or one 11th of the height.
		
		*/
		Frame.unit = width / 15;
		
		font = createFont("res/A.ttf", (float)(unit/5));
		font2 = createFont("res/A.ttf", (float)(unit/3.5));
			
		frame = new JFrame("Cerberus Crypt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());
		frame.setResizable(false);
		frame.setSize(width, height);
		
		//below I add details and set preferences for all the visual objects
		
		
		mainPanel = createPanel(mainPanel, null,Color.BLUE);
		homePanel = createPanel(homePanel, null, 0 ,0, width, height, burlyWood);
		HUD = createPanel(HUD, null, 0, 0, width, unit/2,fireBrick);
		startPanel = createPanel(startPanel, null, 0, 0, width, height, black);
		explorePanel = createPanel(explorePanel, null, 0, 0, width, height, burlyWood);
		savePanel =  createPanel(savePanel, null, 0, 0, width, height, burlyWood);
		
		map = createImage(map,"res/map.png", 0, 0, width, height);
        map.setLayout(null);
		
		startlogo = createImage(startlogo,"res/logo.png", unit*5, unit*2, unit*5, unit*5);
        homeLogo = createImage(homeLogo,"res/homePageLogo.png", unit*6, 0, unit*8, unit*7);
        homeScreenWizard = createImage(homeScreenWizard, "res/homeScreenWizard.png", unit*7, unit*3, unit*8, unit*8);
        
        startButton = createButton(startButton, unit*6, unit*8, unit*3, unit, "START", true, darkGrey, lightGrey, font);
        
        explorebutton = createButton(explorebutton, unit/2, unit, (int) (unit*4.5), unit, "EXPLORE", true, fireBrick, gold, font);
        inventorybutton = createButton(inventorybutton, unit/2, unit*3, (int) (unit*4.5), unit, "INVENTORY", true, fireBrick, gold, font);
        mapbutton = createButton(mapbutton, unit/2, unit*5, (int) (unit*4.5), unit, "MAP", true, fireBrick, gold, font);
        savebutton = createButton(savebutton, unit/2, unit*7, (int) (unit*4.5), unit, "SAVE", true, fireBrick, gold, font);
        
        mapgrasslandsbutton = createButton(mapgrasslandsbutton, unit*9, unit*7, unit*2, unit/2, "GRASSLANDS", false, darkGrey, white, font);
        mapcavesbutton = createButton(mapcavesbutton, unit*2, unit*2, unit*2, unit/2, "CAVES", false, darkGrey, white, font);
        mapforestbutton = createButton(mapforestbutton, unit * 2, unit*6, unit*2, unit/2, "FOREST", false, darkGrey, white, font);
        mapdeepForestbutton = createButton(mapdeepForestbutton, 0, unit*8, unit*2, unit/2, "DEEP FOREST", false, darkGrey, white, font);
        mapswampbutton = createButton(mapswampbutton, unit*2, (int) (unit*9.5), unit*2, unit/2, "SWAMP", false, darkGrey, white, font);
        mapmountainsbutton = createButton(mapmountainsbutton, 0, 0, unit*2, unit/2, "MOUNTAINS", false, darkGrey, black, font);
        maptundrabutton = createButton(maptundrabutton, unit*13, unit, unit*2, unit/2, "TUNDRA", false, darkGrey, white, font);
        mapdesertbutton = createButton(mapdesertbutton, unit*11, unit*9, unit*2, unit/2, "DESERT", false, darkGrey, black, font);
        mapexitbutton = createButton(mapexitbutton, (int) (unit*14), (int) (unit*10), unit, unit/2, "EXIT", true, darkGrey, white, font);
        
        playerHealth = createLabel(playerHealth, "HEALTH: " + Game.player.getHealth(), unit, 0, unit*2, unit/2, gold, font);
        playerLocation = createLabel(playerLocation, "LOCATION: " + Game.player.getLocation(), unit*6, 0, unit*3, unit/2, gold, font);
        playerGold = createLabel(playerGold, "GOLD: " + Game.player.getGold(), unit*13, 0, unit*2, unit/2, gold, font);
        
        optionPane = createScrollPane(optionPane, null, unit, unit*4, unit*13, unit*6, lightBurlyWood, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        exploreTextPane = createScrollPane(exploreTextPane, null, unit, unit, unit*13, unit*2, lightBurlyWood, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        exploreExitButton = createButton(exploreExitButton, (unit*14+unit/10), (unit*10+unit/10), (unit-unit/10), (unit/2-unit/10), "EXIT", true, fireBrick, gold, font);
        
        exploreText = createLabel(exploreText, "", 0, 0, unit*13, unit*2, black, font2);
        
        exploreInventoryButton = createButton(exploreInventoryButton, (int)(unit * 6.5), (int)(unit * 3.25), unit * 2, unit / 2, "INVENTORY", true, fireBrick, gold, font);
        
        inventoryPanel = createPanel(inventoryPanel, null, 0, 0, width, height, burlyWood);
        inventoryItemPanel = createPanel(inventoryItemPanel, null, unit/2, unit*3, unit * 14, (int) (unit * 6.5), Color.blue);
        
        inventoryExitButton = createButton(inventoryExitButton, (unit*14+unit/10), (unit*10+unit/10), (unit-unit/10), (unit/2-unit/10), "EXIT", true, fireBrick, gold, font);
        inventoryNextButton = createButton(inventoryNextButton, (int)(unit * 7.5), (int)(unit*9.75), unit, unit/2, "NEXT", true, lightBurlyWood, black, font);
        inventoryBackButton = createButton(inventoryBackButton, (int)(unit * 6.5), (int)(unit*9.75), unit, unit/2, "BACK", true, lightBurlyWood, black, font);
        battleInventoryExitButton = createButton(battleInventoryExitButton, (unit*14+unit/10), (unit*10+unit/10), (unit-unit/10), (unit/2-unit/10), "EXIT", true, fireBrick, gold, font);
        
        inventoryWeaponInfo = createLabel(inventoryWeaponInfo, "<html>WEAPON:<br/>" + Game.player.getWeapon().getName() + "</html>", (int) (unit*3.5), (int)(unit*0.75), unit*4, unit*2, gold, font2);
        weaponImageFrame = createPanel(weaponImageFrame, null, unit - unit/10, (int)(unit*0.75 - unit/10), unit*2+unit/5, unit*2+unit/5, lightBurlyWood);
        
        tradePanel = createPanel(tradePanel, null, 0, 0, width, height, burlyWood);
        tradeItemPanel = createPanel(tradeItemPanel, null, unit/2, unit*3, unit * 14, (int) (unit * 6.5), Color.blue);
        tradeExitButton = createButton(tradeExitButton, (unit*14+unit/10), (unit*10+unit/10), (unit-unit/10), (unit/2-unit/10), "EXIT", true, fireBrick, gold, font);
        
        tradeNextButton = createButton(tradeNextButton, (int)(unit * 7.5), (int)(unit*9.75), unit, unit/2, "NEXT", true, lightBurlyWood, black, font);
        tradeBackButton = createButton(tradeBackButton, (int)(unit * 6.5), (int)(unit*9.75), unit, unit/2, "BACK", true, lightBurlyWood, black, font);
        
        traderImageFrame = createPanel(traderImageFrame, null, unit - unit/10, (int)(unit*0.75 - unit/10), unit*2+unit/5, unit*2+unit/5, lightBurlyWood);
        traderText = createLabel(traderText, "", (int) (unit*3.5), (int) (unit*0.75), unit*10, unit*2, black, font);
        
        saveNameText = createLabel(saveNameText, "name", (int) (unit*6), (int) (unit*2.5), unit*3, unit/2, black, font);
        saveTextField = createTextField(saveTextField, (int) (unit*6), (int) (unit*3), unit*3, unit/2);
        saveTextField.setBackground(lightBurlyWood);
        saveExitButton = createButton(saveExitButton, (int) (unit*14), (int) (unit*10), unit, unit/2, "EXIT", true, fireBrick, gold, font);
        saveEnterButton = createButton(saveEnterButton, (int) (unit*6.5), (int) (unit*3.5), unit*2, unit/2, "SAVE", true, fireBrick, gold, font);
        loadNameText = createLabel(loadNameText, "name", (int) (unit*6), (int) (unit*5), unit*3, unit/2, black, font);
        loadTextField = createTextField(loadTextField, (int) (unit*6), (int) (unit*5.5), unit*3, unit/2);
        loadTextField.setBackground(lightBurlyWood);
        loadEnterButton = createButton(loadEnterButton, (int) (unit*6.5), (int) (unit*6), unit*2, unit/2, "LOAD", true, fireBrick, gold, font);
        
        // Below I add all the visual objects to their respective pages
        
        
        inventoryPanel.add(inventoryBackButton);
        inventoryPanel.add(inventoryNextButton);
        inventoryPanel.add(inventoryExitButton);
        inventoryPanel.add(inventoryItemPanel);
        inventoryPanel.add(inventoryWeaponInfo);
        inventoryPanel.add(weaponImageFrame);
        inventoryPanel.add(battleInventoryExitButton);
        
        tradePanel.add(tradeBackButton);
        tradePanel.add(tradeNextButton);
        tradePanel.add(tradeExitButton);
        tradePanel.add(tradeItemPanel);
        tradePanel.add(traderText);
        tradePanel.add(traderImageFrame);
        
        HUD.add(playerHealth);
        HUD.add(playerLocation);
        HUD.add(playerGold);
        
        startPanel.add(startlogo);
        startPanel.add(startButton);
        
        homePanel.add(explorebutton);
        homePanel.add(inventorybutton);
        homePanel.add(mapbutton);
        homePanel.add(savebutton);
        homePanel.add(homeScreenWizard);
        homePanel.add(homeLogo);
        homePanel.add(HUD);
        
        exploreTextPane.add(exploreText);
        
        explorePanel.add(optionPane);
        explorePanel.add(exploreTextPane);
        explorePanel.add(exploreExitButton);
        explorePanel.add(exploreInventoryButton);
        
        map.add(mapgrasslandsbutton);
        map.add(mapcavesbutton);
        map.add(mapforestbutton);
        map.add(mapdeepForestbutton);
        map.add(mapdesertbutton);
        map.add(mapmountainsbutton);
        map.add(mapswampbutton);
        map.add(maptundrabutton);
        map.add(mapexitbutton);
        
        savePanel.add(saveExitButton);
        savePanel.add(saveTextField);
        savePanel.add(saveNameText);
        savePanel.add(saveEnterButton);
        savePanel.add(loadTextField);
        savePanel.add(loadNameText);
        savePanel.add(loadEnterButton);
        
        startGame();
        
        frame.add(mainPanel);
        
        //switching the GUI to the standard style instead of the apple style
  		try {
  			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
  		} catch(Exception e){
  			  e.printStackTrace(); 
  		}
        
        frame.setVisible(true);
	}
	
	//Displays the game start page
	public static void startGame() {
		mainPanel.add(startPanel);
	}
	
	//Displays the save page
	public static void saveMenu() {
		mainPanel.add(savePanel);
	}
	
	//Displays the home menu page
	public static void startMenu() {
		homePanel.add(HUD);
		mainPanel.add(homePanel);
	}
	
	//Displays the inventory page
	public static void inventory() {
		addInventory(0);
		inventoryExitButton.setVisible(true);
		battleInventoryExitButton.setVisible(true);
		inventoryPanel.repaint();
		mainPanel.add(inventoryPanel);
	}
	
	//Displays the map page
	public static void map() {
		mainPanel.add(map);
	}
	
	//Displays the explore page
	public static void explore() {
		Game.explore();
		explorePanel.add(HUD);
		mainPanel.add(explorePanel);
	}
	
	//this method creates an inventory interface for the player's consumables and weapons. 
	//the inventory menu works by taking all the weapons and consumables stored in the player
	//and creates a panel for each one. on the panel I put the name and some info as well as a
	//button that calls a function to either equip a weapon or eat a consumable
	public static ArrayList<JPanel> createInventory(){
		ArrayList<Consumable> consumableList = Game.player.getConsumables();
		ArrayList<Weapon> weaponList = Game.player.getWeapons();
		
		ArrayList<JPanel> returnList = new ArrayList<JPanel>();
		
		int verticalBorder = unit / 4;
		int horizontalBorder = (unit / 2) / 12;
		
		int n;
		
		if(consumableList.size() == 0) {
			JPanel panel = createPanel(new JPanel(), null, 0, 0, unit * 14, (int) (unit * 6.5), lightBurlyWood);
			returnList.add(panel);
		}
		
		for(int i = 0; i < consumableList.size(); i++) {
			
			JPanel panel = createPanel(new JPanel(), null, 0, 0, unit * 14, (int) (unit * 6.5), lightBurlyWood);
			
			for(n = 0; (i + n) < consumableList.size() && n < 6; n++) {
				int index = i+n;
				JPanel itemPanel = createPanel(new JPanel(), null, verticalBorder, horizontalBorder + (2 * horizontalBorder * n) + (unit * n), (int) (unit * 7 - (verticalBorder*2)), (unit), burlyWood);
				JLabel label = createLabel(new JLabel(), consumableList.get(index).getName() + "  HEALING: " + consumableList.get(index).getHealing(), verticalBorder, 0, unit*5, unit, black, font);
				
				JButton button = createButton(new JButton(), unit*5, horizontalBorder, unit, unit-(horizontalBorder*2), "EAT", true, fireBrick, gold, font);
				button.addActionListener(e -> Game.consume(index));
				
				itemPanel.add(label);
				itemPanel.add(button);
				
				panel.add(itemPanel);
			}
			i+=n - 1;
			
			returnList.add(panel);
		}
		for(int i = 0; i < weaponList.size(); i++) {
			JPanel panel;
			int temp = i;
			if((i+6)/6 > returnList.size()) {
				panel = createPanel(new JPanel(), null, 0, 0, unit * 14, (int) (unit * 6.5), lightBurlyWood);
			}
			else {
				panel = returnList.get((i+6)/6 - 1);
			}
			for(n = 0; (i + n) < weaponList.size() && n < 6; n++) {
				int index = i+n;
				JPanel itemPanel = createPanel(new JPanel(), null, unit*7 + verticalBorder, horizontalBorder + (2 * horizontalBorder * n) + (unit * n), (int) (unit * 7 - (verticalBorder*2)), (unit), burlyWood);
				JLabel label = createLabel(new JLabel(), weaponList.get(index).getName() + "  DAMAGE: " + weaponList.get(index).getDamage(), verticalBorder, 0, unit*4, unit, black, font);
				if(weaponList.get(index).equals(Game.player.getWeapon()) == false) {
					JButton button = createButton(new JButton(), unit*5, horizontalBorder, unit, unit-(horizontalBorder*2), "EQUIP", true, fireBrick, gold, font);
					button.addActionListener(e -> Game.player.equipWeapon(weaponList.get(index)));
					itemPanel.add(button);
				}
				
				itemPanel.add(label);
				
				panel.add(itemPanel);
			}
			i+=n - 1;
			if((temp+6)/6 > returnList.size()) {
				returnList.add(panel);
			}
			else {
				returnList.set((temp+6)/6 - 1, panel);
			}
		}
		return returnList;
	}
	
	//creates the trade menu
	public static ArrayList<JPanel> createTradeMenu(Trader trader){
		
		ArrayList<Consumable> consumableList = trader.getConsumables();
		ArrayList<Weapon> weaponList = trader.getWeapons();
		
		//list of trade slides to be returned
		ArrayList<JPanel> returnList = new ArrayList<JPanel>();
		
		//set up borders and spacing for item panels
		int verticalBorder = unit / 4;
		int horizontalBorder = (unit / 2) / 12;
		
		int n;
		
		//if there arent any consumables, create trade slide for weapons to use
		if(consumableList.size() == 0) {
			JPanel panel = createPanel(new JPanel(), null, 0, 0, unit * 14, (int) (unit * 6.5), lightBurlyWood);
			returnList.add(panel);
		}
		
		//adding consumables with buttons to an trade slide and creating a new trade slide 
		//everytime the current trade slide fills up (each trade slide fills up once it has 6
		//items)
		for(int i = 0; i < consumableList.size(); i++) {
			
			//creates an inventory page for items
			JPanel panel = createPanel(new JPanel(), null, 0, 0, unit * 14, (int) (unit * 6.5), lightBurlyWood);
			
			//for n in range of the size of one page, create an item panel and add it to the 
			//trade slide
			for(n = 0; (i + n) < consumableList.size() && n < 6; n++) {
				int index = i+n;
				JPanel itemPanel = createPanel(new JPanel(), null, verticalBorder, horizontalBorder + (2 * horizontalBorder * n) + (unit * n), (int) (unit * 7 - (verticalBorder*2)), (unit), burlyWood);
				JLabel label = createLabel(new JLabel(), consumableList.get(index).getName() + "  HEALING: " + consumableList.get(index).getHealing() + " COST: " + consumableList.get(index).getCost(), verticalBorder, 0, unit*5, unit, black, font);
				
				JButton button = createButton(new JButton(), unit*5, horizontalBorder, unit, unit-(horizontalBorder*2), "BUY", true, fireBrick, gold, font);
				button.addActionListener(e -> Game.buy(consumableList.get(index)));
				
				itemPanel.add(label);
				itemPanel.add(button);
				
				panel.add(itemPanel);
			}
			i+=n - 1;
			
			returnList.add(panel);
		}
		//adds weapons to each of the trade slides. if there are more weapons than consumables
		//it will create a new trade slide to add the weapons onto
		for(int i = 0; i < weaponList.size(); i++) {
			JPanel panel;
			int temp = i;
			
			//if the number of weapons doesn't fit in the amount of slides that currently exist
			if((i+6)/6 > returnList.size()) {
				//create a new trade slide
				panel = createPanel(new JPanel(), null, 0, 0, unit * 14, (int) (unit * 6.5), lightBurlyWood);
			}
			else {
				//else get the trade slide for the current position
				panel = returnList.get((i+6)/6 - 1);
			}
			for(n = 0; (i + n) < weaponList.size() && n < 6; n++) {
				int index = i+n;
				JPanel itemPanel = createPanel(new JPanel(), null, unit*7 + verticalBorder, horizontalBorder + (2 * horizontalBorder * n) + (unit * n), (int) (unit * 7 - (verticalBorder*2)), (unit), burlyWood);
				JLabel label = createLabel(new JLabel(), weaponList.get(index).getName() + "  DAMAGE: " + weaponList.get(index).getDamage() + " COST: " + weaponList.get(index).getCost(), verticalBorder, 0, unit*5, unit, black, font);
				//if the player doesn't own the weapon make it available for purchase
				if(Game.player.getWeapons().contains(weaponList.get(index)) == false) {
					JButton button = createButton(new JButton(), unit*5, horizontalBorder, unit, unit-(horizontalBorder*2), "BUY", true, fireBrick, gold, font);
					button.addActionListener(e -> Game.buy(weaponList.get(index)));
					itemPanel.add(button);
				}
				
				itemPanel.add(label);
				
				panel.add(itemPanel);
			}
			i+=n - 1;
			
			//if a new trade slide was created, add it to the return list
			if((temp+6)/6 > returnList.size()) {
				returnList.add(panel);
			}
			else {
				//else set the trade slide in the current position to the trade slide 
				//with weapons added
				returnList.set((temp+6)/6 - 1, panel);
			}
		}
		return returnList;
	}
	
	//adds the trade menu at a specific slide
	//(if the trade is 3-4 slides long, it can be added in at the 2nd or 3rd slide)
	public static void addTrade(int position, Trader trader) {
		
		addTraderIcon(trader.getFile());
		
		updateHUD();
		tradePanel.add(HUD);
		//setting the traders dialogue to a random dialogue line
		traderText.setText(Game.getDialogue());
		//sets the global trade position to the new position
		tradePosition = position;
		//creates all the items in the trade and adds them to an arraylist of different
		//trade slides
		tradePanels = createTradeMenu(trader);
		tradeItemPanel.removeAll();
		tradeItemPanel.repaint();
		//checking if the current trade page is the last page. If so remove the next panel
		//button
		if(position == tradePanels.size() - 1) {
			tradeNextButton.setVisible(false);
		}
		else{
			tradeNextButton.setVisible(true);
		}
		//checking if the current trade page is the first page. If so remove the back button
		if(position == 0) {
			tradeBackButton.setVisible(false);
		}
		else{
			tradeBackButton.setVisible(true);
		}
		//adding in the current trade panel
		tradeItemPanel.add(tradePanels.get(position));
	}
	
	//adds the inventory at a specific slide
	//(if the inventory is 3-4 slides long, it can be added in at the 2nd or 3rd slide)
	public static void addInventory(int position) {
		
		addWeaponIcon(Game.player.getWeapon().getFile());
		
		inventoryWeaponInfo.setText("<html>WEAPON:<br/>" + Game.player.getWeapon().getName() + "</html>");
		
		updateHUD();
		inventoryPanel.add(HUD);
		//sets the global inventory position to the new position
		inventoryPosition = position;
		//creates all the items in the inventory and adds them to an arraylist of different
		//inventory slides
		inventoryPanels = createInventory();
		inventoryItemPanel.removeAll();
		inventoryItemPanel.repaint();
		//checking if the current inventory page is the last page. If so remove the next panel
		//button
		if(position == inventoryPanels.size() - 1) {
			inventoryNextButton.setVisible(false);
		}
		else{
			inventoryNextButton.setVisible(true);
		}
		//checking if the current inventory page is the first page. If so remove the back button
		if(position == 0) {
			inventoryBackButton.setVisible(false);
		}
		else{
			inventoryBackButton.setVisible(true);
		}
		//adding in the current inventory panel
		inventoryItemPanel.add(inventoryPanels.get(position));
	}
	
	
	
	//takes image file and creates the traders picture based on which trader the player is
	//trading with
	public static void addTraderIcon(String file) {
		traderImageFrame.removeAll();
		traderImageFrame.repaint();
		traderImageFrame.add(createImage(new JLabel(), file, unit/10, unit/10, unit*2, unit*2));
	}
	
	//takes image file and creates an icon for the currently equiped weapon
	public static void addWeaponIcon(String file) {
		weaponImageFrame.removeAll();
		weaponImageFrame.repaint();
		weaponImageFrame.add(createImage(new JLabel(), file, unit/10, unit/10, unit*2, unit*2));
	}
	
	//method for creating panel with unspecified position and size. used for full screen panels
	public static JPanel createPanel(JPanel panel, LayoutManager layout, Color backgroundColor) {
		panel = new JPanel();
		panel.setLayout(layout);
		panel.setBackground(backgroundColor);
		return panel;
	}
	
	//method for creating a panel with specified position and size. mostly used for panels
	//on top of the full screen panel
	public static JPanel createPanel(JPanel panel, LayoutManager layout, int x, int y, int width, int height, Color backgroundColor) {
		panel = new JPanel(layout);
		panel.setBounds(x, y, width, height);
		panel.setBackground(backgroundColor);
		return panel;
	}
	
	//method for creating a button
	public static JButton createButton(JButton button, int x, int y, int width, int height, String text, boolean clear, Color backgroundColor, Color textColor, Font font) {
		button = new JButton(text);
		button.setFont(font);
		button.addActionListener(new KeyInput());
		button.setBounds(x, y, width, height);
		button.setBackground(backgroundColor);
		button.setForeground(textColor);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setOpaque(clear);
		return button;
	}
	
	//method for creating a basic text field
	public static JTextField createTextField(JTextField textField, int x, int y, int width, int height) {
		textField = new JTextField();
		textField.setBounds(x, y, width, height);
		return textField;
	}
	
	//method for creating a basic label
	public static JLabel createLabel(JLabel label, String text, int x, int y, int width, int height, Color color, Font font) {
		label = new JLabel(text);
		label.setBounds(x, y, width, height);
		label.setForeground(color);
		label.setFont(font);
		return label;
	}
	
	//uses the addimage method to turn the image into a label which I can use in my program
	public static JLabel createImage(JLabel label, String file, int x, int y, int width, int height) {
		Image image = addImage(width, height, file);
		label = new JLabel(new ImageIcon(image));
		label.setBounds(x, y, width, height);
		return label;
	}
	
	//creates JScrollPane
	public static JScrollPane createScrollPane(JScrollPane ScrollPane, LayoutManager layout, int x, int y, int width, int height, Color backgroundColor, int policy) {
		ScrollPane = new JScrollPane();
		ScrollPane.setBounds(x,y,width,height);
		ScrollPane.setLayout(layout);
		ScrollPane.setBackground(backgroundColor);
		ScrollPane.setVerticalScrollBarPolicy(policy);
		return ScrollPane;
	}
	
	//method for taking a ttf file and creating a font
	public static Font createFont(String file, float size) {
		Font customFont = null;
		
		//creating the font
		try {
		    customFont = Font.createFont(Font.TRUETYPE_FONT, new File(file)).deriveFont(size);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		return customFont;
	}
	
	//takes a png or jpeg file and returns an image. not used directly 
	//but utilized by the createImage method
	public static Image addImage(int width, int height, String file) {
		BufferedImage image = null;
		try {
			//reading in the file
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	//updates the head of display
	public static void updateHUD() {
		playerHealth.setText("HEALTH: " + Game.player.getHealth());
		playerLocation.setText("LOCATION: " + Game.player.getLocation());
		playerGold.setText("GOLD: " + Game.player.getGold());
	}
	
	//clears the main panel
	public static void clearScreen() {
		updateHUD();
		mainPanel.removeAll();
		mainPanel.repaint();
	}
	
}
