package persistencia;

import java.util.GregorianCalendar;

import servidor.Cliente;

public class CargaDatos {

	public static void main(String[] args) 
	{
		Cliente cliente1 = new Cliente("36001684", "Default", new GregorianCalendar(1992, 5, 10));
		Cliente cliente2 = new Cliente("31179333", "Gold", new GregorianCalendar(1984, 8, 30));
		Cliente cliente3 = new Cliente("40731757", "Select", new GregorianCalendar(1997, 3, 26));
	}

}
