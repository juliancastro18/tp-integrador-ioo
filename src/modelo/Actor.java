package modelo;


public abstract class Actor {

	//-------------------------ATRIBUTOS-------------------------
	protected int id;
	protected Contacto contacto;
	
	//-------------------------CONSTRUCTOR-------------------------
	
	public Actor(int id, Contacto contacto) { //Constructor asignando id, solo se usa para comercio
		super();
		this.id = id;
		this.contacto = contacto;
	}
	
	public Actor(Contacto contacto) { //Constructor para asignar id autoincremental, se usa con cliente
		super();
		this.id = -1;
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
	
	
	public boolean equals(Actor a) {
		boolean equals=false;
		if(id==a.id) {
			equals=true;
		}
		return equals;
	}

	protected abstract boolean validarIdentificadorUnico(long iUnico);

		
}
