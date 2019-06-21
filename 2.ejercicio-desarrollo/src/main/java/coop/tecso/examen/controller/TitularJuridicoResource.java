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

import coop.tecso.examen.model.TitularJuridico;
import coop.tecso.examen.service.TitularJuridicoService;

@RestController
@RequestMapping("/app/view/api")
public class TitularJuridicoResource {

	private TitularJuridicoService titularJuridicoService;
	
	public TitularJuridicoResource(TitularJuridicoService titularJuridicoService) {
		this.titularJuridicoService = titularJuridicoService;
	}
	
	@RequestMapping(value="titular_juridico",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TitularJuridico> getAllTitularJuridico(){
		return this.titularJuridicoService.findAll();
	}
	
	@RequestMapping(value="titular_juridico",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TitularJuridico> createTitularJuridico(@RequestBody TitularJuridico titularjuridico) throws URISyntaxException{
		try {
			TitularJuridico result = this.titularJuridicoService.save(titularjuridico);
			return ResponseEntity.created(new URI("/app/view/api/titularJuridico/"+result.getRut())).body(result);
		}catch(Exception e) {
			return new ResponseEntity<TitularJuridico>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="titular_juridico",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TitularJuridico> updateTitularJuridico(@RequestBody TitularJuridico titularjuridico) throws URISyntaxException{
		if(titularjuridico.getRut()==null) {
			return new ResponseEntity<TitularJuridico>(HttpStatus.NOT_FOUND);
		}
		
		try {
			TitularJuridico result = this.titularJuridicoService.update(titularjuridico);
			return ResponseEntity.created(new URI("/app/view/api/titularJuridico/"+result.getRut())).body(result);
		}catch(Exception e) {
			return new ResponseEntity<TitularJuridico>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/titular_juridico/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteTitularJuridico(@PathVariable Integer id){
		this.titularJuridicoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
