/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.catproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class CatProject {

       public static void main(String[] args) throws IOException {
        Pilas pila;
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;

        int t;
        Gatos gato;

        Gatos_Service catService = new Gatos_Service();
        char respuesta;

        //Pedimos el tamaño de la pila
        System.out.println("Escriba el tamaño del arreglo: ");
        entrada = bufer.readLine();
        t = Integer.parseInt(entrada);
        pila = new Pilas(t);

        //Probar el estado de la pila está vacia
        System.out.println("Estado actual de la pila: ");
        if (pila.isEmpty()) {
            System.out.println("La pila esta vacia");
        } else {
            System.out.println("la pila tiene elementos");
        }

        //Introducir información en la pila 
        System.out.println("--------------------------------------------");
        do {
            gato = catService.getGatos();
            System.out.println("Gato id: " + gato.getId());
            System.out.println("Gato url: " + gato.getUrl());
            catService.desplegarImagen(gato);
           
            if (pila.push(gato)) {
                System.out.println("El dato se introdujo en la pila");
                System.out.println("¿Quieres introducir más Datos? Escriba n para parar: ");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            } else {
                System.out.println("La pila está llena, ya no se pueden introducir datos");
                respuesta = 'n';
            }

        } while (respuesta != 'n');
        
         //Sacar todos los elementos de la pila e imprimirlos 
        while(!pila.isEmpty()){
        gato = pila.pop();
        System.out.println("Retirando valores de la pila: " + gato.getId());
        }
        
        //Comprobar que la pila quedó vacía
        
        System.out.println("---------------------------------------");
        System.out.println("Estado actual de la pila: ");
        if(pila.isEmpty())
            System.out.println("La pila está vacía");
        else
            System.out.println("La pila aún no está vacía");
       }
}

    

