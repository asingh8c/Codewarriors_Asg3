package library.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import library.interfaces.entities.EMemberState;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public class Member implements IMember {

	private String firstName;
	private String lastName;
	private String contactPhone;
	private String email;
	private int id;
	private EMemberState state;
	private List<ILoan> loanList;
	private float totalFine;

	public Member(String fName, String lName, String contactPh, String email, int membId) {
		// Initialize member attributes
		this.firstName = fName;
		this.lastName = lName;
		this.contactPhone = contactPh;
		this.email = email;
		this.id = membId;
		this.loanList = new ArrayList<ILoan>(); // Empty Loan List
		this.totalFine = 0;
		this.state = EMemberState.BORROWING_ALLOWED; // Initial state of new
														// Member

	}

	@Override
	public boolean hasOverDueLoans() {
		// TODO Returns boolean indicating whether user has overdue on loan book
		for (ILoan loan : this.loanList) {
			if (loan.isOverDue()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasReachedLoanLimit() {
		// TODO Returns boolean indicating if number of books allowed for loan
		// has reached
		if (this.loanList.size() >= 5) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasFinesPayable() {
		// TODO Returns boolean indicating if there is pending fine in members
		// account
		// account
		if (this.totalFine > 0.0f) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasReachedFineLimit() {
		// TODO Returns boolean indicating if pending fine has reached limit
		if (this.totalFine >= 10.0f) {
			return true;
		}
		return false;
	}

	@Override
	public float getFineAmount() {
		// TODO Return total payable fine in member account
		return this.totalFine;
	}

	@Override
	public void addFine(float fine) {
		// TODO Add fine in member to existing fine amount
		if (fine > 0) {
			this.totalFine += fine;
		} else {
			throw new RuntimeException("Member can not be a negative fine value");
		}

	}

	@Override
	public void payFine(float payment) {
		// TODO Update total fine when Member pays off fine
		if (payment < 0.0f || payment > this.totalFine) {
			throw new RuntimeException(
					"Negative Value for fine payment and payment greater than total fine is not allowed");
		}
		this.totalFine -= payment;
	}

	@Override
	public void addLoan(ILoan loan) {
		// TODO Add book loan to the loan list
		if (!this.isBorrowingAllowed()) {
			throw new RuntimeException(
					String.format("Member: addLoan : operation not allowed in state: %s", new Object[] { this.state }));
		}
		this.loanList.add(loan);
		this.updateBorrowState();
	}

	@Override
	public List<ILoan> getLoans() {
		// TODO Return non-editable loan list of member
		return Collections.unmodifiableList(this.loanList);
	}

	@Override
	public void removeLoan(ILoan loan) {
		// TODO Remove book loan from member account
		if (loan == null || !this.loanList.contains(loan)) {
			throw new RuntimeException(
					String.format("Member: removeLoan : loan is null or not found in loanList", new Object[0]));
		}
		this.loanList.remove(loan);
		this.updateBorrowState();
	}

	@Override
	public EMemberState getState() {
		// TODO Return borrow status of member entity
		return this.state;
	}

	@Override
	public String getFirstName() {
		// TODO Return member first name
		return this.firstName;
	}

	@Override
	public String getLastName() {
		// TODO Return member last name
		return this.lastName;
	}

	@Override
	public String getContactPhone() {
		// TODO Return member contact telephone number
		return this.contactPhone;
	}

	@Override
	public String getEmailAddress() {
		// TODO Return member email address
		return this.email;
	}

	@Override
	public int getID() {
		// TODO Return member member Id
		return this.id;
	}

	private Boolean isBorrowingAllowed() {
		boolean check = !this.hasOverDueLoans() && !this.hasReachedFineLimit() && !this.hasReachedLoanLimit();
		return check;
	}

	private void updateBorrowState() {
		this.state = this.isBorrowingAllowed() != false ? EMemberState.BORROWING_ALLOWED
				: EMemberState.BORROWING_DISALLOWED;
	}

}
