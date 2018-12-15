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
public class email {
    private String x;
    public void setX(String x){
        this.x=x;
    }
    public boolean isvalidemail(){
        int idx=0;
        boolean cond = false;
        if((x.length()<2)) cond=false;
        while((!cond) && (idx<x.length())){
            if(x.charAt(idx)=='@') cond=true;
            idx++;
        }
        return cond;
    }
}
