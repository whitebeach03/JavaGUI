import java.io.IOException;

public class ImageState extends State {
	StateManager stateManager;
	MyImage myImage;
	Mediator mediator;
	int x, y = 0;
	
	public ImageState(StateManager stateManager) {
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	public void mouseUp(int x, int y) {
		
	}
	
	public void mouseDrag(int x, int y) {
		// 高さ、横幅が負の時のための処理
		if (x < 0) {
			x *= -1;
		}
		if (y < 0) {
			y *= -1;
		}
		int dx = x - this.x;
		int dy = y - this.y;
		myImage.setW(dx);
		myImage.setH(dy);
		mediator.repaint();
		myImage.setRegion();
	}
	
	public void mouseDown(int x, int y) {
		try {
			myImage = new MyImage(x, y, 0, 0, this.stateManager);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		stateManager.addDrawing(myImage);
		mediator.repaint();
		this.x = x;
		this.y = y;
	}
}
