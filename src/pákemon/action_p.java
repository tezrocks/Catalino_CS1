package pákemon;

//pallat town
//rice man easter egg
//

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class action_p extends JPanel implements KeyListener, ActionListener  {
	
	// pakemon
	static HashMap<String,String> Squitle = new HashMap(); 
	static HashMap Picochu = new HashMap(); 
	
	private int backgroundX, backgroundY, playerX, playerY, Pimage;
	private boolean play = false;
	// stage
	private boolean town = true;
	private boolean path = false;
	private boolean pine_l = false;
	private boolean battle = false;
	// face
	private boolean front = true;
	private boolean back = false;
	private boolean right = false;
	private boolean left = false;
	// images
	Image pallet_town, pine_lab, player, pake_orb, squitle;//, Pimage;
	private Timer t;
	int delay = 10;
	
	public action_p() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		t = new Timer(delay,this);
		t.start();
		backgroundX = 0;
		backgroundY = 0;
		playerX = 100;
		playerY = 208;
		
		
		///squitle
		Squitle.put("HP", "50");
		Squitle.put("attack", "20");
		//Squitle.put("image", squitle);  
		///pikachu
		Picochu.put("HP", 40);
		Picochu.put("attack", 30);
		//Picochu.put("image", );     /////////// needs a picture 
		
	
		//import images
		ImageIcon b = new ImageIcon("C:/Users/11178/Desktop/Java stooff/250px-Pallet_Town_RBY.png");// town
		pallet_town = b.getImage();
		ImageIcon y = new ImageIcon("C:/Users/11178/Desktop/Java stooff/pines_lab.png"); // pine lab
		pine_lab = y.getImage();
		ImageIcon x = new ImageIcon("C:/Users/11178/Desktop/Java stooff/pake_orb.png"); // pake orb
		pake_orb = x.getImage();
		ImageIcon p = new ImageIcon("C://Users//11178//Desktop//Java stooff/front_pakemon_player.png");// player
		player = p.getImage();
		ImageIcon s = new ImageIcon("C:/Users/11178/Desktop/Java stooff/squitle.png"); // pake orb
		squitle = s.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Squitle.put("HP", 50);
		//Squitle.put("", 50);
		
		
		Graphics2D g2d = (Graphics2D)g;
		if(town == true) {
			g2d.drawImage(pallet_town, backgroundX, backgroundY,null);
		}
		else if(pine_l == true) {
			g2d.drawImage(pine_lab,backgroundX, backgroundY,null);
			g2d.drawImage(pake_orb, 500, 160,null);
		}
		else if(battle == true) {
			//g2d.drawImage(Pimage, 390, 30,null);
		}
		g2d.drawImage(player,playerX, playerY,null);
			
		//g.drawRect(413, 148, 208, 43);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		g.drawString(Squitle.get("attack"),25,25);
		g.drawRect(playerX, playerY, 47, 55);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		t.start();
		
		if (town == true) {// starting town
			
			if(front == true){// done
				if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 137, 105, 137, 100))){ //house 1
					playerY=50;							//				-					//
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 412, 105, 137, 100))){ //house 2
					playerY=50;
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 341, 273, 212, 138))){ //house 3
					playerY=218;
				}
			}
			
			else if(back == true) {// done
				if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 137, 105, 137, 100))){ //house 1
					playerY=205;															//   +    //
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 412, 105, 137, 100))){ //house 2
					playerY=205;
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 341, 273, 212, 138))){ //house 3
					playerY=411;
				}
			}
			
			else if(right == true) {// done
				if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 137, 105, 137, 100))){ //house 1
					playerX=90;						//				-				   //
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 412, 105, 137, 100))){ //house 2
					playerX=365;
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 341, 273, 212, 138))){ //house 3
					playerX=294;
				}
			}
			
			else if(left == true) {// done
				if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 137, 105, 137, 100))){ //house 1
					playerX=274;													   //    +   //
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 412, 105, 137, 100))){ //house 2
					playerX=549;
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 341, 273, 212, 138))){ //house 3
					playerX=553;
				}
			}
			
			
			if( new Rectangle(playerX, playerY, 47, 59).intersects(new Rectangle( 401, 394, 55, 18))) {
				town = false;
				path = false;
				pine_l = true;
				battle = false;
				
				playerX = 323;
				playerY = 520;
			}
		}
		
		else if(pine_l == true) {
			if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 413, 148, 208, 43))){ //pake orb on table
				ImageIcon x = new ImageIcon("C:/Users/11178/Desktop/Java stooff/transparent_image.png"); // pake orb
				pake_orb = x.getImage();
				town = false;
				path = false;
				pine_l = false;
				battle = true;///////////////////////////////////////////////////////////////////////////////////////////////////////////////take out
			}
			
			if(front == true) {
				if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 413, 148, 208, 43))){ //table
					playerY-= 10;					    //				-					//               
				}  
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 414, 305, 273, 72))){ //right cabinet
					playerY-= 10;					             
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 0, 305, 273, 72))){ //left cabinet
					playerY-= 10;					             
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 0, 45, 276, 47))){ //desk
					playerY-= 10;					             
				}
			}                                                                                                
			else if(back == true) {// done                                                                   
				if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 413, 148, 208, 43))){ //table
					playerY+= 10;															//   +    //     
				} 
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 414, 305, 273, 72))){ //right cabinet
					playerY+= 10;					             
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 0, 305, 273, 72))){ //left cabinet
					playerY+= 10;					             
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 0, 45, 276, 47))){ //desk
					playerY+= 10;					             
				}
			}                                                                                                
			else if(right == true) {// done                                                                  
				if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 413, 148, 208, 43))){ //table
					playerX -=10;					//				-				   //                    
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 414, 305, 273, 72))){ //right cabinet
					playerX -=10; 
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 0, 305, 273, 72))){ //left cabinet
					playerX -=10; 
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 0, 45, 276, 47))){ //desk
					playerX -=10; 
				}
			}                                                                                                
			else if(left == true) {// done                                                                   
				if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 413, 148, 208, 43))){ //table
					playerX +=10; 													   //    +   //
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 414, 305, 273, 72))){ //right cabinet
					playerX +=10; 					             
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 0, 305, 273, 72))){ //left cabinet
					playerX +=10; 					             
				}
				else if( new Rectangle(playerX, playerY, 47, 55).intersects(new Rectangle( 0, 45, 276, 47))){ // desk
					playerX +=10; 					             
				}
			}
			
			
			if(new Rectangle(playerX, playerY, 47, 59).intersects(new Rectangle( 323, 580, 55, 18))){
				town = true;
				path = false;
				pine_l = false;
				battle = false;
				
				playerX = 401;
				playerY = 415;
			}
		}
		
		if (battle == true) {
			ImageIcon p = new ImageIcon("C://Users//11178//Desktop//Java stooff/transparent_image.png");// player disapear
			player = p.getImage();
			///Pimage = Squitle.get(attack);
			
			
		}
		
		repaint();
	}

	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {//move left
			
			if (town == true) {// starting town
				if (playerX <= 30) {
					playerX = 30;
				}
				else {
					playerX -= 10;
				}
			}
			if (pine_l == true) {
				if (playerX <= 5) {
					playerX = 5;
				}
				else {
					playerX -= 10;
				}
			}
			front = false;
			back = false;
			right = false;
			left = true;
			
			ImageIcon p = new ImageIcon("C://Users//11178//Desktop//Java stooff/left_pakemon_player.png");
			player = p.getImage();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {	//move right
			
			if (town == true) {// pallet town
				if (playerX >= 610) {
					playerX = 610;
				}
				else {
					playerX += 10;
				}
			}
			if (pine_l == true) {// pine's lab
				if (playerX >= 630) {
					playerX = 630;
				}
				else {
					playerX += 10;
				}
			}
			front = false;
			back = false;
			right = true;
			left = false;
			
			ImageIcon p = new ImageIcon("C://Users//11178//Desktop//Java stooff/right_pakemon_player.png");
			player = p.getImage();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) { //move up 
			
			if (town == true) {// starting town
				if (playerY <= 45) {
					playerY = 45;
				}
				else {
					playerY -= 10;
				}
			}
			if (pine_l == true) {// pine's lab
				if (playerY <= 45) {
					playerY = 45;
				}
				else {
					playerY -= 10;
				}
			}
			front = false;
			back = true;
			right = false;
			left = false;
			
			ImageIcon p = new ImageIcon("C://Users//11178//Desktop//Java stooff/back_pakemon_player.png");
			player = p.getImage();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) { //move down
			
			if (town == true) {// starting town
				if (playerY >= 540) {
					playerY = 540;
				}
				else {
					playerY += 10;
				}
			}
			if (pine_l == true) {// pine's lab
				if (playerY >= 540) {
					playerY = 540;
				}
				else {
					playerY += 10;
				}
			}
			front = true;
			back = false;
			right = false;
			left = false;

			
			ImageIcon p = new ImageIcon("C://Users//11178//Desktop//Java stooff/front_pakemon_player.png");
			player = p.getImage();
		}
	
	}
	
	

	
	public void keyReleased(KeyEvent e) {
		
		
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}
}