package exercise8;

import greenfoot.GreenfootImage;

public class PurpleCars extends LeaveWorld {
	public PurpleCars() {
		String carImage = "images\\topCarPurple.png";
		
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
		if(this.getRotation() == Direction.North.getCarRotation()) {
			if((this.getY() == (intersection.getY() - (Road.ROAD_HEIGHT / 4))) && alreadyTurned == false) {
				randTurn = rand.nextInt(3);
				if(randTurn == turn) {
					this.setLocation(this.getX(), intersection.getY() - (Road.ROAD_HEIGHT / 4));
					this.turn(LEFT);
					alreadyTurned = true;
				}
			}
		}
		if(this.getRotation() == Direction.South.getCarRotation()) {
			if((this.getY() == (intersection.getY() + (Road.ROAD_HEIGHT / 4))) && alreadyTurned == false) {
				randTurn = rand.nextInt(3);
				if(randTurn == turn) {
					this.setLocation(this.getX(), intersection.getY() + (Road.ROAD_HEIGHT / 4));
					this.turn(LEFT);
					alreadyTurned = true;
				}
			}
		}
		if(this.getRotation() == Direction.East.getCarRotation()) {
			if((this.getX() == (intersection.getX() + (Road.ROAD_HEIGHT / 4))) && alreadyTurned == false) {
				randTurn = rand.nextInt(3);
				if(randTurn == turn) {
					this.setLocation(intersection.getX() + (Road.ROAD_HEIGHT / 4), this.getY());
					this.turn(LEFT);
					alreadyTurned = true;
				}
			}
		}
		if(this.getRotation() == Direction.West.getCarRotation()) {
			if((this.getX() == (intersection.getX() - (Road.ROAD_HEIGHT / 4))) && alreadyTurned == false) {
				randTurn = rand.nextInt(3);
				if(randTurn == turn) {
					this.setLocation(intersection.getX() - (Road.ROAD_HEIGHT / 4), this.getY());
					this.turn(LEFT);
					alreadyTurned = true;
				}
			}
		}
	}
}
