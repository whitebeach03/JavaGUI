import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

public class OtherLineColorItem extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public OtherLineColorItem(StateManager stateManager) {
		super("Other Colors");
		addActionListener(new OtherColorListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class OtherColorListener extends JMenuItem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JColorChooser colorChooser = new JColorChooser();
			@SuppressWarnings("static-access")
			Color color = colorChooser.showDialog(this, "色の選択", Color.white);
			
			mediator.setLineColor(color);
			mediator.repaint();
		}
	}
}
