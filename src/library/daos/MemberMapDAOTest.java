/**
 * 
 */
package library.daos;

import java.util.List;


import junit.framework.TestCase;
import library.interfaces.daos.IMemberDAO;
import library.interfaces.daos.IMemberHelper;
import library.interfaces.entities.IMember;

/**
 * @author Thilini
 *
 */
public class MemberMapDAOTest extends TestCase {
	private IMemberHelper helper;
	private IMemberDAO memberDAO;
	private int memberID; 
	private String nameForTheLastName;
	private String email = "johnwick@gmail.com";
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		helper = new MemberHelper();
		memberDAO = new MemberMapDAO(helper);
		IMember member = memberDAO.addMember("John", "Wick", "", email);
		memberID = member.getID();
		//Adding member2
		IMember member2 = memberDAO.addMember("John", "Sick", "", "");
		IMember member3 = memberDAO.addMember("Rahul", "Wick", "", "");
		
		nameForTheLastName = "Wick";
		
	}

	/**
	 * Test method for {@link library.daos.MemberMapDAO#addMember()}.
	 */
	public void testAddMember() {
		IMember member = memberDAO.addMember("", "", "", "");
		assertNotNull(member);
	}

	/**
	 * Test method for {@link library.daos.MemberMapDAO#getMemberByID(int)}.
	 */
	public void testGetMemberByID() {
		int testingMemberId = memberID;
		IMember member = memberDAO.getMemberByID(testingMemberId);
		assertNotNull(member);
		assertEquals(member.getID(), testingMemberId);
	}

	/**
	 * Test method for {@link library.daos.MemberMapDAO#listMembers(int)}.
	 */
	public void testListMembers() {
		//Members are already added to the memberDAO
		List<IMember> memberList =  memberDAO.listMembers();
		assertNotNull(memberList);
		assertTrue(memberList.size()>0);
	}

	/**
	 * Test method for {@link library.daos.MemberMapDAO#findMembersByLastName(java.lang.String)}.
	 */
	public void testFindMembersByLastName() {
		List<IMember> memberByLatName = memberDAO.findMembersByLastName(nameForTheLastName);
		assertNotNull(memberByLatName);
		assertTrue(memberByLatName.size() == 2);
	}

	/**
	 * Test method for {@link library.daos.MemberMapDAO#findMembersByEmailAddress(java.lang.String)}.
	 */
	public void testFindMembersByEmailAddress() {
		List<IMember> memberByEmail = memberDAO.findMembersByEmailAddress(email);
		assertNotNull(memberByEmail);
		assertTrue(memberByEmail.size() == 1);
	}

	/**
	 * Test method for {@link library.daos.MemberMapDAO#findMembersByNames(java.lang.String, java.lang.String)}.
	 */
	public void testFindMembersByNames() {
		List<IMember> membersByName = memberDAO.findMembersByNames("Rahul", "Wick");
		assertNotNull(membersByName);	
		assertTrue(membersByName.size() == 1);
	}

}
