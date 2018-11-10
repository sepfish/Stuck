import java.awt.Color;
import java.awt.Graphics;

public class InteractObject extends GameObject{

	InteractObject(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
	}
	
	void draw(Graphics g) {
		checkIfChecked(g);
		if (isChecked == false) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
}

