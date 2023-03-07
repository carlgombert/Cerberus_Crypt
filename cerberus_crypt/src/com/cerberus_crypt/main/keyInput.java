package com.cerberus_crypt.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class keyInput implements ActionListener{
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
		if(e.getSource()==Frame.savebutton) {
			Frame.clearScreen();
			Frame.saveMenu();
		}
		/*if(e.getSource()==Frame.saveEnterButton) {
			try {
				Frame.save.SaveGame(Frame.saveTextField.getText());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Frame.saveTextField.setText("");
		}*/
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
	}
}
