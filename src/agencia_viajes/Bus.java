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
public class Bus extends Viaje implements Serializable{
    private double precio;
    private String clase;
    private String compania;
    public Bus(String destino,String origen,String fechaS,String fechaR, int pas,double precio,byte[] foto,String clase,String comp){
        super(destino,"Bus",origen,fechaS,fechaR,pas,foto);
        this.precio=precio;
        this.clase=clase;
        compania=comp;
    }
    public String tipoClase(){
        return clase;
    }
    public double getprecio(){
        return precio;
    }
    public String comp(){
        return compania;
    }
}
