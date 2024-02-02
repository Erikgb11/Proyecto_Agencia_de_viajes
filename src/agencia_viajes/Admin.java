/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;

import java.io.*;
/**
 *
 * @author erikg
 */
public class Admin implements Serializable{
    private String nombre;
    private String correo;
    private String contra;
    
    public Admin(String nombre, String correo, String contra){
        this.nombre=nombre;
        this.correo=correo;
        this.contra=contra;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public String getContra(){
        return contra;
    }
    public void setContra(String contra){
        this.contra=contra;
    }
}
