package lt.egzaminas.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "KnyguNuomaArchyvas")
public class KnyguVietos extends ViesaNeviesa{

}
