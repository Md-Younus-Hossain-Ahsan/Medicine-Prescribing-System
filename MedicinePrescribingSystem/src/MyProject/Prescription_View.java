/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyProject;

import JClasses.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Prescription_View extends javax.swing.JFrame {

    Timer timer;
    int PatientID = 0;
    int PrescriptionID = 0;
    SimpleDateFormat rdf = new SimpleDateFormat("HH");    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        
    DefaultListModel<String> Prescribed_Medicines_List;
    DefaultListModel<String> Prescribed_Tests_List;
    DefaultListModel<String> Problems_List;
    DefaultListModel<String> Prescribed_Advices_List;
    
    
    public Prescription_View() {
        initComponents();        
    }

    
    public Prescription_View(int Pres_id, int Pat_id, String Chamber_Name) throws ClassNotFoundException {
        initComponents();
        PrescriptionID = Pres_id;
        PatientID = Pat_id;
        
        DoctorInfo doctor = new DoctorInfo();
        doctor.search();
        Dr_Name.setText(doctor.getName());
        
        Chamber chamber = new Chamber();
        chamber.Find_ID_from_Name(Chamber_Name);
        Header.setText("\n" + doctor.getQualifications() + "\nConsultant : " + Chamber_Name + "\nAddress : " + chamber.getLocation() + "\nMobile : " + chamber.getMobile());
        
        Prescription_ID.setText("Prescription ID : " + Integer.toString(PrescriptionID));
        Patient_ID.setText(Integer.toString(PatientID));
        Patient patient = new Patient();
        patient.search(PatientID);
        Prescription prescription = new Prescription();
        prescription.Search_Info(PrescriptionID);
        
        Patient_Name.setText("Name : " + patient.getName());
        Patient_Age.setText(Integer.toString(prescription.getPatient_Age()));
        
        Appointment_Date.setText("Date : " + prescription.getVisiting_Date());
        Next_Appointment.setText("Next Appointment : " + prescription.getNextAppointment());
                
        Prescribed_Medicine_List();
        Prescribed_Tests_List();
        Found_Problems_List();
        Advices_List();
        
        timer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Date CurrentDate = new Date(); 
                
                int check = Integer.parseInt(rdf.format(CurrentDate));
                if(check > 11)
                    Print_DateTime.setText("Print : " + sdf.format(CurrentDate) + " PM");
                else
                    Print_DateTime.setText("Print : " + sdf.format(CurrentDate) + " AM");
            }

            private void setVisible(boolean b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        timer.start();
        
    }
    
    
    public void Prescribed_Medicine_List() throws ClassNotFoundException
    {
        //PrescribedMedicines prescribedMedicines = new PrescribedMedicines();
        Medicine medicine = new Medicine();
        
        //prescribedMedicines.Find_All_ids(PrescriptionID);
        
        Prescribed_Medicines_List = new DefaultListModel<>();
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Prescribed_Medicines WHERE Pres_id = '"+ PrescriptionID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            Prescribed_Medicines_List.addElement("    ");
            Prescribed_Medicines_List.addElement("    ");
            while (res.next()) {
                
                medicine.Find_Name_from_ID(res.getInt("med_id"));
                
                if(medicine.getMedicineType().equals("Tablet"))
                    Prescribed_Medicines_List.addElement("  √ Tab. " + medicine.getMedicineName() + " - " + res.getString("dosage_condition"));
                else if(medicine.getMedicineType().equals("Capsule"))
                    Prescribed_Medicines_List.addElement("  √ Cap. " + medicine.getMedicineName() + " - " + res.getString("dosage_condition"));
                else if(medicine.getMedicineType().equals("Syrup"))
                    Prescribed_Medicines_List.addElement("  √ Syr. " + medicine.getMedicineName() + " - " + res.getString("dosage_condition"));
                else
                    Prescribed_Medicines_List.addElement("  √ " + medicine.getMedicineType() + ". " + medicine.getMedicineName() + " - " + res.getString("dosage_condition"));
                
                    
                Prescribed_Medicines_List.addElement("     " + res.getString("dosage_routine") + " - " + res.getString("period") + " - " + res.getString("duration"));
                Prescribed_Medicines_List.addElement("");
        
            } 
        } catch (SQLException e) {
        } 
        
        Medicines_List.setModel(Prescribed_Medicines_List);
        //Prescribed_Medicines_List.addElement(res.getString("med_name"));
    }
    
    
    public void Prescribed_Tests_List() throws ClassNotFoundException
    {
        
        Test test = new Test();
        
        Prescribed_Tests_List = new DefaultListModel<>();
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Prescribed_Tests WHERE Pres_id = '"+ PrescriptionID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            Prescribed_Tests_List.addElement("    Prescribed Tests:");
            while (res.next()) {
                
                test.Find_Name_from_ID(res.getInt("Test_id"));
                
                Prescribed_Tests_List.addElement("     ► " + test.getName());
                Prescribed_Tests_List.addElement("");
        
            } 
        } catch (SQLException e) {
        } 
        
        Test_List.setModel(Prescribed_Tests_List);
        
    }
    
    
    public void Found_Problems_List() throws ClassNotFoundException
    {
        
        Disease disease = new Disease();
        
        Problems_List = new DefaultListModel<>();
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Finding_Problems WHERE Pres_id = '"+ PrescriptionID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            Problems_List.addElement("    Found Problems:");
            while (res.next()) {
                
                disease.Find_Details_from_ID(res.getInt("Dis_id"));
                
                Problems_List.addElement("     » " + disease.getdetails());
                Problems_List.addElement("");
        
            } 
        } catch (SQLException e) {
        } 
        
        Found_Problem_List.setModel(Problems_List);
        
    }
    
    
    public void Advices_List() throws ClassNotFoundException
    {
        
        Advice advice = new Advice();
        
        Prescribed_Advices_List = new DefaultListModel<>();
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Advices WHERE Pres_id = '"+ PrescriptionID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            Prescribed_Advices_List.addElement("    Advices:");
            while (res.next()) {
                
                Prescribed_Advices_List.addElement("     => " + res.getString("details"));
                Prescribed_Advices_List.addElement("");
        
            } 
        } catch (SQLException e) {
        } 
        
        Advice_List.setModel(Prescribed_Advices_List);
        
    }
    
    
    /**Found_Problems_List
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Prescription_Pad = new javax.swing.JPanel();
        Dr_Name = new javax.swing.JLabel();
        Next_Appointment = new javax.swing.JLabel();
        Patient_Age = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Patient_ID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Prescription_ID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Appointment_Date = new javax.swing.JLabel();
        Print_DateTime = new javax.swing.JLabel();
        Patient_Name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Medicines_List = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Advice_List = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Test_List = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Found_Problem_List = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        Header = new javax.swing.JTextArea();
        Close = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Prescription_Pad.setBackground(new java.awt.Color(255, 255, 255));
        Prescription_Pad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dr_Name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dr_Name.setForeground(new java.awt.Color(0, 153, 153));
        Dr_Name.setText("Dr. ");
        Prescription_Pad.add(Dr_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 18, 500, 30));

        Next_Appointment.setBackground(new java.awt.Color(255, 255, 255));
        Next_Appointment.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Next_Appointment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Next_Appointment.setText("Next Appointment :");
        Prescription_Pad.add(Next_Appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 510, 25));

        Patient_Age.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Patient_Age.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Prescription_Pad.add(Patient_Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 60, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("In the name of Allah, the Most Gracious, the Most Merciful");
        Prescription_Pad.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 530, 25));

        Patient_ID.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Patient_ID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Prescription_Pad.add(Patient_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 155, 70, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("  Patient ID :");
        Prescription_Pad.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 70, 20));

        Prescription_ID.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Prescription_ID.setText("Prescription ID :");
        Prescription_Pad.add(Prescription_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 190, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Be patient with yourself. Nothing in nature blooms all year.");
        Prescription_Pad.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 530, -1));

        jList3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jScrollPane8.setViewportView(jList3);

        Prescription_Pad.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 725, 550, 40));

        jList2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jScrollPane6.setViewportView(jList2);

        Prescription_Pad.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 700, 550, 30));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Rx  ");
        Prescription_Pad.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 260, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("  Age :");
        Prescription_Pad.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 60, 20));

        Appointment_Date.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Appointment_Date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Appointment_Date.setText("Date : ");
        Prescription_Pad.add(Appointment_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 190, 20));

        Print_DateTime.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Print_DateTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Print_DateTime.setText("Print : ");
        Prescription_Pad.add(Print_DateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 155, 190, 20));

        Patient_Name.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Patient_Name.setText("Name :");
        Prescription_Pad.add(Patient_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 230, 20));

        Medicines_List.setBorder(null);
        Medicines_List.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jScrollPane1.setViewportView(Medicines_List);

        Prescription_Pad.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 280, 520));

        Advice_List.setBorder(null);
        Advice_List.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jScrollPane4.setViewportView(Advice_List);

        Prescription_Pad.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 540, 280, 170));

        Test_List.setBorder(null);
        Test_List.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jScrollPane2.setViewportView(Test_List);

        Prescription_Pad.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 340, 280, 230));

        Found_Problem_List.setBorder(null);
        Found_Problem_List.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jScrollPane3.setViewportView(Found_Problem_List);

        Prescription_Pad.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 190, 280, 180));

        jScrollPane5.setViewportView(jList1);

        Prescription_Pad.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 155, 550, 40));

        Header.setEditable(false);
        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setColumns(20);
        Header.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Header.setRows(5);
        Header.setFocusable(false);
        jScrollPane7.setViewportView(Header);

        Prescription_Pad.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 21, 520, 170));

        getContentPane().add(Prescription_Pad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 750));

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
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 770, 130, 40));

        Print.setBackground(new java.awt.Color(232, 245, 253));
        Print.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/print icon.png"))); // NOI18N
        Print.setText("Print");
        Print.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Print.setContentAreaFilled(false);
        Print.setOpaque(true);
        Print.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PrintMouseMoved(evt);
            }
        });
        Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrintMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrintMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PrintMouseReleased(evt);
            }
        });
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        getContentPane().add(Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 770, 130, 40));

        bg.setBackground(new java.awt.Color(242, 255, 242));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void PrintMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseMoved
        Print.setCursor(SignIN.cursor);
    }//GEN-LAST:event_PrintMouseMoved

    private void PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseClicked
        Print.setBackground(new Color(0,0,255).brighter());
        Print.setForeground(Color.WHITE);
    }//GEN-LAST:event_PrintMouseClicked

    private void PrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseEntered
        Print.setBackground(new Color(0,153,255).brighter());
        Print.setForeground(Color.BLACK);
    }//GEN-LAST:event_PrintMouseEntered

    private void PrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseExited
        Print.setBackground(new Color(232,245,253));
        Print.setForeground(Color.BLACK);
    }//GEN-LAST:event_PrintMouseExited

    private void PrintMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMousePressed
        Print.setBackground(new Color(0,0,255).brighter());
        Print.setForeground(Color.WHITE);
    }//GEN-LAST:event_PrintMousePressed

    private void PrintMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseReleased
        Print.setBackground(new Color(232,245,253));
        Print.setForeground(Color.BLACK);
    }//GEN-LAST:event_PrintMouseReleased

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable() {
            
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;

                    // Set page orientation to landscape
                pf.setOrientation(PageFormat.LANDSCAPE);

                    // Calculate the scaling factor to fit the content within the printable area
                double scaleX = pf.getImageableWidth() / 320; // 530 is the original width
                double scaleY = pf.getImageableHeight() / 530; // 750 is the original height
                double scale = Math.min(scaleX, scaleY);

                g2.translate(pf.getImageableX(), pf.getImageableY());

                    // Apply scaling
                g2.scale(scale, scale);

                Prescription_Pad.print(g2);

                return Printable.PAGE_EXISTS;
            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_PrintActionPerformed

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
            java.util.logging.Logger.getLogger(Prescription_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prescription_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prescription_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prescription_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prescription_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Advice_List;
    private javax.swing.JLabel Appointment_Date;
    private javax.swing.JButton Close;
    private javax.swing.JLabel Dr_Name;
    private javax.swing.JList<String> Found_Problem_List;
    private javax.swing.JTextArea Header;
    private javax.swing.JList<String> Medicines_List;
    private javax.swing.JLabel Next_Appointment;
    private javax.swing.JLabel Patient_Age;
    private javax.swing.JLabel Patient_ID;
    private javax.swing.JLabel Patient_Name;
    private javax.swing.JLabel Prescription_ID;
    private javax.swing.JPanel Prescription_Pad;
    private javax.swing.JButton Print;
    private javax.swing.JLabel Print_DateTime;
    private javax.swing.JList<String> Test_List;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    // End of variables declaration//GEN-END:variables
}
