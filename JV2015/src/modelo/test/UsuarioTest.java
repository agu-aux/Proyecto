package modelo.test;

import modelo.Contraseña;
import modelo.Correo;
import modelo.Direccion;
import modelo.Nif;
import modelo.Usuario;
import modelo.Usuario.RolUsuario;
import util.Fecha;

public class UsuarioTest {
	// Objetos para la prueba.
	private Usuario usuario1 = new Usuario();; 
	private Usuario usuario2 = new Usuario(new Nif(), "Alberto", "López Ruiz",
			new Direccion(), new Correo(), new Fecha(),
			new Fecha(), new Contraseña("Miau&1"), RolUsuario.ADMINISTRADOR);;
	private Usuario usuario3 = new Usuario(usuario2);
	
	public UsuarioTest() {
		testSet();
		//testGet();
		//testConstructores();	
		//testToString();
	}

	private void testSet() {	
		usuario1.setFechaAlta(new Fecha(2013, 10, 2));
		usuario1.setClaveAcceso(new Contraseña("Miau&1"));
		usuario1.setRol(RolUsuario.ADMINISTRADOR);

		//para regenerar iUsr
		usuario1.setNif(new Nif("99999999Y"));
	
		mostrarResultados(usuario1);
	}
	
	private void mostrarResultados(Usuario usuario) {
		System.out.println(usuario.getIdUsr());	
		System.out.println(usuario.getFechaAlta());	
		System.out.println(usuario.getClaveAcceso());	
		System.out.println(usuario.getRol());	
	}

	private void testGet() {
		mostrarResultados(usuario2);
	}

	private void testConstructores() {
		mostrarResultados(usuario1);
		mostrarResultados(usuario2);
		mostrarResultados(usuario3);
	}

	private void testToString() {
		System.out.println(usuario2);
	}
}
