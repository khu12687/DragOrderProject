package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.BookDao;
import kr.ac.kopo.model.Book;
import kr.ac.kopo.util.Pager;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao dao;

	@Override
	public List<Book> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Book item) {
		dao.add(item);
	}

	@Override
	public Book item(int BookId) {
		return dao.item(BookId);
	}

	@Override
	public void update(Book item) {
		dao.update(item);
	}

	@Override
	public void delete(int BookId) {
		dao.delete(BookId);
	}

	@Override
	public void dummy() {
		for(int i=0; i < 100; i++) {
			Book item = new Book();
			
			item.setSubject("제목 테스트 " + i);
			item.setContents("내용 테스트 " + i);
			item.setOrderOriginal(0);
			dao.add(item);
		}
	}

	@Override
	public void init(Pager pager) {
		List<Book> list = dao.list(pager);
		for(Book item : list)
			dao.delete(item.getBookId());
	}

	@Override
	public void order(Book book) {
		dao.order(book);
		
	}
}
