package exercise2;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class TrafficLights extends Actor {
	public static enum Colour {
		RED,
		GREEN,
		YELLOW
	}
	private String[] colourImages = {"images\\trafficLightRed.png", "images\\trafficLightGreen.png", "images\\trafficLightYellow.png"};
	
	public TrafficLights(Colour initialColour) {
		initialColour.ordinal();
		GreenfootImage trafficLight = new GreenfootImage(colourImages[initialColour.ordinal()]);
		setImage(trafficLight);
	}
	
	public void setColour(Colour newColour) {
		setImage(colourImages[newColour.ordinal()]);
	}
	
}
