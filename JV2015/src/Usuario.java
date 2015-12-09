

/** 
 * Proyecto: Juego de la vida.
 *  Implementa el concepto de Usuario según el modelo1
 *  @since: prototipo1.0
 *  @source: Usuario.java 
 *  @version: 1.0 - 8/12/2015 
 *  @author: ajp
 */

public class Usuario {
	
	// Atributos	
	public String nif;
	public String nombre;
	public String apellidos;
	public String domicilio;
	public String correo;
	public String fechaNacimiento;
	public String fechaAlta;
	public String claveAcceso;
	public String rol;

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * del objeto de la clase Usuario  
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" 			// Incluye identificador de objeto
				+"\n nif: \t\t" + nif 
				+ "\n nombre: \t" + nombre 
				+ "\n apellidos: \t" + apellidos 
				+ "\n domicilio: \t" + domicilio 
				+ "\n correo: \t" + correo 
				+ "\n fechaNacimiento:" + fechaNacimiento
				+ "\n fechaAlta: \t" + fechaAlta 
				+ "\n claveAcceso: \t" + claveAcceso
				+ "\n rol: \t\t" + rol ;
	}

} // class

