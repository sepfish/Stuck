import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	String movingState = "";
	int roomState = 1;
	Boolean isChecked = false;
	Color color;
	
	GameObject(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	void update() {
		}
	
	void draw(Graphics g) {
	}
	
	void setColor(Color c) {
		this.color = c;
	}
	
	Color getColor() {
		return color;
	}
	
}
