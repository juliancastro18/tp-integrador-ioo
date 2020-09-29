package test;

import modelo.Articulo;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Contacto;
import modelo.Ubicacion;

public class testItemsCarrito {

	public static void main(String[] args) throws Exception {
		//Creo cliente
		Ubicacion ubicacion1 = new Ubicacion(342, 764);
		Contacto contacto1 = new Contacto("juan@gmail.com","1134764321",ubicacion1);
		Cliente cliente1 = new Cliente(contacto1, "Blanco", "Juan", 33457215, 'm');
		
		//Creo artículos
		Articulo art1 = new Articulo(1,"Televisor LG 50 PULGADAS","8412584512541",45.000);
		Articulo art2 = new Articulo(2,"Heladera LG","7791234567898",85.000);
		Articulo art3 = new Articulo(3,"Aire acondicionado LG","8412345678905",40.000);
		
		//Creo nuevo carrito
		Carrito c = new Carrito(0, cliente1);
		
		//Imprimo contenido
		System.out.println(c.toString());

		//Agrego items
		c.agregarItem(art1, 1);
		c.agregarItem(art1, 2);
		c.agregarItem(art3, 5);
		
		//Imprimo contenido, deberian aparecer: 3 de art1 y 5 de art3
		System.out.println(c.toString());
		
		//Elimino items
		try {
			c.eliminarItem(art1, 3); //elimino todos
			c.eliminarItem(art3, 4); //elimino 4 y dejo 1
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Imprimo contenido
		System.out.println(c.toString());
		
		//Elimino mas
		try {
			c.eliminarItem(art1, 2); //tendria que tirar error, ya no hay mas
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			c.eliminarItem(art3, 2); //tendria que tirar error, quiero eliminar mas de los que hay
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
