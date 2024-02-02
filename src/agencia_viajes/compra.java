/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;

import java.time.*;
import java.io.*;
/**
 *
 * @author erikg
 */
public class compra implements Serializable{
    private int id;
    private String nombre;
    private String tipo;
    private int cantidadC;
    private double pagado;
    private String correoC;
    private LocalDateTime fcompra;
    
    public compra(int id,String nombre, String tipo, int cantidadC,double pagado,String correo){
        this.id=id;
        this.nombre=nombre;
        this.tipo=tipo;
        this.cantidadC=cantidadC;
        this.pagado=pagado;
        this.correoC=correo;
        fcompra=LocalDateTime.now();
    }
    public int getId(){
        return id;
    }
    public LocalDateTime getFCompra(){
        return fcompra;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public int getCantidadC(){
        return cantidadC;
    }
    public void setCantidadC(int cantidadC){
        this.cantidadC=cantidadC;
    }
    public double getPagado(){
        return pagado;
    }
    public void setPagado(double pagado){
        this.pagado=pagado;
    }
    public String getCorreoC(){
        return correoC;
    }
    public void setCorreoC(String correoC){
        this.correoC=correoC;
    }
    public String toString(){
        return "id "+id+" nombre: "+nombre+" "+tipo+" "+cantidadC+" "+pagado+" "+correoC+" "+fcompra;
    }
}
