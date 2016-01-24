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
	static SesionUsuario[] datosSesiones = new SesionUsuario[MAX_SESIONES];
	
	static Scanner teclado = new Scanner(System.in);	//Entrada por consola

	// En este array los 0 indican celdas con célula muerta y los 1 vivas
	static byte[][] mundo = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0 }, //
			{ 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, // 
			{ 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, // Given:
			{ 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 1x Planeador
			{ 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 1x Flip-Flop
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }  // 1x Still Life
	};

	static final int TAMAÑO = 12;
	static final int CICLOS = 120;

	public static void main(String[] args) {	
		cargarDatosPrueba();		
		//mostrarTodosDatosUsuarios();

		if (iniciarSesion()) {
			arrancarSimulacion();
		}

		System.out.println("Fin del programa...");
		teclado.close();
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
			datosSesiones[sesionesRegistradas].setUsr(usrSesion);
			datosSesiones[sesionesRegistradas].setFecha(new Date().toString());
			sesionesRegistradas++; // Actualiza contador sesiones
			
			System.out.println("Sesión: " + sesionesRegistradas + '\n' + "Iniciada por: " + usrSesion.getNombre() + " "
					+ usrSesion.getApellidos());
			return true;
		}
		return false;
	}

	/**
	 * Ejecuta una simulación del juego de la vida en la consola.
	 * Utiliza la configuración por defecto.
	 */
	static void arrancarSimulacion() {
		int gen = 0; 		//Generaciones

		do {
			System.out.println("\nGeneración: " + gen);
			mostrarMundo();
			mundo = actualizarMundo();
			gen++;
		}
		while (gen <= CICLOS);
	}

	/**
	 * Despliega en la consola el estado almacenado correspondiente
	 * a una generación del Juego de la vida.
	 */
	private static void mostrarMundo() {

		for (int i = 0; i < TAMAÑO; i++) {
			for (int j = 0; j < TAMAÑO; j++) {
				System.out.print((mundo[i][j] == 1) ? "|o" : "| ");
			}
			System.out.println("|");
		}
	}

	/**
	 * Actualiza el estado almacenado del Juego de la Vida.
	 * @return nuevoEstado, el array con los cambios de la siguiente generación.
	 */
	private static byte[][] actualizarMundo()  {     					

		byte[][] nuevoEstado = new byte[TAMAÑO][TAMAÑO];

		for (int i = 0; i < TAMAÑO; i++) {

			for (int j = 0; j <= 11; j++) {

				int vecinas = 0;						//células adyacentes

				// las celdas situadas fuera del mundo, con índices fuera de rango, hay que controlarlas

				if (i-1 >= 0)	
					vecinas += mundo[i-1][j];			//celda N			NO | N | NE
														//					-----------
				if (i-1 >= 0 && j+1 < TAMAÑO)			// 					 O |   | E
					vecinas += mundo[i-1][j+1];			//celda NE			----------- 
														//					SO | S | SE
				if (j+1 < TAMAÑO)
					vecinas += mundo[i][j+1];			//celda E			 

				if (i+1 < TAMAÑO && j+1 < TAMAÑO)
					vecinas += mundo[i+1][j+1];			//celda SE          

				if (i+1 < TAMAÑO)
					vecinas += mundo[i+1][j]; 			//celda S           

				if (i+1 < TAMAÑO && j-1 >= 0)
					vecinas += mundo[i+1][j-1]; 		//celda SO 

				if (j-1 >= 0)
					vecinas += mundo[i][j-1];			//celda O           			                                     	

				if (i-1 >= 0 && j-1 >= 0)
					vecinas += mundo[i-1][j-1]; 		//celda NO

				if (vecinas < 2) 
					nuevoEstado[i][j] = 0; 				// subpoblación, muere

				if (vecinas > 3) 
					nuevoEstado[i][j] = 0; 				// sobrepoblación, muere

				if (vecinas == 3) 
					nuevoEstado[i][j] = 1; 				// pasa a estar viva o se mantiene

				if (vecinas == 2 && mundo[i][j] == 1) 						
					nuevoEstado[i][j] = 1; 				// se mantiene viva
			}
		}
		return nuevoEstado;
	}

	/**
	 * Muestra por consola todos los usuarios almacenados.
	 */
	private static void mostrarTodosDatosUsuarios() {

		for (Usuario u: datosUsuarios) {
			System.out.println("\n" + u);
		}
	}

	/**
	 * Genera datos de prueba válidos dentro 
	 * del almacén de datos.
	 */
	private static void cargarDatosPrueba() {
		datosUsuarios[0] = new Usuario();
		datosUsuarios[0].setNif("2344556K");
		datosUsuarios[0].setNombre("Pepe"); 
		datosUsuarios[0].setApellidos("López Pérez");
		datosUsuarios[0].setDomicilio("C/Luna, 27 30132 Murcia");
		datosUsuarios[0].setCorreo("pepe@gmail.com");
		datosUsuarios[0].setFechaNacimiento("1990.11.12");
		datosUsuarios[0].setFechaAlta("2014.12.3");
		datosUsuarios[0].setClaveAcceso("miau");
		datosUsuarios[0].setRol("usuario normal");

		for (int i = 1; i < MAX_USUARIOS; i++) {
			datosUsuarios[i] = new Usuario();
			datosUsuarios[i].setNif(i + "344556K");
			datosUsuarios[i].setNombre("Pepe" + i); 
			datosUsuarios[i].setApellidos("López" + " Pérez" +i);
			datosUsuarios[i].setDomicilio("C/Luna, 27 30132 Murcia");
			datosUsuarios[i].setCorreo("pepe" + i + "@gmail.com");
			datosUsuarios[i].setFechaNacimiento("1990.11.12");
			datosUsuarios[i].setFechaAlta("2014.12.3");
			datosUsuarios[i].setClaveAcceso("miau" + i);
			datosUsuarios[i].setRol("usuario normal");
		}
	}
	
} //class
