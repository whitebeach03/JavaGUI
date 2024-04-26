import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage extends MyDrawing {
	Image img;
	Mediator mediator;
	StateManager stateManager;
	
	public MyImage(int xpt, int ypt, int w1, int h1, StateManager stateManager) throws IOException {
		super();
		setLocation(xpt, ypt);
		setW(w1);
		setH(h1);
		setRegion();
		this.stateManager = stateManager;
		mediator = stateManager.mediator;
		
		try {
			img = ImageIO.read(mediator.getImage());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		
		// 高さ、横幅が負の時の処理
		if (w < 0) {
			x += w;
			w *= -1;
		}
		if (h < 0) {
			y += h;
			h *= -1;
		}
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, x, y, getW(), getH(), null);
	}
	
	public boolean contains(int x, int y) { 
    	return region.contains(x, y);
    }
    public void setRegion() {
    	region = new Rectangle(x, y, w, h);
    }
}
