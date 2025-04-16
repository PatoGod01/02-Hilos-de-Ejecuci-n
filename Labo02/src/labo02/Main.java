
/**
 *
 * @author JoseS
 */
package labo02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese el valor máximo (N) para buscar primos: ");
        int valor = leer.nextInt();
        
        // Versión secuencial
        System.out.println("\n--- BÚSQUEDA SECUENCIAL ---");
        PrimosSecuencial ps = new PrimosSecuencial(valor);
        long inicio = System.currentTimeMillis();
        ps.buscarPrimos();
        long fin = System.currentTimeMillis();
        
        System.out.println("Primos encontrados (secuencial):");
        imprimirPrimos(ps.getPrimos(), ps.getContador());
        System.out.println("Tiempo secuencial: " + (fin - inicio) + " ms");
        
        // Versión paralela
        System.out.println("\n--- BÚSQUEDA PARALELA ---");
        System.out.println("¿Cuántos hilos desea usar? ");
        int hilos = leer.nextInt();
        
        PrimosParalelos[] tareas = new PrimosParalelos[hilos];
        int rango = valor / hilos;
        
        // Crear tareas
        for (int k = 0; k < hilos; k++) {
            int inicioRango = k * rango + 1;
            int finRango = (k == hilos - 1) ? valor : (k + 1) * rango;
            String nombre = "Hilo-" + (k + 1);
            tareas[k] = new PrimosParalelos(inicioRango, finRango, nombre);
        }
        
        inicio = System.currentTimeMillis();
        // Iniciar hilos
        for (int k = 0; k < hilos; k++) {
            tareas[k].start();
        }
        
        // Esperar a que terminen todos los hilos
        try {
            for (int k = 0; k < hilos; k++) {
                tareas[k].join();
            }
        } catch (InterruptedException ex) {
            System.err.println("Error en los hilos: " + ex.getMessage());
        }
        fin = System.currentTimeMillis();
        
        // Combinar resultados
        System.out.println("\nPrimos encontrados (paralelo):");
        int totalPrimos = 0;
        for (int k = 0; k < hilos; k++) {
            totalPrimos += tareas[k].getContador();
        }
        
        int[] todosPrimos = new int[totalPrimos];
        int indice = 0;
        for (int k = 0; k < hilos; k++) {
            int[] primosHilo = tareas[k].getPrimos();
            int contadorHilo = tareas[k].getContador();
            System.arraycopy(primosHilo, 0, todosPrimos, indice, contadorHilo);
            indice += contadorHilo;
        }
        
        imprimirPrimos(todosPrimos, totalPrimos);
        System.out.println("Tiempo paralelo: " + (fin - inicio) + " ms");
    }
    
    private static void imprimirPrimos(int[] primos, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print(primos[i] + " ");
        }
        System.out.println("\nTotal: " + cantidad + " números primos");
    }
}