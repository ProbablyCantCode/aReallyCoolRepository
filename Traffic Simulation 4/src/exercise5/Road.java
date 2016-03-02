package exercise5;

import java.awt.Color;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Road extends Actor {
	public static final int ROAD_HEIGHT = 50;
	
	public static final int X_GAP_SIZE = ((TrafficWorld.WORLD_WIDTH - (TrafficWorld.X_ROADS * ROAD_HEIGHT)) / (TrafficWorld.X_ROADS - 1));
	public static final int Y_GAP_SIZE = ((TrafficWorld.WORLD_HEIGHT - (TrafficWorld.Y_ROADS * ROAD_HEIGHT)) / (TrafficWorld.Y_ROADS - 1));
	
	public Road() {
		GreenfootImage image = new GreenfootImage(TrafficWorld.WORLD_WIDTH, ROAD_HEIGHT);
		this.setImage(image);
		image.setColor(Color.GRAY);
		image.fill();
	}
}
