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
import java.util.ArrayList;
import model.model_transaksi;
import view.laporan;

/**
 *
 * @author Administrator
 */
public class laporan_kontroler implements MouseListener {
    private laporan gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    private ArrayList<model_transaksi> daftartransaksi;
    public laporan_kontroler(String nama) throws SQLException{
        db.konek();
        gettransaksifromdb();
        gui = new laporan();
        gui.tampilpesanan(daftartransaksi);
        gui.setVisible(true);
        gui.addlistener(this);
        this.nama=nama;
    }
    public void gettransaksifromdb() throws SQLException{
        ArrayList<Integer> data=new ArrayList<>();
        daftartransaksi = new ArrayList<model_transaksi>();
        String command ="select id_transaksi from transaksi";
        try {
            rs = db.getdata(command);
            while(rs.next()){
                data.add(Integer.parseInt(rs.getString(1)));
            }
        } catch (Exception e) {
        }
        for(int i=0; i<data.size(); i++){
            int id=data.get(i);
            double jum=0;
            String com="select * from menu where id_menu in (select id_menu from detiltransaksi where id_transaksi="+id+")";
            ResultSet rslocal=db.getdata(com);
            while (rslocal.next()){
                jum+=rslocal.getDouble("harga");
            }
            this.daftartransaksi.add(new model_transaksi(id,jum));
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        gui.dispose();
        new mainmanager_kontroler(nama);
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
