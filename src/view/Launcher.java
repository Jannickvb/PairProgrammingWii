package view;

import controller.RemoteController;

public class Launcher {
	RemoteController remotes = RemoteController.instance;
	public static void main(String[] args){
		new GameFrame();
	}
	
}
