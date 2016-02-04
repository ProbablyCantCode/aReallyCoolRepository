
public class PolarBear extends Tour implements Biome{

	public PolarBear(String name) {
		super(name);
	}

	@Override
	protected String getSalutation() {
		return "What's Up?";
	}

	@Override
	public void livesIn() {
		System.out.println("I live in the cold Arctic!");
	}

}
