package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import view.GameFrame;
import controller.GameController;

public class SimonSays extends GameState{
	private GameFrame frame;
	private GameController gameControl;
	public SimonSays(GameFrame frame){
		super(frame);
		gameControl = GameController.instance;
		this.frame = frame;
	}
	
	public void draw(Graphics2D g2){
		g2.drawString("1: Simon Says",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate", 0, 30);
		AffineTransform tx = new AffineTransform();
		tx.translate(frame.getWidth()/2,(frame.getHeight()/2)-25);
		g2.transform(tx);
		g2.drawLine(0, -frame.getHeight()/2, 0, frame.getHeight()/2);
		g2.drawLine(-frame.getWidth()/2,0,frame.getWidth()/2,0);
		if(gameControl.getColor() == 2)
		{
			g2.setColor(Color.BLACK);
		}
		else
		{
			g2.setColor(Color.BLUE);
		}
		g2.fillRect(0, 0, 100, 100);
		if(gameControl.getColor() == 3)
		{
			g2.setColor(Color.BLACK);
		}
		else
		{
			g2.setColor(Color.YELLOW);
		}
		g2.fillRect(-100, 0, 100, 100);
		if(gameControl.getColor() == 1)
		{
			g2.setColor(Color.BLACK);
		}
		else
		{
			g2.setColor(Color.RED);
		}
		g2.fillRect(0, -100, 100, 100);
		if(gameControl.getColor() == 4)
		{
			g2.setColor(Color.BLACK);
		}
		else
		{
			g2.setColor(Color.GREEN);
		}
		g2.fillRect(-100, -100, 100, 100);
		
	}
}
