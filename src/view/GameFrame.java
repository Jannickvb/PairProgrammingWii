package view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public GameFrame(){
		super("Wiiiiiiiiii");
		setPreferredSize(new Dimension(566,590));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setContentPane(new GamePanel(this));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
