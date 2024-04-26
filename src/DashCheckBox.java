import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class DashCheckBox extends JCheckBox {
	StateManager stateManager;
	Mediator mediator;
	float dash1[] = {10.0f, 3.0f};
	float dash2[] = {10.0f, 0};
	
	public DashCheckBox(StateManager stateManager) {
		super("Dash");
		addItemListener(new DashCheckListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class DashCheckListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			
			if (state == ItemEvent.SELECTED) {
				for (MyDrawing d: mediator.selectedDrawings) {
					d.setDash(dash1);
				}
				mediator.repaint();
			}
			else {
				for (MyDrawing d: mediator.selectedDrawings) {
					d.setDash(dash2);
				}
				mediator.repaint();
			}
		}
	}
}
