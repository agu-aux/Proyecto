/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Usuario según el modelo1.
 *  En esta versión no se han aplicado la mayoría de los estándares 
 *  de diseño OO dirigidos a conseguir un "código limpio". 
 *  La implementación es la más básica posible con el fin ilustrar 
 *  cómo se evoluciona desde un "código malo".
 *  Se pueden detectar varios defectos y antipatrones de diseño:
 *  	- Ausencia de encapsulación.
 *  	- Clase demasiado grande.
 *  	- Clase sólo de datos.
 *  	- Obsesión por los tipos primitivos.  
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
		return super.toString() + "\n" 			// Incluye identificador de objeto
				+"\n nif: \t\t" + getNif() 
				+ "\n nombre: \t" + nombre 
				+ "\n apellidos: \t" + apellidos 
				+ "\n domicilio: \t" + getDomicilio() 
				+ "\n correo: \t" + getCorreo() 
				+ "\n fechaNacimiento:" + getFechaNacimiento()
				+ "\n fechaAlta: \t" + getFechaAlta() 
				+ "\n claveAcceso: \t" + getClaveAcceso()
				+ "\n rol: \t\t" + getRol() ;
	}
	
} // class

