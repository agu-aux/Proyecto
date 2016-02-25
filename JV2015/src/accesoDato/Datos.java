package accesoDato;

import modelo.SesionUsuario;
import modelo.Usuario;

public class Datos {
	private final int MAX_USUARIOS = 10;
	private final int MAX_SESIONES = 10;
	private Usuario[] datosUsuarios;
	private SesionUsuario[] datosSesiones;
	private int sesionesRegistradas;

	public Datos() {
		datosUsuarios = new Usuario[MAX_USUARIOS];
		datosSesiones = new SesionUsuario[MAX_SESIONES];	
		sesionesRegistradas = 0;
		cargarDatosPrueba();
	}

	public int getMaxUsuarios() {
		return MAX_USUARIOS;
	}

	public int getMaxSesiones() {
		return MAX_SESIONES;
	}

	public Usuario[] getDatosUsuarios() {
		return datosUsuarios;
	}

	public SesionUsuario[] getDatosSesiones() {
		return datosSesiones;
	}

	public int getSesionesRegistradas() {
		return sesionesRegistradas;
	}
	
	/**
	 * Obtiene todos los usuarios almacenados en texto formateado.
	 */
	public String textoDatosUsuarios() {
		StringBuilder aux = new StringBuilder();
		for (Usuario u: datosUsuarios) {
			aux.append("\n" + u);
		}
		return aux.toString();
	}

	/**
	 * Volcado de todos los usuarios almacenados.
	 */
	public String volcarDatosUsuarios() {
		StringBuilder aux = new StringBuilder();
		for (Usuario u: datosUsuarios) {
			aux.append("<usr>"  
						+"<attrib>"+u.getNif()+"</attrib>"
						+"<attrib>"+u.getNombre()+"</attrib>"
						+"<attrib>"+u.getApellidos()+"</attrib>"
						+"<attrib>"+u.getIdUsr()+"</attrib>"
						+"<attrib>"+u.getDomicilio()+"</attrib>"
						+"<attrib>"+u.getCorreo()+"</attrib>"
						+"<attrib>"+u.getFechaNacimiento()+"</attrib>"
						+"<attrib>"+u.getFechaAlta()+"</attrib>"
						+"<attrib>"+u.getClaveAcceso()+"</attrib>"
						+"<attrib>"+u.getRol()+"</attrib>"
					+"</usr>");
		}
		return aux.toString();
	}

	/**
	 * Volcado de todos las sesiones almacenadas.
	 */
	public String volcarDatosSesiones() {
		StringBuilder aux = new StringBuilder();
		for (SesionUsuario s: datosSesiones) {
			aux.append("<sesion>"
					+"<usr>"  
						+"<attrib>"+s.getUsr().getNif()+"</attrib>"
						+"<attrib>"+s.getUsr().getNombre()+"</attrib>"
						+"<attrib>"+s.getUsr().getApellidos()+"</attrib>"
						+"<attrib>"+s.getUsr().getIdUsr()+"</attrib>"
						+"<attrib>"+s.getUsr().getDomicilio()+"</attrib>"
						+"<attrib>"+s.getUsr().getCorreo()+"</attrib>"
						+"<attrib>"+s.getUsr().getFechaNacimiento()+"</attrib>"
						+"<attrib>"+s.getUsr().getFechaAlta()+"</attrib>"
						+"<attrib>"+s.getUsr().getClaveAcceso()+"</attrib>"
						+"<attrib>"+s.getUsr().getRol()+"</attrib>"
					+"</usr>"
					+"<attrib>"+s.getFecha()+"</attrib>"
					+"<sesion>");
		}
		return aux.toString();
	}

	/**
	 * Genera datos de prueba válidos dentro 
	 * del almacén de datos.
	 */
	private void cargarDatosPrueba() {
		datosUsuarios[0] = new Usuario();
		datosUsuarios[0].setNif("02344550K");
		datosUsuarios[0].setNombre("Pepe"); 
		datosUsuarios[0].setApellidos("López Pérez");
		datosUsuarios[0].setDomicilio("C/Luna, 27 30132 Murcia");
		datosUsuarios[0].setCorreo("pepe@gmail.com");
		datosUsuarios[0].setFechaNacimiento("1990.11.12");
		datosUsuarios[0].setFechaAlta("2014.12.03");
		datosUsuarios[0].setClaveAcceso("miau0");
		datosUsuarios[0].setRol("usuario normal");

		for (int i = 1; i < MAX_USUARIOS; i++) {
			datosUsuarios[i] = new Usuario("0234455"+i+"K", "Pepe" + i,
					"López" + " Pérez" +i, "C/Luna, 27 30132 Murcia", 
					"pepe" + i + "@gmail.com", "1990.11.12", 
					"2014.12.03", "miau" + i, "usuario normal");
		}
	}

	public Usuario buscarUsuario(String idUsr) {
		// Buscar usuario coincidente con credencial
		for (int i = 0; i < datosUsuarios.length; i++) {
			if (datosUsuarios[i].getIdUsr().equals(idUsr.toUpperCase())) {
				return datosUsuarios[i];
			}
		}
		return null;				
	}
	
	/**
	 * Añade una nueva sesión en el almacén de datos.
	 * @param sesionUsuario a guardar.
	 */
	public void registrarSesion(SesionUsuario sesionUsuario) {
		datosSesiones[sesionesRegistradas] = sesionUsuario;
		sesionesRegistradas++;	
	}

} //class
