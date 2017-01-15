package model;
import javax.persistence.*;
@Embeddable
public class IdEnfermedadMascota {
	
	@Column(name="IdEnfermedad")
	private int idEnfermedad;
	
	@Column(name="Mascota")
	private String idMascota;
	
	public IdEnfermedadMascota(){}

	public IdEnfermedadMascota(int idEnfermedad, String idMascota) {
		super();
		this.idEnfermedad = idEnfermedad;
		this.idMascota = idMascota;
	}

	public int getIdEnfermedad() {
		return idEnfermedad;
	}

	public void setIdEnfermedad(int idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}

	public String getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(String idMascota) {
		this.idMascota = idMascota;
	}
	
}
