package model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="dbo.BI_Visitas")
public class Visita {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVisita;
	
	@Column(name="Fecha")
	private Timestamp fecha;
	
	@Column(name="Temperatura")
	private byte temperatura;
	
	@Column(name="Peso")
	private int peso;
	
	@ManyToOne
	@JoinColumn(name="Mascota")
	private Mascota mascota;

	public Visita(){}
	
	public Visita(int idVisita, Timestamp fecha, byte temperatura, int peso, Mascota mascota) {
		super();
		this.idVisita = idVisita;
		this.fecha = fecha;
		this.temperatura = temperatura;
		this.peso = peso;
		this.mascota = mascota;
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public byte getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(byte temperatura) {
		this.temperatura = temperatura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	
}
