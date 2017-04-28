package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.util.GameUtil;
import com.util.MyFrame;

/*
 * This class provides the frame for the game.
 * 
 */ 


public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	//Image bg = GameUtil.getImage("images/planeGameBackground1.jpg");
	Plane p = new Plane("images/newplane.png",50,50);
	
	ArrayList bulletList = new ArrayList();
	//Explode baozha = new Explode(50, 50);
	Explode bao;
	Date startTime;
	Date endTime;
	
	public void paint (Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		//baozha.draw(g);
		for (int i = 0; i<bulletList.size();i++) {
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			// if the two rectangles touched
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng) {
				p.setLive(false);
				
				if(bao==null) {
					endTime = new Date();//current time
					bao = new Explode(p.x, p.y);
				}
				bao.draw(g);
				break;
			}
			
		}
		
		if(!p.isLive()) {
			//printInfo(g, "GAME OVER",50,100,200,Color.white);
			int period = (int)(endTime.getTime() - startTime.getTime())/1000; // get seconds
	     	printInfo(g, "Time: "+period+" seconds", 20, 120, 260, Color.white);
	     
	     	switch (period/10) {
	     	case 0:
	     	case 1:
	     		printInfo(g, "Too bad", 50, 100, 200, Color.white);
	     		break;
	     	case 2:
	     		printInfo(g, "Not too bad", 50, 100, 200, Color.white);
	     		break;
	     	case 3:
	     		printInfo(g, "Bad", 50, 100, 200, Color.white);
	     		break;
	     	default:
	     		printInfo(g, "Good", 50, 100, 200, Color.white);
	     		break;
	     	}
	     	// the plane still exists so that the period still appears there
	     	
		}
		 
		//printInfo(g, "Score:100", 10, 50, 50, Color.yellow);
	}
	public void printInfo(Graphics g,String str,int size, int x, int y, Color color) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("Boulder",Font.BOLD,size);
		//g.drawString("GAME OVER", (int)p.x, (int)p.y);
		g.setFont(f);
		g.drawString(str, x,y);
		g.setColor(c);
	}  
	public static void main (String [] args) {
		new PlaneGameFrame().launchFrame();
	} 
	/*
	 * Override this method in order to register class KeyMonitor
	 */
	public void launchFrame() {
		super.launchFrame();
		//register class KeyMonitor
		addKeyListener(new KeyMonitor());
		//generate the bullets
		for(int i =0;i<6;i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();//current time
	}
	 
	/*
	 * This inner class is to achieve controlling by keyboard
	 */
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("Press"+e.getKeyCode());
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("Release"+e.getKeyCode());
			//System.out.println("Press"+e.getKeyCode());
			p.minusDirection(e);
		
	}
	}
	}
