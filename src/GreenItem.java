import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class GreenItem extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public GreenItem(StateManager stateManager) {
		super("Green");
		addActionListener(new GreenItemListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class GreenItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (mediator.getAlpha()) {
				mediator.setFillColor(new Color(0, 255, 0, mediator.getAlphaNum()));
			}
			else {
				mediator.setFillColor(Color.green);
			}
			mediator.repaint();
		}
	}
}
