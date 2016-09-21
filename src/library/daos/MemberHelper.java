/**
 * 
 */
package library.daos;

import library.entities.Member;
import library.interfaces.daos.IMemberHelper;
import library.interfaces.entities.IMember;

/**
 * @author thilini
 *
 */
public class MemberHelper implements IMemberHelper {

	/* (non-Javadoc)
	 * @see library.interfaces.daos.IMemberHelper#makeMember(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	public IMember makeMember(String firstName, String lastName, String contactPhone, String emailAddress, int id) {
		
		 return new Member(firstName, lastName, contactPhone, emailAddress, id);
	}

}
