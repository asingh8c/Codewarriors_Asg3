/**
 * 
 */
package library.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import library.interfaces.entities.IMember;

/**
 * @author asmita
 *
 */
public class MemberTest {
	
	private Member mem;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mem = new Member("Asmita","Singh","12345","asmita@gmail.com",101);
	}

	/**
	 * Test method for {@link library.entities.Member#Member(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public final void testMember() {
		boolean b = mem instanceof Member;
		assertTrue("Member created",b);
	}

	/**
	 * Test method for {@link library.entities.Member#hasOverDueLoans()}.
	 */
	@Test
	public final void testHasOverDueLoans() {
		 // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#hasReachedLoanLimit()}.
	 */
	@Test
	public final void testHasReachedLoanLimit() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#hasFinesPayable()}.
	 */
	@Test
	public final void testHasFinesPayable() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#hasReachedFineLimit()}.
	 */
	@Test
	public final void testHasReachedFineLimit() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#getFineAmount()}.
	 */
	@Test
	public final void testGetFineAmount() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#addFine(float)}.
	 */
	@Test
	public final void testAddFine() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#payFine(float)}.
	 */
	@Test
	public final void testPayFine() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#addLoan(library.interfaces.entities.ILoan)}.
	 */
	@Test
	public final void testAddLoan() {
		mem
	}

	/**
	 * Test method for {@link library.entities.Member#getLoans()}.
	 */
	@Test
	public final void testGetLoans() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#removeLoan(library.interfaces.entities.ILoan)}.
	 */
	@Test
	public final void testRemoveLoan() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#getState()}.
	 */
	@Test
	public final void testGetState() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link library.entities.Member#getFirstName()}.
	 */
	@Test
	public final void testGetFirstName() {
		String fName = mem.getFirstName();
		assertEquals("Matching First Name","Asmita", fName);
		}

	/**
	 * Test method for {@link library.entities.Member#getLastName()}.
	 */
	@Test
	public final void testGetLastName() {
		String lName = mem.getLastName();
		assertEquals("Matching Last Name","Singh", lName);	
		}

	/**
	 * Test method for {@link library.entities.Member#getContactPhone()}.
	 */
	@Test
	public final void testGetContactPhone() {
		String contNum = mem.getContactPhone();
		assertEquals("Matching Contact Number","12345", contNum);
		}

	/**
	 * Test method for {@link library.entities.Member#getEmailAddress()}.
	 */
	@Test
	public final void testGetEmailAddress() {
		String email = mem.getEmailAddress();
		assertEquals("Matching email","asmita@gmail.com", email);	}

	/**
	 * Test method for {@link library.entities.Member#getID()}.
	 */
	@Test
	public final void testGetID() {
		int id = mem.getID();
		assertEquals("Matching Member Id",101, id);	}

}
