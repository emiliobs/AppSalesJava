
package Forms;

import Classes.Response;
import Classes.User;
import Classes.UserDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmUser extends javax.swing.JInternalFrame {

  private  DefaultTableModel model;
  
    public frmUser() {
        initComponents();
        
        this.fillTable();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Users");

        btnNewUser.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNewUser.setText("New User.");
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUser);

        btnEdit.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewUser)
                        .addGap(38, 38, 38)
                        .addComponent(btnEdit)
                        .addGap(39, 39, 39)
                        .addComponent(btnDelete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewUser)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUserActionPerformed
        //forma de abrir un formulario modal:
        FrmNewUser form = new FrmNewUser(null, closable);
        //aqui lo centro
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        
        User user = form.getUser();
        
        if (user == null)
        {
            return;
        }     
        
          Response response = UserDAO.Create(user);
        
        if (response.isSucced())
        {
            JOptionPane.showMessageDialog(rootPane, "User create Successfully.");
           this.fillTable();
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "ERROR: " + response.getMessage());
        }
      
    }//GEN-LAST:event_btnNewUserActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
      
        //si es igual a -1 es que no han seleccionado nada:
        if (tblUser.getSelectedRow() == -1) 
        {
            JOptionPane.showMessageDialog(this , "You muist select a record to Edit.");
            return;
        }
        
        String email = tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 0).toString();
        
        User user = UserDAO.getEmail(email);
        
        FrmEdit form = new FrmEdit(null, true);
        form.setLocationRelativeTo(null);
        form.setUser(user);
        form.setVisible(true);
        
       Response respponse =  UserDAO.Update(form.getUser());
       
        if (respponse.isSucced())
        {
            JOptionPane.showMessageDialog(rootPane, "User Edit Successfully.");
            this.fillTable();
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "ERROR: " + respponse.getMessage());
        }
        
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        if (tblUser.getSelectedRow() == -1) 
        {
            JOptionPane.showMessageDialog(rootPane,"You must selecct a Record to Delete.");
            
            return;
        }
        
        int rta = JOptionPane.showConfirmDialog(this, "Are you sure to Delete this record", 
                                                                                    "Delete confirmation", JOptionPane.YES_OPTION);
        
        if (rta != JOptionPane.YES_OPTION)
        {
            return;
        }
        
        String email = tblUser.getModel().getValueAt(tblUser.getSelectedRow(), 0).toString();
        
        Response response = UserDAO.Delete(email);
        
        if (response.isSucced()) 
        {
            JOptionPane.showMessageDialog(rootPane, "User Delete Successfully.");
            this.fillTable();
        }
        else
        {
             JOptionPane.showMessageDialog(rootPane, "ERROR." + response.getMessage());
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables

    private void fillTable()
    {
        ArrayList<User> users = UserDAO.get();
        
        String colunms[] = {"E-Mail", "First Name", "Last Name"};
        this.model = new DefaultTableModel(colunms, 0);
        tblUser.setModel(model);
        
        for (User user  : users)
        {
                Object[] row = 
                {
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName()
                };
                
                this.model.addRow(row);
        }
    }
}
