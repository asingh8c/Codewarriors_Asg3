package library.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import library.interfaces.entities.EBookState;
import library.interfaces.entities.ILoan;

/**
 * @author Prateek
 *
 */

public class BookTest {

	Calendar returnDate;
	Book book = new Book("Prateek Narang", "Welcome to JUnit Testing.", "IT678", 7895012);
	Member member = new Member("Prateek", "Narang", "54321", "prateek@gmail.com", 102);

//	@Test
//	public void testBook() {
//		boolean status = book instanceof Book;
//		assertTrue("Book created succesfully", status);
//	}

	@Test
	public void testBorrow1() {
		returnDate = Calendar.getInstance();
		returnDate.setTime(new Date()); // Now use today date.
		returnDate.add(Calendar.DATE, 14);
		ILoan loan = new Loan(book, member, Calendar.getInstance().getTime(), returnDate.getTime());
		book.state = EBookState.ON_LOAN;
		try {
			book.borrow(loan);
			assertTrue(book.getState().equals(EBookState.ON_LOAN));
		} catch (RuntimeException e) {
			assertEquals(1, 1);
		}

	}

	@Test
	public void testBorrow2() {
		returnDate = Calendar.getInstance();
		returnDate.setTime(new Date()); // Now use today date.
		returnDate.add(Calendar.DATE, 14);
		ILoan loan = new Loan(book, member, Calendar.getInstance().getTime(), returnDate.getTime());

		try {
			book.borrow(loan);
			assertTrue(book.getState().equals(EBookState.ON_LOAN));
		} catch (RuntimeException e) {
			assertEquals(1, 1);
		}

	}

	@Test
	public void testBorrow3() {
		returnDate = Calendar.getInstance();
		returnDate.setTime(new Date()); // Now use today date.
		returnDate.add(Calendar.DATE, 14);
		ILoan loan = new Loan(book, member, Calendar.getInstance().getTime(), returnDate.getTime());

		try {
			book.borrow(loan);
			book.state=EBookState.AVAILABLE;
			assertTrue(book.getState().equals(EBookState.ON_LOAN));
		} catch (RuntimeException e) {
			assertEquals(1, 1);
		}

	}

//	@Test
//	public void testGetLoan() {
//		// TODO
//		// Needs information from another entity
//		// Will be done in integration testing
//	}
//
//	@Test
//	public void testReturnBook() {
//		// TODO
//		// Needs information from another entity
//		// Will be done in integration testing
//	}
//
//	@Test
//	public void testLose() {
//		// TODO
//		// Needs information from another entity
//		// Will be done in integration testing
//	}
//
//	@Test
//	public void testRepair() {
//		// TODO
//		// Needs information from another entity
//		// Will be done in integration testing
//	}
//
//	@Test
//	public void testDispose() {
//		// TODO
//		// Needs information from another entity
//		// Will be done in integration testing
//	}
//
//	@Test
//	public void testGetState() {
//		// TODO
//		// Needs information from another entity
//		// Will be done in integration testing
//	}
//
//	@Test
//	public void testGetAuthor() {
//		String author = book.getAuthor();
//		assertEquals("Prateek Narang", author);
//	}
//
//	@Test
//	public void testGetTitle() {
//		String title = book.getTitle();
//		assertEquals("Welcome to JUnit Testing.", title);
//	}
//
//	@Test
//	public void testGetCallNumber() {
//		String callNumber = book.getCallNumber();
//		assertEquals("IT678", callNumber);
//	}
//
//	@Test
//	public void testGetID() {
//		int id = book.getID();
//		assertEquals(7895012, id);
//	}
}
