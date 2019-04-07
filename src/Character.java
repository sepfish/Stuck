import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Character extends GameObject{
	boolean justArrived;
	boolean hasKey = false;
	boolean openDoor = false;
	int walkCount = 0;
	int keyPieces = 0;
	boolean getGlue = false;
	boolean getAllPieces = false;
	
	public static BufferedImage stand;
	public static BufferedImage back;
	public static BufferedImage right1;
	public static BufferedImage right2;
	public static BufferedImage right3;
	public static BufferedImage climb1;
	public static BufferedImage climb2;
	public static BufferedImage left1;
	public static BufferedImage left2;
	public static BufferedImage left3;
	

	Character(int x, int y, int width, int height) {
		super(x, y, width, height, Color.BLACK);
		// TODO Auto-generated constructor stub
		
		try {
			stand = ImageIO.read(this.getClass().getResourceAsStream("IMG_0602.png"));
			back = ImageIO.read(this.getClass().getResourceAsStream("back.png"));
			right1 = ImageIO.read(this.getClass().getResourceAsStream("IMG_0604.png"));
			right2 = ImageIO.read(this.getClass().getResourceAsStream("IMG_0606.PNG"));
			right3 = ImageIO.read(this.getClass().getResourceAsStream("right.png"));
			climb1 = ImageIO.read(this.getClass().getResourceAsStream("back1.png"));
			climb2 = ImageIO.read(this.getClass().getResourceAsStream("back2.png"));
			left1 = ImageIO.read(this.getClass().getResourceAsStream("left.png"));
			left2 = ImageIO.read(this.getClass().getResourceAsStream("left1.png"));
			left3 = ImageIO.read(this.getClass().getResourceAsStream("left2.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setY(int y) {
		this.y = y;
	}
	
	void setMovingState(String mov) {
		movingState = mov;
	}
	
	
	void drawImg(Graphics g, BufferedImage img) {
		if (img != null) {
			g.drawImage(img, x, y, width, height, null);
		}
	}
	
	void update() {
		keyPieceCheck();
		if (movingState.equals("left")) {
			if (x > 150 && y >= 350) {
				x -= 3;
				walkCount++;
			}
		}
		if (movingState.equals("right")) {
			if (x < 800) {
				if (roomState == 1 && y >= 350) {
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
	}
	
	void keyPieceCheck() {
		if (keyPieces == 3 && getGlue && !getAllPieces) {
			getAllPieces = true;
			hasKey = true;
		}
	}
	
	void draw(Graphics g) {
			if (movingState.equals("")) {
				drawImg(g, stand);
			} else if (movingState == "right") {
				if (walkCount/9 % 4 == 0) {
					drawImg(g, right1);
				} else if (walkCount/9 % 4 == 1) {
					drawImg(g, right2);
				} else if (walkCount/9 % 4 == 2) {
					drawImg(g, right1);
				} else if (walkCount/9 % 4 == 3) {
					drawImg(g, right3);
				}
			} else if (movingState == "left") {
				if (walkCount/9 % 4 == 0) {
					drawImg(g, left1);
				} else if (walkCount/9 % 4 == 1) {
					drawImg(g, left2);
				} else if (walkCount/9 % 4 == 2) {
					drawImg(g, left1);
				} else if (walkCount/9 % 4 == 3) {
					drawImg(g, left3);
				}
			} else if (movingState == "down") {
				if (walkCount/9 % 4 == 0) {
					drawImg(g, climb1);
				} else if (walkCount/9 % 4 == 1) {
					drawImg(g, back);
				} else if (walkCount/9 % 4 == 2) {
					drawImg(g, climb2);
				} else if (walkCount/9 % 4 == 3) {
					drawImg(g, back);
				}
			} else if (movingState == "up") {
				if (walkCount/9 % 4 == 0) {
					drawImg(g, climb2);
				} else if (walkCount/9 % 4 == 1) {
					drawImg(g, back);
				} else if (walkCount/9 % 4 == 2) {
					drawImg(g, climb1);
				} else if (walkCount/9 % 4 == 3) {
					drawImg(g, back);
				}
			} else if (movingState == "check") {
				drawImg(g, back);
			}
	}

}
