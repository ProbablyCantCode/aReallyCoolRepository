package exercise4;

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
	
	Road[] HorizontalRoads = new Road[Y_ROADS];
	Road[] VerticalRoads = new Road[X_ROADS];
	
	
	public TrafficWorld() {
		super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);
		GreenfootImage background = this.getBackground();
		background.setColor(Color.GREEN);
		background.fill();
		
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
		
		for(int x = 0; x < X_ROADS; x++) {
			for(int y = 0; y < Y_ROADS; y++) {
				Intersection intersection = new Intersection();
				this.addObject(intersection, VerticalRoads[x].getX(), HorizontalRoads[y].getY());
				intersection.addLights();
			}
		}	
	}
	
	public void act() {
		Random num = new Random();
		int randNum = num.nextInt(50);
		if(randNum == 7) {
			RedCars red = new RedCars();
			BlueCars blue = new BlueCars();
			PurpleCars purple = new PurpleCars();
			YellowCars yellow = new YellowCars();
			Car[] cars = {
					red,
					blue,
					purple,
					yellow,
			};
			
			int randVert = num.nextInt(VerticalRoads.length);
			int randHorz = num.nextInt(HorizontalRoads.length);
			int randRota = num.nextInt(4);
			int randColour = num.nextInt(4);
			
			if(randRota == 0) {
				this.addObject(cars[randColour], 0, 0);
				cars[randColour].setRotation(0);
				cars[randColour].setLocation(0, HorizontalRoads[randHorz].getY() + Road.ROAD_HEIGHT / 4);
			}
			if(randRota == 1) {
				this.addObject(cars[randColour], 0, 0);
				cars[randColour].setRotation(90);
				cars[randColour].setLocation(VerticalRoads[randVert].getX() - (Road.ROAD_HEIGHT / 4), 0);
			}
			if(randRota == 2) {
				this.addObject(cars[randColour], 0, 0);
				cars[randColour].setRotation(180);
				cars[randColour].setLocation(WORLD_WIDTH, HorizontalRoads[randHorz].getY() - (Road.ROAD_HEIGHT / 4));
				
			}
			if(randRota == 3) {
				this.addObject(cars[randColour], 0, 0);
				cars[randColour].setRotation(270);
				cars[randColour].setLocation(VerticalRoads[randVert].getX() + (Road.ROAD_HEIGHT / 4), WORLD_HEIGHT);
			}
		}
	}
}
