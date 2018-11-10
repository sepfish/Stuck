import java.awt.Graphics;

public class ObjectManager {
	Character chara;
	InteractObject obj1;
	
	ObjectManager(Character c){
		chara = c;
		drawInteractObjects();
	}
	
	void update() {
		obj1.update();
		chara.update();
	}
	
	void drawRoom1(Graphics g) {
		obj1.draw(g);
		chara.draw(g);
	}
	
	void drawRoom2(Graphics g) {
		chara.draw(g);
	}
	
	
	void drawInteractObjects() {
		obj1 = new InteractObject(200, 460, 80, 120);
	}
	
	boolean isBetween(Character c, InteractObject o) {
		if (c.x >= o.x && c.x <= o.x + o.width) {
			return true;
		} else {
			return false;
		}
	}
}
