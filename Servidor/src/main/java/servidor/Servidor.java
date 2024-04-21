/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class Servidor implements Serializable{
    
    ServerSocket server;
    int puerto=1234;
    ArrayList<String> dnis=new ArrayList<String>();
    ArrayList<String> boxes=new ArrayList<String>();
    private static final long serialVersionUID = 4209360273818925922L;
    
    public Servidor(ServerSocket socket){
        this.server=socket;
        for (int i = 1; i <= 10; i++) {
            boxes.add(String.valueOf(i));
        }
    }
    public void iniciar(){
        while (!server.isClosed()) {
            // Espera una nueva conexión
            
            try {
                
                Socket socket = server.accept();

                ClienteHandler clienteHandler=new ClienteHandler(socket);

                Thread thread=new Thread(clienteHandler);
                thread.start();  
                
                
            } catch (IOException e) {
                cerrarsocket();
                e.printStackTrace();
            }
        } 
    }

    
    
    public void cerrarsocket(){
        
        try{
            if(server!=null){
                server.close();
            }
        }catch(IOException e){
             
        }
    }
}