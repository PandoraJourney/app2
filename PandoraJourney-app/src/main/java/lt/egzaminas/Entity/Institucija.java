package lt.egzaminas.Entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "INSTITUCIJA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public abstract class Institucija {

	//@TableGenerator(name = "Inst", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "Instid", allocationSize = 1)
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "Inst")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Instid;
	
	private String tipas;
	private String pavadinimas;
	private String miestas;
	private String nuotraukaURL;
	
	  @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH})
	    @JoinTable(name = "Inst_to_knygos",
	            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "Instid"),
	            inverseJoinColumns = @JoinColumn(name = "id",
	                    referencedColumnName = "id"))
	private List<Book> knygos;
	
//	  @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH})
//	    @JoinTable(name = "Inst_to_knygos",
//	            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "Instid"),
//	            inverseJoinColumns = @JoinColumn(name = "id",
//	                    referencedColumnName = "id"))
//	private List<PriceState> detales;
//	
	public void addBook(Book book)
	{
		knygos.add(book);
	}
	
	public void removeBook(Book book)
	{
		knygos.remove(book);
	}
	public List<Book> getBooks() {
		return knygos;
	}

	public void setBooks(List<Book> books) {
		this.knygos = books;
	}
	
	public Long getInstid() {
		return Instid;
	}

	public void setInstid(Long instid) {
		Instid = instid;
	}

	public String getTipas() {
		return tipas;
	}

	public void setTipas(String tipas) {
		this.tipas = tipas;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadainimas) {
		pavadainimas = pavadinimas;
	}

	public String getMiestas() {
		return miestas;
	}

	public void setMiestas(String miestas) {
		miestas = miestas;
	}

	public String getNuotraukaURL() {
		return nuotraukaURL;
	}

	public void setNuotraukaURL(String nuotraukaURL) {
		nuotraukaURL = nuotraukaURL;
	}
	
}