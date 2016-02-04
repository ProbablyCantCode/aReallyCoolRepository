package exercise3;

import java.util.Random;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Car extends Actor implements IntersectionListener{
	public static enum carState {
		OUTSIDE,
		APPROACHING,
		INSIDE
	}
	
	Random rand = new Random();
	private carState state = carState.APPROACHING;
	private Intersection intersection;
	
	private final int FULL_SPEED = 5;
	private final int SLOW_DOWN = 2;
	private final int STOPPED = 0;
	private int currSpeed = FULL_SPEED;
	
	public Car() {
		String[] carImages = {"images\\topCarBlue.png", "images\\topCarRed.png", "images\\topCarPurple.png", "images\\topCarYellow.png"};
		int randCarColour = rand.nextInt(4);
		int carColour = randCarColour;
		
		GreenfootImage image = new GreenfootImage(carImages[carColour]);
		this.setImage(image);
	}
	
	public void act() {
		move(currSpeed);
		
		switch(state) {
		case OUTSIDE:
			if(currSpeed < FULL_SPEED) {
				speedUp(); 
			}
			break;
		case APPROACHING:
			if(this.getRotation() == Direction.East.getDirection() || this.getRotation() == Direction.West.getDirection()) {
				if(intersection != null) {
					if(intersection.getHorzColour() == TrafficLights.Colour.GREEN) {
						speedUp();
					}
					else {
						slowDown();
					}
				}
			}
			if(this.getRotation() == Direction.North.getDirection() || this.getRotation() == Direction.South.getDirection()) {
				if(intersection != null) {
					if(intersection.getVertColour() == TrafficLights.Colour.GREEN) {
						speedUp();
					}
					else {
						slowDown();
					}
				}
			}
			break;
		case INSIDE:
			if(currSpeed <= SLOW_DOWN) {
				currSpeed = STOPPED;
			}
			else {
				currSpeed = FULL_SPEED;
			}
			break;
		}
		
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
	
	public void speedUp() {
		if(currSpeed < FULL_SPEED) {
			++currSpeed;
		}
	}
	
	public void slowDown() {
		if(currSpeed > STOPPED) {
			--currSpeed;
		}
	}

	@Override
	public void notifyCarApproaching(Intersection i) {
		intersection = i;
		state = carState.APPROACHING;
		
	}

	@Override
	public void notifyCarLeaving(Intersection i) {
		intersection = i;
		state = carState.OUTSIDE;
		
	}

	@Override
	public void notifyCarInside(Intersection i) {
		intersection = i;
		state = carState.INSIDE;
	}
}
