import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

class MyOval extends MyDrawing {
	public MyOval(int xpt, int ypt, int w1, int h1, Color lineColor, Color fillColor) {  
		super();
		setLocation(xpt, ypt);
		setLineColor(lineColor);
		setFillColor(fillColor);
		setW(w1);
		setH(h1);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		
		// 高さ、横幅が負の時の処理
//		if (w < 0) {
//			x += w;
//			w *= -1;
//		}
//		if (h < 0) {
//			y += h;
//			h *= -1;
//		}
		adjustWidth(x, w);
		adjustHeight(y, h);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getLineWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, getDash(), 3.0f));
		g2.setColor(getLineColor());
		g2.drawOval(x, y, getW(), getH());
		g2.setColor(getFillColor());
		g2.fillOval(x, y, getW(), getH());
	}
	
	public boolean contains(int x, int y) { 
    	return region.contains(x, y);
    }
    public void setRegion() {
    	region = new Rectangle(x, y, w, h);
    }
}



