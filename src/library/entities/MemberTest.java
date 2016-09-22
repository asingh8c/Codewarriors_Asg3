package library.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import library.daos.BookHelper;
import library.daos.BookMapDAO;
import library.daos.LoanHelper;
import library.daos.LoanMapDAO;
import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;

public class MemberTest {
	private Member mem1;
	private Member mem2;
	private Member mem3;
	private ILoanDAO loanDAO = new LoanMapDAO(new LoanHelper());
	private IBookDAO bookDAO = new BookMapDAO(new BookHelper());
	IBook[] book = new IBook[10];

	@Before
	public void setUp() throws Exception {
		mem1 = new Member("Prateek", "Narang", "54321", "prateek@gmail.com", 101);
		mem2 = new Member("Asmita", "Singh", "12345", "asmita@gmail.com", 102);
		mem3 = new Member("Krishanthi", "Wickram", "98765", "krishanthi@gmail.com", 103);

		book[0] = bookDAO.addBook("testAuthor1", "testTitle1", "testCallNo1");
		book[1] = bookDAO.addBook("testAuthor2", "testTitle2", "testCallNo2");
		book[2] = bookDAO.addBook("testAuthor1", "testTitle3", "testCallNo3");
		book[3] = bookDAO.addBook("testAuthor2", "testTitle4", "testCallNo4");
		book[4] = bookDAO.addBook("testAuthor3", "testTitle4", "testCallNo5");
		book[5] = bookDAO.addBook("testAuthor3", "testTitle1", "testCallNo6");

		// create a member with three book loans
		for (int i = 0; i < 5; i++) {
			ILoan loan = loanDAO.createLoan(mem1, book[i]);
			loanDAO.commitLoan(loan);
		}
	}

	@Test
	public void testMember() {
		boolean b = mem1 instanceof Member;
		assertTrue(b);
	}

	@Test
	public void testHasOverDueLoans() {
		assertFalse(mem1.hasOverDueLoans());
		// add an overdue book then test
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		cal.setTime(now);
		cal.add(Calendar.DATE, ILoan.LOAN_PERIOD + 1);
		Date checkDate = cal.getTime();
		loanDAO.updateOverDueStatus(checkDate);// pass the overdue date
		assertTrue(mem1.hasOverDueLoans());
	}

	@Test
	public void testHasReachedLoanLimit() {
		// Returns false when there is member who has no book added to loan list
		assertFalse(mem2.hasReachedLoanLimit());
		// Returns true when there is member who has 5 book added to loan list
		assertTrue(mem1.hasReachedLoanLimit());

	}

	@Test
	public void testHasFinesPayable() {
		// TODO
	}

	@Test
	public void testHasReachedFineLimit() {
		// TODO
	}

	@Test
	public void testGetFineAmount() {
		// TODO
	}

	@Test
	public void testAddFine() {
		// TODO
	}

	@Test
	public void testPayFine() {
		// TODO
	}

	@Test
	public void testAddLoan() {
		// TODO
	}

	@Test
	public void testGetLoans() {
		// TODO
	}

	@Test
	public void testRemoveLoan() {
		// TODO
	}

	@Test
	public void testGetState() {
		// TODO
	}

	@Test
	public void testGetFirstName() {
		// TODO
	}

	@Test
	public void testGetLastName() {
		// TODO
	}

	@Test
	public void testGetContactPhone() {
		// TODO
	}

	@Test
	public void testGetEmailAddress() {
		// TODO
	}

	@Test
	public void testGetID() {
		// TODO
	}

}
