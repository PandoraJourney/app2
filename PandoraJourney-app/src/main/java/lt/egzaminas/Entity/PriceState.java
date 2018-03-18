package lt.egzaminas.Entity;

import javax.persistence.*;

import org.springframework.validation.annotation.*;

@Entity
public class PriceState {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private double kaina;
	
	@Column
	private String bukle;
	@Column
	private int kiekis;
	
//	@ManyToMany	(mappedBy = "detales", cascade = {CascadeType.MERGE, CascadeType.DETACH})
//	List<Institucija> insts;
	
	public double getKaina() {
		return kaina;
	}
	public String getBukle() {
		return bukle;
	}
	public int getKiekis() {
		return kiekis;
	}
	public void setKaina(double kaina) {
		this.kaina = kaina;
	}
	public void setBukle(String bukle) {
		this.bukle = bukle;
	}
	public void setKiekis(int kiekis) {
		this.kiekis = kiekis;
	}

}
