/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import database.database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.addslashes;
import view.tambahmenu;

/**
 *
 * @author Administrator
 */
public class tambahmenu_kontroler implements MouseListener{
    private tambahmenu gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    
    public tambahmenu_kontroler(String nama){
        db.konek();
        gui = new tambahmenu();
        gui.setVisible(true);
        gui.addlistener(this);
        this.nama=nama;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source=e.getSource();
        if(source.equals(gui.gettambah())){
            String namamenu=new addslashes().addslash(gui.getnama());
            String harga=new addslashes().addslash(gui.getharga());
            if(namamenu.equals("")){
                JOptionPane.showMessageDialog(gui,"nama tidak boleh kosong","error",0);
            }else if(new addslashes().isnumber(harga)){
                String command="insert into menu(nama,harga,status) values('"+namamenu+"',"+harga+",'ada')";
                db.isidata(command);
                JOptionPane.showMessageDialog(gui,"selamat menu berhasil ditambahkan","berhasil",1);
                gui.dispose();
                new menuadmin_kontroler(nama);
            }else{
                JOptionPane.showMessageDialog(gui,"format harga tidak sesuai","error",0);
            }
        }else{
            gui.dispose();
            new menuadmin_kontroler(nama);
        }
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
    
}