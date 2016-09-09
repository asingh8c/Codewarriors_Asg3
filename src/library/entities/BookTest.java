package library.entities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * @author Prateek
 *
 */

public class BookTest {

	Book book=new Book("Prateek Narang","Welcome to JUnit Testing.","IT678",7895012);

	@Test
	public void testBook() {
		boolean status = book instanceof Book;
		assertTrue("Book created succesfully",status);
	}

	@Test
	public void testBorrow() {
		// TODO
		//Needs information from another entity
		//Will be done in integration testing
	}

	@Test
	public void testGetLoan() {
		 // TODO
	}

	@Test
	public void testReturnBook() {
		// TODO
	}

	@Test
	public void testLose() {
		 // TODO
	}

	@Test
	public void testRepair() {
		// TODO
	}

	@Test
	public void testDispose() {
		// TODO
	}

	@Test
	public void testGetState() {
		 // TODO
	}

	@Test
	public void testGetAuthor() {
		 // TODO
	}

	@Test
	public void testGetTitle() {
		 // TODO
	}

	@Test
	public void testGetCallNumber() {
		// TODO
	}

	@Test
	public void testGetID() {
		 // TODO
	}

	@Test
	public void testToString() {
		 // TODO
	}

}
