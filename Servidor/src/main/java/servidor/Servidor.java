/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;
import com.mycompany.televisor.Televisor;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Constantes;
import modelo.Empleado;
import modelo.Totem;
import modelo.Administrador;

/**
 *
 * @author ignacio
 */
public class Servidor extends Thread implements Serializable{
   
    ArrayList<String> dnis=new ArrayList<String>();
    ArrayList<String> personasAtendidas=new ArrayList<String>();
    ArrayList<String> boxes=new ArrayList<String>();
    private LocalDateTime tiempo = LocalDateTime.now();
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final long serialVersionUID = 4209360273818925922L;
    
    public Servidor(){
     
    }
    public void run(){
        try {
            ServerSocket server = new ServerSocket(Constantes.PUERTO);
            int vecesEmpleado =0;
            while (!server.isClosed()) {
                DatosConexion datos=new DatosConexion(server.accept());
                Object obj=datos.ois.readObject();
                System.out.println(datos.ois);
                if(obj instanceof Totem){
                    Totem totem=(Totem)obj;
                    this.dnis.add(totem.getDni());
                }
                else if(obj instanceof Televisor){
                    Televisor televisor = (Televisor) obj;
                    if (this.dnis.size()>0) {
                    	Empleado empleado = new Empleado();
                    	empleado.setDni(this.personasAtendidas.get(this.personasAtendidas.size()));
                    	empleado.setPuesto(Integer.parseInt(this.boxes.get(this.boxes.size())));
                    	datos.oos.writeObject(empleado);
						datos.oos.flush();
						System.out.println("llega2");
	                    System.out.println("datos enviados: objeto:"+obj);
	                    datos.out.println("dni");
					}
                    System.out.println("llega2");
                }else if(obj instanceof Empleado){
                    Empleado empleado = (Empleado) obj;
                    if (!this.dnis.isEmpty()) {
                    	vecesEmpleado++;
	                    for (int i = 0; i < this.dnis.size(); i++) {
							System.out.println(this.dnis.get(i));
						}
	                    if (vecesEmpleado != 1){
	                    	this.personasAtendidas.add(this.dnis.get(0));
	                    	this.dnis.remove(0);
	                    	this.boxes.add(Integer.toString(empleado.getPuesto()));
	                    	if (this.dnis.isEmpty())
	                        	vecesEmpleado = 0;
	                    }
                    }
                    else
                    	vecesEmpleado = 0;
                    empleado.setDnis(this.dnis);
                    datos.oos.writeObject(empleado);
                    datos.oos.flush();
                    System.out.println(empleado);
                    System.out.println("llega2");
                    System.out.println("datos enviados: objeto:"+obj);
                    datos.out.println("dnis");
                }else if(obj instanceof Administrador){
                	Administrador administrador = (Administrador) obj;
                	String tiempoActual = calculaTiempo();
                	administrador.setTiempo(tiempoActual);
                	administrador.setPersonasAtendidas(this.personasAtendidas.size());
                	administrador.setTiempoPromedio(calculaTiempoPromedio(this.personasAtendidas.size()));
                	System.out.println(administrador);
                	datos.oos.writeObject(administrador);
                    datos.oos.flush();
                    System.out.println("llega2");
                    System.out.println("datos enviados: objeto:"+obj);
                    datos.out.println("dnis");
                }
            } 
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	private String calculaTiempo() {
    	int horas = LocalDateTime.now().getHour() - this.tiempo.getHour();
    	int minutos = LocalDateTime.now().getMinute() - this.tiempo.getMinute();
    	int segundos = LocalDateTime.now().getSecond() - this.tiempo.getSecond();
    	String tiempoActual;
    	if (minutos < 0) {
			minutos = 60-minutos;
		}
    	if (minutos > 60) {
    		horas++;
			minutos = minutos-60;
		}
    	if (segundos < 0) {
			segundos = 60-segundos;
		}
    	if (segundos > 60) {
    		minutos++;
			segundos = segundos-60;
		}
    	if (minutos < 10 && segundos < 10) {
    		tiempoActual = horas + ":0" + minutos + ":0" + segundos;
		} else if (minutos < 10) {
			tiempoActual = horas + ":0" + minutos + ":" + segundos;
		} else if (segundos < 10) {
    		tiempoActual = horas + ":" + minutos + ":0" + segundos;
    	}else {
    		tiempoActual = horas + ":" + minutos + ":" + segundos;
		}
    	return tiempoActual;
	}
	
    private String calculaTiempoPromedio(int personas) {
    	int horas = LocalDateTime.now().getHour() - this.tiempo.getHour();
    	int minutos = LocalDateTime.now().getMinute() - this.tiempo.getMinute();
    	int segundos = LocalDateTime.now().getSecond() - this.tiempo.getSecond();
    	String tiempoActual;
    	if (personas == 0) {
			tiempoActual = "0:00:00";
		}
    	else{
    		if (minutos < 0) {
    			minutos = 60-minutos;
    		}
        	if (minutos > 60) {
        		horas++;
    			minutos = minutos-60;
    		}
        	if (segundos < 0) {
    			segundos = 60-segundos;
    		}
        	if (segundos > 60) {
        		minutos++;
    			segundos = segundos-60;
    		}
    		if (minutos < 10 && segundos < 10) {
        		tiempoActual = horas/personas + ":0" + minutos/personas + ":0" + segundos/personas;
    		} else if (minutos < 10) {
    			tiempoActual = horas/personas + ":0" + minutos/personas + ":" + segundos/personas;
    		} else if (segundos < 10) {
        		tiempoActual = horas/personas + ":" + minutos/personas + ":0" + segundos/personas;
        	}else {
        		tiempoActual = horas/personas + ":" + minutos/personas + ":" + segundos/personas;
    		}
    	}
		return tiempoActual;
	}
    public void cerrarsocket(){
    
    }
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}