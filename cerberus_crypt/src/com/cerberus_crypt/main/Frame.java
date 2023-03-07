package com.cerberus_crypt.main;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.UIManager;

public class Frame{
	
	public static JFrame frame;
	
	public static int width;
	public static int height;
	public static int unit;
	
	public static JPanel mainPanel;
	public static JPanel homePanel;
	public static JPanel startPanel;
	public static JPanel HUD;
	public static JPanel HUD2;
	public static JPanel HUD3;
	public static JPanel savePanel;
	public static JPanel explorePanel;
	public static JPanel inventoryPanel;
	public static JPanel inventoryItemPanel;
	
	public static JLabel enterName;
	public static JLabel startlogo;
	public static JLabel homeScreenWizard;
	public static JLabel map;
	public static JLabel homeLogo;
	public static JLabel playerHealth;
	public static JLabel playerLocation;
	public static JLabel playerGold;
	public static JLabel playerHealth2;
	public static JLabel playerLocation2;
	public static JLabel playerGold2;
	public static JLabel playerHealth3;
	public static JLabel playerLocation3;
	public static JLabel playerGold3;
	public static JLabel exploreText;
	
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
	public static JButton saveExitButton;
	public static JButton exploreExitButton;
	public static JButton inventoryExitButton;
	public static JButton inventoryNextButton;
	public static JButton inventoryBackButton;
	
	public static JScrollPane optionPane;
	public static JScrollPane exploreTextPane;
	
	public static JTextField saveTextField;
	
	public static Save save;
	
	public static Font font;
	public static Font font2;
	
	public static Color burlyWood = new Color(188,123,25);
	public static Color lightBurlyWood = new Color(169,111,23);
	public static Color fireBrick = new Color(178,34,34);
	public static Color gold = new Color(212,175,55);
	public static Color lightGrey = Color.LIGHT_GRAY;
	public static Color darkGrey = new Color(20,20,20);
	public static Color white = Color.white;
	public static Color black = Color.BLACK;
	
	public static ArrayList<JPanel> inventoryPanels;
	
