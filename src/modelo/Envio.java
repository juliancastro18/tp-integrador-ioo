package modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Envio extends Entrega{

	private LocalTime horaHasta;
	private LocalTime horaDesde;
	private double costo;
	private Ubicacion ubicacion;
	
	public Envio(int id, LocalDate fecha, boolean efectivo, LocalTime horaDesde, LocalTime horaHasta, Ubicacion origen, Ubicacion destino, double costoFijo, double costoPorKm) {
		super(id, fecha, efectivo);
		this.horaHasta = horaHasta;
		this.horaDesde = horaDesde;
		this.ubicacion = destino;
		setCosto(origen, costoFijo, costoPorKm);
	}
	
	public LocalTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(Ubicacion origen, double costoFijo, double costoPorKm) {
		this.costo = costoFijo + (ubicacion.distanciaCoord(origen) * costoPorKm);
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		String str = "";
		str += super.toString();
		str += "Tipo de entrega: Envío\n";
		str += "Rango de entrega: " + horaHasta + " / " + horaDesde + "\n" + "Costo de envío: " + costo;
		return str;
	}
	
}
