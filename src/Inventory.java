import javax.swing.JFrame;
import javax.swing.JPanel;

public class Inventory {
	JFrame frame;
	JPanel panel;
	
	Inventory(){
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
