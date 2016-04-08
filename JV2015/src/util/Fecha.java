package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

	private Calendar calendario;

	public Fecha(int año, int mes, int dia ) {
		calendario = new GregorianCalendar(año, mes-1, dia);
	}

	public Fecha() {
		calendario = new GregorianCalendar();
	}

	public Fecha(Fecha fecha) {
		
	}

	public int getAño() {
		return calendario.get(Calendar.YEAR);
	}

	public int getMes() {
		return calendario.get(Calendar.MONTH)+1;
	}

	public int getDia() {
		return calendario.get(Calendar.DAY_OF_MONTH);
	}

	public void setAño(int año) {
		calendario.set(Calendar.YEAR, año);
	}

	public void setMes(int mes) {
		calendario.set(Calendar.MONTH, mes);
	}

	public void setDia(int dia) {
		calendario.set(Calendar.DAY_OF_MONTH, dia);
	}
	
	@Override
	public String toString() {
		return "" + getAño() + "." + getMes() + "." + getDia();
		
	}
} // class
