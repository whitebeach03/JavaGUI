import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.Serializable;

public class MyDrawing implements Cloneable, Serializable {
    int x, y, w, h;
	Color lineColor, fillColor;
	int lineWidth;
	boolean isSelected;
	Shape region;
	final int SIZE = 7;
	float dash[] = {10.0f, 0};
	
	public MyDrawing() {
		x = y = 0;
		w = h = 40;
		lineColor = Color.black;
		fillColor = Color.white;
		lineWidth = 1;
		setRegion();
	}
	
	public void draw(Graphics g) {
		if (isSelected) {
			g.setColor(Color.black);
			g.fillRect(x+w/2-SIZE/2, y-SIZE/2, SIZE, SIZE);
			g.fillRect(x-SIZE/2, y+h/2-SIZE/2, SIZE, SIZE);
			g.fillRect(x+w/2-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
			g.fillRect(x+w-SIZE/2, y+h/2-SIZE/2, SIZE, SIZE);
			g.fillRect(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
			g.fillRect(x+w-SIZE/2, y-SIZE/2, SIZE, SIZE);
			g.fillRect(x-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
			g.fillRect(x+w-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
		}
	}
	
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
		setRegion();
	}
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		setRegion();
	}
	public void setSize(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public int getX() {
		return this.x;
	}
    public int getY() {
		return this.y;
	}
    public int getW() {
		return this.w;
	}
    public int getH() {
    	return this.h;
    }
    
    public Color getFillColor() {
    	return this.fillColor;  
    }
    public Color getLineColor() {
    	return this.lineColor;
    }   
    public int getLineWidth() {
    	return this.lineWidth;
    }
    
    public void setFillColor(Color fillColor) {
    	this.fillColor = fillColor;
    }
    
    public void setLineColor(Color lineColor) {
    	this.lineColor = lineColor;
    }
    
    public void setW(int w) { 
    	this.w = w;
    }
    public void setH(int h) {
    	this.h = h;
    }   
    public void setLineWidth(int lineWidth) { 
    	this.lineWidth = lineWidth;
    }
    
    public boolean getSelected() {
    	return isSelected;
    }
    public void setSelected(boolean isSelected) {
    	this.isSelected = isSelected;
    }
    
    public boolean contains(int x, int y) { 
    	return region.contains(x, y);
    }
    public void setRegion() {
    	region = new Rectangle(x, y, w, h);
    }
    
    public MyDrawing clone() throws CloneNotSupportedException {
    	return (MyDrawing) super.clone();
    }
    
    public void setDash(float f[]) {
    	dash = f;
    }
    public float[] getDash() {
    	return this.dash;
    }
    
    public void adjustWidth(int x, int w) {
    	if (w < 0) {
    		x += w;
    		w *= -1;
    	}
    }
    public void adjustHeight(int y, int h) {
    	if (h < 0) {
    		y += h;
			h *= -1;
    	}
    }
}

