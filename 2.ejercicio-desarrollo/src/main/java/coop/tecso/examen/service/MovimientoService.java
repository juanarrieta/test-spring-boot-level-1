package coop.tecso.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.repository.MovimientoRepository;

@Service
public class MovimientoService {

	private MovimientoRepository movimientoRepository;
	private CuentaCorrienteRepository cuentaCorrienteRepository;
	
	@Autowired
	public MovimientoService(MovimientoRepository movimientoRepository, CuentaCorrienteRepository cuentaCorrienteRepository) {
		this.movimientoRepository = movimientoRepository;
		this.cuentaCorrienteRepository = cuentaCorrienteRepository;
	}
	
	public Movimiento save(Movimiento movimiento) {
		if(movimiento.getTipo().equals("debito")) 
			movimiento.getCuenta().setSaldo(movimiento.getCuenta().getSaldo() - movimiento.getImporte());	
		
		else 
			movimiento.getCuenta().setSaldo(movimiento.getCuenta().getSaldo() + movimiento.getImporte());
		
		this.cuentaCorrienteRepository.save(movimiento.getCuenta());
		
		return this.movimientoRepository.save(movimiento);
	}
	
	public List<Movimiento> findAll(){
		return this.movimientoRepository.findAll();
	}
	
}
