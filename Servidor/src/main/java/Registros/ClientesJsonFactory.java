package Registros;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import servidor.Cliente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientesJsonFactory implements JsonFactory {
	private ArrayList<Cliente> clientes;

    public ClientesJsonFactory() {
    	clientes=new ArrayList<Cliente>();
    }

    @Override
    public void leerDesdeJson(String archivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClientesWrapper clientesWrapper = objectMapper.readValue(new File(archivo), ClientesWrapper.class);
            clientes = clientesWrapper.getClientes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @JsonIgnore
    public void guardarEnJson(String archivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(archivo);
            ClientesWrapper clientesWrapper = new ClientesWrapper();
            clientesWrapper.setClientes(clientes);
            System.out.println(clientesWrapper);
            try (Scanner s = new Scanner(System.in)) {
				System.out.println(s.next());
			}
            objectMapper.writeValue(file, clientesWrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
    
    

}

