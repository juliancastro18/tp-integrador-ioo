package modelo;
import java.time.LocalDate;

public abstract class Entrega {

	protected int id;
	protected LocalDate fecha;
	protected boolean efectivo;
	
	public Entrega(int id, LocalDate fecha, boolean efectivo)
	{
		setId(id);
		setFecha(fecha);
		setEfectivo(efectivo);
	}
	
	//----------------constructor para pruebas--------------------
	public Entrega(LocalDate fecha)
	{
		setFecha(fecha);
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isEfectivo() {
		return efectivo;
	}
	public void setEfectivo(boolean efectivo) {
		this.efectivo = efectivo;
	}

	@Override
	public String toString() {
		return "Fecha de entrega: " + fecha + "\nAbona en efectivo: " + efectivo + "\n";
	}
	
	
	
}
