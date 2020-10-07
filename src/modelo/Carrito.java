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
	
	
	//------------------------constructor para pruebas----------------------
	public Carrito(Entrega entrega)
	{
		setEntrega(entrega);
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
	
	
	public String toString() {
		String yesNo[] = {"Sí", "No"};
		String str = "Carrito: #" + idCarrito + " | Fecha: " + fecha + " | Hora: " + hora +"\n"+ "\nCliente: #" + cliente.getId() + " " + cliente.getNombreCompleto()
		+ " DNI: " + cliente.getDni() + "\nEstá cerrado: " + (cerrado? "Sí" : "No") + "\n\nDetalle: \n";
		
		for(ItemCarrito item : lstItemCarrito) {
			str += item.getDetalle();
		}
		
		if(lstItemCarrito.isEmpty()) str+= "\n<No hay items en el carrito>\n";
		str += "\nSubtotal: $" + this.calcularTotalCarrito();

		
		if(cerrado) {
			str += "\nDescuento: $" + this.descuento + "\nTotal a pagar: $" + this.totalAPagarCarrito();
			str += "\n\n" + this.entrega.toString();
		}else {
			str += "\n<Entrega sin definir>\n";
		}
		
		return str;
	}

	public boolean equals(Carrito carro) {
			return this.idCarrito ==carro.getIdCarrito();
	}
	
	
	public void agregarItem(Articulo art, int cantidad) throws Exception {
		
		if(cerrado) throw new Exception("No se puede agregar items a un carrito cerrado");
		
		ItemCarrito auxIC = getItemCarrito(art);
		
		if(auxIC != null) { //si existe el item, agrego la cantidad
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
		
		if( (cantActual<cantidad) || (cantidad<=0)) {
			throw new Exception ("Cantidad a eliminar invalida");
		}else if( cantActual == cantidad) {
			lstItemCarrito.remove(auxIC);
		}else if( cantActual > cantidad) {
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
	
	
	public double calcularTotalCarrito() {
		double total = 0;
		for (ItemCarrito item : this.lstItemCarrito) {
			total += (item.getArticulo().getPrecio() * item.getCantidad());
		}
		return total;
	}
	
	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuento) {
		double descuento = 0;
		if(this.cerrado==true) {
			if(diaDescuento==LocalDate.now().getDayOfMonth()) {
				for(ItemCarrito item : this.lstItemCarrito) {
					descuento += ((item.getCantidad()/2) * item.getArticulo().getPrecio() * porcentajeDescuento / 100);
				}
			}
		}
		return descuento;
	}
	
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		return ( calcularTotalCarrito() * porcentajeDescuentoEfectivo /100 );
	}
	
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
	
	public double totalAPagarCarrito() {
		return ( calcularTotalCarrito() - this.descuento );
	}
	

}
