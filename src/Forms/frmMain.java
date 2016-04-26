/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Classes.User;

/**
 *
 * @author Emilio
 */
public class frmMain extends javax.swing.JFrame {
    
    private  User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
    
    
    

    /**
     * Creates new form frmMain
     */
    public frmMain() {
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

        dpnMAin = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuCustomers = new javax.swing.JMenuItem();
        mnuProducts = new javax.swing.JMenuItem();
        mnuSupplier = new javax.swing.JMenuItem();
        mnuUsers = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuSingOut = new javax.swing.JMenuItem();
        mnuMovements = new javax.swing.JMenu();
        mnuPurchases = new javax.swing.JMenuItem();
        mnuSales = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dpnMAin.setBackground(new java.awt.Color(255, 0, 0));
        dpnMAin.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout dpnMAinLayout = new javax.swing.GroupLayout(dpnMAin);
        dpnMAin.setLayout(dpnMAinLayout);
        dpnMAinLayout.setHorizontalGroup(
            dpnMAinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1319, Short.MAX_VALUE)
        );
        dpnMAinLayout.setVerticalGroup(
            dpnMAinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );

        mnuFile.setText("File");

        mnuCustomers.setText("Customers");
        mnuFile.add(mnuCustomers);

        mnuProducts.setText("Products");
        mnuFile.add(mnuProducts);

        mnuSupplier.setText("Suppliers");
        mnuFile.add(mnuSupplier);

        mnuUsers.setText("Users");
        mnuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsersActionPerformed(evt);
            }
        });
        mnuFile.add(mnuUsers);
        mnuFile.add(jSeparator1);

        mnuSingOut.setText("Sing Out");
        mnuSingOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSingOutActionPerformed(evt);
            }
        });
        mnuFile.add(mnuSingOut);

        jMenuBar1.add(mnuFile);

        mnuMovements.setText("Movement");

        mnuPurchases.setText("Purcharses");
        mnuMovements.add(mnuPurchases);

        mnuSales.setText("Sales");
        mnuMovements.add(mnuSales);

        jMenuBar1.add(mnuMovements);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dpnMAin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnMAin)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSingOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSingOutActionPerformed
        this.dispose();
//        System.exit(0);
    }//GEN-LAST:event_mnuSingOutActionPerformed

    private void mnuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsersActionPerformed
       frmUser form = new frmUser();
       this.dpnMAin.add(form);
       form.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuUsersActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpnMAin;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuCustomers;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuMovements;
    private javax.swing.JMenuItem mnuProducts;
    private javax.swing.JMenuItem mnuPurchases;
    private javax.swing.JMenuItem mnuSales;
    private javax.swing.JMenuItem mnuSingOut;
    private javax.swing.JMenuItem mnuSupplier;
    private javax.swing.JMenuItem mnuUsers;
    // End of variables declaration//GEN-END:variables
}
