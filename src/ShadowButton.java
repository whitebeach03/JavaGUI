import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ShadowButton extends JButton {
	StateManager stateManager;
	Mediator mediator;
	boolean shadow = false;
	
	
	public ShadowButton(StateManager stateManager) {
		super("Shadow");
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		addActionListener(new ShadowListener());
	}
	
	class ShadowListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (mediator.selectedDrawings != null) {
				mediator.copy();
				mediator.setFillColor(Color.black);
				mediator.setLineColor(Color.black);
				mediator.paste(mediator.selectedDrawings.get(0).x - 10, mediator.selectedDrawings.get(0).y - 10);
			}
			mediator.repaint();
		}
	}
}
