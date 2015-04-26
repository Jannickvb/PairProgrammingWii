package controller;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.JoystickEvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.NunchukButtonsEvent;
import wiiusej.wiiusejevents.physicalevents.NunchukEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.StatusEvent;

public class MyWiiListener implements WiimoteListener{
	
	private Wiimote[] wiimotes;
	private GameController gameControl;
	private GameStateManager gsm;
	public MyWiiListener(GameStateManager gsm)
	{
		gameControl = GameController.instance;
		this.gsm = gsm;
//		this.wiimotes = WiiUseApiManager.getWiimotes(1, true);
//		for(int i = 0; i < wiimotes.length; i++)
//		{
//			wiimotes[i].activateIRTRacking();
//			wiimotes[i].activateMotionSensing();
//			wiimotes[i].addWiiMoteEventListeners(this);
//			switch(i)
//			{
//			case 0:
//				wiimotes[i].setLeds(true, false, false, false);
//				break;
//			case 1:
//				wiimotes[i].setLeds(false, true, false, false);
//				break;
//			case 2:
//				wiimotes[i].setLeds(false, false, true, false);
//				break;
//			case 3:
//				wiimotes[i].setLeds(false, false, false, true);
//				break;
//			}
//		}
		
	}

	@Override
	public void onButtonsEvent(WiimoteButtonsEvent e) {
		if(e.isButtonDownJustPressed()){
			gsm.back();
		}
		if(e.isButtonUpJustPressed()){
			gsm.next();
		}
		if(e.isButtonLeftJustPressed()){
			System.out.println("kut hardniksveld");
		}
		if(e.isButtonRightJustPressed()){
			System.out.println("godverdomme wesley");
		}
	}

	@Override
	public void onClassicControllerInsertedEvent(
			ClassicControllerInsertedEvent e) {
		
		
	}

	@Override
	public void onClassicControllerRemovedEvent(
			ClassicControllerRemovedEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnectionEvent(DisconnectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExpansionEvent(ExpansionEvent e) {
		if(e instanceof NunchukEvent)
		{
			NunchukEvent nunchuck = (NunchukEvent) e;
			JoystickEvent joystick = nunchuck.getNunchukJoystickEvent();
			if(joystick.getMagnitude() > 0.3)
			{
				gameControl.setAngle((int)joystick.getAngle());
			}
		}
	}

	@Override
	public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIrEvent(IREvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMotionSensingEvent(MotionSensingEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNunchukInsertedEvent(NunchukInsertedEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNunchukRemovedEvent(NunchukRemovedEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusEvent(StatusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
