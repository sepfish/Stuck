import java.awt.Dimension;

import javax.swing.JFrame;

public class Stuck {
	JFrame window;
	final static int width = 1000;
	final static int height = 800;
	GamePanel panel;
	
	Stuck() {
		window = new JFrame();
		panel = new GamePanel();
	} 
	
	public static void main(String[] args) {
		Stuck game = new Stuck();
		game.setup();
	}
	
	void setup() {
		window.add(panel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.getContentPane().setPreferredSize(new Dimension(width, height));
        window.pack();
        window.addKeyListener(panel);
        panel.startGame();
	}
}
