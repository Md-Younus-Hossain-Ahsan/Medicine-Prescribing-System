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

public final class Appointment_List extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    String App_id;
    String Name;
    int Age = 0;
    int ChamberID = 0;
    int PatientID = 0;
    String Mobile_Number;
    String Gender;
    String App_date;
    String Appointment_Date;
    SimpleDateFormat tdf = new SimpleDateFormat("yyyy-MM-dd");
            
    
    public Appointment_List() {
        
        initComponents(); 
        
        java.util.Date CurrentDate = new java.util.Date();
        AppointmentDate_Select.setMinSelectableDate(new java.util.Date());
        Appointment_Date = tdf.format(CurrentDate);
        AppointmentDate.setText(Appointment_Date);
        
        All_Chamber_View();
        Chamber chamber = new Chamber();
        chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
        ChamberID = chamber.getChamberID();
        All_View();
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


    public void All_View(){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Appointment where Chamber_id = '"+ ChamberID +"' and App_date = '"+ Appointment_Date +"' and App_type = 'Pending'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            AppointmentList.setModel(new DefaultTableModel(null, new String[] {"SI no", "Appointment ID", "Name", "Age", "Gender", "Mobile Number", "Date"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("SI_no")),
                                    res.getString("App_id"),
                                    res.getString("Name"),
                                    Integer.toString(res.getInt("Age")),
                                    res.getString("Gender"),
                                    res.getString("Mobile_Number"),
                                    res.getDate("App_date").toString()};
                DefaultTableModel tbModel = (DefaultTableModel) AppointmentList.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        AppointmentDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        AppointmentDate_Select = new com.toedter.calendar.JDateChooser();
        Set = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AppointmentList = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ChamberName = new javax.swing.JComboBox<>();
        Back = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/+.png"))); // NOI18N
        jLabel4.setText(" Appointment List ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 240, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 630, 10));

        AppointmentDate.setEditable(false);
        AppointmentDate.setBackground(new java.awt.Color(232, 245, 253));
        AppointmentDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AppointmentDate.setBorder(null);
        getContentPane().add(AppointmentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 240, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Appointment Date");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Appointment Date Select");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 160, -1));

        AppointmentDate_Select.setBackground(new java.awt.Color(232, 245, 253));
        AppointmentDate_Select.setDateFormatString("d MMM y");
        AppointmentDate_Select.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(AppointmentDate_Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 210, 30));

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
        getContentPane().add(Set, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 90, 30));

        AppointmentList.setBackground(new java.awt.Color(232, 245, 253));
        AppointmentList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        AppointmentList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AppointmentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SI no", "Appointment ID", "Name", "Age", "Gender", "Mobile Number", "Date"
            }
        ));
        AppointmentList.setToolTipText("");
        AppointmentList.setName(""); // NOI18N
        AppointmentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppointmentListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(AppointmentList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 760, 190));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Chamber Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 150, 30));

        ChamberName.setBackground(new java.awt.Color(232, 245, 253));
        ChamberName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ChamberName.setBorder(null);
        ChamberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChamberNameActionPerformed(evt);
            }
        });
        getContentPane().add(ChamberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 630, 30));

        Back.setBackground(new java.awt.Color(232, 245, 253));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setText("Back");
        Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Back.setContentAreaFilled(false);
        Back.setOpaque(true);
        Back.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BackMouseMoved(evt);
            }
        });
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BackMouseReleased(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 130, 40));

        Add.setBackground(new java.awt.Color(232, 245, 253));
        Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add.setText("Next");
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
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 440, 130, 40));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg1.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AppointmentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppointmentListMouseClicked
        int i = AppointmentList.getSelectedRow();
        TableModel model = AppointmentList.getModel();
        
        App_id = (String) model.getValueAt(i, 1);
        Name = (String) model.getValueAt(i, 2);
        Age = Integer.parseInt((String) model.getValueAt(i, 3));
        Gender = (String) model.getValueAt(i, 4);
        Mobile_Number = (String) model.getValueAt(i, 5);    
        App_date = (String) model.getValueAt(i, 6);
        
    }//GEN-LAST:event_AppointmentListMouseClicked
    
    
    private void ChamberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChamberNameActionPerformed
        Chamber chamber = new Chamber();
        chamber.Find_ID_from_Name((String) ChamberName.getSelectedItem());
        ChamberID = chamber.getChamberID();        
        All_View();
    }//GEN-LAST:event_ChamberNameActionPerformed

    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(SignIN.cursor);
    }//GEN-LAST:event_BackMouseMoved

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        Back.setBackground(new Color(0,0,255).brighter());
        Back.setForeground(Color.WHITE);
    }//GEN-LAST:event_BackMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        Back.setBackground(new Color(0,153,255).brighter());
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        Back.setBackground(new Color(232,245,253));
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseExited

    private void BackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMousePressed
        Back.setBackground(new Color(0,0,255).brighter());
        Back.setForeground(Color.WHITE);
    }//GEN-LAST:event_BackMousePressed

    private void BackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseReleased
        Back.setBackground(new Color(232,245,253));
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseReleased

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        dispose();
    }//GEN-LAST:event_BackActionPerformed

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
        //Add to database        
        Appointment appointment = new Appointment();
        Patient patient = new Patient();
        
        try{
        if(!Name.equals(""))
        {
            try {
                appointment.Search(Name, Mobile_Number);
            } catch (ClassNotFoundException ex) {}
        
            if(appointment.getFound() == 0)
            {
                try {
                    appointment.Add_to_patient_list(Name, Age, Gender, Mobile_Number);
                } catch (ClassNotFoundException ex) {}
            }
            else{
                try {
                    patient.Age_Update(Name, Age, Mobile_Number);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
            
            try {   
                appointment.Appointment_Type_Updation(App_id) ;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                patient.Patient_ID_search(Name, Mobile_Number);
                PatientID = patient.getPatientID();
            } catch (ClassNotFoundException ex) {}
            
            try {
                new Prescription_Create(ChamberID, PatientID).setVisible(true);
            } catch (ClassNotFoundException ex) {}
            
            dispose();
        }
    }catch(Exception e){}
        
    }//GEN-LAST:event_AddActionPerformed

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
        All_View();
        
    }//GEN-LAST:event_SetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Appointment_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField AppointmentDate;
    private com.toedter.calendar.JDateChooser AppointmentDate_Select;
    private javax.swing.JTable AppointmentList;
    private javax.swing.JButton Back;
    private javax.swing.JComboBox<String> ChamberName;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JButton Set;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
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