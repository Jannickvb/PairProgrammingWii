package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import view.GameFrame;
import controller.GameController;

public class SimonSays extends GameState{
	private GameFrame frame;
	private GameController gameControl;
	private ArrayList<Integer> userInput;
	private ArrayList<Integer> gameInput;
	private int showTime, element;
	public SimonSays(GameFrame frame){
		super(frame);
		gameControl = GameController.instance;
		this.frame = frame;
		this.userInput = new ArrayList<Integer>();
		this.gameInput = new ArrayList<Integer>();
		this.showTime = 0;
		this.element = 0;
		nextRound();
	}
	
	public void draw(Graphics2D g2){
		g2.drawString("1: Simon Says",0,10);
		g2.drawString("Press UP/DOWN on the Wii remote to navigate", 0, 30);
		if(gameControl.getUserInputEnabled())
		{
			g2.drawString("Your Turn: " + userInput.size(), frame.getWidth()/2, 10);
		}
		if(!gameControl.getUserInputEnabled())
		{
			g2.drawString(element + "", frame.getWidth()/2, 10);
		}
		if(!gameControl.getSimon()){
			g2.setColor(Color.RED);
			g2.fillRect(0, 40, 150, 30);
			g2.setColor(Color.white);
			g2.drawString("PRESS 1 TO START", 10, 60);
		}else{
			g2.setColor(Color.GREEN);
			g2.fillRect(0, 40, 150, 30);
			g2.setColor(Color.white);
			g2.drawString("GAME IS RUNNING", 10, 60);
		}
		g2.setColor(Color.BLACK);
		AffineTransform tx = new AffineTransform();
		tx.translate(frame.getWidth()/2,(frame.getHeight()/2)-25);
		g2.transform(tx);
		g2.setColor(new Color(30,30,30));
		g2.fillRect(-155, -155, 310, 310);
		if(gameControl.getRekt() == 2)
		{
			g2.setColor(Color.BLUE.darker());
		}
		else
		{
			g2.setColor(Color.BLUE);
		}
		g2.fillRect(0, 0, 150, 150);
		if(gameControl.getRekt() == 3)
		{
			g2.setColor(Color.YELLOW.darker());
		}
		else
		{
			g2.setColor(Color.YELLOW);
		}
		g2.fillRect(-150, 0, 150, 150);
		if(gameControl.getRekt() == 1)
		{
			g2.setColor(Color.RED.darker());
		}
		else
		{
			g2.setColor(Color.RED);
		}
		g2.fillRect(0, -150, 150, 150);
		if(gameControl.getRekt() == 4)
		{
			g2.setColor(Color.GREEN.darker());
		}
		else
		{
			g2.setColor(Color.GREEN);
		}
		g2.fillRect(-150, -150, 150, 150);
		
	}
	
	public void setUserInput(ArrayList<Integer> userInput)
	{
		this.userInput = userInput;
	}
	
	public ArrayList<Integer> getUserInput()
	{
		return userInput;
	}
	
	public void gameover()
	{
		System.out.println("Game Restart");
		userInput.clear();
		gameInput.clear();
		element = 0;
		showTime = 0;
		if(!gameControl.getSimon())
			nextRound();
	}
	
	public void nextRound()
	{
		userInput.clear();
		gameControl.setUserInputEnabled(false);
		int x = 0;
		while(x == 0)
		{
			x = (int) (Math.random()*5);
		}
		gameInput.add(x); //voegt een (random) nieuwe toe
	}
	
	public void showColors()
	{
		gameControl.setRekt(gameInput.get(element));
	}

	@Override
	public void update() {
		if(gameControl.getSimon())
			updateGame();
	}
	
	public void updateGame(){
		if(!gameControl.getUserInputEnabled() && gameInput.size() > 0){
			if(showTime > 60)
			{
				//tekent de elementen (kleuren) 1 keer per seconde
				showTime = 0;
				if(element < gameInput.size())
				{
					showColors();
					element++;
				}
				else
				{
					element = 0;
					gameControl.setUserInputEnabled(true);
					gameControl.setRekt(0);
				}
			}
			else
			{
				showTime ++;
			}
		}
		else if(gameControl.getUserInputEnabled() && gameControl.getPressed() && gameControl.getRekt() != 0 && gameInput.size() != userInput.size())
		{
			userInput.add(gameControl.getSelected());
		}
		else if(userInput.size() >= gameInput.size())
		{
			gameControl.setSimon(true);
			for(int i = 0; i < gameInput.size(); i++)
			{
				if(gameInput.get(i) != userInput.get(i))
				{
					gameControl.setSimon(false);
				}
			}
			if(!gameControl.getSimon())
			{
				gameControl.setSimon(false);
				gameover();
			}
			else
			{
				nextRound();
			}
		}
	}
}
