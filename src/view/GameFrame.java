package view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame(){
		super("Wiiiiiiiiii");
		setPreferredSize(new Dimension(566,590));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setContentPane(new GamePanel());
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
