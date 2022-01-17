package in.purabtech.mongodb.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.purabtech.mongodb.api.model.Book;
import in.purabtech.mongodb.api.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Added book with id:"+book.getId();
		
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/findAllBooks/{bookid}")
	public Optional<Book> getBook(@PathVariable int bookid) {
		return bookRepository.findById(bookid);
	}

	@DeleteMapping("/delete/{bookid}")
	public String deleteBook(@PathVariable int bookid){
		bookRepository.deleteById(bookid);
		return "Book deleted by id:"+bookid;
	}

}
