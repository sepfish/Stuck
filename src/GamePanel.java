import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	GameObject object;
	
	GamePanel(){
		timer = new Timer(1000/60, this);
		object = new GameObject(10, 100, 60, 80);
	}

	void startGame() {
		timer.start();
	}
	
	 @Override
	 public void paintComponent(Graphics g){
		 object.draw(g);
	 }
	 
	 @Override
	 public void actionPerformed(ActionEvent e) {
		repaint();
	 }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("going left");
			object.movingState = "left";
		} else 
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("going right");
			object.movingState = "right";
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
