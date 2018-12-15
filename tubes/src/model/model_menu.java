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
public class model_menu {
    public int id;
    public String nama;
    public String status;
    public double harga;

    public model_menu(int id, String nama, String status, double harga) {
        this.id=id;
        this.nama=nama;
        this.status=status;
        this.harga=harga;
    }

    public int getid(){
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
