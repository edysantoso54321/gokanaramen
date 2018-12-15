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
public class addslashes {
    public String addslash(String x){
        int idx=0;
        String hasil="";
        while(idx<x.length()){
            if(x.charAt(idx)=='\\') hasil=hasil+'\\'+'\\';
            else if(x.charAt(idx)=='\'') hasil=hasil+'\\'+x.charAt(idx);
            else hasil=hasil+x.charAt(idx);
            idx++;
        }
        return hasil;
    }
    public boolean isnumber(String x){
        try{
            Integer.parseInt(x);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
