import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.Color;

public class ObjectManager {
	Random random;
	Character chara;
	InteractObject obj1;
	InteractObject door;
	InteractObject desk;
	InteractObject mirror;
	InteractObject chest;
	InteractObject hole;
	InteractObject sofa;
	Ladder ladderR1;
	Ladder ladderR2;
	ArrayList<InteractObject> interactObjects = new ArrayList<InteractObject>();
	
	ObjectManager(Character c){
		chara = c;
		door = new InteractObject(140, 265, 90, 135);
		obj1 = new InteractObject(265, 300, 90, 120);
		desk = new InteractObject(300, 465, 120, 60);
		mirror = new InteractObject(500, 275, 70, 120);
		chest = new InteractObject(365, 300, 90, 120);
		hole = new InteractObject(150, 480, 20, 20);
		sofa = new InteractObject(475, 445, 150, 75);
		ladderR1 = new Ladder(750, 0, 80, 425);
		ladderR2 = new Ladder(750, 475, 80, 135);
		interactObjects.add(door);
		interactObjects.add(desk);
		interactObjects.add(obj1);
		interactObjects.add(mirror);
		interactObjects.add(chest);
		interactObjects.add(hole);
		interactObjects.add(sofa);
	}
	
	void update() {
		obj1.update();
		desk.update();
		mirror.update();
		chara.update();
		door.update();
	}
	
	void drawRoom1(Graphics g) {
		ladderR1.draw(g);
		door.setColor(Color.YELLOW);
		door.setName("DOOR");
		door.setInside("nothing", "door.png", "door.png", 1, false);
		door.drawImg(g);
		obj1.setName("CHEST");
		obj1.setInside("nothing", "clock.png", "", 1, false);
		obj1.drawImg(g);
		chest.setName("CHEST");
		chest.setInside("GLUE BOTTLE", "glue.png", "", 1, false);
		chest.drawImg(g);
		chest.lock();
		mirror.setName("MIRROR");
		mirror.setInside("NOTE", "note.png", "mirror.png", 1, false);
		mirror.drawImg(g);
		chara.draw(g);
	}
	
	void drawRoom2(Graphics g) {
		desk.setName("DESK");
		ladderR2.draw(g);
		desk.setInside("CHEST KEY", "key.png", "desk.png", 2, true);
		desk.drawImg(g);	
		hole.setName("HOLE IN THE WALL");
		hole.setInside("stick (implement later)", "glue.png", "hole.png", 2, false);
		hole.drawImg(g);
		sofa.setName("SOFA");
		sofa.setInside("nothing", "door.png", "", 2, false);
		sofa.drawImg(g);
		chara.draw(g);
	}
	

	boolean isBetween(Character c, GameObject o) {
		if (c.x >= o.x && c.x + c.width <= o.x + o.width) {
			return true;
		} else {
			return false;
		}
	}

	void check(InteractObject o) {
		random = new Random();
		int rand = random.nextInt(3);
		if (o.name.equals("DOOR")) {
			if(chara.hasKey) {
				JOptionPane.showMessageDialog(null, "You open the DOOR.", "", JOptionPane.INFORMATION_MESSAGE);
				chara.roomState = 3;
			} else {
					JOptionPane.showMessageDialog(null, "The DOOR is locked.\nYou must find the KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "On second thought... what's that under the door?", "STUCK?", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (o.name.equals("SOFA")) {
			JOptionPane.showMessageDialog(null, "There's a joke book on the sofa.\nYou decide to look inside the book.", "SOFA", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "Inside the joke book, there's a quantum physics book.\nYou open it.", "SOFA", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "Inside the quantum physics book, there's another joke book.\nYou open it.", "SOFA", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "Inside the joke book, there's another quantum physics book...", "SOFA", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "You decide to stop.", "SOFA", JOptionPane.INFORMATION_MESSAGE);
		} else if (o.locked) {
			System.out.println(o.hasKey);
			if (o.hasKey) {
				o.locked = false;
				System.out.println("I unlocked the thing using the key thingy");
				JOptionPane.showMessageDialog(null, "You unlocked the " + o.name + ".", "UNLOCKED", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (rand == 0) {
					JOptionPane.showMessageDialog(null, "The " + o.name + " is locked.", "LOCKED", JOptionPane.INFORMATION_MESSAGE);
				} else if (rand == 1) {
					JOptionPane.showMessageDialog(null, "It's locked.", "LOCKED", JOptionPane.INFORMATION_MESSAGE);
				} else if (rand == 2) {
					JOptionPane.showMessageDialog(null, "You need to find the key to the " + o.name + " to open it.", "LOCKED", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else if (o.objInside != null && o.objInside != "nothing" && o.getObject) {
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "You've already taken the " + o.objInside + ".", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.objInside + " is already inside your INVENTORY.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null,  "The " + o.objInside + " inside the " + o.name + " is already in your possession.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (o.objInside == null || o.objInside == "nothing"){
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "There's nothing inside.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.name + " is empty.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null, "The " + o.name + " contains nothing inside.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			}
		} 
		else if (o.objInside != null && o.objInside != "nothing" && o.getObject == false && o.locked == false) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + " inside the " + o.name + ".", "INSIDE", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQ == 1) {
				o.getObject = true;
				if (o.isKey) {
					o.hasKey = true;
					System.out.println("I have the key thingy");
					System.out.println(o.hasKey);
				}
			}
		}
	}
}
