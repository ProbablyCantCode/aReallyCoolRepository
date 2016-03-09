package exercise4;

import greenfoot.GreenfootImage;

public class RedCars extends Wrapping{
	public RedCars() {
		String carImage = "images\\topCarRed.png";
		
		GreenfootImage image = new GreenfootImage(carImage);
		this.setImage(image);
	}
	
	public void act() {
		super.act();
	}
}
