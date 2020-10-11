package modelo;

public class Articulo {
	
	//-------------------------ATRIBUTOS-------------------------
	private int idArticulo;
	private String nombre;
	private String codBarras;
	private double precio;

	//-------------------------CONSTRUCTOR-------------------------
	public Articulo(int id, String nombre, String codBarras, double precio)throws Exception {
		super();
		this.idArticulo = id;
		this.nombre = nombre;
		setCodBarras(codBarras);
		this.precio = precio;

	}

	public Articulo() {
		super();
	}

	//-------------------------GETTERS Y SETTERS-------------------------
	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int id) {
		this.idArticulo = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras)throws Exception {
		if (validarCodBarras(codBarras)) {						
			this.codBarras = codBarras;
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getDetalle() {
		return "Art. ID: " + idArticulo + " - " + nombre + " - Precio Un.: $" + precio;
	}

	//-------------------------METODOS-------------------------
	
	public boolean equals(Articulo art) {
		return this.idArticulo == art.getIdArticulo();
	}
	
	
	public boolean equals(String nombre) {
		return this.nombre == nombre;
	}
	
	public boolean equals(int id){
		return this.idArticulo == id;
	}
	
	@Override
	public String toString() {
		return "Producto---> id: " + getIdArticulo() + ", Articulo: " + getNombre() + ", codBarras: " + getCodBarras() + ", precio: "
				+ getPrecio()+"\n";
	}

	
	/*En el siguiente metodo debemos comprobar que el digito de control (ultimo numero del codigo de barras)
	  sea IGUAL al resultado que arrojan los siguientes cuentas.....*/
	
	public boolean validarCodBarras(String codBarras) throws Exception {
		boolean codigoValidado = false;
		int[] numPosicionesPares = new int[6];
		int[] numPosicionesImpares = new int[6];
		int sumaPar = 0, sumaImpar = 0;
		int j = 0;
		int k = 0;
		int numero = 0;
		char[] codBarrasDescompuesto = codBarras.toCharArray();									// Descomponemos el codigo de barras en char
		if(codBarrasDescompuesto.length!=13)  throw new Exception("El codigo ("+codBarras+") es invalido (Exceso o falta de digitos)");
		for (int i = 0; i < codBarrasDescompuesto.length-1; i++) {	 
			if ((i % 2 )== 0 && j<6) {															//Comprobamos si la posicion es par y si es el vector tiene espacios...								
					numero = Integer.valueOf(String.valueOf(codBarrasDescompuesto[i]));			//Convertimos el dato en entero para poder guardarlo y trabajarlo
					numPosicionesPares[j] = numero;					
					sumaPar += numPosicionesPares[j];											//PASO 1 A medida que se agregan los numeros al vector vamos haciendo la respectiva suma
					j++; 
			} else {																			//Si la posicion no es par, hacemos lo mismo que en el bloque IF pero con los numeros en pos impar
				numero = Integer.valueOf(String.valueOf(codBarrasDescompuesto[i]));			
				numPosicionesImpares[k] = numero;
				sumaImpar += numPosicionesImpares[k];											//PASO 2  A medida que se agregan los numeros al vector vamos haciendo la respectiva suma
				k++;
			}
		}
		int multiSumaImpar = sumaImpar * 3;														//PASO 3	Multiplicamos por 3 la suma de los numeros en posicion impar
		int sumaParMasMulti = (sumaPar + multiSumaImpar);										//PASO 4	Al resultado del paso 3 le agregamos LA SUMA de los numeros en posicion impar..							
		int sumaParMasMultiRedondeado = ((sumaParMasMulti/10)*10+10);							//PASO  5	Al resultado del paso 4 lo redondeamos a la primer decena mayor... si el da 95 rredondeamos 100
		int digitoDeControl = sumaParMasMultiRedondeado - sumaParMasMulti;						//PASO 6 	Al resultado del paso 5 le restamos el resultado del paso 4 y obtenemos el digito de control

		if (Integer.valueOf(String.valueOf(codBarrasDescompuesto[12])) == digitoDeControl) {	// COMPROBAMOS QUE EL N° OBTENIDO DEL PASO 6 sea igual al ultimo numero del codigo de barras que se intenta ingresar
			codigoValidado = true;																
		}else {
			throw new Exception("El codigo de barras es invalido");
		}
		return codigoValidado;																	//DEVOLVEMOS BOOLEANO QUE PERMITIRA EL SETEO EN EL CONSTRUCTOR

	}	
}
