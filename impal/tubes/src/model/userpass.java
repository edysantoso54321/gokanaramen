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
public class userpass {
    public String username;
    public String password;
    public char status;
    public void userpass(String u, String p, char s){
        this.username=u;
        this.password=p;
        this.status=s;
    }
    public String getusername(){
        return username;
    }
    public String getpassrword(){
        return password;
    }
    public char getstatus(){
        return status;
    }
}
