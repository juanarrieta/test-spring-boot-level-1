package coop.tecso.examen.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="cuenta_corriente")
@EntityListeners(AuditingEntityListener.class)
public class CuentaCorriente{
	
	@Id
	private Integer num_cuenta;
	
	private String moneda;
	
	private Double saldo;

	@ManyToOne
	@JoinColumn(name = "ID_TITULAR_FIS")
	private TitularFisico titular_fis;
	
	@ManyToOne
	@JoinColumn(name = "ID_TITULAR_JUR")
	private TitularJuridico titular_jur;
	
	public Integer getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(Integer num_cuenta) {
		this.num_cuenta = num_cuenta;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TitularFisico getTitular_fis() {
		return titular_fis;
	}

	public void setTitular_fis(TitularFisico titular_fis) {
		this.titular_fis = titular_fis;
	}

	public TitularJuridico getTitular_jur() {
		return titular_jur;
	}

	public void setTitular_jur(TitularJuridico titular_jur) {
		this.titular_jur = titular_jur;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [num_cuenta=" + num_cuenta + ", moneda=" + moneda + ", saldo=" + saldo
				+ ", titular_fis=" + titular_fis + ", titular_jur=" + titular_jur + "]";
	}	
}
