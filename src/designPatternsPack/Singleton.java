package designPatternsPack;

public class Singleton {

	private static Singleton instance;
	private Singleton() {
		// private constructor 
	}
	
	public Singleton getInstance()
	{
		if(instance == null)
		instance = new Singleton();
		return instance;
	}
}
