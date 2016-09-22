package library.entities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MemberTest {
	private Member mem1=new Member("Prateek", "Narang", "12345", "prateekpnarang@gmail.com", 101);

	@Test
	public void testMember() {
		boolean b = mem1 instanceof Member;
		assertTrue(b);
	}

	@Test
	public void testHasOverDueLoans() {
		 // TODO
	}

	@Test
	public void testHasReachedLoanLimit() {
		 // TODO
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
