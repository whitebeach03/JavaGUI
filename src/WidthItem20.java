import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class WidthItem20 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public WidthItem20(StateManager stateManager) {
		super("20");
		addActionListener(new WidthItem20Listener());
		this.stateManager = stateManager;
	}
	
	class WidthItem20Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.mediator.setLineWidth(20);
			stateManager.mediator.repaint();
		}
	}
}
