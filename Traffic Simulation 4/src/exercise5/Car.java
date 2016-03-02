package exercise5;

import java.util.HashMap;
import java.util.Random;

import greenfoot.Actor;

public abstract class Car extends Actor implements IntersectionListener{
	public static enum carState {
		OUTSIDE,
		APPROACHING,
		INSIDE
	}
	
	Random rand = new Random();
	protected carState state = carState.APPROACHING;
	protected Intersection intersection;
	@SuppressWarnings("rawtypes")
	public static HashMap<Class, Integer> CAR_STATS = new HashMap<Class, Integer>();
	protected int statisticCounter = 0;
	
	private final int FULL_SPEED = 3;
	private final int SLOW_DOWN = 1;
	private final int STOPPED = 0;
	private int currSpeed = FULL_SPEED;
	
	protected final int LEFT = 270;
	protected final int RIGHT = 90;
	
	private Car secondCar;
	private Explosion explosion = new Explosion();
	protected boolean alreadyTurned = false;
	
	protected int randTurn;
	protected int turn = 0;
	protected int alwaysTurn = 1;
	protected boolean dead = false;
	
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
			statisticCounter = 0;
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
					turn();
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
					turn();
				}
			}
			
			break;
		}
		statisticCounter++;
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
			dead = true;
			
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
	
	public static void carStatistics() {
		System.out.println("Number of Red Cars that crossed intersections: " + CAR_STATS.get(RedCars.class));
		System.out.println("Number of Blue Cars that crossed intersections: " + CAR_STATS.get(BlueCars.class));
		System.out.println("Number of Yellow Cars that crossed intersections: " + CAR_STATS.get(YellowCars.class));
		System.out.println("Number of Purple Cars that crossed intersections: " + CAR_STATS.get(PurpleCars.class));
		
	}
	
	public abstract void turn();

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
