import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject{

	Character(int x, int y, int width, int height) {
		super(x, y, width, height, Color.BLACK);
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
			if (y == 50) {
				roomState = 2;
			} else if (y > 0) {
				y -= 3;
			}
		}
		if (movingState.equals("down")) {
			if (roomState == 1) {
				if (y < 350) {
					y += 3;
			} else if (roomState == 2) {
				if (y < 500) {
					y += 3;
				}	
			}
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
