/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyProject;

import JClasses.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Chamber_Info extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
        
    int ID = 0;
    int Last_Chamber_id = 0;
    
    public Chamber_Info() throws ClassNotFoundException{
        initComponents();
        All_View();
    }
    
    
    public void All_View() throws ClassNotFoundException{
        
        Chamber new_chamber = new Chamber();
        new_chamber.Last_ID();
        Last_Chamber_id = new_chamber.getLast_Chamber_id();   
        Chamber_ID.setText(Integer.toString(++Last_Chamber_id));
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Chamber";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            PrescriptionList.setModel(new DefaultTableModel(null, new String[] {"Chamber ID", "Name"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("Chamber_id")),
                                   res.getString("Name")};
                DefaultTableModel tbModel = (DefaultTableModel) PrescriptionList.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prescription_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
    public void reset() throws ClassNotFoundException {
    
        Chamber_ID.setText("");
        Email.setText("");
        Name.setText("");
        Location.setText("");
        MobileNumbers.setText("");
        Visiting_Time.setText("");
        Days.setText("");
        Fee.setText("");
        
        All_View();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_gender = new javax.swing.JComboBox<>();
        jpanelsignup = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Chamber_ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Days = new javax.swing.JTextField();
        Fee = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        MobileNumbers = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Location = new javax.swing.JTextField();
        Visiting_Time = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        PrescriptionList = new javax.swing.JTable();
        Close = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        register_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male ", "Female" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelsignup.setBackground(new java.awt.Color(255, 255, 255));
        jpanelsignup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/+.png"))); // NOI18N
        jLabel1.setText(" Chamber Information ");
        jpanelsignup.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 80));

        jSeparator5.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 570, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 570, 10));

        jSeparator6.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 570, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 350, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 120, 10));

        jSeparator7.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 180, 10));

        jSeparator8.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 210, 10));

        jSeparator9.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 160, 10));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Chamber ID");
        jpanelsignup.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Visiting Time");
        jpanelsignup.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 20));

        Chamber_ID.setEditable(false);
        Chamber_ID.setBackground(new java.awt.Color(232, 245, 253));
        Chamber_ID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Chamber_ID.setBorder(null);
        jpanelsignup.add(Chamber_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 180, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Name");
        jpanelsignup.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 300, -1));

        Name.setBackground(new java.awt.Color(232, 245, 253));
        Name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Name.setBorder(null);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        jpanelsignup.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 570, 20));

        Days.setBackground(new java.awt.Color(232, 245, 253));
        Days.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Days.setBorder(null);
        Days.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaysActionPerformed(evt);
            }
        });
        jpanelsignup.add(Days, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 210, 20));

        Fee.setBackground(new java.awt.Color(232, 245, 253));
        Fee.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Fee.setBorder(null);
        Fee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeeActionPerformed(evt);
            }
        });
        jpanelsignup.add(Fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 120, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Visiting Fee");
        jpanelsignup.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        MobileNumbers.setBackground(new java.awt.Color(232, 245, 253));
        MobileNumbers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MobileNumbers.setBorder(null);
        MobileNumbers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobileNumbersActionPerformed(evt);
            }
        });
        jpanelsignup.add(MobileNumbers, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 570, 20));

        Update.setBackground(new java.awt.Color(232, 245, 253));
        Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Update.setText("Update");
        Update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Update.setContentAreaFilled(false);
        Update.setOpaque(true);
        Update.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpdateMouseMoved(evt);
            }
        });
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateMouseReleased(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jpanelsignup.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 90, 40));

        Add.setBackground(new java.awt.Color(232, 245, 253));
        Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add.setText("Add");
        Add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Add.setContentAreaFilled(false);
        Add.setOpaque(true);
        Add.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AddMouseMoved(evt);
            }
        });
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AddMouseReleased(evt);
            }
        });
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jpanelsignup.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 92, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Mobile Numbers");
        jpanelsignup.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 310, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Location");
        jpanelsignup.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 310, -1));

        Location.setBackground(new java.awt.Color(232, 245, 253));
        Location.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Location.setBorder(null);
        Location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationActionPerformed(evt);
            }
        });
        jpanelsignup.add(Location, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 570, 20));

        Visiting_Time.setBackground(new java.awt.Color(232, 245, 253));
        Visiting_Time.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Visiting_Time.setBorder(null);
        Visiting_Time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Visiting_TimeActionPerformed(evt);
            }
        });
        jpanelsignup.add(Visiting_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 160, 20));

        PrescriptionList.setBackground(new java.awt.Color(232, 245, 253));
        PrescriptionList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PrescriptionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chamber ID", "Name"
            }
        ));
        PrescriptionList.setToolTipText("");
        PrescriptionList.setName(""); // NOI18N
        PrescriptionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrescriptionListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(PrescriptionList);

        jpanelsignup.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 570, 140));

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
        jpanelsignup.add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 90, 40));

        Reset.setBackground(new java.awt.Color(232, 245, 253));
        Reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Reset.setText("Reset");
        Reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Reset.setContentAreaFilled(false);
        Reset.setOpaque(true);
        Reset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ResetMouseMoved(evt);
            }
        });
        Reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ResetMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetMouseReleased(evt);
            }
        });
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        jpanelsignup.add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 90, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Email");
        jpanelsignup.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        Email.setBackground(new java.awt.Color(232, 245, 253));
        Email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Email.setBorder(null);
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jpanelsignup.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 350, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Visiting Days");
        jpanelsignup.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg5.jpg"))); // NOI18N
        jpanelsignup.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 610));

        getContentPane().add(jpanelsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void DaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DaysActionPerformed

    private void FeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FeeActionPerformed

    private void LocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocationActionPerformed

    private void Visiting_TimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Visiting_TimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Visiting_TimeActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void MobileNumbersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNumbersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNumbersActionPerformed

    private void PrescriptionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrescriptionListMouseClicked
        int i = PrescriptionList.getSelectedRow();
        TableModel model = PrescriptionList.getModel();

        ID = Integer.parseInt((String) model.getValueAt(i, 0));
        Chamber_ID.setText((String) model.getValueAt(i, 0));
        Name.setText((String) model.getValueAt(i, 1));
        Chamber chamber = new Chamber();
        chamber.Find_ID_from_Name(Name.getText());
        Email.setText(chamber.getEmail());        
        Location.setText(chamber.getLocation());
        MobileNumbers.setText(chamber.getMobile());
        Visiting_Time.setText(chamber.getVisiting_Time());
        Days.setText(chamber.getDays());
        Fee.setText(chamber.getFee());

    }//GEN-LAST:event_PrescriptionListMouseClicked

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

    private void ResetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseMoved
        Reset.setCursor(SignIN.cursor);
    }//GEN-LAST:event_ResetMouseMoved

    private void ResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseClicked
        Reset.setBackground(new Color(0,0,255).brighter());
        Reset.setForeground(Color.WHITE);
    }//GEN-LAST:event_ResetMouseClicked

    private void ResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseEntered
        Reset.setBackground(new Color(0,153,255).brighter());
        Reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_ResetMouseEntered

    private void ResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseExited
        Reset.setBackground(new Color(232,245,253));
        Reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_ResetMouseExited

    private void ResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMousePressed
        Reset.setBackground(new Color(0,0,255).brighter());
        Reset.setForeground(Color.WHITE);
    }//GEN-LAST:event_ResetMousePressed

    private void ResetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseReleased
        Reset.setBackground(new Color(232,245,253));
        Reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_ResetMouseReleased

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        try {
            reset();
        } catch (ClassNotFoundException ex) {}
    }//GEN-LAST:event_ResetActionPerformed

    private void UpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseMoved
        Update.setCursor(SignIN.cursor);
    }//GEN-LAST:event_UpdateMouseMoved

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        Update.setBackground(new Color(0,0,255).brighter());
        Update.setForeground(Color.WHITE);
    }//GEN-LAST:event_UpdateMouseClicked

    private void UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseEntered
        Update.setBackground(new Color(0,153,255).brighter());
        Update.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpdateMouseEntered

    private void UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseExited
        Update.setBackground(new Color(232,245,253));
        Update.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpdateMouseExited

    private void UpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMousePressed
        Update.setBackground(new Color(0,0,255).brighter());
        Update.setForeground(Color.WHITE);
    }//GEN-LAST:event_UpdateMousePressed

    private void UpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseReleased
        Update.setBackground(new Color(232,245,253));
        Update.setForeground(Color.BLACK);
    }//GEN-LAST:event_UpdateMouseReleased

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        
        Chamber chamber = new Chamber();
        if(Name.getText().trim().equals("") || Email.getText().trim().equals("") || Location.getText().trim().equals("") || MobileNumbers.getText().trim().equals("") || Visiting_Time.getText().trim().equals("") || Days.getText().trim().equals("") || Fee.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else{
            try {
                int VisitingFee = Integer.parseInt(Fee.getText());
                chamber.ChamberInfo_Updation(ID, Name.getText(), Email.getText(), Location.getText(), Visiting_Time.getText(), Days.getText(), Integer.parseInt(Fee.getText()), MobileNumbers.getText());
                JOptionPane.showMessageDialog(null, "Updated !");
                reset();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Chamber_Info.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error !!!");
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void AddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseMoved
        Add.setCursor(SignIN.cursor);
    }//GEN-LAST:event_AddMouseMoved

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        Add.setBackground(new Color(0,0,255).brighter());
        Add.setForeground(Color.WHITE);
    }//GEN-LAST:event_AddMouseClicked

    private void AddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseEntered
        Add.setBackground(new Color(0,153,255).brighter());
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseEntered

    private void AddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseExited
        Add.setBackground(new Color(232,245,253));
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseExited

    private void AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMousePressed
        Add.setBackground(new Color(0,0,255).brighter());
        Add.setForeground(Color.WHITE);
    }//GEN-LAST:event_AddMousePressed

    private void AddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseReleased
        Add.setBackground(new Color(232,245,253));
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseReleased

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        
        Chamber new_chamber = new Chamber();
        if(Name.getText().trim().equals("") || Email.getText().trim().equals("") || Location.getText().trim().equals("") || MobileNumbers.getText().trim().equals("") || Visiting_Time.getText().trim().equals("") || Days.getText().trim().equals("") || Fee.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else{
            try {
                int VisitingFee = Integer.parseInt(Fee.getText());
                new_chamber.Add_a_Chamber(Name.getText(), Email.getText(), Location.getText(), Visiting_Time.getText(), Days.getText(), Integer.parseInt(Fee.getText()), MobileNumbers.getText());
                JOptionPane.showMessageDialog(null, "Added !");
                reset();
            } catch (ClassNotFoundException | HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error !!!");
            }
        }
        
    }//GEN-LAST:event_AddActionPerformed

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
            java.util.logging.Logger.getLogger(Chamber_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chamber_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chamber_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chamber_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Chamber_Info().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Chamber_Info.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField Chamber_ID;
    private javax.swing.JButton Close;
    private javax.swing.JTextField Days;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Fee;
    private javax.swing.JTextField Location;
    private javax.swing.JTextField MobileNumbers;
    private javax.swing.JTextField Name;
    private javax.swing.JTable PrescriptionList;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Update;
    private javax.swing.JTextField Visiting_Time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel jpanelsignup;
    private javax.swing.JComboBox<String> register_gender;
    // End of variables declaration//GEN-END:variables
}
