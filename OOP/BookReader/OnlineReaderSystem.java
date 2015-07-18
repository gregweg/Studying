package OOP.BookReader;

public class OnlineReaderSystem {
	private Book b;
	private User u;
	public OnlineReaderSystem(Book b, User u)  { ... }
	public void listenRequest() { }
	public Book searchBook(long ID) { return Book.find(ID); }
	public User searchUser(long ID) { return User.find(ID); }
}
