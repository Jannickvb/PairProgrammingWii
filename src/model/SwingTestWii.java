package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import view.GameFrame;
import controller.GameController;

public class SwingTestWii extends GameState{

	private int acceleration;
	private int whipAngle;
	private GameController gameControl = GameController.instance;
	public SwingTestWii(GameFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawString("4: IR test panel",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate", 0, 30);
		g2.drawString("Swing to spin the thingy", 0, 60);
		AffineTransform tx = new AffineTransform();
		tx.translate(frame.getWidth()/2, frame.getHeight()/2);
		tx.rotate(Math.toRadians(whipAngle));
		g2.transform(tx);
		g2.setStroke(new BasicStroke(10f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		g2.setColor(Color.red);
		g2.drawLine(0, 0, 100, 100);
	}

	@Override
	public void update() {
		acceleration = gameControl.getAcceleration();
		System.out.println(acceleration);
		if(acceleration > 160 || acceleration < 100)
			whipAngle+=12;
		if(whipAngle > 359)
			whipAngle = 0;
	}

}
