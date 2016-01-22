/** 
 * Proyecto: Juego de la vida.
 * Pruebas iniciales de las clases Usuario y SesionUsuario del modelo1.
 * En esta versión no se han aplicado la mayoría de los estándares 
 * de diseño OO dirigidos a conseguir un "código limpio".
 * @since: prototipo1.0
 * @source: JVPrincipal.java 
 * @version: 1.1 - 21/01/2016 
 * @author: ajp
 */

import java.util.Date;
import java.util.Scanner;

public class JVPrincipal {

	static final int MAX_USUARIOS = 10;
	static final int MAX_SESIONES = 10;
	static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	static SesionUsuario[] datosSesiones = new SesionUsuario[MAX_USUARIOS]; 
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {	

		cargarDatosPrueba();
		//mostrarDatosUsuario();

		if (iniciarSesion() == true) {
			arrancarSimulacion();
		}
		System.out.println("Fin programa...");
		teclado.close();
	}


	private static void arrancarSimulacion() {
		System.out.println("Ejecuta JV...");
	}

	/**
	 * Controla el acceso de usuario 
	 * y registro de la sesión correspondiente. 
	 * @return true si la sesión de usuario es válida.
	 */
	private static boolean iniciarSesion() {
		boolean todoCorrecto = false;				// Control de credenciales de usuario
		Usuario usrSesion = null;					// Usuario en sesión
		int intentos = 3;							// Contandor de intentos
		int sesionesRegistradas = 0;				// Control de sesiones registradas
	
		do {
			// Pide credencial usuario y contraseña
			System.out.print("Introduce el nif: ");
			String credencialUsr = teclado.nextLine();
			System.out.print("Introduce clave acceso: ");
			String clave = teclado.nextLine();

			// Buscar usuario coincidente con credencial
			for (int i = 0; i < MAX_USUARIOS; i++) {
				if (datosUsuarios[i].getNif().equals(credencialUsr)) {
					usrSesion = datosUsuarios[i];	// Guarda referencia al usuario encontrado
					
					// comprobar contraseña
					if (usrSesion.getClaveAcceso().equals(clave)) {
						todoCorrecto = true;
						break;						//Termina for de búsqueda
					}
				}
			}
			if (todoCorrecto == false) {
				intentos--;
				System.out.println("Credenciales incorrectas...");
				System.out.println("Quedan " + intentos + " intentos... ");
			}
		}
		while (!todoCorrecto && intentos > 0);

		if (todoCorrecto) {
			// Registra sesión
			datosSesiones[sesionesRegistradas] = new SesionUsuario();
			datosSesiones[sesionesRegistradas].usr = usrSesion;
			datosSesiones[sesionesRegistradas].fecha = new Date().toString();
			sesionesRegistradas++; // Actualiza contador sesiones
			
			System.out.println("Sesión: " + sesionesRegistradas + '\n' + "Iniciada por: " + usrSesion.getNombre() + " "
					+ usrSesion.getApellidos());
			return true;
		}
		return false;
	}

	/**
	 * Muestra por consola todos los usuarios almacenados.
	 */
	private static void mostrarDatosUsuario() {
		for (Usuario usr: datosUsuarios) {
			System.out.println(usr);
		}	
	}

	/**
	 * Genera datos de prueba válidos dentro 
	 * de los almacenes de datos.
	 */
	private static void cargarDatosPrueba() {

		Usuario usr0 = new Usuario();
		usr0.setNif("03456790K");
		usr0.setNombre("Pepe");
		usr0.setApellidos("López Pérez");
		usr0.setDomicilio("C/Luna, 27 30132 Murcia");
		usr0.setCorreo("pepe@gmail.com");
		usr0.setFechaNacimiento("1990.11.12");
		usr0.setFechaAlta("2014.12.3");
		usr0.setClaveAcceso("miau");
		usr0.setRol("usuario normal");
		datosUsuarios[0] = usr0;

		Usuario usr1 = new Usuario();
		usr1.setNif("14548790K");
		usr1.setNombre("Pepe1");
		usr1.setApellidos("López Pérez");
		usr1.setDomicilio("C/Luna, 27 30132 Murcia");
		usr1.setCorreo("pepe1@gmail.com");
		usr1.setFechaNacimiento("1995.04.19");
		usr1.setFechaAlta("2015.10.03");
		usr1.setClaveAcceso("miau1");
		usr1.setRol("usuario normal");
		datosUsuarios[1] = usr1;

		for (int i = 2; i < MAX_USUARIOS; i++) {
			Usuario usr = new Usuario();
			usr.setNif(i + "4548790K");
			usr.setNombre("Pepe" + i);
			usr.setApellidos("López Pérez");
			usr.setDomicilio("C/Luna, 27 30132 Murcia");
			usr.setCorreo("pepe" + i + "@gmail.com");
			usr.setFechaNacimiento("1995.04.19");
			usr.setFechaAlta("2015.10.03");
			usr.setClaveAcceso("miau" + i);
			usr.setRol("usuario normal");
			datosUsuarios[i] = usr;
		}
	}

} //class
