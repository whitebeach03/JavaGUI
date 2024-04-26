import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SaveButton extends JButton {
	StateManager stateManager;
	
	public SaveButton(StateManager stateManager) {
		super("Save");
		addActionListener(new SaveListener());
		this.stateManager = stateManager;
	}
	
	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new SaveState(stateManager));
			try {
				stateManager.save();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}
	}
}
