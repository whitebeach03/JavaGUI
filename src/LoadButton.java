import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

public class LoadButton extends JButton {
	StateManager stateManager;
	Mediator mediator;
	Vector<MyDrawing> drawings;
	
	public LoadButton(StateManager stateManager) {
		super("Load");
		addActionListener(new LoadListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		drawings = mediator.drawings;
	}
	
	class LoadListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new LoadState(stateManager));
			try {
				stateManager.load();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}
	}
}
