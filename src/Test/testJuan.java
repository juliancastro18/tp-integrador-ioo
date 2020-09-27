package Test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.DiaRetiro;
import modelo.Entrega;
import modelo.RetiroLocal;
import modelo.Carrito;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;
import java.util.ArrayList;
import java.util.List;


public class testJuan {

	public static void main(String[] args) {
		Ubicacion ubicacion1 = new Ubicacion(342, 764);
		Contacto contacto1 = new Contacto("juan@gmail.com","1134764321",ubicacion1);
		
		LocalDate fecha = LocalDate.of(2020, 9, 5);
		//List<DiaRetiro> listaDiasRetiro = new ArrayList<DiaRetiro>();
		//listaDiasRetiro.add(new DiaRetiro(1, LocalTime.of(10, 0), LocalTime.of(18, 0), 30));
		List<Carrito> carritos = new ArrayList<Carrito>();
		Entrega entrega = new RetiroLocal(fecha, LocalTime.of(12, 0));
		Entrega entrega2 = new RetiroLocal(fecha, LocalTime.of(14, 0));
		carritos.add(new Carrito(entrega));
		carritos.add(new Carrito(entrega2));
		
		try
		{
			
			Comercio comercio = new Comercio(123, contacto1, 20395149866L);
			comercio.agregarDiaRetiro(1, LocalTime.of(10, 0), LocalTime.of(18, 0), 30);
			comercio.agregarDiaRetiro(5, LocalTime.of(10, 0), LocalTime.of(17, 0), 40);
			//comercio.agregarCarrito(cliente, esEnvio);
			
			for(DiaRetiro turno : comercio.getListaDiaRetiro())
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
