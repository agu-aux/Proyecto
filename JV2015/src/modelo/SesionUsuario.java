package modelo;
/** 
 * Proyecto: Juego de la vida.
 *  Implementa el concepto de SesionUsuario según el modelo1
 *  En esta versión no se han aplicado la mayoría de los estándares 
 *  de diseño OO dirigidos a conseguir un "código limpio". 
 *  @since: prototipo1.0
 *  @source: SesionUsuario.java 
 *  @version: 1.1 - 21/01/2016 
 *  @author: ajp
 */

public class SesionUsuario {
	
	// Atributos	
	private Usuario usr;   // Concreta la relación de composición del modelo UML
	private String fecha; 
	
	// Constructores
	
	/**
	 * Constructor convencional.
	 * Establece el valor inicial de cada uno de los atributos.
	 * Recibe parámetros que se corresponden con los atributos.
	 */
	public SesionUsuario(Usuario usr, String fecha) {
		setUsr(usr);
		setFecha(fecha);
	}
	
	/**
	 * Constructor por defecto.
	 * Establece el valor inicial, por defecto, de cada uno de los atributos.
	 * Llama al constructor convencional de la propia clase.
	 */
	public SesionUsuario(){
		this(new Usuario(), "2015.01.01");
	}

	/**
	 * Constructor copia.
	 * Establece el valor inicial de cada uno de los atributos a partir de
	 * los valores obtenidos de un objeto de su misma clase, recibido como parámetro.
	 * Llama al constructor convencional de la propia clase.
	 */
	public SesionUsuario(SesionUsuario su){
		this(new Usuario(su.usr), new String(su.fecha));
	}
	
	
	// Métodos de acceso y auxiliares.
	
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
		assert fechaValida(fecha);
		this.fecha = fecha;
	}

	private boolean fechaValida(String fecha) {
		assert fecha.matches("^[0-9]{4}[/.-][0-9]{1,2}[/.-][0-9]{1,2}$");
		// Semántica.
		return fechaSesionCoherente(fecha);
	}
	
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
