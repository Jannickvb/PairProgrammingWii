package controller;

import view.GameFrame;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;

public class RemoteController {

	Wiimote[] wiimote;
	MyWiiListener wiilistener;
	GameStateManager gsm;
	public RemoteController(GameFrame frame){
		this.gsm = frame.getGameStateManager();
		wiimote = WiiUseApiManager.getWiimotes(4, true);
		for(int i = 0;i<wiimote.length;i++)
			wiimote[i].addWiiMoteEventListeners(new MyWiiListener(gsm));
		if(wiimote.length == 0)
			System.out.println("NO CONTROLLER CONNECTED");
	}
	
	public Wiimote[] getWiiMotes(){
		return wiimote;
	}
	
	public MyWiiListener getListener()
	{
		return wiilistener;
	}
}
