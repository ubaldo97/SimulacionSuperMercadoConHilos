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
public class Cliente  {
    private String nombre;
    private int[] carrito;
    public static Cliente c;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carrito = generarAleatorio();

    }

    public static ArrayList<Cliente> generarClientes(int cantidad) {

        ArrayList<Cliente> listaOriginal = new ArrayList();
        for (int i = 0; i < cantidad; i++) {
            c = new Cliente(listaClientes.Nombres(i));
            listaOriginal.add(c);
        }
        return listaOriginal;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCarrito() {
        return carrito;
    }

    public void setCarrito(int[] carrito) {
        this.carrito = carrito;
    }

    /*Este metodo genera una lista con un numero de productos aleatorios
     *En primera instancia se iba a utilizar para esperar un determinado tiempo por cada
      producto pero luego se optó por esperar un determinado tiempo por cliente y no por
      producto.    
     *Por lo cual en la clase cajera solo se utilizó el tamaño de 
      cada lista generada para la cantidad de productos. 
    */
    private int[] generarAleatorio() {

        Random ran = new Random();
        int num = ran.nextInt(10) + 1;
        int[] nProductos = new int[num];
        for (int i = 0; i < num; i++) {
            Random ran2 = new Random();
            int num2 = ran.nextInt(5) + 1;
            nProductos[i] = num2;
        }
        return nProductos;
    }


}
