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
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author ignacio
 */
public class Televisor {

   ArrayList<String> dnis=new ArrayList<String>();
   public Televisor(Socket socket){
        try{
            this.socket=socket;
            this.salida=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch(IOException e){
            
        }
    
    }
    
    
    Socket socket;
    BufferedReader entrada;
    BufferedWriter salida;
    
    public void iniciar() {
        ControladorTelevisor controladorTelevisor=new ControladorTelevisor(this);
        controladorTelevisor.ejecutar();
    }
    
    
    public void comienza(){
        try{
            this.salida.write("televisor" + "\n"); // Agrega un salto de línea al final del mensaje
            this.salida.flush(); // Asegúrate de que el mensaje se envíe inmediatamente
            
        }catch(Exception e){
            
        }
        
    }
}
