import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	String movingState = "";
	
	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		if (movingState.equals("left")) {
			x--;
		}
		if (movingState.equals("right")) {
			x++;
		}
	}
	
	void draw(Graphics g) {
		g.fillRect(10, 10, x, y);
	}
}
