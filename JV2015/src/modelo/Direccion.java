package modelo;

public class Direccion {
	private String codigoPostal;
	private String via;
	private String numero;
	private String poblacion;
	private String pais;
	
	public Direccion(String codigoPostal, String via, String numero, 
						String poblacion, String pais) {
		setCodigoPostal(codigoPostal);
		setVia(via);
		setNumero(numero);
		setPoblacion(poblacion);
		setPais(pais);
	}

	public Direccion() {
		this("30000", "Via", "10", "Murcia", "España");
	}
	
	public Direccion(Direccion direccion) {
		this(direccion.codigoPostal, direccion.via, direccion.numero, 
				direccion.poblacion, direccion.pais);
	}
	
	public void setCodigoPostal(String codigoPostal) {
		assert codigoPostal != null;
		assert codigoPostalValido(codigoPostal);
		this.codigoPostal = codigoPostal;
	}

	/**
	 * Comprueba validez de un código Postal.
	 * @param codigoPostal.
	 * @return true si cumple.
	 */
	private boolean codigoPostalValido(String codigoPostal) {
		assert codigoPostal.matches("^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$");
		// Semántica.
		return codigoPostalAutentico(codigoPostal);
	}
	
	/**
	 * Comprueba que existe el código postal.
	 * @param codigoPostal.
	 * @return true si cumple.
	 */
	private boolean codigoPostalAutentico(String codigoPostal) {
		// Comprueba que el codigo postal no es falso. 
		//--Pendiente--
		return true;
	}

	public void setVia(String via) {
		assert via != null;
		assert viaValida(via);
		this.via = via;	
	}

	/**
	 * Comprueba validez de la vía pública.
	 * @param via.
	 * @return true si cumple.
	 */
	private boolean viaValida(String via) {
		assert via.matches("[\\w áéíóú]+");
		// Semántica.
		return viaAutentica(via);
	}
	
	/**
	 * Comprueba que existe la vía pública.
	 * @param via.
	 * @return true si cumple.
	 */
	private boolean viaAutentica(String via) {
		// Comprueba que la via no es falsa.
		//--Pendiente--
		return true;
	}
	
	public void setNumero(String numero) {
		assert numero != null;
		assert numeroValido(numero);
		this.numero = numero;
	}
	
	/**
	 * Comprueba validez de la vía pública.
	 * @param via.
	 * @return true si cumple.
	 */
	private boolean numeroValido(String numero) {
		return numero.matches("[\\d]+");
	}
	
	public void setPoblacion(String poblacion) {
		assert poblacion != null;
		assert poblacionValida(poblacion);
		this.poblacion = poblacion;
	}

	/**
	 * Comprueba validez de la poblacion.
	 * @param poblacion.
	 * @return true si cumple.
	 */
	private boolean poblacionValida(String poblacion) {
		assert poblacion.matches("[\\w áéíóú]+");
		// Semántica.
		return poblacionAutentica(poblacion);
	}
	
	/**
	 * Comprueba que existe la población.
	 * @param poblacion.
	 * @return true si cumple.
	 */
	private boolean poblacionAutentica(String poblacion) {
		// Comprueba que la población no es falsa.
		//--Pendiente--
		return true;
	}
	
	public void setPais(String pais) {
		assert pais != null;
		assert paisValido(pais);
		this.pais = pais;
	}

	/**
	 * Comprueba validez del pais.
	 * @param pais.
	 * @return true si cumple.
	 */
	private boolean paisValido(String pais) {
		assert pais.matches("[\\w áéíóú]+");
		// Semántica.
		return paisAutentico(pais);
	}
	
	/**
	 * Comprueba que existe el pais.
	 * @param pais.
	 * @return true si cumple.
	 */
	private boolean paisAutentico(String pais) {
		// Comprueba que el pais no es falso.
		//--Pendiente--
		return true;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @return the via
	 */
	public String getVia() {
		return via;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	@Override
	public String toString() {
		return codigoPostal + ", " + via + ", " + numero
				+ ", " + poblacion + ", " + pais;
	}
	
} // class
