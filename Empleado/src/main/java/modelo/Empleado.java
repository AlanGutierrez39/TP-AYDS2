/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

import controlador.ControladorEmpleado;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;
import vista.Ventana_Operador;

/**
 *
 * @author ignacio
 */
public class Empleado {

    public Empleado(){}
    
    int puerto = 1234;
    String ip = "localhost"; // Cambia esto a la dirección IP del servidor
    
    
    public void iniciar() {
        ControladorEmpleado controladorEmpleado=new ControladorEmpleado(this);
        controladorEmpleado.ejecutar();
    }
    
    
    public void ingresa(){
        
    }
}
