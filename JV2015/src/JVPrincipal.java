/** 
 * Proyecto: Juego de la vida.
 * Pruebas iniciales de las clases Usuario y SesionUsuario del modelo1.
 * En esta versión no se han aplicado la mayoría de los estándares 
 * de diseño OO dirigidos a conseguir un "código limpio".
 * @since: prototipo1.0
 * @source: JVPrincipal.java 
 * @version: 1.0 - 8/12/2015 
 * @author: ajp
 */

import java.util.Date;
import java.util.Scanner;

public class JVPrincipal {

	//Apartado 6:
	static final int MAX_USUARIOS = 10;
	static final int MAX_SESIONES = 10;
	static Usuario[] datosUsuarios = new Usuario[MAX_USUARIOS];
	static SesionUsuario[] datosSesiones = new SesionUsuario[MAX_USUARIOS]; 
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {	
		//Apartado 4 y 5: Pruebas
		//pruebasPrevias();

		//Apartado 7
		cargarDatosPrueba();
		//mostrarDatosUsuario();

		//Apartado 8
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
	 * Apartado 8:
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
				if (datosUsuarios[i].nif.equals(credencialUsr)) {
					usrSesion = datosUsuarios[i];	// Guarda referencia al usuario encontrado
					
					// comprobar contraseña
					if (usrSesion.claveAcceso.equals(clave)) {
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
			
			System.out.println("Sesión: " + sesionesRegistradas + '\n' + "Iniciada por: " + usrSesion.nombre + " "
					+ usrSesion.apellidos);
			return true;
		}
		return false;
	}

	/**
	 * Apartado 7:
	 * Muestra por consola todos los usuarios almacenados.
	 */
	private static void mostrarDatosUsuario() {
		for (Usuario usr: datosUsuarios) {
			System.out.println(usr);
		}	
	}

	/**
	 * Apartado 7:
	 * Genera datos de prueba válidos dentro 
	 * de los almacenes de datos.
	 */
	private static void cargarDatosPrueba() {

		Usuario usr0 = new Usuario();
		usr0.nif = "03456790K";
		usr0.nombre = "Pepe";
		usr0.apellidos = "López Pérez";
		usr0.domicilio = "C/Luna, 27 30132 Murcia";
		usr0.correo = "pepe@gmail.com";
		usr0.fechaNacimiento = "1990.11.12";
		usr0.fechaAlta = "2014.12.3";
		usr0.claveAcceso = "miau";
		usr0.rol = "usuario normal";
		datosUsuarios[0] = usr0;

		Usuario usr1 = new Usuario();
		usr1.nif = "14548790K";
		usr1.nombre = "Pepe1";
		usr1.apellidos = "López Pérez";
		usr1.domicilio = "C/Luna, 27 30132 Murcia";
		usr1.correo = "pepe1@gmail.com";
		usr1.fechaNacimiento = "1995.04.19";
		usr1.fechaAlta = "2015.10.03";
		usr1.claveAcceso = "miau1";
		usr1.rol = "usuario normal";
		datosUsuarios[1] = usr1;

		for (int i = 2; i < MAX_USUARIOS; i++) {
			Usuario usr = new Usuario();
			usr.nif = i + "4548790K";
			usr.nombre = "Pepe" + i;
			usr.apellidos = "López Pérez";
			usr.domicilio = "C/Luna, 27 30132 Murcia";
			usr.correo = "pepe" + i + "@gmail.com";
			usr.fechaNacimiento = "1995.04.19";
			usr.fechaAlta = "2015.10.03";
			usr.claveAcceso = "miau" + i;
			usr.rol = "usuario normal";
			datosUsuarios[i] = usr;
		}
	}

	/**
	 * Apartado 4 y 5: Pruebas
	 */
	private static void pruebasPrevias() {

		// Prueba de la clase Usuario

		Usuario usr1;
		//Equivalencia
		//usr1.nombre = "Luis";
		//null.nombre = "Luis";	

		//Asignación de referencias no duplica objeto
		Usuario usr2 = new Usuario();
		usr1 = usr2;

		usr2.nif = "23456790K";
		usr2.nombre = "Pepe";
		usr2.apellidos = "López Pérez";
		usr2.domicilio = "C/Luna, 27 30132 Murcia";
		usr2.correo = "pepe@gmail.com";
		usr2.fechaNacimiento = "1990.11.12";
		usr2.fechaAlta = "2014.12.3";
		usr2.claveAcceso = "miau";
		usr2.rol = "usuario normal";

		//Modifica también usr2, son el mismo objeto
		usr1.nombre = "Luis";
		System.out.println("usr1: " + usr1.nombre);
		System.out.println("usr2: " + usr2.nombre);

		//Así si duplica
		Usuario usr4 = new Usuario();
		usr4 .nif = usr2.nif;
		usr4.nombre = usr2.nombre;
		usr4.apellidos = usr2.apellidos;
		usr4.domicilio =  usr2.domicilio;
		usr4.correo = usr2.correo;
		usr4.fechaNacimiento = usr2.fechaNacimiento;
		usr4.fechaAlta = usr2.fechaAlta;
		usr4.fechaAlta = usr2.fechaAlta;
		usr4.rol = usr2.rol;

		// Son diferentes objetos
		usr4.nombre = "Pedro";
		System.out.println(usr2.nombre);

		// Desde teclado
		Scanner teclado = new Scanner(System.in);
		Usuario usr3 = new Usuario();
		System.out.println("Entrada de datos de usuario... ");
		System.out.print("nif: ");	
		usr3.nif = teclado.next();
		System.out.print("nombre: ");	
		usr3.nombre = teclado.next();
		System.out.print("apellidos: ");
		usr3.apellidos = teclado.next();
		System.out.print("domicilio: ");
		usr3.domicilio =  teclado.next();
		System.out.print("correo: ");
		usr3.correo = teclado.next();
		System.out.print("fechaNacimiento: ");
		usr3.fechaNacimiento = teclado.next();
		System.out.print("fechaAlta: ");
		usr3.fechaAlta = teclado.next();
		System.out.print("claveAcceso: ");
		usr3.claveAcceso = teclado.next();
		System.out.print("rol: ");
		usr3.rol = "NORMAL";

		// Si toString() de Usuario no está redefinido...
		System.out.println(usr1); 		// Muestra identificador único de objeto
		System.out.println(usr2);
		System.out.println(usr3);
		System.out.println(usr4);

		// Prueba de la clase SesionUsuario

		SesionUsuario sesion1 = new SesionUsuario();
		sesion1.usr = usr2;
		sesion1.fecha = "2014.12.3";

		System.out.println(sesion1);	
	}

} //class
