package Solver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class imageLoader {
	
	BufferedImage ramme;
	BufferedImage spruter;
	ArrayList<BufferedImage> ruter;
	ArrayList<BufferedImage> knapper;
	BufferedImage knapp;
	
	
	public imageLoader(){
		

		if(spruter== null){
		try{
			spruter = ImageIO.read(new File("bilder/ruter.png"));

		} catch (IOException e) {
			System.out.println("Finner ikke bildet");
		}}
		if(ramme== null){
		try{
			ramme = ImageIO.read(new File("bilder/ramme.png"));

		} catch (IOException e) {
			System.out.println("Finner ikke bildet");
		}}

		createRuter();
		
		if(knapp== null){
		try{
			knapp = ImageIO.read(new File("bilder/knapp.png"));

		} catch (IOException e) {
			System.out.println("Finner ikke bildet");
		}}
		createKnapper();
		
		}
	
	public BufferedImage getRute(int n){
		return ruter.get(n);
		
	}
	public void createRuter(){
		ruter = new ArrayList<BufferedImage>();
		for(int row=0;row<4;row++){
			for(int col=0;col<5;col++){
				ruter.add(spruter.getSubimage(col*40, row*40, 40, 40));
				
			}
		}
		
		
	}
	public void createKnapper(){
		knapper = new ArrayList<BufferedImage>();
		for(int row=0;row<2;row++){
			knapper.add(knapp.getSubimage(0, row*80, 160, 80));
		}
		
		
	}
	
	public BufferedImage getKnapp(int n){
		return knapper.get(n);
		
	}
	
	
	public BufferedImage getRamme(){
		return ramme;
	}
	
	
}
