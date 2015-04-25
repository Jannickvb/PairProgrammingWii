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
	private int color;
	
	public MyWiiListener()
	{
		this.wiimotes = WiiUseApiManager.getWiimotes(1, true);
		for(int i = 0; i < wiimotes.length; i++)
		{
			wiimotes[i].activateIRTRacking();
			wiimotes[i].activateMotionSensing();
			wiimotes[i].addWiiMoteEventListeners(this);
			switch(i)
			{
			case 0:
				wiimotes[i].setLeds(true, false, false, false);
				break;
			case 1:
				wiimotes[i].setLeds(false, true, false, false);
				break;
			case 2:
				wiimotes[i].setLeds(false, false, true, false);
				break;
			case 3:
				wiimotes[i].setLeds(false, false, false, true);
				break;
			}
		}
		this.color = 0;
	}

	@Override
	public void onButtonsEvent(WiimoteButtonsEvent e) {
		if(e.isButtonDownJustPressed()){
			System.out.println("wesley is een idioot");
		}
		if(e.isButtonUpJustPressed()){
			System.out.println("wesley is een faggot");
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
	
	public int getColor()
	{
		return color;
	}

	@Override
	public void onExpansionEvent(ExpansionEvent e) {
		if(e instanceof NunchukEvent){
			NunchukEvent nunchuck = (NunchukEvent) e;
			JoystickEvent joystick = nunchuck.getNunchukJoystickEvent();
			if(joystick.getMagnitude() > 0.3)
			{
				if(joystick.getMagnitude() > 0.3)
            {
            	if(joystick.getAngle() > 0 && joystick.getAngle() < 90)
            	{
            		System.out.println("rood");
            		color = 1;
            	}
            	if(joystick.getAngle() > 90 && joystick.getAngle() < 180)
            	{
            		System.out.println("blauw");
            		color = 2;
            	}
            	if(joystick.getAngle() > 180 && joystick.getAngle() < 270)
            	{
            		System.out.println("geel");
            		color = 3;
            	}
            	if(joystick.getAngle() > 270 && joystick.getAngle() < 360)
            	{
            		System.out.println("groen");
            		color = 4;
            	}
            }
            else
            {
            	color = 0;
            }
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
