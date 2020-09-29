package test;

import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Ubicacion;

public class testKevin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Ubicacion ubicacion1 = new Ubicacion(150.0,210.00);
		
		Contacto contacto1 = new Contacto("kevin@kevin.com","1136592243",ubicacion1);
		
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		List<Articulo> listaArticulos2 = new ArrayList<Articulo>();
		List<Articulo> listaArticulos3 = new ArrayList<Articulo>();
		List<Carrito> listaCarrito = new ArrayList<Carrito>();
		Cliente cliente1 = new Cliente(contacto1,"Cánepa","Kevin",38826035,'m');
		Carrito carrito1 = new Carrito(1,cliente1);
		
		
		
		
		try {
			Comercio comercio = new Comercio(1,contacto1,"Disco",listaArticulos,listaCarrito);
			
			Articulo art1 = new Articulo(1,"Televisor LG 50 PULGADAS","8412584512541",45.000);
			Articulo art2 = new Articulo(2,"Heladera LG","7791234567898",85.000);
			Articulo art3 = new Articulo(3,"Aire acondicionado LG","8412345678905",40.000);
			
			comercio.agregarArticulo("Tv lg 50 pulgadas","8412584512541", 45.000);
			comercio.agregarArticulo("Heladera LG", "7791234567898", 85.000);
			System.out.println(comercio);
			System.out.println(comercio.traerArticulo(1));
			carrito1.agregarItem(art1, 4);
			carrito1.agregarItem(art2, 1);
			carrito1.eliminarItem(art1, 2);
			System.out.println(carrito1);
			System.out.println("GET ITEM CARRITO--->"+carrito1.getItemCarrito(art2));
			System.out.println("Calcular total carrito--->"+carrito1.calcularTotalCarrito());
			System.out.println("CALCULAR DESCUENTO EFECTIVO---->"+carrito1.calcularDescuentoEfectivo(10));
			System.out.println("CALCULAR DESCUENTO TOTAL---->"+carrito1.totalAPagarCarrito());
			
			
		}catch(Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
		
		
		
		//Articulo art1 = new Articulo(1,"Televisor LG 50 PULGADAS","8412584512541",45.000);
		//Articulo art2 = new Articulo(2,"Heladera LG","7791234567898",85.000);
		//Articulo art3 = new Articulo(3,"Aire acondicionado LG","8412345678905",40.000);
		//Articulo art4 = new Articulo(4,"Lavavajillas","202122",35.000);
		
		
		
		
		
		
		/*
		//System.out.println(art1);
		
		listaArticulos.add(art1);
		listaArticulos.add(art2);
		//listaArticulos3.add(art3);
		
		System.out.println(listaArticulos);
		
		listaArticulos2 = listaArticulos;
		for(int i = 0;i<listaArticulos3.size();i++) {
			listaArticulos2.add(listaArticulos3.get(i));
		}
		
		//System.out.println(listaArticulos2);
		
		
		
		List<ItemCarrito> lstItemCarrito = new ArrayList<ItemCarrito>();
		
		try {
			Comercio comercio = new Comercio(1,contacto1,"Disco",listaArticulos,listaCarrito);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
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
		
		
		//Carrito carrito1 = new Carrito(1,kevin);
		
		//System.out.println(carrito1);
		//System.out.println("Traer producto:--->"+comercio.traerArticulo(6));
		
		*/
		
	}

}
