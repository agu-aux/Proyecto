/** 
 * Proyecto: Juego de la vida.
 *  Implementa el concepto de SesionUsuario según el modelo1
 *  En esta versión no se han aplicado la mayoría de los estándares 
 *  de diseño OO dirigidos a conseguir un "código limpio". 
 *  La implementación es la más básica posible con el fin ilustrar 
 *  cómo se evoluciona desde un "código malo".
 *  Se pueden detectar varios defectos y antipatrones de diseño:
 *  	- Ausencia de encapsulación.
 *  	- Clase sólo de datos.
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
	
	
	// Métodos de acceso
	
	public Usuario getUsr() {
		return usr;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	// Métodos redefinidos
	
	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * del objeto de la clase SesionUsuario  
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" 			// Incluye identificador de objeto
				+ "\n" + getUsr()
				+ "\n fecha:" + getFecha();
	}

} // class
