import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

import java.applet.AudioClip;
import java.awt.Color;

public class ObjectManager {
	String password = "password";
	String combination;
	boolean computerUnlocked = false;
	boolean safeUnlocked = false;
	boolean mirrorCheckQ = false;
	//fun stuff here
	int mirrorCheck = 0;
	int doorCheck = 0;
	int sofaCheck = 0;
	boolean dramaticMoment = false;
	//interactObjects
	Random random;
	Character chara;
	InteractObject obj1;
	InteractObject door;
	InteractObject desk;
	InteractObject mirror;
	InteractObject chest;
	InteractObject hole;
	InteractObject sofa;
	InteractObject computer;
	InteractObject safe;
	InteractObject sideTable;
	Ladder ladderR1;
	Ladder ladderR2;
	ArrayList<InteractObject> interactObjects = new ArrayList<InteractObject>();
	ImageIcon icon;
	boolean squeakQ;
	
	ObjectManager(Character c) {
		chara = c;
		Random rand = new Random();
		int rand1 = rand.nextInt(9);
		int rand2 = rand.nextInt(9);
		int rand3 = rand.nextInt(9);
		int rand4 = rand.nextInt(9);
		combination = Integer.toString(rand1) + Integer.toString(rand2) + Integer.toString(rand3) + Integer.toString(rand4);
		icon = new ImageIcon(this.getClass().getClassLoader().getResource("icon.png"));
		squeakQ = false;
		//initialize interactObjects
		door = new InteractObject(140, 265, 90, 135);
		obj1 = new InteractObject(265, 300, 90, 120);
		desk = new InteractObject(315, 465, 120, 60);
		mirror = new InteractObject(500, 275, 70, 120);
		chest = new InteractObject(365, 300, 90, 120);
		hole = new InteractObject(150, 480, 20, 20);
		sofa = new InteractObject(475, 445, 150, 75);
		computer = new InteractObject(335, 415, 70, 50);
		safe = new InteractObject(600, 320, 90, 100);
		sideTable = new InteractObject(645, 465, 44, 51);
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
		interactObjects.add(sideTable);
		interactObjects.add(safe);
		//draw the images for the interactObjects
		//(room 1)
		door.setInside("DOOR KEY", "key3.png", "door.png", "", 1, false);
		obj1.setInside("nothing", "clock.png", "chesttest.png", "chesttest1.png", 1, false);
		chest.setInside("GLUE BOTTLE", "glue.png", "chesttest.png", "chesttest1.png", 1, false);
		chest.lock();
		mirror.setInside("NOTE", "note.png", "mirror1.png", "mirror4.png", 1, false);
		safe.setInside("FORGOTTEN KEY", "key2.png", "safetest.png", "", 1, false);
		ladderR1.setImg("long.jpg");
		//(room 2)
		desk.setInside("CHEST KEY", "key.png", "desk.png", "", 2, true);
		hole.setInside("STICK", "stick.png", "hole.png", "", 2, false);
		sofa.setInside("PENCIL", "pencil.png", "sofa.png", "", 2, false);
		computer.setInside("nothing", "", "computer1.png", "computer.png", 2, false);
		sideTable.setInside("nothing", "sidetabletest.png", "sidetabletest.png", "", 2, false);
		ladderR2.setImg("stairstest.png");
	}
	
	public AudioClip loadSound(String fileName) {
		return JApplet.newAudioClip(getClass().getResource(fileName));
	}
	
	void update() {
		for (InteractObject i: interactObjects) {
			i.update();
		}
		chara.update();
		door.update();
		AudioClip squeak = loadSound("sqeak.wav");
		if (!squeakQ && (chara.movingState == "up" || chara.movingState == "down")) {
			squeak.play();
			squeakQ = true;
		}
		if (chara.movingState.equals("change") || (chara.y > 350 && chara.roomState == 1)) {
			squeakQ = false;
			squeak.stop();
		}
	}
	
