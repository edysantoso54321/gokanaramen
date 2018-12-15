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
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import model.addslashes;
import view.login;

/**
 *
 * @author Administrator
 */
public class login_kontroler implements MouseListener{
    private login gui;
    private database db = new database();
    private ResultSet rs=null;
    public login_kontroler(){
        db.konek();
        gui = new login();
        gui.setVisible(true);
        gui.addlistener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(gui.getdaftar())){
            gui.dispose();
            new daftar_kontroler();
        }else{
            String username = new addslashes().addslash(gui.getuser()).trim();
            String password = new addslashes().addslash(gui.getpass()).trim();
            if (username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(gui, "maaf username dan password tidak boleh kosong","error",0);
            }else{
                String command = "select * from userpass where username='"+username+"' and password='"+password+"'";
                String commands = "select max(id_transaksi) from transaksi";
                try {
                    String previlage;
                    rs = db.getdata(command);
                    if (rs.next() && rs.getString(1).equals(username) && rs.getString(2).equals(password)){
                        String nama=rs.getString(1);
                        previlage=rs.getString(3);
                        if (previlage.equals("c")) {
                            rs=db.getdata(commands);
                            if(rs.next() && rs.getBoolean(1)){
                                int max=rs.getInt(1);
                                command="select id_customer from customer where username='"+username+"'";
                                rs=db.getdata(command);
                                rs.next();
                                command="insert into transaksi values("+(max+1)+","+rs.getInt(1)+",'lunas')";
                                db.isidata(command);
                                gui.dispose();
                                new main_kontroler(nama,max+1);
                            }else{
                                command="select id_customer from customer where username='"+username+"'";
                                rs=db.getdata(command);
                                rs.next();
                                command="insert into transaksi values(1,"+rs.getInt(1)+",'lunas')";
                                db.isidata(command);
                                gui.dispose();
                                new main_kontroler(nama,1);
                            }
                        }else if (previlage.equals("a")){
                            gui.dispose();
                            new mainadmin_kontroler(rs.getString(1));
                        }else if (previlage.equals("p")){
                            gui.dispose();
                            new pegawai_kontroler(rs.getString(1));
                        }else if (previlage.equals("m")){
                            gui.dispose();
                            new mainmanager_kontroler(rs.getString(1));
                        }else{
                            gui.dispose();
                        }
                    }else{
                        JOptionPane.showMessageDialog(gui, "maaf user dan password tidak valid","gagal",0);
                        gui.reset();
                    }
                } catch (Exception ae) {
                }
            }
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
