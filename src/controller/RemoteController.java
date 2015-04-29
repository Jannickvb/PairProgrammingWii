package controller;

import view.GameFrame;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;

public class RemoteController {

	Wiimote[] wiimote;
	MyWiiListener wiilistener;
	GameStateManager gsm;
	private boolean sensorbarPos;
	private GameFrame frame;
	public RemoteController(GameFrame frame){
		this.frame = frame;
		this.gsm = frame.getGameStateManager();
		wiimote = WiiUseApiManager.getWiimotes(4, true);
		for(int i = 0;i<wiimote.length;i++){
			wiimote[i].addWiiMoteEventListeners(new MyWiiListener(this.frame));
			wiimote[i].activateMotionSensing();
			wiimote[i].activateIRTRacking();
			wiimote[i].setSensorBarBelowScreen();
		}
		if(wiimote.length == 0)
			System.out.println("NO CONTROLLER CONNECTED");
	}
	
	public Wiimote[] getWiiMotes(){
		return wiimote;
	}

	public void setSensorBarBelowScreen(){
		for(int i = 0;i<wiimote.length;i++){
			wiimote[i].setSensorBarBelowScreen();
		}
		sensorbarPos = false;
	}
	
	public boolean getSensorbarPos(){
		return sensorbarPos;
	}
	
	public void setSensorBarAboveScreen(){
		for(int i = 0;i<wiimote.length;i++){
			wiimote[i].setSensorBarAboveScreen();
		}
		sensorbarPos = true;
	}
	
	public MyWiiListener getListener()
	{
		return wiilistener;
	}
}
