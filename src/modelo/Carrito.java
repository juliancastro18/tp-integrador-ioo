package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito{
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito;
	private Entrega entrega;
	
	
	public Carrito(int id, Cliente cliente) {
		super();
		this.idCarrito = id;
		this.cliente = cliente;
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
		inicializarValoresPorDefecto();
	}
	
	private void inicializarValoresPorDefecto() {
		this.fecha = LocalDate.now();
		this.hora = LocalTime.now();
		this.cerrado = false;
	}
	
	
	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdCarrito() {
		return idCarrito;
	}
	
	public void setIdCarrito(int id) {
		this.idCarrito = id;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public boolean isCerrado() {
		return cerrado;
	}
	
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	
	public double getDescuento() {
		return descuento;
	}
	
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}
	
	public void setLstItemCarrito(List<ItemCarrito>lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}
	
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	
	public boolean equals(Carrito carro) {
		return this.idCarrito ==carro.getIdCarrito();
	}
	
	
	public String toString() {
		String str = "Carrito: #" + idCarrito + " | Fecha: " + fecha + " | Hora: " + hora +"\n"+ "\nCliente: #" +
		cliente.getId() + " " + cliente.getNombreCompleto() + " DNI: " + cliente.getDni() + 
		"\nEst� cerrado: " + (cerrado? "S�" : "No") + "\n\nDetalle: \n";
		
		for(ItemCarrito item : lstItemCarrito) {
			str += item.getDetalle();
		}
		
		if(lstItemCarrito.isEmpty()) str+= "\n<No hay items en el carrito>\n";
		str += "\nSubtotal: $" + this.calcularTotalCarrito();

		
		if(cerrado) {
			str += "\nDescuento: $" + this.descuento + "\nTotal a pagar: $" + this.totalAPagarCarrito();
			str += "\n\n" + this.entrega.toString()+"\n------------------------------------------------\n";
		}else {
			str += "\n<Entrega sin definir>\n------------------------------------------------\n";
		}
		
		return str;
	}

	// ----------------------------- ADMINISTRAR ITEM-CARRITOS -----------------------------
	
	public void agregarItem(Articulo art, int cantidad) throws Exception {
		
		if(cerrado) throw new Exception("No se puede agregar items a un carrito cerrado");
		
		ItemCarrito auxIC = getItemCarrito(art); //obtengo item correspondiente al articulo
		
		if(auxIC != null) { //si existe el item, agrego la cantidad pasada por parametro
			auxIC.setCantidad(auxIC.getCantidad() + cantidad);
		}else { //si no existe, creo un ItemCarrito nuevo
			lstItemCarrito.add(new ItemCarrito(art, cantidad));
		}
	}
	
	
	public void eliminarItem(Articulo art, int cantidad) throws Exception {
		
		if(cerrado) throw new Exception("No se puede eliminar items de un carrito cerrado");
		
		ItemCarrito auxIC = getItemCarrito(art);
		if(auxIC == null) {
			throw new Exception ("No existe el producto en el carrito");
		}
			
		int cantActual = auxIC.getCantidad();
		
		if( (cantActual<cantidad) || (cantidad<=0)) { //si se quiere eliminar mas unidades de las que hay
			throw new Exception ("Cantidad a eliminar invalida");
		}else if( cantActual == cantidad) { //si la cantidad a eliminar coincide con la del carrito, elimino el item
			lstItemCarrito.remove(auxIC);
		}else if( cantActual > cantidad) { //sino, le resto la cantidad ingresada por parametro
			auxIC.setCantidad(auxIC.getCantidad() - cantidad);
		}
	}
	
	//devuelve el ItemCarrito correspondiente a un articulo
	public ItemCarrito getItemCarrito(Articulo art) {
		int contador = 0;
		boolean encontrado = true;
		ItemCarrito auxIC = null;
		
		while( (auxIC == null) && (contador<lstItemCarrito.size()) ) {
			encontrado = lstItemCarrito.get(contador).getArticulo().equals(art);
			if(encontrado) auxIC = lstItemCarrito.get(contador);
			contador++;
		}
		
		return auxIC;
	}
	
	
	// ----------------------------- CALCULOS CARRITOS -----------------------------
	
	//Calcula el total del carrito sin descuentos aplicados
	public double calcularTotalCarrito() {
		double total = 0;
		for (ItemCarrito item : this.lstItemCarrito) {
			total += item.calcularSubTotalItem(); //Calcula el monto por item y lo suma al total
		}
		return total;
	}
	
	//Calcula el descuento del total del carrito en base al dia
	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuento) {
		double descuento = 0;
		
		if(this.cerrado==true) { //Si el carrito esta cerrado
			if(diaDescuento==LocalDate.now().getDayOfMonth()) { //y coincide el dia de la compra con el dia de promociones
				for(ItemCarrito item : this.lstItemCarrito) {
					descuento += ((item.getCantidad()/2) * item.getArticulo().getPrecio() * porcentajeDescuento / 100); //Aplica la promo(% de descuento a la segunda unidad) y lo va sumando
				}
			}
		}
		
		return descuento;
	}
	
	//Calcula el descuento del total del carrito si es efectivo
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		double descuento = 0;
		
		if(this.entrega.isEfectivo()) {
			descuento = (calcularTotalCarrito() * porcentajeDescuentoEfectivo /100);
		}
		
		return descuento;
	}
	
	//Devuelve el descuento mayor de los dos posibles
	public double calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuento, double porcentajeDescuentoEfectivo) {
		double descuento = 0;
		if(this.cerrado==true) {
			double dEfectivo = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
			double dDia = calcularDescuentoDia(diaDescuento,porcentajeDescuento);
			if( dDia >= dEfectivo ) {
				descuento = dDia;
			}else {
				descuento = dEfectivo;
			}
		}
		return descuento;
	}
	
	//Devuelve el total del carrito con el descuento aplicado
	public double totalAPagarCarrito() {
		return ( calcularTotalCarrito() - this.descuento );
	}
	

}
