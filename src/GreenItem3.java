import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class GreenItem3 extends JMenuItem {
	MyCanvas canvas;
	StateManager stateManager;
	Mediator mediator;
	
	public GreenItem3(StateManager stateManager) {
		super("Green");
		addActionListener(new GreenItemListener3());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		canvas = mediator.canvas;
	}
	
	class GreenItemListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.green);
			mediator.repaint();
		}
	}
}
