package model;

import java.awt.Graphics2D;

import view.GameFrame;

public class NunchuckPreview extends GameState{
	private GameFrame frame;
	public NunchuckPreview(GameFrame frame) {
		super(frame);
		this.frame = frame;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawString("3: Nunchuck Preview",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate", 0, 30);
	}

}
