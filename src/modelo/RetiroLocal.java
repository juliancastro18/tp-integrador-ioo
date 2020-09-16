package modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroLocal extends Entrega {

	private LocalTime horaEntrega;

	public RetiroLocal(int id, LocalDate fecha, boolean efectivo, LocalTime horaEntrega) {
		this.id = id;
		this.fecha = fecha;
		this.efectivo = efectivo;
		this.horaEntrega = horaEntrega;
	}
	
	public LocalTime getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(LocalTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
		
	
}
