import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	int currentState = menu;
	ObjectManager obj;
	Decorator deco;
	boolean test = false;
	Inventory inv;
	
	public static BufferedImage titleImg;
	public static BufferedImage floorImg;
	public static BufferedImage endImg;
	
	
	GamePanel(){
		chara = new Character(450, 350, 60, 80);
		timer = new Timer(1000/60, this);
		obj = new ObjectManager(chara);
		deco = new Decorator();
		inv = new Inventory();
		try {
			titleImg = ImageIO.read(this.getClass().getResourceAsStream("title test.jpg"));
			floorImg = ImageIO.read(this.getClass().getResourceAsStream("floor.jpg"));
			endImg = ImageIO.read(this.getClass().getResourceAsStream("end.jpg"));
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
		g.drawImage(GamePanel.titleImg, 0, 0, Stuck.width, Stuck.height, null);    
	}
	
	void drawRoom1State(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Stuck.width, Stuck.height - 200); 
		g.setColor(new Color(102, 71, 19));
		g.fillRect(0, 400, Stuck.width, 200);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(100, 0, 800, 500);
		g.drawImage(GamePanel.floorImg, 100, 400, 800, 100, null);
		deco.drawR1(g);
		obj.drawRoom1(g);
	}
	
	void drawRoom2State(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Stuck.width, Stuck.height);   
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(100, 100, 800, 500);
		g.drawImage(GamePanel.floorImg, 100, 500, 800, 100, null);
		deco.drawR2(g);
		obj.drawRoom2(g);
	}
	
	void drawEndState(Graphics g) {
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER && currentState != menu) {
			currentState = 3;
		}
		if (currentState == menu) {
			currentState = room1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			chara.movingState  = "left";
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			chara.movingState = "right";
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
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
				chara.movingState = "";
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
		if (e.getKeyCode() == KeyEvent.VK_I) {
			inv.popUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_H) {
			inv.help();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		chara.movingState = "";
	}
}
