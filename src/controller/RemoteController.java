package controller;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;

public class RemoteController {

	Wiimote[] wiimote;
	MyWiiListener wiilistener;
	public static final RemoteController instance = new RemoteController();
	
	public RemoteController(){
		wiimote = WiiUseApiManager.getWiimotes(1, true);
		wiimote[0].addWiiMoteEventListeners(new MyWiiListener());
	}
	
	public Wiimote[] getWiiMotes(){
		return wiimote;
	}
	
	public MyWiiListener getListener()
	{
		return wiilistener;
	}
}
