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
public class Cliente implements Serializable{
    private String nombre;
    private int edad;
    private String tel;
    private String direccion;
    private Cuenta cuenta;
    private String contras;
    private String correo;
    private int activo=0;
    public Cliente(String nombre, String correo, String contra){
        this.nombre=nombre;
        edad=0;
        tel="";
        direccion="";
        cuenta=new Cuenta();
        this.contras=contra;
        this.correo=correo;
    }
    public Cliente(String nombre, int edad, String direccion,String correo, String contra){
	this.nombre=nombre;
	if(edad>=17){
            this.edad=edad;
	}
        cuenta=new Cuenta();
	this.tel="Sin telefono";
	this.direccion=direccion;
        this.contras=contra;
        this.correo=correo;
    }
    public Cliente(String nombre, int edad, String tel, String direccion,String correo,String contra){
	this.nombre=nombre;
	this.edad=edad;
	if(edad>17){
            this.edad=edad;
	}
        cuenta=new Cuenta();
        this.tel=tel;
	this.direccion=direccion;
	this.correo=correo;
        this.contras=contra;
    }
    public String  obtenerNombre( ){
        return nombre;
    }  
    public String  obtenerCorreo( ){
        return correo;
    }  
    public String obtenerContra( ){
        return contras;
    }  
    public Cuenta obtenerCuenta( ){
        return cuenta;
    }  
    public void crearNum(int num){
       this.cuenta.ednum(1000+num);
    }
    public int getactivo(){
        return activo;
    }
    public void editaract(){
        if(activo==1){
            activo=0;
        }else if(activo==0){
            activo=1;
        }
    }
    public void editaract(int a){
        if(activo==1||a==0){
            activo=a;
        }else if(activo==0||a==1){
            activo=1;
        }else{
            System.out.println("No se puede hacer el cambio");
        }
    }
    public String toString(){
        return "Usuario "+nombre+" Con edad: "+edad+" "+cuenta+tel+" "+direccion+" "+correo;
    }
}
