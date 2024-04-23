/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

import controlador.ControladorEmpleado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class Empleado implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2179221794384146037L;

	public Empleado(){}
    
    private transient BufferedReader entrada;
    private transient BufferedWriter salida;
    private transient SocketEmpleado nuevo;
    private int puesto;
    private String dni;
    private ArrayList<String> dnis=new ArrayList<String>();
    
    public void iniciar() {
        nuevo = new SocketEmpleado();
        ControladorEmpleado controladorEmpleado=new ControladorEmpleado(this);
        controladorEmpleado.ejecutar();
    }
    
    public void ingresa(){
    	try{
            nuevo.envio(this, "empleado");
            this.dnis = nuevo.recepcion(this, "empleado");
        }catch(Exception e){
            
        }
    }
    
	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	public BufferedReader getEntrada() {
		return entrada;
	}


	public void setEntrada(BufferedReader entrada) {
		this.entrada = entrada;
	}


	public BufferedWriter getSalida() {
		return salida;
	}


	public void setSalida(BufferedWriter salida) {
		this.salida = salida;
	}


	public SocketEmpleado getNuevo() {
		return nuevo;
	}


	public void setNuevo(SocketEmpleado nuevo) {
		this.nuevo = nuevo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Empleado [puesto=" + puesto + ", dnis=" + dnis + "]";
	}

	public ArrayList<String> getDnis() {
		return dnis;
	}

	public void setDnis(ArrayList<String> dnis) {
		this.dnis = dnis;
	}
    
}
