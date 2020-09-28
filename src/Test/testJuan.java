package Test;

import java.time.LocalDate;
import java.time.LocalTime;
import modelo.DiaRetiro;
import modelo.RetiroLocal;
import modelo.Turno;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;
import java.util.ArrayList;
import java.util.List;


public class testJuan {

	public static void main(String[] args) {
		
		Ubicacion ubicacion1 = new Ubicacion(342, 764);
		Contacto contacto1 = new Contacto("juan@gmail.com", "1134764321", ubicacion1);
		LocalDate fecha = LocalDate.of(2020, 9, 1);
		Cliente cliente1 = new Cliente(1, contacto1, "asd", "asd", 39514986, 'm');
		Cliente cliente2 = new Cliente(2, contacto1, "ertert", "bnmbnm", 39514986, 'f');
		List<Carrito> listaCarritos = new ArrayList<Carrito>();
		List<DiaRetiro> listaDiaRetiros = new ArrayList<DiaRetiro>();
		Carrito carrito1 = new Carrito(1, cliente1);
		Carrito carrito2 = new Carrito(2, cliente2);
		Carrito carrito3 = new Carrito(3, cliente2);
		carrito1.setEntrega(new RetiroLocal(LocalDate.of(2020, 9, 1), LocalTime.of(11, 0)));
		carrito2.setEntrega(new RetiroLocal(LocalDate.of(2020, 9, 1), LocalTime.of(12, 0)));
		carrito3.setEntrega(new RetiroLocal(LocalDate.of(2020, 9, 2), LocalTime.of(16, 0)));
		listaCarritos.add(carrito1);
		listaCarritos.add(carrito2);
		listaCarritos.add(carrito3);			
			
		try
		{
			
			Comercio comercio = new Comercio(123, contacto1, 20395149866L, listaCarritos, listaDiaRetiros);
			comercio.agregarDiaRetiro(1, LocalTime.of(10, 0), LocalTime.of(18, 0), 60);
			comercio.agregarDiaRetiro(2, LocalTime.of(10, 0), LocalTime.of(18, 0), 30);
			
			for(Turno turno : comercio.generarTurnosLibres(fecha))
			{
				System.out.println(turno.toString());
				System.out.println("");
			}
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
