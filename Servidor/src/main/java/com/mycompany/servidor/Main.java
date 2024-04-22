/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import servidor.Servidor;

/**
 *
 * @author ignacio
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
    Servidor servidor=new Servidor();
    servidor.run();
    }
   
    
}
