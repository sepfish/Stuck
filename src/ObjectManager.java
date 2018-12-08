import java.awt.Graphics;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.Color;

public class ObjectManager {
	Character chara;
	InteractObject obj1;
	InteractObject door;
	InteractObject desk;
	InteractObject mirror;
	InteractObject chest;
	Ladder ladderR1;
	Ladder ladderR2;
	ArrayList<InteractObject> interactObjects = new ArrayList<InteractObject>();
	
	ObjectManager(Character c){
		chara = c;
		door = new InteractObject(140, 280, 80, 120);
		obj1 = new InteractObject(265, 300, 90, 120);
		desk = new InteractObject(300, 465, 120, 60);
		mirror = new InteractObject(500, 305, 70, 120);
		chest = new InteractObject(365, 300, 90, 120);
		interactObjects.add(door);
		interactObjects.add(desk);
		interactObjects.add(obj1);
		interactObjects.add(mirror);
		interactObjects.add(chest);
	}
	
	void update() {
		obj1.update();
		desk.update();
		mirror.update();
		chara.update();
	}
	
	void drawRoom1(Graphics g) {
		drawInteractObjects();
		ladderR1.draw(g);
		door.draw(g);
		door.setColor(Color.YELLOW);
		door.setName("DOOR");
		obj1.draw(g);
		obj1.setName("CHEST");
		chest.draw(g);
		chest.setName("CHEST");
		chest.setInside("hmm", "test.jpg");
		chest.lock();
		mirror.draw(g);
		mirror.setName("MIRROR");
		mirror.setInside("NOTE", "note.jpg");
		chara.draw(g);
	}
	
	void drawRoom2(Graphics g) {
		drawInteractObjectsR2();
		desk.draw(g);
		desk.setName("DESK");
		desk.setInside("CHEST KEY", "Untitled.jpg");
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
		if (c.x >= o.x && c.x + c.width <= o.x + o.width) {
			return true;
		} else {
			return false;
		}
	}
	
	void check(InteractObject o) {
		if (o.name.equals("DOOR")) {
			JOptionPane.showMessageDialog(null, "The DOOR is locked.\nYou must find the KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE);
		} else if (o.locked) {
			JOptionPane.showMessageDialog(null, "The " + o.name + " is locked.", "LOCKED", JOptionPane.INFORMATION_MESSAGE);
		} else if (o.objInside != null && o.getObject == false) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + " inside the " + o.name + ".", "INSIDE", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQ == 1) {
				o.getObject = true;
			}
		} else if (o.objInside != null && o.getObject) {
			JOptionPane.showMessageDialog(null, "You've already taken the " + o.objInside + ".", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
		} else if (o.objInside == null){
			JOptionPane.showMessageDialog(null, "There's nothing inside.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
