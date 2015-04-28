package controller;

import java.util.ArrayList;

import model.Accelerometer;
import model.GameState;
import model.IrPanel;
import model.NunchuckPreview;
import model.SimonSays;
import view.GameFrame;

public class GameStateManager {
	private ArrayList<GameState> gamestates;
	private GameFrame frame;
	private GameState currentState;
	public GameStateManager(GameFrame frame){
		gamestates = new ArrayList<GameState>();
		this.frame = frame;
		gamestates.add(new SimonSays(frame));
		gamestates.add(new Accelerometer(frame));
		gamestates.add(new NunchuckPreview(frame));
		gamestates.add(new IrPanel(frame));
		currentState = gamestates.get(0);
	}
	
	public GameState getGameState(){
		return currentState;
	}

	public void next() {
		if(currentState instanceof SimonSays)
		{
			currentState = gamestates.get(1);
		}
		else if(currentState instanceof Accelerometer)
		{
			currentState = gamestates.get(2);
		}
		else if(currentState instanceof NunchuckPreview)
		{
			currentState = gamestates.get(3);
		}
		else if(currentState instanceof IrPanel)
		{
			currentState = gamestates.get(0);
		}
		else
		{
			currentState = gamestates.get(0);
		}
	}
	
	public void back() {
		if(currentState instanceof SimonSays)
		{
			currentState = gamestates.get(3);
		}
		else if(currentState instanceof Accelerometer)
		{
			currentState = gamestates.get(0);
		}
		else if(currentState instanceof NunchuckPreview)
		{
			currentState = gamestates.get(1);
		}
		else if(currentState instanceof IrPanel)
		{
			currentState = gamestates.get(2);
		}
		else
		{
			currentState = gamestates.get(0);
		}
	}
}
