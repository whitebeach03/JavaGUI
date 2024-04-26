import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class RedItem3 extends JMenuItem {
	MyCanvas canvas;
	StateManager stateManager;
	Mediator mediator;
	
	public RedItem3(StateManager stateManager) {
		super("Red");
		addActionListener(new RedItemListener3());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		canvas = mediator.canvas;
	}
	
	class RedItemListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.red);
			mediator.repaint();
		}
	}
}
