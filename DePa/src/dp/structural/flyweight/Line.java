package dp.structural.flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class Line implements Shape{

	public Line() {
		System.out.println("Creating Line object");
		try {
			Thread.sleep(1);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics line, int x1, int y1, int x2, int y2, Color color) {
		// TODO Auto-generated method stub
		line.setColor(color);
		line.drawLine(x1, y1, x2, y2);
	}
}
