package co.edu.uniajc.smartcaf.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "physical_evaluation")
public class PhysicalEvaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;
	
	@Column(name = "hora", nullable = false)
    private String hora;
	
	@Column(name = "lesiones_fisicas", nullable = false)
    private String lesionesFisicas;
	
	@Column(name = "consumo_medicamentos", nullable = false)
    private String consumoMedicamentos;
	
	@Column(name = "consumo_sustancias_psicoactivas", nullable = false)
    private String consumoSustanciasPsicoactivas;
	
	@Column(name = "horas_sueno", nullable = false)
    private String horaSueno;
	
	@Column(name = "altura", nullable = false)
    private String altura;
	
	@Column(name = "peso", nullable = false)
    private String peso;
	
	@Column(name = "pulso", nullable = false)
    private String pulso;
	
	@Column(name = "observacion")
    private String observacion;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * @return the lesionesFisicas
	 */
	public String getLesionesFisicas() {
		return lesionesFisicas;
	}

	/**
	 * @param lesionesFisicas the lesionesFisicas to set
	 */
	public void setLesionesFisicas(String lesionesFisicas) {
		this.lesionesFisicas = lesionesFisicas;
	}

	/**
	 * @return the consumoMedicamentos
	 */
	public String getConsumoMedicamentos() {
		return consumoMedicamentos;
	}

	/**
	 * @param consumoMedicamentos the consumoMedicamentos to set
	 */
	public void setConsumoMedicamentos(String consumoMedicamentos) {
		this.consumoMedicamentos = consumoMedicamentos;
	}

	/**
	 * @return the consumoSustanciasPsicoactivas
	 */
	public String getConsumoSustanciasPsicoactivas() {
		return consumoSustanciasPsicoactivas;
	}

	/**
	 * @param consumoSustanciasPsicoactivas the consumoSustanciasPsicoactivas to set
	 */
	public void setConsumoSustanciasPsicoactivas(String consumoSustanciasPsicoactivas) {
		this.consumoSustanciasPsicoactivas = consumoSustanciasPsicoactivas;
	}

	/**
	 * @return the altura
	 */
	public String getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(String altura) {
		this.altura = altura;
	}

	/**
	 * @return the peso
	 */
	public String getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(String peso) {
		this.peso = peso;
	}

	/**
	 * @return the pulso
	 */
	public String getPulso() {
		return pulso;
	}

	/**
	 * @param pulso the pulso to set
	 */
	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the horaSueno
	 */
	public String getHoraSueno() {
		return horaSueno;
	}

	/**
	 * @param horaSueno the horaSueno to set
	 */
	public void setHoraSueno(String horaSueno) {
		this.horaSueno = horaSueno;
	}
	
}
