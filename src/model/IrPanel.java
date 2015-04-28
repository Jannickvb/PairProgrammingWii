package model;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import view.GameFrame;

public class IrPanel extends GameState{

	public IrPanel(GameFrame frame) {
		super(frame);
		
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawString("4: IR test panel",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate", 0, 30);
		AffineTransform tx = new AffineTransform();
		tx.translate(0,(frame.getHeight()/2)-25);
		g2.transform(tx);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
