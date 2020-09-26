package modelo;

public class Cliente extends Actor {
	
	//-------------------------ATRIBUTOS-------------------------
	private String apellido;
	private String nombre;
	private int dni;
	private char sexo;
	
	//-------------------------CONSTRUCTOR-------------------------
	public Cliente(int id, Contacto contacto, String apellido, String nombre, int dni, char sexo) {
		super(id, contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		if(validarIdentificadorUnico(dni)) {
			this.dni = dni;
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
		return "Cliente= Id: " + super.getId() + " - Apellido: " + apellido + " - Nombre: " + nombre + " - DNI: " + dni + contacto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dni;
		return result;
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
