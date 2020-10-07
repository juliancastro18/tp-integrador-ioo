package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Comercio extends Actor{

	// ----------------------------- ATRIBUTOS -----------------------------
	
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

	// ----------------------------- CONSTRUCTOR -----------------------------
	
	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		super(id, contacto);
		setNombreComercio(nombreComercio);
		setCUIT(cuit);
		setCostoFijo(costoFijo);
		setCostoPorKm(costoPorKm);
		setDiaDescuento(diaDescuento);
		setPorcentajeDescuentoDia(porcentajeDescuentoDia);
		setPorcentajeDescuentoEfectivo(porcentajeDescuentoEfectivo);
		this.listaDiaRetiro = new ArrayList<DiaRetiro>();
		this.listaCarrito = new ArrayList<Carrito>();
		this.listaArticulos = new ArrayList<Articulo>();
	}


	// constructor para realizar test
	public Comercio(int id, Contacto contacto, long cuit, List<Carrito> listaDeCarritos, List<DiaRetiro> listaDeRetiros) throws Exception {
		super(id, contacto);
		setCUIT(cuit);
		setListaCarrito(listaDeCarritos);
		setListaDiaRetiro(listaDeRetiros);
	}

	public Comercio(int id, Contacto contacto, long cuit) throws Exception {
		super(id, contacto);
		setCUIT(cuit); 
		setListaDiaRetiro(new ArrayList<DiaRetiro>());
		setListaCarrito(new ArrayList<Carrito>());
	}

	// Constructor para test de carrito, y articulos
	public Comercio(int id, Contacto contacto, String nombreComercio, List<Articulo> listaArticulos,
			List<Carrito> listaDeCarritos) throws Exception {
		super(id, contacto);
		setListaArticulos(listaArticulos);
		setListaCarrito(listaDeCarritos);
		setNombreComercio(nombreComercio);
	}

	// ----------------------------- GETTERS Y SETTERS -----------------------------

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
		
		else
			throw new Exception("\nError al validar CUIT. Por favor intente nuevamente...\n");
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

	public void setPorcentajeDescuentoEfectivo(int porcentajeDesccuentoEfecivo) {
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

	// ----------------------------- NUEVOS ID PARA LISTAS -----------------------------

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
	
	protected int getNuevoIdCliente() {
		int idSiguiente = 0;
		
		for(Carrito i: this.listaCarrito) {
			if(i.getCliente().getId() > idSiguiente) {
				idSiguiente = i.getCliente().getId();
			}
		}
		return idSiguiente+1;
	}

	// ----------------------------- METODOS -----------------------------

	//TOSTRING
		@Override
		public String toString() {
			return super.toString() + "\nNombre: " + getNombreComercio() + "\nCUIT: " + getCUIT();
		}
	
	//VALIDACION CUIL
	@Override
	protected boolean validarIdentificadorUnico(long iUnico) {
		String cuitCadena = String.valueOf(iUnico); // convierte el cuit a cadena
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
		
		return validacion; // devuelve el resultado
	}

	
	//OBTIENE LISTA DE CARRITOS POR FECHA
	public List<Carrito> obtenerCarritosRetiroLocal(LocalDate fecha) {
		List<Carrito> listaCarritos = new ArrayList<Carrito>();
		
		for (Carrito carrito : getListaCarrito()) {
			if(carrito.isCerrado())
			{
				if(carrito.getEntrega() instanceof RetiroLocal)
				{
					if (carrito.getEntrega().getFecha().equals(fecha))
						listaCarritos.add(carrito);
				}
			}
		}
		
		if(listaCarritos.isEmpty())
			listaCarritos = null;

		return listaCarritos;
	}

	//OBTIENE DIA RETIRO POR FECHA
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
	
	//OBTIENE DIA RETIRO POR DIA DE SEMANA
		public DiaRetiro obtenerDiaRetiro(int diaSemana) {
			DiaRetiro resultado = null;
			for (DiaRetiro dato : getListaDiaRetiro()) {
				if (dato.getDiaSemana() == diaSemana) {
					resultado = dato;
				}
			}

			return resultado;
		}
	
	
	//GENERA AGENDA	
	public List<Turno> generarAgenda(LocalDate fecha) throws Exception{
		List<Turno> agenda = new ArrayList<Turno>();
		List<Turno> turnosLibres = new ArrayList<Turno>();
		List<Turno> turnosOcupados = new ArrayList<Turno>();
		turnosLibres = generarTurnosLibres(fecha);
		turnosOcupados = generarTurnosOcupados(fecha);

		for (int i = 0; i < turnosLibres.size(); i++) { //recorre turnos libres por fecha
			agenda.add(turnosLibres.get(i));
		}
		if(!turnosOcupados.isEmpty()) {
			for(int i = 0;i<turnosOcupados.size();i++) {
				agenda.add(turnosOcupados.get(i));
			}
		}
			
		return agenda;
	}

	//OBTIENE LISTA DE TURNOS OCUPADOS
	
	/*
	 *  REUTILIZAR METODO OBTENER CARRITOS POR FECHA
	 * 
	 */
	public List<Turno> generarTurnosOcupados(LocalDate fecha) throws Exception {
		List<Turno> listaTurnosOcupados = new ArrayList<Turno>();
		RetiroLocal retiroAux;												
		
		if ( ! (obtenerCarritosRetiroLocal(fecha) == null)) {							
			
			for(Carrito carrito : obtenerCarritosRetiroLocal(fecha))
			{
				retiroAux = (RetiroLocal) carrito.getEntrega();
				listaTurnosOcupados.add(new Turno(fecha, retiroAux.getHoraEntrega(), true));
			}
			
		}
		
		else {
			throw new Exception("No hay turnos ocupados para la fecha seleccionada...\n");
		}
		
		return listaTurnosOcupados;	
	}

	//GENERAR TURNOS LIBRES
	/*este metodo devuelve una lista de turnos libres en base a la fecha especificada por
	  parametro y los horarios correspondientes a las Entregas
	  de carritos ya confirmados. Si no hay ningun carrito
	  confirmado que sea para retirar en el local el metodo genera turnos nuevos con todos 
	  los horarios del dia especificado y devuelve la lista. En caso de que ya haya carritos confirmados
	  dentro de la lista (con la misma fecha que la solicitada), se recorren para
	  ver que turnos estan ocupados y cuales no. Por cada verificacion se aumtenta
	  la hora segun el intervalo especificado en DiaRetiro para preguntar si el
	  siguiente turno esta ocupado.
	  */
	public List<Turno> generarTurnosLibres(LocalDate fecha) {

		List<Turno> listaTurnos = new ArrayList<Turno>();  				//crea una lista de turnos que sera retornada
		LocalTime horadesde = obtenerDiaRetiro(fecha).getHoraDesde();	//obtiene la hora desde del dia de retiro especificado 
		LocalTime horahasta = obtenerDiaRetiro(fecha).getHoraHasta();	//obtiene la hora hasta del dia de retiro especificado 
		int intervalo = obtenerDiaRetiro(fecha).getIntervalo();			//obtiene el intervalo (cada cuanto se generan turnos nuevos)
		
		if (obtenerCarritosRetiroLocal(fecha) == null) { 							
			while (horadesde.getHour() < horahasta.getHour()) {		//recorre desde la hora que abre el comercio hasta una hora antes que cierre (ultimo turno)
				listaTurnos.add(new Turno(fecha, horadesde, false));//crea y agrega un nuevo turno disponible a la lista
				horadesde = horadesde.plusMinutes(intervalo);			// aumenta la hora para el turno siguiente
			
			}
		}

		else {																	
			
				List<Carrito> carritos = obtenerCarritosRetiroLocal(fecha);					//se guarda la lista de los turnos ocupados				
				int indice = 0;
				RetiroLocal aux;
				boolean horarioOcupado = false;													
				
				while(horadesde.getHour() < horahasta.getHour())					//se recorren los horarios de los turnos segun el intervalo
				{
					while(indice < carritos.size() & !horarioOcupado)												//se recorre hasta que se encuentra un turno con el mismo horario, significa que el turno ya existe
					{		
						aux = (RetiroLocal) carritos.get(indice).getEntrega();
						if(horadesde.equals(aux.getHoraEntrega()))			//compara los horarios del turno existente con el horario que se desea agregar para un turno nuevo
						{
							horarioOcupado = true;											//bandera se pone en true para no crear un turno nuevo
						}
						
						indice++;
					}
					
					if(! horarioOcupado)
						listaTurnos.add(new Turno(fecha, horadesde, false));
					
					indice = 0;
					horarioOcupado = false;
					horadesde = horadesde.plusMinutes(intervalo);					//la hora desde incrementa segun el intervalo
				}	
			}

		return listaTurnos;														//devuelve la lista de turnos libres
	}

	
	//METODO PARA AGREGAR UN DIARETIRO A LA LISTA
	public boolean agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) throws Exception
	{
		if(obtenerDiaRetiro(diaSemana) == null)
		{
			getListaDiaRetiro().add(new DiaRetiro(getNuevoIdDiaRetiro(), diaSemana, horaDesde, horaHasta, intervalo));
		}
		
		else 
			throw new Exception("\nEl dia de retiro ya existe\n");
			
		return true;
	}
			
	
	// ----------------------------- ADMINISTRACION DE PRODUCTOS-ARTICULOS -----------------------------
	
	//AGREGA ARTICULO AL COMERCIO	
	public boolean agregarArticulo(String articuloNombre,String codBarras,double precio) throws Exception{
		boolean addArticulo = false;
		int id = 0;
		boolean articuloExiste = false;
		boolean finLista = false;
		int vueltas = 0;

		
		if(listaArticulos.size()>0) {
			while (articuloExiste == false && finLista == false) {
				Articulo art = listaArticulos.get(vueltas);
				if (art.equals(articuloNombre)) {
					articuloExiste = true;
				}
				vueltas++;
				
				if (vueltas == listaArticulos.size()) {
					finLista = true;
				}
				
			}
		}

		
		if(articuloExiste == true)throw new Exception( "El articulos ya existe");
		
		
		if(articuloExiste == false) {
			id=this.getNuevoIdArticulo();
			Articulo articulo = new Articulo(id,articuloNombre,codBarras,precio);
			listaArticulos.add(articulo);
			addArticulo=true;
			
		}
		return addArticulo;
	}
	

	
	
	
	
	//BUSCAR ARTICULO POR ID
	public Articulo traerArticulo(int idArticulo)throws Exception{
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
			
			if(finLista && found==false)throw new Exception("El articulo no existe");

		}
		return art;
	}
	
	//ELIMINAR ARTICULO
	public void eliminarArticulo(int idArticulo) throws Exception {
		Articulo artEliminar = traerArticulo(idArticulo);
		
		if (artEliminar == null) {
			throw new Exception("Articulo no encontrado");
		}
		
		for(Carrito carro : listaCarrito) {
			ItemCarrito itemAux = carro.getItemCarrito(artEliminar);
			if (itemAux != null) {
				throw new Exception("El articulo fue agregado a almenos un carrito, y no puede ser eliminado");
			}
		}

		listaArticulos.remove(artEliminar);
	}

	
	// ----------------------------- ADMINISTRAR CARRITOS -----------------------------

	//AGREGAR CARRITO
	public void agregarCarrito(Cliente cliente) throws Exception {
		
		if (getCarritoAbierto(cliente) != null) {
			throw new Exception("El cliente " + cliente.getNombreCompleto() + " ya tiene un carrito abierto");
		}
		
		if(cliente.getId() == -1) {
			cliente.setId(getNuevoIdCliente());
		}
		
		Carrito nuevoCarrito = new Carrito(this.getNuevoIdCarrito(), cliente);
		listaCarrito.add(nuevoCarrito);
	}
	
	
	//ELIMINAR POR ID
	public void eliminarCarrito(int idCarrito) throws Exception {
		
		Carrito carritoEliminar = getCarritoFromLista(idCarrito);
		if(!carritoEliminar.isCerrado()) {
			listaCarrito.remove(carritoEliminar);
		}else {
			throw new Exception("No se puede eliminar un carrito que ya fue cerrado");
		}
	}
	
	//ELIMINAR POR CLIENTE
	public void eliminarCarritoAbierto(Cliente cliente) throws Exception {
		Carrito carritoEliminar = getCarritoAbierto(cliente);
		if(carritoEliminar!=null) {
			listaCarrito.remove(carritoEliminar);
		}else {
			throw new Exception("El cliente " + cliente.getNombreCompleto() + " no tiene carrito abierto");
		}
	}
	
	//CONFIRMAR ENVIO
	public void confirmarCarritoEnvio(Carrito carrito, boolean esEfectivo, LocalDate fechaEntrega, LocalTime horaDesde, LocalTime horaHasta) throws Exception {
		if(carrito.isCerrado() || carrito.getLstItemCarrito().isEmpty() == true) {
			throw new Exception("El carrito está vacío o ya fue cerrado");
		}
		
		Ubicacion origen = contacto.getUbicacion();
		Ubicacion destino = carrito.getCliente().getContacto().getUbicacion();
		Entrega entrega = new Envio(carrito.getIdCarrito(), fechaEntrega, esEfectivo, horaDesde, horaHasta, origen, destino, getCostoFijo(), getCostoPorKm());
		
		carrito.setCerrado(true);
		double descuento = carrito.calcularDescuentoCarrito(diaDescuento, porcentajeDescuentoDia, porcentajeDescuentoEfectivo);
		carrito.setDescuento(descuento);
		carrito.setEntrega(entrega);
			
	}
	
	//CONFIRMAR RETIRO
	public void confirmarCarritoRetiroLocal(Carrito carrito, boolean esEfectivo, LocalDate fechaEntrega) throws Exception {
		if(carrito.isCerrado() || carrito.getLstItemCarrito().isEmpty() == true) {
			throw new Exception("El carrito está vacío o ya fue cerrado");
		}
		
		LocalTime horaEntrega = generarTurnosLibres(fechaEntrega).get(0).getHora(); //selecciono el primer turno libre, y obtengo su horario
		Entrega entrega = new RetiroLocal(carrito.getIdCarrito(), fechaEntrega, esEfectivo, horaEntrega);
		
		carrito.setCerrado(true);
		double descuento = carrito.calcularDescuentoCarrito(diaDescuento, porcentajeDescuentoDia, porcentajeDescuentoEfectivo);
		carrito.setDescuento(descuento);
		carrito.setEntrega(entrega);
			
	}
	
	//MOSTRAR POR ID
	public void mostrarCarrito(int idCarrito) throws Exception {
		Carrito carritoMostrar = getCarritoFromLista(idCarrito);
		System.out.println(carritoMostrar);
	}
	
	//BUSCAR CARRITO POR ID
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
	
		
	//BUSCA CARRITO ABIERTO POR CLIENTE
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


	// ----------------------------- FIN -----------------------------
}
