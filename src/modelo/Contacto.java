package modelo;

public class Contacto {
	//-------------------------ATRIBUTOS-------------------------
	private String email;
	private String celular;
	private Ubicacion ubicacion;
	
	//-------------------------CONSTRUCTOR-------------------------
	public Contacto(String email, String celular, Ubicacion ubicacion) throws Exception {
		super();
		setEmail(email);
		setCelular(celular);
		setUbicacion(ubicacion);
	}
	

	//-------------------------GETTERS Y SETTERS-------------------------
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws Exception {
		boolean mailValido = true;
		if(email.indexOf("@") < 1) { //si el arroba no está a partir de la pos 1
			mailValido = false;
		}
		if(email.lastIndexOf(".") <= email.indexOf("@")+1) { //si no hay un punto luego del arroba
			mailValido = false;
		}
		if(mailValido==false) {
			throw new Exception ("Email inválido");
		}
		this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) throws Exception {
		if(celular.length()<10) {
			throw new Exception("Celular inválido");
		}
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
	
	public boolean equals(Contacto a) {
		boolean equals=false;
		if( email.equals(a.email) && celular.equals(a.celular) && ubicacion.equals(a.ubicacion) ) {
			equals=true;
		}
		return equals;
	}
	
}
