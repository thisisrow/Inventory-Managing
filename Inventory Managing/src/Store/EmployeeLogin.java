/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Store;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MANSI UMESH BARI
 */
public class EmployeeLogin extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeLogin
     */
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    public EmployeeLogin() {
        initComponents();
        connect();
    }
    
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/luffystore","root", "root");
             stmt = con.createStatement();

            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/adminlogin.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Employee Login form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 420, 170);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel9.setText("Password");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(40, 340, 86, 26);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(40, 380, 340, 40);

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel10.setText("Username");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(40, 220, 88, 26);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(40, 260, 340, 40);

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel);
        cancel.setBounds(230, 450, 120, 40);

        login.setBackground(new java.awt.Color(51, 51, 255));
        login.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel2.add(login);
        login.setBounds(70, 450, 120, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(70, 20, 420, 530);

        setSize(new java.awt.Dimension(581, 590));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        String uname = jTextField2.getText();
        String paswo = jTextField1.getText();
        
        String sql = "select * from employee";
        
        int i=0;
        try{
        
             rs=stmt.executeQuery(sql);
             while(rs.next())
             {
                 if(uname.equals(rs.getString("name")))
                     //if(uname.equals(rs.getString("email")))
                 {
                     if(paswo.equals(rs.getString("password")))
                     {
                         i++;
                         if(i==1)
                         {
                             JOptionPane.showMessageDialog(this,"Login Successfull");
                             DashboardAd db = new DashboardAd();
                             db.setVisible(true);
                             this.dispose();
                         }
                         else{
                              JOptionPane.showMessageDialog(this,"Something went wrong");
                         }
                     }
                     else{
                             JOptionPane.showMessageDialog(this,"Password does not match.");
                     }
                 }
             }   
        }catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
    }                                     

   /* private void cancelActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        Usertype ut = new Usertype();
        ut.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginActionPerformed
*/
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
         Usertype ut = new Usertype();
        ut.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton login;
    // End of variables declaration//GEN-END:variables
}
