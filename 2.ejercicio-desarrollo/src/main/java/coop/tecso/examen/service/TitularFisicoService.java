package coop.tecso.examen.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.TitularFisico;
import coop.tecso.examen.repository.TitularFisicoRepository;

@Service
public class TitularFisicoService {

	private TitularFisicoRepository titularFisicoRepository;
	
	@Autowired
	public TitularFisicoService(TitularFisicoRepository titularFisicoRepository) {
		this.titularFisicoRepository = titularFisicoRepository;
	}
	
	public TitularFisico save(TitularFisico titularFisico) {
		if(titularFisico.getRut() != null && this.titularFisicoRepository.exists(titularFisico.getRut())) {
			throw new EntityExistsException("Ya existe un titular con ese rut");
		}
		return this.titularFisicoRepository.save(titularFisico);	
	}
	
	public TitularFisico update(TitularFisico titularFisico) {
		return this.titularFisicoRepository.save(titularFisico);
	}
	
	public List<TitularFisico> findAll(){
		return this.titularFisicoRepository.findAll();
	}
	
	public TitularFisico findOne(Integer id){
		return this.titularFisicoRepository.findOne(id);
	}
	
	public void delete(Integer id){
		this.titularFisicoRepository.delete(id);
	}
}
