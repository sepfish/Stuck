import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject{
	boolean justArrived;
	boolean hasKey = false;
	int walkCount = 0;

	Character(int x, int y, int width, int height) {
		super(x, y, width, height, Color.BLACK);
		// TODO Auto-generated constructor stub
	}
	
	void setY(int y) {
		this.y = y;
	}
	
	void update() {
		if (movingState.equals("left")) {
			if (x > 150 && y >= 350) {
				x -= 3;
				walkCount++;
			}
		}
		if (movingState.equals("right")) {
			if (x < 800) {
				if (roomState == 1 && y == 350) {
					x += 3;
				} else if (roomState == 2) {
					x += 3;
				}
				walkCount++;
			}
		}
		if (movingState.equals("up")) {
			if (y < 25) {
				roomState = 2;
			} else if (y > 0) {
				y -= 3;
			}
			walkCount++;
		}
		if (movingState.equals("down")) {
			if (y < 350) {
				y += 3;
			} else if (roomState == 2) {
				if (y >= 500) {
					roomState = 1;
					justArrived = true;
				} else {
					y += 3;
				}
			}
			walkCount++;
		}
		if (movingState.equals("")) {
			walkCount++;
		}
	}
	
	void draw(Graphics g) {
		if (movingState.equals("")) {
			if (walkCount/10 % 2 == 0) {
				g.setColor(Color.DARK_GRAY);
			} else if (walkCount/10 % 2 == 1) {
				g.setColor(Color.LIGHT_GRAY);
			}
		} else if (movingState == "left") {
			if (walkCount/10 % 3 == 0) {
				g.setColor(Color.RED);
			} else if (walkCount/10 % 3 == 1) {
				g.setColor(Color.ORANGE);
			} else if (walkCount/10 % 3 == 2) {
				g.setColor(Color.YELLOW);
			}
		} else if (movingState == "right") {
			if (walkCount/10 % 3 == 0) {
				g.setColor(Color.GREEN);
			} else if (walkCount/10 % 3 == 1) {
				g.setColor(Color.BLUE);
			} else if (walkCount/10 % 3 == 2) {
				g.setColor(Color.PINK);
			}
		} else if (movingState == "up") {
			if (walkCount/10 % 3 == 0) {
				g.setColor(Color.RED);
			} else if (walkCount/10 % 3 == 1) {
				g.setColor(Color.YELLOW);
			} else if (walkCount/10 % 3 == 2) {
				g.setColor(Color.BLUE);
			}
		} else if (movingState == "down") {
			if (walkCount/10 % 3 == 0) {
				g.setColor(Color.ORANGE);
			} else if (walkCount/10 % 3 == 1) {
				g.setColor(Color.GREEN);
			} else if (walkCount/10 % 3 == 2) {
				g.setColor(Color.PINK);
			}
		}
		g.fillRect(x, y, width, height);
	}

}
