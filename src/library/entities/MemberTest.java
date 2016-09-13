/**
 * 
 */
package library.entities;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.entities.EMemberState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

/**
 * @author asmita
 *
 */
public class MemberTest {

	private Member mem;
	private ILoanDAO loanDAO;
	private IBookDAO bookDAO;
	private ILoan loan;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mem = new Member("Asmita", "Singh", "12345", "asmita@gmail.com", 101);
		/**
		 * IBook[] book = new IBook[4]; book[0] = bookDAO.addBook("author1",
		 * "title1", "callNo1"); book[1] = bookDAO.addBook("author1", "title2",
		 * "callNo2"); book[2] = bookDAO.addBook("author1", "title3",
		 * "callNo3"); book[3] = bookDAO.addBook("author1", "title4",
		 * "callNo4"); book[4] = bookDAO.addBook("author2", "title5",
		 * "callNo5");
		 * 
		 * 
		 * //create a member with three book loans for (int i=0; i<3; i++) {
		 * ILoan loan = loanDAO.createLoan(mem, book[i]);
		 * loanDAO.commitLoan(loan); }
		 **/

	}

	/**
	 * Test method for
	 * {@link library.entities.Member#Member(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testMember() {
		boolean b = mem instanceof Member;
		assertTrue(b);
	}

	/**
	 * Test method for {@link library.entities.Member#hasOverDueLoans()}.
	 */
	@Test
	public final void testHasOverDueLoans() {
		// check if there any book loan overdue it returns false as new member
		// has no loan record
		assertFalse(mem.hasOverDueLoans());
		/** add an overdue book then test
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		cal.setTime(now);
		cal.add(Calendar.DATE, ILoan.LOAN_PERIOD + 1);
		Date checkDate = cal.getTime();
		loanDAO.updateOverDueStatus(checkDate);
		assertTrue(mem.hasOverDueLoans());
		**/

	}

	/**
	 * Test method for {@link library.entities.Member#hasReachedLoanLimit()}.
	 */
	@Test
	public final void testHasReachedLoanLimit() {
		// Returns false when there is member who has no book added to loan list
		assertFalse(mem.hasReachedLoanLimit());
	}

	/**
	 * Test method for {@link library.entities.Member#hasFinesPayable()}.
	 */
	@Test
	public final void testHasFinesPayable() {
		// Returns false when member has no fines in account
		assertFalse(mem.hasFinesPayable());
		// Add some fine and check again
		mem.addFine(5.0f);
		assertTrue(mem.hasFinesPayable());
	}

	/**
	 * Test method for {@link library.entities.Member#hasReachedFineLimit()}.
	 */
	@Test
	public final void testHasReachedFineLimit() {
		// Returns false is member has no fine and thus not reached fine limit
		assertFalse(mem.hasReachedFineLimit());
		// Returns false is fine added is less than limit
		mem.addFine(8.0f);
		assertFalse(mem.hasReachedFineLimit());
		mem.addFine(3.0f);
		assertTrue(mem.hasReachedFineLimit());
	}

	/**
	 * Test method for {@link library.entities.Member#getFineAmount()}.
	 */
	@Test
	public final void testGetFineAmount() {
		mem.addFine(5.0f);
		assertTrue(5.0f == mem.getFineAmount());
	}

	/**
	 * Test method for {@link library.entities.Member#addFine(float)}.
	 */
	@Test
	public final void testAddFine() {
		float initialFine = mem.getFineAmount();
		mem.addFine(5.0f);
		assertTrue((initialFine + 5.0f) == mem.getFineAmount()); // Compare fine
																	// added to
																	// actual
																	// value
	}

	/**
	 * Test method for {@link library.entities.Member#payFine(float)}.
	 */
	@Test
	public final void testPayFine() {
		// add fine amount and then pay some, check the remaining fine value to
		// compare
		mem.addFine(8.0f);
		mem.payFine(5.0f);
		assertTrue(3.0f == mem.getFineAmount());
	}

	/**
	 * Test method for
	 * {@link library.entities.Member#addLoan(library.interfaces.entities.ILoan)}.
	 */
	@Test
	public final void testAddLoan() {
		fail("Not yet implemented"); // TODO Need Book & loan entity to test
	}

	/**
	 * Test method for {@link library.entities.Member#getLoans()}.
	 */
	@Test
	public final void testGetLoans() {
		// Empty list as no book added
		assertTrue(mem.getLoans().size() == 0);
	}

	/**
	 * Test method for
	 * {@link library.entities.Member#removeLoan(library.interfaces.entities.ILoan)}.
	 */
	@Test
	public final void testRemoveLoan() {
		fail("Not yet implemented"); // TODO Need Book & loan entity to test
	}

	/**
	 * Test method for {@link library.entities.Member#getState()}.
	 */
	@Test
	public final void testGetState() {
		// check initial state set
		assertTrue(EMemberState.BORROWING_ALLOWED == mem.getState());
	}

	/**
	 * Test method for {@link library.entities.Member#getFirstName()}.
	 */
	@Test
	public final void testGetFirstName() {
		String fName = mem.getFirstName();
		assertEquals("Matching First Name", "Asmita", fName);
	}

	/**
	 * Test method for {@link library.entities.Member#getLastName()}.
	 */
	@Test
	public final void testGetLastName() {
		String lName = mem.getLastName();
		assertEquals("Matching Last Name", "Singh", lName);
	}

	/**
	 * Test method for {@link library.entities.Member#getContactPhone()}.
	 */
	@Test
	public final void testGetContactPhone() {
		String contNum = mem.getContactPhone();
		assertEquals("Matching Contact Number", "12345", contNum);
	}

	/**
	 * Test method for {@link library.entities.Member#getEmailAddress()}.
	 */
	@Test
	public final void testGetEmailAddress() {
		String email = mem.getEmailAddress();
		assertEquals("Matching email", "asmita@gmail.com", email);
	}

	/**
	 * Test method for {@link library.entities.Member#getID()}.
	 */
	@Test
	public final void testGetID() {
		int id = mem.getID();
		assertEquals("Matching Member Id", 101, id);
	}

}
