package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.util.GameUtil;

public class Plane extends GameObject {
	
	boolean left,up,right,down;
	private boolean live = true;
	
	
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void draw(Graphics g) {
		if(live) {
		g.drawImage(img,(int)x,(int)y,null);
		move();
		}
	}
	public Plane() {
		
	}
	/*
	 * parameter imgpath is the path of plane image
	 * parameter x,y are the location of plane
	 */
	public Plane(String imgpath, double x, double y) {
		
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	public void move() {
		if(left) {
			x -= speed;
		}
		if(right) {
			x += speed;
		}
		if(up) {
			y -= speed;
		}
		if(down) {
			y += speed;
		}
	}
	public void addDirection(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		//VK_LEFT:left key in the keyboard
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
		    up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;

		default:
			break;
		}
	}
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;

		default:
			break;
	}
	}
}
