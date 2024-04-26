import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class RedItem2 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public RedItem2(StateManager stateManager) {
		super("Red");
		addActionListener(new RedItemListener2());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class RedItemListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mediator.setLineColor(Color.red);
				
			mediator.repaint();
		}
	}
}
