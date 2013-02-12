/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormMusic.java
 *
 * Created on Feb 12, 2013, 7:18:31 PM
 */
package musicplayer;

import javax.swing.*;
import java.io.*;
import javazoom.jl.player.Player;
import javax.swing.UIManager.*;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author VIQRI
 */
public class FormMusic extends javax.swing.JFrame {

        private ArrayList<Lagu> lsLagu = new ArrayList<Lagu>();
        private DefaultListModel dfm = new DefaultListModel();
        private MyConnection myCon = null;
        private Lagu selectedLagu = null;
        private DefaultTableModel tbModel = null;
        
	private JFileChooser fc = new JFileChooser();
	private String url, url1;
	private File file;
	private FileInputStream fis;
	private Player player;
    
        
    /** Creates new form FormMusic */
    public FormMusic() {
        myCon = new MyConnection();
        initComponents();
        init();
        refreshLagu();
        refreshLaguOnTable();
    }

    public void init(){
        tbModel = new DefaultTableModel();

        tbModel.addColumn("Nama Lagu");
        tbModel.addColumn("Lokasi Lagu");

        tbLagu.setModel(tbModel);
    }
    
    private void refreshLagu(){
        dfm.removeAllElements();
        lsLagu = myCon.findAllLagu();

        for (Iterator<Lagu> it = lsLagu.iterator(); it.hasNext();) {
            Lagu Lagu = it.next();
            dfm.addElement(Lagu.getNamaLagu());
        }
    }
    
    private void refreshLaguOnTable(){
        if(tbModel.getRowCount() > 0){
            for (int i=0;i<=tbModel.getRowCount();i++){
                tbModel.removeRow(i);
            }
        }
            for (Iterator<Lagu> it = lsLagu.iterator(); it.hasNext();) {
                Lagu Lagu = it.next();
                tbModel.addRow(new String[] {
                    Lagu.getNamaLagu(),
                    Lagu.getAlamatLagu(),
                });
            }
    }
    
    private void refreshDetailLagu(){
        if(selectedLagu != null){
            try
            {
                url = selectedLagu.getAlamatLagu();
                lblAlamat.setText(selectedLagu.getNamaLagu());
                file = new File(url);
                fis = new FileInputStream(file);
                player = new Player(fis);
            }
        catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this,"File tidak dapat diputar");
                lblAlamat.setText("");
            }
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        lblAlamat = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLagu = new javax.swing.JTable();
        btnBuka = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        btnPlay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnPlayKeyReleased(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        lblAlamat.setText("- - - -");

        jLabel4.setText("Memutar :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStop)
                    .addComponent(lblAlamat))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblAlamat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStop)
                    .addComponent(btnPlay))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbLagu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbLagu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbLaguMousePressed(evt);
            }
        });
        tbLagu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbLaguPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbLagu);

        btnBuka.setText("Tambah File");
        btnBuka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBukaActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnBuka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Simple MP3 Player");

        jLabel2.setText("Author : 6309030 - Fiqri Ahmad F");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnBukaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBukaActionPerformed
    fc.setCurrentDirectory(new File(""));
    int a = fc.showOpenDialog(null);
    
    if(a == JFileChooser.APPROVE_OPTION)
        {
	try
            {
                url = fc.getSelectedFile().getPath();
                url1 = fc.getSelectedFile().getName();
                
                Lagu m = new Lagu();
            
                m.setNamaLagu(url1);
                m.setAlamatLagu(url);
                
                myCon.insertLagu(m);
                
                init();
                refreshLagu();
                refreshLaguOnTable();
                refreshDetailLagu();
            }
        catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this,"File tidak dapat diputar");
                lblAlamat.setText("");
            }
        }
}//GEN-LAST:event_btnBukaActionPerformed

private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
    
    // run in new thread to play in background
    new Thread() {
        @Override
        public void run() {
            try {
                player.play();
            }
            catch (Exception e) 
            { 
                System.out.println(e);
            }
        }
    }.start();
}//GEN-LAST:event_btnPlayActionPerformed

private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
    try
	{
            player.close();
        }
    catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
}//GEN-LAST:event_btnStopActionPerformed

private void btnPlayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPlayKeyReleased
    
}//GEN-LAST:event_btnPlayKeyReleased

private void tbLaguPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbLaguPropertyChange
    // TODO add your handling code here:
}//GEN-LAST:event_tbLaguPropertyChange

private void tbLaguMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLaguMousePressed
    if(tbLagu.getSelectedRow() >= 0){
            selectedLagu = lsLagu.get(tbLagu.getSelectedRow());
        }
        refreshDetailLagu();
}//GEN-LAST:event_tbLaguMousePressed

private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
    if(selectedLagu != null){
            myCon.deleteLagu(selectedLagu);
            selectedLagu = null;
            
            init();
            refreshLagu();
            refreshLaguOnTable();
        }
}//GEN-LAST:event_btnHapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMusic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormMusic().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuka;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JTable tbLagu;
    // End of variables declaration//GEN-END:variables
}
