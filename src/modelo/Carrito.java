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
	
	
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento,
			List<ItemCarrito> listaItems, Cliente cliente, Entrega entrega) {
		super();
		this.idCarrito = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = listaItems;
		this.entrega = entrega;
	}
	
	public Carrito(int id, Cliente cliente) {
		this(id, LocalDate.now(), LocalTime.now(), false, 0, new ArrayList<ItemCarrito>(), cliente, null);
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
	
	/*
	@Override
	public String toString() {
		return "Carrito [id=" + idCarrito + ", fecha: " + fecha + ", hora: " + hora + ", cerrado: " + cerrado + ", descuento = "
				+ descuento + ", cliente = " + cliente + ", lstItemCarrito = " + lstItemCarrito + ", entrega = " + entrega
				+ "]";
	}*/
	
	public String toString() {
		String str = "";
		str += "#" + idCarrito + " " + fecha + " - " + hora + "\n";
		str += "Cliente: " + cliente.getNombreCompleto() + "\nCerrado: " + cerrado + "\n";
		str += "Detalle: \n";
		for(ItemCarrito item : lstItemCarrito) {
			str += item.toString();
		}
		if(lstItemCarrito.isEmpty()) str+= "<no hay items en el carrito>\n";
		if(cerrado) {
			str += entrega.toString();
		}else {
			str += "<entrega sin definir>\n";
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
		
		if(auxIC != null) {
			
			int cantActual = auxIC.getCantidad();
			
			if( (cantActual<cantidad) || (cantidad<=0)) {
				throw new Exception ("Cantidad a eliminar invalida");
			}else if( cantActual == cantidad) {
				lstItemCarrito.remove(auxIC);
			}else if( cantActual > cantidad) {
				auxIC.setCantidad(auxIC.getCantidad() - cantidad);
			}
			
		}else {
			throw new Exception ("No existe el producto en el carrito");
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
		return calcularTotalCarrito() * porcentajeDescuentoEfectivo /100;
	}
	
	public double calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuento, double porcentajeDescuentoEfectivo) {
		double descuento=0;
		if(this.cerrado==true) {
			if( calcularDescuentoDia(diaDescuento,porcentajeDescuento) >= calcularDescuentoEfectivo(porcentajeDescuentoEfectivo) ) {
				descuento = calcularDescuentoDia(diaDescuento,porcentajeDescuento);
			}else {
				descuento = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
			}
		}
		return descuento;
	}
}
