package exercise3;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Explosion extends Actor{
	String[] explosion = {"images\\explosion1.png", "images\\explosion2.png", "images\\explosion3.png"};
	private int counter = 0;
	
	public Explosion() {
		act();
		
	}
	
	public void act() {
		switch(counter) {
		case 0:
			GreenfootImage explosion1 = new GreenfootImage(explosion[0]);
			this.setImage(explosion1);
			break;
		case 20:
			GreenfootImage explosion2 = new GreenfootImage(explosion[1]);
			this.setImage(explosion2);
			break;
		case 40:
			GreenfootImage explosion3 = new GreenfootImage(explosion[2]);
			this.setImage(explosion3);
			break;
		case 60:
			getWorld().removeObject(this);
			counter = 0;
			break;
		}
		counter++;
	}

}
