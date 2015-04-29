package controller;

import java.awt.geom.Point2D;

import model.Accelerometer;
import model.SimonSays;
import model.IrPanel;
import model.NunchuckPreview;
import view.GameFrame;
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
	
	private GameController gameControl;
	private GameStateManager gsm;
	private RemoteController rem;
	private GameFrame frame;
	public MyWiiListener(GameFrame frame, RemoteController rem)
	{
		this.frame = frame;
		gameControl = GameController.instance;
		this.gsm = this.frame.getGameStateManager();
		this.rem = rem;
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
			System.out.println("left");
		}
		if(e.isButtonRightJustPressed()){
			System.out.println("right");
		}
		if(e.isButtonAJustPressed()){
			if(gameControl.getUserInputEnabled())
			{
				gameControl.setRekt();
			}
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
			NunchukButtonsEvent nunButtons = nunchuck.getButtonsEvent();
			JoystickEvent joystick = nunchuck.getNunchukJoystickEvent();
			MotionSensingEvent motion = nunchuck.getNunchukMotionSensingEvent();
			gameControl.setRoll((int)motion.getOrientation().getRoll());
			gameControl.setMagnitude(joystick.getMagnitude());
			if(joystick.getMagnitude() > 0.3)
			{
				gameControl.setAngle((int)joystick.getAngle());
			}
			if(gsm.getGameState() instanceof NunchuckPreview)
			{
				if(nunButtons.isButtonCJustPressed())
					gameControl.toggleRotation();
			}
			if(gsm.getGameState() instanceof IrPanel)
			{
				if(nunButtons.isButtonZJustPressed())
				{
						rem.setSensorBarBelowScreen();
				}
					
				if(nunButtons.isButtonCJustPressed())
				{
						rem.setSensorBarAboveScreen();
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
		if(gsm.getGameState() instanceof IrPanel){
			gameControl.setIrX(e.getAx());
			gameControl.setIrY(e.getAy());
		}
	}

	@Override
	public void onMotionSensingEvent(MotionSensingEvent e) {
		if(gsm.getGameState() instanceof Accelerometer){
			gameControl.getX().add(new Point2D.Double(gameControl.getYSpeed(), e.getRawAcceleration().getX()-130));	
			gameControl.getY().add(new Point2D.Double(gameControl.getYSpeed(), e.getRawAcceleration().getY()-130));	
			gameControl.getZ().add(new Point2D.Double(gameControl.getYSpeed(), e.getRawAcceleration().getZ()-130));	
		}
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
