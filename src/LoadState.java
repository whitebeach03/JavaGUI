import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import javax.swing.JFileChooser;

public class LoadState extends State {
	StateManager stateManager;
	Mediator mediator;
	Vector<MyDrawing> drawings;
	
	public LoadState(StateManager stateManager) {
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		drawings = mediator.drawings;
	}
	
	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		JFileChooser fc = new JFileChooser();
		int returnval = fc.showOpenDialog(null);
		
		if (returnval == JFileChooser.APPROVE_OPTION) { //ロード用のダイアログを開く.
			File file = fc.getSelectedFile(); //選択されたファイルを得る.
			
			try {
				FileInputStream fin = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fin);
				
				drawings = (Vector<MyDrawing>)in.readObject();
				
				for (MyDrawing d: drawings) {
					System.out.println(d);
					mediator.addDrawing(d);
					d.setLocation(d.x, d.y);
				}
				mediator.repaint();
				System.out.println("をロードしました。");
				
				fin.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
