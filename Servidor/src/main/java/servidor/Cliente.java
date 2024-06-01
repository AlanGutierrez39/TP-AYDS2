package servidor;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4875610979375323141L;
	private String dni;
	private String tipoCliente;
	private GregorianCalendar fechaNacimiento;
    //private boolean atendido;
    private int tiempoInicio;
    private int tiempoFin;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String dni, String tipoCliente, GregorianCalendar fechaNacimiento) {
		super();
		this.dni = dni;
		this.tipoCliente = tipoCliente;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Cliente(String dni, String tipoCliente, GregorianCalendar fechaNacimiento, int tiempoInicio,
			int tiempoFin) {
		super();
		this.dni = dni;
		this.tipoCliente = tipoCliente;
		this.fechaNacimiento = fechaNacimiento;
		this.tiempoInicio = tiempoInicio;
		this.tiempoFin = tiempoFin;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getTiempoInicio() {
		return tiempoInicio;
	}

	public void setTiempoInicio(int tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public int getTiempoFin() {
		return tiempoFin;
	}

	public void setTiempoFin(int tiempoFin) {
		this.tiempoFin = tiempoFin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", tipoCliente=" + tipoCliente + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
