import java.awt.Graphics;

import javax.swing.JOptionPane;

public class ObjectManager {
	Character chara;
	InteractObject obj1;
	InteractObject desk;
	Ladder ladderR1;
	Ladder ladderR2;
	
	ObjectManager(Character c){
		chara = c;
	}
	
	void update() {
		obj1.update();
		chara.update();
	}
	
	void drawRoom1(Graphics g) {
		drawInteractObjects();
		ladderR1.draw(g);
		obj1.draw(g);
		chara.draw(g);
	}
	
	void drawRoom2(Graphics g) {
		drawInteractObjectsR2();
		desk.draw(g);
		desk.setInside("Key");
		ladderR2.draw(g);
		chara.draw(g);
	}
	
	
	void drawInteractObjects() {
		ladderR1 = new Ladder(750, 0, 80, 425);
	}
	
	void drawInteractObjectsR2() {
		ladderR2 = new Ladder(750, 475, 80, 135);
	}
	
	boolean isBetween(Character c, GameObject o) {
		if (c.x >= o.x && c.x <= o.x + o.width) {
			return true;
		} else {
			return false;
		}
	}
	
	void check(InteractObject o) {
		if (o.objInside != null) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + ".", "Inside", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"Don't", "Take it"}, null);
		} else {
			JOptionPane.showMessageDialog(null, "There's nothing inside.");
		}
	}
}
