/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;
import com.mycompany.televisor.Televisor;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Constantes;
import modelo.Empleado;
import modelo.Totem;
//import modelo.Administrador;

/**
 *
 * @author ignacio
 */
public class Servidor extends Thread implements Serializable{
   
    ArrayList<String> dnis=new ArrayList<String>();
    ArrayList<String> boxes=new ArrayList<String>();
    private static final long serialVersionUID = 4209360273818925922L;
    
    public Servidor(){
     
    }
    public void run(){
        try {
            ServerSocket server = new ServerSocket(Constantes.PUERTO);
           
            while (!server.isClosed()) {
                DatosConexion datos=new DatosConexion(server.accept());
                Object obj=datos.ois.readObject();
                System.out.println(datos.ois);
                if(obj instanceof Totem){
                    Totem totem=(Totem)obj;
                    this.dnis.add(totem.getDni());
                    /*for (int i = 0; i < this.dnis.size(); i++) {
						System.out.println(this.dnis.get(i));
					}*/
                }
                else if(obj instanceof Televisor){
                    Televisor televisor = (Televisor) obj;
                    if (this.dnis.size()>0) {
						datos.oos.writeObject(this.dnis.get(this.dnis.size()));
						datos.oos.flush();
						System.out.println("llega2");
	                    System.out.println("datos enviados: objeto:"+obj);
	                    datos.out.println("dni");
					}
                    System.out.println("llega2");
                }else if(obj instanceof Empleado){
                    Empleado empleado = (Empleado) obj;
                    datos.oos.writeObject(this.dnis);
                    datos.oos.flush();
                    System.out.println("llega2");
                    System.out.println("datos enviados: objeto:"+obj);
                    datos.out.println("dni");
                }/*else if(obj instanceof Administrador){
                	Administrador administrador = (Administrador) obj;
                }*/
                /*else if(obj instanceof Televisor){
                    Televisor televisor = (Televisor) obj;
                    datos.oos.writeObject(this.dnis.get(0));
                    datos.oos.flush();
                    System.out.println("llega2");
                    System.out.println("datos enviados: objeto:"+obj);
                    datos.out.println("dni");
                }else if(obj instanceof Empleado){
                    Empleado empleado = (Empleado) obj;
                    //empleado.setPuesto(1);
                    empleado.setDni(this.dnis.get(0));
                    System.out.println(empleado);
                    this.dnis.remove(0);
                    datos.oos.writeObject(empleado);
                    datos.oos.flush();
                    System.out.println("llega2");
                    System.out.println("datos enviados: objeto:"+empleado);
                    datos.out.println("dni");
                }*/
            } 
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public void cerrarsocket(){
    
    }
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}