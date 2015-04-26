package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.List;

import view.GameFrame;
import controller.GameController;

public class Accelerometer extends GameState{
	private GameFrame frame;
	private GameController gameControl;
	private int beginN;
	public Accelerometer(GameFrame frame) {
		super(frame);
		this.gameControl = GameController.instance;
		this.frame = frame;
		this.beginN = 0;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawString("2: Accelerometer",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate", 0, 30);
		AffineTransform tx = new AffineTransform();
		tx.translate(0,(frame.getHeight()/2)-25);
		g2.transform(tx);
		g2.drawLine(-frame.getWidth(), 0, frame.getWidth(), 0);
		Stroke s = new BasicStroke(1f);
	    g2.setStroke(s);
		g2.setColor(Color.red);
		drawLines(g2, gameControl.getX());
		g2.setColor(Color.blue);
		drawLines(g2, gameControl.getY());
		g2.setColor(Color.green);
		drawLines(g2, gameControl.getZ());
	}


	private void drawLines(Graphics2D g2, List<Point2D> list)
	{
		Point2D currentP;
		Point2D nextP;
		
		for(int i = 0; i < list.size();i++){
			currentP = list.get(i);
			try{
				nextP = list.get(i+1);
			}catch(IndexOutOfBoundsException e){
				System.out.println("GODVERDOMME WESLEY JE VERNEUKT T WEER");
				nextP = currentP;
			}
			g2.draw(new Line2D.Float(currentP, nextP));
		}
	}
	public void hasSpace(){
		if(!gameControl.getY().isEmpty())
			if(gameControl.getY().get(gameControl.getY().size()-1).getX() > frame.getWidth())
			{
				gameControl.clearLists();
				gameControl.setYSpeed(0);
			}
	}

	@Override
	public void update() {
		hasSpace();
		gameControl.setYSpeed((gameControl.getYSpeed()+1));
	}

}
