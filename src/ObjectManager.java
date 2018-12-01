import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ObjectManager {
	Character chara;
	InteractObject obj1;
	InteractObject desk;
	Ladder ladderR1;
	Ladder ladderR2;
	ArrayList<InteractObject> interactObjects = new ArrayList<InteractObject>();
	
	ObjectManager(Character c){
		chara = c;
		obj1 = new InteractObject(200, 300, 80, 120);
		desk = new InteractObject(300, 465, 120, 60);
		interactObjects.add(desk);
		interactObjects.add(obj1);
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
		if (o.objInside != null && o.getObject == false) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + ".", "INSIDE", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQ == 1) {
				o.getObject = true;
			}
		} else if (o.objInside != null && o.getObject) {
			JOptionPane.showMessageDialog(null, "You've already taken the " + o.objInside + ".", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "There's nothing inside.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
