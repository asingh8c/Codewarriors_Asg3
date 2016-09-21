package library.concrete.dao;

import java.util.ArrayList;
import java.util.List;

import library.entities.Member;
import library.interfaces.daos.IMemberDAO;
import library.interfaces.daos.IMemberHelper;
import library.interfaces.entities.IMember;

public class MemberDAO implements IMemberDAO {
	private IMemberHelper memberHelper;
	private List<IMember> members;
	private static int memberId = 1;
	
	public MemberDAO(IMemberHelper memberHelper){
		if(memberHelper == null){
			throw new IllegalArgumentException();
		}else{
			this.memberHelper = memberHelper;
			members = new ArrayList<>();
		}
	}

	@Override
	public IMember addMember(String firstName, String lastName,
			String ContactPhone, String emailAddress) {
		Member m = new Member(firstName, lastName, ContactPhone, emailAddress, memberId++);
		members.add(m);
		return m;
	}

	@Override
	public IMember getMemberByID(int id) {
		IMember member = null;
		for(IMember mem: members){
			if(mem.getID() == id){
				member = mem;
			}
		}
		return member;
	}

	@Override
	public List<IMember> listMembers() {
		// TODO Auto-generated method stub
		return members;
	}

	@Override
	public List<IMember> findMembersByLastName(String lastName) {
		
		List<IMember> lastMembers = new ArrayList<>();
		for(IMember mem: members){
			if(mem.getLastName().equals(lastName)){
				lastMembers.add(mem);
			}
		}
		return lastMembers;
	}

	@Override
	public List<IMember> findMembersByEmailAddress(String emailAddress) {
		List<IMember> emailMembers = new ArrayList<>();
		for(IMember mem: members){
			if(mem.getEmailAddress().equals(emailAddress)){
				emailMembers.add(mem);
			}
		}
		return emailMembers;
	}

	@Override
	public List<IMember> findMembersByNames(String firstName, String lastName) {
		List<IMember> namesMembers = new ArrayList<>();
		for(IMember mem: members){
			if(mem.getLastName().equals(lastName) || mem.getFirstName().equals(firstName)){
				namesMembers.add(mem);
			}
		}
		return namesMembers;
	}

}
