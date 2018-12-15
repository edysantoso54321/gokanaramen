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
import model.model_menu;
import view.pesanan;

/**
 *
 * @author Administrator
 */
public class lihatpesanan_kontroler implements MouseListener {
    private pesanan gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    private int y;
    private ArrayList<model_menu> daftarpesanan = new ArrayList<model_menu>();

    public lihatpesanan_kontroler(String nama, int y){
        db.konek();
        this.y=y;
        getpesananfromdb();
        gui = new pesanan();
        gui.tampilpesanan(daftarpesanan);
        gui.setVisible(true);
        gui.addlistener(this);
        this.nama=nama;
    }
    public void getpesananfromdb(){
        daftarpesanan = new ArrayList<model_menu>();
        String command ="select * from menu where id_menu in (select id_menu from detiltransaksi where id_transaksi="+y+")";
        try {
            rs = db.getdata(command);
            while (rs.next()){
                int id = rs.getInt("id_menu");
                String nama = rs.getString("nama");
                double harga = rs.getDouble("harga");
                String status = rs.getString("status");
                daftarpesanan.add(new model_menu(id,nama,status,harga));
            }
        } catch (Exception e) {
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        gui.dispose();
        new main_kontroler(nama,y);

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
