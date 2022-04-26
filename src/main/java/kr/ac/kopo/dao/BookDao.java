package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.util.Pager;

public interface BookDao {

	int total(Pager pager);

	List<Book> list(Pager pager);

	void add(Book item);

	Book item(int bookId);

	void update(Book item);

	void delete(int bookId);

	void order(Book book);

}
