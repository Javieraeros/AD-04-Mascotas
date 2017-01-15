package model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="dbo.BI_Mascotas")
public class Mascota {
	private String codigo;
	private String raza;
	private String especie;
	private Date fechaNacimiento;
	private Date fechaFallecimiento;
	private String alias;
}
