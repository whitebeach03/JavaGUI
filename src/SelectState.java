import java.awt.Color;
import java.awt.Cursor;

public class SelectState extends State {
	StateManager stateManager;
	Mediator mediator;
	MyCanvas canvas;
	Operation operation;
	MyApplication myApp;
	int x, y = 0;

	public SelectState(StateManager stateManager) {
		this.stateManager = stateManager;
		mediator = stateManager.mediator;		
		canvas = mediator.canvas;
	}
	
	public void mouseUp(int x, int y) {
		if (operation instanceof Click) {
			mediator.setSelected(x, y);
			if (mediator.getFront() == true && mediator.getBack() == false) { //最前面に表示
				if (mediator.selectedDrawings.size() != 0) { 
					if (mediator.selectedDrawings.firstElement() != mediator.drawings.lastElement()) {
						mediator.toFront(mediator.selectedDrawings.firstElement());
					}
				}
			}
			else if (mediator.getFront() == false && mediator.getBack() == true) { //最背面に表示
				if (mediator.selectedDrawings.size() != 0) { 
					if (mediator.selectedDrawings.firstElement() != mediator.drawings.firstElement()) {
						mediator.toBack(mediator.selectedDrawings.firstElement());
					}
				}
			}
		}
		else if (operation instanceof Drag) {
			mediator.drawings.remove(((Drag) operation).myRectangle);
			mediator.selectedDrawings.remove(((Drag) operation).myRectangle);
		}
		mediator.repaint();
	}
	
	public void mouseDrag(int x, int y) {		
		if (operation instanceof Move) { //図形の移動
			int dx = x - ((Move)operation).x;
			int dy = y - ((Move)operation).y;
			mediator.move(dx, dy);
			
			((Move) operation).x = x;
			((Move) operation).y = y;
		}
		else if (operation instanceof Click) { //Rectangleの追加
			Drag drag = new Drag(x, y);
			mediator.addDrawing(drag.myRectangle);
			
			operation = drag;
		}
		else if (operation instanceof Drag) { //Rectangleの拡大 複数選択
			MyRectangle rect = ((Drag) operation).myRectangle;
			rect.setW(x - rect.x);
			rect.setH(y - rect.y);
			
			mediator.resetSelectedDrawings(rect);
		}
		mediator.repaint();
	}
	
	public void mouseDown(int x, int y) {
		boolean moving = false;
		for (MyDrawing d: mediator.selectedDrawings) {
			if (d.contains(x, y)) {
				moving = true;
				break;
			}
		}
		if (moving) {
			operation = new Move(x, y);
		}
		else {
			for (MyDrawing d: mediator.selectedDrawings) {
				d.setSelected(false);
			}
			mediator.clearSelectedDrawings();
			operation = new Click();
		}			
	}
	
	public void mouseMove(int x, int y) { //選択図形の上にカーソル -> ハンドカーソルに.
		for (MyDrawing d: mediator.selectedDrawings) {
			if (d.contains(x, y)) {
				canvas.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else {
				canvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}
}

abstract class Operation {
	
}
class Click extends Operation {
	
}
class Drag extends Operation {
	MyRectangle myRectangle;
	Drag(int x, int y){
		myRectangle = new MyRectangle(x, y, 0, 0, Color.black);
	}
}
class Move extends Operation {
	int x;
	int y;
	Move(int x, int y){
		this.x = x;
		this.y = y;
	}
}