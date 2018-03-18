package lt.egzaminas.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public abstract class ViesaNeviesa extends Institucija {
	private String viesumas;

	public String getViesumas() {
		return viesumas;
	}

	public void setViesumas(String viesumas) {
		this.viesumas = viesumas;
	}
	
}

