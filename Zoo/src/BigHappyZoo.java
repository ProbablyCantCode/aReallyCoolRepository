import java.util.ArrayList;

public class BigHappyZoo {
	private ArrayList<Tour> tours = new ArrayList<Tour>();
	
	public void addToTour(Tour tour) {
		tours.add(tour);
	}
	
	public void giveTour() {
		for(Tour t : tours) {
			System.out.println(t.getGreeting());
			if(t instanceof Biome) {
				Biome b = (Biome) t;
				b.livesIn();
			}
		}
	}
	
	public static void main(String[] args) {
		BigHappyZoo zoo = new BigHappyZoo();
		
		PolarBear polarBear = new PolarBear("Philip");
		zoo.addToTour(polarBear);
		Penguin penguin = new Penguin("Patricia");
		zoo.addToTour(penguin);
		Panther panther = new Panther("Paul");
		zoo.addToTour(panther);
		Lizzard lizzard = new Lizzard("Lisa");
		zoo.addToTour(lizzard);
		Camel camel = new Camel("Carl");
		zoo.addToTour(camel);
		Frog frog = new Frog("Fred");
		zoo.addToTour(frog);
		
		zoo.giveTour();
	}

}
