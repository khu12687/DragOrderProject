package kr.ac.kopo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.util.Pager;

@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	BookService service;
	
	@GetMapping
	public String index(Pager pager, Model model) {
		
		List<Book> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return "index";
	}
	
	@PostMapping("/order")
	@ResponseBody
	public String order(@RequestBody Book book) {
		//System.out.println(book.getBookId());
		//System.out.println(book.getOrder());
		//System.out.println(book.getOrderOriginal());
		service.order(book);
		
		return "1";
	}
	
}
