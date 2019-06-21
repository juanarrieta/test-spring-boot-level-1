package coop.tecso.examen.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="titular_juridico")
@EntityListeners(AuditingEntityListener.class)
public class TitularJuridico {
	
	@Id
	private Integer rut;
	
	private String razon_social;
	
	private Timestamp anio_fund;

	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public Timestamp getAnio_fund() {
		return anio_fund;
	}

	public void setAnio_fund(Timestamp anio_fund) {
		this.anio_fund = anio_fund;
	}

}
