/** 
 * Proyecto: Juego de la vida.
 *  jv2014.ajp
 *  Clase-utilidades de validación de formatos utilizando regex.
 *  @since: prototipo1.2
 *  @source: Formato.java 
 *  @version: 1.1.2 - 23/02/2015
 *  @author: ajp
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formato {

	private static final String PATRON_URL = "^http://[\\w]+(\\.[\\w-]+)*/([\\w-])*/([\\w-]+)*(\\.[\\w]{1,})";
	private static final String PATRON_URL2 = "^(https?://)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\w\\.-/]+)?/?$";
	private static final String PATRON_URL3 = "^(ht|f)tp(s?)://[0-9a-zA-Z]([-\\.\\w]*[0-9a-zA-Z])*(?:(0-9)*)*(?)([a-zA-Z0-9-\\.?,/+&%\\$#_]*)?$";
	private static final String PATRON_ID_YOOTUBE = "^http://(?:youtu\\.be/|(?:[a-z]{2,3}\\.)?youtube\\.com/watch(?:\\?|#\\!)v=)([\\w-]{11}).*/gi";

	private static final String PATRON_CORREO = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$";

	private static final String PATRON_USUARIO = "^[a-z\\d_]{4,15}$";
	private static final String PATRON_CONTRASEÑA = "[A-ZÑa-zñ0-9%&#_-]{6,18}";
	private static final String PATRON_CONTRASEÑA2 = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
	private static final String PATRON_CONTRASEÑA3 = "((?=.{0,}[A-ZÑ])(?=.{0,}[a-zñ])(?=.{1,}\\d)(?=.{1,}[$*-+&!?%])).{8,16}";
	private static final String PATRON_CONTRASEÑA4 = "^(?=[^\\d_].*?\\d)\\w(\\w|[!@#$%]){7,20}";

	private static final String PATRON_TELEFONO = "^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$";

	private static final String PATRON_TARJETA = "^((67\\d{2})|(4\\d{3})|(5[1-5]\\d{2})|(6011))(-?\\s?\\d{4}){3}|(3[4,7])\\d{2}-?\\s?\\d{6}-?\\s?\\d{5}$";

	private static final String PATRON_IP = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
	private static final String PATRON_IP2 = "^(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
	private static final String PATRON_IP3 = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))";

	private static final String PATRON_NIF = "^[0-9]{8}[a-zA-Z]";
	private static final String PATRON_FECHA = "^[0-9]{4}[/.-][0-9]{1,2}[/.-][0-9]{1,2}";
	private static final String PATRON_CP = "^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$";

	/**
	 * Verifica que un nif tiene un formato válido.
	 * @param nif - a validar.
	 * @return - true si es correcto.
	 */
	public static boolean nifValido(String nif) {

		return Pattern.compile(PATRON_NIF).matcher(nif).matches();
	}

	/**
	 * Verifica que la dirección de correo tiene un formato válido.
	 * @param correo - a validar.
	 * @return - true si es correcto.
	 */
	public static boolean correoValido(String correo) {

		return Pattern.compile(PATRON_CORREO).matcher(correo).matches();
	}

	
	/**
	 * Verifica que una contraseña sea robusta:
	 * al menos una minúscula.
	 * Al menos una mayúscula.
	 * Al menos un número.
	 * Al menos un caracter especial.
	 * Mínimo 8 caracteres.
	 * @param contraseña - a validar.
	 * @return - true si es correcta.
	 */
	public static boolean contraseñaRobusta(String contraseña) {

		return Pattern.compile(PATRON_CONTRASEÑA3).matcher(contraseña).matches();
	}

	/**
	 * Verifica que un codigo postal tiene un formato válido.
	 * @param cp - a validar.
	 * @return - true si es correcto.
	 */
	public static boolean cpValido(String cp) {

		return Pattern.compile(PATRON_CP).matcher(cp).matches();
	}
	
	/**
	 * Verifica que una fecha tiene un formato válido.
	 * @param fecha - a validar.
	 * @return - true si es correcto.
	 */
	public static boolean fechaValida(String fecha) {

		return Pattern.compile(PATRON_FECHA).matcher(fecha).matches();
	}
}