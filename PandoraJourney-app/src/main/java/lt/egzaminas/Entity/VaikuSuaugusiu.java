package lt.egzaminas.Entity;

import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class VaikuSuaugusiu extends Institucija {
	private String Vaiku;

	public String getVaiku() {
		return Vaiku;
	}

	public void setVaiku(String vaiku) {
		this.Vaiku = vaiku;
	}
}
