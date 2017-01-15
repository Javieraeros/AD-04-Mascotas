package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="dbo.BI_Mascotas")
public class Mascota {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codigo;
	
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
	
	@OneToMany(mappedBy="idVisita",cascade= CascadeType.ALL)
	private Set<Visita> visitas=new HashSet();
	
	@ManyToOne
	@JoinColumn(name="CodigoPropietario")
	private Cliente cliente;
	
	@ManyToMany(cascade = {CascadeType.ALL},mappedBy="mascotas")
	private Set<Enfermedad> enfermedades=new HashSet();

	

	public Mascota(String codigo, String raza, String especie, Date fechaNacimiento, Date fechaFallecimiento,
			String alias, Set<Visita> visitas, Cliente cliente, Set<Enfermedad> enfermedades) {
		super();
		this.codigo = codigo;
		this.raza = raza;
		this.especie = especie;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaFallecimiento = fechaFallecimiento;
		this.alias = alias;
		this.visitas = visitas;
		this.cliente = cliente;
		this.enfermedades = enfermedades;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaFallecimiento() {
		return fechaFallecimiento;
	}

	public void setFechaFallecimiento(Date fechaFallecimiento) {
		this.fechaFallecimiento = fechaFallecimiento;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Set<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(Set<Visita> visitas) {
		this.visitas = visitas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Enfermedad> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(Set<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}
	
	
	
}
