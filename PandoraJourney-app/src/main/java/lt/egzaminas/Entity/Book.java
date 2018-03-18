package lt.egzaminas.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String vardas; 
	@Column
	private String autorius;
	@Column
	private long psl;
	@Column
	private String nuotr;
	@ManyToMany	(mappedBy = "knygos", cascade = {CascadeType.MERGE, CascadeType.DETACH})
	private List<Institucija> insts;
	
	public void addInstitucija(Institucija inst)
	{
		insts.add(inst);
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
	public List<Institucija> getInst() {
		return insts;
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
	public void setInst(List<Institucija> inst) {
		this.insts = inst;
	}
}
