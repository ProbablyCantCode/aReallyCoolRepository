package exercise6;

import java.util.ArrayList;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Intersection extends Actor {
	private static final int GREEN_COUNT = 375;
	private static final int YELLOW_COUNT = 25;
	private static final int RED_COUNT = GREEN_COUNT - (YELLOW_COUNT * 7);
	
	private final int east = 0;
	private final int west = 2;
	private final int north = 1;
	private final int south = 3;
	
	private ArrayList<IntersectionListener> innerPrevCars = new ArrayList<IntersectionListener>();
	private ArrayList<IntersectionListener> innerCurrCars = new ArrayList<IntersectionListener>();
	private ArrayList<IntersectionListener> outerPrevCars = new ArrayList<IntersectionListener>();
	private ArrayList<IntersectionListener> outerCurrCars = new ArrayList<IntersectionListener>();
	
	private TrafficLights[] lightPlacement = new TrafficLights[4];
	private int counter = 0;
	
	private TrafficLights.Colour verticalColour = TrafficLights.Colour.GREEN;
	private TrafficLights.Colour horizontalColour = TrafficLights.Colour.RED;
	
	public int carCounter = 0;
	
	public  Intersection() {
		GreenfootImage intersection = new GreenfootImage(Road.ROAD_HEIGHT, Road.ROAD_HEIGHT);
		setImage(intersection);
	}
	
	public void addLights() {
		for(int dir = 0; dir < lightPlacement.length; dir++) {
			lightPlacement[dir] = new TrafficLights(verticalColour);
			lightPlacement[dir].setRotation(dir * Direction.West.getLightRotation()); 
			if(lightPlacement[dir].getRotation() == Direction.South.getLightRotation() || lightPlacement[dir].getRotation() == Direction.North.getLightRotation()) {
				lightPlacement[dir].setColour(horizontalColour);
				if(lightPlacement[dir].getRotation() == Direction.North.getLightRotation()) {
					this.getWorld().addObject(lightPlacement[dir], this.getX(), (this.getY() - (Road.ROAD_HEIGHT/2)) - lightPlacement[dir].getImage().getHeight() / 2 );
				}
				if(lightPlacement[dir].getRotation() == Direction.South.getLightRotation()) {
					this.getWorld().addObject(lightPlacement[dir], this.getX(), (this.getY() + (Road.ROAD_HEIGHT/2)) + lightPlacement[dir].getImage().getHeight() / 2);
				}
			}
			else {
				if(lightPlacement[dir].getRotation() == Direction.East.getLightRotation() || lightPlacement[dir].getRotation() == Direction.West.getLightRotation()) {
					lightPlacement[dir].setColour(verticalColour);
					if(lightPlacement[dir].getRotation() == Direction.East.getLightRotation()) {
						this.getWorld().addObject(lightPlacement[dir], (this.getX() - (Road.ROAD_HEIGHT/2)) - lightPlacement[dir].getImage().getHeight() / 2, this.getY());
					}
					if(lightPlacement[dir].getRotation() == Direction.West.getLightRotation()) {
						this.getWorld().addObject(lightPlacement[dir], (this.getX() + (Road.ROAD_HEIGHT/2)) + lightPlacement[dir].getImage().getHeight() / 2, this.getY());
					}
				}
			}
		}
	}
	
	public void act() {
		counter++;
		
		switch(horizontalColour) {
		case GREEN:
			if(counter == GREEN_COUNT) {
				horizontalColour = TrafficLights.Colour.YELLOW;
				lightPlacement[east].setColour(horizontalColour);
				lightPlacement[west].setColour(horizontalColour);
				counter = 0;
			}
			break;
		case YELLOW:
			if(counter == YELLOW_COUNT) {
				horizontalColour = TrafficLights.Colour.RED;
				lightPlacement[east].setColour(horizontalColour);
				lightPlacement[west].setColour(horizontalColour);
				
				verticalColour = TrafficLights.Colour.GREEN;
				lightPlacement[north].setColour(verticalColour);
				lightPlacement[south].setColour(verticalColour);
			}
			break;
		case RED:
			if(counter == RED_COUNT) {
				horizontalColour = TrafficLights.Colour.GREEN;
				lightPlacement[east].setColour(horizontalColour);
				lightPlacement[west].setColour(horizontalColour);

				verticalColour = TrafficLights.Colour.RED;
				lightPlacement[north].setColour(verticalColour);
				lightPlacement[south].setColour(verticalColour);
			}
			if(counter == (RED_COUNT - YELLOW_COUNT)) {
				verticalColour = TrafficLights.Colour.YELLOW;
				lightPlacement[north].setColour(verticalColour);
				lightPlacement[south].setColour(verticalColour);
			}
			break;
		}
		
		notifyApproaching();
		notifyLeaving();
		notifyInside();
	}
	
	@SuppressWarnings("unchecked")
	public void notifyApproaching() {
		outerCurrCars = (ArrayList<IntersectionListener>) this.getObjectsInRange(75, IntersectionListener.class);
		for(IntersectionListener check: outerCurrCars) {
			if(!outerPrevCars.contains(check)) {
				check.notifyCarApproaching(this);
			}
		}
		
	}
	
	public void notifyLeaving() {
		for(IntersectionListener check: outerPrevCars) {
			if(!outerCurrCars.contains(check)) {
				check.notifyCarLeaving(this);
			}
		}
		outerPrevCars = outerCurrCars;
	}
	
	@SuppressWarnings("unchecked")
	public void notifyInside() {
		innerCurrCars = (ArrayList<IntersectionListener>) this.getObjectsInRange(Road.ROAD_HEIGHT, IntersectionListener.class);
		for(IntersectionListener check: innerCurrCars) {
			if(!innerPrevCars.contains(check)) {
				check.notifyCarInside(this);
				carCounter++;
			}
		}
		innerPrevCars = innerCurrCars;
		
	}
	
	public TrafficLights.Colour getHorzColour() {
		return horizontalColour;
	}
	
	public TrafficLights.Colour getVertColour() {
		return verticalColour;
	}

	@Override
	public String toString() {
		int x = this.getX();
		int y = this.getY();
		return "at " + x  + ", " + y;
	}
	
	
}
