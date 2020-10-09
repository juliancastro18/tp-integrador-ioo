package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;



public class testEntregaFinal {

	public static void main(String[] args) {
		
		try {
			Articulo articuloPrueba = new Articulo(0,"Arroz Luchetti","7791234567892",45.00);
		}catch(Exception e) {
			System.out.println("Excepcion:"+ e.getMessage());
		}
		try {
			Ubicacion ubicacion0 = new Ubicacion(-34.812231, -58.401095);
			Contacto contacto0 = new Contacto("almacengrana@gmail.com", "1110001000", ubicacion0);
			////////////////////////////////////////////////UBICACION Y CONTACTO DE LOS CLIENTES////////////////////////////////////////////////
			Ubicacion ubicacion1 = new Ubicacion(-34.809141,-58.384877);	
			Contacto contacto1 = new Contacto("juan@gmail.com", "1111111111", ubicacion1);
			Contacto contacto2 = new Contacto("kevin@gmail.com", "2222222222", ubicacion1);
			Contacto contacto3 = new Contacto("Juli@gmail.com","3333333333",ubicacion1);
			Contacto contacto4 = new Contacto("Gian@gmail.com","4444444444",ubicacion1);
			
			Cliente cliente1 = new Cliente(contacto1, "Blanco", "Juan", 33457215, 'm');
			Cliente cliente2 = new Cliente(contacto2,"Canepa","Kevin",38826035,'m');
			Cliente cliente3 = new Cliente(contacto3,"Castro","Julian",10101010,'m');
			Cliente cliente4 = new Cliente(contacto4,"Cambareri","Gianluca",01010101,'m');
			////////////////////////////////////////////////CREAMOS EL COMERCIO////////////////////////////////////////////////
			Comercio almacenGranate = new Comercio(0, contacto0, "Almacen Granate", 30548083156l, 200,100 , 5, 50, 10);

			
			/////////////////////////////////////////////////AGREGAMOS DIAS DE RETIRO////////////////////////////////////////////////
			almacenGranate.agregarDiaRetiro(1, LocalTime.of(10, 0), LocalTime.of(18, 0), 60);
			almacenGranate.agregarDiaRetiro(2, LocalTime.of(10, 0), LocalTime.of(18, 0), 30);
			almacenGranate.agregarDiaRetiro(3, LocalTime.of(10, 0), LocalTime.of(18, 0), 30);
			almacenGranate.agregarDiaRetiro(4, LocalTime.of(10, 0), LocalTime.of(18, 0), 30);
			almacenGranate.agregarDiaRetiro(5, LocalTime.of(10, 0), LocalTime.of(18, 0), 30);
			
			////////////////////////////////////////////////AGREGAMOS ARTICULOS////////////////////////////////////////////////
			almacenGranate.agregarArticulo("Televisor LG 50 PULGADAS", "8412584512541", 35000);
			almacenGranate.agregarArticulo("Heladera LG", "7791234567898", 40000);
			almacenGranate.agregarArticulo("Aire acondicionado LG", "8412345678905", 65000);
			
			
			/////////////////////////////////////////////////AGREGAMO CARRITOS E ITEMS A LOS MISMOS///////////////////////////////////////////////
			almacenGranate.agregarCarrito(cliente1);
			
			almacenGranate.getListaCarrito().get(0).agregarItem(almacenGranate.getListaArticulos().get(0), 1);
			almacenGranate.getListaCarrito().get(0).agregarItem(almacenGranate.getListaArticulos().get(2), 2);

			almacenGranate.agregarCarrito(cliente2);

			almacenGranate.getListaCarrito().get(1).agregarItem(almacenGranate.getListaArticulos().get(1),1);
			almacenGranate.getListaCarrito().get(1).agregarItem(almacenGranate.getListaArticulos().get(0),2);
			
			almacenGranate.agregarCarrito(cliente3);
			
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(0),1);
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(1),2);
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(2),3);
						
			almacenGranate.agregarCarrito(cliente4);
			
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(0),1);
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(1),2);
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(2),3);
			
			////////////////////////////////////////////////MODIFICAMOS CARRITO///////////////////////////////////////////////
			almacenGranate.getListaCarrito().get(3).eliminarItem(almacenGranate.getListaArticulos().get(0), 1);
			almacenGranate.getListaCarrito().get(3).eliminarItem(almacenGranate.getListaArticulos().get(1), 1);

			
			
			////////////////////////////////////////////////CONFIRMAMOS CARRITOS///////////////////////////////////////////////
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(0), true, LocalDate.of(2020, 9, 5));
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(1), false, LocalDate.of(2020, 9, 4));
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(2), true, LocalDate.of(2020, 9, 3));
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(3), true, LocalDate.of(2020, 9, 2));
			
			////////////////////////////////////////////////AGREGO OTRO CARRITO A UN MISMO CLIENTE Y LO CONFIRMO////////////////////////////////////////////////
			almacenGranate.agregarCarrito(cliente3);
			almacenGranate.getListaCarrito().get(4).agregarItem(almacenGranate.getListaArticulos().get(0),1);
			
			almacenGranate.confirmarCarritoEnvio(almacenGranate.getListaCarrito().get(4), true, LocalDate.of(2020, 9, 5), LocalTime.of(10, 0), LocalTime.of(17, 0));
			

			////////////////////////////////////////////////MOSTRAMOS POR CONSOLA////////////////////////////////////////////////
			System.out.println("-------------------------------------------ALMACEN GRANATE-------------------------------------------");
			System.out.println(almacenGranate);
			
			System.out.println("-------------------------------------------LISTA DE CARRITOS-------------------------------------------");
			
			System.out.println(almacenGranate.getListaCarrito().get(0));
			System.out.println(almacenGranate.getListaCarrito().get(1));
			System.out.println(almacenGranate.getListaCarrito().get(2));
			System.out.println(almacenGranate.getListaCarrito().get(3));
			System.out.println(almacenGranate.getListaCarrito().get(4));
			
			System.out.println("-------------------------------------------TURNOS LIBRES-------------------------------------------");
			System.out.println(almacenGranate.generarTurnosLibres(LocalDate.of(2020, 9, 1)));
			System.out.println("-------------------------------------------TURNOS OCUPADOS-------------------------------------------");
			System.out.println(almacenGranate.generarTurnosOcupados(LocalDate.of(2020, 9, 1)));
			System.out.println("-------------------------------------------AGENDA-------------------------------------------");
			System.out.println(almacenGranate.generarAgenda(LocalDate.of(2020, 9, 1)));

		}catch(Exception e) {
			System.out.println("Excepcion:"+ e.getMessage());
		}
		
		
		
	}

}
