import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class FrontCheckBox extends JCheckBox {
	StateManager stateManager;
	Mediator mediator;
	
	public FrontCheckBox(StateManager stateManager) {
		super("To Front");
		addItemListener(new FrontCheckListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class FrontCheckListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			if (state == ItemEvent.SELECTED) {
				mediator.setFront(true);
			}
			else {
				mediator.setFront(false);
			}
		}
	}
}
