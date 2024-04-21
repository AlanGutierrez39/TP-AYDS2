/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Totem;


/**
 *
 * @author ignacio
 */
public class ClienteHandler implements Runnable,Serializable{
    private static ArrayList<String> dnis=new ArrayList<String>();
    private static ArrayList<String> boxes=new ArrayList<String>();
    private static ArrayList<Socket> socketsTelevisores=new ArrayList<>();
    private static final long serialVersionUID = 4209360273818925922L;
    Socket socket;
    ObjectOutputStream oos;
    BufferedReader in;
    PrintWriter out;
    ObjectInputStream ois;
    String id;
    
    public ClienteHandler(Socket socket){
        try{
            this.socket=socket;
            this.oos=new ObjectOutputStream(socket.getOutputStream());
            this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out=new PrintWriter(socket.getOutputStream(),true);
            this.ois=new ObjectInputStream(socket.getInputStream());  
        }catch(IOException e){
            
        }
         
    }
    
    
    public void run(){
        String msgclient;
        try {
            Object obj;
            try {
                obj = ois.readObject();
                //String dni=((Totem) obj).getDni();
                //System.out.println(dni);
                System.out.println(obj);
                //dni="1";
            } catch (ClassNotFoundException ex) {
                System.out.println("pasa1");
            }
            msgclient=in.readLine();
            this.id=msgclient;
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        while (socket.isConnected()) {
            try{
                System.out.println(this.id);
                if(this.id.equals("televisor")){
                    socketsTelevisores.add(socket);
                    break;
                }
                else{
                	broadcastmessage();
                    //broadcastmessage((Totem) ois.readObject());
                    break;
                }
                  
            }catch(Exception e){
            }
        }   
    }
    
    public void broadcastmessage(){
            Totem obj;
        try {
            obj = (Totem)ois.readObject();
            //String dni=obj.getDni();
            for(int i=0;i<socketsTelevisores.size();i++){
                      Socket socket = socketsTelevisores.get(i); // Obtener el socket
                      OutputStream outputStream = socket.getOutputStream(); // Obtener el OutputStream
                      PrintWriter telout = new PrintWriter(outputStream, true); // Envolver el OutputStream en un PrintWriter
                      //System.out.println(dni);
                      //telout.println(dni); // Escribir el mensaje en el PrintWriter usando println
            }
            //System.out.println(dni);
        } catch (IOException ex) {
            Logger.getLogger(ClienteHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*public void broadcastmessage(Totem obj){
    try {
        obj = (Totem)ois.readObject();
        //String dni=obj.getDni();
        for(int i=0;i<socketsTelevisores.size();i++){
                  Socket socket = socketsTelevisores.get(i); // Obtener el socket
                  OutputStream outputStream = socket.getOutputStream(); // Obtener el OutputStream
                  PrintWriter telout = new PrintWriter(outputStream, true); // Envolver el OutputStream en un PrintWriter
                  //System.out.println(dni);
                  //telout.println(dni); // Escribir el mensaje en el PrintWriter usando println
        }
        //System.out.println(dni);
    } catch (IOException ex) {
        Logger.getLogger(ClienteHandler.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(ClienteHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
} */
    
    
    public void enviarDatosAlTelevisor(ArrayList<String> lista1, ArrayList<String> lista2,Socket socket) {
        try {
            // Construye las cadenas separadas por un delimitador
            String lista1Str = String.join(",", lista1);
            String lista2Str = String.join(",", lista2);

            // Concatena las cadenas en un solo mensaje separado por un delimitador
            String mensaje = lista1Str + "|" + lista2Str;

            // Envía el mensaje al televisor
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void closeAll(Socket socket,BufferedReader bufferedReader,BufferedWriter bufferedWriter){
        try{
            if(bufferedReader!=null)
                bufferedReader.close();
            if(bufferedWriter!=null)
                bufferedWriter.close();
            if(socket!=null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
    

