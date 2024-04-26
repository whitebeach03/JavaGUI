import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class YellowItem extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public YellowItem(StateManager stateManager) {
		super("Yellow");
		addActionListener(new YellowItemListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class YellowItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (mediator.getAlpha()) {
				mediator.setFillColor(new Color(255, 255, 0, mediator.getAlphaNum()));
			}
			else {
				mediator.setFillColor(Color.yellow);
			}
			mediator.repaint();
		}
	}
}
