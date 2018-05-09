package dp.structural.flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class Oval implements Shape {

	private boolean fill;
	
	public Oval(boolean f) {
		this.fill=f;
		System.out.println("Creating Oval object with fill="+ f);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics circle, int x, int y, int width, int height, Color color) {
		// TODO Auto-generated method stub
		circle.setColor(color);
		circle.drawOval(x, y, width, height);
		if(fill) {
			circle.fillOval(x, y, width, height);
		}
	}

}
