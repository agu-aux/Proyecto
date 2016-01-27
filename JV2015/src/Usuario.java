/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Usuario según el modelo1.
 *  En esta versión no se han aplicado la mayoría de los estándares 
 *  de diseño OO dirigidos a conseguir un "código limpio". 
 *  La implementación es la más básica posible con el fin ilustrar 
 *  cómo se evoluciona desde un "código con defectos".
 *  Se pueden detectar varios defectos y antipatrones de diseño:
 *  	- Clase demasiado grande.
 *  	- Abuso por los tipos primitivos.  
 *  @since: prototipo1.0
 *  @source: Usuario.java 
 *  @version: 1.1 - 21/01/2016 
 *  @author: ajp
 */

public class Usuario {
	
	// Atributos	
	
	private String nif;
	private String nombre;
	private String apellidos;
	private String domicilio;
	private String correo;
	private String fechaNacimiento;
	private String fechaAlta;
	private String claveAcceso;
	private String rol;

	// Constructores
	/**
	 * Constructor convencional.
	 * Establece el valor inicial de cada uno de los atributos.
	 * Recibe parámetros que se corresponden con los atributos.
	 * @param nif
	 * @param nombre
	 * @param apellidos
	 * @param domicilio
	 * @param correo
	 * @param fechaNacimiento
	 * @param fechaAlta
	 * @param claveAcceso
	 * @param rol
	 */
	public Usuario(String nif, String nombre, String apellidos, 
			String domicilio, String correo, String fechaNacimiento,
			String fechaAlta, String claveAcceso, String rol) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAlta = fechaAlta;
		this.claveAcceso = claveAcceso;
		this.rol = rol;
	}
	
	/**
	 * Constructor por defecto.
	 * Establece el valor inicial, por defecto, de cada uno de los atributos.
	 * Llama al constructor convencional de la propia clase.
	 */
	public Usuario(){
		this("nif", "nombre", "apellidos", 
				"domicilio", "correo", "fechaNacimiento", 
				"fechaAlta", "claveAcceso", "rol");
	}
	
	/**
	 * Constructor copia.
	 * Establece el valor inicial de cada uno de los atributos a partir de
	 * los valores obtenidos de un objeto de su misma clase.
	 * Llama al constructor convencional.
	 * @param u - el Usuario a clonar
	 */
	public Usuario(Usuario usr) {
		this(usr.nif, usr.nombre, usr.apellidos, 
				usr.domicilio, usr.correo, usr.fechaNacimiento, 
				usr.fechaAlta, usr.claveAcceso, usr.rol);
	}
	
	// Métodos de acceso

	public String getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
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
		this.nif = nif;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	// Métodos redefinidos
	
	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * del objeto de la clase Usuario  
	 */
	@Override
	public String toString() {
		return "\n nif: \t\t" + nif 
				+ "\n nombre: \t" + nombre 
				+ "\n apellidos: \t" + apellidos 
				+ "\n domicilio: \t" + domicilio 
				+ "\n correo: \t" + correo 
				+ "\n fechaNacimiento:" + fechaNacimiento
				+ "\n fechaAlta: \t" + fechaAlta 
				+ "\n claveAcceso: \t" + claveAcceso
				+ "\n rol: \t\t" + rol;
	}
	
} // class

