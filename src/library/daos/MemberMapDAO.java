/**
 * 
 */
package library.daos;

import java.util.List;

import library.interfaces.daos.IMemberDAO;
import library.interfaces.entities.IMember;

/**
 * @author 11580359
 *
 */
public class MemberMapDAO implements IMemberDAO {

	/* (non-Javadoc)
	 * @see library.interfaces.daos.IMemberDAO#addMember(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IMember addMember((String firstName, String lastName, String contactPhone, String emailAddress)) {
		int id = this.getNextId();
        IMember mem = this.helper.makeMember(firstName, lastName, contactPhone, emailAddress, id);
        this.memberMap.put(id, mem);
        return mem;
		
		return null;
	}

	/* (non-Javadoc)
	 * @see library.interfaces.daos.IMemberDAO#getMemberByID(int)
	 */
	public IMember getMemberByID(int id) {
		if (this.memberMap.keySet().contains(id)) {
            return this.memberMap.get(id);
        }
		return null;
	}

	/* (non-Javadoc)
	 * @see library.interfaces.daos.IMemberDAO#listMembers()
	 */
	public List listMembers(int id) {
		 if (this.memberMap.keySet().contains(id)) {
	            return this.memberMap.get(id);
	        }
		return null;
	}

	/* (non-Javadoc)
	 * @see library.interfaces.daos.IMemberDAO#findMembersByLastName(java.lang.String)
	 */
	public List findMembersByLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException(String.format("MemberMapDAO : findMembersByLastName : lastName cannot be null or blank", new Object[0]));
        }
        ArrayList<IMember> list = new ArrayList<IMember>();
        for (IMember m : this.memberMap.values()) {
            if (!lastName.equals(m.getLastName())) continue;
            list.add(m);
        }
        return Collections.unmodifiableList(list);
		return null;
	}

	/* (non-Javadoc)
	 * @see library.interfaces.daos.IMemberDAO#findMembersByEmailAddress(java.lang.String)
	 */
	public List findMembersByEmailAddress(String emailAddress) {
		 if (emailAddress == null || emailAddress.isEmpty()) {
	            throw new IllegalArgumentException(String.format("MemberMapDAO : findMembersByEmailAddress : emailAddress cannot be null or blank", new Object[0]));
	        }
	        ArrayList<IMember> list = new ArrayList<IMember>();
	        for (IMember m : this.memberMap.values()) {
	            if (!emailAddress.equals(m.getEmailAddress())) continue;
	            list.add(m);
	        }
	        return Collections.unmodifiableList(list);
	        return null;
	}

	/* (non-Javadoc)
	 * @see library.interfaces.daos.IMemberDAO#findMembersByNames(java.lang.String, java.lang.String)
	 */
	public List findMembersByNames(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
        throw new IllegalArgumentException(String.format("MemberMapDAO : findMembersByNames : firstName and lastName cannot be null or blank", new Object[0]));
    }
    ArrayList<IMember> list = new ArrayList<IMember>();
    for (IMember m : this.memberMap.values()) {
        if (!firstName.equals(m.getFirstName()) || !lastName.equals(m.getLastName())) continue;
        list.add(m);
    }
    return Collections.unmodifiableList(list);
}

private int getNextId() {
    return this.nextID++;
}
}
