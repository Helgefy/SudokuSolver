package Solver;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class rute extends JComponent{

	int xpos;
	int ypos;
	int startx;
	int starty;
	rekke vertikalrekke;
	rekke horisontalrekke;
	rekke firkanter;
	boolean isEmpty;
	int tall;
	brett brett;
	Rectangle rect;
	Graphics2D g2;
	BufferedImage img;
	imageLoader imgLoad;
	boolean isSelected;
	
	public rute(int xpos,int ypos,rekke vertikalrekke,rekke horisontalrekke,rekke firkanter,brett brett){
		setypos(ypos);
		setxpos(xpos);
		setHorisontalrekke(horisontalrekke);
		setVertikalrekke(vertikalrekke);
		setFirkanter(firkanter);
		setEmpty(true);
		this.brett = brett;
		img=null;
		isSelected=false;
		
	}
	
	
	int getypos(){
		
		return ypos;
		
	}
	
	void setypos(int ypos){
		this.ypos=ypos;
	}
	
	int getxpos(){
		
		return xpos;
		
	}
	
	void setxpos(int xpos){
		this.xpos=xpos;
	}
	
	protected rekke getVertikalrekke() {
		return vertikalrekke;
	}

	protected void setVertikalrekke(rekke vertikalrekke) {
		this.vertikalrekke = vertikalrekke;
	}

	protected rekke getHorisontalrekke() {
		return horisontalrekke;
	}

	protected void setHorisontalrekke(rekke horisontalrekke) {
		this.horisontalrekke = horisontalrekke;
	}

	protected rekke getFirkanter() {
		return firkanter;
	}

	protected void setFirkanter(rekke firkanter) {
		this.firkanter = firkanter;
	}



	protected boolean isEmpty() {
		return isEmpty;
	}



	protected void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}



	protected int getTall() {
		if(isEmpty){
			return 0;
		}
		return tall;
	}



	protected void setTall(int tall) {
		this.tall = tall;
		setEmpty(false);
	}
	
	protected void removeTall(){
		setEmpty(true);
	}



	public void paintComponent(Graphics g){
		if(isSelected){
			g2 = (Graphics2D) g;
			g2.drawImage(imgLoad.getRute(getTall()+10), xpos*40+startx,ypos*40+starty,null);
		}
		else{
			g2 = (Graphics2D) g;
			g2.drawImage(imgLoad.getRute(getTall()), xpos*40+startx,ypos*40+starty,null);
		}
	}



	public void addImgLoad(imageLoader imgLoad) {
		// TODO Auto-generated method stub
		this.imgLoad=imgLoad;
	}
	public Rectangle getRectangle(){
		return rect;
	}
	public void select(){
		isSelected=true;
	}
	public void deSelect(){
		isSelected=false;
	}
	public void setStart(int x, int y){
		starty=y;
		startx=x;
		rect = new Rectangle(xpos*40+startx,ypos*40+starty,40,40);
	}
}
