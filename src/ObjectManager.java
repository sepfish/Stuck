import java.awt.Graphics;

public class ObjectManager {
	Character chara;
	InteractObject obj1;
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
		ladderR2.draw(g);
		chara.draw(g);
	}
	
	
	void drawInteractObjects() {
		obj1 = new InteractObject(200, 360, 80, 120);
		ladderR1 = new Ladder(750, 0, 80, 450);
	}
	
	void drawInteractObjectsR2() {
		ladderR2 = new Ladder(750, 450, 80, 150);
	}
	
	boolean isBetween(Character c, GameObject o) {
		if (c.x >= o.x && c.x <= o.x + o.width) {
			return true;
		} else {
			return false;
		}
	}
}
