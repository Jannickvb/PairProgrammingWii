package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import view.GameFrame;
import controller.GameController;

public class NunchuckPreview extends GameState{
	private GameFrame frame;
	private GameController gameControl;
	private int angle,roll,x,y;
	private double magnitude;
	private boolean viewRotation;
	Graphics2D g2;
	public NunchuckPreview(GameFrame frame) {
		super(frame);
		this.gameControl = GameController.instance;
		this.frame = frame;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawString("3: Nunchuck Preview",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate, C to toggle Rotation", 0, 30);
		g2.drawString("Nunchuck values:", 0, 60);
		g2.drawString("Joystick Angle: " + angle, 0, 90);
		g2.drawString("Joystick Magnitude: " + magnitude,0,120);
		g2.drawString("Nunchuck Rotation: " + roll,0,150);
		g2.drawString("View Rotation: " + viewRotation, 0, 180);
		AffineTransform tx = new AffineTransform();
		tx.translate(frame.getWidth()/2,(frame.getHeight()/2)-25);
		if(gameControl.getViewRotation())
			transformXY(g2,tx);
		g2.transform(tx);
		g2.drawLine(-4000, 0, 4000, 0);
		g2.drawLine(0, -4000, 0, 4000);
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2.drawOval(-100, -100, 200, 200);
		drawJoystickPosition(g2);
	}
	
	public void transformXY(Graphics2D g2,AffineTransform tx){
		tx.rotate(Math.toRadians(roll));
	}
	
	public void drawJoystickPosition(Graphics2D g2){
		int angle = gameControl.getAngle();
		double magnitude = gameControl.getMagnitude();
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(20,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		if(magnitude > 1.0){
			magnitude = 1.0;
		}

		g2.drawLine(x,y,x,y);
	}

	@Override
	public void update() {
		this.angle = gameControl.getAngle();
		this.magnitude = gameControl.getMagnitude();
		this.roll = gameControl.getRoll();
		this.viewRotation = gameControl.getViewRotation();
		this.x = (int) ((magnitude * 100) * Math.cos(Math.toRadians((double)angle-30)-1));
		this.y = (int) ((magnitude * 100) * Math.sin(Math.toRadians((double)angle-30)-1));
	}

	
}
