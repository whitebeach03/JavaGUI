import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class GreenItem2 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public GreenItem2(StateManager stateManager) {
		super("Green");
		addActionListener(new GreenItemListener2());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class GreenItemListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mediator.setLineColor(Color.green);
			
			mediator.repaint();
		}
	}
}
