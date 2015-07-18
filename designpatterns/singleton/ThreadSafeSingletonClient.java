package designpatterns.singleton;

public class ThreadSafeSingletonClient {

	public static void main(String[] args) {
		ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
		System.out.println(singleton.getDescription());
	}
}
