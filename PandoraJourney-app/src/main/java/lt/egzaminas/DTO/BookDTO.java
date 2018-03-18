package lt.egzaminas.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lt.egzaminas.Entity.Book;

public class BookDTO {
	private String vardas; 
	private String autorius;
	private long psl;
	private String nuotr;
	
	public static Book toBookEntity(BookDTO book)
	{
		Book bOOk = new Book();		
		bOOk.setAutorius(book.getAutorius());
		bOOk.setVardas(book.getVardas());
		bOOk.setNuotr(book.getNuotr());
		bOOk.setPsl(book.getPsl());
		return bOOk;
	}
	
	public static BookDTO toBookDTO(Book book)
	{
		BookDTO bOOk = new BookDTO();		
	bOOk.setAutorius(book.getAutorius());
	bOOk.setVardas(book.getVardas());
	bOOk.setNuotr(book.getNuotr());
	bOOk.setPsl(book.getPsl());
	return bOOk;
	}
	public String getVardas() {
		return vardas;
	}
	public String getAutorius() {
		return autorius;
	}
	public long getPsl() {
		return psl;
	}
	public String getNuotr() {
		return nuotr;
	}
	public void setVardas(String vardas) {
		this.vardas = vardas;
	}
	public void setAutorius(String autorius) {
		this.autorius = autorius;
	}
	public void setPsl(long psl) {
		this.psl = psl;
	}
	public void setNuotr(String nuotr) {
		this.nuotr = nuotr;
	}
	
	

}
