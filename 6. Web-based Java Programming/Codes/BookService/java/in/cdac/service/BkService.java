package in.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.entity.Book;
import in.cdac.repo.BookRepository;

@Service
public class BkService {
	@Autowired
	private BookRepository bkr;
	
	public Book saveBook(Book bk) {
		return bkr.save(bk);
	}
	
	public Book updateBook(Book bk) {
		Book existingBook = bkr.findById(bk.getBookid()).orElse(null);
		existingBook.setAuthor(bk.getAuthor());
		existingBook.setName(bk.getName());
		existingBook.setPrice(bk.getPrice());
		existingBook.setQuantity(bk.getQuantity());
		
		return bkr.save(existingBook);
	}
	
	public Book getBookDetails(int id) {
		return bkr.findById(id).orElse(null);
	}
	
	public List<Book> getAllBooksDetails(){
		return bkr.findAll();
	}
	
	public String deleteBook(int id) {
		Book bk = bkr.findById(id).orElse(null);
		if(bk != null) {
			bkr.deleteById(id);
			return "Book of id: "+id+" was deleted";
		} else {
			return "Sorry Book not found";
		}		
	}
	
	public Book getBookByName(String bookname) {
		return bkr.findByName(bookname);
	}
	
	public List<Book> getBookByPrice(float pc) {
		return bkr.findByPrice(pc);
	}
}
