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
import javax.swing.JOptionPane;
import model.pegawai;
import view.hapuspegawai;

/**
 *
 * @author Administrator
 */
public class hapuspegawai_kontroler implements MouseListener{

    private hapuspegawai gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    private ArrayList<pegawai> daftarmenu;//=new ArrayList<model_menu>();
    public hapuspegawai_kontroler(String nama){
        db.konek();
        getmenufromdb();
        gui = new hapuspegawai();
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
        Object source=e.getSource();
        if(source.equals(gui.getExit())){
            gui.dispose();
            new menupegawai_kontroler(nama);
        }else{
            if (gui.getmenuselected()!=null){
                String command="delete from pegawai where id_pegawai="+Integer.parseInt(gui.getmenuselected());
                String commands="delete from userpass where username='"+String.valueOf(gui.getusername())+"'";
                db.isidata(command);
                db.isidata(commands);
                JOptionPane.showMessageDialog(gui,"pegawai terhapus","selamat",1);
                getmenufromdb();
                gui.tampilmenu(daftarmenu);
            }else{
                JOptionPane.showMessageDialog(gui,"tidak ada pegawai yang dipilih","error",0);
            }
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
