package lt.egzaminas.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.egzaminas.DTO.BookDTO;
import lt.egzaminas.DTO.InstDTO;
import lt.egzaminas.Services.BookService;

@RestController // rest valdiklis
@Api(value = "book")
@RequestMapping(value = "/api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/")
	@GetMapping
	@ApiOperation(value="Get institution list",notes="Returns list of institution")
	public List<BookDTO> getBooks() {
		return bookService.getBooks();
	}


	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create book",notes="Creates book from json")
	public void createBook(@ApiParam(value="User Data",required=true) @Valid @RequestBody final BookDTO book ) {
		bookService.createBook(book);
	}

	@RequestMapping(path = "/", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateBook(@ApiParam(value="Book Data",required=true) @Valid @RequestBody final BookDTO book) {
		bookService.updateBook(book);
	}
//	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
	@ApiOperation(value="Deletes book",notes="Deletes intitutio from username")
	public void deleteBook(@ApiParam(value="Institution name",required=true) @RequestBody final String name) {
		bookService.deleteBook(name);
	}

}
