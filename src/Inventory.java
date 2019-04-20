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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inventory {
	JFrame frame;
	JFrame hFrame;
	JPanel panel;
	JPanel hPanel;
	JLabel hLabel;
	boolean added = false;
	
	ImageIcon icon;
	
	Inventory(){
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("INVENTORY");
		icon = new ImageIcon(this.getClass().getClassLoader().getResource("icon.png"));
	}
	
	void popUp() {
		if (panel.getComponentCount() == 0) {
			JOptionPane.showMessageDialog(null, "Your INVENTORY is empty.", "INVENTORY", JOptionPane.INFORMATION_MESSAGE, icon);
		} else {
			frame.setVisible(true);
		}
	}
	
	void isItChecked(InteractObject a) {
		if (a.getObject && added == false) {
			panel.add(a.invObject);
			frame.pack();
		}
	}
	
	void help() {
		hFrame = new JFrame();
		hPanel = new JPanel();
		hFrame.add(hPanel);
		hFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		hFrame.setTitle("HELP");
		try {
			hLabel = createLabelImage("help.png");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hPanel.add(hLabel);
		hFrame.pack();
		JOptionPane.showMessageDialog(null, "You reach into your pocket and draw out a slip of paper.", "HELP", JOptionPane.INFORMATION_MESSAGE);
		hFrame.setVisible(true);
		JOptionPane.showMessageDialog(null, "[Don't forget to double check things, too.]", "HELP", JOptionPane.INFORMATION_MESSAGE);
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
