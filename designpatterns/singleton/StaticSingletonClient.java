package designpatterns.singleton;

public class StaticSingletonClient {

	public static void main(String[] args) {
		StaticSingleton singleton = StaticSingleton.getInstance();
		System.out.println(singleton.getDescription());
	}
}
