import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject{
	boolean justArrived;
	boolean hasKey = false;
	String charaState = "stand";

	Character(int x, int y, int width, int height) {
		super(x, y, width, height, Color.BLACK);
		// TODO Auto-generated constructor stub
	}
	
	void setY(int y) {
		this.y = y;
	}
	
	void update() {
		if (movingState.equals("left")) {
			charaState = "walkLeft";
			if (x > 150 && y >= 350) {
					x -= 4;
			}
		}
		if (movingState.equals("right")) {
			charaState = "walkRight";
			if (x < 800) {
				x += 4;
			}
		}
		if (movingState.equals("up")) {
			charaState = "climbUp";
			if (y < 50) {
				roomState = 2;
			} else if (y > 0) {
				y -= 4;
			}
		}
		if (movingState.equals("down")) {
			charaState = "climbDown";
			if (y < 350) {
				y += 4;
			} else if (y >= 350) {
				if (roomState == 2) {
					roomState = 1;
					justArrived = true;
				}
			}
		}
		if (movingState.equals("")) {
			charaState = "stand";
		}
	}
	
	void draw(Graphics g) {
		if (charaState == "stand") {
			g.setColor(Color.GRAY);
		} else if (charaState == "walkLeft") {
			g.setColor(Color.DARK_GRAY);
		} else if (charaState == "walkRight") {
			g.setColor(Color.BLACK);
		} else if (charaState == "climbUp") {
			g.setColor(Color.ORANGE);
		} else if (charaState == "climbDown") {
			g.setColor(Color.PINK);
		}
		g.fillRect(x, y, width, height);
	}

}
