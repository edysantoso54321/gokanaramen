/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main(String x) {
        initComponents();
        user.setText(x);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screensize.width / 2) - (getSize().width / 2), (screensize.height / 2) - (getSize().height / 2));
    }

    public JLabel getExit() {
        return exit;
    }

    public JLabel getkirimpesan() {
        return kirimpesan;
    }

    public JLabel getpesansekarang() {
        return pesansekarang;
    }

    public JLabel getlihatpesanan() {
        return lihatpesanan;
    }

    public JLabel getlihatmenu() {
        return lihatmenu;
    }
    public void addlistener(MouseListener e){
        exit.addMouseListener(e);
        lihatmenu.addMouseListener(e);
        lihatpesanan.addMouseListener(e);
        kirimpesan.addMouseListener(e);
        pesansekarang.addMouseListener(e);
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
        pesansekarang = new javax.swing.JLabel();
        lihatpesanan = new javax.swing.JLabel();
        lihatmenu = new javax.swing.JLabel();
        kirimpesan = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(583, 400));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(583, 300));
        jPanel1.setLayout(null);

        pesansekarang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        pesansekarang.setForeground(new java.awt.Color(255, 255, 0));
        pesansekarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pesanan.png"))); // NOI18N
        pesansekarang.setText("PESAN SEKARANG");
        pesansekarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(pesansekarang);
        pesansekarang.setBounds(160, 150, 290, 45);

        lihatpesanan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lihatpesanan.setForeground(new java.awt.Color(255, 255, 0));
        lihatpesanan.setIcon(new javax.swing.ImageIcon("E:\\tubes\\src\\gambar\\menu.png")); // NOI18N
        lihatpesanan.setText("LIHAT PESANAN");
        lihatpesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lihatpesanan);
        lihatpesanan.setBounds(160, 220, 270, 45);

        lihatmenu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lihatmenu.setForeground(new java.awt.Color(255, 255, 0));
        lihatmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pesan.png"))); // NOI18N
        lihatmenu.setText("LIHAT MENU");
        lihatmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lihatmenu);
        lihatmenu.setBounds(160, 80, 209, 50);

        kirimpesan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        kirimpesan.setForeground(new java.awt.Color(255, 255, 0));
        kirimpesan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mesage.png"))); // NOI18N
        kirimpesan.setText("KIRIM PESAN KE ADMIN");
        kirimpesan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(kirimpesan);
        kirimpesan.setBounds(160, 290, 370, 45);

        user.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        user.setForeground(new java.awt.Color(51, 204, 0));
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icon.png"))); // NOI18N
        jPanel1.add(user);
        user.setBounds(10, 13, 213, 48);

        exit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exit.setForeground(new java.awt.Color(51, 204, 0));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logout.png"))); // NOI18N
        exit.setText("EXIT");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(exit);
        exit.setBounds(446, 13, 112, 35);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/backgroundmain.jpg"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(583, 390));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 0, 583, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel kirimpesan;
    private javax.swing.JLabel lihatmenu;
    private javax.swing.JLabel lihatpesanan;
    private javax.swing.JLabel pesansekarang;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
