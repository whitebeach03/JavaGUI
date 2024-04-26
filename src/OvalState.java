import java.awt.Color;

public class OvalState extends State {
    StateManager stateManager;
    MyOval myOval;
    Mediator mediator;
    MyCanvas canvas;
    int x, y = 0;
	
	public OvalState(StateManager stateManager) {
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
	}
	
	public void mouseUp(int x, int y) {
		
	}
	
	public void mouseDrag(int x, int y) {
		int dx = x - this.x;
		int dy = y - this.y;
		
		// 高さ、横幅が負の時のための処理
		if (dx < 0) {
			dx *= -1;
		}
		if (dy < 0) {
			dy *= -1;
		}
		myOval.setW(dx);
		myOval.setH(dy);
		mediator.repaint();
		myOval.setRegion();
	}
	
	public void mouseDown(int x, int y) {
		myOval = new MyOval(x, y, 0, 0, Color.black, Color.white);
		stateManager.addDrawing(myOval);
		mediator.repaint();
		this.x = x;
		this.y = y;
	}
}
