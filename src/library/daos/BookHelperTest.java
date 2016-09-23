/**
 * 
 */
package library.daos;

import junit.framework.TestCase;
import library.interfaces.daos.IBookHelper;
import library.interfaces.entities.IBook;

/**
 * @author 11580359
 *
 */
public class BookHelperTest extends TestCase {
	private IBookHelper helper;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		helper = new BookHelper();
	}

	/**
	 * Test method for {@link library.daos.BookHelper#makeBook(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	public void testMakeBook() {
		IBook book = helper.makeBook("Krish Dall", "Proffessional pro practise", "0456885299", 1);
		assertNotNull(book);
		assertEquals(1, book.getID());
	}

}
