import java.awt.Graphics;

public class Decorator {
	InteractObject clock;
	InteractObject bookshelf;
	InteractObject lamp;
	InteractObject painting;
	InteractObject pgo;
	InteractObject chair;
	InteractObject pframe;

	Decorator(){
		clock = new InteractObject(360, 175, 50, 50);
		bookshelf = new InteractObject(135, 200, 100, 40);
		lamp = new InteractObject(255, 400, 50, 120);
		painting = new InteractObject(415, 305, 75, 100);
		pgo = new InteractObject(835, 485, 40, 40);
		chair = new InteractObject(340, 460, 50, 70);
		pframe = new InteractObject(655, 435, 25, 30);
		//room 1
		clock.setInside("nothing", "clock.png", "clock2.png", "", 0, false);
		bookshelf.setInside("nothing", "bookshelf.png", "bookshelf.png", "", 0, false);
		//room 2
		painting.setInside("nothing", "ib.png", "ib.png", "", 0, false);
		lamp.setInside("nothing", "lamp.png", "lamp.png", "", 0, false);
		pgo.setInside("nothing", "pgo.png", "pgo.png", "", 0, false);
		chair.setInside("nothing", "chair.png", "chair.png", "", 0, false);
	}
	
	//floor number set to 0 because I don't want them to get checked anyway
	void drawR1(Graphics g) {
		clock.drawImg(g);
		bookshelf.drawImg(g);
	}
	
	void drawR2(Graphics g) {
		lamp.drawImg(g);
		painting.drawImg(g);
		pgo.drawImg(g);
		chair.drawImg(g);
		pframe.drawImg(g);
	}
}
