package modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Envio extends Entrega{

	private LocalTime horaHasta;
	private LocalTime horaDesde;
	private double costo;
	private Ubicacion ubicacion;
	
	public Envio(int id, LocalDate fecha, boolean efectivo, LocalTime horaHasta, LocalTime horaDesde, Ubicacion origen, Ubicacion destino, double costoFijo, double costoPorKm) {
		this.id = id;
		this.fecha = fecha;
		this.efectivo = efectivo;
		this.horaHasta = horaHasta;
		this.horaDesde = horaDesde;
		this.ubicacion = destino;
		setCosto(origen, costoFijo, costoPorKm);
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
	
}
