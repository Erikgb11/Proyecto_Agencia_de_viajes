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
    private static int numPT;//pasaje total
    private int pR;//pasaje restante
    private int pas;//usado
    private byte[] foto;
    
    public Viaje(String destino,String tra,String origen,String fechaS,String fechaR,int numP,byte[] foto){
        this.destino=destino;
        this.tipotra=tra;
        this.origen=origen;
        this.fechaS=fechaS;
        this.fechaR=fechaR;
        this.numPT=numP;
        pR=numP;
        this.foto=foto;
    }
    public Viaje(String destino,String tra,String origen,String fechaS,String fechaR,int numP,int numR,byte[] foto){
        this.destino=destino;
        this.tipotra=tra;
        this.origen=origen;
        this.fechaS=fechaS;
        this.fechaR=fechaR;
        this.numPT=numP;
        pR=numR;
        this.foto=foto;
    }
    
    abstract public String tipoClase();
    abstract public double getprecio();
    public String getdestino(){
        return destino;
    }
    public void setDestino(String destino){
        this.destino=destino;
    }
    public String gettipotra(){
        return tipotra;
    }
    public void setTipoTra(String tipotra){
        this.tipotra=tipotra;
    }
    public String getorigen(){
        return origen;
    }
    public void setOrigen(String origen){
        this.origen=origen;
    }
    public String getfechaS(){
        return fechaS;
    }
    public void setFechaS(String fechaS){
        this.fechaS=fechaS;
    }
    public String getfechaR(){
        return fechaR;
    }
    public void setFechaR(String fechaR){
        this.fechaR=fechaR;
    }
    public static int getnumPT(){
        return numPT;
    }
    public int getpr(){
        return pR;
    }
    public void setPr(int pR){
        this.pR=pR;
    }
    public int getpas(){
        return pas;
    }
    public void setPas(int pas){
        this.pas=pas;
    }
    public byte[] getFoto(){
        return foto;
    }
    public void serFoto(byte[] foto){
        this.foto=foto;
    }
    public void dismPas(int pasC){
        pR=pR-pasC;
    }
    
    
    
    
    

}
