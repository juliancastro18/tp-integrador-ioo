package modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroLocal extends Entrega {

	private LocalTime horaEntrega;

	public RetiroLocal(int id, LocalDate fecha, boolean efectivo, LocalTime horaEntrega) {
		super(id, fecha, efectivo);
		this.horaEntrega = horaEntrega;
	}
	
	
	public LocalTime getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(LocalTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}

	@Override
	public String toString() {
		String str = "";
		str += super.toString();
		str += "Tipo de entrega: Retiro en el local\nHora de entrega: " + horaEntrega;
		return str;
	}
			
	
}
