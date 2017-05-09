package Solver;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class brett extends JComponent{
	
	int size = 9;
	ArrayList<rute> nummer;
	ArrayList<rekke> vertikalerekker;
	ArrayList<rekke> horisontalerekker;
	ArrayList<rekke> firkanter;
	Graphics2D g2;
	imageLoader imgLoad;
	int xpos;
	int ypos;

	public brett(){
		// nummer
		nummer=new ArrayList<rute>();
		vertikalerekker=new ArrayList<rekke>();
		horisontalerekker=new ArrayList<rekke>();
		firkanter=new ArrayList<rekke>();
		imgLoad = new imageLoader();
		xpos = 150;
		ypos = 100;
		for (int i = 1;i<10;i++){
			vertikalerekker.add(new rekke(i));
			horisontalerekker.add(new rekke(i));
			firkanter.add(new rekke(i));
		}
		for (int i = 1;i<10;i++){
			for (int n=1;n<10;n++){
				nummer.add(new rute(n,i,vertikalerekker.get(n-1),horisontalerekker.get(i-1),firkanter.get((int)(Math.ceil((n-1)/3)+Math.floor((i-1)/3)*3)),this));
			}
		}
		for (rute rute:this.nummer){
			rute.addImgLoad(imgLoad);
			rute.setStart(xpos, ypos);
		}
	}
	
	void printBrett(){
		for (int n=0;n<9;n++){
			String tall="";
			for (int i=0;i<9;i++){
				if (nummer.get(n*9+i).isEmpty){
					tall=tall+"- ";
					
				}
				else{
					tall=tall+nummer.get(n*9+i).getTall()+" ";
					
				}
				
			}
			System.out.print(tall+"\n");
		}
		
	}
	
	void printTilhorighet(){
		for (int n=0;n<9;n++){
			String tall="";
			for (int i=0;i<9;i++){
				tall=tall+(nummer.get(n*9+i).getVertikalrekke().getPos())+" ";
				
			}
			System.out.print(tall+"\n");
		}
		System.out.print("\n\n");
		for (int n=0;n<9;n++){
			String tall="";
			for (int i=0;i<9;i++){
				tall=tall+(nummer.get(n*9+i).getHorisontalrekke().getPos())+" ";
				
			}
			System.out.print(tall+"\n");			
		}
		
		System.out.print("\n\n");
		for (int n=0;n<9;n++){
			String tall="";
			for (int i=0;i<9;i++){
				tall=tall+(nummer.get(n*9+i).getFirkanter().getPos())+" ";
				
			}
			System.out.print(tall+"\n");			
		}
		
		
		
	}
	public void paintComponent(Graphics g){
		g2 = (Graphics2D) g;
		g2.drawImage(imgLoad.getRamme(),xpos + 40,ypos + 40,null);

	}
	
	public imageLoader getImgLoad(){
		return imgLoad;
	}

}
