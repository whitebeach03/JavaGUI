import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

public class DeleteButton extends JButton {
	StateManager stateManager;
	Mediator mediator;
	Vector<MyDrawing> selectedDrawings;
	
	public DeleteButton(StateManager stateManager) {
		super("Delete");		
		addActionListener(new DeleteListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		selectedDrawings = mediator.selectedDrawings;
	}
	
	class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.mediator.removeDrawing(selectedDrawings);
			stateManager.mediator.repaint();
		}
	}
}
