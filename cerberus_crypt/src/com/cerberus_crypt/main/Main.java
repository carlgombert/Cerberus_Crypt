package com.cerberus_crypt.main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;


public class Main implements Serializable{

	transient public static Frame frame;
	
	public static int width;
	public static int height;
	
	
	public static void main(String[] args) {
		Game game = new Game();
		
		Dimension screen_size=Toolkit.getDefaultToolkit().getScreenSize();
		height = (int) screen_size.getHeight();
		//height = 200;
    	width = (int) ((height / 11) * 15);
		frame = new Frame(width, height);
		
    }
	
}