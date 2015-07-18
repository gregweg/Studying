package OOP.BookReader;

import java.util.Set;

public class User {
	private long ID;
	private String details;
	private int accountType;
	private static Set<User> users;
	
	public Book searchLibrary(long id) { return Book.find(id); }
	public void renewMembership() { ... }
	public long getID() {
		return ID;
	}
	
	public static User find(long ID) {
		for (User u : users) {
			if (u.getID() == ID) return u;
		}
		return null;
	}
	
	public static void addUser(long ID, String details, int accountType) {
		users.add(new User(ID, details, accountType));
	}
	
	public User(long ID, String details, int accountType) {
		this.ID = ID;
		this.details = details;
		this.accountType = accountType;
	}
}
