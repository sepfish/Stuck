import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*Hey, where am I now??
 *11/9: You just implemented "checking" an InteractObject. You were trying to make it turn red when it was checked.
 *11/16: You have problems with the isChecked setting back to false when it turns true - (try making the INteractObject its own little variable inside of GamePanel, not in the ObjectManager)
 *11/23: THANK GOD THAT PROBLEM IS SOLVED HHHHHH
 *		 anyway, you're debating whether to stick all the InteractObjects in an ArrayList
 *		 you should also start thinking about puzzles (finding key fragments (hehe Jevil), batteries for things, notes & passwords, etc)
 *		 you also created an inventory class... but pretty much didn't do anything in it
 *11/30: You did it. You implemented the ArrayList. You also created your first Inventory mock-up (it looks so bad hahaha)
 *		 You should start thinking about puzzles!!!! You also need to create more InteractObjects, and maybe get started on the art. 100px by 100px drawings seem pretty good for the inventory.
 *		 Maybe you should pixellate those Love Nikki home avatars haha
*/

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	Character chara;
	final int menu = 0;
	final int room1 = 1;
	final int room2 = 2;
	final int end = 3;
	int currentState = menu;
	ObjectManager obj;
	boolean test = false;
	Inventory inv;
	
	GamePanel(){
		chara = new Character(450, 350, 60, 80);
		timer = new Timer(1000/60, this);
		obj = new ObjectManager(chara);
		obj.drawInteractObjects();
		inv = new Inventory();
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
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Stuck.width, Stuck.height);    
	}
	
	void drawRoom1State(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Stuck.width, Stuck.height - 200); 
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 400, Stuck.width, 200);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(100, 0, 800, 500);
		g.setColor(Color.MAGENTA);
		g.fillRect(100, 400, Stuck.width - 200, 100);
		obj.drawRoom1(g);
	}
	
	void drawRoom2State(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Stuck.width, Stuck.height);   
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(100, 100, 800, 500);
		g.setColor(Color.MAGENTA);
		g.fillRect(100, 500, Stuck.width - 200, 100);
		obj.drawRoom2(g);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Stuck.width, Stuck.height);    
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == 3) {
				currentState = 1;
				chara.roomState = 1;
				chara.setY(350);
			} else {
				currentState++;
				chara.roomState++;
			}
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
			for (int i = 0; i < obj.interactObjects.size(); i++) {
				if (obj.isBetween(chara, obj.interactObjects.get(i))) {
					obj.interactObjects.get(i).isChecked = true;
					obj.check(obj.interactObjects.get(i));
					inv.isItChecked(obj.interactObjects.get(i));
					obj.update();
					obj.interactObjects.get(i).isChecked = false;
				}		
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
			System.out.println(chara.roomState);
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			inv.popUp();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		chara.movingState = "";
	}
}
