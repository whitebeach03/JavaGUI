import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyTriangle extends MyDrawing {
	public MyTriangle(int xpt, int ypt, int w1, int h1, Color lColor, Color fColor) {  // コンストラクタ
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
		
		// 高さ、横幅が負の時のための処理
		if (w < 0) {
			x += w;
			w *= -1;
		}
	   if (h < 0) {
			y += h;
			h *= -1;
		}
		
		int[] xpoint = {x, x + getW()/2, x + getW()};  //　正三角形の座標
		int[] ypoint = {y + getH(), y, y + getH()};
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getLineWidth(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 3.0f, getDash(), 3.0f));
		g2.setColor(getLineColor());
		g2.drawPolygon(xpoint, ypoint, 3);
		g2.setColor(getFillColor());
		g2.fillPolygon(xpoint, ypoint, 3);       //setColorの後にdraw***やfill***をかく
	}
}
