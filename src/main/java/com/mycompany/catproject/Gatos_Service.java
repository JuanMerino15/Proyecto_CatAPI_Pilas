/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.catproject;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class Gatos_Service {
    
      //Renderiza una imagen dentro de un JOptionPane
    public void desplegarImagen(Gatos unGato) throws IOException{
       
        Image image = null;
        try{
            URL url = new URL(unGato.getUrl());
            image = ImageIO.read(url);
            
            //Redimensionar la imagen obtenida
            ImageIcon imgGato = new ImageIcon(image);
            if(imgGato.getIconWidth()>700){
                Image img = imgGato.getImage();
                Image imgModificada = img.getScaledInstance(700, 400, java.awt.Image.SCALE_SMOOTH);
                imgGato = new ImageIcon(imgModificada);
            }
            
            String idGato = unGato.getId();
            JOptionPane.showMessageDialog(null, idGato, "Gato", JOptionPane.INFORMATION_MESSAGE,imgGato);
            
        } catch ( Exception e ) {
            System.out.println("No se pudo crear el objeto Image");
        }
        }        
                
    //conexión con la API
    public Gatos getGatos() throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();
        //Toda la información de API
        Response response = client.newCall(request).execute();
        
        //Crear un objeto con formmato  Jso
        String gatoJson = response.body().string();
        //Quitar llave inicial y final
        gatoJson = gatoJson.substring(1,gatoJson.length());
        gatoJson = gatoJson.substring(0, gatoJson.length()-1);
        
        System.out.println("gatoJson: " + gatoJson);
        //Crear un objeto de la clase json
        Gson gson = new Gson();
        Gatos gato = gson.fromJson(gatoJson, Gatos.class);
        return gato;
      
        }
}