	void drawRoom1(Graphics g) {
		ladderR1.drawImg(g);
		door.setColor(Color.YELLOW);
		door.setName("DOOR");
		door.drawImg(g);
		obj1.setName("CHEST");
		obj1.drawImgTemp(g);
		chest.setName("OTHER CHEST");
		chest.drawImgTemp(g);
		mirror.setName("MIRROR");
		mirror.drawImgTemp(g);
		safe.setName("SAFE");
		safe.drawImg(g);
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
	}
	
	

	boolean isBetween(Character c, GameObject o) {
		if (c.x >= o.x - 10 && c.x + c.width <= o.x + o.width + 10) {
			return true;
		} else {
			return false;
		}
	}

	void introduction() {
		chara.movingState = "";
		JOptionPane.showMessageDialog(null, "You're STUCK.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "You found yourself inside this room, with no recollection of how you got here.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "The only thing you can do right now is figure out how to ESCAPE.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "[Press I for inventory. Press H for help.]", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "[Don't forget to double check things, too.]", "STUCK", JOptionPane.INFORMATION_MESSAGE);
	}
	
	String askQ(String question, String name) {
		String r = JOptionPane.showInputDialog(null, question, name, JOptionPane.INFORMATION_MESSAGE);
		if (r == null) {
			r = "";
		}
		return r;
	}

	
//THE GIANT CHECK METHOD-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	void check(InteractObject o) {
		chara.setMovingState("check");
		random = new Random();
		int rand = random.nextInt(3);
		//DOOR
		if (o.name.equals("DOOR")) {
			if(chara.hasKey) {
				JOptionPane.showMessageDialog(null, "You open your INVENTORY and take out the three small objects you've collected:\na PENCIL, a STICK, and a KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "Using way too much of the GLUE, you create a long object.\nAn extension of your arm, if you will.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "Using this object you created, you crouch under the DOOR and successfully sweep the small KEY towards you.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
				getObjectMethodNoKey(o);
				chara.hasKey = false;
				chara.openDoor = true;
			} else if (chara.openDoor) {
				dramaticMoment = true;
				JOptionPane.showMessageDialog(null, "You open the DOOR.", "", JOptionPane.INFORMATION_MESSAGE, icon);
				chara.roomState = 3;
			} else {
				if (mirrorCheck == 0 || !mirror.getObject) {
					JOptionPane.showMessageDialog(null, "The DOOR is locked.\nYou must find the KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
				} else {
					if (doorCheck == 0 && mirror.getObject) {
						JOptionPane.showMessageDialog(null, "The DOOR is locked.\nYou must find the KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
						JOptionPane.showMessageDialog(null, "You crouch down...\nThere's something under the door.", "STUCK?", JOptionPane.INFORMATION_MESSAGE, icon);
						JOptionPane.showMessageDialog(null, "It's the KEY. You try reaching for it, but your arm's not long enough.", "FOUND THE KEY", JOptionPane.INFORMATION_MESSAGE, icon);
						JOptionPane.showMessageDialog(null, "Maybe you could find or make something that could help you reach it.", "FOUND THE KEY", JOptionPane.INFORMATION_MESSAGE, icon);
						doorCheck++;
					} else {
						JOptionPane.showMessageDialog(null, "You need to find or make something to help you get the KEY.", "STUCK", JOptionPane.INFORMATION_MESSAGE, icon);
					}
				}
			}
		//SOFA
		} else if (o.name.equals("SOFA")) {
			if (sofaCheck == 0) {
				JOptionPane.showMessageDialog(null, "There's a joke book on the sofa.\nYou decide to look inside the book.", "SOFA", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "Inside the joke book, there's a quantum physics book.\nYou open it.", "SOFA", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "Inside the quantum physics book, there's another joke book.\nYou feel a strange sense of deja vu.", "SOFA", JOptionPane.INFORMATION_MESSAGE, icon);
				sofaCheck++;
			} else if (sofaCheck == 1 || !o.getObject) {
				JOptionPane.showMessageDialog(null, "You're reluctant to check the sofa again, but you see something wedged between the cushions.", "SOFA", JOptionPane.INFORMATION_MESSAGE, icon);
				getObjectMethodKeyPieces(o);
				sofaCheck++;
			} else if (sofaCheck > 1 && o.getObject){
				JOptionPane.showMessageDialog(null, "The joke book sits threateningly on the sofa. You decide to leave.", "SOFA", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		//HOLE IN THE WALL, BECAUSE I'M LAZY
		} else if (o.name.equals("HOLE IN THE WALL")) {
			getObjectMethodKeyPieces(o);
		//MIRROR
		} else if (o.name.equals("MIRROR")) {
			if (mirrorCheck == 0) {
				JOptionPane.showMessageDialog(null, "It's a mirror. You admire yourself in it.", "MIRROR", JOptionPane.INFORMATION_MESSAGE, icon);
				mirrorCheck++;
			} else {
				JOptionPane.showMessageDialog(null, "You notice something inside the frame of the mirror.", "MIRROR", JOptionPane.INFORMATION_MESSAGE, icon);
				getObjectMethodNoKey(o);
			}	
		//COMPUTER
		} else if (o.name.equals("COMPUTER")) {
			AudioClip beep = loadSound("beep.wav");
			beep.play();
			String passwordQ = askQ("ENTER 8-CHARACTER PASSWORD:\n\n\n\nHINT: most common password", "COMPUTER");
			if (passwordQ.equalsIgnoreCase(password) && !computerUnlocked) {
				JOptionPane.showMessageDialog(null, "You unlocked the COMPUTER.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "There's a message addressed to you.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "'hey __________! the combination to the safe is " + combination + ". the ___________ key's in there.'", "COMPUTER", JOptionPane.INFORMATION_MESSAGE, icon);
				computerUnlocked = true;
				JOptionPane.showMessageDialog(null, "'you don't need to enter the password to the computer again, by the way. just press enter or something. good luck!'", "COMPUTER", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (computerUnlocked) {
				JOptionPane.showMessageDialog(null, "You look at the message on the computer again.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "'hey __________! the combination to the safe is " + combination + ". there's a key in there.'", "COMPUTER", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (passwordQ.equals("")){
				JOptionPane.showMessageDialog(null, "You decide to try again later.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE, icon);
			} else {
				JOptionPane.showMessageDialog(null, "That's the wrong PASSWORD.", "COMPUTER", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		//SAFE
		} else if (o.name.equals("SAFE") && !safeUnlocked) {
			String combinationQ = askQ("ENTER COMBINATION", "SAFE");
			if (combinationQ.equals(combination)) {
				JOptionPane.showMessageDialog(null, "You hear a click and the door opens slightly.", "SAFE", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "Inside is a small KEY.", "SAFE", JOptionPane.INFORMATION_MESSAGE, icon);
				JOptionPane.showMessageDialog(null, "You don't remember what the KEY is for, though.", "SAFE", JOptionPane.INFORMATION_MESSAGE, icon);
				safeUnlocked = true;
				getObjectMethodKeyPieces(o);
			} else if (safeUnlocked){
				JOptionPane.showMessageDialog(null, "You look inside the safe again.", "SAFE", JOptionPane.INFORMATION_MESSAGE, icon);
				getObjectMethodKeyPieces(o);
			} else if (combinationQ.equals("")){
				JOptionPane.showMessageDialog(null, "You decide to try again later.", "SAFE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else {
				JOptionPane.showMessageDialog(null, "That's the wrong COMBINATION.", "SAFE", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		//LOCKED
		} else if (o.locked) {
			if (o.hasKey) {
				AudioClip eeee = loadSound("creak.wav");
				eeee.play();
				o.unlock();
				JOptionPane.showMessageDialog(null, "You unlocked the " + o.name + ".", "UNLOCKED", JOptionPane.INFORMATION_MESSAGE, icon);
				getObjectMethodNoKey(o);
			} else {
				if (rand == 0) {
					JOptionPane.showMessageDialog(null, "The " + o.name + " is locked.", "LOCKED", JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (rand == 1) {
					JOptionPane.showMessageDialog(null, "It's locked.", "LOCKED", JOptionPane.INFORMATION_MESSAGE, icon);
				} else if (rand == 2) {
					JOptionPane.showMessageDialog(null, "You need to find the key to the " + o.name + " to open it.", "LOCKED", JOptionPane.INFORMATION_MESSAGE, icon);
				}
			}
		//OBJECT ALREADY TAKEN
		} else if (o.objInside != null && o.objInside != "nothing" && o.getObject) {
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "You've already taken the " + o.objInside + ".", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.objInside + " is already inside your INVENTORY.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null,  "The " + o.objInside + " inside the " + o.name + " is already in your possession.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		//IT'S EMPTY
		AudioClip eeee = loadSound("creak.wav");
		eeee.play();
		} else if (o.objInside == null || o.objInside == "nothing"){
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "There's nothing inside.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.name + " is empty.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null, "The " + o.name + " contains nothing inside.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		//NORMAL CHECKING
		AudioClip eeee = loadSound("creak.wav");
		eeee.play();
		} else if (o.objInside != null && o.objInside != "nothing" && !o.getObject && !o.locked) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + " inside the " + o.name + ".", "INSIDE", 0, JOptionPane.INFORMATION_MESSAGE, icon, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQ == 1) {
				o.getObject = true;
				if (o.isKey) {
					o.hasKey = true;
				}
				if (o.name.equals("OTHER CHEST")) {
					chara.getGlue = true;
				}
			}
		}
		chara.setMovingState("");
	}
	
	void getObjectMethodNoKey(InteractObject o) {
		random = new Random();
		int rand = random.nextInt(3);
		if (o.objInside != null && o.objInside != "nothing" && !o.getObject && !o.locked && !o.name.equals("DOOR")) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + " inside the " + o.name + ".", "INSIDE", 0, JOptionPane.INFORMATION_MESSAGE, icon, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQ == 1) {
				o.getObject = true;
				if (o.name.equals("OTHER CHEST")) {
					chara.getGlue = true;
				}
			}
		} else if (o.objInside != null && o.objInside != "nothing" && !o.getObject && !o.locked && o.name.equals("DOOR")) {
			int checkQhmm = JOptionPane.showOptionDialog(null, "You find the " + o.objInside + " under the " + o.name + ".", "STUCK", 0, JOptionPane.INFORMATION_MESSAGE, icon, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQhmm == 1) {
				o.getObject = true;
			}
		} else if (o.objInside != null && o.objInside != "nothing" && o.getObject) {
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "You've already taken the " + o.objInside + ".", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.objInside + " is already inside your INVENTORY.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null,  "The " + o.objInside + " inside the " + o.name + " is already in your possession.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		}
	}
	
	void getObjectMethodKeyPieces(InteractObject o) {
		random = new Random();
		int rand = random.nextInt(3);
		if (o.objInside != null && o.objInside != "nothing" && !o.getObject && !o.locked) {
			int checkQ = JOptionPane.showOptionDialog(null, "You find a " + o.objInside + " inside the " + o.name + ".", "INSIDE", 0, JOptionPane.INFORMATION_MESSAGE, icon, new String[] {"DON'T", "TAKE IT"}, null);
			if (checkQ == 1) {
				o.getObject = true;
				chara.keyPieces++;
			}
		} else if (o.objInside != null && o.objInside != "nothing" && o.getObject) {
			if (rand == 0) {
				JOptionPane.showMessageDialog(null, "You've already taken the " + o.objInside + ".", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (rand == 1) {
				JOptionPane.showMessageDialog(null, "The " + o.objInside + " is already inside your INVENTORY.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (rand == 2) {
				JOptionPane.showMessageDialog(null,  "The " + o.objInside + " inside the " + o.name + " is already in your possession.", "INSIDE", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		}
	}
}
