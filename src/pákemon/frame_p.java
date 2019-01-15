package pákemon;

import javax.swing.JFrame;

public class frame_p {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		action_p g = new action_p();
		frame.setSize(695, 647);
		frame.setTitle("Pákemon");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(g);

	}
}
