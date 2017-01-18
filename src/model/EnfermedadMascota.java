package model;

import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="BI_Mascotas_Enfermedades")
public class EnfermedadMascota {

	@Id
	@ManyToOne
	@JoinColumn(name="idEnfermedad")
	private Enfermedad enfermedad;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Mascota")
	private Mascota mascota;
	
	@Column(name="FechaInicio")
	private Date fechaInicio;
	
	@Column(name="FechaCura")
	private Date fechaCura;
	
	public EnfermedadMascota(){}

	

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaCura() {
		return fechaCura;
	}

	public void setFechaCura(Date fechaCura) {
		this.fechaCura = fechaCura;
	}
	
}
