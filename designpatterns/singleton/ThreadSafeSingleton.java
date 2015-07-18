package designpatterns.singleton;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton uniqueInstance;

 
	private ThreadSafeSingleton() {}
 
	public static synchronized ThreadSafeSingleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ThreadSafeSingleton();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
	public String getDescription() {
		return "I'm a thread safe Singleton!";
	}
}
