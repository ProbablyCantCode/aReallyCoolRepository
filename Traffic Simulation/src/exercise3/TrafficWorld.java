package exercise3;

import java.awt.Color;

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
		
		Road[] HorizontalRoads = new Road[Y_ROADS];
		Road[] VerticalRoads = new Road[X_ROADS];
		
		for(int n = 0; n < Y_ROADS; n++) {
			int Y_INC = (((Road.Y_GAP_SIZE + Road.ROAD_HEIGHT) * n) + (Road.ROAD_HEIGHT / 2));
			
			HorizontalRoads[n] = new Road();
			this.addObject(HorizontalRoads[n], (WORLD_WIDTH / 2), Y_INC);
		}
		
		for(int n = 0; n < X_ROADS; n++) {
			int X_INC = (((Road.X_GAP_SIZE + Road.ROAD_HEIGHT) * n) + (Road.ROAD_HEIGHT / 2));
			
			VerticalRoads[n] = new Road();
			this.addObject(VerticalRoads[n], X_INC, (WORLD_HEIGHT / 2));
			VerticalRoads[n].turn(90);
		}
		
		for(int n = 0; n < Y_ROADS; n++) {
			int Y_INC = (((Road.Y_GAP_SIZE + Road.ROAD_HEIGHT) * n) + (Road.ROAD_HEIGHT / 2)) - (Road.ROAD_HEIGHT / 4);
			
			Car car1 = new Car();
			this.addObject(car1, 0, (Y_INC + (Road.ROAD_HEIGHT / 2)));
			
			Car car2 = new Car();
			this.addObject(car2, WORLD_HEIGHT, Y_INC);
			car2.turn(180);
		}
		
		for(int n = 0; n < X_ROADS; n++) {
			int X_INC = (((Road.X_GAP_SIZE + Road.ROAD_HEIGHT) * n) + (Road.ROAD_HEIGHT / 2));
			
			Car car1 = new Car();
			this.addObject(car1, (X_INC - (Road.ROAD_HEIGHT / 4)), 0);
			car1.turn(90);
			
			Car car2 = new Car();
			this.addObject(car2, (X_INC + (Road.ROAD_HEIGHT / 4)), WORLD_WIDTH);
			car2.turn(270);
		}
		
		for(int x = 0; x < X_ROADS; x++) {
			for(int y = 0; y < Y_ROADS; y++) {
				Intersection intersection = new Intersection();
				this.addObject(intersection, VerticalRoads[x].getX(), HorizontalRoads[y].getY());
				intersection.addLights();
			}
		}	
	}
}
