/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import controller.ThreadController;

/**
 *
 * @author Yelson
 */
public class GraphicInterface extends javax.swing.JFrame {

    private boolean check;
    private ThreadController controller;
    
    public GraphicInterface() {
        initComponents();
        controller = new ThreadController();
        trackView1.create();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trackView1 = new view.TrackView();
        jLabel2 = new javax.swing.JLabel();
        cmbSpeed = new javax.swing.JComboBox<>();
        btnSimulation = new javax.swing.JButton();
        btnInterrupt = new javax.swing.JButton();
        btnRevert = new javax.swing.JButton();
        jbtBarrier = new javax.swing.JToggleButton();
        cbxImages = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        txtBarrier = new javax.swing.JTextField();
        txtValue = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout trackView1Layout = new javax.swing.GroupLayout(trackView1);
        trackView1.setLayout(trackView1Layout);
        trackView1Layout.setHorizontalGroup(
            trackView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        trackView1Layout.setVerticalGroup(
            trackView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );

        jLabel2.setText("Value:");

        cmbSpeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Speed 3", "Speed 2", "Speed 1" }));

        btnSimulation.setText("Simulation");
        btnSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimulationActionPerformed(evt);
            }
        });

        btnInterrupt.setText("Interrupt");
        btnInterrupt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInterruptActionPerformed(evt);
            }
        });

        btnRevert.setText("Revert");
        btnRevert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevertActionPerformed(evt);
            }
        });

        jbtBarrier.setText("Activate");
        jbtBarrier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBarrierActionPerformed(evt);
            }
        });

        cbxImages.setText("Images");
        cbxImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxImagesActionPerformed(evt);
            }
        });

        jLabel3.setText("Barrier:");

        txtValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValueActionPerformed(evt);
            }
        });

        btnCreate.setText("Create Runners");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(trackView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtBarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInterrupt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(btnRevert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxImages)
                    .addComponent(btnSimulation))
                .addGap(28, 28, 28))
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(trackView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBarrier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnRevert)
                    .addComponent(cbxImages))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBarrier)
                    .addComponent(btnInterrupt)
                    .addComponent(btnSimulation))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtBarrierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBarrierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtBarrierActionPerformed

    private void cbxImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxImagesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxImagesActionPerformed

    private void txtValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValueActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        controller.insertRunners(Integer.parseInt(this.txtValue.getText()), cmbSpeed.getSelectedIndex()+1);
        controller.start();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnInterruptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterruptActionPerformed
        trackView1.interrput();
    }//GEN-LAST:event_btnInterruptActionPerformed

    private void btnRevertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevertActionPerformed
        controller.revert();
    }//GEN-LAST:event_btnRevertActionPerformed

    private void btnSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimulationActionPerformed
        // TODO add your handling code here:
        trackView1.continueThread();
    }//GEN-LAST:event_btnSimulationActionPerformed

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
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnInterrupt;
    private javax.swing.JButton btnRevert;
    private javax.swing.JButton btnSimulation;
    private javax.swing.JCheckBox cbxImages;
    private javax.swing.JComboBox<String> cmbSpeed;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton jbtBarrier;
    private view.TrackView trackView1;
    private javax.swing.JTextField txtBarrier;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
