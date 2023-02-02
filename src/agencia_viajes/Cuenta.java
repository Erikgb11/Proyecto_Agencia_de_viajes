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
public class Cuenta implements Serializable{
    private int numC;
    private double saldo;
	
    public Cuenta(){
        this.numC=0;
        this.saldo=0.0;
    }
    public Cuenta(double saldo){
        this.saldo=saldo;
    }
    
    public void aumeS(double ausal){
        saldo=saldo+ausal;
    }
    public double mostrarS(){
        return saldo;
    }
    public int getnum(){
        return numC;
    }
    public void ednum(int ed){
        this.numC=ed;
    }
    public String toString(){
        return "No. Cuenta: "+numC+"saldo "+saldo;
    }
}