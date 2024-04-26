import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MyRectangle extends MyDrawing {

	float dash1[] = {10.0f, 3.0f};
	public MyRectangle(int x, int y, int w, int h, Color lineColor) {
		super();
		setLocation(x, y);
		setLineColor(lineColor);
		setW(w);
		setH(h);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		
		if (w < 0) {
			x += w;
			w *= -1;
		}
		if (h < 0) {
			y += h;
			h *= -1;
		}
	
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, dash1, 3.0f));
		g2.setColor(getLineColor());
		g2.drawRect(x, y, getW(), getH());
	}
	
	public boolean contains(int x, int y) { 
    	return region.contains(x, y);
    }
    public void setRegion() {
    	region = new Rectangle(x, y, w, h);
    }
}
