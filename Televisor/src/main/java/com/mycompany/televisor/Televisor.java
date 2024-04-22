/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.televisor;

import controlador.ControladorTelevisor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author ignacio
 */
public class Televisor {

   ArrayList<String> dnis=new ArrayList<String>();
   Socket socket;
   BufferedReader entrada;
   BufferedWriter salida;
   private ObjectOutputStream oos;
   private ObjectInputStream ois;
   
   public Televisor(Socket socket){
        try{
            this.socket=socket;
            this.salida=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.oos=new ObjectOutputStream(socket.getOutputStream());
            this.ois=new ObjectInputStream(socket.getInputStream());
        }catch(IOException e){
            
        }
    
    }

    public void iniciar() {
        ControladorTelevisor controladorTelevisor=new ControladorTelevisor(this);
        controladorTelevisor.ejecutar();
    }
    
    
    public void comienza(){
        try{
            this.salida.write("televisor" + "\n"); // Agrega un salto de línea al final del mensaje
            this.salida.flush(); // Asegúrate de que el mensaje se envíe inmediatamente
            this.oos.writeObject(this);
            this.oos.flush();
        }catch(Exception e){
            
        }
        
    }
}
