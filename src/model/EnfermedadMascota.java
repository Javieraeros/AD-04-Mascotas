package model;

import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="BI_Mascotas_Enfermedades")
public class EnfermedadMascota {

	@EmbeddedId
	@AttributeOverrides({ 
		@AttributeOverride(name = "idEnfermedad", column = @Column(name = "IdEnfermedad")),
		@AttributeOverride(name = "mascota", column = @Column(name = "Mascota")) 
		})
	private IdEnfermedadMascota id;
	
	@Column(name="FechaInicio")
	private Date fechaInicio;
	
	@Column(name="FechaCura")
	private Date fechaCura;
	
	
	//TODO Preguntar a LEo
	/*@ManyToOne
	@JoinColumn(name="idEnfermedad")
	private Enfermedad enfermedad;
	
	@ManyToOne
	@JoinColumn(name="Mascota")
	private Mascota mascota;*/
	
	
	public EnfermedadMascota(){}

	public EnfermedadMascota(IdEnfermedadMascota id, Date fechaInicio, Date fechaCura) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaCura = fechaCura;
	}

	public IdEnfermedadMascota getId() {
		return id;
	}

	public void setId(IdEnfermedadMascota id) {
		this.id = id;
	}

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
