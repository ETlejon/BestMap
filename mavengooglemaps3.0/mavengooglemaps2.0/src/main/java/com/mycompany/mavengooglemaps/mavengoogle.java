package com.mycompany.mavengooglemaps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VLADIVOZTOK
 */
public class mavengoogle {
    public final int WIDTH = 640;
  public final int HEIGHT = 480;
  public final LatLng latitud1 = new LatLng();
  public final LatLng longitud1 = new LatLng();
    private final BufferedImage IMAGE = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException, ApiException, InterruptedException, IOException{
       mapaestatico m = new mapaestatico();
        
        
        System.out.println("Google maps java");  
  GeoApiContext context = new GeoApiContext.Builder()
    .apiKey("AIzaSyBT3LetGrKgAPSj4FiAJUiAbSd2h8sfN0E")
    .build();
GeocodingResult[] results =  GeocodingApi.geocode(context,
    "edificio cosmopolitan, tijuana").await();
Gson gson = new GsonBuilder().setPrettyPrinting().create();
System.out.println(gson.toJson("La longitud es: "+results[0].geometry.location.lat));
System.out.println(gson.toJson("La latitud es: "+results[0].geometry.location.lng));
double longitud = results[0].geometry.location.lng;
double latitud = results[0].geometry.location.lat;


 }
    }
    
    

