import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ImageButton extends JButton {
	StateManager stateManager;
	Mediator mediator;
	
	public ImageButton(StateManager stateManager) {
		super("Image");		
		addActionListener(new ImageListener());
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	class ImageListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new ImageState(stateManager));
			mediator.setImage();
		}
	}
}
