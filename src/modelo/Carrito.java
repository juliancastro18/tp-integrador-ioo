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
	private List<ItemCarrito>lstItemCarrito;
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
	
	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento,
			Cliente cliente, Entrega entrega) {
		this(id, fecha, hora, cerrado, descuento, new ArrayList<ItemCarrito>(), cliente, entrega);
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
	
	public void setDescuento(int descuento) {
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
	

	@Override
	public String toString() {
		return "Carrito [id=" + idCarrito + ", fecha: " + fecha + ", hora: " + hora + ", cerrado: " + cerrado + ", descuento = "
				+ descuento + ", cliente = " + cliente + ", lstItemCarrito = " + lstItemCarrito + ", entrega = " + entrega
				+ "]";
	}

	public boolean equals(Carrito carro) {
			return this.idCarrito ==carro.getIdCarrito();
	}
	
	
}
