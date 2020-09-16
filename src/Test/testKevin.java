package Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Carrito;
import modelo.Comercio;
import modelo.Contacto;
import modelo.ItemCarrito;
import modelo.Ubicacion;



public class testKevin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ubicacion ubicacion1 = new Ubicacion(150.0,210.00);
		
		Contacto contacto1 = new Contacto("kevin@kevin.com","1136592243",ubicacion1);
		
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		
		List<Carrito> listaCarrito = new ArrayList<Carrito>();
		
		
		
		
		
		Articulo art1 = new Articulo(1,"Televisor LG 50 PULGADAS","0123566",45.000);
		Articulo art2 = new Articulo(2,"Heladera LG","101112",85.000);
		Articulo art3 = new Articulo(3,"Aire acondicionado LG","010203",40.000);
		Articulo art4 = new Articulo(4,"Lavavajillas","202122",35.000);
		
		
		List<ItemCarrito> lstItemCarrito = new ArrayList<ItemCarrito>();
		
		Comercio comercio = new Comercio(contacto1,"Disco",listaArticulos,listaCarrito);
		ItemCarrito item1 = new ItemCarrito(art1,5);
		ItemCarrito item2 = new ItemCarrito(art2,2);
		ItemCarrito item3 = new ItemCarrito(art4,4);
		
		listaArticulos.add(art1);
		listaArticulos.add(art2);
		listaArticulos.add(art3);
		listaArticulos.add(art4);
		
		
		lstItemCarrito.add(item1);
		lstItemCarrito.add(item2);
		lstItemCarrito.add(item3);
		
		
		Carrito carrito1 = new Carrito(1,LocalDate.now(),LocalTime.now(),true,15.30,lstItemCarrito, null, null);
		
		//System.out.println(carrito1);
		System.out.println("Treaer producto:--->"+comercio.traerProducto(6));
		
	
		
	}

}
