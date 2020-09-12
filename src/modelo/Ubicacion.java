package modelo;


public class Ubicacion {

	private double latitud;
	private double longitud;
	
	public Ubicacion(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	@Override
	public String toString() {
		return " - Ubicacion: Latitud " + latitud + " / Longitud " + longitud;
	}
	
	public double distanciaCoord(double lat, double lng) {
		double radioTierra = 6371; // en kilómetros
		double dLat = Math. toRadians ( lat - this.latitud );
		double dLng = Math. toRadians ( lng - this.longitud );
		double sindLat = Math. sin ( dLat / 2);
		double sindLng = Math. sin ( dLng / 2);
		double va1 = Math. pow ( sindLat , 2)+Math. pow ( sindLng , 2)*Math. cos (Math. toRadians ( this.latitud ))*
		Math. cos (Math. toRadians ( lat ));
		double va2 = 2 * Math. atan2 (Math. sqrt ( va1 ), Math. sqrt (1 - va1 ));
		return radioTierra * va2 ;
	}
	
	public double distanciaCoord(Ubicacion ubicacion) {
		double lat = ubicacion.getLatitud();
		double lng = ubicacion.getLongitud();
		return distanciaCoord(lat,lng);
	}
	
}
