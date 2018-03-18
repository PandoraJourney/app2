package lt.egzaminas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import lt.egzaminas.Entity.*;

@Repository
public interface InstitucijaRepo extends JpaRepository<Institucija, Long> {

	//Ieskociau by id, bet neranda to attributo, nes cia daug instituciju istrins
	//zodizu cia tik laiko biski daugiau reikejo :) ir gitt'a ismok :/
	Institucija findDistinctInstitucijaByPavadinimas(String inst);

	void deleteByPavadinimas(String Inst);

	Institucija findByPa(Long id);

	

}
