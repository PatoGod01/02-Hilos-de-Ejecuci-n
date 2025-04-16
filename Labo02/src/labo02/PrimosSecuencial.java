/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labo02;

public class PrimosSecuencial {
    private int valor;
    private int[] primos;
    private int contador;

    public PrimosSecuencial(int valor) {
        this.valor = valor;
        this.primos = new int[valor]; // Tamaño máximo posible
        this.contador = 0;
    }

    public boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;
        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    public void buscarPrimos() {
        for (int i = 1; i <= valor; i++) {
            if (esPrimo(i)) {
                primos[contador++] = i;
            }
        }
    }

    public int[] getPrimos() {
        return primos;
    }

    public int getContador() {
        return contador;
    }
}