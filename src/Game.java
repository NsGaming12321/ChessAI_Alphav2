import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game {
	// create jframe
	static JFrame f = new JFrame("hi");
	// create main object
	static Main main = new Main();
	// create a mouselistener object from the class
	static MyMouseListener mml = new MyMouseListener();

	// main method
	public static void main(String[] args) {
		// basic jframe paramters
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setLayout(new BorderLayout());
		f.add(Game.main, BorderLayout.CENTER);
		f.setTitle("Marco");
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.addMouseListener(mml);

	}

}
