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
import view.mainadmin;

/**
 *
 * @author Administrator
 */
public class mainadmin_kontroler implements MouseListener{

    private mainadmin gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    public mainadmin_kontroler(String nama){
        db.konek();
        gui = new mainadmin(nama);
        gui.setVisible(true);
        gui.addlistener(this);
        this.nama=nama;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source=e.getSource();
        if(source.equals(gui.getpegawai())){
            gui.dispose();
            new menupegawai_kontroler(nama);
        }else if(source.equals(gui.getmenu())){
            gui.dispose();
            new menuadmin_kontroler(nama);
        }else if(source.equals(gui.getcustomer())){
            gui.dispose();
            new hapuscustomer_kontroler(nama);
        }else{
            gui.dispose();
            new login_kontroler();
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