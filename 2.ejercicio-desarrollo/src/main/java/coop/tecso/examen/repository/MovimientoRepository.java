package coop.tecso.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento,Integer>{
	
}
