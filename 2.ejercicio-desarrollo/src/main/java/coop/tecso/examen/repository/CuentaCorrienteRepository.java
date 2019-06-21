package coop.tecso.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.CuentaCorriente;

public interface CuentaCorrienteRepository extends JpaRepository<CuentaCorriente,Integer>{
	
}
