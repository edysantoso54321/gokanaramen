/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import database.database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.addUser;

/**
 *
 * @author Administrator
 */
public class addUser_kontroler implements ActionListener{
    addUser view;
    private String nama;
    database db = new database();
    public addUser_kontroler(String x) {
        nama = x;
        db.konek();
        view = new addUser(nama);
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getAddButton())){
            if(!view.getUsername().getText().equals("")&&!view.getPassword().getText().equals("")){
                db.isidata("insert into user values('"+view.getUsername().getText()+"','"+view.getPassword().getText()+"')");
                view.dispose();
                new main_kontroler(nama);
            }else{
                JOptionPane.showMessageDialog(null, "Maaf Username dan Password\nTidak Boleh Kosong", "Tidak Boleh Kosong", 2);
            }
        }
    }
    
}
