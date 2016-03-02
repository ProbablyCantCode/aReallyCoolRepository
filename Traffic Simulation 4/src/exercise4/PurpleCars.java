package exercise4;

import greenfoot.GreenfootImage;

public class PurpleCars extends LeaveWorld {
	public PurpleCars() {
		String carImage = "images\\topCarPurple.png";
		
		GreenfootImage image = new GreenfootImage(carImage);
		this.setImage(image);
	}
	
	public void act() {
		super.act();
		
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
