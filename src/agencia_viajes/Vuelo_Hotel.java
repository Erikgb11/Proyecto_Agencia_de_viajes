/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;
   
import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Vuelo_Hotel implements Paquetes,Serializable{
    private Avion viaje;
    private Hotel hotel;
    private double precio;
    
    public Vuelo_Hotel(Hotel h,Avion a){
        viaje=a;
        hotel=h;
        preio();
    }
    public Viaje Mostrarviaje(){
        return viaje;
    }
    public Hotel mostarh(){
        return hotel;
    }
    public void PersonasD(int a){
        hotel.Reser(a);
        viaje.eitpr(a);
    }
    public void preio(){
        precio=hotel.getpreNo()+viaje.getprecio();
    }
    public double getprecio(){
        return precio;
    }
}
