package modelo;
/** 
 * Proyecto: Juego de la vida.
 *  Implementa el concepto de SesionUsuario según el modelo1
 *  En esta versión no se han aplicado la mayoría de los estándares 
 *  de diseño OO dirigidos a conseguir un "código limpio". 
 *  @since: prototipo1.0
 *  @source: SesionUsuario.java 
 *  @version: 1.2 - 22/02/2016 
 *  @author: ajp
 */

public class SesionUsuario {
	
	// Atributos	
	private Usuario usr;   // Concreta la relación de composición del modelo UML
	private String fecha; 
	
	// Constructores
	
	/**
	 * @param usr
	 * @param fecha
	 */
	public SesionUsuario(Usuario usr, String fecha) {
		setUsr(usr);
		setFecha(fecha);
	}
	
	public SesionUsuario(){
		this(new Usuario(), "2015.01.01");
	}

	public SesionUsuario(SesionUsuario su){
		this(new Usuario(su.usr), new String(su.fecha));
	}
	
	
	// Métodos de acceso
	
	public Usuario getUsr() {
		return usr;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setUsr(Usuario usr) {
		assert usr != null;
		this.usr = usr;
	}
	
	public void setFecha(String fecha) {
		assert fecha != null;
		assert fechaSesionValida(fecha);
		this.fecha = fecha;
	}

	/**
	 * Comprueba validez de una fecha.
	 * @param fecha.
	 * @return true si cumple.
	 */
	private boolean fechaSesionValida(String fecha) {
		assert fecha.matches("^[0-9]{4}[/.-][0-9]{1,2}[/.-][0-9]{1,2}$");
		// Semántica.
		return fechaSesionCoherente(fecha);
	}
	
	/**
	 * Comprueba coherencia de una fecha de sesión.
	 * @param fecha.
	 * @return true si cumple.
	 */
	private boolean fechaSesionCoherente(String fecha) {
		// Comprueba que fechaSesion no es, por ejemplo, del futuro
		// --Pendiente--
		return true;
	}
	
	// Métodos redefinidos
	
	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * del objeto de la clase SesionUsuario  
	 */
	@Override
	public String toString() {
		return  "\n" + usr
				+ String.format("\n fecha: \t\t%s", fecha);
	}

} // class
