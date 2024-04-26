import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class WhiteItem2 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public WhiteItem2(StateManager stateManager) {
		super("White");
		addActionListener(new WhiteItemListener2());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class WhiteItemListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mediator.setLineColor(Color.white);
				
			mediator.repaint();
		}
	}
}
