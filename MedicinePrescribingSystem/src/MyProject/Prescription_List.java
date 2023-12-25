package MyProject;

import JClasses.*;
import java.awt.*;
import java.sql.*;
import java.text.*;
import javax.swing.table.*;
import java.util.logging.*;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Prescription_List extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    int ChamberID = 0;
    int PatientID = 0;
    int Last_Prescription_ID = 0;
    SimpleDateFormat tdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
    public Prescription_List() {
        
        initComponents();        
        All_Chamber_View();
        Chamber chamber = new Chamber();
        chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
        ChamberID = chamber.getChamberID();
        All_View();
    }
    
    public Prescription_List(int Last_Prescription_ID, int PatientID, String Chamber_Name) {
        
        initComponents();
        All_Chamber_View();
        
        this.Last_Prescription_ID = Last_Prescription_ID;
        Patient_ID.setText(Integer.toString(PatientID));
        
        Chamber chamber = new Chamber();
        ChamberName.setSelectedItem(Chamber_Name);
        chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
        ChamberID = chamber.getChamberID();
        this.PatientID = PatientID;
        Search_using_ID();
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
            Logger.getLogger(Prescription_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  


    public void All_View(){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        java.util.Date CurrentDate = new java.util.Date();
        tdf.format(CurrentDate);
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Prescription where Chamber_id = '"+ ChamberID +"' ORDER BY Pres_id DESC";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            Patient patient = new Patient();
            PrescriptionList.setModel(new DefaultTableModel(null, new String[] {"Prescription ID", "Patient ID", "Name", "Mobile Number", "Visiting Date"}));
            
            while(res.next())
            {
                patient.search(res.getInt("Patient_id"));
                String tbData[] = {Integer.toString(res.getInt("Pres_id")),
                                   Integer.toString(res.getInt("Patient_id")),
                                   patient.getName(),
                                   patient.getMobile_number(),
                                   res.getString("Visiting_Date")};
                DefaultTableModel tbModel = (DefaultTableModel) PrescriptionList.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prescription_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
    public void Reset()
    {
        Prescription_ID.setText("");
        Patient_ID.setText("");
        Name.setText("");
        MobileNumber.setText("");
    }

    
    public void Search_using_ID()
    {
    try{
            Chamber chamber = new Chamber();
            chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
            ChamberID = chamber.getChamberID();
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = null;

                try{
                        int check = Integer.parseInt(Patient_ID.getText());
                        sql = "SELECT * FROM Prescription WHERE Patient_id = '" + PatientID + "' AND Chamber_id = '"+ ChamberID +"' AND Pres_id != '"+ Last_Prescription_ID +"' ORDER BY Pres_id DESC";
                }catch(NumberFormatException e){Patient_ID.setText("");}
                
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                Patient patient = new Patient();
            PrescriptionList.setModel(new DefaultTableModel(null, new String[] {"Prescription ID", "Patient ID", "Name", "Mobile Number", "Visiting Date"}));
            
            while(res.next())
            {
                patient.search(res.getInt("Patient_id"));
                String tbData[] = {Integer.toString(res.getInt("Pres_id")),
                                   Integer.toString(res.getInt("Patient_id")),
                                   patient.getName(),
                                   patient.getMobile_number(),
                                   res.getString("Visiting_Date")};
                DefaultTableModel tbModel = (DefaultTableModel) PrescriptionList.getModel();
                tbModel.addRow(tbData);
            }

            } catch (SQLException e) {System.out.println(e);}
        } catch (ClassNotFoundException ex) {Logger.getLogger(Patient_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        PrescriptionList = new javax.swing.JTable();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        Patient_ID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ChamberName = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        Prescription_ID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        MobileNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        View = new javax.swing.JButton();
        All_View = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PrescriptionList.setBackground(new java.awt.Color(232, 245, 253));
        PrescriptionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescription ID", "Patient ID", "Name", "Mobile Number", "Visiting Date"
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 810, 190));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 640, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 180, 10));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 250, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 90, 10));

        jSeparator16.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 90, 10));

        Patient_ID.setBackground(new java.awt.Color(232, 245, 253));
        Patient_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Patient_ID.setBorder(null);
        Patient_ID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Patient_IDMouseClicked(evt);
            }
        });
        Patient_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Patient_IDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Patient_IDKeyTyped(evt);
            }
        });
        getContentPane().add(Patient_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 90, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Patient ID");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Chamber Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 120, 30));

        ChamberName.setBackground(new java.awt.Color(232, 245, 253));
        ChamberName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ChamberName.setBorder(null);
        ChamberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChamberNameActionPerformed(evt);
            }
        });
        getContentPane().add(ChamberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 640, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Prescription ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, 20));

        Prescription_ID.setBackground(new java.awt.Color(232, 245, 253));
        Prescription_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Prescription_ID.setBorder(null);
        Prescription_ID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prescription_IDMouseClicked(evt);
            }
        });
        Prescription_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Prescription_IDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Prescription_IDKeyTyped(evt);
            }
        });
        getContentPane().add(Prescription_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 90, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Name");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, 20));

        Name.setEditable(false);
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
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 250, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Mobile Number");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, 20));

        MobileNumber.setEditable(false);
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
        getContentPane().add(MobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 180, 30));

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/+.png"))); // NOI18N
        jLabel4.setText(" Prescription List ");
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
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 130, 40));

        View.setBackground(new java.awt.Color(232, 245, 253));
        View.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        View.setText("View");
        View.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        View.setContentAreaFilled(false);
        View.setOpaque(true);
        View.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ViewMouseMoved(evt);
            }
        });
        View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ViewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ViewMouseReleased(evt);
            }
        });
        View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewActionPerformed(evt);
            }
        });
        getContentPane().add(View, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, 130, 40));

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
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, 30));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg1.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrescriptionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrescriptionListMouseClicked
        int i = PrescriptionList.getSelectedRow();
        TableModel model = PrescriptionList.getModel();
        
        Prescription_ID.setText((String) model.getValueAt(i, 0));
        Patient_ID.setText((String) model.getValueAt(i, 1));
        Name.setText((String) model.getValueAt(i, 2));
        MobileNumber.setText((String) model.getValueAt(i, 3));
           
    }//GEN-LAST:event_PrescriptionListMouseClicked
    
    
    private void ChamberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChamberNameActionPerformed
        Chamber chamber = new Chamber();
        chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
        ChamberID = chamber.getChamberID();        
        
        if(Patient_ID.getText().trim().equals(""))
            All_View();
        else
            Search_using_ID();
        
    }//GEN-LAST:event_ChamberNameActionPerformed

    private void Prescription_IDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prescription_IDMouseClicked
        // TODO add your handling code here:
        All_View();
        Reset();
    }//GEN-LAST:event_Prescription_IDMouseClicked

    private void Prescription_IDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Prescription_IDKeyReleased
        try{
            Chamber chamber = new Chamber();
            chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
            ChamberID = chamber.getChamberID();
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = null;

                if(Prescription_ID.getText().trim().equals(""))
                    All_View();
                else{
                    try{
                        int check = Integer.parseInt(Prescription_ID.getText());
                        sql = "SELECT * FROM Prescription WHERE Pres_id LIKE '" + Integer.valueOf(Prescription_ID.getText()) + "%' AND Chamber_id = '"+ ChamberID +"' ORDER BY Pres_id DESC";
                    }catch(NumberFormatException e){Prescription_ID.setText("");}
                }
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                Patient patient = new Patient();
            PrescriptionList.setModel(new DefaultTableModel(null, new String[] {"Prescription ID", "Patient ID", "Name", "Mobile Number", "Visiting Date"}));
            
            while(res.next())
            {
                patient.search(res.getInt("Patient_id"));
                String tbData[] = {Integer.toString(res.getInt("Pres_id")),
                                   Integer.toString(res.getInt("Patient_id")),
                                   patient.getName(),
                                   patient.getMobile_number(),
                                   res.getString("Visiting_Date")};
                DefaultTableModel tbModel = (DefaultTableModel) PrescriptionList.getModel();
                tbModel.addRow(tbData);
            }

            } catch (SQLException e) {System.out.println(e);}
        } catch (ClassNotFoundException ex) {Logger.getLogger(Patient_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Prescription_IDKeyReleased

    private void Prescription_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Prescription_IDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
        evt.consume();
    }//GEN-LAST:event_Prescription_IDKeyTyped

    private void NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMouseClicked
        All_View();
        Reset();
    }//GEN-LAST:event_NameMouseClicked

    private void NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyPressed

    }//GEN-LAST:event_NameKeyPressed

    private void NameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyReleased
        
    }//GEN-LAST:event_NameKeyReleased

    private void NameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyTyped

    }//GEN-LAST:event_NameKeyTyped

    private void MobileNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MobileNumberMouseClicked
        
    }//GEN-LAST:event_MobileNumberMouseClicked

    private void MobileNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNumberKeyReleased
        
    }//GEN-LAST:event_MobileNumberKeyReleased

    private void MobileNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNumberKeyTyped
        
    }//GEN-LAST:event_MobileNumberKeyTyped

    private void Patient_IDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_IDMouseClicked
        All_View();
        Reset();
    }//GEN-LAST:event_Patient_IDMouseClicked

    private void Patient_IDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Patient_IDKeyReleased
        
        try{
            Chamber chamber = new Chamber();
            chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
            ChamberID = chamber.getChamberID();
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = null;

                if(Patient_ID.getText().trim().equals(""))
                    All_View();
                else{
                    try{
                        int check = Integer.parseInt(Patient_ID.getText());
                        sql = "SELECT * FROM Prescription WHERE Patient_id LIKE '" + Integer.valueOf(Patient_ID.getText()) + "%' AND Chamber_id = '"+ ChamberID +"' ORDER BY Pres_id DESC";
                    }catch(NumberFormatException e){Patient_ID.setText("");}
                }
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                Patient patient = new Patient();
            PrescriptionList.setModel(new DefaultTableModel(null, new String[] {"Prescription ID", "Patient ID", "Name", "Mobile Number", "Visiting Date"}));
            
            while(res.next())
            {
                patient.search(res.getInt("Patient_id"));
                String tbData[] = {Integer.toString(res.getInt("Pres_id")),
                                   Integer.toString(res.getInt("Patient_id")),
                                   patient.getName(),
                                   patient.getMobile_number(),
                                   res.getString("Visiting_Date")};
                DefaultTableModel tbModel = (DefaultTableModel) PrescriptionList.getModel();
                tbModel.addRow(tbData);
            }

            } catch (SQLException e) {System.out.println(e);}
        } catch (ClassNotFoundException ex) {Logger.getLogger(Patient_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Patient_IDKeyReleased

    private void Patient_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Patient_IDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_Patient_IDKeyTyped

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

    private void ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMouseMoved
        View.setCursor(SignIN.cursor);
    }//GEN-LAST:event_ViewMouseMoved

    private void ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMouseClicked
        View.setBackground(new Color(0,0,255).brighter());
        View.setForeground(Color.WHITE);
    }//GEN-LAST:event_ViewMouseClicked

    private void ViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMouseEntered
        View.setBackground(new Color(0,153,255).brighter());
        View.setForeground(Color.BLACK);
    }//GEN-LAST:event_ViewMouseEntered

    private void ViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMouseExited
        View.setBackground(new Color(232,245,253));
        View.setForeground(Color.BLACK);
    }//GEN-LAST:event_ViewMouseExited

    private void ViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMousePressed
        View.setBackground(new Color(0,0,255).brighter());
        View.setForeground(Color.WHITE);
    }//GEN-LAST:event_ViewMousePressed

    private void ViewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMouseReleased
        View.setBackground(new Color(232,245,253));
        View.setForeground(Color.BLACK);
    }//GEN-LAST:event_ViewMouseReleased

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewActionPerformed
        
        if(Prescription_ID.getText().trim().equals("") || Patient_ID.getText().trim().equals("")){}
        else
        {
            try{
                new Prescription_View(Integer.parseInt(Prescription_ID.getText()), Integer.parseInt(Patient_ID.getText()), (String) ChamberName.getSelectedItem()).setVisible(true);
            }catch(Exception e){}
        }
    }//GEN-LAST:event_ViewActionPerformed

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
                new Prescription_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton All_View;
    private javax.swing.JComboBox<String> ChamberName;
    private javax.swing.JButton Close;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField MobileNumber;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Patient_ID;
    private javax.swing.JTable PrescriptionList;
    private javax.swing.JTextField Prescription_ID;
    private javax.swing.JButton View;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
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

    private void search(String Name, String Mobile_Number) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getFound() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void Search(String Name, String Mobile_Number) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void Add_to_patient_list(String Name, int Age, String Gender, String Mobile_Number) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}