import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class YellowItem2 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public YellowItem2(StateManager stateManager) {
		super("Yellow");
		addActionListener(new YellowItemListener2());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class YellowItemListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mediator.setLineColor(Color.yellow);
			
			mediator.repaint();
		}
	}
}
