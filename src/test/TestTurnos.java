package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Turno;
import modelo.Ubicacion;


public class TestTurnos {

	public static void main(String[] args) {
		
		try {
			//UBICACION Y CONTACTO DEL ALMACEN
			Ubicacion ubicacion0 = new Ubicacion(100, 100);
			Contacto contacto0 = new Contacto("almacengrana@gmail.com", "1110001000", ubicacion0);
			
			
			////////////////////////////////////////////////UBICACION Y CONTACTO DE LOS CLIENTES////////////////////////////////////////////////
			Ubicacion ubicacion1 = new Ubicacion(111, 111);	
			Contacto contacto1 = new Contacto("juan@gmail.com", "1111111111", ubicacion1);
			Contacto contacto2 = new Contacto("kevin@gmail.com", "2222222222", ubicacion1);
			Contacto contacto3 = new Contacto("Juli@gmail.com","3333333333",ubicacion1);
			Contacto contacto4 = new Contacto("Gian@gmail.com","4444444444",ubicacion1);
			
			Cliente cliente1 = new Cliente(contacto1, "Blanco", "Juan", 33457215, 'm');
			Cliente cliente2 = new Cliente(contacto2,"Canepa","Kevin",38826035,'m');
			Cliente cliente3 = new Cliente(contacto3,"Castro","Julian",10101010,'m');
			Cliente cliente4 = new Cliente(contacto4,"lopez","Gianluca",01010101,'m');
			Comercio almacenGranate = new Comercio(0, contacto0, "Almacen Granate", 30548083156l, 100, 5.5, 5, 50, 10);
			almacenGranate.agregarDiaRetiro(1, LocalTime.of(10, 0), LocalTime.of(18, 0), 60);
			almacenGranate.agregarDiaRetiro(2, LocalTime.of(10, 0), LocalTime.of(18, 0), 30);
			////////////////////////////////////////////////AGREGAMOS ARTICULOS////////////////////////////////////////////////
			almacenGranate.agregarArticulo("Televisor LG 50 PULGADAS", "8412584512541", 35000);
			almacenGranate.agregarArticulo("Heladera LG", "8412584512541", 40000);
			almacenGranate.agregarArticulo("Aire acondicionado LG", "8412345678905", 65000);
			
			
			/////////////////////////////////////////////////AGREGAMO CARRITO CLIENTE 1///////////////////////////////////////////////
			almacenGranate.agregarCarrito(cliente1);
			almacenGranate.getListaCarrito().get(0).agregarItem(almacenGranate.getListaArticulos().get(0), 1);
			almacenGranate.getListaCarrito().get(0).agregarItem(almacenGranate.getListaArticulos().get(2), 2);
			///////////////////////////////////////////////AGREGAMOS CARRITO CLIENTE 2///////////////////////////////////////////////
			almacenGranate.agregarCarrito(cliente2);
			/////////////////////////////////////////////////AGREGAMOS HELADERA y 2 TVS///////////////////////////////////////////////
			almacenGranate.getListaCarrito().get(1).agregarItem(almacenGranate.getListaArticulos().get(1),1);
			almacenGranate.getListaCarrito().get(1).agregarItem(almacenGranate.getListaArticulos().get(0),2);
			
			////////////////////////////////////////////////AGREGAMOS CARRITO CLIENTE 3////////////////////////////////////////////////
			almacenGranate.agregarCarrito(cliente3);
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(0),1);
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(1),2);
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(2),3);
			
			almacenGranate.agregarCarrito(cliente4);
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(0),1);
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(1),2);
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(2),3);
			
			
			
			////////////////////////////////////////////////CERRAMOS CARRITOS////////////////////////////////////////////////
			almacenGranate.confirmarCarritoEnvio(almacenGranate.getListaCarrito().get(0), true, null, null, null);
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(1), true, LocalDate.of(2020, 9, 1));
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(3), true, LocalDate.of(2020, 9, 1));
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(2), true, LocalDate.of(2020, 9, 1));
			
		
			

			for (Turno turno : almacenGranate.generarTurnosLibres(LocalDate.of(2020, 9, 1))) {
				System.out.println(turno.toString());
			}
			
			for(Turno turno : almacenGranate.generarTurnosOcupados(LocalDate.of(2020, 9, 1))) {
				System.out.println(turno.toString());
			}
			
			System.out.println(almacenGranate.getListaCarrito());
			 

			//System.out.println("Turnos libres: "+almacenGranate.generarTurnosLibres(LocalDate.of(2020, 9, 1)));
			//System.out.println("Turnos ocupados: "+almacenGranate.generarTurnosOcupados(LocalDate.of(2020, 9, 1)));
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.println("Agenda------------>"+almacenGranate.generarAgenda(LocalDate.of(2020, 9, 1)));

			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}