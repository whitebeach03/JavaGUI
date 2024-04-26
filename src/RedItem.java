import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class RedItem extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public RedItem(StateManager stateManager) {
		super("Red");
		addActionListener(new RedItemListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class RedItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (mediator.getAlpha()) {
				mediator.setFillColor(new Color(255, 0, 0, mediator.getAlphaNum()));
			}
			else {
				mediator.setFillColor(Color.red);
			}
			mediator.repaint();
		}
	}
}
