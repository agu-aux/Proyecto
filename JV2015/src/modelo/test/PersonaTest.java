package modelo.test;

import modelo.Correo;
import modelo.Direccion;
import modelo.Nif;
import modelo.Persona;
import util.Fecha;

public class PersonaTest {
	private Persona persona1;
	private Persona persona2;
	private Persona persona3;
	private Persona persona4;
	
	public PersonaTest() {
		persona1 = new Persona();
		persona2 = new Persona(new Nif("12345678A"), "Pepe", "López Pérez",
				new Direccion("30012", "Alta", "10", "Murcia", "España"), 
				new Correo("pepe@gmail.com"), new Fecha(2010, 4, 27));
		persona3 = new Persona(persona1);

		testSet();
		testGet();
		testConstructores();
		testToString();
	}

	public void testGet() {
		System.out.println("Pruebas de métodos get...");
		mostrar(persona1);
	}
	
	public void testSet() {
		System.out.println("Pruebas de métodos set...");
		mostrar(persona1);
		
		persona1.setNif(new Nif("12345678A"));
		persona1.setNombre("Pepe");
		persona1.setApellidos("López Pérez");
		persona1.setDomicilio(new Direccion("30012", "Alta", "10", "Murcia", "España"));
		persona1.setCorreo(new Correo("pepe@gmail.com"));
		persona1.setFechaNacimiento(new Fecha(2010, 4, 27));
		
		mostrar(persona1);

		// datos incorrectos
		persona4 = new Persona();
		
		// Falla nif
		persona4.setNif(null);
		
		// Falla nif
		persona4.setNombre(null);
		persona4.setNombre("");
		persona4.setNombre(" ");
		persona4.setNombre("p123");
		
		// Falla apellidos
		persona4.setApellidos("p123");
		
		// Falla domicilio
		persona4.setDomicilio(null);
		
		// Falla correo
		persona4.setCorreo(null);
		
		// Falla fechaNacimiento
		persona4.setFechaNacimiento(null);
	
	}

	private void mostrar(Persona persona1) {
		System.out.println("nif:  \t\t" + persona1.getNif());
		System.out.println("nombre:  \t" + persona1.getNombre());
		System.out.println("apellidos:  \t" + persona1.getApellidos());
		System.out.println("domicilio:  \t" + persona1.getDomicilio());
		System.out.println("correo:  \t" + persona1.getCorreo());
		System.out.println("fechaNacimiento:" + persona1.getFechaNacimiento());	
	}

	public void testConstructores() {
		System.out.println("Pruebas de métodos constructores...");
		mostrar(persona1);
		mostrar(persona2);
		mostrar(persona3);
		
		// datos incorrectos
		//Falla nif
		persona4 = new Persona(null, "Pepe", "López Pérez",
				new Direccion("30012", "Alta", "10", "Murcia", "España"), 
				new Correo("pepe@gmail.com"), new Fecha(2010, 4, 27));
		
		//Falla nombre
		persona4 = new Persona(new Nif("12345678A"), "", "López Pérez",
						new Direccion("30012", "Alta", "10", "Murcia", "España"), 
						new Correo("pepe@gmail.com"), new Fecha(2010, 4, 27));
		
		//Falla apellidos
		persona4 = new Persona(new Nif("12345678A"), "Pepe", "",
						new Direccion("30012", "Alta", "10", "Murcia", "España"), 
						new Correo("pepe@gmail.com"), new Fecha(2010, 4, 27));

		//Falla domicilio
		persona4 = new Persona(new Nif("12345678A"), "Pepe", "López Pérez", 
						null, new Correo("pepe@gmail.com"), new Fecha(2010, 4, 27));

		//Falla correo
		persona4 = new Persona(new Nif("12345678A"), "Pepe", "López Pérez",
						new Direccion("30012", "Alta", "10", "Murcia", "España"), 
						null, new Fecha(2010, 4, 27));

		//Falla fecha
		persona4 = new Persona(new Nif("12345678A"), "Pepe", "López Pérez",
						new Direccion("30012", "Alta", "10", "Murcia", "España"), 
						new Correo("pepe@gmail.com"), null);
	}

	public void testToString() {
		System.out.println("Pruebas de método toString...");
		mostrar(persona1);
		System.out.println(persona1);
	}

} // class
