package designpatterns.singleton;

//NOTE: This is not thread safe!

public class ClassicSingleton {
	private static ClassicSingleton uniqueInstance;
	 
	private ClassicSingleton() {}
 
	public static ClassicSingleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ClassicSingleton();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
	public String getDescription() {
		return "I'm a classic Singleton!";
	}
}
