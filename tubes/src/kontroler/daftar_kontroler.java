/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import database.database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.addslashes;
import model.email;
import view.daftar;

/**
 *
 * @author Administrator
 */
public class daftar_kontroler implements MouseListener,ActionListener{
    private daftar gui;
    private database db = new database();
    private ResultSet rs;
    private String nama;
    public daftar_kontroler(){
        db.konek();
        gui = new daftar();
        gui.setVisible(true);
        gui.addlistener(this);
        gui.addmouseistener(this);
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
    @Override
    public void mouseClicked(MouseEvent e) {
        gui.dispose();
        new login_kontroler();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username=new addslashes().addslash(gui.getusername().trim());
        String password=new addslashes().addslash(gui.getpassword().trim());
        String nama=new addslashes().addslash(gui.getnama().trim());
        String alamat=new addslashes().addslash(gui.getalamat());
        char kelamin=gui.getkelamin();
        String email=new addslashes().addslash(gui.getemail().trim());
        String agama=new addslashes().addslash(gui.getagama());
        String nomor=new addslashes().addslash(gui.getnomor().trim());
        email c=new email();
        c.setX(email);
        if(iskosong(username,password,nama,alamat,email,nomor)){
            JOptionPane.showMessageDialog(gui,"tidak boleh ada fild yang kosong","error",0);
        }else if(!isvalidnomortelepon(nomor)){
            JOptionPane.showMessageDialog(gui,"maaf nomor telepon tidak valid"+'\n'+"catatan : tidak perlu kode negara","error",0);
        }else if(!c.isvalidemail()){
            JOptionPane.showMessageDialog(gui,"maaf nomor telepon tidak valid"+'\n'+"catatan : tidak perlu kode negara","error",0);
        }else{
            try {
                rs = db.getdata("select username from userpass where username='"+username+"'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(gui,"username sudah dipakai orang lain","error",0);
                }else{
                    String command="insert into userpass values('"+
                            username+"'"+
                            ",'"+password+"'"+
                            ",'c')";
                    db.isidata(command);
                    command="insert into customer(nama,alamat,nomer_telp,jenis_kelamin,email,agama,username) values('"
                            + nama+"','"
                            + alamat+"','"
                            + nomor +"','"
                            + kelamin+"','"
                            + email+"','"
                            + agama+"','"
                            + username+"')";
                    db.isidata(command);
                    JOptionPane.showMessageDialog(gui,"silahkan login","selamat",1);
                    gui.dispose();
                    new login_kontroler();
                }
            } catch (SQLException ex) {
                Logger.getLogger(daftar_kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
