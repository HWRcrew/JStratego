/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.gui.game;

import javax.swing.text.BadLocationException;
import jstratego.logic.game.Game;

/**
 *
 * @author Tim
 */
public class StartScreen extends javax.swing.JFrame {

    /**
     * Creates new form StartScreen
     */
    public StartScreen() {
        this.setContentPane(new BackgroundPanelStart());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        labelInfo1 = new javax.swing.JLabel();
        labelInfo2 = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        txtRed = new javax.swing.JTextField();
        txtBlue = new javax.swing.JTextField();
        labelInfo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("startFrame");
        setPreferredSize(new java.awt.Dimension(750, 700));
        setResizable(false);

        panelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panelMain.setOpaque(false);
        panelMain.setPreferredSize(new java.awt.Dimension(245, 700));

        labelInfo1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelInfo1.setText("Spieler Rot:");

        labelInfo2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        labelInfo2.setText("Spieler Blau:");

        buttonStart.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        buttonStart.setText("Neues Spiel starten");
        buttonStart.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonStart.setEnabled(false);
        buttonStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonStartMouseClicked(evt);
            }
        });

        txtRed.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRedActionPerformed(evt);
            }
        });
        txtRed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRedKeyTyped(evt);
            }
        });

        txtBlue.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBlueActionPerformed(evt);
            }
        });
        txtBlue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBlueKeyTyped(evt);
            }
        });

        labelInfo3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        labelInfo3.setText("Herzlich Willkommen!");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelMainLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(labelInfo2))
                        .addComponent(buttonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBlue)
                        .addComponent(txtRed)
                        .addComponent(labelInfo3))
                    .addComponent(labelInfo1))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInfo3)
                .addGap(18, 18, 18)
                .addComponent(labelInfo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelInfo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(501, Short.MAX_VALUE)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRedKeyTyped
        buttonStart.setEnabled(true);
        if (txtRed.getText().length() >= 30) {
            try {
                txtRed.setText(txtRed.getText(0, 29));

            } catch (BadLocationException ex) {
            }
        }
        if (!txtRed.getText().isEmpty() && !txtBlue.getText().isEmpty()) {
            buttonStart.setEnabled(true);
        } else {
            buttonStart.setEnabled(false);
        }
    }//GEN-LAST:event_txtRedKeyTyped

    private void txtBlueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBlueKeyTyped
        buttonStart.setEnabled(true);
        if (txtBlue.getText().length() >= 30) {
            try {
                txtBlue.setText(txtBlue.getText(0, 29));
            } catch (BadLocationException ex) {
            }
        }
        if (!txtRed.getText().isEmpty() && !txtBlue.getText().isEmpty()) {
            buttonStart.setEnabled(true);
        } else {
            buttonStart.setEnabled(false);
        }
    }//GEN-LAST:event_txtBlueKeyTyped

    private void buttonStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStartMouseClicked
        Game game = new Game(txtRed.getText(), txtBlue.getText());
        jstratego.gui.game.PlayBoard.main(game);
        setVisible(false);
    }//GEN-LAST:event_buttonStartMouseClicked

	private void txtRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRedActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtRedActionPerformed

	private void txtBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBlueActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtBlueActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new StartScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel labelInfo1;
    private javax.swing.JLabel labelInfo2;
    private javax.swing.JLabel labelInfo3;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTextField txtBlue;
    private javax.swing.JTextField txtRed;
    // End of variables declaration//GEN-END:variables
}
