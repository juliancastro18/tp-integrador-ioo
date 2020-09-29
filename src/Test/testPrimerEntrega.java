package Test;

import modelo.Ubicacion;
import modelo.Contacto;
import modelo.Cliente;
import modelo.Comercio;

public class testPrimerEntrega {

	public static void main(String[] args) throws Exception {
		
		//CREAMOS COMERCIO
		Ubicacion ubicacion0 = new Ubicacion(100, 100);
		Contacto contacto0 = new Contacto("almacengrana@gmail.com", "1110001000", ubicacion0);
		Comercio almacenGranate = new Comercio(0, contacto0, "Almacen Granate", 30548083156l, 100, 5.5, 5, 50, 10);
		
		
		//CREAMOS CLIENTES
		Ubicacion ubicacion1 = new Ubicacion(111, 111);
		Contacto contacto1 = new Contacto("juan@gmail.com", "1111111111", ubicacion1);
		Cliente cliente1 = new Cliente(contacto1, "Blanco", "Juan", 33457215, 'm');
		
		
		//AGREGAMOS ARTICULOS
		almacenGranate.agregarArticulo("Televisor LG 50 PULGADAS", "8412584512541", 35000);
		almacenGranate.agregarArticulo("Heladera LG", "7791234567898", 40000);
		almacenGranate.agregarArticulo("Aire acondicionado LG", "8412345678905", 65000);
		
		
		//AGREGAMOS CARRITOS
		almacenGranate.agregarCarrito(cliente1);
		almacenGranate.getListaCarrito().get(0).agregarItem(almacenGranate.getListaArticulos().get(0), 1);
		almacenGranate.getListaCarrito().get(0).agregarItem(almacenGranate.getListaArticulos().get(2), 2);
		
		//CERRAMOS CARRITOS
		almacenGranate.confirmarCarritoEnvio(almacenGranate.getListaCarrito().get(0), true, null, null, null);
		
		//MOSTRAMOS POR CONSOLA
		System.out.println( almacenGranate.getListaCarrito().get(0) + " " + almacenGranate.getListaCarrito().get(0).totalAPagarCarrito() );
		
		//INTENTAMOS ELIMINAR CARRITO CERRADO
		almacenGranate.eliminarCarrito(0);

	}

}
