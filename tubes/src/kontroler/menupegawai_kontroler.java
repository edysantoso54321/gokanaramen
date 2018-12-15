/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.menupegawai;

/**
 *
 * @author Administrator
 */
public class menupegawai_kontroler implements MouseListener{
    private menupegawai gui;
    private String nama;
    public menupegawai_kontroler(String x){
        this.nama = x;
        gui = new menupegawai();
        gui.setVisible(true);
        gui.addlistener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source=e.getSource();
        if (source.equals(gui.getexit())){
            gui.dispose();
            new mainadmin_kontroler(nama);
        }else if(source.equals(gui.gettambahpegawai())){
            gui.dispose();
            new tambahpegawai_kontroler(nama);
        }else if(source.equals(gui.getlihatpegawai())){
            gui.dispose();
            new daftarpegawai_kontroler(nama);
        }else{
            gui.dispose();
            new hapuspegawai_kontroler(nama);
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
