import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ladder extends GameObject{
	String fileName;
	BufferedImage ladderImg;

	Ladder(int x, int y, int width, int height) {
		super(x, y, width, height, Color.CYAN);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		
	}
	
	void draw(Graphics g) {
		 g.setColor(Color.CYAN);
	     g.fillRect(x, y, width, height); 
	}
	
	void drawImg(Graphics g) {
		if (ladderImg != null) {
			g.drawImage(ladderImg, x, y, width, height, null);
		} else {
			draw(g);
		}
	}
	
	void setImg(String fileName) {
		this.fileName = fileName;
		try {
			this.ladderImg = ImageIO.read(this.getClass().getResourceAsStream(fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
