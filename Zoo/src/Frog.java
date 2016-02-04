
public class Frog extends Tour implements Biome{

	public Frog(String name) {
		super(name);
	}

	@Override
	protected String getSalutation() {
		return "Hi";
	}

	@Override
	public void livesIn() {
		System.out.println("I live in the humid Jungle!");
		
	}

}
