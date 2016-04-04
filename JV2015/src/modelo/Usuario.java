package modelo;
/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Usuario según el modelo2.
 *  Hereda de Persona.
 *  @since: prototipo1.0
 *  @source: Usuario.java 
 *  @version: 1.2 - 24/02/2016 
 *  @author: ajp
 */

public class Usuario extends Persona{

	// Atributos	
	private String idUsr;
	private String fechaAlta;
	private String claveAcceso;
	private String rol;

	// Constructores
	/**
	 * Constructor convencional.
	 * Establece el valor inicial de cada uno de los atributos.
	 * Recibe parámetros que se corresponden con los atributos menos idUsr
	 * que se genera y controla internamente.
	 */
	public Usuario(String nif, String nombre, String apellidos, 
			String domicilio, String correo, String fechaNacimiento,
			String fechaAlta, String claveAcceso, String rol) {
		
		super(nif, nombre, apellidos, domicilio, correo, fechaNacimiento);
		idUsr = generarIdUsr();
		setFechaAlta(fechaAlta);
		setClaveAcceso(claveAcceso);
		setRol(rol);
	}

	/**
	 * Constructor por defecto.
	 * Establece el valor inicial, por defecto, de cada uno de los atributos.
	 * Llama al constructor convencional de la propia clase.
	 */
	public Usuario(){
	//	super("00000000A", "Nombre", "Apellido Apellido", 
	//			"domicilio", "correo@correo.com", "2015.01.01");
	//	idUsr = generarIdUsr();
	//	setFechaAlta(fechaAlta);
	//	setClaveAcceso(claveAcceso);
	//	setRol(rol);
		
		this("00000000A", "Nombre", "Apellido Apellido", 
				"domicilio", "correo@correo.com", "2015.01.01", 
				"2015.01.01", "claveAcceso", "rol");
	}

