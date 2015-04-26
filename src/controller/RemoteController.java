package controller;

import javax.swing.JDialog;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;

public class RemoteController {

	Wiimote[] wiimote;
	MyWiiListener wiilistener;
	public static final RemoteController instance = new RemoteController();
	
	public RemoteController(){
		wiimote = WiiUseApiManager.getWiimotes(4, true);
		for(int i = 0;i<wiimote.length;i++)
			wiimote[i].addWiiMoteEventListeners(new MyWiiListener());
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
