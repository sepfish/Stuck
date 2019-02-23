import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.Color;

public class ObjectManager {
	String password = "Password";
	String combination = "1061";
	boolean computerUnlocked = false;
	boolean safeUnlocked = false;
	boolean mirrorCheckQ = false;
	//fun ints here
	int mirrorCheck = 0;
	int doorCheck = 0;
	int sofaCheck = 0;
	Random random;
	Character chara;
	InteractObject obj1;
	InteractObject door;
	InteractObject desk;
	InteractObject mirror;
	InteractObject chest;
	InteractObject hole;
	InteractObject sofa; //as of 1/25 serves no purpose
	InteractObject computer;
	InteractObject safe;
	InteractObject sideTable;
	Ladder ladderR1;
	Ladder ladderR2;
	ArrayList<InteractObject> interactObjects = new ArrayList<InteractObject>();
	
	ObjectManager(Character c){
		chara = c;
		//initialize interactObjects
		door = new InteractObject(140, 265, 90, 135);
		obj1 = new InteractObject(265, 300, 90, 120);
		desk = new InteractObject(300, 465, 120, 60);
		mirror = new InteractObject(500, 275, 70, 120);
		chest = new InteractObject(365, 300, 90, 120);
		hole = new InteractObject(150, 480, 20, 20);
		sofa = new InteractObject(475, 445, 150, 75);
		computer = new InteractObject(335, 415, 70, 50);
		safe = new InteractObject(600, 320, 90, 100);
		sideTable = new InteractObject(645, 450, 65, 75);
		//initialize ladders
		ladderR1 = new Ladder(750, 0, 80, 425);
		ladderR2 = new Ladder(750, 500, 80, 100);
		//add interactObjects to the interactObject arrayList
		interactObjects.add(door);
		interactObjects.add(desk);
		interactObjects.add(obj1);
		interactObjects.add(mirror);
		interactObjects.add(chest);
		interactObjects.add(hole);
		interactObjects.add(sofa);
		interactObjects.add(computer);
		interactObjects.add(safe);
		interactObjects.add(sideTable);
		//draw the images for the interactObjects
		//(room 1)
		door.setInside("nothing", "door.png", "door.png", "", 1, false);
		obj1.setInside("hmm", "clock.png", "chesttest.png", "", 1, false);
		chest.setInside("GLUE BOTTLE", "glue.png", "chesttest.png", "", 1, false);
		chest.lock();
		mirror.setInside("NOTE", "note.png", "mirror.png", "", 1, false);
		safe.setInside("OTHER KEY", "key2.png", "", "", 1, false);
		//(room 2)
		desk.setInside("CHEST KEY", "key.png", "desk.png", "", 2, true);
		hole.setInside("stick (implement later)", "glue.png", "hole.png", "", 2, false);
		sofa.setInside("PENCIL", "pencil.png", "", "", 2, false);
		computer.setInside("nothing", "", "computer1.png", "computer.png", 2, false);
		sideTable.setInside("nothing", "", "", "", 2, false);
		ladderR2.setImg("stairstest.png");
	}
	
	void update() {
		for (InteractObject i: interactObjects) {
			i.update();
		}
		chara.update();
		door.update();
	}
	
	void drawRoom1(Graphics g) {
		ladderR1.draw(g);
		door.setColor(Color.YELLOW);
		door.setName("DOOR");
		door.drawImg(g);
		obj1.setName("CHEST");
		obj1.drawImg(g);
		chest.setName("CHEST");
		chest.drawImg(g);
		mirror.setName("MIRROR");
		mirror.drawImg(g);
		safe.setName("SAFE");
		safe.drawImg(g);
		chara.draw(g);
	}
	
