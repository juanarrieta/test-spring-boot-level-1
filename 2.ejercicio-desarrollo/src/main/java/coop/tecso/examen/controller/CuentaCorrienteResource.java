package coop.tecso.examen.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.service.CuentaCorrienteService;


@RestController
@RequestMapping("/app/view/api")
public class CuentaCorrienteResource {

	private CuentaCorrienteService cuentaCorrienteService;
	
	
	public CuentaCorrienteResource(CuentaCorrienteService cuentaCorrienteService) {
		this.cuentaCorrienteService = cuentaCorrienteService;
	}
	
	@RequestMapping(value="cuenta_corriente",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CuentaCorriente> getAll(){
		return this.cuentaCorrienteService.findAll();
	}
	
	@RequestMapping(value="cuenta_corriente",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CuentaCorriente> save(@RequestBody CuentaCorriente cuentaCorriente) throws URISyntaxException{	
		try {
			CuentaCorriente result = this.cuentaCorrienteService.save(cuentaCorriente);
			return ResponseEntity.created(new URI("/app/view/api/cuenta_corriente/"+result.getNum_cuenta())).body(result);
		}catch(Exception e) {
			return new ResponseEntity<CuentaCorriente>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="/cuenta_corriente/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		this.cuentaCorrienteService.delete(id);
		return ResponseEntity.ok().build();
	}
}
