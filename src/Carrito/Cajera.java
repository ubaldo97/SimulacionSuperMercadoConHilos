/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrito;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ubaldo Pánuco Sandoval
 * Oscar Eduardo Ceballos Pérez
 * Carrito de compras
 * Simulación de compras en un supermercado 
 * utilizando hilos
 * 20/04/2018
 */

public class Cajera extends Thread{
    private String nombre;
    private ArrayList<Cliente> listac;
    private ArrayList<Cliente> listaTotal;
    private long tiempoInicial;
    private int tam;

    // Constructor, getter & setter
    public Cajera(String nombre, ArrayList<Cliente> lista, int tam, long t) {
        this.nombre = nombre;
        this.listac = lista;
        this.tiempoInicial = t;
        this.tam = tam;
    }

    @Override
    public void run() {
        try {

            Thread.sleep(10);

            for (int x = 0; x < tam; x++) {
                int total = 0;
                System.out.println("\n" + (char) 27 + "[30;46mLA " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                        + this.listac.get(0).getNombre() + " EN EL TIEMPO: "
                        + (System.currentTimeMillis() - this.tiempoInicial) / 1000
                        + "seg");
                for (int i = 0; i < this.listac.get(0).getCarrito().length; i++) {
                    Random ran = new Random();
                    int precio = ran.nextInt(500) + 1;
                    System.out.println("Procesando el producto " + (i + 1)
                             + "->Precio: " + "$"
                            + +precio
                    );
                    total += precio;
                }
                Random ran = new Random();
                int t = ran.nextInt(15) + 1;
                if (x == 0) {
                    System.out.println("\n" + (char) 27 + "[30;42mLA " + this.nombre + " HA TERMINADO DE ATENDER A "
                            + this.listac.get(0).getNombre() + " EN: "
                            + t
                            + "seg "
                            + "TOTAL A PAGAR: $"
                            + total);
                } else {

                    System.out.println("\n" + (char) 27 + "[30;42mLA " + this.nombre + " HA TERMINADO DE ATENDER A "
                            + this.listac.get(0).getNombre() + " EN: "
                            + (System.currentTimeMillis() - this.tiempoInicial + (t * 1000)) / 1000
                            + "seg "
                            + "TOTAL A PAGAR: $"
                            + total);
                }

                System.out.println("*****************************"
                        + "************************************************");
                listac.remove(0);

                this.esperar(t);
            }
            System.out.println("\n" + (char) 27 + "[30;43mLA " + this.nombre + " ATENDIO A: "
                    + tam + " CLIENTES EN TOTAL");

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTiempoInicial() {
        return tiempoInicial;
    }

    public void setTiempoInicial(long initialTime) {
        this.tiempoInicial = initialTime;
    }

}
