/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class database {
    private final String server = "jdbc:mysql://localhost/impal";
    private final String dbuser = "root";
    private final String dbpass = "";
    private Connection kon=null;
    private Statement state=null;
    private ResultSet rs=null;
    public void konek(){
        try {
            kon = (Connection) DriverManager.getConnection(server, dbuser, dbpass);
            state = (Statement) kon.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"terjadi kesalahan saat koneksi","error",0);
        } 
    }
    public void isidata(String command){
        try {
            state.executeUpdate(command);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"terjadi kesalahan saat mengisi data","error",0);
        }
    }
    public ResultSet getdata(String command){
        try {
            rs = state.executeQuery(command);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"terjadi kesalahan saat mengambil data","error",0);
        }
        return rs;
    }
}
