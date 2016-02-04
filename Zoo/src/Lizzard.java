
public class Lizzard extends Tour implements Biome{

	public Lizzard(String name) {
		super(name);
	}

	@Override
	protected String getSalutation() {
		return "Howdy";
	}

	@Override
	public void livesIn() {
		System.out.println("I live in the scorching Desert!");
	}

}
