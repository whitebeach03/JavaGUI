import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

public class OtherFillColorItem extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	
	public OtherFillColorItem(StateManager stateManager) {
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
			//RGB値の取得
			if (color != null) {
				int r = color.getRed();
				int g = color.getGreen();
				int b = color.getBlue();
				if (mediator.getAlpha()) {
					mediator.setFillColor(new Color(r, g, b, 50));
				}
				else {
					mediator.setFillColor(color);
				}
			}

			mediator.repaint();
		}
	}
}
