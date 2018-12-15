/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.lihatdata;

/**
 *
 * @author Administrator
 */
public class lihatdata_kontroler implements MouseListener {
    private lihatdata gui;
    private String nama;
    public lihatdata_kontroler(String x){
        nama = x;
        gui = new lihatdata();
        gui.addlistener(this);
        gui.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(gui.getKembali())){
            gui.dispose();
            new main_kontroler(nama);
        }else if (source.equals(gui.getData())){
            gui.dispose();
            new data_kontroler(nama);
        }else{
            gui.dispose();
            new user_kontroler(nama);
        }
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
