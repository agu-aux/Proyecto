 /** 
  * Proyecto: Juego de la vida.
  * Pruebas iniciales de las clases Usuario y SesionUsuario del modelo1 
  * @since: prototipo1.0
  * @source: JVPrincipal.java 
  * @version: 1.0 - 8/12/2015 
  * @author: ajp
 */

import java.util.Scanner;

public class JVPrincipal {

	public static void main(String[] args) {	
		//Apartado 4 y 5: Pruebas
		pruebasPrevias();	
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
