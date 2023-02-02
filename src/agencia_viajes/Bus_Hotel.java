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
public class Bus_Hotel implements Paquetes,Serializable{
    private Bus bus;
    private Hotel hotel;
    private double precio;
    
    public Bus_Hotel(Hotel h,Bus b){
        bus=b;
        hotel=h;
        preio();
    }
    public Viaje Mostrarviaje(){
        return bus;
    }
    public Hotel mostarh(){
        return hotel;
    }
    public void PersonasD(int a){
        hotel.Reser(a);
        bus.eitpr(a);
    }
    public double getprecio(){
        return precio;
    }
    public void preio(){
        precio=hotel.getpreNo()+bus.getprecio();
    }
    
}
