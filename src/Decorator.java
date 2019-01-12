import java.awt.Graphics;

public class Decorator {
	InteractObject clock;
	InteractObject bookshelf;
	InteractObject lamp;

	Decorator(){
		clock = new InteractObject(360, 175, 50, 50);
		bookshelf = new InteractObject(135, 200, 100, 40);
		lamp = new InteractObject(255, 400, 50, 120);
	}
	
	//floor number set to 0 because I don't want them to get checked anyway
	void drawR1(Graphics g) {
		clock.setInside("nothing", "clock.png", "clock2.png", 0, false);
		clock.drawImg(g);
		bookshelf.setInside("nothing", "bookshelf.png", "bookshelf.png", 0, false);
		bookshelf.drawImg(g);
	}
	
	void drawR2(Graphics g) {
		lamp.setInside("nothing", "lamp.png", "lamp.png", 0, false);
		lamp.drawImg(g);
	}
}
