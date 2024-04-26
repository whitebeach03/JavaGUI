import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class AlphaCheckBox extends JCheckBox { 
	StateManager stateManager;
	Mediator mediator;
	
	public AlphaCheckBox(StateManager stateManager) {
		super("α-Channel");
		addItemListener(new AlphaCheckListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class AlphaCheckListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			if (state == ItemEvent.SELECTED) {
				mediator.setAlpha(true);
				for (MyDrawing d: mediator.selectedDrawings) {
					int r = d.fillColor.getRed();
					int g = d.fillColor.getGreen();
					int b = d.fillColor.getBlue();
					
					d.setFillColor(new Color(r, g, b, mediator.getAlphaNum()));
				}
				mediator.repaint();
			}
			else {
				mediator.setAlpha(false);
				
				for (MyDrawing d: mediator.selectedDrawings) {
					int r = d.fillColor.getRed();
					int g = d.fillColor.getGreen();
					int b = d.fillColor.getBlue();
					
					d.setFillColor(new Color(r, g, b, 255));
				}
				mediator.repaint();
			}
		}
	}
}
