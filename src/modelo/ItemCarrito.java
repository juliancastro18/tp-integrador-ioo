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
		return this.getArticulo().getIdArticulo() == item.getArticulo().getIdArticulo();
	}
	
	@Override
	public String toString() {
		return "ItemCarrito" + articulo + ", cantidad = " + cantidad+"\n";
	}
	

	
}
