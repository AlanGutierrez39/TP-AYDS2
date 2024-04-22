package modelo;

import java.io.IOException;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		Socket socket=new Socket("localhost",1234);
        Administrador administrador = new Administrador(socket);
        administrador.iniciar();
	}

}
