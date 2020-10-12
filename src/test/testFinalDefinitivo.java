package test;


import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Carrito;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;


public class testFinalDefinitivo {

	public static void main(String[] args) {
		
		Ubicacion ubicacionComercio = null;
		Ubicacion ubicacionCliente = null;
		Contacto contactoComercio = null;
		Contacto contacto1 = null;
		Contacto contacto2 = null;
		Contacto contacto3 = null;
		Contacto contacto4 = null;
		Contacto contacto5 = null;
		Comercio almacenGranate = null;
		Cliente cliente1 = null;
		Cliente cliente2 = null;
		Cliente cliente3 = null;
		Cliente cliente4 = null;
		Cliente cliente5 = null;

				
		///////////////////////////////////////////////////////////////////UBICACIONES Y CONTACTOS////////////////////////////////////////////////////////////////////
		
		try {
			ubicacionComercio = new Ubicacion(-34.812231, -58.401095);
			ubicacionCliente = new Ubicacion(-34.809141,-58.384877);	
			contactoComercio = new Contacto("almacengrana@gmail.com", "1110001000", ubicacionComercio);
			contacto1 = new Contacto("juan@gmail.com", "1111111111", ubicacionCliente);
			contacto2 = new Contacto("kevin@gmail.com", "2222222222", ubicacionCliente);
			contacto3 = new Contacto("Juli@gmail.com","3333333333",ubicacionCliente);
			contacto4 = new Contacto("Gian@gmail.com","4444444444",ubicacionCliente);
			contacto5 = new Contacto("gianluca@Excepciones.com", "1128657837", ubicacionCliente);
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		////////////////////////////////////////////////////////////////////CREAMOS EL COMERCIO////////////////////////////////////////////////////////////////////
		
		try {
			almacenGranate = new Comercio(0, contactoComercio, "Almacen Granate", 30548083156l, 200,100 , 1, 50, 10);
			System.out.println(almacenGranate);
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		////////////////////////////////////////////////////////////////////AGREGAMOS DIAS DE RETIRO////////////////////////////////////////////////////////////////////
		
		try {
			almacenGranate.agregarDiaRetiro(1, LocalTime.of(10, 0), LocalTime.of(18, 0), 60);
			almacenGranate.agregarDiaRetiro(2, LocalTime.of(10, 0), LocalTime.of(18, 0), 30);
			almacenGranate.agregarDiaRetiro(3, LocalTime.of(10, 0), LocalTime.of(11, 0), 60);
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		////////////////////////////////////////////////////////////////////CREAMOS CLIENTES////////////////////////////////////////////////////////////////////
		
		try {
			cliente1 = new Cliente(contacto1, "Blanco", "Juan", 33457215, 'm');
			cliente2 = new Cliente(contacto2,"Canepa","Kevin",38826035,'m');
			cliente3 = new Cliente(contacto3,"Castro","Julian",10101010,'m');
			cliente4 = new Cliente(contacto4,"Cambareri","Gianluca",01010101,'m');
			cliente5 = new Cliente(contacto5, "GoogleGianGoogle", "GianLuigi", 39514986, 'm');
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////AGREGAMOS ARTICULOS////////////////////////////////////////////////////////////////////
		
		try {
			almacenGranate.agregarArticulo("Televisor LG 50 PULGADAS", "8412584512541", 35000);
			almacenGranate.agregarArticulo("Heladera LG", "7791234567898", 40000);
			almacenGranate.agregarArticulo("Aire acondicionado LG", "8412345678905", 65000);
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////CREAMOS CARRITOS////////////////////////////////////////////////////////////////////
		
		try {
			almacenGranate.agregarCarrito(cliente1);
			almacenGranate.agregarCarrito(cliente2);
			almacenGranate.agregarCarrito(cliente3);
			almacenGranate.agregarCarrito(cliente4);
			almacenGranate.agregarCarrito(cliente5);

			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////CARGAMOS CARRITOS////////////////////////////////////////////////////////////////////
		
		try {
			
			//CLIENTE 1
			almacenGranate.getListaCarrito().get(0).agregarItem(almacenGranate.getListaArticulos().get(0), 1);
			almacenGranate.getListaCarrito().get(0).agregarItem(almacenGranate.getListaArticulos().get(2), 2);
			//CLIENTE 2
			almacenGranate.getListaCarrito().get(1).agregarItem(almacenGranate.getListaArticulos().get(1),1);
			almacenGranate.getListaCarrito().get(1).agregarItem(almacenGranate.getListaArticulos().get(0),2);
			//CLIENTE 3
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(0),1);
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(1),2);
			almacenGranate.getListaCarrito().get(2).agregarItem(almacenGranate.getListaArticulos().get(2),3);
			//CLIENTE 4
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(0),1);
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(1),2);
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(2),3);
			
			almacenGranate.getListaCarrito().get(4).agregarItem(almacenGranate.getListaArticulos().get(0), 1);
					
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////MODIFICAMOS CARRITO 3////////////////////////////////////////////////////////////////////
		
		try {
			almacenGranate.getListaCarrito().get(3).eliminarItem(almacenGranate.getListaArticulos().get(0), 1);
			almacenGranate.getListaCarrito().get(3).eliminarItem(almacenGranate.getListaArticulos().get(1), 1);
			System.out.println("------------------------------------------------LISTA DE CARRITOS------------------------------------------------");
			
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}

		//////////////////////////////////////////////////////////////////CONFIRMAMOS CARRITOS Y CERRAMOS//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(0), false, LocalDate.of(2020, 10, 1));
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(1), true, LocalDate.of(2020, 10, 1));
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(2), true, LocalDate.of(2020, 10, 1));
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(4), false, LocalDate.of(2020, 10, 3));
			almacenGranate.confirmarCarritoEnvio(almacenGranate.getListaCarrito().get(3), true, LocalDate.of(2020, 10, 5), LocalTime.of(10, 0), LocalTime.of(17, 0));
			
