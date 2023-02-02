/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;

/**
 *
 * @author HP
 */
import java.io.*;
public class Hotel implements Serializable{
    private double puntuacion;
    private double preNo;
    private int habitacionesT;
    private int habitacionesR;
    private String localizacion;
    private String foto;
    private String nombre;
    
    
    public Hotel(double punt, double precio, int r, String loc,String nombre){
        puntuacion=punt;
        preNo=precio;
        habitacionesT=60;
        habitacionesR=r;
        localizacion=loc;
        this.nombre=nombre;
    }
    
    public Hotel(double punt, double precio, int r, String loc,String foto,String nombre){
        puntuacion=punt;
        preNo=precio;
        habitacionesT=60;
        habitacionesR=r;
        localizacion=loc;
        this.nombre=nombre;
    }
    public double getpuntuacion(){
        return puntuacion;
    }
    public double getpreNo(){
        return preNo;
    }
    public int gethabitacionesR(){
        return habitacionesR;
    }
    public String getlocalizacion(){
        return localizacion;
    }
    public String getfoto(){
        return foto;
    }
    public String getnombre(){
        return nombre;
    }
    public void Reser(int h){
        if(habitacionesT>=0){
            habitacionesT=habitacionesT-h;
        }
    }
    public int getReser(){
        return habitacionesT;
    }
 
}
