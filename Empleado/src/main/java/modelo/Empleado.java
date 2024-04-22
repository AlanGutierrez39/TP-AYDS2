/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

import controlador.ControladorEmpleado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import vista.Ventana_Operador;

/**
 *
 * @author ignacio
 */
public class Empleado implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Empleado(){}
    
    int puerto = 1234;
    String ip = "localhost"; // Cambia esto a la dirección IP del servidor
	private Socket socket;
	private ObjectOutputStream oos;
	private BufferedReader in;
	private PrintWriter out;
	private ObjectInputStream ois;
    private int puesto;
    
    public void iniciar() {
        ControladorEmpleado controladorEmpleado=new ControladorEmpleado(this);
        controladorEmpleado.ejecutar();
    }
    
    
    public void ingresa(){
    	try{
            abrirConexion(ip, puerto);
            System.out.println("Conexion establecida");
            System.out.println("Enviando datos");
            recibirDatos();
            System.out.println("esperando respuesta");
            //out.println("1");
            System.out.println("Respuesta recibida");
        }catch(Exception e){
            
        }finally{
        	cerrarConexion();
        }
    }
    
    private void abrirConexion(String ip,int puerto) throws IOException{
        this.socket=new Socket(ip,puerto);
        this.oos=new ObjectOutputStream(socket.getOutputStream());
        this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out=new PrintWriter(socket.getOutputStream(),true);
        this.ois=new ObjectInputStream(socket.getInputStream());  
    }
    private void cerrarConexion(){
        try {
            socket.close();
            oos.close();
            in.close();
            out.close();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void recibirDatos() throws IOException, ClassNotFoundException{
        //System.out.println("llega1");
        //out.println(mensaje);
        //out.flush();
        ois.readObject();
        System.out.println("llega2");
        System.out.println("datos recibidos");
    }
}
