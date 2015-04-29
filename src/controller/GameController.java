package controller;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GameController {
	
	public final static GameController instance = new GameController();
	private int angle,rekt,roll,ySpeed, irX, irY,acceleration;
	private double magnitude;
	private boolean viewRotation,userInputEnabled,aPressed,simon = false;

	private ArrayList<Point2D> x,y,z;
	public GameController(){
		this.x = new ArrayList<Point2D>();
		this.y = new ArrayList<Point2D>();
		this.z = new ArrayList<Point2D>();
		this.ySpeed = 0;
	}
	
	public int getRekt(){
		if(userInputEnabled){
			if(angle > 0 && angle < 90)
	    	{
	    		rekt = 1;
	    	}
	    	if(angle > 90 && angle < 180)
	    	{
	    		rekt = 2;
	    	}
	    	if(angle > 180 && angle < 270)
	    	{
	    		rekt = 3;
	    	}
	    	if(angle > 270 && angle < 360)
	    	{
	    		rekt = 4;
	    	}
		}
	    return rekt;
	}
	public void setRekt(int i){
		if(rekt<0)
			rekt = 0;
		else if(rekt>4)
			rekt = 4;
		else
			rekt = i;
	}
	
	public void setRekt()
	{
		if(userInputEnabled)
		{
			aPressed = true;
		}
	}
	
	public int getSelected()
	{
		aPressed = false;
		return rekt;
	}
	
	public boolean getPressed()
	{
		return aPressed;
	}
	
	public void removeFromIndex(List<Point2D> list, int index)
	{
		list.remove(index);
	}
	
	public void setMagnitude(double magnitude){
		this.magnitude = magnitude;
	}
	
	public double getMagnitude(){
		return magnitude;
	}
	
	public void setAngle(int angle){
		this.angle = angle;
	}
	
	public int getAngle(){
		return angle;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	public int getRoll(){
		return roll;
	}
	
	public int getYSpeed() {
		return ySpeed;
	}

	public ArrayList<Point2D> getX() {
		return x;
	}

	public ArrayList<Point2D> getY() {
		return y;
	}

	public ArrayList<Point2D> getZ() {
		return z;
	}

	public void clearLists(){
		x.clear();
		y.clear();
		z.clear();
	}
	public boolean getViewRotation(){
		return viewRotation;
	}
	public void toggleRotation(){
		if(viewRotation)
			viewRotation = false;
		else
			viewRotation = true;
	}

	public int getIrX(){
		return irX;
	}
	public int getIrY(){
		return irY;
	}

	public void setUserInputEnabled(boolean userInputEnabled){
		this.userInputEnabled = userInputEnabled;
	}
	public void setIrX(int irX){
		this.irX = irX;
	}
	public void setIrY(int irY){
		this.irY = irY;
	}
	public boolean getUserInputEnabled(){
		return userInputEnabled;
	}
	
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	public boolean getSimon(){
		return simon;
	}
	public void setSimon(boolean simon){
		this.simon = simon;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}
}
