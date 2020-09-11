package modelo;

public class Actor {

	//-------------------------ATRIBUTOS-------------------------
	private int id;
	protected Contacto contacto;
	
	//-------------------------CONSTRUCTOR-------------------------
	public Actor(int id, Contacto contacto) {
		super();
		this.id = id;
		this.contacto = contacto;
	}
	
	//-------------------------GETTES Y SETTERS-------------------------
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
		return "Actor [id=" + id + ", contacto=" + contacto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
