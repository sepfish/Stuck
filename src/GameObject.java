import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	String movingState = "";
	Boolean isChecked = false;
	
	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		}
	
	void draw(Graphics g) {
	}
	
	void checkIfChecked(Graphics g) {
		if (isChecked) {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
			isChecked = false;
			JOptionPane.showMessageDialog(null, "Hi");
		}
	}
}
