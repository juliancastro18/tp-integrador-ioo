package modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroLocal extends Entrega {

	private LocalTime horaEntrega;

	public RetiroLocal(int id, LocalDate fecha, boolean efectivo, LocalTime horaEntrega) {
		super(id, fecha, efectivo);
		this.horaEntrega = horaEntrega;
	}
	
	//---------------------constructor para pruebas---------------------
	public RetiroLocal(LocalDate fecha, LocalTime horaentrega)
	{
		super(fecha);
		setHoraEntrega(horaentrega);
	}
	
	
	public LocalTime getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(LocalTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}

	@Override
	public String toString() {
		return "RetiroLocal [horaEntrega=" + horaEntrega + ", id=" + id + ", fecha=" + fecha + ", efectivo=" + efectivo	+ "]";
	}
			
	
}
