import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class WidthItem10 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public WidthItem10(StateManager stateManager) {
		super("10");
		addActionListener(new WidthItem10Listener());
		this.stateManager = stateManager;
	}
	
	class WidthItem10Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.mediator.setLineWidth(10);
			stateManager.mediator.repaint();
		}
	}
}
