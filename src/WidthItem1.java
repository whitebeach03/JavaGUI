import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class WidthItem1 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	public WidthItem1(StateManager stateManager) {
		super("1");
		addActionListener(new WidthItem1Listener());
		this.stateManager = stateManager;
	}
	
	class WidthItem1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.mediator.setLineWidth(1);
			stateManager.mediator.repaint();
		}
	}
}
