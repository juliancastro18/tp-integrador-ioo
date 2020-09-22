package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Comercio extends Actor {

	private String nombreComercio;
	private long CUIT;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private List<DiaRetiro> listaDiaRetiro;
	private List<Carrito> listaCarrito;
	private List<Articulo> listaArticulos;

	// -------------------CONSTRUCTOR-------------------------
	// VALIDA LOS DATOS ANTES DE ASIGNARLOS
	public Comercio(Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diaDescuento) throws Exception {
		super(contacto);
		setNombreComercio(nombreComercio);
		setCUIT(cuit);
		setCostoFijo(costoFijo);
		setCostoPorKm(costoPorKm);
		setDiaDescuento(diaDescuento);
	}

	// constructor para realizar test
	public Comercio(Contacto contacto, long cuit, List<Carrito> listaDeCarritos, List<DiaRetiro> diasRetiro) throws Exception {
		super(contacto);
		setCUIT(cuit);
		setListaCarrito(listaDeCarritos);
		setListaDiaRetiro(diasRetiro);
	}

	public Comercio(Contacto contacto, long cuit, List<DiaRetiro> diasRetiro) throws Exception {
		super(contacto);
		setCUIT(cuit); 
		setListaDiaRetiro(diasRetiro);
		setListaCarrito(new ArrayList<Carrito>());
	}

	// Constructor para test de carrito, y articulos
	public Comercio(Contacto contacto, String nombreComercio, List<Articulo> listaArticulos,
			List<Carrito> listaDeCarritos) throws Exception {
		super(contacto);
		setListaArticulos(listaArticulos);
		setListaCarrito(listaDeCarritos);
		setNombreComercio(nombreComercio);
	}

	// --------------------GETTERS Y SETTERS-----------------------------

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public long getCUIT() {
		return CUIT;
	}

	public void setCUIT(long cuit) throws Exception {
		if (validarIdentificadorUnico(cuit)) // valida el cuit y si es verdadero se asigna
			CUIT = cuit;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	public int getDiaDescuento() {
		return diaDescuento;
	}

	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	public int getPorcentajeDescuentoEfecivo() {
		return porcentajeDescuentoEfectivo;
	}

	public void setPorcentajeDescuentoEfecivo(int porcentajeDesccuentoEfecivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDesccuentoEfecivo;
	}

	public List<DiaRetiro> getListaDiaRetiro() {
		return listaDiaRetiro;
	}

	public void setListaDiaRetiro(List<DiaRetiro> listaDiaRetiro) {
		this.listaDiaRetiro = listaDiaRetiro;
	}

	public List<Carrito> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(List<Carrito> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}

	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

	// --- GET IDs PARA LISTAS

	protected int getNuevoIdDiaRetiro() {
		int idSiguiente = 0;
		if (listaDiaRetiro.isEmpty() == false) {
			idSiguiente = listaDiaRetiro.get(listaDiaRetiro.size() - 1).getId() + 1;
		}
		return idSiguiente;
	}

	protected int getNuevoIdArticulo() {
		int idSiguiente = 0;
		if (listaArticulos.isEmpty() == false) {
			idSiguiente = listaArticulos.get(listaArticulos.size() - 1).getIdArticulo() + 1;
		}
		return idSiguiente;
	}

	protected int getNuevoIdCarrito() {
		int idSiguiente = 0;
		if (listaCarrito.isEmpty() == false) {
			idSiguiente = listaCarrito.get(listaCarrito.size() - 1).getIdCarrito() + 1;
		}
		return idSiguiente;
	}

	// ----------------------------METODOS--------------------------------------

	protected boolean validarIdentificadorUnico(long cuit) throws Exception {
		String cuitCadena = String.valueOf(cuit); // convierte el cuit a cadena
		String valores = "5432765432"; // valores para hacer el calculo
		char[] cuitDescompuesto = cuitCadena.toCharArray(); // descompone el cuit numero por numero
		char[] valoresDescompuesto = valores.toCharArray(); // descompone los valores numero por numero
		int a, b; // a: almacena cada numero del cuit descompuesto, b: almacena cada numero de los
					// valores decompuestos
		int resto = 0; // almacena el resto de la division del calculo
		int suma = 0; // almacena a suma de las multiplicaciones del calculo
		int j = 0;
		int dv, dv1 = Integer.valueOf(String.valueOf(cuitDescompuesto[10])); // dv: almacena el digito verificador 0 o 9
																				// segun el caso
																				// dv1: almacena el digito verificador
																				// del cuit a validar
		boolean validacion = false; // valor a retornar segun sea verificado el cuit

		for (int i = 0; i < 10; i++) // itera recorriendo los arreglos y haciendo las multiplicaciones
		{
			a = Integer.valueOf(String.valueOf(cuitDescompuesto[i])); // convierte el caracter en numero
			b = Integer.valueOf(String.valueOf(valoresDescompuesto[j])); // convierte el caracter en numero
			suma += a * b; // realiza la multiplicacion y la almacena en suma
			j++; // el indice incrementa en 1 por cada iteracion
		}

		resto = suma % 11; // guarda el resto de la division

		if ((11 - resto) == 0) // si es 0 entonces hace la verificacion con el digito verificador del cuit
		{
			dv = 0;
			if (dv == dv1)
				validacion = true;
		}

		else {
			if ((11 - resto) == 1) // si es 1 entonces hace la verificacion con el digito verificador del cuit
			{
				dv = 9;
				if (dv == dv1)
					validacion = true;
			}

			else // realiza a verificacion con el digito verificador del cuit
			{
				if ((11 - resto) == dv1)
					validacion = true;
			}
		}
		
		if( ! validacion)
			throw new Exception("\nCuil invalido. Por favor intente nuevamente...\n");
		
		return validacion; // devuelve el resultado
	}

	// obtiene una lista de carritos segun la fecha especificada
	public List<Carrito> obtenerCarritosPorFecha(LocalDate fecha) {
		List<Carrito> listaCarritos = new ArrayList<Carrito>();

		for (Carrito carrito : getListaCarrito()) {
			if (carrito.getEntrega().getFecha().equals(fecha)) {
				listaCarritos.add(carrito);
			}
		}

		return listaCarritos;
	}

	// metodo para obtener un diaRetiro segun la fecha indicada
	public DiaRetiro obtenerDiaRetiro(LocalDate fecha) {
		DiaRetiro resultado = null;
		int dia = fecha.getDayOfMonth();
		for (DiaRetiro dato : getListaDiaRetiro()) {
			if (dato.getDiaSemana() == dia) {
				resultado = dato;
			}
		}

		return resultado;
	}


	
	// GENERAR AGENDA
	
	public List<Turno> generarAgenda(LocalDate fecha) {
		List<Turno> agenda = new ArrayList<Turno>();
		List<Turno> turnosLibres = new ArrayList<Turno>();
		List<Turno> turnosOcupados = new ArrayList<Turno>();
		turnosLibres = generarTurnosLibres(fecha);
		turnosOcupados = generarTurnosOcupados(fecha);
		//VAMOS A RECORRER LOS TURNOS LIBRES QUE HAY EN ESA FECHA
		for (int i = 0; i < turnosLibres.size(); i++) {
			agenda.add(turnosLibres.get(i));
		}
		if(!turnosOcupados.isEmpty()) {
			for(int i = 0;i<turnosOcupados.size();i++) {
		
				agenda.add(turnosOcupados.get(i));
			}
		}

		return agenda;
	}

	

	 public List<Turno> generarTurnosOcupados(LocalDate fecha) {
		List<Turno> listaTurnosOcupados = new ArrayList<Turno>();
		LocalTime horadesde = obtenerDiaRetiro(fecha).getHoraDesde();	
		LocalTime horahasta = obtenerDiaRetiro(fecha).getHoraHasta();	
		int intervalo = obtenerDiaRetiro(fecha).getIntervalo();
		
		RetiroLocal carritoAux;												
		boolean esIgual = false;

		if (!getListaCarrito().isEmpty()) { 							
			while (horadesde.getHour() < horahasta.getHour()) {					
				for (Carrito carrito : obtenerCarritosPorFecha(fecha)) {				
					if (carrito.getEntrega() instanceof RetiroLocal) {			
						carritoAux = (RetiroLocal) carrito.getEntrega();		

						if ((horadesde.equals(carritoAux.getHoraEntrega()))) {	
							esIgual = true;																							
						}
					}
				}
				if ((esIgual)) {												
					listaTurnosOcupados.add(new Turno(fecha, horadesde, true));
				}
				esIgual = false;												
				horadesde = horadesde.plusMinutes(intervalo);						
			}
		}
		return listaTurnosOcupados;	
	}


	// METODO GENERARTURNOSLIBRES
	/*
	 este metodo devuelve una lista de turnos en base a la fecha especificada por
	 parametro (clase DiaRetiro) y los horarios correspondientes a las Entregas
	 (clase Entregas) de carritos ya confirmados. Si no hay ningun carrito
	 confirmado el metodo genera turnos nuevos con todos los horarios del dia
	 especificado y devuelve la lista. En caso de que ya haya carritos confirmados
	 dentro de la lista (con la misma fecha que la solicitada), se recorren para
	 ver que turnos estan ocupados y cuales no. Por cada verificacion se aumtenta
	 la hora segun el intervalo especificado en DiaRetiro para preguntar si el
	 siguiente turno esta ocupado.
	 */
	
	
	
	
	
	// metodo generarTurnosLibres


	public List<Turno> generarTurnosLibres(LocalDate fecha) {

		List<Turno> listaTurnos = new ArrayList<Turno>();  				//crea una lista de turnos que sera retornada
		LocalTime horadesde = obtenerDiaRetiro(fecha).getHoraDesde();	//obtiene la hora desde del dia de retiro especificado 
		LocalTime horahasta = obtenerDiaRetiro(fecha).getHoraHasta();	//obtiene la hora hasta del dia de retiro especificado 
		int intervalo = obtenerDiaRetiro(fecha).getIntervalo();			//obtiene el intervalo (cada cuanto se generan turnos nuevos)

		if (getListaCarrito().isEmpty()) { 							//pregunta si la lista esta vacia

			while (horadesde.getHour() < horahasta.getHour()) {		//recorre desde la hora que abre el comercio hasta una hora antes que cierre (ultimo turno)
				listaTurnos.add(new Turno(fecha, horadesde, false));//crea y agrega un nuevo turno disponible a la lista
				horadesde = horadesde.plusMinutes(intervalo);			// aumenta la hora para el turno siguiente
			}

		}

		else {																	
			RetiroLocal carritoAux;												//variable auxiliar
			boolean esIgual = false;											//flag para verificar si el turno esta ocupado o libre
																				//mientras el flag permanezca en false quiere decir que no hay turnos ocupados
																				//en ese horario entonces se crea un nuevo turno

			while (horadesde.getHour() < horahasta.getHour()) {					//recorre los horarios del dia
				for (Carrito carrito : obtenerCarritosPorFecha(fecha)) {		//obtene todos los carritos confirmados segun la fecha especificada		
					if (carrito.getEntrega() instanceof RetiroLocal) {			//pregunta el tipo de entrega del carrito, si es de tipo retiroLocal entonces se tiene que checkear
						carritoAux = (RetiroLocal) carrito.getEntrega();		//se hace la conversion a la clase hija para poder acceder al horario de retiroLocal

						if ((horadesde.equals(carritoAux.getHoraEntrega()))) {	//pregunta si la hora correspone a la hora de entrega del carrito a verificar
							esIgual = true;										//si la hora es la misma significa que el turno esta ocupado y se actualiza el flag													
						}
					}

				}

				if (!(esIgual)) {												//si el flag es false se agregan turnos
					listaTurnos.add(new Turno(fecha, horadesde, false));
				}

				esIgual = false;												//resetea el flag
				horadesde = horadesde.plusMinutes(intervalo);						//suma el intervalo a la hora para la siguiente iteracion
			}

		}

		return listaTurnos;														//devuelve la lista

	}
	
	
	
	///////////////////////////////ADMINISTRACION DE PRODUCTOS-ARTICULOS////////////////////////////////////////
	
	// AGREGA PRODUCTO AL COMERCIO
	/*
	public boolean agregarProducto(String producto,String codBarras,double precio) throws Exception{
		boolean addProducto = false;
		int id = 0;
		for(Articulo art: listaArticulos) {
			String nombreProducto = art.getNombre();
			if(nombreProducto == producto)throw new Exception( "El producto ya existe");
		}
		id=this.getNuevoIdArticulo();
		Articulo articulo = new Articulo(id,producto,codBarras,precio);
		listaArticulos.add(articulo);
		addProducto=true;
		return addProducto;
	}*/
	
	
	public Articulo traerProducto(int idArticulo) {
		boolean found = false;
		boolean finLista = false;
		int vueltas = 0;
		Articulo art = null;

		// Si no se encontro y no se llego al fin de la lista ....
		while (found == false && finLista == false) {
			Articulo p = listaArticulos.get(vueltas);
			if (p.getIdArticulo() == idArticulo) {
				art = p;
				found = true;
			}
			vueltas++;
			// comprobamos si se termino la lista
			if (vueltas == listaArticulos.size()) {
				finLista = true;
			}

		}
		return art;
	}

	// ------------- ADMINISTRAR CARRITOS -------------

	public void agregarCarrito(Cliente cliente, boolean esEnvio) throws Exception {

		if (getCarritoAbierto(cliente) != null) {
			throw new Exception("El cliente " + cliente.getNombreCompleto() + " ya tiene un carrito abierto");
		}

		Carrito nuevoCarrito = new Carrito(this.getNuevoIdCarrito(), cliente);
		listaCarrito.add(nuevoCarrito);
	}
	
	public void eliminarCarrito(int idCarrito) throws Exception {
		
		Carrito carritoEliminar = getCarritoFromLista(idCarrito);
		

		//TODO: corregir el parametro de descuento
		//Carrito nuevoCarrito = new Carrito(this.getNuevoIdCarrito(), LocalDate.now(), LocalTime.now(), false, 1234, cliente, entrega);
		//listaCarrito.add(nuevoCarrito);

		if(carritoEliminar.isCerrado()) {
			listaCarrito.remove(carritoEliminar);
		}else {
			throw new Exception("No se puede eliminar un carrito que ya fue cerrado");
		}

	}
	
	public void eliminarCarritoAbierto(Cliente cliente) throws Exception {
		Carrito carritoEliminar = getCarritoAbierto(cliente);
		if(carritoEliminar!=null) {
			listaCarrito.remove(carritoEliminar);
		}else {
			throw new Exception("El cliente " + cliente.getNombreCompleto() + " no tiene carrito abierto");
		}
	}
	
	public void confirmarCarritoEnvio(Carrito carrito, boolean esEfectivo, LocalDate fechaEntrega, LocalTime horaDesde, LocalTime horaHasta) throws Exception {
		if(!carrito.isCerrado() && carrito.getLstItemCarrito().isEmpty() == false) {
			Ubicacion origen = contacto.getUbicacion();
			Ubicacion destino = carrito.getCliente().getContacto().getUbicacion();
			Entrega entrega = new Envio(carrito.getIdCarrito(), fechaEntrega, esEfectivo, horaDesde, horaHasta, origen, destino, getCostoFijo(), getCostoPorKm());
			
			carrito.setCerrado(true);
			double descuento = carrito.calcularDescuentoCarrito(diaDescuento, porcentajeDescuentoDia, porcentajeDescuentoEfectivo);
			carrito.setDescuento(descuento);
			carrito.setEntrega(entrega);
			
		}else {
			throw new Exception("El carrito está vacío o ya fue cerrado");
		}
	}
	
	public void confirmarCarritoRetiroLocal(Carrito carrito, boolean esEfectivo, LocalDate fechaEntrega) throws Exception {
		if(!carrito.isCerrado() && carrito.getLstItemCarrito().isEmpty() == false) {
			Ubicacion origen = contacto.getUbicacion();
			Ubicacion destino = carrito.getCliente().getContacto().getUbicacion();
			LocalTime horaEntrega = generarTurnosLibres(fechaEntrega).get(0).getHora(); //selecciono el primer turno libre, y obtengo su horario
			Entrega entrega = new RetiroLocal(carrito.getIdCarrito(), fechaEntrega, esEfectivo, horaEntrega);
			
			carrito.setCerrado(true);
			double descuento = carrito.calcularDescuentoCarrito(diaDescuento, porcentajeDescuentoDia, porcentajeDescuentoEfectivo);
			carrito.setDescuento(descuento);
			carrito.setEntrega(entrega);
			
		}else {
			throw new Exception("El carrito está vacío o ya fue cerrado");
		}
	}
	
	public void mostrarCarrito(int idCarrito) throws Exception {
		Carrito carritoMostrar = getCarritoFromLista(idCarrito);
		System.out.println(carritoMostrar);
	}
	
	public Carrito getCarritoFromLista(int idCarrito) throws Exception {
		boolean encontrado = false;
		int contador = 0;
		Carrito carrito = null;
		
		while( encontrado != true && contador < listaCarrito.size() ) {
			if (idCarrito == listaCarrito.get(contador).getIdCarrito()) {
				carrito = listaCarrito.get(contador);
				encontrado = true;
			}
			contador++;
		}
		if(carrito==null) {
			throw new Exception("No se encontró el carrito con id " + idCarrito);
		}
		return carrito;
	}
	
	public Carrito getCarritoAbierto(Cliente cliente) {
		Carrito carritoAbierto = null;
		int contador = 0;
		while (contador < listaCarrito.size() && carritoAbierto == null) {
			// si el carrito pertenece al cliente y el carrito está abierto...
			if (listaCarrito.get(contador).getCliente().equals(cliente)	&& listaCarrito.get(contador).isCerrado() == false) {
				carritoAbierto = listaCarrito.get(contador);
			}
			contador++;
		}

		return carritoAbierto;
	}

	// ----------------------------------METODO
	// TOSTRING------------------------------------------
	@Override
	public String toString() {
		return super.toString() + "\nNombre: " + getNombreComercio() + "\nCUIT: " + getCUIT();
	}

}
