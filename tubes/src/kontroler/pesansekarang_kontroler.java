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
import model.model_menu;
import view.order;

/**
 *
 * @author Administrator
 */
public class pesansekarang_kontroler implements MouseListener{

    private order gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    private int y;
    private ArrayList<model_menu> daftarmenu;
    private ArrayList<model_menu> daftarpesanan = new ArrayList<model_menu>();
    public pesansekarang_kontroler(String nama,int y){
        db.konek();
        this.y=y;
        getmenufromdb();
        getpesananfromdb();
        gui = new order();
        gui.tampilmenu(daftarmenu);
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
    public void getmenufromdb(){
        daftarmenu = new ArrayList<model_menu>();
        String command ="select * from menu";
        try {
            rs = db.getdata(command);
            while (rs.next()){
                int id = rs.getInt("id_menu");
                String nama = rs.getString("nama");
                double harga = rs.getDouble("harga");
                String status = rs.getString("status");
                daftarmenu.add(new model_menu(id,nama,status,harga));
            }
        } catch (Exception e) {
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object source=e.getSource();
        if(source.equals(gui.getExit())){
            gui.dispose();
            new main_kontroler(nama,y);
        }else if(source.equals(gui.gettambah())){
            if(gui.getrowmenuselected()!=-1){
                daftarpesanan.add(daftarmenu.get(gui.getrowmenuselected()));
                gui.tampilpesanan(daftarpesanan);
            }else{
                JOptionPane.showMessageDialog(gui,"tidak ada menu yang dipilih","error",0);
            }
            
        }else if(source.equals(gui.gethapus())){
            if(gui.getrowpesananselected()!=-1){
                
            }else{
                JOptionPane.showMessageDialog(gui,"tidak ada menu yang dipilih","error",0);
            }
            
        }else if(source.equals(gui.getsimpan())){
            for(model_menu x:daftarpesanan){
                String commands="insert into detiltransaksi(id_transaksi,id_menu) values("+y+","+x.getid()+")";
                db.isidata(commands);
            }
            JOptionPane.showMessageDialog(gui,"terimakasih sudah memsan","sukses",1);
            gui.dispose();
            new main_kontroler(nama,y);
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
