import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inventory {
	JFrame frame;
	JPanel panel;
	boolean added = false;
	JButton experimental = new JButton();
	JLabel picture;
	
	Inventory(){
		frame = new JFrame();
		panel = new JPanel();
		picture = new JLabel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("INVENTORY");
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
	
	void popUp() {
		frame.setVisible(true);
	}
	
	void isItChecked(InteractObject a) {
		if (a.getObject && added == false) {
			try {
				picture = createLabelImage("Untitled.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.add(picture);
			frame.pack();
		}
	}
}