	/**
	 * Constructor copia.
	 * Establece el valor inicial de cada uno de los atributos a partir de
	 * los valores obtenidos de un objeto de su misma clase, recibido como parámetro.
	 * Llama al constructor convencional de la propia clase.
	 */
	public Usuario(Usuario usr) {
		this(usr.nif, usr.nombre, usr.apellidos, 
				usr.domicilio, usr.correo, usr.fechaNacimiento, 
				usr.fechaAlta, usr.claveAcceso, usr.rol);
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

	public String getIdUsr() {
		return idUsr;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public String getRol() {
		return rol;
	}

	public void setNif(String nif) {
		assert nif != null;
		assert nifValido(nif);
		this.nif = nif;
		// Detecta que no es tiempo de constructor.
		if (this.idUsr != null) {
			reGenerarIdUsr();
		}
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
	
	private void reGenerarIdUsr() {
		assert nif != null;
		assert nombre != null;
		assert apellidos != null;
		idUsr = generarIdUsr();
	}
	
	/**
	 * Genera un identificador interno de usuario.
	 */
	private String generarIdUsr() {
		StringBuilder idUsr = new StringBuilder();
		// Primera letra nombre
		idUsr.append(nombre.charAt(0)); 

		// Primera letra de los apellidos
		String[] apellidos = this.apellidos.split(" ");
		idUsr.append(apellidos[0].charAt(0));
		if (apellidos.length > 1) {
			idUsr.append(apellidos[1].charAt(0));
		}

		// Últimos dos caracteres del nif
		idUsr.append(nif.substring(nif.length()-2));	
		
		// Comprueba que no existe y varía si es necesario.
		// ¿Cuantas veces debería intentarlo?
		while (buscarUsuario(idUsr.toString()) != null) {
			variarIdUsr(idUsr);
		}
		return idUsr.toString().toUpperCase();
	}

	private Usuario buscarUsuario(String idUsr) {
		// Busca y devuelve el usuario según su idUsr
		//--Pendiente--
		return null;
	}
	
	/**
	 * Varía un identificador interno de usuario.
	 * @param idUsr.
	 */
	private void variarIdUsr(StringBuilder idUsr) {
		if (idUsr.charAt(4) == 'Z') {
			idUsr.setCharAt(4, 'A');
		}
		else {		
			// Cambia la última letra con la siguiente en el alfabeto.
			idUsr.setCharAt(4, (char) (idUsr.charAt(4) + 1));
		}
	}
	
	public void setNombre(String nombre) {
		assert nombre != null;
		assert nombreValido(nombre);
		this.nombre = nombre;
		// Detecta que no es tiempo de constructor.
		if (idUsr != null) {
			reGenerarIdUsr();
		}
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
		// Detecta que no es tiempo de constructor.
		if (this.idUsr != null) {
			reGenerarIdUsr();
		}
	}

	/**
	 * Comprueba validez de los apellidos.
	 * @param apellidos.
	 * @return true si cumple.
	 */
	private boolean apellidosValidos(String apellidos) {
		return apellidos.matches("^[A-Z][áéíóúa-z \\w]+");
	}
	
	public void setDomicilio(String domicilio) {
		assert domicilio != null;
		assert domicilioValido(domicilio);
		this.domicilio = domicilio;
	}

	/**
	 * Comprueba validez de una dirección postal.
	 * @param domicilio.
	 * @return true si cumple.
	 */
	private boolean domicilioValido(String domicilio) {
		assert domicilio.matches("[áéíóú /,\\w]+");
		// Semántica.
		return direccionAutentica(domicilio);
	}
	
	/**
	 * Comprueba que existe de una dirección postal.
	 * @param domicilio.
	 * @return true si cumple.
	 */
	private boolean direccionAutentica(String domicilio) {
		// Comprueba que la dirección no es falsa.
		//--Pendiente--
		return true;
	}
	
	public void setClaveAcceso(String claveAcceso) {
		assert claveAcceso != null;
		assert claveAccesoValida(claveAcceso);
		this.claveAcceso = encriptar(claveAcceso);
	}

	/**
	 * Comprueba complejidad de una contraseña.
	 * @param claveAcceso.
	 * @return true si cumple.
	 */
	private boolean claveAccesoValida(String claveAcceso) {
		return claveAcceso.matches("[A-ZÑa-zñ0-9%&#_-]{4,18}");
	}
	
	/**
	 * Encripta una texto utilizando algoritmo simple.
	 * @param claveAcceso - a encriptar.
	 * @return clave encriptada.
	 */
	private String encriptar(String claveAcceso) {
		StringBuilder encriptada = new StringBuilder();
		String alfabetoNormal =   "%&#_-0123456789abcdefghijklmnñopqrstuvwxyzABCEFGHIJKLMNÑOPQRSTUVWXYZ";
		String alfabetoDesplazado = "6789abcdefghijklmnñopqrstuvwxyzABCEFGHIJKLMNÑOPQRSTUVWXYZ%&#_-012345";
		for (char i = 0; i < claveAcceso.length(); i++) {
			int posicion = alfabetoNormal.indexOf(claveAcceso.charAt(i));
			encriptada.append(alfabetoDesplazado.charAt(posicion));
		}
		return encriptada.toString();
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		assert fechaNacimiento != null;
		assert fechaNacimientoValida(fechaNacimiento);
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Comprueba validez de una fecha de nacimiento.
	 * @param fechaNacimiento.
	 * @return true si cumple.
	 */
	private boolean fechaNacimientoValida(String fechaNacimiento) {
		assert fechaNacimiento.matches("^[0-9]{4}[/.-][0-9]{1,2}[/.-][0-9]{1,2}");
		//Semántica
		return fechaNacimientoCoherente(fechaNacimiento);
	}
	
	/**
	 * Comprueba coherencia de una fecha de nacimiento.
	 * @param fechaNacimiento.
	 * @return true si cumple.
	 */
	private boolean fechaNacimientoCoherente(String fechaNacimiento) {
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
	
	public void setFechaAlta(String fechaAlta) {
		assert fechaAlta != null;
		assert fechaAltaValida(fechaAlta);
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Comprueba validez de una fecha de alta.
	 * @param fechaAlta.
	 * @return true si cumple.
	 */
	private boolean fechaAltaValida(String fechaAlta) {
		assert fechaAlta.matches("^[0-9]{4}[/.-][0-9]{2}[/.-][0-9]{2}$");
		// Semántica.
		return fechaAltaCoherente(fechaAlta);
	}
	
	/**
	 * Comprueba coherencia de una fecha de alta.
	 * @param fechaAlta.
	 * @return true si cumple.
	 */
	private boolean fechaAltaCoherente(String fechaAlta) {
		// Comprueba que fechaAlta no es, por ejemplo, del futuro
		// --Pendiente--
		return true;
	}

	public void setRol(String rol) {
		assert rol != null;
		assert rolValido(rol);
		this.rol = rol;
	}

	/**
	 * Comprueba validez de un rol de usuario.
	 * @param rol.
	 * @return true si cumple.
	 */
	private boolean rolValido(String rol) {
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
				+ "\n idUsr: \t%s,"
				+ "\n domicilio: \t%s,"
				+ "\n correo: \t%s,"
				+ "\n fechaNacimiento: \t%s,"
				+ "\n fechaAlta: \t%s,"
				+ "\n claveAcceso: \t%s,"
				+ "\n rol: \t\t%s", 
				nif, nombre, apellidos, idUsr, domicilio, correo, 
				fechaNacimiento, fechaAlta, claveAcceso, rol);		
	}

} // class

