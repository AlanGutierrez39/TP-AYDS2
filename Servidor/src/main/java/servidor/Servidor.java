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
                if(obj instanceof Totem){
                    Totem totem=(Totem)obj;
                    System.out.println(totem.getDni());
                    this.dnis.add(totem.getDni());
                }
                else if(obj instanceof Televisor){
                    Televisor televisor = (Televisor) obj;
                    
                }else if(obj instanceof Empleado){
                    Empleado empleado = (Empleado) obj;
                    datos.oos.writeObject(this.dnis.get(this.dnis.size()));
                    datos.oos.flush();
                    System.out.println("llega2");
                    System.out.println("datos enviados: objeto:"+obj);
                    datos.out.println("dni");
                }
            } 
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public void cerrarsocket(){
    
    }
}