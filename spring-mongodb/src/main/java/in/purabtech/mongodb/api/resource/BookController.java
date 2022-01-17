package in.purabtech.mongodb.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.purabtech.mongodb.api.model.Book;
import in.purabtech.mongodb.api.repository.BookRepository;

import java.util.List;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Added book with id:"+book.getId();
		
	}

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

}
