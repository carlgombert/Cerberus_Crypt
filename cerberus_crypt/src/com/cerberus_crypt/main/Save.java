package com.cerberus_crypt.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Save {
	
	private static final String filePath = "saves/";
	
	//saves the current progress to a file given by the players inputed name to the saves folder
	public static void SaveGame(String name) throws FileNotFoundException, IOException{
		String fileName = (filePath + name + ".svr");
		FileOutputStream userSaveFile = new FileOutputStream(fileName);
	    ObjectOutputStream playerSaver = new ObjectOutputStream(userSaveFile);
	    playerSaver.writeObject(Game.player);
	    userSaveFile.close();
	    playerSaver.close();
	}
	
	//loads the progress from a given file to the current session
	public static Player LoadGame(String name) throws FileNotFoundException, IOException{
		Player loadedPlayer = Game.player;
		String fileName = (filePath + name + ".svr");
		FileInputStream userLoadFile = new FileInputStream(fileName); 
        ObjectInputStream playerLoader = new ObjectInputStream(userLoadFile);
        try {
			loadedPlayer = (Player)playerLoader.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
        loadedPlayer.setLocation(Game.grasslands);
        userLoadFile.close();
	    playerLoader.close();
        return loadedPlayer;
	}
}
