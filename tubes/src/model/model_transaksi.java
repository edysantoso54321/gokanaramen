/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class model_transaksi {
    private int id_transaksi;
    private double jumlah;
    public model_transaksi(int id,double jumlah){
        this.id_transaksi=id;
        this.jumlah=jumlah;
    }
    public int getid(){
        return id_transaksi;
    }
    public double getjumlah(){
        return jumlah;
    }
}
