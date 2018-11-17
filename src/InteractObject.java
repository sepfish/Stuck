import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class InteractObject extends GameObject{

	InteractObject(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
	}
	
	void draw(Graphics g) {
		System.out.println(isChecked);
		if (isChecked == false) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		} else if (isChecked) {
			isOpen = true;
			isChecked = false;
			int checkQ = JOptionPane.showOptionDialog(null, "You find a Something.", "Drawer", 0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"Don't", "Take it"}, null);
			if (checkQ == 1) {
				System.out.println("yay");
			}
		if (isOpen) {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}
		}
	}
	
	public boolean isItChecked() {
		return isChecked;
	}
	
	public void setIsChecked(Boolean b) {
		isChecked = b;
	}
}

