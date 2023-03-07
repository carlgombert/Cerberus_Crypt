package com.cerberus_crypt.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Save {
	
	public static ArrayList<String> Saves = new ArrayList<String>();
	private static final String filePath = "/Users/carlgombert/eclipse-workspace/CerberusCryptSwing/saves/";
	
	public Save() {
		
	}
	
	/*public void SaveGame(String name) throws FileNotFoundException, IOException{
		String fileName = (filePath + name + ".svr");
		FileOutputStream userSaveFile = new FileOutputStream(fileName);
	    ObjectOutputStream playerSaver = new ObjectOutputStream(userSaveFile);
	    playerSaver.writeObject(Main.player);
	    userSaveFile.close();
	    playerSaver.close();
	}
	
	public Player LoadGame(String name) throws FileNotFoundException, IOException{
		Player loadedPlayer = Main.player;
		String fileName = (filePath + name + ".svr");
		FileInputStream userLoadFile = new FileInputStream(fileName); 
        ObjectInputStream playerLoader = new ObjectInputStream(userLoadFile);
        try {
			loadedPlayer = (Player)playerLoader.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
        userLoadFile.close();
	    playerLoader.close();
        return loadedPlayer;
	}*/
}
