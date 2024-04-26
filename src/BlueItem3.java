import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class BlueItem3 extends JMenuItem {
	MyCanvas canvas;
	StateManager stateManager;
	Mediator mediator;
	
	public BlueItem3(StateManager stateManager) {
		super("Blue");
		addActionListener(new BlueItemListener3());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		canvas = mediator.canvas;
	}
	
	class BlueItemListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.blue);	
			mediator.repaint();
		}
	}
}
