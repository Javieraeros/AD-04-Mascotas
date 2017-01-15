package model;
import javax.persistence.*;
@Entity
@Table(name="dbo.BI_Clientes")
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="Telefono")
	private String telefono;
	
	@Column(name="Direccion")
	private String direccion;

	@Column(name="NumeroCuenta")
	private String numeroCuenta;
	
	@Column(name="Nombre")
	private String nombre;

	public Clientes(){}
	
	public Clientes(int codigo, String telefono, String direccion, String numeroCuenta, String nombre) {
		super();
		this.codigo = codigo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.numeroCuenta = numeroCuenta;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
