/** 
 * Proyecto: Juego de la vida.
 *  Implementa el concepto de SesionUsuario según el modelo1
 *  @since: prototipo1.0
 *  @source: SesionUsuario.java 
 *  @version: 1.0 - 8/12/2015 
 *  @author: ajp
 */

public class SesionUsuario {
	
	// Atributos	
	public Usuario usr;   // Concreta la relación de composición del modelo UML
	public String fecha; 
	
	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * del objeto de la clase SesionUsuario  
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" 			// Incluye identificador de objeto
				+ "\n" + usr  					// usr.toString()
				+ "\n fecha:" + fecha;
	}
} // class
