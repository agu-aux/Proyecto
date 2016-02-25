/** 
 * Proyecto: Juego de la vida.
 * Pruebas iniciales de las clases Usuario y SesionUsuario del modelo1.
 * En esta versión no se han aplicado la mayoría de los estándares 
 * de diseño OO dirigidos a conseguir un "código limpio".
 * @since: prototipo1.0
 * @source: JVPrincipal.java 
 * @version: 1.2 - 25/02/2016 
 * @author: ajp
 */

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import accesoDato.Datos;
import modelo.SesionUsuario;
import modelo.Usuario;

public class JVPrincipal {
		
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
		Datos datos = new Datos();		
		System.out.println(datos.textoDatosUsuarios());
		if (iniciarSesion(datos)) {
			arrancarSimulacion();
		}
		System.out.println("Fin del programa...");
		teclado.close();
	}

	/**
	 * Controla el acceso de usuario 
	 * y registro de la sesión correspondiente. 
	 * @param datos 
	 * @return true si la sesión de usuario es válida.
	 */
	public static boolean iniciarSesion(Datos datos) {
		boolean todoCorrecto = false;				// Control de credenciales de usuario
		Usuario usrSesion = null;					// Usuario en sesión
		int intentos = 3;							// Contandor de intentos

		do {
			// Pide credencial usuario y contraseña
			System.out.print("Introduce el idUsr: ");
			String credencialUsr = teclado.nextLine();
			credencialUsr = credencialUsr.toUpperCase();
			System.out.print("Introduce clave acceso: ");
			String clave = teclado.nextLine();

			// Busca usuario coincidente con credencial
			usrSesion = datos.buscarUsuario(credencialUsr);
			if ( usrSesion != null) {	
				// Usuario temporal para encriptar la clave introducida
				Usuario usrTmp = new Usuario();
				usrTmp.setClaveAcceso(clave);
				if (usrSesion.getClaveAcceso().equals(usrTmp.getClaveAcceso())) {
					todoCorrecto = true;
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
			SesionUsuario sesionUsr = new SesionUsuario();
			sesionUsr.setUsr(usrSesion);
			Calendar hoy = new GregorianCalendar();
			sesionUsr.setFecha(hoy.get(Calendar.YEAR) + "."
							+ hoy.get(Calendar.MONTH) + "."
							+ hoy.get(Calendar.DATE));
			datos.registrarSesion(sesionUsr);
			
			System.out.println("Sesión: " + datos.getSesionesRegistradas()
					+ '\n' + "Iniciada por: " + usrSesion.getNombre() + " "
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
	
} //class
