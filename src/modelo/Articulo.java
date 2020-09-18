package modelo;

public class Articulo {
	private int idArticulo;
	private String nombre;
	private String codBarras;
	private double precio;

	public Articulo(int id, String nombre, String codBarras, double precio) {
		super();
		this.idArticulo = id;
		this.nombre = nombre;
		setCodBarras(codBarras);
		this.precio = precio;

	}

	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public void setCodBarras(String codBarras) {
		if (validarCodBarras(codBarras)) {
			this.codBarras = codBarras;
		} else {
			this.codBarras = null;
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean equals(Articulo art) {
		return this.idArticulo == art.getIdArticulo();
	}

	@Override
	public String toString() {
		return "Producto---> id=" + idArticulo + ", nombre=" + nombre + ", codBarras=" + codBarras + ", precio="
				+ precio;
	}

	public boolean validarCodBarras(String codBarras) {
		boolean codigoValidado = false;
		int[] numPosicionesPares = new int[6];
		int[] numPosicionesImpares = new int[6];
		int sumaPar = 0, sumaImpar = 0;
		int j = 0;
		int k = 0;
		int numero = 0;
		
		char[] codBarrasDescompuesto = codBarras.toCharArray();
		for (int i = 0; i < codBarrasDescompuesto.length-1; i++) {

			if ((i % 2 )== 0 && j<6) {
					numero = Integer.valueOf(String.valueOf(codBarrasDescompuesto[i]));
					numPosicionesPares[j] = numero;
					//System.out.println(numPosicionesPares[j]);
					
					sumaPar += numPosicionesPares[j];								//PASO 1
					j++; 
					

			} else {
				numero = Integer.valueOf(String.valueOf(codBarrasDescompuesto[i]));
				numPosicionesImpares[k] = numero;
				//System.out.println("POSICIONES IMPARES:-->"+codBarrasDescompuesto[i]);
				sumaImpar += numPosicionesImpares[k];								//PASO 2
				k++;
			}
			
		}
		//System.out.println("Suma numeros en posicion par:"+sumaPar);
		//System.out.println("Suma numeros en posicion impar"+sumaImpar);
		int multiSumaImpar = sumaImpar * 3;											//PASO 3
		//System.out.println("A la suma impar la multiplicamos * 3 --->"+multiSumaImpar);
		int sumaParMasMulti = (sumaPar + multiSumaImpar);							//PASO 4								
		//System.out.println("Sumamos la suma par + la multiplicacion anterior----->"+sumaParMasMulti);
		//int sumaParMasMultiRedondeado = (int) Math.ceil(sumaParMasMulti);			//PASO  5 ----->NO HACE EL REDONDEO HACIA ARRIBA
		int sumaParMasMultiRedondeado = ((sumaParMasMulti/10)*10+10);
		//System.out.println("Redondea de la de los numeros par y la multiplicacion"+sumaParMasMultiRedondeado);
		int digitoDeControl = sumaParMasMultiRedondeado - sumaParMasMulti;
		
		//System.out.println();
		System.out.println(digitoDeControl);
		if (Integer.valueOf(String.valueOf(codBarrasDescompuesto[12])) == digitoDeControl) {
			codigoValidado = true;
		}
		
		
		return codigoValidado;

	}
}
