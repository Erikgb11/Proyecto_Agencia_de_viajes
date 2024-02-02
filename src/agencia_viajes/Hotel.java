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
    private byte[] foto;
    private String nombre;
    
    
    public Hotel(double punt, double precio, int r, String loc,String nombre, byte[] foto){
        puntuacion=punt;
        preNo=precio;
        habitacionesT=r;
        habitacionesR=r;
        localizacion=loc;
        this.nombre=nombre;
        this.foto=foto;
    }
    
    public Hotel(double punt, double precio, int r, String loc,byte[] foto,String nombre){
        puntuacion=punt;
        preNo=precio;
        habitacionesT=r;
        habitacionesR=r;
        localizacion=loc;
        this.nombre=nombre;
        this.foto=foto;
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
    public byte[] getfoto(){
        return foto;
    }
    public void setFoto(byte[] foto){
        this.foto=foto;
    }
    public String getnombre(){
        return nombre;
    }
    public void Reser(int h){
        if(habitacionesR>=0){
            habitacionesR=habitacionesR-h;
        }
    }
    public int getReser(){
        return habitacionesT;
    }
 
}
