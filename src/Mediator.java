import java.awt.Color;
import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Mediator {
	MyCanvas canvas;
	Vector<MyDrawing> drawings;
	Vector<MyDrawing> selectedDrawings = null;
	Vector<MyDrawing> buffer = null; 
	boolean isAlpha = false;
	boolean front = false;
	boolean back = false;
	int x, y = 0;
	int alpha = 255;
	File file;
	
	public Mediator(MyCanvas canvas) {
		this.canvas = canvas;
		drawings = new Vector<MyDrawing>();
		selectedDrawings = new Vector<MyDrawing>();
		buffer = new Vector<MyDrawing>();
	}
	
	public Enumeration<MyDrawing> drawingsElements(){
		return drawings.elements();
	}
	
	public void addDrawing(MyDrawing d) {
		drawings.add(d);
	}

	public void removeDrawing(Vector<MyDrawing> d) {
		for (int i = 0; i < d.size(); i++) {
			drawings.remove(d.get(i));
		}
	}
	
	public void addSelectedDrawing(MyDrawing d) {
		selectedDrawings.add(d);
		d.setSelected(true);
	}
	
	public Vector<MyDrawing> getSelectedDrawing() {
		return selectedDrawings;
	}
	
	public void move(int dx, int dy) {
		if (selectedDrawings != null) {
			for (int i = 0; i < selectedDrawings.size(); i++) {
				selectedDrawings.get(i).move(dx, dy);
			}
		}
	}

	public void repaint() {
		canvas.repaint();
	}
	
	public void clearSelectedDrawings() {
		selectedDrawings.clear();
	}
	
	public void setSelected(int x, int y) { //(x, y)の図形を選択.
		clearSelectedDrawings();
		for (int i = drawings.size() - 1; i >= 0; i--) { //オブジェクトの上から選択できるように.
			if (drawings.get(i).contains(x, y)) {
				addSelectedDrawing(drawings.get(i));
				break;
			}
			else {
				drawings.get(i).setSelected(false);
			}
		}
	}
	
	public void setFillColor(Color color) {
		for (MyDrawing d: selectedDrawings) {
			d.setFillColor(color);
		}
	}
	public void setLineColor(Color color) {
		for (MyDrawing d: selectedDrawings) {
			d.setLineColor(color);
		}
	}
	public void setLineWidth(int lineWidth) {
		for (MyDrawing d: selectedDrawings) {
			d.setLineWidth(lineWidth);
		}
	}
	
	public void clearBuffer() {
		buffer.clear();
	}
	public void copy() {
		clearBuffer();
		for (MyDrawing d: selectedDrawings) {
			try {
				buffer.add(d.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	public void cut() {
		clearBuffer();
		for (MyDrawing d: selectedDrawings) {
			try {
				buffer.add(d.clone());
			} catch (CloneNotSupportedException e){
				e.printStackTrace();
			}
		}
		removeDrawing(selectedDrawings);
		repaint();
	}
	public void paste(int x, int y) {
		if (buffer != null) {
			MyDrawing clone = null;
			try {
				for (MyDrawing d: buffer) {
					int dx = d.x - buffer.get(0).x; //相対距離の計算x
					int dy = d.y - buffer.get(0).y; //相対距離の計算y
					clone = d.clone();
					clone.setLocation(x + dx, y + dy);
					addDrawing(clone);					
				}
			} catch (CloneNotSupportedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	public void resetSelectedDrawings(MyRectangle selectedArea) { //複数選択を行う.
		clearSelectedDrawings();
		for (MyDrawing d: drawings) {			
			if (selectedArea.x < d.x && selectedArea.x + selectedArea.w > d.x + d.w && selectedArea.y < d.y && selectedArea.y + selectedArea.h > d.y + d.h) {
				addSelectedDrawing(d);
			}
			else {
				d.setSelected(false);
			}
		}
		repaint();
	}
	
	public void setAlpha(boolean b) { //αチャンネル
		isAlpha = b;
	}
	public boolean getAlpha() {
		return isAlpha;
	}
	public void setAlphaNum(int num) {
		this.alpha = num;
	}
	public int getAlphaNum() {
		return this.alpha;
	}
	
	public void toFront(MyDrawing d) { //最前面に移動
		drawings.remove(d);
		addDrawing(d);
		repaint();
	}
	public void toBack(MyDrawing d) { //最背面に移動
		drawings.remove(d);
		drawings.add(0, d);
		repaint();
	}
	public void setFront(boolean b) {
		front = b;
	}
	public boolean getFront() {
		return front;
	}
	public void setBack(boolean b) {
		back = b;
	}
	public boolean getBack() {
		return back;
	}
	
	public void setImage() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("画像ファイル", "png", "jpg"));
		
		if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
			this.file = fc.getSelectedFile();
		}
	}
	public File getImage() {
		return this.file;
	}
}