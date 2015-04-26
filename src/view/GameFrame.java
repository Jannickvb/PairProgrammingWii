package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.GameStateManager;
import controller.RemoteController;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private GameStateManager gsm;
	private RemoteController rem;
	private GamePanel gamePanel;
	public GameFrame(){
		super("Wiiiiiiiiii");
		
		setPreferredSize(new Dimension(800,600));
		setMinimumSize(new Dimension(600,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		gsm = new GameStateManager(this);
		rem = new RemoteController(this);
		gamePanel = new GamePanel(this);
		setContentPane(gamePanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public GameStateManager getGameStateManager(){
		return gsm;
	}
	
	public RemoteController getRemoteController(){
		return rem;
	}
	
	public GamePanel getGamePanel(){
		return gamePanel;
	}
}
