
public abstract class Tour {
	protected String name;
	
	public Tour(String name) {
		this.name = name;
	}
	
	public String getGreeting() {
		String greeting = getSalutation() + ", I'm a " + getClass().getName() + " and my name is " + name;
		return greeting;
	}
	
	protected abstract String getSalutation();
	
}
