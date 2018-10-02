package coreProfHwLesson1;

public class Fruit {
	
	private int weight;

	public Fruit(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		
		return getClass().getSimpleName() + weight + "г";
	}
	
	
}