			for(Carrito carritoCompras : almacenGranate.getListaCarrito()) {
				almacenGranate.mostrarCarrito(carritoCompras.getIdCarrito());
			}
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////MOSTRAMOS AGENDA Y TURNOS//////////////////////////////////////////////////////////////////
		
		try {
			System.out.println("------------------------------------------------AGENDA------------------------------------------------");
			System.out.println(almacenGranate.generarAgenda(LocalDate.of(2020, 10, 1)));
			System.out.println("------------------------------------------------TURNOS LIBRES------------------------------------------------");
			System.out.println(almacenGranate.generarTurnosLibres(LocalDate.of(2020, 10, 1)));
			System.out.println("------------------------------------------------TURNOS OCUPADOS------------------------------------------------");
			System.out.println(almacenGranate.generarTurnosOcupados(LocalDate.of(2020, 10, 1)));
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////REPETIMOS CLIENTE CON NUEVO CARRITO DISTINTO DIA//////////////////////////////////////////
		
		try {
			System.out.println("------------------------------------------------");
			almacenGranate.agregarCarrito(cliente4);
			almacenGranate.getListaCarrito().get(4).agregarItem(almacenGranate.getListaArticulos().get(0),5);
			almacenGranate.confirmarCarritoRetiroLocal(almacenGranate.getListaCarrito().get(4), false, LocalDate.of(2020, 10, 2));
			almacenGranate.mostrarCarrito(almacenGranate.getListaCarrito().get(4).getIdCarrito());
			
			System.out.println("------------------------------------------------AGENDA------------------------------------------------");
			System.out.println(almacenGranate.generarAgenda(LocalDate.of(2020, 10, 2)));
			System.out.println("------------------------------------------------TURNOS LIBRES------------------------------------------------");
			System.out.println(almacenGranate.generarTurnosLibres(LocalDate.of(2020, 10, 2)));
			System.out.println("------------------------------------------------TURNOS OCUPADOS------------------------------------------------");
			System.out.println(almacenGranate.generarTurnosOcupados(LocalDate.of(2020, 10, 2)));
			

			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////EXCEPCIONES//////////////////////////////////////////////////////////////////
		
		System.out.println("----------------------------------------EXCEPCIONES----------------------------------------");
		
		
		//////////////////////////////////////////////////////////////////FALLO CUIL//////////////////////////////////////////////////////////////////
		try {
			almacenGranate = new Comercio(0, contactoComercio, "Almacen Granate", 1111120388260352l, 200,100 , 1, 50, 10);
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////FALLO DNI//////////////////////////////////////////////////////////////////
		try {
			cliente4 = new Cliente(contacto4,"Cambareri","Gianluca",1234567891,'m');
			
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////FALLO EL CODIGO DE BARRAS//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.agregarArticulo("Playstation 4", "8412584522549", 75.000);
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}

		//////////////////////////////////////////////////////////////////ARTICULO NO EXISTE//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.traerArticulo(10);
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////ARTICULO REPETIDO//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.agregarArticulo("Televisor LG 50 PULGADAS", "8412584512541", 35000);
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////SE INTENTA BORRAR ARTICULO QUE NO EXISTE//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.eliminarArticulo(10);
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		/////////////////////////////////////////////////////////////////SE INTENTA BORRAR ARTICULO QUE EXISTE EN UN CARRITO//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.eliminarArticulo(1);
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////SE QUIERE AGREGAR CARRITO CUANDO YA HAY UNO ABIERTO//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.agregarCarrito(cliente4);
			almacenGranate.agregarCarrito(cliente4);
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////BORRAR ARTICULO QUE YA FUE CERRADO//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.eliminarCarrito(0);

		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////NO HAY TURNOS OCUPADOS//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.generarTurnosOcupados((LocalDate.of(2020, 10, 30)));
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
		//////////////////////////////////////////////////////////////////NO HAY TURNOS LIBRES//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.generarTurnosLibres((LocalDate.of(2020, 10, 3)));
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		//////////////////////////////////////////////////////////////////EL DIA RETIRO YA EXISTE//////////////////////////////////////////////////////////////////
		try {
			almacenGranate.agregarDiaRetiro(1, LocalTime.of(10, 0), LocalTime.of(18, 0), 60);
		}catch(Exception e) {
			System.out.println("Excepcion: "+ e.getMessage());
		}
		
	}

}
