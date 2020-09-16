package modelo;

public class Articulo {
	private int idArticulo;
	private String nombre;
	private String codBarras;
	private double precio;
	public Articulo(int id, String nombre, String codBarras, double precio) {
		super();
		this.idArticulo = id;
		this.nombre = nombre;
		this.codBarras = codBarras;
		this.precio = precio;
	}
	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(int id) {
		this.idArticulo = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean equals(Articulo art) {
		return this.idArticulo==art.getIdArticulo();
	}
	@Override
	public String toString() {
		return "Producto---> id="+ idArticulo + ", nombre=" + nombre + ", codBarras=" + codBarras + ", precio=" + precio+"\n";
	}
	
	
	
}
