package model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class isempty {
    private String x;
    public void setX(String x){
        this.x=x;
    }
    public boolean isvalidnomortelepon(String x){
        int idx=0;
        boolean cond = true;
        if((x.length()>13) || (x.length()<10)) cond=false;
        while((cond) && (idx<x.length())){
            if((x.charAt(idx)!='0') && (x.charAt(idx)!='1') && (x.charAt(idx)!='2') && (x.charAt(idx)!='3')  && (x.charAt(idx)!='4') && (x.charAt(idx)!='5') && (x.charAt(idx)!='6')  && (x.charAt(idx)!='7') && (x.charAt(idx)!='8') && (x.charAt(idx)!='9')) cond=false;
            idx++;
        }
        return cond;
    }
    public boolean iskosong(String username, String password, String nama, String alamat,String email,String nomor ){
        return username.equals("") || password.equals("") || nama.equals("") || alamat.equals("") || email.equals("") || nomor.equals("");
    }
}
