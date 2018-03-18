package lt.egzaminas.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "BibliotekaKnygynas")
public class BibliotekaKnygynas extends VaikuSuaugusiu {

}
