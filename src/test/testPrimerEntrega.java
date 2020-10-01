package test;

import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;

public class testPrimerEntrega {

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
			////////////////////////////////////////////////AGREGAMOS ARTICULOS////////////////////////////////////////////////
			almacenGranate.agregarArticulo("Televisor LG 50 PULGADAS", "8412584512541", 35000);
			almacenGranate.agregarArticulo("Heladera LG", "7791234567898", 40000);
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
			
			///////////////////////////////////////////////MODICAMOS CANTIDADES DE ITEMS////////////////////////////////////////////////
			almacenGranate.getListaCarrito().get(2).eliminarItem(almacenGranate.getListaArticulos().get(0), 1);
			almacenGranate.getListaCarrito().get(2).eliminarItem(almacenGranate.getListaArticulos().get(1), 1);

			
			////////////////////////////////////////////////CERRAMOS CARRITOS////////////////////////////////////////////////
			almacenGranate.confirmarCarritoEnvio(almacenGranate.getListaCarrito().get(0), true, null, null, null);
			almacenGranate.confirmarCarritoEnvio(almacenGranate.getListaCarrito().get(2), true, null, null, null);
			
			////////////////////////////////////////////////AGREGO CARRITO A UN MISMO CLIENTE////////////////////////////////////////////////
			almacenGranate.agregarCarrito(cliente3);
			almacenGranate.getListaCarrito().get(3).agregarItem(almacenGranate.getListaArticulos().get(0),1);

			////////////////////////////////////////////////MOSTRAMOS POR CONSOLA LA LISTA ENTERA DE CARRITOS////////////////////////////////////////////////
			System.out.println("                                   LISTA DE CARRITOS                                ");
			System.out.println(almacenGranate.getListaCarrito());
			System.out.println("---------------------------------------------------------------------------------------");
			////////////////////////////////////////////////MOSTRAMOS CARRITO CLIENTE 1 POR TOTAL A PAGAR////////////////////////////////////////////////
			System.out.println("                                 CARRITO TOTAL A PAGAR                                   ");
			System.out.println(almacenGranate.getListaCarrito().get(0) + " " + almacenGranate.getListaCarrito().get(0).totalAPagarCarrito() + "\n\n");
			System.out.println(almacenGranate.getListaCarrito().get(2) + " " + almacenGranate.getListaCarrito().get(0).totalAPagarCarrito() + "\n\n");
			System.out.println("----------------------------------------------------------------------------------------");


			////////////////////////////////////////////////BORRAMOS CARRITO ABIERTO CLIENTE 2////////////////////////////////////////////////
			almacenGranate.eliminarCarrito(1);
			
			////////////////////////////////////////////////VOLVEMOS A MOSTRAR - MUESTRA DOS CARRITOS--> CLIENTE 1/3////////////////////////////////////////////////
			
			System.out.println("                                   MUESTRA LOS CARRITOS QUE QUEDARON                             ");
			System.out.println(almacenGranate.getListaCarrito());
			System.out.println("---------------------------------------------------------------------------------------");
		
		}catch(Exception e) {
			System.out.println("Excepcion: "+e.getMessage());
		}

	}

}
