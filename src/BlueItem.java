import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class BlueItem extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public BlueItem(StateManager stateManager) {
		super("Blue");
		addActionListener(new BlueItemListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class BlueItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (mediator.getAlpha()) {
				mediator.setFillColor(new Color(0, 0, 255, mediator.getAlphaNum()));
			}
			else {
				mediator.setFillColor(Color.blue);
			}
			mediator.repaint();
		}
	}
}
