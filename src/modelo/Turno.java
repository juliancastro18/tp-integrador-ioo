package modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	
	private LocalDate dia;
	private LocalTime hora;
	private boolean ocupado;
	
	public Turno(LocalDate dia, LocalTime hora, boolean ocupado) {
		this.dia = dia;
		this.hora = hora;
		this.ocupado = ocupado;
	}
	
	
	protected LocalDate getDia() {
		return dia;
	}
	protected void setDia(LocalDate dia) {
		this.dia = dia;
	}
	protected LocalTime getHora() {
		return hora;
	}
	protected void setHora(LocalTime hora) {
		this.hora = hora;
	}
	protected boolean isOcupado() {
		return ocupado;
	}
	protected void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	
	//-----------To String------------
	public String toString()
	{
		return "Dia: " + getDia() + "\nHora: " + getHora() + "\nOcupado: " + isOcupado();
	}
}
