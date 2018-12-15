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
public class menu {
    public String id;
    public String nama;
    public String status;
    public double harga;
    
    public void menu(String id, String nama, String status, double harga){
        this.id=id;
        this.nama=nama;
        this.status=status;
        this.harga=harga;
    }
    
    public String getid(){
        return id;
    }
    public String getnama(){
        return nama;
    }
    public double getharga(){
        return harga;
    }
    public String getstatus(){
        return status;
    }
}
