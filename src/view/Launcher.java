package view;

import controller.GameController;
import controller.RemoteController;

public class Launcher {
	RemoteController remotes = RemoteController.instance;
	GameController gameControl = GameController.instance;
	public static void main(String[] args){
		new GameFrame();
	}
	
}
