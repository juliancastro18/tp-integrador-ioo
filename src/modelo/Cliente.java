package modelo;
/*import modelo.Contacto;
import modelo.Ubicacion;*/

public class Cliente extends Actor {
	
	//-------------------------ATRIBUTOS-------------------------
	private String apellido;
	private String nombre;
	private long dni;
	private char sexo;
	
	//-------------------------CONSTRUCTOR-------------------------
	public Cliente(Contacto contacto, String apellido, String nombre, long dni, char sexo) throws Exception {
		super(contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		setDni(dni);
		this.sexo = sexo;
	}
	

	//-------------------------GETTERS Y SETTERS-------------------------
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombreCompleto() {
		return getNombre() + " " + getApellido();
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) throws Exception {
		if(validarIdentificadorUnico(dni)) {
			this.dni = dni;
		}
		else {
			throw new Exception("\nError al validar DNI. Por favor verifiquelo\n");
		}
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	//-------------------------METODOS-------------------------
	@Override
	public String toString() {
		return "Cliente= Id: " + id + " - Apellido: " + apellido + " - Nombre: " + nombre + " - DNI: " + dni + contacto;
	}

	public boolean equals(Cliente c) {
		boolean equals=false;
		if(dni == c.dni) {
			equals=true;
		}
		return equals;
	}

	@Override	
	protected boolean validarIdentificadorUnico(long iUnico) {
		boolean validador = false;
		if(iUnico>0 && iUnico<99999999) {
			validador = true;
		}
		return validador;
	}

}
