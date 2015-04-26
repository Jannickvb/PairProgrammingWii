package model;

import java.awt.Graphics2D;

import view.GameFrame;

public abstract class GameState {
	protected GameFrame frame;
	public GameState(GameFrame frame){
		this.frame = frame;
	}
	public abstract void draw(Graphics2D g2);
	public abstract void update();
}
