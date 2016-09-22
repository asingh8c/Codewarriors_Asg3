/**
 *
 */
package library.daos;

import java.util.Date;

import library.entities.Loan;
import library.interfaces.daos.ILoanHelper;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

/**
 * @author Thilini
 *
 */
public class LoanHelper implements ILoanHelper {

	/* (non-Javadoc)
	 * @see library.interfaces.daos.ILoanHelper#makeLoan(library.interfaces.entities.IBook, library.interfaces.entities.IMember, java.util.Date, java.util.Date)
	 */
	@Override
	public ILoan makeLoan(IBook book, IMember borrower, Date borrowDate, Date dueDate) {
		 return new Loan(book, borrower, borrowDate, dueDate);
	}

}
