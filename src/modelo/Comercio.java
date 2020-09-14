package modelo;

public class Comercio extends Actor{
	
	private String nombreComercio;
	private long CUIT;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfecivo;
	private DiaRetiro listaDiaRetiro;
	private Carrito listaCarrito;
	
	//-------------------CONSTRUCTOR-------------------------
	//VALIDA LOS DATOS ANTES DE ASIGNARLOS
	public Comercio(Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfecivo, DiaRetiro listaDiaRetiro,
			Carrito listaCarrito) {
		super(contacto);
		setNombreComercio(nombreComercio);
		setCUIT(cuit);
		setCostoFijo(costoFijo);
		setCostoPorKm(costoPorKm);
		setDiaDescuento(diaDescuento);
		setPorcentajeDescuentoDia(porcentajeDescuentoDia);
		setPorcentajeDescuentoEfecivo(porcentajeDescuentoEfecivo);
		setListaDiaRetiro(listaDiaRetiro);
		setListaCarrito(listaCarrito);
	}
	
	
	public Comercio(Contacto contacto, long cuit)
	{
		super(contacto);
		setCUIT(cuit);
	}

	//--------------------GETTERS Y SETTERS-----------------------------
	
	protected String getNombreComercio() {
		return nombreComercio;
	}

	protected void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public long getCUIT() {
		return CUIT;
	}

	protected void setCUIT(long cuit) {
		if(validarIdentificadorUnico(cuit)) //valida el cuit y si es verdadero se asigna
			CUIT = cuit;
		else
			CUIT = 0;
	}

	protected double getCostoFijo() {
		return costoFijo;
	}

	protected void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	protected double getCostoPorKm() {
		return costoPorKm;
	}

	protected void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	protected int getDiaDescuento() {
		return diaDescuento;
	}

	protected void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	protected int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	protected void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	protected int getPorcentajeDescuentoEfecivo() {
		return porcentajeDescuentoEfecivo;
	}

	protected void setPorcentajeDescuentoEfecivo(int porcentajeDesccuentoEfecivo) {
		this.porcentajeDescuentoEfecivo = porcentajeDesccuentoEfecivo;
	}

	protected DiaRetiro getListaDiaRetiro() {
		return listaDiaRetiro;
	}

	protected void setListaDiaRetiro(DiaRetiro listaDiaRetiro) {
		this.listaDiaRetiro = listaDiaRetiro;
	}

	protected Carrito getListaCarrito() {
		return listaCarrito;
	}

	protected void setListaCarrito(Carrito listaCarrito) {
		this.listaCarrito = listaCarrito;
	}
	
	
	//----------------------------METODOS--------------------------------------
	//valida el cuit
	protected boolean validarIdentificadorUnico(long cuit)
	{
		String cuitCadena = String.valueOf(cuit); 						//convierte el cuit a cadena
		String valores = "5432765432"; 									//valores para hacer el calculo
		char[] cuitDescompuesto = cuitCadena.toCharArray(); 			//descompone el cuit numero por numero
		char[] valoresDescompuesto = valores.toCharArray(); 			//descompone los valores numero por numero
		int a, b; 														// a: almacena cada numero del cuit descompuesto, b: almacena cada numero de los valores decompuestos
		int resto = 0; 													//almacena el resto de la division del calculo
		int suma = 0; 													//almacena a suma de las multiplicaciones del calculo
		int j = 0;
		int dv, dv1 = Integer.valueOf(String.valueOf(cuitDescompuesto[10])); 	//dv: almacena el digito verificador segun el caso,
																				//dv1: almacena el digito verificador del cuit a validar
		boolean validacion = false;												//valor a retornar segun sea verificado el cuit
		
		
		for(int i = 0; i < 10; i++) //itera recorriendo los arreglos y haciendo las multiplicaciones
		{
			a = Integer.valueOf(String.valueOf(cuitDescompuesto[i])); 		//convierte el caracter en numero
			b = Integer.valueOf(String.valueOf(valoresDescompuesto[j]));	//convierte el caracter en numero
			suma += a * b;													//realiza la multiplicacion y la almacena en suma
			j++;															//el indice incrementa en 1 por cada iteracion
		}
		
		resto = suma % 11;													//guarda el resto de la division
		
		if((11 - resto) == 0)												//si es 0 entonces hace la verificacion con el digito verificador del cuit
		{
			dv = 0;
			if(dv == dv1)
				validacion = true;
		}
		
		else
		{
			if((11 - resto) == 1)											//si es 1 entonces hace la verificacion con el digito verificador del cuit
			{
				dv = 9;
				if(dv == dv1)
					validacion = true;
			}
			
			else															//realiza a verificacion con el digito verificador del cuit
			{
				if((11 - resto) == dv1)
					validacion = true;
			}
		}
			
	
		return validacion;													//devuelve el resultado
	}
	
	
	
	
	
	
	//----------------------------------METODO TOSTRING------------------------------------------
	@Override
	public String toString() {
		return super.toString() + "\nNombre: " + getNombreComercio() + 
				"\nCUIT: " + getCUIT();
	}
}






























