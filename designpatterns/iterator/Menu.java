package designpatterns.iterator;

import java.util.Iterator;

public interface Menu {
	public Iterator<String> createIterator();
}
