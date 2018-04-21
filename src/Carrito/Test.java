/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrito;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ubaldo Pánuco Sandoval
 * Oscar Eduardo Ceballos Pérez
 * Carrito de compras
 * Simulación de compras en un supermercado 
 * utilizando hilos
 * 20/04/2018
 */
public class Test {
    public static void main(String LoQueSea[]) {
        //Elegir una cantidad entre 1 y 50
        int nClientes=6;
        ArrayList<Cliente> listaOriginal = Cliente.generarClientes(nClientes);

        ArrayList<Cliente> lis = new ArrayList();
        ArrayList<Cliente> lis2 = new ArrayList();
        ArrayList<Cliente> lis3 = new ArrayList();
        
        for (int i = 0; i < listaOriginal.size(); i++) {
            Random ran = new Random();
            int aleatorio = ran.nextInt(3) + 1;
            if (aleatorio == 1) {
                lis.add(listaOriginal.get(i));
            }
            if (aleatorio == 2) {
                lis2.add(listaOriginal.get(i));
            }
            if (aleatorio == 3) {
                lis3.add(listaOriginal.get(i));
            }
        }
        long tiempoInicial = System.currentTimeMillis();
        Cajera cajera1 = new Cajera("Cajera 1", lis, lis.size(), tiempoInicial);
        Cajera cajera2 = new Cajera("Cajera 2", lis2, lis2.size(), tiempoInicial);
        Cajera cajera3 = new Cajera("Cajera 3", lis3, lis3.size(), tiempoInicial);
        
        cajera1.start();
        cajera2.start();
        cajera3.start();
    }
}
