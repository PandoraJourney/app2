package lt.egzaminas.Controllers;

import java.util.List;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.*;
import lt.egzaminas.DTO.*;
import lt.egzaminas.Services.*;

@RestController // rest valdiklis
@Api(value = "institucija")
@RequestMapping(value = "/api/instucijos")
public class InstitutionController {

	@Autowired
	private InstService instService;
	
	
	@RequestMapping(value = "/")
	@GetMapping
	@ApiOperation(value="Get institution list",notes="Returns list of institution")
	public List<InstDTO> getInstutions() {
		return instService.getInsts();
	}
	
	@RequestMapping(value = "/")
	@GetMapping
	@ApiOperation(value="Get institution details by name",notes="Returns list of institution")
	public InstDTO getInstutionByName((value="Institucija name",required=true) @Valid @RequestBody final String name) {
		return instService.getInstByName(name);
	}


	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create users",notes="Creates user from string")
	public void createInstituion(@ApiParam(value="User Data",required=true) @Valid @RequestBody final InstDTO inst ) {
		instService.createInstituton(inst);
	}

	@RequestMapping(path = "/", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateUser(@ApiParam(value="Inst Data",required=true) @Valid @RequestBody final InstDTO inst) {
		instService.updateInst(inst);
	}
//	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
	@ApiOperation(value="Deletes inst",notes="Deletes intitutio from username")
	public void deleteInstitution(@ApiParam(value="Institution name",required=true) @RequestBody final String inst) {
		instService.deleteInst(inst);
	}

}


