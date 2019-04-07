import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	Character chara;
	final int menu = 0;
	final int room1 = 1;
	final int room2 = 2;
	final int end = 3;
	final int transition = 4;
	int currentState = menu;
	ObjectManager obj;
	Decorator deco;
	boolean test = false;
	Inventory inv;
	//songs
	Song ibmemory;
	boolean ibmemoryStart = false;
	Song chaosablaze;
	boolean chaosablazeStart = false;
	Song dvictory;
	boolean dvictoryStart = false;
	//hmm
	boolean startQ = false;
	boolean pressSomething = false;
	Random random;
	
	public static BufferedImage titleImg;
	public static BufferedImage floorImg;
	public static BufferedImage endImg;
	public static BufferedImage skyR1;
	
	
	GamePanel(){
		chara = new Character(450, 350, 63, 84);
		timer = new Timer(1000/60, this);
		obj = new ObjectManager(chara);
		deco = new Decorator();
		inv = new Inventory();
		ibmemory = new Song("memory.mp3");
		chaosablaze = new Song("chaosablaze.mp3");
		dvictory = new Song("delightinvictory.mp3");
		
		try {
			titleImg = ImageIO.read(this.getClass().getResourceAsStream("title.jpg"));
			floorImg = ImageIO.read(this.getClass().getResourceAsStream("floor.jpg"));
			endImg = ImageIO.read(this.getClass().getResourceAsStream("end.jpg"));
			skyR1 = ImageIO.read(this.getClass().getResourceAsStream("sky1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void startGame() {
		timer.start();
	}
	
	void updateMenuState() {
		
	}
	
	void updateRoom1State() {
		obj.update();
	}
	
	void updateRoom2State() {
		obj.update();
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		ibmemory.stop();
		g.drawImage(GamePanel.titleImg, 0, 0, Stuck.width, Stuck.height, null);    
	}
	
	void drawRoom1State(Graphics g) {
		if (!startQ) {
			startQ = true;
			pressSomething = true;
			obj.introduction();
		}
		if (!ibmemoryStart) {
			ibmemory.play();
			ibmemoryStart = true;
		}
		if (obj.dramaticMoment) { 
			ibmemory.stop();
		}
		g.drawImage(GamePanel.skyR1, 0, 0, Stuck.width, Stuck.height - 200, null);  
		g.setColor(new Color(59, 40, 14));
		g.fillRect(0, 400, Stuck.width, 200);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(100, 0, 800, 500);
		g.drawImage(GamePanel.floorImg, 100, 400, 800, 100, null);
		deco.drawR1(g);
		obj.drawRoom1(g);
		chara.draw(g);
	}
	
	void drawRoom2State(Graphics g) {
		g.setColor(new Color(147, 179, 175));
		g.fillRect(0, 0, Stuck.width, Stuck.height);   
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(100, 100, 800, 500);
		g.drawImage(GamePanel.floorImg, 100, 500, 800, 100, null);
		obj.drawRoom2(g);
		deco.drawR2(g);
		chara.draw(g);
	}
	
	void drawEndState(Graphics g) {
		ibmemory.stop();
		random = new Random();
		int chaosorvictory = random.nextInt(2);
		if (chaosorvictory == 0) {
			if (!chaosablazeStart) {
				chaosablaze.play();
				chaosablazeStart = true;
			}
		} else {
			if (!dvictoryStart) {
				dvictory.play();
				dvictoryStart = true;
			}
		}
			
		g.drawImage(GamePanel.endImg, 0, 0, Stuck.width, Stuck.height, null);
	}
	

	
	 @Override
	 public void paintComponent(Graphics g){
		if (currentState == menu) {
			drawMenuState(g);
		} else if (currentState == room1) {
			drawRoom1State(g);
		} else if (currentState == room2) {
			drawRoom2State(g);
		} else if (currentState == end) {
			drawEndState(g);
		}
	 }
	 
	 @Override
	 public void actionPerformed(ActionEvent e) {
		if (chara.roomState == 3) {
			currentState = end;
		}
		if (currentState == menu) {
			updateMenuState();
		} else if (currentState == room1) {
			updateRoom1State();
		} else if (currentState == room2) {
			updateRoom2State();
		} else if (currentState == end) {
			updateEndState();
		}
		repaint();
	 }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (currentState == menu) {
			currentState = room1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			chara.setMovingState("left");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			chara.setMovingState("right");
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			chara.setMovingState("");
			boolean tempSolution = false;
			for (int i = 0; i < obj.interactObjects.size(); i++) {
				if (obj.isBetween(chara, obj.interactObjects.get(i)) && obj.interactObjects.get(i).floorNumber == currentState) {
					obj.interactObjects.get(i).isChecked = true;
					obj.check(obj.interactObjects.get(i));
					inv.isItChecked(obj.interactObjects.get(i));
					obj.update();
					obj.interactObjects.get(i).isChecked = false;
				}
			}
			if (currentState == 2 && 150 <= chara.x && 170 >= chara.x && tempSolution == false) {
				obj.interactObjects.get(5).isChecked = true;
				obj.check(obj.interactObjects.get(5));
				inv.isItChecked(obj.interactObjects.get(5));
				obj.update();
				obj.interactObjects.get(5).isChecked = false;
				tempSolution = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP  && obj.isBetween(chara, obj.ladderR1)) {
			chara.movingState = "up";
			if (chara.roomState == 2) {
				chara.setY(450);
				currentState = 2;
				chara.setMovingState("");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && obj.isBetween(chara, obj.ladderR1)) {
			chara.movingState = "down";
			if (chara.roomState == 1 && chara.justArrived) {
					chara.setY(60);
					chara.justArrived = false;
					currentState = 1;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_I && pressSomething) {
			inv.popUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_H && pressSomething) {
			inv.help();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		chara.movingState = "";
	}
}
