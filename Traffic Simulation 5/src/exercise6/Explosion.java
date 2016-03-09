package exercise6;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Explosion extends Actor{
	String[] explosion = {"images\\explosion1.png", "images\\explosion2.png", "images\\explosion3.png"};
	private int counter = 0;
	private int image = 0;
	
	public Explosion() {
		act();
		
	}
	
	public void act() {
		switch(counter) {
		case 0:
			GreenfootImage explosion1 = new GreenfootImage(explosion[image]);
			this.setImage(explosion1);
			image = 1;
			break;
		case 20:
			GreenfootImage explosion2 = new GreenfootImage(explosion[image]);
			this.setImage(explosion2);
			image = 2;
			break;
		case 40:
			GreenfootImage explosion3 = new GreenfootImage(explosion[image]);
			this.setImage(explosion3);
			image = 0;
			break;
		case 60:
			getWorld().removeObject(this);
			counter = 0;
			break;
		}
		counter++;
	}

}
