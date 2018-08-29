/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Simulator;
import java.awt.Graphics;
import controller.ThreadController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Yelson
 */
public class GraphicInterface extends javax.swing.JFrame {

    private ThreadController controller;
    private boolean checkStatus;
    private boolean interruptStatus;
    private boolean simulate;
    private Simulator simulator;
    private Timer updaterTimer; 
    private TimerTask timerTask;
    
    public GraphicInterface() {
        initComponents();
        checkStatus = false;
        simulate = false;
        interruptStatus = true;
        simulator = new Simulator();
        controller = ThreadController.getInstace();
        trackView1.create();
        controller.start();
        simulator.start();
        simulator.suspend();
        updaterTimer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                lblSpeed3.setText("" + controller.getThreadPool()[0].getCreatedQuantity());
                lblSpeed2.setText("" + controller.getThreadPool()[1].getCreatedQuantity());
                lblSpeed1.setText("" + controller.getThreadPool()[2].getCreatedQuantity());
            }
        };
        updaterTimer.schedule(timerTask, 0, 100);
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
        cbxImages = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        txtBarrier = new javax.swing.JTextField();
        txtValue = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnAllBarriers = new javax.swing.JButton();
        btnBarries = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSpeed1 = new javax.swing.JLabel();
        lblSpeed2 = new javax.swing.JLabel();
        lblSpeed3 = new javax.swing.JLabel();

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

        btnAllBarriers.setText("Deactivate All Barriers");
        btnAllBarriers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllBarriersActionPerformed(evt);
            }
        });

        btnBarries.setText("Activate");
        btnBarries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarriesActionPerformed(evt);
            }
        });

        jLabel1.setText("Speed 1:");

        jLabel4.setText("Speed 2:");

        jLabel5.setText("Speed 3:");

        lblSpeed1.setText("0");

        lblSpeed2.setText("0");

        lblSpeed3.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBarrier, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBarries, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAllBarriers, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRevert, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInterrupt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxImages)
                    .addComponent(btnSimulation, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSpeed2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSpeed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSpeed3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addComponent(trackView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(trackView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBarrier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(btnRevert)
                                .addComponent(btnBarries))
                            .addComponent(cbxImages, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnInterrupt)
                            .addComponent(btnSimulation)
                            .addComponent(btnAllBarriers)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSpeed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblSpeed2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblSpeed3))))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtBarrierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBarrierActionPerformed

    }//GEN-LAST:event_jbtBarrierActionPerformed

    private void cbxImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxImagesActionPerformed
        checkStatus = !checkStatus;
        controller.setShowImages(checkStatus);
        controller.changeImageStatus(checkStatus);
    }//GEN-LAST:event_cbxImagesActionPerformed

    private void txtValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValueActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        controller.createThreads(Integer.parseInt(this.txtValue.getText()), cmbSpeed.getSelectedIndex()+1);
        txtValue.setText("");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnInterruptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterruptActionPerformed
        if(interruptStatus){
            btnInterrupt.setText("Continue");
        }else{
            btnInterrupt.setText("Interrupt");
        }
        interruptStatus = !interruptStatus;
        controller.stateThread();
    }//GEN-LAST:event_btnInterruptActionPerformed

    private void btnRevertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevertActionPerformed
        controller.revert();
    }//GEN-LAST:event_btnRevertActionPerformed

    private void btnSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimulationActionPerformed
        simulate = !simulate;
        if(simulate){
            simulator.resume();
            btnSimulation.setText("Stop");
        }else{
            simulator.suspend();
            btnSimulation.setText("Simulate");
        }
    }//GEN-LAST:event_btnSimulationActionPerformed

    private void btnBarriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarriesActionPerformed
        String barriers = txtBarrier.getText();
        if(barriers.equals("")){
            controller.getTrack().activateAllBarriers();
        }else{
            String barrierList[] = barriers.split(",");
            for(int i = 0; i < barrierList.length; i++){
                int lane = Integer.parseInt(barrierList[i]);
               controller.getTrack().activateBarrier(lane-1);
            }
        }
        txtBarrier.setText("");
    }//GEN-LAST:event_btnBarriesActionPerformed

    private void btnAllBarriersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllBarriersActionPerformed
        controller.getTrack().deactivateAllBarriers();
    }//GEN-LAST:event_btnAllBarriersActionPerformed

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
    private javax.swing.JButton btnAllBarriers;
    private javax.swing.JButton btnBarries;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnInterrupt;
    private javax.swing.JButton btnRevert;
    private javax.swing.JButton btnSimulation;
    private javax.swing.JCheckBox cbxImages;
    private javax.swing.JComboBox<String> cmbSpeed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblSpeed1;
    private javax.swing.JLabel lblSpeed2;
    private javax.swing.JLabel lblSpeed3;
    private view.TrackView trackView1;
    private javax.swing.JTextField txtBarrier;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
