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

import coop.tecso.examen.model.TitularFisico;
import coop.tecso.examen.service.TitularFisicoService;

@RestController
@RequestMapping("/app/view/api")
public class TitularFisicoResource {

	private TitularFisicoService titularFisicoService;
	
	public TitularFisicoResource(TitularFisicoService titularFisicoService) {
		this.titularFisicoService = titularFisicoService;
	}
	
	@RequestMapping(value="titular_fisico",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TitularFisico> getAllTitularFisico(){
		return this.titularFisicoService.findAll();
	}
	
	@RequestMapping(value="titular_fisico",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TitularFisico> createTitularFisico(@RequestBody TitularFisico titularfisico) throws URISyntaxException{
		try {
			TitularFisico result = this.titularFisicoService.save(titularfisico);
			return ResponseEntity.created(new URI("/app/view/api/titularfisico/"+result.getRut())).body(result);
		}catch(Exception e) {
			return new ResponseEntity<TitularFisico>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="titular_fisico",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TitularFisico> updateTitularFisico(@RequestBody TitularFisico titularfisico) throws URISyntaxException{
		if(titularfisico.getRut()==null) {
			return new ResponseEntity<TitularFisico>(HttpStatus.NOT_FOUND);
		}
		
		try {
			TitularFisico result = this.titularFisicoService.update(titularfisico);
			return ResponseEntity.created(new URI("/app/view/api/titularfisico/"+result.getRut())).body(result);
		}catch(Exception e) {
			return new ResponseEntity<TitularFisico>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/titular_fisico/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteTitularFisico(@PathVariable Integer id){
		this.titularFisicoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
