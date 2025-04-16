package labo02;

public class PrimosParalelos extends Thread {
    private int inicio;
    private int fin;
    private int[] primos;
    private int contador;
    private String nombre;

    public PrimosParalelos(int inicio, int fin, String nombre) {
        this.inicio = inicio;
        this.fin = fin;
        this.nombre = nombre;
        this.primos = new int[fin - inicio + 1];
        this.contador = 0;
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;
        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println("Inicio de búsqueda: " + nombre);
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                primos[contador++] = i;
            }
        }
        System.out.println("Fin de búsqueda: " + nombre + " - Encontrados: " + contador);
    }

    public int[] getPrimos() {
        return primos;
    }

    public int getContador() {
        return contador;
    }
}