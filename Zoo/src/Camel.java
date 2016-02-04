
public class Camel extends Tour implements Biome{

	public Camel(String name) {
		super(name);
	}

	@Override
	protected String getSalutation() {
		return "Hey";
	}

	@Override
	public void livesIn() {
		System.out.println("I live in the scorching Desert!");
		
	}

}
