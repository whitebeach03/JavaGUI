import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CopyButton extends JButton {
	StateManager stateManager;
	
	public CopyButton(StateManager stateManager) {
		super("Copy");		
		addActionListener(new CopyListener());
		this.stateManager = stateManager;
	}
	
	class CopyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.mediator.copy();
			stateManager.mediator.repaint();
		}
	}
}
