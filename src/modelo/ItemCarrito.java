package modelo;

public class ItemCarrito{
	private Articulo articulo;
	private int cantidad;
	public ItemCarrito(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	public ItemCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean equals(ItemCarrito item) {
		return this.getArticulo().getId() == item.getArticulo().getId();
	}
	
	public String toString() {
		return "Cantidad: " +cantidad+" "+articulo.toString();
	}
	
}
