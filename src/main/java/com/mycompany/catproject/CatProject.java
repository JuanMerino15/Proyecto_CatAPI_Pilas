/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.catproject;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class CatProject {

    
        public static void main(String[] args) throws IOException {
         Gatos_Service catService = new Gatos_Service();
        catService.getGatos();
        
        
        int opcionMenu = -1;
        String[] opciones = {
            "1. Ver Gatos",
            "2. Salir"
        };
        
        do {
            String opcion = ( String ) JOptionPane.showInputDialog( null, "Gatitos Java", "Menú Principal", 
                    JOptionPane.INFORMATION_MESSAGE,
                    null, 
                    opciones, 
                    opciones[0] );
        } while ( opcionMenu != 2 );
    }
    }
    

