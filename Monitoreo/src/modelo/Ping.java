package modelo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Ping{
	
	public static void main(String[] args) {
        // Crear un ExecutorService con un solo hilo
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Crear una instancia de la tarea
        Monitor task = new Monitor();

        try {
            // Ejecutar la tarea y obtener un Future que representa el resultado futuro
            Future<String> future = executor.submit(task);

            // Esperar maximo 3 segundos para el resultado de la tarea
            String result = future.get(3, TimeUnit.SECONDS);
            System.out.println("Resultado de la tarea: " + result);
        } catch (TimeoutException e) {
            // La tarea excedio el tiempo limite
            System.err.println("La tarea excedió el tiempo límite.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al ejecutar la tarea: " + e.getMessage());
        }

        // Apagar el ExecutorService
        executor.shutdown();
    }
	
}
