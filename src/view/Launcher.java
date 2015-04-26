package view;

import controller.GameController;

public class Launcher {
	GameController gameControl = GameController.instance;
	public static void main(String[] args){
		new GameFrame();
	}
	
}
