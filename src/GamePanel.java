import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/*Hey, where am I now??
 *11/9: You just implemented "checking" an InteractObject. You were trying to make it turn red when it was checked.
 *11/16: You have problems with the isChecked setting back to false when it turns true - (try making the INteractObject its own little variable inside of GamePanel, not in the ObjectManager)
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
	
	GamePanel(){
		chara = new Character(450, 350, 60, 80);
		timer = new Timer(1000/60, this);
		obj = new ObjectManager(chara);
		obj.drawInteractObjects();
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
				chara.setY(350);
			} else 
			if (currentState == 1) {
				currentState = 2;
				chara.setY(450);
			} else {
				currentState++;
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE && obj.isBetween(chara, obj.obj1)) {
			obj.obj1.setIsChecked(true);
			System.out.println(obj.obj1.isItChecked());
			obj.update();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP  && obj.isBetween(chara, obj.ladderR1)) {
			chara.movingState = "up";
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && obj.isBetween(chara, obj.ladderR1)) {
			chara.movingState = "down";
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		chara.movingState = "";
	}
}
