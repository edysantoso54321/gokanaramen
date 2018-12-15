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
import model.customer;
import view.hapuscustomer;

/**
 *
 * @author Administrator
 */
public class hapuscustomer_kontroler implements MouseListener{
    private hapuscustomer gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    private ArrayList<customer> daftarmenu;//=new ArrayList<model_menu>();
    public hapuscustomer_kontroler(String nama){
        db.konek();
        getmenufromdb();
        gui = new hapuscustomer();
        gui.tampilmenu(daftarmenu);
        gui.setVisible(true);
        gui.addlistener(this);
        this.nama=nama;
    }
    
    public void getmenufromdb(){
        daftarmenu = new ArrayList<customer>();
        String command ="select * from customer";
        try {
            rs = db.getdata(command);
            while (rs.next()){
                int id = rs.getInt("id_customer");
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");
                String username = rs.getString("username");
                String nomertelepon=rs.getString("nomer_telp");
                daftarmenu.add(new customer(id,nama,alamat,nomertelepon,username));
            }
        } catch (Exception e) {
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source=e.getSource();
        if(source.equals(gui.getExit())){
            gui.dispose();
            new mainadmin_kontroler(nama);
        }else{
            if (gui.getmenuselected()!=null){
                String command="delete from customer where id_customer="+Integer.parseInt(gui.getmenuselected());
                String commands="delete from userpass where username='"+String.valueOf(gui.getusername())+"'";
                db.isidata(command);
                db.isidata(commands);
                JOptionPane.showMessageDialog(gui,"customer terhapus","selamat",1);
                getmenufromdb();
                gui.tampilmenu(daftarmenu);
            }else{
                JOptionPane.showMessageDialog(gui,"tidak ada customer yang dipilih","error",0);
            }
        }

///throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
