package com.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	/*
	private GameUtil(){
		// Tool class should be private 
	}
	*/
	public static Image getImage(String path) {
	
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	
		//return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader()).getResource(path));
	}
}
