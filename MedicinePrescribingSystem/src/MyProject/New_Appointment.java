/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyProject;

import JClasses.*;
import java.awt.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class New_Appointment extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    
    int SI = 1; 
    int ChamberID = 0;
    String Appointment_Date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
    SimpleDateFormat tdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public New_Appointment() throws ClassNotFoundException{
        initComponents();
        All_Chamber_View();
        Chamber chamber = new Chamber();
        chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
        ChamberID = chamber.getChamberID();   
        
        Date CurrentDate = new Date();
        AppointmentDate_Select.setMinSelectableDate(new Date());
        Appointment_Date = tdf.format(CurrentDate);
        AppointmentDate.setText(Appointment_Date);
        
        try {
            Last_SI();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(New_Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        AppID.setText(sdf.format(CurrentDate) + " " + Integer.toString(SI));
        Reset();
               
    }
    
    public void All_Chamber_View(){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Chamber";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                ChamberName.addItem(res.getString("Name"));                
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

    
    public void Last_SI() throws ClassNotFoundException{
        
        SI = 0;
        Appointment appointment = new Appointment();
        appointment.Last_SI_no(ChamberID, Appointment_Date);
        
        SI = appointment.getSI();
        SI_No.setText(Integer.toString(SI));
                
    }
    
    public void Reset(){
        Patient_ID.setText("");
        Name.setText("");
        Age.setText("");
        Gender.setSelectedItem("<<Select>>");
        MobileNumber.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_gender = new javax.swing.JComboBox<>();
        jpanelsignup = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        Patient_ID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        AppointmentDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        AppID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SI_No = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        MobileNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Searching_using_Patient_ID = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ChamberName = new javax.swing.JComboBox<>();
        Close = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        AppointmentDate_Select = new com.toedter.calendar.JDateChooser();
        Patient_Info = new javax.swing.JButton();
        Set = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        register_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male ", "Female" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelsignup.setBackground(new java.awt.Color(255, 255, 255));
        jpanelsignup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator8.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 160, 10));

        jSeparator9.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 660, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 80, 10));

        jSeparator11.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 370, 10));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 140, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 100, 10));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 243, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 240, 10));

        jSeparator16.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        jpanelsignup.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 220, 10));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/+.png"))); // NOI18N
        jLabel1.setText(" Add a new Appointment ");
        jpanelsignup.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 900, 100));

        Patient_ID.setBackground(new java.awt.Color(232, 245, 253));
        Patient_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Patient_ID.setBorder(null);
        Patient_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Patient_IDActionPerformed(evt);
            }
        });
        Patient_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Patient_IDKeyTyped(evt);
            }
        });
        jpanelsignup.add(Patient_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 160, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Appointment Date Select");
        jpanelsignup.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 160, -1));

        AppointmentDate.setEditable(false);
        AppointmentDate.setBackground(new java.awt.Color(232, 245, 253));
        AppointmentDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AppointmentDate.setBorder(null);
        jpanelsignup.add(AppointmentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 240, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Appointment Date");
        jpanelsignup.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, 20));

        AppID.setEditable(false);
        AppID.setBackground(new java.awt.Color(232, 245, 253));
        AppID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AppID.setBorder(null);
        jpanelsignup.add(AppID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 220, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Name");
        jpanelsignup.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        Name.setBackground(new java.awt.Color(232, 245, 253));
        Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Name.setBorder(null);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        jpanelsignup.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 370, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Appointment ID");
        jpanelsignup.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 20));

        SI_No.setEditable(false);
        SI_No.setBackground(new java.awt.Color(232, 245, 253));
        SI_No.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SI_No.setBorder(null);
        jpanelsignup.add(SI_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 80, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Age");
        jpanelsignup.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        Age.setBackground(new java.awt.Color(232, 245, 253));
        Age.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Age.setBorder(null);
        Age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeActionPerformed(evt);
            }
        });
        jpanelsignup.add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gender ");
        jpanelsignup.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 70, -1));

        Gender.setBackground(new java.awt.Color(232, 245, 253));
        Gender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select>>", "Male", "Female" }));
        Gender.setBorder(null);
        jpanelsignup.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 140, 30));

        MobileNumber.setBackground(new java.awt.Color(232, 245, 253));
        MobileNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MobileNumber.setBorder(null);
        MobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobileNumberActionPerformed(evt);
            }
        });
        jpanelsignup.add(MobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 243, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Mobile number");
        jpanelsignup.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("SI No.");
        jpanelsignup.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 20));

        Searching_using_Patient_ID.setBackground(new java.awt.Color(232, 245, 253));
        Searching_using_Patient_ID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Searching_using_Patient_ID.setText("Search");
        Searching_using_Patient_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Searching_using_Patient_ID.setContentAreaFilled(false);
        Searching_using_Patient_ID.setOpaque(true);
        Searching_using_Patient_ID.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Searching_using_Patient_IDMouseMoved(evt);
            }
        });
        Searching_using_Patient_ID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Searching_using_Patient_IDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Searching_using_Patient_IDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Searching_using_Patient_IDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Searching_using_Patient_IDMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Searching_using_Patient_IDMouseReleased(evt);
            }
        });
        Searching_using_Patient_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Searching_using_Patient_IDActionPerformed(evt);
            }
        });
        jpanelsignup.add(Searching_using_Patient_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chamber Name :");
        jpanelsignup.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 110, 30));

        ChamberName.setBackground(new java.awt.Color(232, 245, 253));
        ChamberName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ChamberName.setBorder(null);
        ChamberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChamberNameActionPerformed(evt);
            }
        });
        jpanelsignup.add(ChamberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 660, 30));

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
        jpanelsignup.add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 130, 40));

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
        jpanelsignup.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 130, 40));

        reset.setBackground(new java.awt.Color(232, 245, 253));
        reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        reset.setContentAreaFilled(false);
        reset.setOpaque(true);
        reset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                resetMouseMoved(evt);
            }
        });
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resetMouseReleased(evt);
            }
        });
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jpanelsignup.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 130, 40));

        AppointmentDate_Select.setBackground(new java.awt.Color(232, 245, 253));
        AppointmentDate_Select.setDateFormatString("d MMM y");
        AppointmentDate_Select.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpanelsignup.add(AppointmentDate_Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 200, 30));

        Patient_Info.setBackground(new java.awt.Color(232, 245, 253));
        Patient_Info.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Patient_Info.setText("Patient Info");
        Patient_Info.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Patient_Info.setContentAreaFilled(false);
        Patient_Info.setOpaque(true);
        Patient_Info.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Patient_InfoMouseMoved(evt);
            }
        });
        Patient_Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Patient_InfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Patient_InfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Patient_InfoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Patient_InfoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Patient_InfoMouseReleased(evt);
            }
        });
        Patient_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Patient_InfoActionPerformed(evt);
            }
        });
        jpanelsignup.add(Patient_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 120, 30));

        Set.setBackground(new java.awt.Color(232, 245, 253));
        Set.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Set.setText("Set");
        Set.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Set.setContentAreaFilled(false);
        Set.setOpaque(true);
        Set.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SetMouseMoved(evt);
            }
        });
        Set.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SetMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SetMouseReleased(evt);
            }
        });
        Set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetActionPerformed(evt);
            }
        });
        jpanelsignup.add(Set, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 90, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Patient ID");
        jpanelsignup.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg1.jpg"))); // NOI18N
        jpanelsignup.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        getContentPane().add(jpanelsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MobileNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNumberActionPerformed

    private void AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void Patient_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Patient_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Patient_IDActionPerformed

    private void Searching_using_Patient_IDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Searching_using_Patient_IDMouseMoved
        Searching_using_Patient_ID.setCursor(SignIN.cursor);
    }//GEN-LAST:event_Searching_using_Patient_IDMouseMoved

    private void Searching_using_Patient_IDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Searching_using_Patient_IDMouseClicked
        Searching_using_Patient_ID.setBackground(new Color(0,0,255).brighter());
        Searching_using_Patient_ID.setForeground(Color.WHITE);
    }//GEN-LAST:event_Searching_using_Patient_IDMouseClicked

    private void Searching_using_Patient_IDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Searching_using_Patient_IDMouseEntered
        Searching_using_Patient_ID.setBackground(new Color(0,153,255).brighter());
        Searching_using_Patient_ID.setForeground(Color.BLACK);
    }//GEN-LAST:event_Searching_using_Patient_IDMouseEntered

    private void Searching_using_Patient_IDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Searching_using_Patient_IDMouseExited
        Searching_using_Patient_ID.setBackground(new Color(232,245,253));
        Searching_using_Patient_ID.setForeground(Color.BLACK);
    }//GEN-LAST:event_Searching_using_Patient_IDMouseExited

    private void Searching_using_Patient_IDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Searching_using_Patient_IDMousePressed
        Searching_using_Patient_ID.setBackground(new Color(0,0,255).brighter());
        Searching_using_Patient_ID.setForeground(Color.WHITE);
    }//GEN-LAST:event_Searching_using_Patient_IDMousePressed

    private void Searching_using_Patient_IDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Searching_using_Patient_IDMouseReleased
        Searching_using_Patient_ID.setBackground(new Color(232,245,253));
        Searching_using_Patient_ID.setForeground(Color.BLACK);
    }//GEN-LAST:event_Searching_using_Patient_IDMouseReleased

    private void Searching_using_Patient_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Searching_using_Patient_IDActionPerformed
        Patient patient = new Patient();
        
        try {
            if(!Patient_ID.getText().trim().equals(""))
            {
                patient.search(Integer.parseInt(Patient_ID.getText()));
                if(patient.getFound() == 1)
                {
                    Name.setText(patient.getName());
                    Age.setText(patient.getAge());
                    Gender.setSelectedItem(patient.getGender());
                    MobileNumber.setText(patient.getMobile_number());
                }
                else
                    JOptionPane.showMessageDialog(null, "Not Found !!!"); 
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Searching_using_Patient_IDActionPerformed

    private void ChamberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChamberNameActionPerformed
        
        Chamber chamber = new Chamber();
        chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
        ChamberID = chamber.getChamberID();        
        try {
            Last_SI();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(New_Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Reset();
    }//GEN-LAST:event_ChamberNameActionPerformed

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
        if(Name.getText().isEmpty() || Age.getText().isEmpty() || Gender.getSelectedItem().equals("<<Select>>") || MobileNumber.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            int temp1 = Integer.parseInt(Age.getText());
            long temp2 = Long.parseLong(MobileNumber.getText());
            
            Appointment appointment = new Appointment();
            try {
                appointment.Add_a_New_Appointment(Integer.parseInt(SI_No.getText()), ChamberID, AppID.getText(), Name.getText(), Integer.parseInt(Age.getText()), MobileNumber.getText(), (String) Gender.getSelectedItem(), Appointment_Date);
                
            } catch (ClassNotFoundException ex) {}
            
            try {
                Last_SI();
            } catch (ClassNotFoundException ex) {}
            
            Reset();
        }
    }//GEN-LAST:event_AddActionPerformed

    private void resetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseMoved
        reset.setCursor(SignIN.cursor);
    }//GEN-LAST:event_resetMouseMoved

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        reset.setBackground(new Color(0,0,255).brighter());
        reset.setForeground(Color.WHITE);
    }//GEN-LAST:event_resetMouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        reset.setBackground(new Color(0,153,255).brighter());
        reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        reset.setBackground(new Color(232,245,253));
        reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_resetMouseExited

    private void resetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMousePressed
        reset.setBackground(new Color(0,0,255).brighter());
        reset.setForeground(Color.WHITE);
    }//GEN-LAST:event_resetMousePressed

    private void resetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseReleased
        reset.setBackground(new Color(232,245,253));
        reset.setForeground(Color.BLACK);
    }//GEN-LAST:event_resetMouseReleased

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        Reset();
    }//GEN-LAST:event_resetActionPerformed

    private void Patient_InfoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_InfoMouseMoved
        Patient_Info.setCursor(SignIN.cursor);
    }//GEN-LAST:event_Patient_InfoMouseMoved

    private void Patient_InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_InfoMouseClicked
        Patient_Info.setBackground(new Color(0,0,255).brighter());
        Patient_Info.setForeground(Color.WHITE);
    }//GEN-LAST:event_Patient_InfoMouseClicked

    private void Patient_InfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_InfoMouseEntered
        Patient_Info.setBackground(new Color(0,153,255).brighter());
        Patient_Info.setForeground(Color.BLACK);
    }//GEN-LAST:event_Patient_InfoMouseEntered

    private void Patient_InfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_InfoMouseExited
        Patient_Info.setBackground(new Color(232,245,253));
        Patient_Info.setForeground(Color.BLACK);
    }//GEN-LAST:event_Patient_InfoMouseExited

    private void Patient_InfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_InfoMousePressed
        Patient_Info.setBackground(new Color(0,0,255).brighter());
        Patient_Info.setForeground(Color.WHITE);
    }//GEN-LAST:event_Patient_InfoMousePressed

    private void Patient_InfoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_InfoMouseReleased
        Patient_Info.setBackground(new Color(232,245,253));
        Patient_Info.setForeground(Color.BLACK);
    }//GEN-LAST:event_Patient_InfoMouseReleased

    private void Patient_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Patient_InfoActionPerformed

        new Patient_Info().setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_Patient_InfoActionPerformed

    private void SetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetMouseMoved
        Set.setCursor(SignIN.cursor);
    }//GEN-LAST:event_SetMouseMoved

    private void SetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetMouseClicked
        Set.setBackground(new Color(0,0,255).brighter());
        Set.setForeground(Color.WHITE);
    }//GEN-LAST:event_SetMouseClicked

    private void SetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetMouseEntered
        Set.setBackground(new Color(0,153,255).brighter());
        Set.setForeground(Color.BLACK);
    }//GEN-LAST:event_SetMouseEntered

    private void SetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetMouseExited
        Set.setBackground(new Color(232,245,253));
        Set.setForeground(Color.BLACK);
    }//GEN-LAST:event_SetMouseExited

    private void SetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetMousePressed
        Set.setBackground(new Color(0,0,255).brighter());
        Set.setForeground(Color.WHITE);
    }//GEN-LAST:event_SetMousePressed

    private void SetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetMouseReleased
        Set.setBackground(new Color(232,245,253));
        Set.setForeground(Color.BLACK);
    }//GEN-LAST:event_SetMouseReleased

    private void SetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetActionPerformed
        
        Appointment_Date = tdf.format(AppointmentDate_Select.getDate());
        AppointmentDate.setText(Appointment_Date);
        
        try {
            Last_SI();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(New_Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        AppID.setText(sdf.format(AppointmentDate_Select.getDate()) + " " + Integer.toString(SI));
        
    }//GEN-LAST:event_SetActionPerformed

    private void Patient_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Patient_IDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_Patient_IDKeyTyped

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
            java.util.logging.Logger.getLogger(New_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new New_Appointment().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(New_Appointment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField Age;
    private javax.swing.JTextField AppID;
    private javax.swing.JTextField AppointmentDate;
    private com.toedter.calendar.JDateChooser AppointmentDate_Select;
    private javax.swing.JComboBox<String> ChamberName;
    private javax.swing.JButton Close;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField MobileNumber;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Patient_ID;
    private javax.swing.JButton Patient_Info;
    private javax.swing.JTextField SI_No;
    private javax.swing.JButton Searching_using_Patient_ID;
    private javax.swing.JButton Set;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel jpanelsignup;
    private javax.swing.JComboBox<String> register_gender;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
