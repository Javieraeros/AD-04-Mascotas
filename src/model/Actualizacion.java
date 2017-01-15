package model;

import java.sql.Date;

import javax.persistence.*;
@Entity
@Table(name="BI_Actualizaciones")
public class Actualizacion {
	@Column(name="Fecha")
	private Date fecha;
	@Column(name="Temperatura")
	private byte temperatura;
	@Column(name="Peso")
	private int peso;
	@Column(name="CodigoMascota")
	private String codigoMascota;
	@Column(name="Raza")
	private String raza;
	@Column(name="Especie")
	private String especie;
	@Column(name="FechaNacimiento")
	private Date fechaNacimiento;
	@Column(name="FechaFallecimiento")
	private Date fechaFallecimiento;
	@Column(name="Alias")
	private String alias;
	@Column(name="CodigoPropietario")
	private int codigoPropietario;
	@Column(name="Enfermedad")
	private String enfermedad;
}
