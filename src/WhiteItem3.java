import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class WhiteItem3 extends JMenuItem {
	StateManager stateManager;
	Mediator mediator;
	MyCanvas canvas;
	
	public WhiteItem3(StateManager stateManager) {
		super("White");
		addActionListener(new WhiteItemListener3());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		canvas = mediator.canvas;
	}
	
	class WhiteItemListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.white);
			mediator.repaint();
		}
	}
}
