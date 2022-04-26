package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.util.Pager;

public interface BookService {

	void dummy();

	Book item(int bookId);

	List<Book> list(Pager pager);

	void add(Book item);

	void update(Book item);

	void delete(int bookId);

	void init(Pager pager);

	void order(Book book);

}
