package coop.tecso.examen.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.service.MovimientoService;

@RestController
@RequestMapping("/app/view/api")
public class MovimientoResource {

	private MovimientoService movimientoService;
	
	public MovimientoResource(MovimientoService movimientoService) {
		this.movimientoService = movimientoService;
	}
	
	@RequestMapping(value="movimiento",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movimiento> getAll(){
		return this.movimientoService.findAll();
	}
	
	@RequestMapping(value="movimiento",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento) throws URISyntaxException{
		
		try {
			Movimiento result = this.movimientoService.save(movimiento);
			System.out.print(result.getCuenta());
			return ResponseEntity.created(new URI("/app/view/api/movimiento/"+result.getId())).body(result);
		}catch(Exception e) {
			return new ResponseEntity<Movimiento>(HttpStatus.CONFLICT);
		}
	}
}
