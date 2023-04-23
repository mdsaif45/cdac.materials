package in.cdac.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdac.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByName(String name);
	
	Book findByAuthor(String author);
	
	List<Book> findByPrice(float price);
}
