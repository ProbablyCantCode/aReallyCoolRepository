package exercise6;

import exercise1.TrafficWorld;

public class Wrapping extends Car{
	public void act() {
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
		super.act();
		
	}

	@Override
	public void turn() {
		
	}
	
}
