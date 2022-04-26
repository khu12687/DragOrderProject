package kr.ac.kopo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.model.Book;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.util.Pager;

@Controller
@RequestMapping("/book")
public class BookController {

	final String path = "/book/";
	
	@Autowired
	BookService service;
	
	@RequestMapping("/dummy")
	public String dummy() {
		service.dummy();
		
		return "redirect:list/1";
	}
	
	@RequestMapping("/init")
	public String init(Pager pager) {
		service.init(pager);
		
		return "redirect:list/1";
	}
	
	@GetMapping("/view/{bookId}")
	public String view(@PathVariable int bookId, @PathVariable int articleId, Model model) {
		
		Book item = service.item(bookId);
		
		model.addAttribute("item", item);
		
		return path + "view";
	}
	
	
	@GetMapping("/list/{page}")
	public String list(@PathVariable int page, Pager pager, Model model) {
		pager.setPage(page);
		List<Book> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Book item) {
		
		service.add(item);
		
		return "redirect:list/1";
	}
	
	@GetMapping("/update/{bookId}")
	public String update(@PathVariable int bookId, Model model) {
		Book item = service.item(bookId);
		
		model.addAttribute("item", item);
		
		return path + "update";
		
	}
	
	@PostMapping("/update/{bookId}")
	public String update(@PathVariable int bookId, Book item) {
		
		service.update(item);
		
		return "redirect:../list/1";
	}
	
	@GetMapping("/delete/{bookId}")
	public String delete(@PathVariable int bookId) {
		service.delete(bookId);
		
		return "redirect:../list/1";
	}
	
}
