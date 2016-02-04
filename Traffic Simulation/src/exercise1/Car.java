package exercise1;

import java.util.Random;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Car extends Actor {
	Random rand = new Random();
	
	public Car() {
		String[] carImages = {"images\\topCarBlue.png", "images\\topCarRed.png", "images\\topCarPurple.png", "images\\topCarYellow.png"};
		int randCarColour = rand.nextInt(4);
		int carColour = randCarColour;
		
		GreenfootImage image = new GreenfootImage(carImages[carColour]);
		this.setImage(image);
	}
	
	public void act() {
		move(1);
		
		if(isAtEdge()) {
			if(getX() >= (TrafficWorld.WORLD_WIDTH - 1)) 
				setLocation(0, getY());
			else if(getX() <= 1) 
				setLocation(TrafficWorld.WORLD_WIDTH, getY());
			else if(getY() >= (TrafficWorld.WORLD_HEIGHT - 1)) 
				setLocation(getX(), 0);
			else 
				setLocation(getX(), TrafficWorld.WORLD_HEIGHT);
		}
	}
}
