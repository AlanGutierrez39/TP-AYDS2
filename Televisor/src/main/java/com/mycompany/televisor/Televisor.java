/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.televisor;

import controlador.ControladorTelevisor;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author ignacio
 */
public class Televisor implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = -8432622592732844803L;
	private ArrayList<String> dnis=new ArrayList<String>();
   private transient BufferedReader entrada;
   private transient BufferedWriter salida;
   private transient SocketTelevisor nuevo;

   public Televisor() {
	super();
   }

   public Televisor(SocketTelevisor nuevo){
        this.nuevo = nuevo;
    
    }

    public void iniciar() {
        this.nuevo = new SocketTelevisor();
        ControladorTelevisor controladorTelevisor=new ControladorTelevisor(this);
        controladorTelevisor.ejecutar();
    }
    
    public void comienza(){
    	nuevo.envio(this, "Televisor");
    }
    
	public ArrayList<String> getDnis() {
		return dnis;
	}

	public void setDnis(ArrayList<String> dnis) {
		this.dnis = dnis;
	}

	public BufferedReader getEntrada() {
		return entrada;
	}

	public void setEntrada(BufferedReader entrada) {
		this.entrada = entrada;
	}

	public BufferedWriter getSalida() {
		return salida;
	}

	public void setSalida(BufferedWriter salida) {
		this.salida = salida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SocketTelevisor getNuevo() {
		return nuevo;
	}

	public void setNuevo(SocketTelevisor nuevo) {
		this.nuevo = nuevo;
	}
	
}
