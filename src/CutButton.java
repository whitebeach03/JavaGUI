import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CutButton extends JButton {
	StateManager stateManager;
	
	public CutButton(StateManager stateManager) {
		super("Cut");		
		addActionListener(new CutListener());
		this.stateManager = stateManager;
	}
	
	class CutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.mediator.cut();
			stateManager.mediator.repaint();
		}
	}
}
