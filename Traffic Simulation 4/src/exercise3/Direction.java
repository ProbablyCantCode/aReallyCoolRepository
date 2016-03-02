package exercise3;

public enum Direction {
	North(0, 270),
	South(180, 90),
	East(270, 0),
	West(90, 180);
	
	private int lightRotation;
	private int carRotation;
	
	private Direction(int lightRotation, int carRotation) {
		this.lightRotation = lightRotation;
		this.carRotation = carRotation;
	}

	public int getLightRotation() {
		return lightRotation;
	}

	public int getCarRotation() {
		return carRotation;
	}
	
}
