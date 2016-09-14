/**
 * 
 */
package library.daos;

import library.interfaces.daos.IBookHelper;
import library.interfaces.entities.IBook;

/**
 * @author Thilini
 *
 */
public class BookHelper implements IBookHelper {

	/* (non-Javadoc)
	 * @see library.interfaces.daos.IBookHelper#makeBook(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	public IBook makeBook(String author, String title, String callNumber, int id) {
		return new Book(author, title, callNumber, id);
	}

}
