package modelo;

import util.Fecha;

/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Persona según el modelo2.
 *  @since: prototipo2.0
 *  @source: Persona.java 
 *  @version: 2.0 - 16/03/2016 
 *  @author: ajp
 */

public class Persona {

	// Atributos	
	protected String nif;
	protected String nombre;
	protected String apellidos;
	protected Direccion domicilio;
	protected String correo;
	protected Fecha fechaNacimiento;

	// Constructores
	/**
	 * Constructor convencional.
	 * Establece el valor inicial de cada uno de los atributos.
	 * Recibe parámetros que se corresponden con los atributos menos idUsr
	 * que se genera y controla internamente.
	 */
	public Persona(String nif, String nombre, String apellidos, 
			Direccion domicilio, String correo, Fecha fechaNacimiento) {
		setNif(nif);
		setNombre(nombre);
		setApellidos(apellidos);
		setDomicilio(domicilio);
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
	}

	/**
	 * Constructor por defecto.
	 * Establece el valor inicial, por defecto, de cada uno de los atributos.
	 * Llama al constructor convencional de la propia clase.
	 */
	public Persona(){
		this("00000000A", "Nombre", "Apellido Apellido", 
				new Direccion(), "correo@correo.com", new Fecha());
	}

	/**
	 * Constructor copia.
	 * Establece el valor inicial de cada uno de los atributos a partir de
	 * los valores obtenidos de un objeto de su misma clase, recibido como parámetro.
	 * Llama al constructor convencional de la propia clase.
	 */
	public Persona(Persona usr) {
		this(usr.nif, usr.nombre, usr.apellidos, 
				usr.domicilio, usr.correo, usr.fechaNacimiento);
	}

	// Métodos de acceso.

	public String getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Direccion getDomicilio() {
		return domicilio;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setNif(String nif) {
		assert nif != null;
		assert nifValido(nif);
		this.nif = nif;
	}

	/**
	 * Comprueba la validez de un nif.
	 * @param nif.
	 * @return true si cumple.
	 */
	private boolean nifValido(String nif) {		
		assert nif.matches("^[0-9]{8}[a-zA-Z]");
		// Letra de control.
		return letraValida(nif);		
	}
	
	/**
	 * Comprueba la letra del un nif.
	 * @param nif.
	 * @return true si es correcta.
	 */
	private boolean letraValida(String nif) {
		// Algoritmo de obtención letra
		//--Pendiente--
		return true;
	}
	
	public void setNombre(String nombre) {
		assert nombre != null;
		assert nombreValido(nombre);
		this.nombre = nombre;
	}

	/**
	 * Comprueba validez del un nombre.
	 * @param nombre.
	 * @return true si cumple.
	 */
	private boolean nombreValido(String nombre) {
		return nombre.matches("^[A-Z][áéíóúa-z]+[ A-Záéíóú\\w ]*");
	}
	
	public void setApellidos(String apellidos) {
		assert apellidos != null;
		assert apellidosValidos(apellidos);
		this.apellidos = apellidos;
	}

	/**
	 * Comprueba validez de los apellidos.
	 * @param apellidos.
	 * @return true si cumple.
	 */
	private boolean apellidosValidos(String apellidos) {
		return apellidos.matches("^[A-Z][áéíóúa-z \\w]+");
	}
	
	public void setDomicilio(Direccion domicilio) {
		assert domicilio != null;
		this.domicilio = domicilio;
	}
	
	public void setFechaNacimiento(Fecha fechaNacimiento) {
		assert fechaNacimiento != null;
		assert fechaNacimientoValida(fechaNacimiento);
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Comprueba validez de una fecha de nacimiento.
	 * @param fechaNacimiento.
	 * @return true si cumple.
	 */
	private boolean fechaNacimientoValida(Fecha fechaNacimiento) {
		assert fechaNacimiento != null;
		//Semántica
		return fechaNacimientoCoherente(fechaNacimiento);
	}
	
	/**
	 * Comprueba coherencia de una fecha de nacimiento.
	 * @param fechaNacimiento.
	 * @return true si cumple.
	 */
	private boolean fechaNacimientoCoherente(Fecha fechaNacimiento) {
		// Comprueba que fechaNacimiento no es, por ejemplo, del futuro
		// --Pendiente--
		return true;
	}
	
	public void setCorreo(String correo) {
		assert correo != null;
		assert correoValido(correo);
		this.correo = correo;
	}

	/**
	 * Comprueba validez de una dirección de correo electrónico.
	 * @param correo.
	 * @return true si cumple.
	 */
	private boolean correoValido(String correo) {
		assert correo.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*"
							+ "@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
		// Semántica.
		return correoAutentico(correo);
	}
	
	/**
	 * Comprueba que una dirección de correo existe.
	 * @param correo.
	 * @return true si cumple.
	 */
	private boolean correoAutentico(String correo) {
		// Comprueba que el correo no es falso
		// --Pendiente--
		return true;
	}
	
	// Métodos redefinidos

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * del objeto de la clase Usuario  
	 */
	@Override
	public String toString() {
	
		return String.format(
				"\n nif: \t\t%s,"
				+ "\n nombre: \t%s,"
				+ "\n apellidos: \t%s,"
				+ "\n domicilio: \t%s,"
				+ "\n correo: \t%s,"
				+ "\n fechaNacimiento: \t%s,", 
				nif, nombre, apellidos, domicilio, correo, 
				fechaNacimiento);		
	}

} // class

