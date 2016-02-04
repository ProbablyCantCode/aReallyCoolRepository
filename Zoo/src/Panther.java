
public class Panther extends Tour implements Biome{

	public Panther(String name) {
		super(name);
	}

	@Override
	protected String getSalutation() {
		return "Hey there";
	}

	@Override
	public void livesIn() {
		System.out.println("I live in the humid Jungle!");
	}

}
