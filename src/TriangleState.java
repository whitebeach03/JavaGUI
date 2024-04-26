import java.awt.Color;

public class TriangleState extends State {
	StateManager stateManager;
    MyTriangle myTriangle;
    Mediator mediator;
    int x, y = 0;
	
	public TriangleState(StateManager stateManager) {
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
		myTriangle.setW(dx);
		myTriangle.setH(dy);
		mediator.repaint();
		myTriangle.setRegion();
	}
	
	public void mouseDown(int x, int y) {
		myTriangle = new MyTriangle(x, y, 0, 0, Color.black, Color.white);
		stateManager.addDrawing(myTriangle);
		mediator.repaint();
		this.x = x;
		this.y = y;
	}
}
