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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.mainmanager;

/**
 *
 * @author Administrator
 */
public class mainmanager_kontroler implements MouseListener{
    private mainmanager gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    public mainmanager_kontroler(String nama){
        db.konek();
        gui = new mainmanager(nama);
        gui.setVisible(true);
        gui.addlistener(this);
        this.nama=nama;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source=e.getSource();
        if(source.equals(gui.getpegawai())){
            gui.dispose();
            new login_kontroler();
        }else if(source.equals(gui.getlaporan())){
            gui.dispose();
            try {
                new laporan_kontroler(nama);
            } catch (SQLException ex) {
                Logger.getLogger(mainmanager_kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
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
