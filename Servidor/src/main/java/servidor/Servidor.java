/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import modelo.Administrador;
import modelo.Empleado;
import modelo.Televisor;
import modelo.Totem;
import patronStateServidor.IState;
import patronStateServidor.PrimarioState;
import patronStateServidor.SecundarioState;

/**
 *
 * @author ignacio
 */
public class Servidor extends Thread implements Serializable{
    private static final long serialVersionUID = 4209360273818925922L;
    private ColasManager manager;
    private PrintWriter out;
    private ServerSocket serverSocket;
    private int puerto;
    private IState estado = new SecundarioState(this);
    
    public Servidor() throws IOException{
    	this.manager = ColasManager.getInstancia();
    	try {
    		this.setPuerto(5555);
			this.serverSocket = new ServerSocket(this.puerto);
			this.estado = new PrimarioState(this);
			System.out.println("Servidor TCP iniciado. Esperando conexiones…");
		} catch (IOException e) {
			this.setPuerto(7777);
			this.serverSocket = new ServerSocket(this.puerto);
			this.estado = new SecundarioState(this);
			System.out.println("Servidor TCP secundario iniciado. Esperando conexiones…");
		}
    }
    
    public Servidor(ColasManager manager) throws IOException{
    	this.manager = manager;
    	try {
    		this.setPuerto(5555);
			this.serverSocket = new ServerSocket(this.puerto);
			this.estado = new PrimarioState(this);
			System.out.println("Servidor TCP iniciado. Esperando conexiones…");
		} catch (IOException e) {
			this.setPuerto(7777);
			this.serverSocket = new ServerSocket(this.puerto);
			this.estado = new SecundarioState(this);
			System.out.println("Servidor TCP secundario iniciado. Esperando conexiones…");
		}
    }
    
    /*public Servidor(String ip, int puerto) throws IOException {
    	this.manager = ColasManager.getInstancia();
    	this.serverSocket = new ServerSocket(puerto);
    	switch (puerto) {
		case 5555:
	    	System.out.println("Servidor TCP iniciado. Esperando conexiones…");
			break;
		case 7777:
			System.out.println("Servidor TCP secundario iniciado. Esperando conexiones…");
			break;
		default:
			System.out.println("Puerto incorrecto.");
			break;
		}
    	
    }*/
    //para test
    /*public Servidor(String mensaje) {
    	try {
			this.serverSocket = new ServerSocket(5555);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Servidor ALTER TCP iniciado. Esperando conexiones...");
    }*/
    
    public void startServer() {
    	System.out.println("Puerto: " + this.getServerSocket().getLocalPort() + "\nServidor: " + this.getEstado());
    	try {
			while(true) {
				Socket clientSocket = this.serverSocket.accept();
				Thread thread = new Thread(new ClientHandler(clientSocket,manager, "localhost", this.getServerSocket().getLocalPort()));
				System.out.println(thread);
				thread.start();
				/*try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private ColasManager manager;
        private String ip;
        private int puerto;

        public ClientHandler(Socket clientSocket,ColasManager manager, String ip, int puerto) {
            this.clientSocket = clientSocket;
            this.manager = manager;
            this.ip = ip;
            this.puerto = puerto;
        }

        @Override
        public void run() {
            try { 
                DatosConexion datos = new DatosConexion(this.clientSocket);
                
                //ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                Object obj = datos.ois.readObject();
                if(obj instanceof Totem){
                	System.out.println("entra totem");
                    Totem totem=(Totem)obj;
                    System.out.println("dni que entra: " + totem.getDni());
                    manager.newCliente(totem.getDni());
                    System.out.println("documentos: " + manager.getDnis().toString());
                    
                    mandar_int("agregar index dnis",manager.obtener_index_dnis(), ip, puerto); //manager.obtener_index_dnis()
                    //mandar_objeto("agregar dnis",manager.obtener_dnis().getLast());
                }else if(obj instanceof Televisor){
                	System.out.println("entra televisor");
                	System.out.println("datos: " + datos);
                    manager.creaTele(datos);
                    //zona de pruebas
                    mandar_objeto("televisor",manager.obtener_teles(), ip, puerto);
                    //mandar_objeto("televisor",manager.obtener_teles().getLast());
                }else if(obj instanceof Empleado){
                	System.out.println("entra empleado");
                    Empleado empleado = (Empleado) obj;
                    String msg=datos.in.readLine();
                    if(msg.equalsIgnoreCase("nuevo")) {
                    	manager.newBox(datos);
                    	//boxes.add(indexBox,String.valueOf(indexBox));
            	    	//indexBox++;
                    	mandar_int("agregar index box",manager.obtener_index_box(), ip, puerto);
                    	mandar_objeto("nuevo boxes",manager.obtener_boxes(), ip, puerto);
                    }else {
                    	manager.llamaCliente(String.valueOf(empleado.getPuesto()));
                    	//atendidos.add(dnis.get(0));
                		//dnis.remove(0);
                    	mandar_objeto("agregar dnis",manager.obtener_dnis(), ip, puerto);
                    	mandar_objeto("agregar atendidos",manager.obtener_atendidos(), ip, puerto);
                    }
                }else if(obj instanceof Administrador){
                	System.out.println("entra administrador");
                	this.manager.nuevoAdministrador(datos);
                }
                else if (obj==null){
                	System.out.println("entra ping al servidor");
                	MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
                	MemoryUsage cantMemoriaUsada = mbean.getHeapMemoryUsage();
                	datos.out.flush();
                	datos.out.println(cantMemoriaUsada.toString());
                	datos.out.flush();
                }
            } catch (IOException e) {
                System.err.println("Error al manejar la conexión con el cliente: " + e.getMessage());
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    public static void mandar_int(String mensaje,int numero_enviar, String ip, int puerto) {
		try {
			Socket socket = new Socket(ip, puerto);
			//inicializo
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
	        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	        dos.flush();
			dos.writeUTF(mensaje);
			dos.flush();
			System.out.println("se mando el mensaje");
			dos.flush();
	        dos.writeInt(numero_enviar);
	        dos.flush();
	        System.out.println("se mando el integer");
	        socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void mandar_objeto(String mensaje,Object objeto, String ip, int puerto) {
		try {
			Socket socket = new Socket(ip, puerto);
			//inicializo
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
	        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			dos.flush();
			dos.writeUTF(mensaje);
			dos.flush();
			System.out.println("se mando el mensaje");
			oos.flush();
			System.out.println(objeto);
	        oos.writeObject(objeto);
	        oos.flush();
	        System.out.println("se mando el objeto");
	        socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void cerrarsocket(){
    
    }
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public IState getEstado() {
		return estado;
	}

	public void setEstado(IState estado) {
		this.estado = estado;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	
}