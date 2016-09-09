package library.daos;

import java.util.HashMap;
import java.util.Map;

import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.IBookHelper;
import library.interfaces.entities.IBook;

public abstract class BookMapDAO implements IBookDAO {
	private int nextId;
	private Map<Integer, IBook> bookMap;
	private IBookHelper helper;

	public BookMapDAO(IBookHelper helper) {
		if (helper == null) {
			throw new IllegalArgumentException(
					String.format("BookDAO : constructor : helper cannot be null.", new Object[0]));
		}
		this.nextId = 1;
		this.helper = helper;
		this.bookMap = new HashMap<Integer, IBook>();
	}

	public BookMapDAO(IBookHelper helper, Map<Integer, IBook> bookMap) {
		this(helper);
		if (helper == null) {
			throw new IllegalArgumentException(
					String.format("BookDAO : constructor : bookMap cannot be null.", new Object[0]));
		}
		this.bookMap = bookMap;
	}

}
