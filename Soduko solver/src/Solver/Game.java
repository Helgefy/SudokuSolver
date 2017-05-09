package Solver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{
	brett brett;
	JFrame window;
	KeyInput kInput;
	rute selected;
	JPanel panel;
	Knapp knapp;

	
	public Game(){
		
		GameInit();
		
		GameLoop();
		
	}
	
	
	public void GameInit(){
		// Lager vindu
		window = new JFrame();
		// Størrelse på vindu og setter vindu i senter av skjærmen
		int windx = 900;
		int windy = 600;
		window.setSize(windx, windy);
		window.setLocationRelativeTo(null);
		// Tittel
		window.setTitle("Sodukoløser 3000!!!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		panel = new JPanel(new BorderLayout());
		window.add(panel);
		// Bakgrundsfarge grønn
		panel.setBackground(new Color(50, 150, 50));
		window.addKeyListener(new KeyInput(this));
		panel.addMouseListener(new MouseInput(this));
		brett = new brett();
		for (rute rute:brett.nummer){
			panel.add(rute);
		}
		panel.add(brett);
		knapp = new Knapp(this,brett.getImgLoad());
		knapp.setBackground(new Color(80, 180, 180));
		knapp.setBounds(640,250,160,80);
		knapp.setFont(new Font("Arial",Font.BOLD,18));
		panel.add(knapp);
		knapp.setFocusable(false);
	}
	
	
	public void GameLoop(){
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		int updates=0;
		int frames=0;
		long timer = System.currentTimeMillis();
		while(true){
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime=now;
			if(delta >= 1){
				tick();
				delta--;
				updates++;
				render();
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			frames++;
			if(System.currentTimeMillis() - timer > 10000){
				timer += 10000;
				System.out.println(updates/10 + " Ticks, Fps " + frames);
				updates = 0;
				frames = 0;
				
			}						
		}
			
	}
	private void tick(){
		
		
	}
	private void render(){
		BufferStrategy bs = window.getBufferStrategy();
		if(bs==null){
			window.createBufferStrategy(3);
			bs = window.getBufferStrategy();
		}
		
		Graphics g = bs.getDrawGraphics();
		panel.paint(g);
		for (rute rute:brett.nummer){
			rute.paintComponent(g);

		}
		brett.paintComponent(g);
		if(window.getMousePosition()!=null && knapp.getRectangle().contains(window.getMousePosition())){
			knapp.paintComponent(g,1);
		}
		else{
			knapp.paintComponent(g,0);
		}
		g.dispose();
		bs.show();
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case (KeyEvent.VK_0):if(selected!=null){
			selected.setTall(0);
			selected.setEmpty(true);
		}
		break;
		case (KeyEvent.VK_NUMPAD0):if(selected!=null){
			selected.setTall(0);
			selected.setEmpty(true);
		}
		break;
		case (KeyEvent.VK_BACK_SPACE):if(selected!=null){
			selected.setTall(0);
			selected.setEmpty(true);
		}
		break;
		case (KeyEvent.VK_1):if(selected!=null){
			selected.setTall(1);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_NUMPAD1):if(selected!=null){
			selected.setTall(1);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_2):if(selected!=null){
			selected.setTall(2);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_NUMPAD2):if(selected!=null){
			selected.setTall(2);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_3):if(selected!=null){
			selected.setTall(3);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_NUMPAD3):if(selected!=null){
			selected.setTall(3);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_4):if(selected!=null){
			selected.setTall(4);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_NUMPAD4):if(selected!=null){
			selected.setTall(4);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_5):if(selected!=null){
			selected.setTall(5);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_NUMPAD5):if(selected!=null){
			selected.setTall(5);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_6):if(selected!=null){
			selected.setTall(6);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_NUMPAD6):if(selected!=null){
			selected.setTall(6);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_7):if(selected!=null){
			selected.setTall(7);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_NUMPAD7):if(selected!=null){
			selected.setTall(7);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_8):if(selected!=null){
			selected.setTall(8);
			selected.setEmpty(false);
		};
		break;		
		case (KeyEvent.VK_NUMPAD8):if(selected!=null){
			selected.setTall(8);
			selected.setEmpty(false);
		};
		break;
		case (KeyEvent.VK_9):if(selected!=null){
			selected.setTall(9);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_NUMPAD9):if(selected!=null){
			selected.setTall(9);
			selected.setEmpty(false);
		}
		break;
		case (KeyEvent.VK_DOWN):if(selected!=null && selected.getypos() < 9){
			selected.deSelect();
			selected = brett.nummer.get(brett.nummer.indexOf(selected)+9);
			selected.select();
		}
		break;
		case (KeyEvent.VK_UP):if(selected!=null && selected.getypos() > 1){
			selected.deSelect();
			selected = brett.nummer.get(brett.nummer.indexOf(selected)-9);
			selected.select();
		}
		break;
		case (KeyEvent.VK_RIGHT):if(selected!=null && selected.getxpos() < 9){
			selected.deSelect();
			selected = brett.nummer.get(brett.nummer.indexOf(selected)+1);
			selected.select();
		}
		break;
		case (KeyEvent.VK_LEFT):if(selected!=null && selected.getxpos() > 1){
			selected.deSelect();
			selected = brett.nummer.get(brett.nummer.indexOf(selected)-1);
			selected.select();
		}
		break;
		}
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (rute rute:brett.nummer){
			if(rute.getRectangle().contains(window.getMousePosition())){
				rute.select();
				if (selected!=null){
					selected.deSelect();
				}
				selected=rute;
				return;
			}
			
		}
		if(selected!=null){
			selected.deSelect();}
		selected=null;
		if(knapp.getRectangle().contains(window.getMousePosition())){
			solve();
		}
	}
	public void solve(){
		System.out.println("Løser Sodukoen");
		ArrayList<String> data1=new ArrayList<String>();
		for(rute rute:brett.nummer){
			if(rute.isEmpty==false){
				
				data1.add(Integer.toString(rute.getxpos()-1) + Integer.toString(rute.getypos()-1) + Integer.toString(rute.getTall()));
			}
		}
		
		
		String[] data = new String[data1.size()];
		for(int i=0;i<data1.size();i++){
			data [i] = data1.get(i);
		}
		
		Solver solv=new Solver(data);
		
		int[] los=solv.getSolution();
		for(int i = 0;i<81;i++){
			brett.nummer.get(i).setTall(los[i]);
		}
	}
}
