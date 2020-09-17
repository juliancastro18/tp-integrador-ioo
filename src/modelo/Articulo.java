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
		this.codBarras = codBarras;
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

	public void setCodBarras(String codBarras) throws Exception{
		if(validarCodBarras(codBarras)) {
			this.codBarras = codBarras;
		}
		throw new Exception("El codigo de barras no es valido");
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
		int[] cadenaOriginal = new int[13];
		int[] numPosicionesPares = new int[6];
		int[] numPosicionesImpares = new int[6];
		int sumaPar = 0,sumaImpar=0;
		for (int i = 0; i < cadenaOriginal.length-1; i++) {
			//asignamos a la cadena El string del codigo de barras
			cadenaOriginal[i] = Integer.parseInt(codBarras.substring(i, i + 1));
			
			if ((i % 2) == 0) {
				numPosicionesPares[i] = cadenaOriginal[i];
				//paso 1
				sumaPar+=numPosicionesPares[i];
			} else {
				numPosicionesImpares[i] = cadenaOriginal[i];
				//paso2
				sumaImpar+=numPosicionesImpares[i];
			}
		}
		//paso 3
		int multiSumaImpar= sumaImpar * 3;
		//paso 4
		int sumaParMasMulti = (sumaPar + multiSumaImpar);
		//paso 5
		int sumaParMasMultiRedondeado = (int) Math.ceil(sumaParMasMulti);	
		int digitoDeControl = sumaParMasMultiRedondeado-sumaParMasMulti;
		if(cadenaOriginal[13] == digitoDeControl) {
			codigoValidado = true;
		}
		return codigoValidado;
		
		
		

	}

}
