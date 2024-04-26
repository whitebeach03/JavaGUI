import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class WidthItem5 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public WidthItem5(StateManager stateManager) {
		super("5");
		addActionListener(new WidthItem5Listener());
		this.stateManager = stateManager;
	}
	
	class WidthItem5Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.mediator.setLineWidth(5);
			stateManager.mediator.repaint();
		}
	}
}
