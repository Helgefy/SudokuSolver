package Solver;

import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Knapp extends JComponent {
	

	Game game;
	int ypos;
	int xpos;
	imageLoader imgLoad;
	Graphics2D g2;
	Rectangle rect;
	
	Knapp(Game game,imageLoader imgLoad){
		this.game = game;
		ypos = 250;
		xpos = 640;
		this.imgLoad = imgLoad;
		rect = new Rectangle(xpos,ypos,160,80);
	}
	
	public void paintComponent(Graphics g,int n){
		
		g2 = (Graphics2D) g;
		g2.drawImage(imgLoad.getKnapp(n),xpos,ypos,null);
		

	}
	
	public Rectangle getRectangle(){
		return rect;
	}

	
		
	

}
