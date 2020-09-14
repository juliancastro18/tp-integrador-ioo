package modelo;
import java.time.LocalTime;

public class DiaRetiro {
	
	private int id;
	private int diaSemana;
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	private int intervalo;
	
	
	public DiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		this.diaSemana = diaSemana;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
		this.intervalo = intervalo;
	}
	
	
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected int getDiaSemana() {
		return diaSemana;
	}
	protected void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	protected LocalTime getHoraDesde() {
		return horaDesde;
	}
	protected void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}
	protected LocalTime getHoraHasta() {
		return horaHasta;
	}
	protected void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}
	protected int getIntervalo() {
		return intervalo;
	}
	protected void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	
	
	
	
}
