package exercise5;

import greenfoot.GreenfootImage;

public class BlueCars extends LeaveWorld{
	public BlueCars() {
		String carImage = "images\\topCarBlue.png";
		
		GreenfootImage image = new GreenfootImage(carImage);
		this.setImage(image);
	}
	
	@Override
	public void act() {
		super.act();
		if(statisticCounter == 1) {
			if(state == Car.carState.INSIDE) {
				int count = CAR_STATS.get(getClass());
				if(count == 0) {
					CAR_STATS.put(getClass(), 1);
				}
				else {
					CAR_STATS.put(getClass(), ++count);
				}
			}
		}
	}
	
	@Override
	public void turn() {
		int turnLeft = 1;
		int turnRight = 2;
		
		if(this.getRotation() == Direction.North.getCarRotation()) {
			if(this.getY() - (intersection.getY() - (Road.ROAD_HEIGHT / 4)) <= 1 && alreadyTurned == false && turnLeft == alwaysTurn) {
				this.setLocation(this.getX(), intersection.getY() - (Road.ROAD_HEIGHT / 4));
				this.turn(LEFT);
				alwaysTurn++;
				alreadyTurned = true;			
			}
			if(this.getY() - (intersection.getY() + (Road.ROAD_HEIGHT / 4)) <= 1 && alreadyTurned == false && turnRight == alwaysTurn) {
				this.setLocation(this.getX(), intersection.getY() + (Road.ROAD_HEIGHT / 4));
				this.turn(RIGHT);
				alwaysTurn--;
				alreadyTurned = true;
			}
		}
		if(this.getRotation() == Direction.South.getCarRotation()) {
			if(this.getY() - (intersection.getY() + (Road.ROAD_HEIGHT / 4)) <= 1 && alreadyTurned == false && turnLeft == alwaysTurn) {
				this.setLocation(this.getX(), intersection.getY() + (Road.ROAD_HEIGHT / 4));
				this.turn(LEFT);
				alwaysTurn++;
				alreadyTurned = true;
			}
			if(this.getY() - (intersection.getY() - (Road.ROAD_HEIGHT / 4)) <= 1 && alreadyTurned == false && turnRight == alwaysTurn) {
				this.setLocation(this.getX(), intersection.getY() + (Road.ROAD_HEIGHT / 4));
				this.turn(RIGHT);
				alwaysTurn--;
				alreadyTurned = true;
			}
		}
		if(this.getRotation() == Direction.East.getCarRotation()) {
			if(this.getX() - (intersection.getX() + (Road.ROAD_HEIGHT / 4)) <= 1 && alreadyTurned == false && turnLeft == alwaysTurn) {
				this.setLocation(intersection.getX() + (Road.ROAD_HEIGHT / 4), this.getY());
				this.turn(LEFT);
				alwaysTurn++;
				alreadyTurned = true;
			}
			if(this.getX() - (intersection.getX() - (Road.ROAD_HEIGHT / 4)) <= 1 && alreadyTurned == false && turnRight == alwaysTurn) {
				this.setLocation(intersection.getX() - (Road.ROAD_HEIGHT / 4), this.getY());
				this.turn(RIGHT);
				alwaysTurn--;
				alreadyTurned = true;
			}
		}
		if(this.getRotation() == Direction.West.getCarRotation()) {
			if(this.getX() - (intersection.getX() - (Road.ROAD_HEIGHT / 4)) <= 1 && alreadyTurned == false && turnLeft == alwaysTurn) {
				this.setLocation(intersection.getX() - (Road.ROAD_HEIGHT / 4), this.getY());
				this.turn(LEFT);
				alwaysTurn++;
				alreadyTurned = true;
			}
			if(this.getX() - (intersection.getX() + (Road.ROAD_HEIGHT / 4)) <= 1 && alreadyTurned == false && turnRight == alwaysTurn) {
				this.setLocation(intersection.getX() + (Road.ROAD_HEIGHT / 4), this.getY());
				this.turn(RIGHT);
				alwaysTurn--;
				alreadyTurned = true;
			}
		}
	}
	
}
