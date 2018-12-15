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
import java.util.ArrayList;
import model.pegawai;
import view.daftarpegawai;

/**
 *
 * @author Administrator
 */
public class daftarpegawai_kontroler implements MouseListener{
    private daftarpegawai gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    private ArrayList<pegawai> daftarmenu;//=new ArrayList<model_menu>();
    public daftarpegawai_kontroler(String nama){
        db.konek();
        getmenufromdb();
        gui = new daftarpegawai();
        gui.tampilmenu(daftarmenu);
        gui.setVisible(true);
        gui.addlistener(this);
        this.nama=nama;
    }
    public void getmenufromdb(){
        daftarmenu = new ArrayList<pegawai>();
        String command ="select * from pegawai";
        try {
            rs = db.getdata(command);
            while (rs.next()){
                int id = rs.getInt("id_pegawai");
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");
                String email = rs.getString("email");
                String jabatan = rs.getString("jabatan");
                String agama=rs.getString("agama");
                daftarmenu.add(new pegawai(id,nama,alamat,email,jabatan,agama));
            }
        } catch (Exception e) {
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        gui.dispose();
        new menupegawai_kontroler(nama);
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