	public Frame(int width, int height){
		Frame.width = width;
		Frame.height = height;
		
		Frame.unit = width / 15;
		System.out.println(unit);
		
		font = createFont("res/A.ttf", (float)(unit/5));
		font2 = createFont("res/A.ttf", (float)(unit/3));
		
		save = new Save();
			
		frame = new JFrame("Cerberus Crypt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());
		frame.setResizable(false);
		frame.setSize(width, height);
		
		mainPanel = createPanel(mainPanel, null,Color.BLUE);
		homePanel = createPanel(homePanel, null, 0 ,0, width, height, burlyWood);
		HUD = createPanel(HUD, null, 0, 0, width, unit/2,fireBrick);
		HUD2 = createPanel(HUD, null, 0, 0, width, unit/2,fireBrick);
		HUD3 = createPanel(HUD, null, 0, 0, width, unit/2,fireBrick);
		startPanel = createPanel(startPanel, null, 0, 0, width, height, black);
		explorePanel = createPanel(explorePanel, null, 0, 0, width, height, burlyWood);
		
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
        mapcavesbutton = createButton(mapcavesbutton, 60, 80, 100, 40, "CAVES", false, darkGrey, white, font);
        mapforestbutton = createButton(mapforestbutton, 110, 230, 100, 40, "FOREST", false, darkGrey, white, font);
        mapdeepForestbutton = createButton(mapdeepForestbutton, 0, 290, 120, 40, "DEEP FOREST", false, darkGrey, white, font);
        mapswampbutton = createButton(mapswampbutton, 20, 20, 250, 76, "EXPLORE", false, darkGrey, white, font);
        mapmountainsbutton = createButton(mapmountainsbutton, 20, 20, 76, 40, "EXPLORE", false, darkGrey, white, font);
        maptundrabutton = createButton(maptundrabutton, 20, 20, 76, 40, "EXPLORE", false, darkGrey, white, font);
        mapdesertbutton = createButton(mapdesertbutton, unit*11, unit*9, unit*2, unit/2, "DESERT", false, darkGrey, white, font);
        mapexitbutton = createButton(mapexitbutton, (int) (unit*14), (int) (unit*10), unit, unit/2, "EXIT", true, darkGrey, white, font);
        
        playerHealth = createLabel(playerHealth, "HEALTH: " + Game.player.getHealth(), unit, 0, unit*2, unit/2, gold, font);
        playerLocation = createLabel(playerLocation, "LOCATION: " + Game.player.getLocation(), unit*6, 0, unit*3, unit/2, gold, font);
        playerGold = createLabel(playerGold, "GOLD: " + Game.player.getGold(), unit*13, 0, unit*2, unit/2, gold, font);
        playerHealth2 = createLabel(playerHealth, "HEALTH: " + Game.player.getHealth(), unit, 0, unit*2, unit/2, gold, font);
        playerLocation2 = createLabel(playerLocation, "LOCATION: " + Game.player.getLocation(), unit*6, 0, unit*3, unit/2, gold, font);
        playerGold2 = createLabel(playerGold, "GOLD: " + Game.player.getGold(), unit*13, 0, unit*2, unit/2, gold, font);
        playerHealth3 = createLabel(playerHealth, "HEALTH: " + Game.player.getHealth(), unit, 0, unit*2, unit/2, gold, font);
        playerLocation3 = createLabel(playerLocation, "LOCATION: " + Game.player.getLocation(), unit*6, 0, unit*3, unit/2, gold, font);
        playerGold3 = createLabel(playerGold, "GOLD: " + Game.player.getGold(), unit*13, 0, unit*2, unit/2, gold, font);
        
        optionPane = createScrollPane(optionPane, null, unit, unit*4, unit*13, unit*6, lightBurlyWood, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        exploreTextPane = createScrollPane(exploreTextPane, null, unit, unit, unit*13, unit*2, lightBurlyWood, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        exploreExitButton = createButton(exploreExitButton, (unit*14+unit/10), (unit*10+unit/10), (unit-unit/10), (unit/2-unit/10), "EXIT", true, fireBrick, gold, font);
        
        exploreText = createLabel(exploreText, "", 0, 0, unit*13, unit*2, black, font2);
        
        inventoryPanel = createPanel(inventoryPanel, null, 0, 0, width, height, burlyWood);
        
        inventoryItemPanel = createPanel(inventoryItemPanel, null, unit/2, unit*3, unit * 14, (int) (unit * 6.5), Color.blue);
        inventoryExitButton = createButton(inventoryExitButton, (unit*14+unit/10), (unit*10+unit/10), (unit-unit/10), (unit/2-unit/10), "EXIT", true, fireBrick, gold, font);
        
        inventoryNextButton = createButton(inventoryNextButton, (int)(unit * 7.5), (int)(unit*10.5), unit, unit/2, "NEXT", true, lightBurlyWood, black, font);
        inventoryBackButton = createButton(inventoryBackButton, (int)(unit * 6.5), (int)(unit*10.5), unit, unit/2, "BACK", true, lightBurlyWood, black, font);
        
        inventoryPanel.add(inventoryBackButton);
        inventoryPanel.add(inventoryExitButton);
        inventoryPanel.add(inventoryExitButton);
        inventoryPanel.add(inventoryItemPanel);
        
        HUD.add(playerHealth);
        HUD.add(playerLocation);
        HUD.add(playerGold);
        HUD2.add(playerHealth2);
        HUD2.add(playerLocation2);
        HUD2.add(playerGold2);
        HUD3.add(playerHealth3);
        HUD3.add(playerLocation3);
        HUD3.add(playerGold3);
        
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
        explorePanel.add(HUD2);
        explorePanel.add(exploreExitButton);
        
        map.add(mapgrasslandsbutton);
        map.add(mapcavesbutton);
        map.add(mapforestbutton);
        map.add(mapdeepForestbutton);
        map.add(mapdesertbutton);
        map.add(mapexitbutton);
        
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
	
	public static void startGame() {
		mainPanel.add(startPanel);
		
	}
	
	public static void saveMenu() {
		mainPanel.add(savePanel);
	}
	
	
	public static void startMenu() {
		mainPanel.add(homePanel);
	}
	
	public static void inventory() {
		addInventory(0);
		inventoryPanel.repaint();
		mainPanel.add(inventoryPanel);
	}
	
	public static void map() {
		mainPanel.add(map);
	}
	
	public static void explore() {
		Game.explore();
		mainPanel.add(explorePanel);
	}
	
	public static JPanel createPanel(JPanel panel, LayoutManager layout, Color backgroundColor) {
		panel = new JPanel();
		panel.setLayout(layout);
		panel.setBackground(backgroundColor);
		return panel;
	}
	
	public static JPanel createPanel(JPanel panel, LayoutManager layout, int x, int y, int width, int height, Color backgroundColor) {
		panel = new JPanel(layout);
		panel.setBounds(x, y, width, height);
		panel.setBackground(backgroundColor);
		return panel;
	}
	
	//method for creating a basic button
	public static JButton createButton(JButton button, int x, int y, int width, int height, String text, boolean clear, Color backgroundColor, Color textColor, Font font) {
		button = new JButton(text);
		button.setFont(font);
		button.addActionListener(new keyInput());
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
	
	public static ArrayList<JPanel> createInventory(){
		ArrayList<Consumable> consumableList = Game.player.getConsumables();
		
		ArrayList<JPanel> returnList = new ArrayList<JPanel>();
		
		int verticalBorder = unit / 4;
		int horizontalBorder = (unit / 2) / 12;
		
		System.out.println(consumableList.size());
		
		int n;
		
		if(consumableList.size() == 0) {
			JPanel panel = createPanel(new JPanel(), null, 0, 0, unit * 14, (int) (unit * 6.5), lightBurlyWood);
			returnList.add(panel);
		}
		
		for(int i = 0; i < consumableList.size(); i++) {
			
			JPanel panel = createPanel(new JPanel(), null, 0, 0, unit * 14, (int) (unit * 6.5), lightBurlyWood);
			
			for(n = 0; (i + n) < consumableList.size() && n < 6; n++) {
				int index = i+n;
				JPanel itemPanel = createPanel(new JPanel(), null, verticalBorder, horizontalBorder + (2 * horizontalBorder * n) + (unit * n), (int) (unit * 14 - (verticalBorder*2)), (unit), burlyWood);
				JLabel label = createLabel(new JLabel(), consumableList.get(index).getName() + "  HEALING: " + consumableList.get(index).getHealing(), verticalBorder, 0, unit*8, unit, black, font);
				
				JButton button = createButton(new JButton(), unit*8, horizontalBorder, unit, unit-(horizontalBorder*2), "EAT", true, fireBrick, gold, font);
				button.addActionListener(e -> Game.consume(index));
				
				itemPanel.add(label);
				itemPanel.add(button);
				
				panel.add(itemPanel);
			}
			i+=n;
			
			returnList.add(panel);
		}
		return returnList;
	}
	
	public static void addInventory(int position) {
		inventoryPanels = createInventory();
		inventoryItemPanel.removeAll();
		inventoryItemPanel.repaint();
		inventoryItemPanel.add(inventoryPanels.get(position));
	}
	
	public static JScrollPane createScrollPane(JScrollPane ScrollPane, LayoutManager layout, int x, int y, int width, int height, Color backgroundColor, int policy) {
		ScrollPane = new JScrollPane();
		ScrollPane.setBounds(x,y,width,height);
		ScrollPane.setLayout(layout);
		ScrollPane.setBackground(backgroundColor);
		ScrollPane.setVerticalScrollBarPolicy(policy);
		return ScrollPane;
	}

	public static JLabel createImage(JLabel label, String file, int x, int y, int width, int height) {
		Image image = addImage(width, height, file);
		label = new JLabel(new ImageIcon(image));
		label.setBounds(x, y, width, height);
		return label;
	}
	
	public static void clearScreen() {
		updateHUD();
		mainPanel.removeAll();
		mainPanel.repaint();
	}
	
	public static Font createFont(String file, float size) {
		Font customFont = null;
		
		//create the font to use. Specify the size!
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
	
	public static Image addImage(int width, int height, String file) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public static void updateHUD() {
		playerHealth.setText("HEALTH: " + Game.player.getHealth());
		playerLocation.setText("LOCATION: " + Game.player.getLocation());
		playerGold.setText("GOLD: " + Game.player.getGold());
		playerHealth2.setText("HEALTH: " + Game.player.getHealth());
		playerLocation2.setText("LOCATION: " + Game.player.getLocation());
		playerGold2.setText("GOLD: " + Game.player.getGold());
		playerHealth3.setText("HEALTH: " + Game.player.getHealth());
		playerLocation3.setText("LOCATION: " + Game.player.getLocation());
		playerGold3.setText("GOLD: " + Game.player.getGold());
	}
}
