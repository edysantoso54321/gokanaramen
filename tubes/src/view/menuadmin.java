/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import model.model_menu;

/**
 *
 * @author Administrator
 */
public class menuadmin extends javax.swing.JFrame {

    /**
     * Creates new form menuadmin
     */
    private Object[] rowmenu={"id","nama","harga","status"};
    private DefaultTableModel tablemenu= new DefaultTableModel(null,rowmenu);
    public menuadmin() {
        initComponents();
        mastertable.setModel(tablemenu);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screensize.width / 2) - (getSize().width / 2), (screensize.height / 2) - (getSize().height / 2));
    }
    
    public void tampilmenu(ArrayList<model_menu> a){
        int z=tablemenu.getRowCount();
        for (int i = 0; i <z; i++) {
            tablemenu.removeRow(0);
        }
        for (model_menu x: a){
            int id = x.getid();
            String nama=x.getnama();
            double harga=x.getharga();
            String status=x.getstatus();
            Object[] data={id,nama,harga,status};
            tablemenu.addRow(data);
        }
    }

    
    public void addlistener(MouseListener e){
        exit.addMouseListener(e);
        tambah.addMouseListener(e);
        hapus.addMouseListener(e);
    }
    public JLabel getExit() {
        return exit;
    }
    
    public JButton gettambah() {
        return tambah;
    }
    public JButton gethapus() {
        return hapus;
    }
    
    public String getmenuselected(){
        if (mastertable.getSelectedRow()>-1) return String.valueOf(tablemenu.getValueAt(mastertable.getSelectedRow(),0));
        else return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mastertable = new javax.swing.JTable();
        exit = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(583, 450));
        jPanel1.setLayout(null);

        tambah.setText("tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel1.add(tambah);
        tambah.setBounds(10, 90, 80, 23);

        hapus.setText("hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel1.add(hapus);
        hapus.setBounds(10, 130, 80, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("DAFTAR MENU");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 50, 240, 30);

        mastertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(mastertable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(100, 90, 470, 290);

        exit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 0));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/back1.png"))); // NOI18N
        exit.setText("kembali");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(exit);
        exit.setBounds(10, 10, 160, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/backgroundmain.jpg"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(583, 390));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 0, 583, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_hapusActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mastertable;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
