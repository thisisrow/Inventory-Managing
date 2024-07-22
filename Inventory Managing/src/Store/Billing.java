/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Store;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author MANSI UMESH BARI
 */
public class Billing extends javax.swing.JFrame {
    
    Connection con;
    Statement stmt;
    ResultSet rs;
        int id=0;
        int quant=0;
        static int c = 0;
     
     public Billing() {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        LocalDateTime mydate = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E,MMM DD YYYY");
        String formattedDate = mydate.format(dtf);
        DateTimeFormatter mytime = DateTimeFormatter.ofPattern("HH:mm");
        String formattedtime = mydate.format(mytime);
        connect();
        showdata();
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
    public void showdata()
    {
        String sql="select * from product";
        try {
            rs=stmt.executeQuery(sql);
            DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getString("id"),rs.getString("name"),rs.getString("price"), rs.getString("quantity")});               
            }
            
        }  catch (Exception e) 
                 {
                 JOptionPane.showConfirmDialog(this, e);
                 }
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
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_name = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        preprice = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        product = new javax.swing.JLabel();
        searchpro = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Billing System");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 0, 180, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 10, 1340, 40);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 50, 1340, 40);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jLabel1.setText("Contact");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(260, 10, 60, 26);
        jPanel3.add(contact);
        contact.setBounds(260, 40, 190, 30);

        jLabel3.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jLabel3.setText("Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(10, 10, 60, 26);
        jPanel3.add(c_name);
        c_name.setBounds(10, 40, 210, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(480, 90, 480, 70);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jButton3.setBackground(new java.awt.Color(0, 0, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(280, 20, 75, 30);

        jButton4.setBackground(new java.awt.Color(0, 0, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Generate BIll");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(20, 20, 130, 30);

        jButton7.setBackground(new java.awt.Color(0, 0, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Print");
        jPanel4.add(jButton7);
        jButton7.setBounds(180, 20, 75, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(960, 90, 380, 70);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        add.setBackground(new java.awt.Color(0, 0, 255));
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel5.add(add);
        add.setBounds(380, 30, 75, 23);

        clear.setBackground(new java.awt.Color(255, 0, 0));
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel5.add(clear);
        clear.setBounds(380, 70, 75, 23);

        jLabel4.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jLabel4.setText("Quantity");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(20, 110, 70, 26);
        jPanel5.add(pname);
        pname.setBounds(160, 10, 200, 30);
        jPanel5.add(preprice);
        preprice.setBounds(160, 60, 200, 30);
        jPanel5.add(quantity);
        quantity.setBounds(160, 110, 200, 30);

        jLabel5.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jLabel5.setText("Product name");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(10, 10, 110, 26);

        jLabel6.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jLabel6.setText("Pre Price Quantity");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(10, 60, 140, 26);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(480, 160, 480, 150);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        product.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        product.setText("Search Product");
        jPanel6.add(product);
        product.setBounds(10, 30, 113, 26);

        searchpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchproActionPerformed(evt);
            }
        });
        jPanel6.add(searchpro);
        searchpro.setBounds(130, 30, 150, 22);

        refresh.setBackground(new java.awt.Color(0, 0, 255));
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel6.add(refresh);
        refresh.setBounds(390, 30, 75, 23);

        search.setBackground(new java.awt.Color(0, 0, 255));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel6.add(search);
        search.setBounds(300, 30, 75, 23);

        getContentPane().add(jPanel6);
        jPanel6.setBounds(0, 90, 480, 70);

        jTextArea1.setBackground(new java.awt.Color(102, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(960, 160, 380, 390);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Price", "Quantity"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(480, 310, 480, 240);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Price", "Quantity"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(0, 160, 480, 390);

        setBounds(80, 50, 1360, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        id = Integer.parseInt(model.getValueAt(jTable2.getSelectedRow(), 0).toString());
        pname.setText(model.getValueAt(jTable2.getSelectedRow(), 1).toString());
        preprice.setText(model.getValueAt(jTable2.getSelectedRow(), 2).toString());
        quant=Integer.parseInt(model.getValueAt(jTable2.getSelectedRow(),3).toString());
        quantity.setText("1");
    }//GEN-LAST:event_jTable2MouseClicked

    private void searchproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchproActionPerformed
        // TODO add your handling code here:
        try{
            if(searchpro.getText().equals("")){
                JOptionPane.showConfirmDialog(this, "Search input should be required.");
            }
            else{
                String sql = "select * from product where product like '%"+searchpro.getText()+"%'";
                
                rs = stmt.executeQuery(sql);
                 DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                while(rs.next())
                {
                    model.addRow(new Object[]{rs.getString("id"),rs.getString("name"),rs.getString("price"),rs.getString("quantity")});               
                }
            }
        }
        catch (Exception e)
        {
            }
        
    }//GEN-LAST:event_searchproActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        pname.setText("");
        preprice.setText("");
        quantity.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        if(id==0)
        {
            JOptionPane.showMessageDialog(this,"PLease select product from the list.");
        }
        else if(quantity.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Quantity is required.");
        }
        else if(Integer.parseInt(quantity.getText())>quant)
        {
            JOptionPane.showMessageDialog(this,"Your requirment is more than our quantity.");
        }
        else{
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount( c);
            model.addRow(new Object[]{id,pname.getText(),preprice.getText(),quantity.getText()});
            c++;
        }
    }//GEN-LAST:event_addActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        showdata();
    }//GEN-LAST:event_refreshActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        try{
            if(searchpro.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this,"Search input should be required");
            }
            else
            {
                String sql = "select * from product where name like '%"+searchpro.getText()+"%'";
                
                rs = stmt.executeQuery(sql);
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                while(rs.next())
                {
                    model.addRow(new Object[]{rs.getString("id"),rs.getArray("pname"),rs.getString("preprice"),rs.getString("quantity")});
                }
            }
            
        }
        catch (Exception e)
        {
            
        }
    }//GEN-LAST:event_searchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String name = c_name.getText();
        String cont = contact.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("ddHHmmss");
        SimpleDateFormat aformatter = new SimpleDateFormat("dd/MM/YYYY");
        Date date = new Date();
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
        
        if(name.equals("") || con.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Customer Name and contact are required.");
        }
        else{
            jTextArea1.append(""+
                       "Bill No. :"+formatter.format(date)+"                           Date:"+aformatter.format(date)+""+
                        "\n\n\t             \t"+
                        "\n\n--------------------------------------------------"+
                        "\n Phone No.:9876543210                            Palghar-401404"+
                        "\n----------------------------------------------------"+
                        "\n Customer Name:"+name+"                            "+
                        "\nPhone Number: "+cont+"                           "+
                        "\n----------------------------------------------------"+
                        "\nProduct Name                        Quantity                Price"+
                        "\n----------------------------------------------------"+
                    
                        "\n"
                    );
            
        int price=0;
        for(int i=0;i<jTable1.getRowCount();i++)
        {
            int id=Integer.parseInt(jTable1.getValueAt(i, 0).toString());
            String pname=jTable1.getValueAt(i, 1).toString();
            double preprice = Double.parseDouble(jTable1.getValueAt(i, 2).toString());
            int quantity =Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            double pq;
        
            String sql ="update product set quantity="+quant+" where id = "+id+"";
            
            try
            {
                stmt.executeUpdate(sql);
                showdata();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e);
            }
            if(quant>1)
            {
                pq = preprice*quantity;
                jTextArea1.setText(jTextArea1.getText()+pname+"\t\t "+quantity+"\t  "+pq+"\n"); 
            }
            else
            {
                pq=preprice;
                jTextArea1.setText(jTextArea1.getText()+pname+"\t\t "+quantity+"\t  "+price+"\n"); 
            }
                
            price+=pq;
        }
        
    jTextArea1.setText(jTextArea1.getText()+"\n-------------------------------------------------------");
    jTextArea1.setText(jTextArea1.getText()+"\n-------------------------------------------------------");
    
    jTextArea1.setText(jTextArea1.getText()+"\n     Total Amount\t\t\t      "+price+"");
        }
        c_name.setText("");
        contact.setText("");
        pname.setText("");
        quantity.setText("");
        preprice.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        c_name.setText("");
        contact.setText("");
        pname.setText("");
        quantity.setText("");
        preprice.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField c_name;
    private javax.swing.JButton clear;
    private javax.swing.JTextField contact;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField preprice;
    private javax.swing.JLabel product;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton refresh;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchpro;
    // End of variables declaration//GEN-END:variables
}