	void drawRoom2(Graphics g) {
		desk.setName("DESK");
		ladderR2.drawImg(g);
		desk.drawImg(g);	
		hole.setName("HOLE IN THE WALL");
		hole.drawImg(g);
		sofa.setName("SOFA");
		sofa.drawImg(g);
		computer.setName("COMPUTER");
		computer.drawImgTemp(g);
		sideTable.setName("SIDE TABLE");
		sideTable.drawImg(g);
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
		//DOOR
		if (o.name.equals("DOOR")) {
			if(chara.hasKey) {
				JOptionPane.showMessageDialog(null, "You open the DOOR.", "", JOptionPane.INFORMATION_MESSAGE);
				chara.roomState = 3;
			} else {
				if (mirrorCheck == 0) {
					JOptionPane.showMessageDialog(null, "The DOOR is locked.\nYou must find the KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (doorCheck == 0) {
						JOptionPane.showMessageDialog(null, "The DOOR is locked.\nYou must find the KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, "You crouch down...\nThere's something under the door.", "STUCK?", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, "It's the KEY. You try reaching for it, but your arm's not long enough.", "FOUND THE KEY", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, "Maybe you could find or make something that could help you reach it.", "FOUND THE KEY", JOptionPane.INFORMATION_MESSAGE);
						doorCheck++;
					} else {
						JOptionPane.showMessageDialog(null, "You need to find or make something to help you get the KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE);
					}
				}
					
			}
		//SOFA
		} else if (o.name.equals("SOFA")) {
			if (sofaCheck == 0) {
				JOptionPane.showMessageDialog(null, "There's a joke book on the sofa.\nYou decide to look inside the book.", "SOFA", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Inside the joke book, there's a quantum physics book.\nYou open it.", "SOFA", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Inside the quantum physics book, there's another joke book.\nYou feel a strange sense of deja vu.", "SOFA", JOptionPane.INFORMATION_MESSAGE);
				sofaCheck++;
			} else {
				JOptionPane.showMessageDialog(null, "You're reluctant to check the sofa again, but you see something wedged between the cushions.", "SOFA", JOptionPane.INFORMATION_MESSAGE);
				getObjectMethodNoKey(o);
			}
		//MIRROR
		} else if (o.name.equals("MIRROR")) {
			if (mirrorCheck == 0) {
				JOptionPane.showMessageDialog(null, "It's a mirror. You admire yourself in it.", "MIRROR", JOptionPane.INFORMATION_MESSAGE);
				mirrorCheck++;
			} else {
				JOptionPane.showMessageDialog(null, "You notice something inside the frame of the mirror.", "MIRROR", JOptionPane.INFORMATION_MESSAGE);
				getObjectMethodNoKey(o);
			}
			
		//COMPUTER
		} else if (o.name.equals("COMPUTER")) {
			String passwordQ = JOptionPane.showInputDialog(null, "ENTER PASSWORD:", "COMPUTER", JOptionPane.INFORMATION_MESSAGE);
			if (passwordQ.equalsIgnoreCase(password) && !computerUnlocked) {
				JOptionPane.showMessageDialog(null, "You unlocked the COMPUTER.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "There's a message addressed to you.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "'hey __________! the password to the safe is 1061. the ___________ key's in there.'", "COMPUTER", JOptionPane.INFORMATION_MESSAGE);
				computerUnlocked = true;
				JOptionPane.showMessageDialog(null, "'you don't need to enter the password to the computer again, by the way. just press enter or something. good luck!'", "COMPUTER", JOptionPane.INFORMATION_MESSAGE);
			} else if (computerUnlocked) {
				JOptionPane.showMessageDialog(null, "You look at the message on the computer again.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "'hey __________! the password to the safe is 1061. there's a key in there.'", "COMPUTER", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "That's the wrong PASSWORD.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE);
			}
		//SAFE
		} else if (o.name.equals("SAFE") && !safeUnlocked) {
			String combinationQ = JOptionPane.showInputDialog(null, "ENTER COMBINATION:", "SAFE", JOptionPane.INFORMATION_MESSAGE);
			if (combinationQ.equals(combination)) {
				JOptionPane.showMessageDialog(null, "You hear a click and the door opens slightly.", "SAFE", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Inside is a small KEY.", "SAFE", JOptionPane.INFORMATION_MESSAGE);
				safeUnlocked = true;
				getObjectMethodNoKey(o);
				System.out.println("hmm");
			} else if (safeUnlocked){
				JOptionPane.showMessageDialog(null, "You look inside the safe again.", "SAFE", JOptionPane.INFORMATION_MESSAGE);
				getObjectMethodNoKey(o);
			} else {
				JOptionPane.showMessageDialog(null, "That's the wrong COMBINATION.", "SAFE", JOptionPane.INFORMATION_MESSAGE);
			}
		//LOCKED
		} else if (o.locked) {
			if (o.hasKey) {
				o.unlock();
				JOptionPane.showMessageDialog(null, "You unlocked the " + o.name + ".", "UNLOCKED", JOptionPane.INFORMATION_MESSAGE);
				getObjectMethodNoKey(o);
			} else {
				if (rand == 0) {
					JOptionPane.showMessageDialog(null, "The " + o.name + " is locked.", "LOCKED", JOptionPane.INFORMATION_MESSAGE);
				} else if (rand == 1) {
					JOptionPane.showMessageDialog(null, "It's locked.", "LOCKED", JOptionPane.INFORMATION_MESSAGE);
				} else if (rand == 2) {
					JOptionPane.showMessageDialog(null, "You need to find the key to the " + o.name + " to open it.", "LOCKED", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		//OBJECT ALREADY TAKEN
		} else if (o.objInside != null && o.objInside != "nothing" && o.getObject) {
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "You've already taken the " + o.objInside + ".", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.objInside + " is already inside your INVENTORY.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null,  "The " + o.objInside + " inside the " + o.name + " is already in your possession.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			}
		//IT'S EMPTY
		} else if (o.objInside == null || o.objInside == "nothing"){
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "There's nothing inside.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.name + " is empty.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null, "The " + o.name + " contains nothing inside.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			}
		//NORMAL CHECKING
		} else if (o.objInside != null && o.objInside != "nothing" && !o.getObject && !o.locked) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + " inside the " + o.name + ".", "INSIDE", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQ == 1) {
				o.getObject = true;
				if (o.isKey) {
					o.hasKey = true;
				}
			}
		}
	}
	
	void getObjectMethodNoKey(InteractObject o) {
		random = new Random();
		int rand = random.nextInt(3);
		if (o.objInside != null && o.objInside != "nothing" && !o.getObject && !o.locked) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + " inside the " + o.name + ".", "INSIDE", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQ == 1) {
				o.getObject = true;
			}
		} else if (o.objInside != null && o.objInside != "nothing" && o.getObject) {
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "You've already taken the " + o.objInside + ".", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.objInside + " is already inside your INVENTORY.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null,  "The " + o.objInside + " inside the " + o.name + " is already in your possession.", "INSIDE", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
