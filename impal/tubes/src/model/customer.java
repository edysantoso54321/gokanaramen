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
public class customer implements manusia{
    private String id;
    private String username;
    public String nama;
    public int umur;
    public String alamat;
    public String notelp;
    public char jk;
    public String email;
    public String agama;
    
    
    
    public void setid(String a){
        this.id=a;
    }
    public void setusername(String a){
        this.username=a;
    }
    @Override
    public void setnama(String a) {
        this.nama=a;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setumur(int a) {
        this.umur=a;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setalamat(String a) {
        this.alamat=a;
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setelepon(String a) {
        this.notelp=a;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setjk(char a) {
        this.jk=a;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setemail(String a) {
        this.email=a;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setagama(String a) {
        this.agama=a;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getnama() {
        return this.nama;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getnotelp() {
        return notelp;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getuserid(){
        return id;
    }
    public String getusername(){
        return username;
    }
}
