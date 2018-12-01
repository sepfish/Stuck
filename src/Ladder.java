import java.awt.Color;
import java.awt.Graphics;

public class Ladder extends GameObject{

	Ladder(int x, int y, int width, int height) {
		super(x, y, width, height, Color.CYAN);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		
	}
	
	void draw(Graphics g) {
		 g.setColor(Color.CYAN);
	     g.fillRect(x, y, width, height); 
	}


}
