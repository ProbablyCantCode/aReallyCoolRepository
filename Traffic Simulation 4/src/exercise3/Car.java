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
	
	private final int LEFT = 270;
	private final int RIGHT = 90;
	
	private Car secondCar;
	private Explosion explosion = new Explosion();
	private boolean alreadyTurned = false;
	
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
			if(this.getRotation() == Direction.East.getLightRotation() || this.getRotation() == Direction.West.getLightRotation()) {
				if(intersection != null) {
					if(intersection.getHorzColour() == TrafficLights.Colour.GREEN) {
						speedUp();
					}
					else {
						slowDown();
					}
				}
			}
			if(this.getRotation() == Direction.North.getLightRotation() || this.getRotation() == Direction.South.getLightRotation()) {
				if(intersection != null) {
					if(intersection.getVertColour() == TrafficLights.Colour.GREEN) {
						speedUp();
					}
					else {
						slowDown();
					}
				}
			}
			
			alreadyTurned = false;
			break;
		case INSIDE:
			if(this.getRotation() == Direction.East.getLightRotation() || this.getRotation() == Direction.West.getLightRotation()) {
				if(intersection.getHorzColour() == TrafficLights.Colour.RED || intersection.getHorzColour() == TrafficLights.Colour.YELLOW) {
					if(currSpeed <= SLOW_DOWN) {
						currSpeed = STOPPED;
					}
				}
				else {
					currSpeed = FULL_SPEED;
				}
			}
			if(this.getRotation() == Direction.North.getLightRotation() || this.getRotation() == Direction.South.getLightRotation()) {
				if(intersection.getVertColour() == TrafficLights.Colour.RED || intersection.getVertColour() == TrafficLights.Colour.YELLOW) {
					if(currSpeed <= SLOW_DOWN) {
						currSpeed = STOPPED;
					}
				}
				else {
					currSpeed = FULL_SPEED;
				}
			}
			
			horzTurn();
			vertTurn();
			break;
		}
		
		if(isAtEdge()) {
			getWorld().removeObject(this);
			return;
		}
		
		collisionCheck();
		
	}
	
	private void collisionCheck() {
		try {
			secondCar = (Car)this.getOneIntersectingObject(Car.class);
			if(secondCar != null) {
				throw new Exception("Fender Bender!");
			}
			
		}
		catch(Exception e) {
			getWorld().addObject(explosion, this.getX(), this.getY());
			getWorld().removeObject(secondCar);
			getWorld().removeObject(this);
			
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
	
	public void horzTurn() {
		int randTurn = rand.nextInt(30);
		int leftTurn = 1;
		int rightTurn = 2;
		
		if(this.getRotation() == Direction.East.getCarRotation()) {
			if((this.getX() - (intersection.getX() - (Road.ROAD_HEIGHT / 4))) <= 1 && randTurn == rightTurn && alreadyTurned == false) {
				this.setLocation(intersection.getX() - (Road.ROAD_HEIGHT / 4), this.getY());
				this.turn(RIGHT);
				alreadyTurned = true;
			}
			if((this.getX() - (intersection.getX() + (Road.ROAD_HEIGHT / 4))) <= 1 && randTurn == leftTurn && alreadyTurned == false) {
				this.setLocation(intersection.getX() + (Road.ROAD_HEIGHT / 4), this.getY());
				this.turn(LEFT);
				alreadyTurned = true;
			}
		}
		
		if(this.getRotation() == Direction.West.getCarRotation()) {
			if((this.getX() - (intersection.getX() - (Road.ROAD_HEIGHT / 4))) <= 1 && randTurn == leftTurn && alreadyTurned == false) {
				this.setLocation(intersection.getX() - (Road.ROAD_HEIGHT / 4), this.getY());
				this.turn(LEFT);
				alreadyTurned = true;
			}
			if((this.getX() - (intersection.getX() + (Road.ROAD_HEIGHT / 4))) <= 1 && randTurn == rightTurn && alreadyTurned == false) {
				this.setLocation(intersection.getX() + (Road.ROAD_HEIGHT / 4), this.getY());
				this.turn(RIGHT);
				alreadyTurned = true;
			}
		}
	}
	
	public void vertTurn() {
		int randTurn = rand.nextInt(30);
		int rightTurn = 1;
		int leftTurn = 2;
		
		if(this.getRotation() == Direction.South.getCarRotation()) {
			if((this.getY() - (intersection.getY() - (Road.ROAD_HEIGHT / 4))) <= 1 && randTurn == leftTurn && alreadyTurned == false) {
				this.setLocation(this.getX(), intersection.getY() - (Road.ROAD_HEIGHT / 4));
				this.turn(RIGHT);
				alreadyTurned = true;
			}
			if((this.getY() - (intersection.getY() + (Road.ROAD_HEIGHT / 4))) <= 1 && randTurn == rightTurn && alreadyTurned == false) {
				this.setLocation(this.getX(), intersection.getY() + (Road.ROAD_HEIGHT / 4));
				this.turn(LEFT);
				alreadyTurned = true;
			}
		}
		
		if(this.getRotation() == Direction.North.getCarRotation()) {
			if((this.getY() - (intersection.getY() - (Road.ROAD_HEIGHT / 4))) <= 1 && randTurn == rightTurn && alreadyTurned == false) {
				this.setLocation(this.getX(), intersection.getY() - (Road.ROAD_HEIGHT / 4));
				this.turn(LEFT);
				alreadyTurned = true;
			}
			if((this.getY() - (intersection.getY() + (Road.ROAD_HEIGHT / 4))) <= 1 && randTurn == leftTurn && alreadyTurned == false) {
				this.setLocation(this.getX(), intersection.getY() + (Road.ROAD_HEIGHT / 4));
				this.turn(RIGHT);
				alreadyTurned = true;
			}
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
