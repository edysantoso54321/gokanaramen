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
import view.menuadmin;

/**
 *
 * @author Administrator
 */
public class menuadmin_kontroler implements MouseListener{
    private menuadmin gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    private ArrayList<model_menu> daftarmenu;
    public menuadmin_kontroler(String nama){
        db.konek();
        getmenufromdb();
        gui = new menuadmin();
        gui.setVisible(true);
        gui.addlistener(this);
        gui.tampilmenu(daftarmenu);
        this.nama=nama;
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
        Object source=e.getSource();
        if(source.equals(gui.gettambah())){
            gui.dispose();
            new tambahmenu_kontroler(nama);
        }else if(source.equals(gui.gethapus())){
            if (gui.getmenuselected()!=null){
                String command="delete from menu where id_menu="+Integer.parseInt(gui.getmenuselected());
                db.isidata(command);
                getmenufromdb();
                gui.tampilmenu(daftarmenu);
            }else{
                JOptionPane.showMessageDialog(gui,"tidak ada menu yang dipilih","error",0);
            }
        }else{
            gui.dispose();
            new mainadmin_kontroler(nama);
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
