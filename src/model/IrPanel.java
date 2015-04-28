package model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import controller.GameController;
import view.GameFrame;

public class IrPanel extends GameState{
	private int x,y;
	private GameController gameControl = GameController.instance;
	public IrPanel(GameFrame frame) {
		super(frame);
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawString("4: IR test panel",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate", 0, 30);
		g2.setStroke(new BasicStroke(20f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		g2.drawLine(x, y, x, y);
	}

	@Override
	public void update() {
		this.x = gameControl.getIrX();
		this.y = gameControl.getIrY();
	}

}
