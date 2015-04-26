package controller;

import java.awt.Color;
import java.util.ArrayList;

public class GameController {
	
	public final static GameController instance = new GameController();
	private ArrayList<Color> userInput = new ArrayList<>();
	private int angle,color;
	public GameController(){
		userInput.add(Color.red);
		userInput.add(Color.yellow);
		userInput.add(Color.blue);
		userInput.add(Color.green);
	}
	
	public int getColor(){
		if(angle > 0 && angle < 90)
    	{
    		System.out.println("rood");
    		color = 1;
    	}
    	if(angle > 90 && angle < 180)
    	{
    		System.out.println("blauw");
    		color = 2;
    	}
    	if(angle > 180 && angle < 270)
    	{
    		System.out.println("geel");
    		color = 3;
    	}
    	if(angle > 270 && angle < 360)
    	{
    		System.out.println("groen");
    		color = 4;
    	}
	    
		return color;
	}
	
	public ArrayList<Color> getUserInput(){
		return userInput;
	}
	
	public void setAngle(int angle){
		this.angle = angle;
	}
}
