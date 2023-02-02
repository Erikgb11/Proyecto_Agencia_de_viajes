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
public class Crucero extends Viaje implements Serializable{
    private String clase;
    private double precio;
    
    public Crucero(String destino,String origen,String fechaS,String fechaR,int pas,String foto,String clase,double precio){
        super(destino,"Crucero",origen,fechaS,fechaR,60,pas,foto);
        this.clase=clase;
        this.precio=precio;
    }
    public void tipoClase(String a){
        this.clase="";
    }
    public String tipoClase(){
        return clase;
    }
    public double getprecio(){
        return precio;
    }
}
