/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.televisor;

import java.io.IOException;
import java.net.Socket;


/**
 *
 * @author ignacio
 */
public class Main {
     public static void main(String[] args) throws IOException {
         
        Socket socket=new Socket("localhost",1234);
        Televisor televisor = new Televisor(socket);
        televisor.iniciar();
     }
}
