package exercise5;

public class LeaveWorld extends Car{
	public void act() {
		super.act();
		if(!dead) {
			if(isAtEdge()) {
				getWorld().removeObject(this);
			}
		}
	}

	@Override
	public void turn() {
		
	}

}
