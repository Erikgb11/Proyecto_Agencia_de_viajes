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
abstract class Viaje implements Serializable{
    private String destino;
    private String tipotra;
    private String origen;
    private String fechaS;
    private String fechaR;
    private static int numPT;
    private int pR;
    private int pas;
    private String foto;
    
    public Viaje(String destino,String tra,String origen,String fechaS,String fechaR,int numP, int pas,String foto){
        this.destino=destino;
        this.tipotra=tra;
        this.origen=origen;
        this.fechaS=fechaS;
        this.fechaR=fechaR;
        this.numPT=numP;
        this.pas=pas;
        this.foto=foto;
    }
    
    abstract public String tipoClase();
    abstract public double getprecio();
    public String getdestino(){
        return destino;
    }
    public String gettipotra(){
        return tipotra;
    }
    public String getorigen(){
        return origen;
    }
    public String getfechaS(){
        return fechaS;
    }
    public String getfechaR(){
        return fechaR;
    }
    public static int getnumPT(){
        return numPT;
    }
    public int getpr(){
        return pR;
    }
    public void eitpr(int r){
        pR=r;
    }
    public static void decnumPT(int a){
        numPT=a;
    }
    public int getpas(){
        return pas;
    }

}
