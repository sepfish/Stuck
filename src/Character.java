import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject{
	Boolean isClimbing = false;

	Character(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		if (movingState.equals("left")) {
			if (x > 150) {
				x -= 3;
			}
		}
		if (movingState.equals("right")) {
			if (x < 800) {
				x += 3;
			}
		}
		if (movingState.equals("up")) {
			if (y > 30) {
				y -= 3;
			}
		}
		if (movingState.equals("down")) {
			if (y < 500) {
				y += 3;
			}
		}
	}
	
	void setY(int y) {
		this.y = y;
	}
	
	void jump() {
	}
	
	void draw(Graphics g) {
		 g.setColor(Color.BLACK);
	     g.fillRect(x, y, width, height);
	}

}
