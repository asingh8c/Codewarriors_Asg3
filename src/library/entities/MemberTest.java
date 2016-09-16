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
import library.daos.*;

public class MemberTest {

	private Member mem1;
	private Member mem2;
	private Member mem3;
	private ILoanDAO loanDAO = new LoanMapDAO(new LoanHelper());
	private IBookDAO bookDAO = new BookMapDAO(new BookHelper());
	private ILoan loan;
	IBook[] book = new IBook[10];

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mem1 = new Member("Asmita", "Singh", "12345", "asmita@gmail.com", 101);
		mem2 = new Member("Prateek", "Narang", "54321", "prateek@gmail.com", 102);
		mem3 = new Member("Krishanthi", "Wickram", "98765", "krishanthi@gmail.com", 103);

		book[0] = bookDAO.addBook("author1", "title1", "callNo1");
		book[1] = bookDAO.addBook("author2", "title2", "callNo2");
		book[2] = bookDAO.addBook("author1", "title3", "callNo3");
		book[3] = bookDAO.addBook("author2", "title4", "callNo4");
		book[4] = bookDAO.addBook("author3", "title4", "callNo5");
		book[5] = bookDAO.addBook("author3", "title1", "callNo6");

		// create a member with three book loans
		for (int i = 0; i < 5; i++) {
			ILoan loan = loanDAO.createLoan(mem1, book[i]);
			loanDAO.commitLoan(loan);
		}
	}

	/**
	 * Test method for
	 * {@link library.entities.Member#Member(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testMember() {
		boolean b = mem1 instanceof Member;
		assertTrue(b);
	}

	/**
	 * Test method for {@link library.entities.Member#hasOverDueLoans()}.
	 */
	@Test
	public final void testHasOverDueLoans() {
		// check if there any book loan overdue it returns false as new member
		// has no loan record
		assertFalse(mem1.hasOverDueLoans());
		// add an overdue book then test
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		cal.setTime(now);
		cal.add(Calendar.DATE, ILoan.LOAN_PERIOD + 1);
		Date checkDate = cal.getTime();
		loanDAO.updateOverDueStatus(checkDate);
		assertTrue(mem1.hasOverDueLoans());

	}

	/**
	 * Test method for {@link library.entities.Member#hasReachedLoanLimit()}.
	 */
	@Test
	public final void testHasReachedLoanLimit() {
		// Returns false when there is member who has no book added to loan list
		assertFalse(mem2.hasReachedLoanLimit());
		// Returns true when there is member who has 5 book added to loan list
		assertTrue(mem1.hasReachedLoanLimit());

	}

	/**
	 * Test method for {@link library.entities.Member#hasFinesPayable()}.
	 */
	@Test
	public final void testHasFinesPayable() {
		// Returns false when member has no fines in account
		assertFalse(mem1.hasFinesPayable());
		// Add some fine and check again
		mem1.addFine(5.0f);
		assertTrue(mem1.hasFinesPayable());
	}

	/**
	 * Test method for {@link library.entities.Member#hasReachedFineLimit()}.
	 */
	@Test
	public final void testHasReachedFineLimit() {
		// Returns false is member has no fine and thus not reached fine limit
		assertFalse(mem1.hasReachedFineLimit());
		// Returns false is fine added is less than limit
		mem1.addFine(8.0f);
		assertFalse(mem1.hasReachedFineLimit());
		mem1.addFine(3.0f);
		assertTrue(mem1.hasReachedFineLimit());
	}

	/**
	 * Test method for {@link library.entities.Member#getFineAmount()}.
	 */
	@Test
	public final void testGetFineAmount() {
		mem1.addFine(5.0f);
		assertTrue(5.0f == mem1.getFineAmount());
	}

	/**
	 * Test method for {@link library.entities.Member#addFine(float)}.
	 */
	@Test
	public final void testAddFine() {
		float initialFine = mem1.getFineAmount();
		mem1.addFine(5.0f);
		assertTrue((initialFine + 5.0f) == mem1.getFineAmount()); // Compare
																	// fine
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
		mem1.addFine(8.0f);
		mem1.payFine(5.0f);
		assertTrue(3.0f == mem1.getFineAmount());
	}

	/**
	 * Test method for
	 * {@link library.entities.Member#addLoan(library.interfaces.entities.ILoan)}.
	 */
	@Test
	public final void testAddLoan() {
		Calendar returnDate = Calendar.getInstance();
		returnDate.setTime(new Date()); // Now use today date.
		returnDate.add(Calendar.DATE, 15);
		ILoan loan = new Loan(book[5], mem3, Calendar.getInstance().getTime(), returnDate.getTime());
		// Now test if new loan is added to list
		int prevListSize = mem3.getLoans().size();
		mem3.addLoan(loan);
		int newListSize = mem3.getLoans().size();
		// testing add loan as loan list size will increment by one if loan is
		// added to list
		assertTrue(prevListSize == newListSize - 1);

	}

	/**
	 * Test method for {@link library.entities.Member#getLoans()}.
	 */
	@Test
	public final void testGetLoans() {
		// Empty list as no book added
		assertTrue(mem1.getLoans().size() != 0);
	}

	/**
	 * Test method for
	 * {@link library.entities.Member#removeLoan(library.interfaces.entities.ILoan)}.
	 */
	@Test
	public final void testRemoveLoan() {
		Calendar returnDate = Calendar.getInstance();
		returnDate.setTime(new Date()); // Now use today date.
		returnDate.add(Calendar.DATE, 15);
		ILoan loan1 = new Loan(book[5], mem3, Calendar.getInstance().getTime(), returnDate.getTime());
		ILoan loan2 = new Loan(book[3], mem3, Calendar.getInstance().getTime(), returnDate.getTime());
		// add both the loans to loan list
		mem3.addLoan(loan1);
		mem3.addLoan(loan2);
		// Record loan list size before removing any
		int prevListSize = mem3.getLoans().size();
		// remove loan1 from list
		mem3.removeLoan(loan1);
		// Record new list size after removing one loan from list
		int newListSize = mem3.getLoans().size();
		// testing add loan as loan list size will decrement by one if a loan is
		// removed from list
		assertTrue(prevListSize == newListSize + 1);
	}

	/**
	 * Test method for {@link library.entities.Member#getState()}.
	 */
	@Test
	public final void testGetState() {
		// check initial state set for member who has no fine overdue or books
		// overdue
		assertTrue(EMemberState.BORROWING_ALLOWED == mem2.getState());
		// check state set for member who has books overdue
		assertTrue(EMemberState.BORROWING_DISALLOWED == mem1.getState());
	}

	/**
	 * Test method for {@link library.entities.Member#getFirstName()}.
	 */
	@Test
	public final void testGetFirstName() {
		String fName = mem1.getFirstName();
		assertEquals("Matching First Name", "Asmita", fName);
	}

	/**
	 * Test method for {@link library.entities.Member#getLastName()}.
	 */
	@Test
	public final void testGetLastName() {
		String lName = mem1.getLastName();
		assertEquals("Matching Last Name", "Singh", lName);
	}

	/**
	 * Test method for {@link library.entities.Member#getContactPhone()}.
	 */
	@Test
	public final void testGetContactPhone() {
		String contNum = mem1.getContactPhone();
		assertEquals("Matching Contact Number", "12345", contNum);
	}

	/**
	 * Test method for {@link library.entities.Member#getEmailAddress()}.
	 */
	@Test
	public final void testGetEmailAddress() {
		String email = mem1.getEmailAddress();
		assertEquals("Matching email", "asmita@gmail.com", email);
	}

	/**
	 * Test method for {@link library.entities.Member#getID()}.
	 */
	@Test
	public final void testGetID() {
		int id = mem1.getID();
		assertEquals("Matching Member Id", 101, id);
	}

}
