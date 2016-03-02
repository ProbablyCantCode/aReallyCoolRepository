package exercise5;

import greenfoot.GreenfootImage;

public class RedCars extends Wrapping{
	public RedCars() {
		String carImage = "images\\topCarRed.png";
		
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
	
}
