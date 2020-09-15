package modelo;
import java.time.LocalDate;

public abstract class Entrega {

	protected int id;
	protected LocalDate fecha;
	protected boolean efectivo;
	
	public abstract int getId();

	public abstract void setId(int id);

	public abstract LocalDate getFecha();

	public abstract void setFecha(LocalDate fecha);

	public abstract boolean isEfectivo();

	public abstract void setEfectivo(boolean efectivo);
	
}
