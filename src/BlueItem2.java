import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class BlueItem2 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	
	public BlueItem2(StateManager stateManager) {
		super("Blue");
		addActionListener(new BlueItemListener2());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class BlueItemListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mediator.setLineColor(Color.blue);
			
			mediator.repaint();
		}
	}
}
