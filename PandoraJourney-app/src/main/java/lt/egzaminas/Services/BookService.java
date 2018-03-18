package lt.egzaminas.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.egzaminas.DTO.BookDTO;
import lt.egzaminas.Entity.Book;
import lt.egzaminas.Repository.BookRepository;
import lt.egzaminas.Repository.InstitucijaRepo;

@Transactional
@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	public List<BookDTO> getBooks() {
		List<Book> books= bookRepo.findAll();
		
		return books.stream().map((e)->{return BookDTO.toBookDTO(e);}).collect(Collectors.toList());
	}

	public void createBook(BookDTO book) {
		bookRepo.save(BookDTO.toBookEntity(book));
		
	}

	public void deleteBook(String name) {
		bookRepo.deleteByVardas(name);
	
	}

	public void updateBook(BookDTO book) {
		Book b = bookRepo.findDistinctByVardas(book.getVardas());
		b = BookDTO.toBookEntity(book);
		bookRepo.save(b);
	}

}
