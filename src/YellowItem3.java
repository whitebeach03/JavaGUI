import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class YellowItem3 extends JMenuItem {
	MyCanvas canvas;
	StateManager stateManager;
	Mediator mediator;
	
	public YellowItem3(StateManager stateManager) {
		super("Yellow");
		addActionListener(new YellowItemListener3());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		canvas = mediator.canvas;
	}
	
	class YellowItemListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.yellow);
			mediator.repaint();
		}
	}
}
