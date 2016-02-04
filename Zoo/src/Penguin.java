
public class Penguin extends Tour implements Biome{

	public Penguin(String name) {
		super(name);
	}

	@Override
	protected String getSalutation() {
		return "Hello";
	}

	@Override
	public void livesIn() {
		System.out.println("I live in the cold Arctic!");
	}

}
