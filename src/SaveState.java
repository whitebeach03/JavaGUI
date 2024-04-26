import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFileChooser;

public class SaveState extends State {
	StateManager stateManager;
	Mediator mediator;
	Vector<MyDrawing> drawings;
	
	public SaveState(StateManager stateManager) {
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		drawings = mediator.drawings;
	}
	
	public void save() {
		JFileChooser fc = new JFileChooser();
		int returnval = fc.showSaveDialog(null);
		
		if (returnval == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			
			try {
				FileOutputStream fout = new FileOutputStream(file);
				ObjectOutputStream out = new ObjectOutputStream(fout);
				
				out.writeObject(drawings);
				out.flush();
				
				for (MyDrawing d: drawings) {
					System.out.println(d);
				}
				System.out.println("をセーブしました。");
				
				fout.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
