package library.entities;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import library.interfaces.entities.ELoanState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.IMember;
/**
* @author krishanthi
*
*/
public class LoanTest {
		private static Loan loan1;
	    private int id;
	    private IMember borrower;
	    private IBook book;
	    private Date borrowDate;
	    private Date dueDate;
	    private ELoanState state;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		loan1 =new Loan( Krishanthi,"Welcome to JUnit Testing",10/9/2016,15/9/2016)
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoan() {
		fail("Not yet implemented"); //have to implement
	}

	@Test
	public void testCommit() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testComplete() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testIsOverDue() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testCheckOverDue() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testGetBorrower() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testGetBook() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testGetID() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testGetState() {
		fail("Not yet implemented");//have to implement
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");//have to implement
	}

}
