import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class WhiteItem extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public WhiteItem(StateManager stateManager) {
		super("White");
		addActionListener(new WhiteItemListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class WhiteItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (mediator.getAlpha()) {
				mediator.setFillColor(new Color(255, 255, 255, mediator.getAlphaNum()));
			}
			else {
				mediator.setFillColor(Color.white);
			}
			mediator.repaint();
		}
	}
}
