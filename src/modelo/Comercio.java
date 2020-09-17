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
			int diaDescuento) {
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

	public void setCUIT(long cuit) {
		if (validarIdentificadorUnico(cuit)) // valida el cuit y si es verdadero se asigna
			CUIT = cuit;
		else
			CUIT = 0;
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

	// ----------------------------METODOS--------------------------------------
	// valida el cuit, segun algoritmo para validar cuit y cuil
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

	// metodo generarTurnosLibres

	public List<Turno> generarTurnosLibres(LocalDate fecha) {

		List<Turno> listaTurnos = new ArrayList<Turno>();
		LocalTime horadesde = obtenerDiaRetiro(fecha).getHoraDesde();
		LocalTime horahasta = obtenerDiaRetiro(fecha).getHoraHasta();
		int intervalo = obtenerDiaRetiro(fecha).getIntervalo();

		if (getListaCarrito().isEmpty()) {

			while (horadesde.getHour() < horahasta.getHour()) {
				listaTurnos.add(new Turno(fecha, horadesde, false));
				horadesde = horadesde.plusHours(intervalo);
			}

		}

		else {
			RetiroLocal carritoAux;
			boolean esIgual = false;

			while (horadesde.getHour() < horahasta.getHour()) {
				for (Carrito carrito : obtenerCarritosPorFecha(fecha)) {
					if (carrito.getEntrega() instanceof RetiroLocal) {
						carritoAux = (RetiroLocal) carrito.getEntrega();

						if ((horadesde.equals(carritoAux.getHoraEntrega()))) {
							esIgual = true;
						}
					}

				}

				if (!(esIgual)) {
					listaTurnos.add(new Turno(fecha, horadesde, false));
				}

				esIgual = false;
				horadesde = horadesde.plusHours(intervalo);
			}

		}

		return listaTurnos;

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

	// ----------------------------------METODO
	// TOSTRING------------------------------------------
	@Override
	public String toString() {
		return super.toString() + "\nNombre: " + getNombreComercio() + "\nCUIT: " + getCUIT();
	}

}
