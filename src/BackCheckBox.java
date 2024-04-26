import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class BackCheckBox extends JCheckBox {
	StateManager stateManager;
	Mediator mediator;
	
	public BackCheckBox(StateManager stateManager) {
		super("To Back");
		addItemListener(new BackCheckListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class BackCheckListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			if (state == ItemEvent.SELECTED) {
				mediator.setBack(true);
			}
			else {
				mediator.setBack(false);
			}
		}
	}
}
