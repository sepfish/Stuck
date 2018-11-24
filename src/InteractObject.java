import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class InteractObject extends GameObject{
	String objInside;

	InteractObject(int x, int y, int width, int height) {
		super(x, y, width, height, Color.BLUE);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
	}
	
	void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(x, y, width, height);

	}
	
	Color getColor() {
		if (isChecked) {
			return Color.RED;
		} else {
			return color;
		}
	}
	
	void setInside(String s) {
		objInside = s;
	}
}

