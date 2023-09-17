package com.cerberus_crypt.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class KeyInput implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Frame.startButton) {
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.explorebutton) {
			Frame.clearScreen();
			Frame.explore();
		}
		if(e.getSource()==Frame.mapbutton) {
			Frame.clearScreen();
			Frame.map();
		}
		if(e.getSource()==Frame.mapexitbutton) {
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.mapgrasslandsbutton) {
			Game.player.setLocation(Game.grasslands);
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.mapcavesbutton) {
			Game.player.setLocation(Game.caves);
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.mapforestbutton) {
			Game.player.setLocation(Game.forest);
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.mapdeepForestbutton) {
			Game.player.setLocation(Game.deepForest);
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.mapdesertbutton) {
			Game.player.setLocation(Game.desert);
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.maptundrabutton) {
			Game.player.setLocation(Game.tundra);
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.mapswampbutton) {
			Game.player.setLocation(Game.swamp);
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.mapmountainsbutton) {
			Game.player.setLocation(Game.mountains);
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.savebutton) {
			Frame.clearScreen();
			Frame.saveMenu();
		}
		if(e.getSource()==Frame.saveEnterButton) {
			if(!Frame.saveTextField.getText().equals("")) {
				try {
					Save.SaveGame(Frame.saveTextField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			Frame.saveTextField.setText("");
		}
		if(e.getSource()==Frame.loadEnterButton) {
			if(!Frame.loadTextField.getText().equals("")) {
				try {
					Game.player = Save.LoadGame(Frame.loadTextField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			Frame.loadTextField.setText("");
		}
		if(e.getSource()==Frame.saveExitButton) {
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.exploreExitButton) {
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.inventorybutton) {
			Frame.clearScreen();
			Frame.inventory();
		}
		if(e.getSource()==Frame.inventoryExitButton) {
			Frame.clearScreen();
			Frame.startMenu();
		}
		if(e.getSource()==Frame.inventoryNextButton) {
			Frame.addInventory(Frame.inventoryPosition+1);
		}
		if(e.getSource()==Frame.inventoryBackButton) {
			Frame.addInventory(Frame.inventoryPosition-1);
		}
		if(e.getSource()==Frame.tradeBackButton) {
			Frame.addTrade(Frame.tradePosition-1, Game.player.getLocation().trader());
		}
		if(e.getSource()==Frame.tradeNextButton) {
			Frame.addTrade(Frame.tradePosition+1, Game.player.getLocation().trader());
		}
		if(e.getSource()==Frame.tradeExitButton) {
			Frame.clearScreen();
			Frame.explorePanel.add(Frame.HUD);
			Frame.mainPanel.add(Frame.explorePanel);
		}
		if(e.getSource()==Frame.battleInventoryExitButton) {
			Frame.clearScreen();
			Frame.explorePanel.add(Frame.HUD);
			Frame.mainPanel.add(Frame.explorePanel);
		}
		if(e.getSource()==Frame.exploreInventoryButton) {
			Frame.clearScreen();
			Frame.inventory();
			Frame.inventoryExitButton.setVisible(false);
			Frame.battleInventoryExitButton.setVisible(true);
		}
	}
}
