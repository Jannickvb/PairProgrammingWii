package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.GameStateManager;
import controller.RemoteController;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private GameStateManager gsm;
	private RemoteController rem;
	public GameFrame(){
		super("Wiiiiiiiiii");
		
		setPreferredSize(new Dimension(566,590));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		gsm = new GameStateManager(this);
		rem = new RemoteController(this);
		setContentPane(new GamePanel(this));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public GameStateManager getGameStateManager(){
		return gsm;
	}
	
	public RemoteController getRemoteController(){
		return rem;
	}
}
