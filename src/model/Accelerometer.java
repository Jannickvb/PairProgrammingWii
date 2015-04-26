package model;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import view.GameFrame;

public class Accelerometer extends GameState{
	private GameFrame frame;
	public Accelerometer(GameFrame frame) {
		super(frame);
		this.frame = frame;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawString("2: Accelerometer",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate", 0, 30);
		AffineTransform tx = new AffineTransform();
		tx.translate(frame.getWidth()/2,(frame.getHeight()/2)-25);
		g2.transform(tx);
		g2.drawLine(-frame.getWidth()/2, 0, frame.getWidth()/2, 0);
		g2.drawLine(0, -frame.getHeight()/2, 0, frame.getHeight()/2);
	}

}
