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
	public static BufferedImage right1;
	public static BufferedImage right2;

	Character(int x, int y, int width, int height) {
		super(x, y, width, height, Color.BLACK);
		// TODO Auto-generated constructor stub
		
		try {
			stand = ImageIO.read(this.getClass().getResourceAsStream("IMG_0602.png"));
			right1 = ImageIO.read(this.getClass().getResourceAsStream("IMG_0604.png"));
			right2 = ImageIO.read(this.getClass().getResourceAsStream("IMG_0606.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setY(int y) {
		this.y = y;
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
		if (movingState.equals("")) {
			walkCount++;
		}
	}
	
	void keyPieceCheck() {
		if (keyPieces == 3 && getGlue && !getAllPieces) {
			getAllPieces = true;
			JOptionPane.showMessageDialog(null, "YAY YOU GOT EVERYTHING NOW DO SOMETHING ABOUT IT");
			hasKey = true;
		}
	}
	
	void draw(Graphics g) {
			if (movingState.equals("")) {
				drawImg(g, stand);
			} else if (movingState == "right") {
				if (walkCount/10 % 3 == 0) {
					drawImg(g, right1);
				} else if (walkCount/10 % 3 == 1) {
					drawImg(g, right2);
				} else if (walkCount/10 % 3 == 2) {
					g.setColor(Color.YELLOW);
					g.fillRect(x, y, width, height);
				}
				
			} else if (movingState == "left") {
				if (walkCount/10 % 3 == 0) {
					g.setColor(Color.GREEN);
				} else if (walkCount/10 % 3 == 1) {
					g.setColor(Color.BLUE);
				} else if (walkCount/10 % 3 == 2) {
					g.setColor(Color.PINK);
				}
				g.fillRect(x, y, width, height);
			} else if (movingState == "down") {
				if (walkCount/10 % 3 == 0) {
					g.setColor(Color.RED);
				} else if (walkCount/10 % 3 == 1) {
					g.setColor(Color.YELLOW);
				} else if (walkCount/10 % 3 == 2) {
					g.setColor(Color.BLUE);
				}
				g.fillRect(x, y, width, height);
			} else if (movingState == "up") {
				if (walkCount/10 % 3 == 0) {
					g.setColor(Color.ORANGE);
				} else if (walkCount/10 % 3 == 1) {
					g.setColor(Color.GREEN);
				} else if (walkCount/10 % 3 == 2) {
					g.setColor(Color.PINK);
				}
				g.fillRect(x, y, width, height);
			}
	}

}
