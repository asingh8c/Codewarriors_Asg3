package library.entities;

import static org.junit.Assert.*;
import java.util.*;

//import java.util.Date;

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
		

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Book b1= new Book("Krishanthi", "Welcome to JUnit testing", "123456", 9999);
		Member m1= new Member("Krishanthi","Wickramasooriya","123456","krishanthi@gmail.com",1234);
		Date d1 = (new GregorianCalendar(2016, 9, 15)).getTime();
		Date d2= new Date();
		
	
		//Date d2 = new Date(2016, 10, 15);
		
		
		

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
