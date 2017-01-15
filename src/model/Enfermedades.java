package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="dbo.BI_Enfermedades")
public class Enfermedades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	 @ManyToMany(cascade = {CascadeType.ALL})
	 @JoinTable(name="BI_Mascotas_Enfermedades", joinColumns={@JoinColumn(name="IDEnfermedad")}, inverseJoinColumns={@JoinColumn(name="Mascota")})
	 private Set<Mascota> mascotas=new HashSet();
	
	public Enfermedades(){}

	public Enfermedades(int id, String nombre, Set<Mascota> mascotas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mascotas = mascotas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	
	
	
}
