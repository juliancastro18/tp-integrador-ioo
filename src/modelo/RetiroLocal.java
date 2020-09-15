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

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public boolean isEfectivo() {
		return efectivo;
	}

	@Override
	public void setEfectivo(boolean efectivo) {
		this.efectivo = efectivo;
	}
	
	public LocalTime getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(LocalTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
		
	
}
