package coop.tecso.examen.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.TitularJuridico;
import coop.tecso.examen.repository.TitularJuridicoRepository;

@Service
public class TitularJuridicoService {

	private TitularJuridicoRepository titularJuridicoRepository;
	
	@Autowired
	public TitularJuridicoService(TitularJuridicoRepository titularJuridicoRepository) {
		this.titularJuridicoRepository = titularJuridicoRepository;
	}
	
	public TitularJuridico save(TitularJuridico titularJuridico) {
		if(titularJuridico.getRut() != null && this.titularJuridicoRepository.exists(titularJuridico.getRut())) {
			throw new EntityExistsException("Ya existe un titular con ese rut");
		}
		
		return this.titularJuridicoRepository.save(titularJuridico);	
	}
	
	public TitularJuridico update(TitularJuridico titularJuridico) {
		return this.titularJuridicoRepository.save(titularJuridico);
	}
	
	public List<TitularJuridico> findAll(){
		return this.titularJuridicoRepository.findAll();
	}
	
	public TitularJuridico findOne(Integer id){
		return this.titularJuridicoRepository.findOne(id);
	}
	
	public void delete(Integer id){
		this.titularJuridicoRepository.delete(id);
	}
}
