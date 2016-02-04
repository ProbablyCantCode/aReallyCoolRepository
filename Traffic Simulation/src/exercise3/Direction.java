package exercise3;

public enum Direction {
	North(0),
	South(180),
	East(270),
	West(90);
	
	private int direction;
	
	private Direction(int rotation) {
		this.direction = rotation;
	}
	
	int getDirection() {
		return direction;
	}

}
