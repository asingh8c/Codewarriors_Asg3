package library.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Prateek
 *
 */

public class BookTest {

	Book book = new Book("Prateek Narang", "Welcome to JUnit Testing.", "IT678", 7895012);

	@Test
	public void testBook() {
		boolean status = book instanceof Book;
		assertTrue("Book created succesfully", status);
	}

	@Test
	public void testBorrow() {
		// TODO
		// Needs information from another entity
		// Will be done in integration testing
	}

	@Test
	public void testGetLoan() {
		// TODO
		// Needs information from another entity
		// Will be done in integration testing
	}

	@Test
	public void testReturnBook() {
		// TODO
		// Needs information from another entity
		// Will be done in integration testing
	}

	@Test
	public void testLose() {
		// TODO
		// Needs information from another entity
		// Will be done in integration testing
	}

	@Test
	public void testRepair() {
		// TODO
		// Needs information from another entity
		// Will be done in integration testing
	}

	@Test
	public void testDispose() {
		// TODO
		// Needs information from another entity
		// Will be done in integration testing
	}

	@Test
	public void testGetState() {
		// TODO
		// Needs information from another entity
		// Will be done in integration testing
	}

	@Test
	public void testGetAuthor() {
		String author = book.getAuthor();
		assertEquals("Prateek Narang", author);
	}

	@Test
	public void testGetTitle() {
		String title = book.getTitle();
		assertEquals("Welcome to JUnit Testing.", title);
	}

	@Test
	public void testGetCallNumber() {
		String callNumber = book.getCallNumber();
		assertEquals("IT678",callNumber);
	}

	@Test
	public void testGetID() {
		int id = book.getID();
		assertEquals(7895012, id);
	}
}
