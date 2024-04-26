import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class WidthItem15 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	public WidthItem15(StateManager stateManager) {
		super("15");
		addActionListener(new WidthItem15Listener());
		this.stateManager = stateManager;
	}
	
	class WidthItem15Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.mediator.setLineWidth(15);
			stateManager.mediator.repaint();
		}
	}
}
