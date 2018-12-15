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
import view.tampilanpegawai;
/**
 *
 * @author Administrator
 */
public class pegawai_kontroler implements MouseListener{
    private tampilanpegawai gui;
    private database db = new database();
    private ResultSet rs=null;
    private String nama;
    private String nm;
    private String jbtn;
    private String jk;
    private String emaile;
    private String agm;
    private String almt;
    private String gj;
    public pegawai_kontroler(String x){
        nama = x;
        db.konek();
        gui = new tampilanpegawai(x);
        getmenufromdb();
        gui.settext(nm,jbtn,jk,emaile,agm,almt,gj);
        gui.setVisible(true);
        gui.addlistener(this);

    }
    public void getmenufromdb(){
        //daftarmenu = new ArrayList<model_menu>();
        String command ="select * from pegawai";
        try {
            rs = db.getdata(command);
            while (rs.next()){
                nm=rs.getString(2);
                jbtn=rs.getString(7);
                jk=rs.getString(4);
                emaile=rs.getString(6);
                agm=rs.getString(8);
                almt=rs.getString(3);
                gj="0";
            }
        } catch (Exception e) {
        }
    }
    public void getpegawaifromdb(){
        String command="select * from menu";
        System.out.println(command);
        try{
            rs = db.getdata(command);
            while(rs.next()){
                nm=rs.getString(2);
                jbtn=rs.getString(7);
                jk=rs.getString(4);
                emaile=rs.getString(6);
                agm=rs.getString(8);
                almt=rs.getString(3);
                gj="0";
            }
        }catch(Exception e){
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        gui.dispose();
        new login_kontroler();
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
