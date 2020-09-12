package modelo;

public class Contacto {
	//-------------------------ATRIBUTOS-------------------------
	private String email;
	private String celular;
	private Ubicacion ubicacion;
	
	//-------------------------CONSTRUCTOR-------------------------
	public Contacto(String email, String celular, Ubicacion ubicacion) {
		super();
		this.email = email;
		this.celular = celular;
		this.ubicacion = ubicacion;
	}
	
	//-------------------------GETTERS Y SETTERS-------------------------
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	//-------------------------METODOS-------------------------
	@Override
	public String toString() {
		return " - Email: " + email + " - Celular: " + celular + ubicacion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
		return result;
	}
	
	public boolean equals(Contacto a) {
		boolean equals=false;
		if( email.equals(a.email) && celular.equals(a.celular) && ubicacion.equals(a.ubicacion) ) {
			equals=true;
		}
		return equals;
	}
	
}
