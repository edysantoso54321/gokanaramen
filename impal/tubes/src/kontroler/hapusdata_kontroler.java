/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.hapusdata;

/**
 *
 * @author Administrator
 */
public class hapusdata_kontroler implements MouseListener {
    private String nama;
    private hapusdata gui;
    public hapusdata_kontroler(String x){
        nama = x;
        gui = new hapusdata();
        gui.addlistener(this);
        gui.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        gui.dispose();
        new main_kontroler(nama);
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
