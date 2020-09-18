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
	private int porcentajeDescuentoEfecivo;
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
	public Comercio(Contacto contacto, List<Carrito> listaDeCarritos, List<DiaRetiro> diasRetiro) {
		super(contacto);
		setListaCarrito(listaDeCarritos);
		setListaDiaRetiro(diasRetiro);
	}

	public Comercio(Contacto contacto, List<DiaRetiro> diasRetiro) {
		super(contacto);
		setListaDiaRetiro(diasRetiro);
		setListaCarrito(new ArrayList<Carrito>());
	}

	// Constructor para test de carrito, y articulos
	public Comercio(Contacto contacto, String nombreComercio, List<Articulo> listaArticulos,
			List<Carrito> listaDeCarritos) {
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
		else
			throw new Exception("\nCuil invalido. Por favor intente nuevamente...\n");
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
		return porcentajeDescuentoEfecivo;
	}

	public void setPorcentajeDescuentoEfecivo(int porcentajeDesccuentoEfecivo) {
		this.porcentajeDescuentoEfecivo = porcentajeDesccuentoEfecivo;
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
	// valida el cuit, segun algoritmo para validar cuit y cuil
	protected boolean validarIdentificadorUnico() {
		return validarIdentificadorUnico(this.CUIT);

	}

	protected boolean validarIdentificadorUnico(long cuit) {
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


	// METODO GENERARTURNOSLIBRES
	/*
	 * este metodo devuelve una lista de turnos en base a la fecha especificada por
	 * parametro (clase DiaRetiro) y los horarios correspondientes a las Entregas
	 * (clase Entregas) de carritos ya confirmados. Si no hay ningun carrito
	 * confirmado el metodo genera turnos nuevos con todos los horarios del dia
	 * especificado y devuelve la lista. En caso de que ya haya carritos confirmados
	 * dentro de la lista (con la misma fecha que la solicitada), se recorren para
	 * ver que turnos estan ocupados y cuales no. Por cada verificacion se aumtenta
	 * la hora segun el intervalo especificado en DiaRetiro para preguntar si el
	 * siguiente turno esta ocupado.
	 */

	
	// GENERAR AGENDA

	public List<Turno> generarAgenda(LocalDate fecha) {
		List<Turno> agenda = new ArrayList<Turno>();
		
		//VAMOS A RECORRER LOS TURNOS LIBRES QUE HAY EN ESA FECHA
		for (int i = 0; i < generarTurnosLibres(fecha).size(); i++) {
			agenda.add(generarTurnosLibres(fecha).get(i));
		}
		if(!generarTurnosOcupados(fecha).isEmpty()) {
			for(int i = 0;i<generarTurnosOcupados(fecha).size();i++) {
				agenda.add(generarTurnosOcupados(fecha).getIndex(i));
			}
		}

		return agenda;
	}

	// metodo generarTurnosLibres


	public List<Turno> generarTurnosLibres(LocalDate fecha) {

		List<Turno> listaTurnos = new ArrayList<Turno>();  				//crea una lista de turnos que sera retornada
		LocalTime horadesde = obtenerDiaRetiro(fecha).getHoraDesde();	//obtiene la hora desde del dia de retiro especificado 
		LocalTime horahasta = obtenerDiaRetiro(fecha).getHoraHasta();	//obtiene la hora hasta del dia de retiro especificado 
		int intervalo = obtenerDiaRetiro(fecha).getIntervalo();			//obtiene el intervalo (cada cuanto se generan turnos nuevos)

		if (getListaCarrito().isEmpty()) { 							//pregunta si la lista esta vacia

			while (horadesde.getHour() < horahasta.getHour()) {		//recorre desde la hora que abre el comercio hasta una hora antes que cierre (ultimo turno)
				listaTurnos.add(new Turno(fecha, horadesde, false));//crea y agrega un nuevo turno disponible a la lista
				horadesde = horadesde.plusHours(intervalo);			// aumenta la hora para el turno siguiente
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
				horadesde = horadesde.plusHours(intervalo);						//suma el intervalo a la hora para la siguiente iteracion
			}

		}

		return listaTurnos;														//devuelve la lista

	}

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

	/*public void agregarCarrito(Cliente cliente, boolean esEnvio) throws Exception {
		Entrega entrega = null;

		if (clienteTieneCarritoAbierto(cliente)) {
			throw new Exception("El cliente " + cliente.getNombreCompleto() + " ya tiene un carrito abierto");
		}

		// TODO: crear entrega correspondiente

		// TODO: corregir el parametro de descuento
		Carrito nuevoCarrito = new Carrito(this.getNuevoIdCarrito(), LocalDate.now(), LocalTime.now(), false, 1234,
				cliente, entrega);
		listaCarrito.add(nuevoCarrito);
	}*/
	
	public boolean clienteTieneCarritoAbierto(Cliente cliente) {
		boolean carritoAbierto = false;
		int contador = 0;
		while (contador < listaCarrito.size() && carritoAbierto == false) {
			// si el carrito pertenece al cliente y el carrito está abierto...
			if (listaCarrito.get(contador).getCliente().equals(cliente)
					&& listaCarrito.get(contador).isCerrado() == false) {
				carritoAbierto = true;
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
