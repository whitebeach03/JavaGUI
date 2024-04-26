import java.util.Vector;

public class StateManager {
	State state = null;
	MyCanvas canvas;
	Mediator mediator;
	MyDrawing selectedDrawings;
	int w, h;
	
	public StateManager(Mediator mediator) { 
		this.mediator = mediator;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void mouseDown(int x, int y) {
		if (state != null) {
			state.mouseDown(x, y);
		}
	}	
	public void mouseDrag(int w, int h) {
		if (state != null) {
			state.mouseDrag(w, h);
		}
	}
	public void mouseUp(int x, int y) {
		if (state != null) {
			state.mouseUp(x, y);
		}
	}
	public void mouseMove(int x, int y) {
		if (state != null) {
			state.mouseMove(x, y);
		}
	}
	public void addDrawing(MyDrawing d) {
		mediator.addDrawing(d);
	}
	public void removeDrawing(Vector<MyDrawing> d) {
		mediator.removeDrawing(d);
	}
	
	public void setW(int w) { //図形幅変更メソッド
    	this.w = w;
    }
    public void setH(int h) { //図形高さ変更メソッド
    	this.h = h;
    }
    public int getW() {
		return this.w;
	}
    public int getH() {
    	return this.h;
    }

    public void setFillColor() {
    	state.setFillColor();
    	mediator.repaint();
    }
    public void setLineColor() {
    	state.setLineColor();
    	mediator.repaint();
    }
    public void setLineWidth() {
    	state.setLineWidth();
    }
    public void delete() {
    	state.delete();
    	mediator.repaint();
    }
    public void cut() {
    	state.cut();
    	mediator.repaint();
    }
    public void copy() {
    	state.copy();
    	mediator.repaint();
    }
    public void shadow() {
    	state.shadow();
    	mediator.repaint();
    }
    public void save() {
    	state.save();
    }
    public void load() throws Exception {
    	state.load();
    }
}