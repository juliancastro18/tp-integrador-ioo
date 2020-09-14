package modelo;


public abstract class Actor {

	//-------------------------ATRIBUTOS-------------------------
	private int id;
	protected Contacto contacto;
	
	//-------------------------CONSTRUCTOR-------------------------
	public Actor(Contacto contacto) {
		super();
		id = this.hashCode();
		this.contacto = contacto;
	}
	
	//-------------------------GETTERS Y SETTERS-------------------------
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Contacto getContacto() {
		return contacto;
	}
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	//-------------------------METODOS-------------------------
	@Override
	public String toString() {
		return "idActor= " + id + contacto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contacto == null) ? 0 : contacto.hashCode());
		result = prime * result + id;
		return result;
	}
	
	public boolean equals(Actor a) {
		boolean equals=false;
		if(id==a.id) {
			equals=true;
		}
		return equals;
	}

	protected abstract boolean validarIdentificadorUnico(long a);

		
}
