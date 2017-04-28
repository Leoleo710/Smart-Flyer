package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.util.Constant;

public class Bullet extends GameObject {
	
	double degree;
	
	
	public Bullet() {
		degree = Math.random()*Math.PI*2;  // set random degree
		//set the location of the bullets at the center of the screen
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_WIDTH/2;
		width = 10;
		height = 10;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);  // draw a point to instead of the bullet
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y>Constant.GAME_HEIGHT-height||y<30){
			degree = -degree;
		}
		if(x>Constant.GAME_WIDTH-width||x<0) {
			degree = Math.PI-degree;
		}
		g.setColor(c);
	}
}
