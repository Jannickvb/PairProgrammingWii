package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.SimonSays;
import controller.GameController;
import controller.GameStateManager;
import controller.RemoteController;

public class GamePanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private GameFrame frame;
	RemoteController rem;
	GameController gameControl;
	GameStateManager gsm;
	public GamePanel(GameFrame frame)
	{
		gameControl = GameController.instance;
		
		this.frame = frame;
		this.rem = frame.getRemoteController();
		this.gsm = frame.getGameStateManager();
		
		Timer timer = new Timer(1000/60, this);
		timer.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
		gsm.getGameState().update();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gsm.getGameState().draw(g2);
	}
	
	public GameFrame getFrame(){
		return frame;
	}
}
