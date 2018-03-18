package lt.egzaminas.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.egzaminas.DTO.*;
import lt.egzaminas.Entity.Institucija;
import lt.egzaminas.Repository.*;

@Service
@Transactional
public class InstService {

	@Autowired
	private InstitucijaRepo instRepo;

	public List<InstDTO> getInsts() {
		List<Institucija> insts = instRepo.findAll();
		return insts.stream().map((e)->{return InstDTO.toInstDTO(e);}).collect(Collectors.toList());
	}

	public void createInstituton(InstDTO inst) {
		instRepo.save(InstDTO.toDTOtoInst(inst))	;
	}

	public void deleteInst(String inst) {
		Institucija ini = instRepo.findDistinctInstitucijaByPavadinimas(inst);
		if(ini != null)
		{
			instRepo.deleteByPavadinimas(ini.getPavadinimas());
		}
		
	}

	public void updateInst(InstDTO inst) {
		Institucija ini = instRepo.findDistinctInstitucijaByPavadinimas(inst.getPav());
		ini = InstDTO.toDTOtoInst(inst);
		instRepo.save(ini);
	}

	public InstDTO getInstByName(String name) {
		return(InstDTO.toInstDTO(instRepo.findDistinctInstitucijaByPavadinimas(name)));

	}
	
	
	
}
