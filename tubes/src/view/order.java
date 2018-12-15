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
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import model.model_menu;

/**
 *
 * @author Administrator
 */
public class order extends javax.swing.JFrame {

    /**
     * Creates new form order
     */
    private Object[] rowmenu={"nama","harga","status"};
    private Object[] roworder={"nama","harga"};
    private DefaultTableModel tablemenu= new DefaultTableModel(null,rowmenu);
    private DefaultTableModel tablepesanan= new DefaultTableModel(null,roworder);
    public order() {
        initComponents();
        mastertablemenu.setModel(tablemenu);
        mastertablepesanan.setModel(tablepesanan);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screensize.width / 2) - (getSize().width / 2), (screensize.height / 2) - (getSize().height / 2));
    }
    
    public void tampilmenu(ArrayList<model_menu> a){
        int z=tablemenu.getRowCount();
        for (int i = 0; i <z; i++) {
            tablemenu.removeRow(0);
        }
        for (model_menu x: a){
            String nama=x.getnama();
            double harga=x.getharga();
            String status=x.getstatus();
            Object[] data={nama,harga,status};
            tablemenu.addRow(data);
        }
    }
    public void tampilpesanan(ArrayList<model_menu> a){
        int z=tablepesanan.getRowCount();
        for (int i = 0; i <z; i++) {
            tablepesanan.removeRow(0);
        }
        for (model_menu x: a){
            String nama=x.getnama();
            double harga=x.getharga();
            Object[] data={nama,harga};
            tablepesanan.addRow(data);
        }
    }
    public void addlistener(MouseListener e){
        exit.addMouseListener(e);
        simpan.addMouseListener(e);
        tambah.addMouseListener(e);
        hapus.addMouseListener(e);
    }
    public JLabel getExit() {
        return exit;
    }
    public JLabel getsimpan() {
        return simpan;
    }
    public JLabel gettambah() {
        return tambah;
    }
    public JLabel gethapus() {
        return hapus;
    }
    public int getrowmenuselected(){
        if(mastertablemenu.getSelectedRow()>-1) return mastertablemenu.getSelectedRow();
        else return -1;
    }
    public int getrowpesananselected(){
        if(mastertablemenu.getSelectedRow()>-1) return mastertablemenu.getSelectedRow();
        else return -1;
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
        simpan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        hapus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mastertablepesanan = new javax.swing.JTable();
        tambah = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mastertablemenu = new javax.swing.JTable();
        exit = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(583, 450));
        jPanel1.setLayout(null);

        simpan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        simpan.setForeground(new java.awt.Color(51, 204, 0));
        simpan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/savepesanan.png"))); // NOI18N
        simpan.setText("simpan");
        simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(simpan);
        simpan.setBounds(430, 10, 140, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("DAFTAR PESANAN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(370, 70, 140, 17);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("MENU");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 70, 50, 17);

        hapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 0));
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/delete.png"))); // NOI18N
        hapus.setText("kembali");
        hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(hapus);
        hapus.setBounds(490, 370, 90, 26);

        mastertablepesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(mastertablepesanan);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(300, 100, 270, 260);

        tambah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tambah.setForeground(new java.awt.Color(255, 255, 0));
        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tambah.png"))); // NOI18N
        tambah.setText("tambah");
        tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(tambah);
        tambah.setBounds(10, 370, 90, 25);

        mastertablemenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mastertablemenu);
        if (mastertablemenu.getColumnModel().getColumnCount() > 0) {
            mastertablemenu.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 260, 260);

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
        jLabel9.setBounds(0, 0, 583, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JLabel hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable mastertablemenu;
    private javax.swing.JTable mastertablepesanan;
    private javax.swing.JLabel simpan;
    private javax.swing.JLabel tambah;
    // End of variables declaration//GEN-END:variables
}
