import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InteractObject extends GameObject{
	String objInside;
	String name;
	String insideFile;
	String fileName;
	JLabel invObject;
	boolean getObject = false;
	boolean locked = false;
	static boolean hasKey = false;
	boolean isKey = false;
	int floorNumber;
	
	public BufferedImage objImg;
	public BufferedImage objImgCheck;
	
	InteractObject(int x, int y, int width, int height) {
		super(x, y, width, height, Color.GREEN);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
	}
		
	void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(x, y, width, height);

	}
	
	void drawImg(Graphics g) {
		if (objImg != null) {
			g.drawImage(objImg, x, y, width, height, null);
		} else {
			draw(g);
		}
	}
	
	void drawImgTemp(Graphics g) {
		if (objImg != null && isChecked == false) {
			g.drawImage(objImg, x, y, width, height, null);
		} else if (objImg != null && isChecked && objImgCheck != null && !locked) {
			g.drawImage(objImgCheck, x, y, width, height, null);
		} else {
			drawImg(g);
		}
	}
	
	Color getColor() {
		if (isChecked) {
			return Color.RED;
		} else {
			return color;
		}
	}
	
	void setColor(Color color) {
		if (color != Color.RED) {
			this.color = color;
		} else {
			System.out.println("NOO!!");
		}
	}
	
	void setInside(String s, String fileName, String insideFile, String checkFile, int floorNum, boolean isKey) {
		floorNumber = floorNum;
		this.isKey = isKey;
		objInside = s;
		this.insideFile = insideFile;
		this.fileName = fileName;
		try {
			invObject = createLabelImage(fileName);
			invObject.setToolTipText(objInside);
			this.objImg = ImageIO.read(this.getClass().getResourceAsStream(insideFile));
			this.objImgCheck = ImageIO.read(this.getClass().getResourceAsStream(checkFile));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void lock() {
		locked = true;
	}
	
	void unlock() {
		locked = false;
	}
	
	public JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

}

