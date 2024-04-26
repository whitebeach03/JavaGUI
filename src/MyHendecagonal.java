import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyHendecagonal extends MyDrawing {
	public MyHendecagonal(int xpt, int ypt, int w1, int h1, Color lColor, Color fColor) {
		super();
		setLocation(xpt, ypt);
		setLineColor(lColor);
		setFillColor(fColor);
		setW(w1);
		setH(h1);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		
		int r = 0;
		if (w >= h) {
			r = h;
		}
		if (h >= w) {
			r = w;
		}

		int[] xpoint = new int[11];
		int[] ypoint = new int[11];
		int n = 11;
		for (int i = 0; i < n; i++) {   //　正11角形の座標
			xpoint[i] = (int) ((int) x + r * Math.cos(360/n * i));
			ypoint[i] = (int) ((int) y + r * Math.sin(360/n * i));
		}
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getLineWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, getDash(), 3.0f));
		g2.setColor(getLineColor());
		g2.drawPolygon(xpoint, ypoint, 11);
		g2.setColor(getFillColor());
		g2.fillPolygon(xpoint, ypoint, 11);	
	}
}
