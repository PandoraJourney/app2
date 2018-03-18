package lt.egzaminas.DTO;

import lt.egzaminas.Entity.*;

public class InstDTO {
	private Long id;

	private String tipas;
	private String pav;
	private String miestas;
	private String nuotr;
	private String vaiku;
	private String viesumas;
	
	public static InstDTO toInstDTO(Institucija inst)
	{
		InstDTO inst_main = new InstDTO();
		inst_main.id = inst.getInstid();
		inst_main.tipas = inst.getTipas();
		inst_main.pav = inst.getPavadinimas();
		inst_main.nuotr = inst.getNuotraukaURL();
		inst_main.miestas = inst.getMiestas();
		if(inst instanceof VaikuSuaugusiu)
		{
			inst_main.vaiku = ((VaikuSuaugusiu)inst).getVaiku();
		}
		if(inst instanceof ViesaNeviesa)
		{
			inst_main.vaiku = ((ViesaNeviesa)inst).getViesumas();
		}
		return inst_main;
	}
	
	public static Institucija toDTOtoInst(InstDTO inst)
	{
		if(inst.getVaiku() != null || inst.getVaiku() != "")
		{
			BibliotekaKnygynas inst_main = new BibliotekaKnygynas();
			inst_main.setTipas(inst.getTipas());
			inst_main.setPavadinimas(inst.getPav());
			inst_main.setNuotraukaURL(inst.getNuotr());
			inst_main.setMiestas(inst.getMiestas());
			inst_main.setVaiku(inst.getVaiku());
			return inst_main;
		}else {
			KnyguVietos inst_main = new KnyguVietos();
			inst_main.setTipas(inst.getTipas());
			inst_main.setPavadinimas(inst.getPav());
			inst_main.setNuotraukaURL(inst.getNuotr());
			inst_main.setMiestas(inst.getMiestas());
			inst_main.setViesumas(inst.getViesumas());
			return inst_main;
		}
	}
	public Long getId() {
		return id;
	}

	public String getTipas() {
		return tipas;
	}

	public String getPav() {
		return pav;
	}

	public String getMiestas() {
		return miestas;
	}

	public String getNuotr() {
		return nuotr;
	}

	public String getVaiku() {
		return vaiku;
	}

	public String getViesumas() {
		return viesumas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTipas(String tipas) {
		this.tipas = tipas;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public void setMiestas(String miestas) {
		this.miestas = miestas;
	}

	public void setNuotr(String nuotr) {
		this.nuotr = nuotr;
	}

	public void setVaiku(String vaiku) {
		this.vaiku = vaiku;
	}

	public void setViesumas(String viesumas) {
		this.viesumas = viesumas;
	}

}
