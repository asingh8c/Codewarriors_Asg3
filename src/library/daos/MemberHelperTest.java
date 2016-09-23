/**
 * 
 */
package library.daos;

import junit.framework.TestCase;
import library.interfaces.daos.IMemberHelper;
import library.interfaces.entities.IMember;

/**
 * @author 11580359
 *
 */
public class MemberHelperTest extends TestCase {
	private IMemberHelper helper;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		helper = new MemberHelper();
	}

	/**
	 * Test method for {@link library.daos.MemberHelper#makeMember(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	public void testMakeMember() {
		IMember member = helper.makeMember("", "", "", "", 1);
		assertNotNull(member);
		assertEquals(1, member.getID());
		
	}

}
