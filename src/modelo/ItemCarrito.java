package modelo;

public class ItemCarrito{
	
	//-------------------------ATRIBUTOS-------------------------
	private Articulo articulo;
	private int cantidad;
	
	//-------------------------CONSTRUCTOR-------------------------
	public ItemCarrito(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	
	public ItemCarrito() {
		super();
	}
	
	//-------------------------GETTERS Y SETTERS-------------------------
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

	//-------------------------METODOS-------------------------
	public boolean equals(ItemCarrito item) {
		return this.getArticulo().getIdArticulo() == item.getArticulo().getIdArticulo();
	}
	
	@Override
	public String toString() {
		return "Articulo: " + articulo + ", Cantidad: " + cantidad + "\n";
	}
	
	public double calcularSubTotalItem() {
		return articulo.getPrecio()*cantidad;
	}
	
}
