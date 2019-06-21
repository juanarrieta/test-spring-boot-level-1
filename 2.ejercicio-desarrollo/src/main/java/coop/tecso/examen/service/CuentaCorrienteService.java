package coop.tecso.examen.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.repository.CuentaCorrienteRepository;

@Service
public class CuentaCorrienteService {

	private CuentaCorrienteRepository cuentaCorrienteRepository;
	
	@Autowired
	public CuentaCorrienteService(CuentaCorrienteRepository cuentaCorrienteRepository) {
		this.cuentaCorrienteRepository = cuentaCorrienteRepository;
	}
	
	public CuentaCorriente save(CuentaCorriente cuentaCorriente) {
		if(cuentaCorriente.getNum_cuenta() != null && this.cuentaCorrienteRepository.exists(cuentaCorriente.getNum_cuenta())) {
			throw new EntityExistsException("Ya existe una cuenta con ese numero de cuenta");
		}
		return this.cuentaCorrienteRepository.save(cuentaCorriente);	
	}
		
	public List<CuentaCorriente> findAll(){
		return this.cuentaCorrienteRepository.findAll();
	}
	
	public void delete(Integer id){
		this.cuentaCorrienteRepository.delete(id);
	}
}
