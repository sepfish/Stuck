import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InteractObject extends GameObject{
	String objInside;
	String name;
	JLabel invObject;
	Boolean getObject = false;
	Boolean locked = false;

	InteractObject(int x, int y, int width, int height) {
		super(x, y, width, height, Color.BLUE);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
	}
		
	void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(x, y, width, height);

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
	
	void setInside(String s, String fileName) {
		objInside = s;
		try {
			invObject = createLabelImage(fileName);
		} catch (MalformedURLException e) {
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

