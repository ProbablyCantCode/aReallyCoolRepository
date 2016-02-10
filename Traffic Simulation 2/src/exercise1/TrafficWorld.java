package exercise1;

import java.awt.Color;
import java.util.Random;

import greenfoot.GreenfootImage;
import greenfoot.World;

public class TrafficWorld extends World {
	public static final int WORLD_WIDTH = 1000;
	public static final int WORLD_HEIGHT = 750;
	private static final int CELL_SIZE = 1;
	
	public static final int Y_ROADS = 5;
	public static final int X_ROADS = 7;
	
	
	public TrafficWorld() {
		super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);
		GreenfootImage background = this.getBackground();
		background.setColor(Color.GREEN);
		background.fill();
		
		Random rand = new Random();
		
		for(int n = 0; n < Y_ROADS; n++) {
			int Y_INC = ((Road.Y_GAP_SIZE + Road.ROAD_HEIGHT) * n) + (Road.ROAD_HEIGHT / 2);
			
			Road road = new Road();
			this.addObject(road, (WORLD_WIDTH / 2), Y_INC);
		}
		
		for(int n = 0; n < X_ROADS; n++) {
			int X_INC = ((Road.X_GAP_SIZE + Road.ROAD_HEIGHT) * n) + (Road.ROAD_HEIGHT / 2);
			
			Road road = new Road();
			this.addObject(road, X_INC, (WORLD_HEIGHT / 2));
			road.turn(90);
		}
		
		for(int n = 0; n < Y_ROADS; n++) {
			int Y_INC = (((Road.Y_GAP_SIZE + Road.ROAD_HEIGHT) * n) + (Road.ROAD_HEIGHT / 2)) - (Road.ROAD_HEIGHT / 4);
			int xRandCarPlace = rand.nextInt(WORLD_HEIGHT);
			
			Car car1 = new Car();
			this.addObject(car1, xRandCarPlace, (Y_INC + (Road.ROAD_HEIGHT / 2)));
			
			Car car2 = new Car();
			this.addObject(car2, (WORLD_HEIGHT - xRandCarPlace), Y_INC);
			car2.turn(180);
		}
		
		for(int n = 0; n < X_ROADS; n++) {
			int X_INC = (((Road.X_GAP_SIZE + Road.ROAD_HEIGHT) * n) + (Road.ROAD_HEIGHT / 2));
			int yRandCarPlace = rand.nextInt(WORLD_WIDTH);
			
			Car car1 = new Car();
			this.addObject(car1, (X_INC - (Road.ROAD_HEIGHT / 4)), yRandCarPlace);
			car1.turn(90);
			
			Car car2 = new Car();
			this.addObject(car2, (X_INC + (Road.ROAD_HEIGHT / 4)), (WORLD_WIDTH - yRandCarPlace));
			car2.turn(270);
		}
	}

}
