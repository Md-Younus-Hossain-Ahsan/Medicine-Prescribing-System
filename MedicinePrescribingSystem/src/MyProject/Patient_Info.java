package MyProject;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.logging.*;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Patient_Info extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    public Patient_Info() {
        
        initComponents();        
        All_View();
    }
    
    public void All_View(){
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Patient";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            PatientInfo.setModel(new DefaultTableModel(null, new String[] {"Patient ID","Name","Age","Gender","Mobile Number"}));

            while (res.next()) {

                String tbData[] = {Integer.toString(res.getInt("Patient_id")),
                                   res.getString("Name"),
                                   Integer.toString(res.getInt("Age")),
                                   res.getString("Gender"),
                                   res.getString("Mobile_Number")};

                DefaultTableModel tbModel = (DefaultTableModel) PatientInfo.getModel();
                tbModel.addRow(tbData);

            }
            Reset();
        } catch (SQLException e) {
            System.out.println(e);
        }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Patient_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Reset(){
        PatientID.setText("");
        Name.setText("");
        MobileNumber.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        PatientInfo = new javax.swing.JTable();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        Name = new javax.swing.JTextField();
        PatientID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        MobileNumber = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        All_View = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PatientInfo.setBackground(new java.awt.Color(232, 245, 253));
        PatientInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PatientInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Name", "Age", "Gender", "Mobile Number"
            }
        ));
        PatientInfo.setToolTipText("");
        PatientInfo.setName(""); // NOI18N
        PatientInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(PatientInfo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 810, 230));

        jSeparator8.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 170, 10));

        jSeparator9.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 300, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 110, 10));

        Name.setBackground(new java.awt.Color(232, 245, 253));
        Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Name.setBorder(null);
        Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameMouseClicked(evt);
            }
        });
        Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NameKeyTyped(evt);
            }
        });
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 300, 30));

        PatientID.setBackground(new java.awt.Color(232, 245, 253));
        PatientID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PatientID.setBorder(null);
        PatientID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientIDMouseClicked(evt);
            }
        });
        PatientID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PatientIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PatientIDKeyTyped(evt);
            }
        });
        getContentPane().add(PatientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 110, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Patient ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Name");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 90, 20));

        MobileNumber.setBackground(new java.awt.Color(232, 245, 253));
        MobileNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MobileNumber.setBorder(null);
        MobileNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MobileNumberMouseClicked(evt);
            }
        });
        MobileNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MobileNumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MobileNumberKeyTyped(evt);
            }
        });
        getContentPane().add(MobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 170, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Mobile Number");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, 20));

        All_View.setBackground(new java.awt.Color(232, 245, 253));
        All_View.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        All_View.setText("All View");
        All_View.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        All_View.setContentAreaFilled(false);
        All_View.setOpaque(true);
        All_View.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                All_ViewMouseMoved(evt);
            }
        });
        All_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_ViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                All_ViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                All_ViewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                All_ViewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                All_ViewMouseReleased(evt);
            }
        });
        All_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                All_ViewActionPerformed(evt);
            }
        });
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 120, 30));

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/+.png"))); // NOI18N
        jLabel4.setText(" Patient Information ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        Close.setBackground(new java.awt.Color(232, 245, 253));
        Close.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Close.setText("Close");
        Close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Close.setContentAreaFilled(false);
        Close.setOpaque(true);
        Close.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CloseMouseMoved(evt);
            }
        });
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CloseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CloseMouseReleased(evt);
            }
        });
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 130, 40));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg1.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PatientInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientInfoMouseClicked
        int i = PatientInfo.getSelectedRow();
        TableModel model = PatientInfo.getModel();
        
        PatientID.setText((String) model.getValueAt(i, 0));
        Name.setText((String) model.getValueAt(i, 1));
        MobileNumber.setText((String) model.getValueAt(i, 4));
    }//GEN-LAST:event_PatientInfoMouseClicked
    
    
    private void PatientIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientIDMouseClicked
        // TODO add your handling code here:
        All_View();
        Reset();
    }//GEN-LAST:event_PatientIDMouseClicked

    private void NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMouseClicked
        All_View();
        Reset();
    }//GEN-LAST:event_NameMouseClicked

    private void PatientIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PatientIDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_PatientIDKeyTyped

    private void NameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyTyped
             
    }//GEN-LAST:event_NameKeyTyped

    private void NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyPressed
        
    }//GEN-LAST:event_NameKeyPressed

    private void NameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyReleased
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "SELECT * FROM Patient WHERE Name LIKE '" + Name.getText() + "%'";
                    
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                PatientInfo.setModel(new DefaultTableModel(null, new String[] {"Patient ID","Name","Age","Gender","Mobile Number"}));

                while (res.next()) {

                    String tbData[] = {Integer.toString(res.getInt("Patient_id")),
                                       res.getString("Name"),
                                       Integer.toString(res.getInt("Age")),
                                       res.getString("Gender"),
                                       res.getString("Mobile_Number")};

                    DefaultTableModel tbModel = (DefaultTableModel) PatientInfo.getModel();
                    tbModel.addRow(tbData);

                }
                
            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {Logger.getLogger(Patient_Info.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_NameKeyReleased

    private void PatientIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PatientIDKeyReleased
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = null;
                
                if(PatientID.getText().trim().equals(""))
                    All_View();
                else{
                    try{
                        sql = "SELECT * FROM Patient WHERE Patient_id LIKE '" + Integer.valueOf(PatientID.getText()) + "%'";
                    }catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Invalid !!!"); PatientID.setText("");}
                }
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                PatientInfo.setModel(new DefaultTableModel(null, new String[] {"Patient ID","Name","Age","Gender","Mobile Number"}));

                while (res.next()) {

                    String tbData[] = {Integer.toString(res.getInt("Patient_id")),
                                       res.getString("Name"),
                                       Integer.toString(res.getInt("Age")),
                                       res.getString("Gender"),
                                       res.getString("Mobile_Number")};

                    DefaultTableModel tbModel = (DefaultTableModel) PatientInfo.getModel();
                    tbModel.addRow(tbData);

                }
                
            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {Logger.getLogger(Patient_Info.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_PatientIDKeyReleased

    private void MobileNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MobileNumberMouseClicked
        All_View();
        Reset();
    }//GEN-LAST:event_MobileNumberMouseClicked

    private void MobileNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNumberKeyReleased
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = null;
                
                if(MobileNumber.getText().trim().equals(""))
                    All_View();
                else{
                    try{
                        sql = "SELECT * FROM Patient WHERE Mobile_Number LIKE '" + MobileNumber.getText() + "%'";
                    }catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Invalid !!!"); MobileNumber.setText("");}
                }
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                PatientInfo.setModel(new DefaultTableModel(null, new String[] {"Patient ID","Name","Age","Gender","Mobile Number"}));

                while (res.next()) {

                    String tbData[] = {Integer.toString(res.getInt("Patient_id")),
                                       res.getString("Name"),
                                       Integer.toString(res.getInt("Age")),
                                       res.getString("Gender"),
                                       res.getString("Mobile_Number")};

                    DefaultTableModel tbModel = (DefaultTableModel) PatientInfo.getModel();
                    tbModel.addRow(tbData);

                }
                
            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {Logger.getLogger(Patient_Info.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_MobileNumberKeyReleased

    private void MobileNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNumberKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_MobileNumberKeyTyped

    private void CloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseMoved
        Close.setCursor(SignIN.cursor);
    }//GEN-LAST:event_CloseMouseMoved

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        Close.setBackground(new Color(0,0,255).brighter());
        Close.setForeground(Color.WHITE);
    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        Close.setBackground(new Color(0,153,255).brighter());
        Close.setForeground(Color.BLACK);
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        Close.setBackground(new Color(232,245,253));
        Close.setForeground(Color.BLACK);
    }//GEN-LAST:event_CloseMouseExited

    private void CloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMousePressed
        Close.setBackground(new Color(0,0,255).brighter());
        Close.setForeground(Color.WHITE);
    }//GEN-LAST:event_CloseMousePressed

    private void CloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseReleased
        Close.setBackground(new Color(232,245,253));
        Close.setForeground(Color.BLACK);
    }//GEN-LAST:event_CloseMouseReleased

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(SignIN.cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

    private void All_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseClicked
        All_View.setBackground(new Color(0,0,255).brighter());
        All_View.setForeground(Color.WHITE);
    }//GEN-LAST:event_All_ViewMouseClicked

    private void All_ViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseEntered
        All_View.setBackground(new Color(0,153,255).brighter());
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseEntered

    private void All_ViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseExited
        All_View.setBackground(new Color(232,245,253));
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseExited

    private void All_ViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMousePressed
        All_View.setBackground(new Color(0,0,255).brighter());
        All_View.setForeground(Color.WHITE);
    }//GEN-LAST:event_All_ViewMousePressed

    private void All_ViewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseReleased
        All_View.setBackground(new Color(232,245,253));
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseReleased

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        All_View();
        Reset();
    }//GEN-LAST:event_All_ViewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Patient_Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton All_View;
    private javax.swing.JButton Close;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField MobileNumber;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField PatientID;
    private javax.swing.JTable PatientInfo;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables

    private String getString(String fromInput) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void TicketGenerate(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getText(String format) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}