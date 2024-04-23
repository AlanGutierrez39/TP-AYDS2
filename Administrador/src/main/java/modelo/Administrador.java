/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Serializable;

import controlador.Controlador;

/**
 *
 * @author ignacio
 */
public class Administrador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 56135097522855850L;
    private transient BufferedReader entrada;
    private transient BufferedWriter salida;
    private transient SocketAdministrador nuevo;
   
   public Administrador() {
	super();
   }

    public void iniciar() {
        this.nuevo = new SocketAdministrador();
        Controlador controlador=new Controlador(this);
        controlador.ejecutar();
    }
    
    public void comienza(){
    	try{
            nuevo.envio(this, "administrador");
        }catch(Exception e){
            
        }
    
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

	public SocketAdministrador getNuevo() {
		return nuevo;
	}

	public void setNuevo(SocketAdministrador nuevo) {
		this.nuevo = nuevo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
