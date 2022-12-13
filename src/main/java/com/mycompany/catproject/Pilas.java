/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.catproject;

import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class Pilas {
    //Inicia la clase pila.

   private Gatos[] stack;
    private int top;
    private int length;
    
    //Crea una pila con espacio para t Data
    public Pilas(int t){
        stack = new Gatos[t];
        top = t;
        this.length = t;
        System.out.println("El valor de Top es: " + this.top);
        System.out.println("Tamaño de la pila: " + stack.length);
    }
    
    //Regresa true si la pila está vacía
    public boolean isEmpty(){
        if(top==stack.length)
            return true;
        else
            return false;
    }
    
    //Regresa true si la pila ya está llena
    public boolean isFull(){
        if(top == 0)
            return true;
        else
            return false;
    }
    
   //Inserta un elemento elemto en la pila
  public boolean push(Gatos d){
      if(this.isFull())//La pila está llena y no se pueden insertar más datos
          return false;
      this.top--;
      stack[top] = d;
        System.out.println("El valor de top: " + this.top);
        return true;
  }
  
  //Saca un elemento de la pila 
    public Gatos pop(){
        Gatos unGato = null;
        //Si la pila NO está vacía, se pueden retirar elementos 
        if(!this.isEmpty()){
            System.out.println("Retirando elemento [ " + top + " ]");
            unGato = stack[top];
            this.top++;
        }
        return unGato;
    }
    
    //Regresa el número de elementos que están en la pila
    public int getSize(){
        return this.stack.length;
    }
}

    

