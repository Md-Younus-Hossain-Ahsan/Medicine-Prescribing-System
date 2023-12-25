/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyProject;

import JClasses.*;
import java.awt.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.*;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Prescription_Create extends javax.swing.JFrame {

    /**
     * Creates new form Prescription_Create
     */
    Timer timer;
    int ChamberID = 0; 
    int PatientID = 0; 
    int PrescriptionID = 0;
    int MedicineID = 0;
    int DoseID = 0;
    int period_id = 0;
    int duration_id = 0;
    int con_id = 0;
    int Testid = 0;
    int NextApp_id = 0;
    int Dis_id = 0;
    int PresMed_id = 0;
    int PresTest_id = 0;
    int FindProb_id = 0;
    int FindAdv_id = 0;
    String Appointment_DateTime = null;    
    String MedicineType = null;    
    String Prev_Medicine = null;    
    String Prev_Test = null;    
    String Prev_Problem = null;    
    String Prev_Advice = null; 
    SimpleDateFormat rdf = new SimpleDateFormat("HH");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    private DefaultListModel mod1, mod2, mod3, mod4, mod5, mod6, mod7, mod8, mod9, mod10;
    
    public Prescription_Create(int ChamberID, int PatientID) throws ClassNotFoundException {
        initComponents();
        
        For_Viewing_Searching_Suggestions();  
        this.ChamberID = ChamberID; 
        this.PatientID = PatientID;
        Initial_Setups();
        Date CurrentDate = new Date(); 
        
        Prescription prescription = new Prescription();
        int check = Integer.parseInt(rdf.format(CurrentDate));
        if(check > 11)
            Appointment_DateTime = sdf.format(CurrentDate) + " PM";
        else
            Appointment_DateTime = sdf.format(CurrentDate) + " AM";
        prescription.Add_a_Prescription(ChamberID, PatientID, Integer.parseInt(PatientAge.getText()), Appointment_DateTime, PatientNextAppointment.getText());
        
        
    }

    private Prescription_Create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void Initial_Setups() throws ClassNotFoundException{
        
        Chamber chamber = new Chamber();
        Patient patient = new Patient();
        Prescription prescription = new Prescription();
        
        chamber.Find_Name_from_ID(ChamberID);
        ChamberNameView.setText(chamber.getChamberName() + " ");
        
        prescription.Last_Prescrition_ID();
        PrescriptionID = prescription.getPrescrition_ID();
        PresID.setText(Integer.toString(PrescriptionID));
                
        PatID.setText(Integer.toString(PatientID));
        
        patient.search(PatientID);
        PatientName.setText(patient.getName());
        PatientAge.setText(patient.getAge());
        PatientMobileNumber.setText(patient.getMobile_number());
    }
    
    
    public void For_Viewing_Searching_Suggestions()
    {
        Medicine_List_PopupMenu.add(Medicine_List_Panel);
        mod1 = new DefaultListModel();
        Medicine_List_View.setModel(mod1);
        
        Routine_PopupMenu.add(Routine_Panel);
        mod2 = new DefaultListModel();
        Routine_View.setModel(mod2);
        
        Period_PopupMenu.add(Period_Panel);
        mod3 = new DefaultListModel(); 
        Period_View.setModel(mod3);
        
        Duration_PopupMenu.add(Duration_Panel);
        mod4 = new DefaultListModel(); 
        Duration_View.setModel(mod4);
        
        Condition_PopupMenu.add(Condition_Panel);
        mod5 = new DefaultListModel(); 
        Condition_View.setModel(mod5);
        
        Test_PopupMenu.add(Test_Panel);
        mod6 = new DefaultListModel(); 
        Test_View.setModel(mod6);
        
        FindingProblem_PopupMenu.add(FindingProblem_Panel);
        mod7 = new DefaultListModel(); 
        FindingProblem_View.setModel(mod7);
        
        Advice_PopupMenu.add(Advice_Panel);
        mod8 = new DefaultListModel(); 
        Advice_View.setModel(mod8);
        
        NextAppointment_PopupMenu.add(NextAppointment_Panel);
        mod9 = new DefaultListModel(); 
        NextAppointment_View.setModel(mod9);
        
        Medicine_Type_PopupMenu.add(Medicine_Type_Panel);
        mod10 = new DefaultListModel();
        Medicine_Type_View.setModel(mod1);     
    }
    
      
    public void Medicine_Search_if_not_found_then_insert()
    {
        MedicineID = 0;
        Medicine medicine = new Medicine();
        medicine.Find_ID_from_Name(PresMedicineName.getText());
        MedicineID = medicine.getMedicineID();
            
        if(MedicineID == 0)
        {
            try {
                medicine.Add_to_medicine_list(PresMedicineName.getText(), MedType_text.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            medicine.Find_ID_from_Name(PresMedicineName.getText());
            MedicineID = medicine.getMedicineID();
        }
        
    }

    
    public void Test_Search_if_not_found_then_insert()
    {
        Testid = 0;
        Test test = new Test();
        test.Find_ID_from_Name(PresTest.getText());
        Testid = test.getTest_id();
            
        if(Testid == 0)
        {
            try {
                test.Add_to_test_list(PresTest.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            test.Find_ID_from_Name(PresTest.getText());
            Testid = test.getTest_id();
        }
    }

    
    public void FindingProblem_Search_if_not_found_then_insert()
    {
        Dis_id = 0;
        
        Disease disease = new Disease();
        
        disease.Find_ID_from_Details(PresFindingProblem.getText());
        Dis_id = disease.getDis_id();
            
        if(Dis_id == 0)
        {
            try {
                disease.Add_to_disease_list(PresFindingProblem.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            disease.Find_ID_from_Details(PresFindingProblem.getText());
            Dis_id = disease.getDis_id();
        }
    }
      
    
    public void All_PrescribedMedicines_View()
    {
        Medicine medicine = new Medicine();
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Prescribed_Medicines where Pres_id = '"+ PrescriptionID +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            MedicineList.setModel(new DefaultTableModel(null, new String[] {"Medicine Name", "Medicine Type", "Routine", "Period", "Duration", "Condition"}));
            
            while(res.next())
            {
                medicine.Find_Name_from_ID(res.getInt("med_id"));
                
                
                String tbData[] = {medicine.getMedicineName(),
                                    medicine.getMedicineType(),
                                    res.getString("dosage_routine"),
                                    res.getString("period"),
                                    res.getString("duration"),
                                    res.getString("dosage_condition")};
                DefaultTableModel tbModel = (DefaultTableModel) MedicineList.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        Medicine_Input_Box_Clear();
    }
    
    
    public void All_PrescribedTests_View()
    {
        Test test = new Test();
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Prescribed_Tests where Pres_id = '"+ PrescriptionID +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            TestList.setModel(new DefaultTableModel(null, new String[] {"Prescribed Tests"}));
            
            while(res.next())
            {
                test.Find_Name_from_ID(res.getInt("Test_id"));
                
                String tbData[] = {test.getName()};
                DefaultTableModel tbModel = (DefaultTableModel) TestList.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        PresTest.setText("");
    }    
    
    
    public void All_FindingProblems_View()
    {
        Disease disease = new Disease();
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Finding_Problems where Pres_id = '"+ PrescriptionID +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            ProblemList.setModel(new DefaultTableModel(null, new String[] {"Finding Problems"}));
            
            while(res.next())
            {
                disease.Find_Details_from_ID(res.getInt("Dis_id"));
                
                String tbData[] = {disease.getdetails()};
                DefaultTableModel tbModel = (DefaultTableModel) ProblemList.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        PresFindingProblem.setText("");
    }        
    
    
    public void All_Advices_View()
    {
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Advices where Pres_id = '"+ PrescriptionID +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            AdviceList.setModel(new DefaultTableModel(null, new String[] {"Advices"}));
            
            while(res.next())
            {
                String tbData[] = {res.getString("details")};
                DefaultTableModel tbModel = (DefaultTableModel) AdviceList.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        PresAdvice.setText("");
    }    
    
    
    public void Medicine_Input_Box_Clear()
    {
        PresMedicineName.setText("");
        MedType_text.setText("");
        PresRoutine.setText("");
        PresPeriod.setText("");
        PresDuration.setText("");
        PresCondition.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Medicine_List_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Medicine_List_View = new javax.swing.JList<>();
        Medicine_List_PopupMenu = new javax.swing.JPopupMenu();
        Routine_Panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Routine_View = new javax.swing.JList<>();
        Routine_PopupMenu = new javax.swing.JPopupMenu();
        Period_Panel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Period_View = new javax.swing.JList<>();
        Period_PopupMenu = new javax.swing.JPopupMenu();
        Duration_Panel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Duration_View = new javax.swing.JList<>();
        Duration_PopupMenu = new javax.swing.JPopupMenu();
        Condition_Panel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Condition_View = new javax.swing.JList<>();
        Condition_PopupMenu = new javax.swing.JPopupMenu();
        Test_Panel = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Test_View = new javax.swing.JList<>();
        Test_PopupMenu = new javax.swing.JPopupMenu();
        FindingProblem_Panel = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        FindingProblem_View = new javax.swing.JList<>();
        FindingProblem_PopupMenu = new javax.swing.JPopupMenu();
        Advice_Panel = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Advice_View = new javax.swing.JList<>();
        Advice_PopupMenu = new javax.swing.JPopupMenu();
        NextAppointment_Panel = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        NextAppointment_View = new javax.swing.JList<>();
        NextAppointment_PopupMenu = new javax.swing.JPopupMenu();
        Medicine_Type_Panel = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        Medicine_Type_View = new javax.swing.JList<>();
        Medicine_Type_PopupMenu = new javax.swing.JPopupMenu();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        MedType_text = new javax.swing.JTextField();
        MedicineUpdate = new javax.swing.JButton();
        TestAdd = new javax.swing.JButton();
        MedicineDelete = new javax.swing.JButton();
        MedicineAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        PresID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PatientName = new javax.swing.JTextField();
        PatientAge = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        PatientMobileNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PatID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PresMedicineName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PresRoutine = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PresPeriod = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        MedicineList = new javax.swing.JTable();
        PresDuration = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TestList = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        PresTest = new javax.swing.JTextField();
        PresFindingProblem = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        ProblemList = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        AdviceList = new javax.swing.JTable();
        PresAdvice = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        PatientNextAppointment = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        PresCondition = new javax.swing.JTextField();
        ChamberNameView = new javax.swing.JLabel();
        Confirm = new javax.swing.JButton();
        All_Prescriptions = new javax.swing.JButton();
        TestUpdate = new javax.swing.JButton();
        TestDelete = new javax.swing.JButton();
        ProblemAdd = new javax.swing.JButton();
        ProblemUpdate = new javax.swing.JButton();
        ProblemDelete = new javax.swing.JButton();
        AdviceAdd = new javax.swing.JButton();
        AdviceUpdate = new javax.swing.JButton();
        AdviceDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        Medicine_List_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Medicine_List_ViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Medicine_List_View);

        javax.swing.GroupLayout Medicine_List_PanelLayout = new javax.swing.GroupLayout(Medicine_List_Panel);
        Medicine_List_Panel.setLayout(Medicine_List_PanelLayout);
        Medicine_List_PanelLayout.setHorizontalGroup(
            Medicine_List_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        Medicine_List_PanelLayout.setVerticalGroup(
            Medicine_List_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Medicine_List_PopupMenu.setFocusable(false);

        Routine_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Routine_ViewMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Routine_View);

        javax.swing.GroupLayout Routine_PanelLayout = new javax.swing.GroupLayout(Routine_Panel);
        Routine_Panel.setLayout(Routine_PanelLayout);
        Routine_PanelLayout.setHorizontalGroup(
            Routine_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        Routine_PanelLayout.setVerticalGroup(
            Routine_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        Routine_PopupMenu.setFocusable(false);

        Period_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Period_ViewMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Period_View);

        javax.swing.GroupLayout Period_PanelLayout = new javax.swing.GroupLayout(Period_Panel);
        Period_Panel.setLayout(Period_PanelLayout);
        Period_PanelLayout.setHorizontalGroup(
            Period_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        Period_PanelLayout.setVerticalGroup(
            Period_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Period_PopupMenu.setFocusable(false);

        Duration_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Duration_ViewMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(Duration_View);

        javax.swing.GroupLayout Duration_PanelLayout = new javax.swing.GroupLayout(Duration_Panel);
        Duration_Panel.setLayout(Duration_PanelLayout);
        Duration_PanelLayout.setHorizontalGroup(
            Duration_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Duration_PanelLayout.setVerticalGroup(
            Duration_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Duration_PopupMenu.setFocusable(false);

        Condition_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Condition_ViewMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(Condition_View);

        javax.swing.GroupLayout Condition_PanelLayout = new javax.swing.GroupLayout(Condition_Panel);
        Condition_Panel.setLayout(Condition_PanelLayout);
        Condition_PanelLayout.setHorizontalGroup(
            Condition_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        Condition_PanelLayout.setVerticalGroup(
            Condition_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Condition_PopupMenu.setFocusable(false);

        Test_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Test_ViewMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(Test_View);

        javax.swing.GroupLayout Test_PanelLayout = new javax.swing.GroupLayout(Test_Panel);
        Test_Panel.setLayout(Test_PanelLayout);
        Test_PanelLayout.setHorizontalGroup(
            Test_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );
        Test_PanelLayout.setVerticalGroup(
            Test_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Test_PopupMenu.setFocusable(false);

        FindingProblem_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FindingProblem_ViewMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(FindingProblem_View);

        javax.swing.GroupLayout FindingProblem_PanelLayout = new javax.swing.GroupLayout(FindingProblem_Panel);
        FindingProblem_Panel.setLayout(FindingProblem_PanelLayout);
        FindingProblem_PanelLayout.setHorizontalGroup(
            FindingProblem_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );
        FindingProblem_PanelLayout.setVerticalGroup(
            FindingProblem_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        FindingProblem_PopupMenu.setFocusable(false);

        Advice_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Advice_ViewMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(Advice_View);

        javax.swing.GroupLayout Advice_PanelLayout = new javax.swing.GroupLayout(Advice_Panel);
        Advice_Panel.setLayout(Advice_PanelLayout);
        Advice_PanelLayout.setHorizontalGroup(
            Advice_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        Advice_PanelLayout.setVerticalGroup(
            Advice_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Advice_PopupMenu.setFocusable(false);

        NextAppointment_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NextAppointment_ViewMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(NextAppointment_View);

        javax.swing.GroupLayout NextAppointment_PanelLayout = new javax.swing.GroupLayout(NextAppointment_Panel);
        NextAppointment_Panel.setLayout(NextAppointment_PanelLayout);
        NextAppointment_PanelLayout.setHorizontalGroup(
            NextAppointment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        NextAppointment_PanelLayout.setVerticalGroup(
            NextAppointment_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        NextAppointment_PopupMenu.setFocusable(false);

        Medicine_Type_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Medicine_Type_ViewMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(Medicine_Type_View);

        javax.swing.GroupLayout Medicine_Type_PanelLayout = new javax.swing.GroupLayout(Medicine_Type_Panel);
        Medicine_Type_Panel.setLayout(Medicine_Type_PanelLayout);
        Medicine_Type_PanelLayout.setHorizontalGroup(
            Medicine_Type_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Medicine_Type_PanelLayout.setVerticalGroup(
            Medicine_Type_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Medicine_Type_PopupMenu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 370, 10));

        jSeparator16.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 160, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, 10));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 130, 150, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 80, 10));

        jSeparator17.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator17.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 130, 190, 10));

        jSeparator18.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator18.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, 10));

        jSeparator19.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator19.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 130, 90, 10));

        jSeparator20.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator20.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 310, 10));

        jSeparator21.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator21.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 150, 10));

        jSeparator22.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator22.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 245, 10));

        jSeparator23.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator23.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 82, 10));

        jSeparator24.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator24.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 100, 10));

        jSeparator25.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator25.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 120, 10));

        jSeparator26.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator26.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 310, 10));

        MedType_text.setBackground(new java.awt.Color(232, 245, 253));
        MedType_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MedType_text.setBorder(null);
        MedType_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedType_textMouseClicked(evt);
            }
        });
        MedType_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MedType_textKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MedType_textKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MedType_textKeyTyped(evt);
            }
        });
        getContentPane().add(MedType_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 80, 30));

        MedicineUpdate.setBackground(new java.awt.Color(232, 245, 253));
        MedicineUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MedicineUpdate.setText("Update");
        MedicineUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        MedicineUpdate.setContentAreaFilled(false);
        MedicineUpdate.setOpaque(true);
        MedicineUpdate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MedicineUpdateMouseMoved(evt);
            }
        });
        MedicineUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MedicineUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MedicineUpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MedicineUpdateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MedicineUpdateMouseReleased(evt);
            }
        });
        MedicineUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedicineUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(MedicineUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 180, 90, 30));

        TestAdd.setBackground(new java.awt.Color(232, 245, 253));
        TestAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TestAdd.setText("Add");
        TestAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        TestAdd.setContentAreaFilled(false);
        TestAdd.setOpaque(true);
        TestAdd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TestAddMouseMoved(evt);
            }
        });
        TestAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TestAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TestAddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TestAddMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TestAddMouseReleased(evt);
            }
        });
        TestAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestAddActionPerformed(evt);
            }
        });
        getContentPane().add(TestAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 90, 30));

        MedicineDelete.setBackground(new java.awt.Color(232, 245, 253));
        MedicineDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MedicineDelete.setText("Delete");
        MedicineDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        MedicineDelete.setContentAreaFilled(false);
        MedicineDelete.setOpaque(true);
        MedicineDelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MedicineDeleteMouseMoved(evt);
            }
        });
        MedicineDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MedicineDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MedicineDeleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MedicineDeleteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MedicineDeleteMouseReleased(evt);
            }
        });
        MedicineDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedicineDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(MedicineDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 90, 30));

        MedicineAdd.setBackground(new java.awt.Color(232, 245, 253));
        MedicineAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MedicineAdd.setText("Add");
        MedicineAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        MedicineAdd.setContentAreaFilled(false);
        MedicineAdd.setOpaque(true);
        MedicineAdd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MedicineAddMouseMoved(evt);
            }
        });
        MedicineAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MedicineAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MedicineAddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MedicineAddMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MedicineAddMouseReleased(evt);
            }
        });
        MedicineAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedicineAddActionPerformed(evt);
            }
        });
        getContentPane().add(MedicineAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Prescription ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        PresID.setEditable(false);
        PresID.setBackground(new java.awt.Color(232, 245, 253));
        PresID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresID.setBorder(null);
        getContentPane().add(PresID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        PatientName.setEditable(false);
        PatientName.setBackground(new java.awt.Color(232, 245, 253));
        PatientName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PatientName.setBorder(null);
        PatientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientNameActionPerformed(evt);
            }
        });
        getContentPane().add(PatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 245, 30));

        PatientAge.setEditable(false);
        PatientAge.setBackground(new java.awt.Color(232, 245, 253));
        PatientAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PatientAge.setBorder(null);
        PatientAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientAgeActionPerformed(evt);
            }
        });
        PatientAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PatientAgeKeyTyped(evt);
            }
        });
        getContentPane().add(PatientAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 100, 90, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Mobile number");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 80, -1, -1));

        PatientMobileNumber.setEditable(false);
        PatientMobileNumber.setBackground(new java.awt.Color(232, 245, 253));
        PatientMobileNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PatientMobileNumber.setBorder(null);
        PatientMobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientMobileNumberActionPerformed(evt);
            }
        });
        getContentPane().add(PatientMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 100, 150, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Patient ID");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 20));

        PatID.setEditable(false);
        PatID.setBackground(new java.awt.Color(232, 245, 253));
        PatID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PatID.setBorder(null);
        getContentPane().add(PatID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Medicine Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));

        PresMedicineName.setBackground(new java.awt.Color(232, 245, 253));
        PresMedicineName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresMedicineName.setBorder(null);
        PresMedicineName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PresMedicineNameKeyReleased(evt);
            }
        });
        getContentPane().add(PresMedicineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Type");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        PresRoutine.setBackground(new java.awt.Color(232, 245, 253));
        PresRoutine.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresRoutine.setBorder(null);
        PresRoutine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresRoutineActionPerformed(evt);
            }
        });
        PresRoutine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PresRoutineKeyReleased(evt);
            }
        });
        getContentPane().add(PresRoutine, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Period");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        PresPeriod.setBackground(new java.awt.Color(232, 245, 253));
        PresPeriod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresPeriod.setBorder(null);
        PresPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresPeriodActionPerformed(evt);
            }
        });
        PresPeriod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PresPeriodKeyReleased(evt);
            }
        });
        getContentPane().add(PresPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 120, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Duration");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, -1, -1));

        MedicineList.setBackground(new java.awt.Color(232, 245, 253));
        MedicineList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MedicineList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", "Medicine Type", "Routine", "Period", "Duration", "Condition"
            }
        ));
        MedicineList.setToolTipText("");
        MedicineList.setName(""); // NOI18N
        MedicineList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(MedicineList);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 1070, 170));

        PresDuration.setBackground(new java.awt.Color(232, 245, 253));
        PresDuration.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresDuration.setBorder(null);
        PresDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresDurationActionPerformed(evt);
            }
        });
        PresDuration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PresDurationKeyReleased(evt);
            }
        });
        getContentPane().add(PresDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 80, 30));

        TestList.setBackground(new java.awt.Color(232, 245, 253));
        TestList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TestList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescribed Tests"
            }
        ));
        TestList.setToolTipText("");
        TestList.setName(""); // NOI18N
        TestList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TestList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 310, 150));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tests");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 150, -1));

        PresTest.setBackground(new java.awt.Color(232, 245, 253));
        PresTest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresTest.setBorder(null);
        PresTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresTestActionPerformed(evt);
            }
        });
        PresTest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PresTestKeyReleased(evt);
            }
        });
        getContentPane().add(PresTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 310, 30));

        PresFindingProblem.setBackground(new java.awt.Color(232, 245, 253));
        PresFindingProblem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresFindingProblem.setBorder(null);
        PresFindingProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresFindingProblemActionPerformed(evt);
            }
        });
        PresFindingProblem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PresFindingProblemKeyReleased(evt);
            }
        });
        getContentPane().add(PresFindingProblem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 310, 30));

        ProblemList.setBackground(new java.awt.Color(232, 245, 253));
        ProblemList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ProblemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Finding Problems"
            }
        ));
        ProblemList.setToolTipText("");
        ProblemList.setName(""); // NOI18N
        ProblemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProblemListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ProblemList);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 310, 150));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Finding Problems");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        AdviceList.setBackground(new java.awt.Color(232, 245, 253));
        AdviceList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AdviceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Advices"
            }
        ));
        AdviceList.setToolTipText("");
        AdviceList.setName(""); // NOI18N
        AdviceList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdviceListMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(AdviceList);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, 370, 150));

        PresAdvice.setBackground(new java.awt.Color(232, 245, 253));
        PresAdvice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresAdvice.setBorder(null);
        PresAdvice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresAdviceActionPerformed(evt);
            }
        });
        PresAdvice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PresAdviceKeyReleased(evt);
            }
        });
        getContentPane().add(PresAdvice, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 370, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Advices");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Next Appointment");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 80, -1, -1));

        PatientNextAppointment.setBackground(new java.awt.Color(232, 245, 253));
        PatientNextAppointment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PatientNextAppointment.setBorder(null);
        PatientNextAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientNextAppointmentActionPerformed(evt);
            }
        });
        PatientNextAppointment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PatientNextAppointmentKeyReleased(evt);
            }
        });
        getContentPane().add(PatientNextAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 100, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Age");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 80, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Condition");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, -1, -1));

        PresCondition.setBackground(new java.awt.Color(232, 245, 253));
        PresCondition.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PresCondition.setBorder(null);
        PresCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresConditionActionPerformed(evt);
            }
        });
        PresCondition.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PresConditionKeyReleased(evt);
            }
        });
        getContentPane().add(PresCondition, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 150, 30));

        ChamberNameView.setFont(new java.awt.Font("Monotype Corsiva", 0, 28)); // NOI18N
        ChamberNameView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChamberNameView.setText("Chamber Name");
        getContentPane().add(ChamberNameView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1130, 50));

        Confirm.setBackground(new java.awt.Color(232, 245, 253));
        Confirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Confirm.setText("Confirm");
        Confirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Confirm.setContentAreaFilled(false);
        Confirm.setOpaque(true);
        Confirm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ConfirmMouseMoved(evt);
            }
        });
        Confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConfirmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConfirmMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConfirmMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ConfirmMouseReleased(evt);
            }
        });
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 730, 120, 40));

        All_Prescriptions.setBackground(new java.awt.Color(232, 245, 253));
        All_Prescriptions.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        All_Prescriptions.setText("All Prescriptions");
        All_Prescriptions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        All_Prescriptions.setContentAreaFilled(false);
        All_Prescriptions.setOpaque(true);
        All_Prescriptions.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                All_PrescriptionsMouseMoved(evt);
            }
        });
        All_Prescriptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_PrescriptionsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                All_PrescriptionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                All_PrescriptionsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                All_PrescriptionsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                All_PrescriptionsMouseReleased(evt);
            }
        });
        All_Prescriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                All_PrescriptionsActionPerformed(evt);
            }
        });
        getContentPane().add(All_Prescriptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, 130, 30));

        TestUpdate.setBackground(new java.awt.Color(232, 245, 253));
        TestUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TestUpdate.setText("Update");
        TestUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        TestUpdate.setContentAreaFilled(false);
        TestUpdate.setOpaque(true);
        TestUpdate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TestUpdateMouseMoved(evt);
            }
        });
        TestUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TestUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TestUpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TestUpdateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TestUpdateMouseReleased(evt);
            }
        });
        TestUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(TestUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 90, 30));

        TestDelete.setBackground(new java.awt.Color(232, 245, 253));
        TestDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TestDelete.setText("Delete");
        TestDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        TestDelete.setContentAreaFilled(false);
        TestDelete.setOpaque(true);
        TestDelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TestDeleteMouseMoved(evt);
            }
        });
        TestDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TestDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TestDeleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TestDeleteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TestDeleteMouseReleased(evt);
            }
        });
        TestDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(TestDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 90, 30));

        ProblemAdd.setBackground(new java.awt.Color(232, 245, 253));
        ProblemAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProblemAdd.setText("Add");
        ProblemAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        ProblemAdd.setContentAreaFilled(false);
        ProblemAdd.setOpaque(true);
        ProblemAdd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ProblemAddMouseMoved(evt);
            }
        });
        ProblemAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProblemAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProblemAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProblemAddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProblemAddMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ProblemAddMouseReleased(evt);
            }
        });
        ProblemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemAddActionPerformed(evt);
            }
        });
        getContentPane().add(ProblemAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 490, 90, 30));

        ProblemUpdate.setBackground(new java.awt.Color(232, 245, 253));
        ProblemUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProblemUpdate.setText("Update");
        ProblemUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        ProblemUpdate.setContentAreaFilled(false);
        ProblemUpdate.setOpaque(true);
        ProblemUpdate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ProblemUpdateMouseMoved(evt);
            }
        });
        ProblemUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProblemUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProblemUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProblemUpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProblemUpdateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ProblemUpdateMouseReleased(evt);
            }
        });
        ProblemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(ProblemUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 90, 30));

        ProblemDelete.setBackground(new java.awt.Color(232, 245, 253));
        ProblemDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProblemDelete.setText("Delete");
        ProblemDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        ProblemDelete.setContentAreaFilled(false);
        ProblemDelete.setOpaque(true);
        ProblemDelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ProblemDeleteMouseMoved(evt);
            }
        });
        ProblemDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProblemDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProblemDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProblemDeleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProblemDeleteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ProblemDeleteMouseReleased(evt);
            }
        });
        ProblemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProblemDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(ProblemDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 90, 30));

        AdviceAdd.setBackground(new java.awt.Color(232, 245, 253));
        AdviceAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdviceAdd.setText("Add");
        AdviceAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        AdviceAdd.setContentAreaFilled(false);
        AdviceAdd.setOpaque(true);
        AdviceAdd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AdviceAddMouseMoved(evt);
            }
        });
        AdviceAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdviceAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdviceAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdviceAddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AdviceAddMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AdviceAddMouseReleased(evt);
            }
        });
        AdviceAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdviceAddActionPerformed(evt);
            }
        });
        getContentPane().add(AdviceAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 90, 30));

        AdviceUpdate.setBackground(new java.awt.Color(232, 245, 253));
        AdviceUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdviceUpdate.setText("Update");
        AdviceUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        AdviceUpdate.setContentAreaFilled(false);
        AdviceUpdate.setOpaque(true);
        AdviceUpdate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AdviceUpdateMouseMoved(evt);
            }
        });
        AdviceUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdviceUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdviceUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdviceUpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AdviceUpdateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AdviceUpdateMouseReleased(evt);
            }
        });
        AdviceUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdviceUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(AdviceUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 490, 90, 30));

        AdviceDelete.setBackground(new java.awt.Color(232, 245, 253));
        AdviceDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdviceDelete.setText("Delete");
        AdviceDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        AdviceDelete.setContentAreaFilled(false);
        AdviceDelete.setOpaque(true);
        AdviceDelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AdviceDeleteMouseMoved(evt);
            }
        });
        AdviceDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdviceDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdviceDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdviceDeleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AdviceDeleteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AdviceDeleteMouseReleased(evt);
            }
        });
        AdviceDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdviceDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(AdviceDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 490, 90, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Routine");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg7.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PatientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientNameActionPerformed

    private void PatientAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientAgeActionPerformed

    private void PatientMobileNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientMobileNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientMobileNumberActionPerformed

    private void PresRoutineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresRoutineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresRoutineActionPerformed

    private void PresPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresPeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresPeriodActionPerformed

    private void PresDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresDurationActionPerformed

    private void TestListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestListMouseClicked
        
        int i = TestList.getSelectedRow();
        TableModel model = TestList.getModel();
        Prev_Test = (String) model.getValueAt(i, 0);
        PresTest.setText((String) model.getValueAt(i, 0));
        
    }//GEN-LAST:event_TestListMouseClicked

    private void PresTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresTestActionPerformed

    private void MedicineListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineListMouseClicked
        int i = MedicineList.getSelectedRow();

        // Check if a row is selected
        if (i != -1) {
            TableModel model = MedicineList.getModel();

            PresMedicineName.setText((String) model.getValueAt(i, 0));
            Prev_Medicine = (String) model.getValueAt(i, 0);
            MedType_text.setText((String) model.getValueAt(i, 1));
            PresRoutine.setText((String) model.getValueAt(i, 2));
            PresPeriod.setText((String) model.getValueAt(i, 3));
            PresDuration.setText((String) model.getValueAt(i, 4));
            PresCondition.setText((String) model.getValueAt(i, 5));
        } else {
            // Handle the case when no row is selected, e.g., display a message or clear fields
            PresMedicineName.setText("");
            Prev_Medicine = "";
            MedType_text.setText("");
            PresRoutine.setText("");
            PresPeriod.setText("");
            PresDuration.setText("");
            PresCondition.setText("");
        }

    }//GEN-LAST:event_MedicineListMouseClicked

    private void PresFindingProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresFindingProblemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresFindingProblemActionPerformed

    private void ProblemListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemListMouseClicked
        
        int i = ProblemList.getSelectedRow();
        TableModel model = ProblemList.getModel();
        Prev_Problem = (String) model.getValueAt(i, 0);
        PresFindingProblem.setText((String) model.getValueAt(i, 0));
        
    }//GEN-LAST:event_ProblemListMouseClicked

    private void AdviceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceListMouseClicked
        
        int i = AdviceList.getSelectedRow();
        TableModel model = AdviceList.getModel();
        Prev_Advice = (String) model.getValueAt(i, 0);
        PresAdvice.setText((String) model.getValueAt(i, 0));
        
    }//GEN-LAST:event_AdviceListMouseClicked

    private void PresAdviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresAdviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresAdviceActionPerformed

    private void PatientNextAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientNextAppointmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientNextAppointmentActionPerformed

    private void PresConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresConditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresConditionActionPerformed

    private void PresMedicineNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PresMedicineNameKeyReleased
        
        Medicine_List_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PresMedicineName.getText().trim().isEmpty())
        {
            mod1.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                
                String sql = "SELECT * FROM medicine WHERE med_name LIKE '" + PresMedicineName.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod1.addElement(res.getString("med_name"));
                } 
            } catch (SQLException | ClassNotFoundException ex) {}
            
            Medicine_List_PopupMenu.show(PresMedicineName, 0, PresMedicineName.getHeight());
            
        }
            
    }//GEN-LAST:event_PresMedicineNameKeyReleased

    private void Medicine_List_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Medicine_List_ViewMouseClicked
        
        PresMedicineName.setText(Medicine_List_View.getSelectedValue());
        
        Medicine medicine = new Medicine();
        medicine.Find_ID_from_Name(PresMedicineName.getText());
        MedicineType = medicine.getMedicineType();
        MedType_text.setText(medicine.getMedicineType());        
    
        Medicine_List_PopupMenu.hide();
        
    }//GEN-LAST:event_Medicine_List_ViewMouseClicked

    private void Routine_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Routine_ViewMouseClicked
        PresRoutine.setText(Routine_View.getSelectedValue());
        Routine_PopupMenu.hide();
    }//GEN-LAST:event_Routine_ViewMouseClicked

    private void Period_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Period_ViewMouseClicked
        PresPeriod.setText(Period_View.getSelectedValue());
        Period_PopupMenu.hide();
    }//GEN-LAST:event_Period_ViewMouseClicked

    private void Duration_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Duration_ViewMouseClicked
        PresDuration.setText(Duration_View.getSelectedValue());
        Duration_PopupMenu.hide();
    }//GEN-LAST:event_Duration_ViewMouseClicked

    private void Condition_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Condition_ViewMouseClicked
        PresCondition.setText(Condition_View.getSelectedValue());
        Condition_PopupMenu.hide();
    }//GEN-LAST:event_Condition_ViewMouseClicked

    private void PresRoutineKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PresRoutineKeyReleased
        
        Routine_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PresRoutine.getText().trim().isEmpty())
        {
            mod2.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT dosage_routine FROM Prescribed_Medicines WHERE dosage_routine LIKE '" + PresRoutine.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod2.addElement(res.getString("dosage_routine"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Routine_PopupMenu.show(PresRoutine, 0, PresRoutine.getHeight());
            
        }
    }//GEN-LAST:event_PresRoutineKeyReleased

    private void PresPeriodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PresPeriodKeyReleased
        
        Period_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PresPeriod.getText().trim().isEmpty())
        {
            mod3.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT period FROM Prescribed_Medicines WHERE period LIKE '" + PresPeriod.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod3.addElement(res.getString("period"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Period_PopupMenu.show(PresPeriod, 0, PresPeriod.getHeight());
            
        }
    }//GEN-LAST:event_PresPeriodKeyReleased

    private void PresDurationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PresDurationKeyReleased
        
        Duration_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PresDuration.getText().trim().isEmpty())
        {
            mod4.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT duration FROM Prescribed_Medicines WHERE duration LIKE '" + PresDuration.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod4.addElement(res.getString("duration"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Duration_PopupMenu.show(PresDuration, 0, PresDuration.getHeight());
            
        }
    }//GEN-LAST:event_PresDurationKeyReleased

    private void PresConditionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PresConditionKeyReleased
        
        Condition_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PresCondition.getText().trim().isEmpty())
        {
            mod5.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT dosage_condition FROM Prescribed_Medicines WHERE dosage_condition LIKE '" + PresCondition.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod5.addElement(res.getString("dosage_condition"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Condition_PopupMenu.show(PresCondition, 0, PresCondition.getHeight());
            
        }
    }//GEN-LAST:event_PresConditionKeyReleased

    private void Test_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Test_ViewMouseClicked
        PresTest.setText(Test_View.getSelectedValue());
        Test_PopupMenu.hide();
    }//GEN-LAST:event_Test_ViewMouseClicked

    private void FindingProblem_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FindingProblem_ViewMouseClicked
        PresFindingProblem.setText(FindingProblem_View.getSelectedValue());
        FindingProblem_PopupMenu.hide();
    }//GEN-LAST:event_FindingProblem_ViewMouseClicked

    private void Advice_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Advice_ViewMouseClicked
        PresAdvice.setText(Advice_View.getSelectedValue());
        Advice_PopupMenu.hide();
    }//GEN-LAST:event_Advice_ViewMouseClicked

    private void PresTestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PresTestKeyReleased
        
        Test_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PresTest.getText().trim().isEmpty())
        {
            mod6.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT * FROM Test WHERE Name LIKE '" + PresTest.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod6.addElement(res.getString("Name"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Test_PopupMenu.show(PresTest, 0, PresTest.getHeight());
            
        }
    }//GEN-LAST:event_PresTestKeyReleased

    private void PresFindingProblemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PresFindingProblemKeyReleased
        
        FindingProblem_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PresFindingProblem.getText().trim().isEmpty())
        {
            mod7.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT * FROM Diseases WHERE details LIKE '" + PresFindingProblem.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod7.addElement(res.getString("details"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            FindingProblem_PopupMenu.show(PresFindingProblem, 0, PresFindingProblem.getHeight());
            
        }
    }//GEN-LAST:event_PresFindingProblemKeyReleased

    private void PresAdviceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PresAdviceKeyReleased
        
        Advice_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PresAdvice.getText().trim().isEmpty())
        {
            mod8.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT details FROM Advices WHERE details LIKE '" + PresAdvice.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod8.addElement(res.getString("details"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Advice_PopupMenu.show(PresAdvice, 0, PresAdvice.getHeight());
            
        }
    }//GEN-LAST:event_PresAdviceKeyReleased

    private void NextAppointment_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextAppointment_ViewMouseClicked
        PatientNextAppointment.setText(NextAppointment_View.getSelectedValue());
        NextAppointment_PopupMenu.hide();
    }//GEN-LAST:event_NextAppointment_ViewMouseClicked

    private void PatientNextAppointmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PatientNextAppointmentKeyReleased
        
        NextAppointment_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!PatientNextAppointment.getText().trim().equals(""))
        {
            mod9.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT NextAppointment FROM Prescription WHERE NextAppointment LIKE '" + PatientNextAppointment.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod9.addElement(res.getString("NextAppointment"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            NextAppointment_PopupMenu.show(PatientNextAppointment, 0, PatientNextAppointment.getHeight());
            
        }
    }//GEN-LAST:event_PatientNextAppointmentKeyReleased

    private void ConfirmMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseMoved
        Confirm.setCursor(SignIN.cursor);
    }//GEN-LAST:event_ConfirmMouseMoved

    private void ConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseClicked
        Confirm.setBackground(new Color(0,0,255).brighter());
        Confirm.setForeground(Color.WHITE);
    }//GEN-LAST:event_ConfirmMouseClicked

    private void ConfirmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseEntered
        Confirm.setBackground(new Color(0,153,255).brighter());
        Confirm.setForeground(Color.BLACK);
    }//GEN-LAST:event_ConfirmMouseEntered

    private void ConfirmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseExited
        Confirm.setBackground(new Color(232,245,253));
        Confirm.setForeground(Color.BLACK);
    }//GEN-LAST:event_ConfirmMouseExited

    private void ConfirmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMousePressed
        Confirm.setBackground(new Color(0,0,255).brighter());
        Confirm.setForeground(Color.WHITE);
    }//GEN-LAST:event_ConfirmMousePressed

    private void ConfirmMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseReleased
        Confirm.setBackground(new Color(232,245,253));
        Confirm.setForeground(Color.BLACK);
    }//GEN-LAST:event_ConfirmMouseReleased

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        
        Prescription prescription = new Prescription();        
        
        try {
            prescription.Next_Appointment_Update(PrescriptionID, PatientNextAppointment.getText());
            new Prescription_View(PrescriptionID, PatientID, ChamberNameView.getText()).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_ConfirmActionPerformed

    private void All_PrescriptionsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_PrescriptionsMouseMoved
        All_Prescriptions.setCursor(SignIN.cursor);
    }//GEN-LAST:event_All_PrescriptionsMouseMoved

    private void All_PrescriptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_PrescriptionsMouseClicked
        All_Prescriptions.setBackground(new Color(0,0,255).brighter());
        All_Prescriptions.setForeground(Color.WHITE);
    }//GEN-LAST:event_All_PrescriptionsMouseClicked

    private void All_PrescriptionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_PrescriptionsMouseEntered
        All_Prescriptions.setBackground(new Color(0,153,255).brighter());
        All_Prescriptions.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_PrescriptionsMouseEntered

    private void All_PrescriptionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_PrescriptionsMouseExited
        All_Prescriptions.setBackground(new Color(232,245,253));
        All_Prescriptions.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_PrescriptionsMouseExited

    private void All_PrescriptionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_PrescriptionsMousePressed
        All_Prescriptions.setBackground(new Color(0,0,255).brighter());
        All_Prescriptions.setForeground(Color.WHITE);
    }//GEN-LAST:event_All_PrescriptionsMousePressed

    private void All_PrescriptionsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_PrescriptionsMouseReleased
        All_Prescriptions.setBackground(new Color(232,245,253));
        All_Prescriptions.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_PrescriptionsMouseReleased

    private void All_PrescriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_PrescriptionsActionPerformed
        new Prescription_List(PrescriptionID, PatientID, ChamberNameView.getText()).setVisible(true);
    }//GEN-LAST:event_All_PrescriptionsActionPerformed

    private void MedicineAddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineAddMouseMoved
        MedicineAdd.setCursor(SignIN.cursor);
    }//GEN-LAST:event_MedicineAddMouseMoved

    private void MedicineAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineAddMouseClicked
        MedicineAdd.setBackground(new Color(0,0,255).brighter());
        MedicineAdd.setForeground(Color.WHITE);
    }//GEN-LAST:event_MedicineAddMouseClicked

    private void MedicineAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineAddMouseEntered
        MedicineAdd.setBackground(new Color(0,153,255).brighter());
        MedicineAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineAddMouseEntered

    private void MedicineAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineAddMouseExited
        MedicineAdd.setBackground(new Color(232,245,253));
        MedicineAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineAddMouseExited

    private void MedicineAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineAddMousePressed
        MedicineAdd.setBackground(new Color(0,0,255).brighter());
        MedicineAdd.setForeground(Color.WHITE);
    }//GEN-LAST:event_MedicineAddMousePressed

    private void MedicineAddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineAddMouseReleased
        MedicineAdd.setBackground(new Color(232,245,253));
        MedicineAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineAddMouseReleased

    private void MedicineAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicineAddActionPerformed
        
        if(PresMedicineName.getText().trim().equals("") || MedType_text.getText().trim().equals("") || PresRoutine.getText().trim().equals("") || PresPeriod.getText().trim().equals("") || PresDuration.getText().trim().equals(""))
        {        
        }
        else
        {
            Medicine_Search_if_not_found_then_insert();  
            PrescribedMedicines prescribedMedicines = new PrescribedMedicines();
            
            try { 
                prescribedMedicines.insert_into_Prescribed_Medicines(PrescriptionID, MedicineID, PresRoutine.getText(), PresPeriod.getText(), PresDuration.getText(), PresCondition.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_PrescribedMedicines_View();

        }
    }//GEN-LAST:event_MedicineAddActionPerformed

    private void MedicineUpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineUpdateMouseMoved
        MedicineUpdate.setCursor(SignIN.cursor);
    }//GEN-LAST:event_MedicineUpdateMouseMoved

    private void MedicineUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineUpdateMouseClicked
        MedicineUpdate.setBackground(new Color(0,0,255).brighter());
        MedicineUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_MedicineUpdateMouseClicked

    private void MedicineUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineUpdateMouseEntered
        MedicineUpdate.setBackground(new Color(0,153,255).brighter());
        MedicineUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineUpdateMouseEntered

    private void MedicineUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineUpdateMouseExited
        MedicineUpdate.setBackground(new Color(232,245,253));
        MedicineUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineUpdateMouseExited

    private void MedicineUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineUpdateMousePressed
        MedicineUpdate.setBackground(new Color(0,0,255).brighter());
        MedicineUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_MedicineUpdateMousePressed

    private void MedicineUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineUpdateMouseReleased
        MedicineUpdate.setBackground(new Color(232,245,253));
        MedicineUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineUpdateMouseReleased

    private void MedicineUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicineUpdateActionPerformed
        if(PresMedicineName.getText().trim().equals("") || MedType_text.getText().trim().equals("") || PresRoutine.getText().trim().equals("") || PresPeriod.getText().trim().equals("") || PresDuration.getText().trim().equals(""))
        {        
        }
        else
        {
            Medicine medicine = new Medicine();            
            PrescribedMedicines prescribedMedicines = new PrescribedMedicines();
            
            try {
                prescribedMedicines.Find_PresMed_id(PrescriptionID, Prev_Medicine);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            PresMed_id = prescribedMedicines.getPresMed_id();
            
            Medicine_Search_if_not_found_then_insert(); 
            
            medicine.Find_ID_from_Name(PresMedicineName.getText());
            
            MedicineID = medicine.getMedicineID();
            
            try {                
                prescribedMedicines.PrescribedMedicine_Update(PresMed_id, MedicineID, PresRoutine.getText(), PresPeriod.getText(), PresDuration.getText(), PresCondition.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }   
            
            All_PrescribedMedicines_View();
        }
    }//GEN-LAST:event_MedicineUpdateActionPerformed

    private void MedicineDeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineDeleteMouseMoved
        MedicineDelete.setCursor(SignIN.cursor);
    }//GEN-LAST:event_MedicineDeleteMouseMoved

    private void MedicineDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineDeleteMouseClicked
        MedicineDelete.setBackground(new Color(0,0,255).brighter());
        MedicineDelete.setForeground(Color.WHITE);
    }//GEN-LAST:event_MedicineDeleteMouseClicked

    private void MedicineDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineDeleteMouseEntered
        MedicineDelete.setBackground(new Color(0,153,255).brighter());
        MedicineDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineDeleteMouseEntered

    private void MedicineDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineDeleteMouseExited
        MedicineDelete.setBackground(new Color(232,245,253));
        MedicineDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineDeleteMouseExited

    private void MedicineDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineDeleteMousePressed
        MedicineDelete.setBackground(new Color(0,0,255).brighter());
        MedicineDelete.setForeground(Color.WHITE);
    }//GEN-LAST:event_MedicineDeleteMousePressed

    private void MedicineDeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineDeleteMouseReleased
        MedicineDelete.setBackground(new Color(232,245,253));
        MedicineDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_MedicineDeleteMouseReleased

    private void MedicineDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicineDeleteActionPerformed

        if(PresMedicineName.getText().trim().equals("") || MedType_text.getText().trim().equals("") || PresRoutine.getText().trim().equals("") || PresPeriod.getText().trim().equals("") || PresDuration.getText().trim().equals(""))
        {        
        }
        else
        {
            Medicine medicine = new Medicine();
            PrescribedMedicines prescribedMedicines = new PrescribedMedicines();
            
            medicine.Find_ID_from_Name(PresMedicineName.getText());
            MedicineID = medicine.getMedicineID();
            try {
                prescribedMedicines.Medicine_Delete_from_list(PrescriptionID, MedicineID);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_PrescribedMedicines_View();
            
        }
        
    }//GEN-LAST:event_MedicineDeleteActionPerformed

    private void TestAddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestAddMouseMoved
        TestAdd.setCursor(SignIN.cursor);
    }//GEN-LAST:event_TestAddMouseMoved

    private void TestAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestAddMouseClicked
        TestAdd.setBackground(new Color(0,0,255).brighter());
        TestAdd.setForeground(Color.WHITE);
    }//GEN-LAST:event_TestAddMouseClicked

    private void TestAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestAddMouseEntered
        TestAdd.setBackground(new Color(0,153,255).brighter());
        TestAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestAddMouseEntered

    private void TestAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestAddMouseExited
        TestAdd.setBackground(new Color(232,245,253));
        TestAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestAddMouseExited

    private void TestAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestAddMousePressed
        TestAdd.setBackground(new Color(0,0,255).brighter());
        TestAdd.setForeground(Color.WHITE);
    }//GEN-LAST:event_TestAddMousePressed

    private void TestAddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestAddMouseReleased
        TestAdd.setBackground(new Color(232,245,253));
        TestAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestAddMouseReleased

    private void TestAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestAddActionPerformed
        
        if(PresTest.getText().trim().equals(""))
        {        
        }
        else
        {
            Test_Search_if_not_found_then_insert();  
            PrescribedTest prescribedTest = new PrescribedTest();
            
            try { 
                prescribedTest.insert_into_Prescribed_Test(PrescriptionID, Testid);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_PrescribedTests_View();
            
        }
    }//GEN-LAST:event_TestAddActionPerformed

    private void TestUpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestUpdateMouseMoved
        TestUpdate.setCursor(SignIN.cursor);
    }//GEN-LAST:event_TestUpdateMouseMoved

    private void TestUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestUpdateMouseClicked
        TestUpdate.setBackground(new Color(0,0,255).brighter());
        TestUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_TestUpdateMouseClicked

    private void TestUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestUpdateMouseEntered
        TestUpdate.setBackground(new Color(0,153,255).brighter());
        TestUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestUpdateMouseEntered

    private void TestUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestUpdateMouseExited
        TestUpdate.setBackground(new Color(232,245,253));
        TestUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestUpdateMouseExited

    private void TestUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestUpdateMousePressed
        TestUpdate.setBackground(new Color(0,0,255).brighter());
        TestUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_TestUpdateMousePressed

    private void TestUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestUpdateMouseReleased
        TestUpdate.setBackground(new Color(232,245,253));
        TestUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestUpdateMouseReleased

    private void TestUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestUpdateActionPerformed
        
        if(PresTest.getText().trim().equals("")){}
        else
        {
            PrescribedTest prescribedTest = new PrescribedTest();
            try {
                prescribedTest.Find_PresTest_id(PrescriptionID, Prev_Test);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            PresTest_id = prescribedTest.getPresTest_id();
            
            Test_Search_if_not_found_then_insert();  
            
            try {
                prescribedTest.PrescribedTest_Update(PresTest_id, Testid);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_PrescribedTests_View();
        }
    }//GEN-LAST:event_TestUpdateActionPerformed

    private void TestDeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestDeleteMouseMoved
        TestDelete.setCursor(SignIN.cursor);
    }//GEN-LAST:event_TestDeleteMouseMoved

    private void TestDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestDeleteMouseClicked
        TestDelete.setBackground(new Color(0,0,255).brighter());
        TestDelete.setForeground(Color.WHITE);
    }//GEN-LAST:event_TestDeleteMouseClicked

    private void TestDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestDeleteMouseEntered
        TestDelete.setBackground(new Color(0,153,255).brighter());
        TestDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestDeleteMouseEntered

    private void TestDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestDeleteMouseExited
        TestDelete.setBackground(new Color(232,245,253));
        TestDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestDeleteMouseExited

    private void TestDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestDeleteMousePressed
        TestDelete.setBackground(new Color(0,0,255).brighter());
        TestDelete.setForeground(Color.WHITE);
    }//GEN-LAST:event_TestDeleteMousePressed

    private void TestDeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestDeleteMouseReleased
        TestDelete.setBackground(new Color(232,245,253));
        TestDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_TestDeleteMouseReleased

    private void TestDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestDeleteActionPerformed
        if(PresTest.getText().trim().equals("")){}
        else
        {
            Test test = new Test();
            PrescribedTest prescribedTest = new PrescribedTest();
            
            test.Find_ID_from_Name(PresTest.getText());
            Testid = test.getTest_id();
            try {
                prescribedTest.PrescribedTest_Delete(PrescriptionID, Testid);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_PrescribedTests_View();
        }
    }//GEN-LAST:event_TestDeleteActionPerformed

    private void ProblemAddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemAddMouseMoved
        ProblemAdd.setCursor(SignIN.cursor);
    }//GEN-LAST:event_ProblemAddMouseMoved

    private void ProblemAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemAddMouseClicked
        ProblemAdd.setBackground(new Color(0,0,255).brighter());
        ProblemAdd.setForeground(Color.WHITE);
    }//GEN-LAST:event_ProblemAddMouseClicked

    private void ProblemAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemAddMouseEntered
        ProblemAdd.setBackground(new Color(0,153,255).brighter());
        ProblemAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemAddMouseEntered

    private void ProblemAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemAddMouseExited
        ProblemAdd.setBackground(new Color(232,245,253));
        ProblemAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemAddMouseExited

    private void ProblemAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemAddMousePressed
        ProblemAdd.setBackground(new Color(0,0,255).brighter());
        ProblemAdd.setForeground(Color.WHITE);
    }//GEN-LAST:event_ProblemAddMousePressed

    private void ProblemAddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemAddMouseReleased
        ProblemAdd.setBackground(new Color(232,245,253));
        ProblemAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemAddMouseReleased

    private void ProblemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemAddActionPerformed
        
        if(PresFindingProblem.getText().trim().equals(""))
        {        
        }
        else
        {
            FindingProblem_Search_if_not_found_then_insert();  
            FindingProblem findingProblem = new FindingProblem();
            
            try { 
                findingProblem.insert_into_Finding_Problem(PrescriptionID, Dis_id);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_FindingProblems_View();
            
        }
    }//GEN-LAST:event_ProblemAddActionPerformed

    private void ProblemUpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemUpdateMouseMoved
        ProblemUpdate.setCursor(SignIN.cursor);
    }//GEN-LAST:event_ProblemUpdateMouseMoved

    private void ProblemUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemUpdateMouseClicked
        ProblemUpdate.setBackground(new Color(0,0,255).brighter());
        ProblemUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_ProblemUpdateMouseClicked

    private void ProblemUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemUpdateMouseEntered
        ProblemUpdate.setBackground(new Color(0,153,255).brighter());
        ProblemUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemUpdateMouseEntered

    private void ProblemUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemUpdateMouseExited
        ProblemUpdate.setBackground(new Color(232,245,253));
        ProblemUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemUpdateMouseExited

    private void ProblemUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemUpdateMousePressed
        ProblemUpdate.setBackground(new Color(0,0,255).brighter());
        ProblemUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_ProblemUpdateMousePressed

    private void ProblemUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemUpdateMouseReleased
        ProblemUpdate.setBackground(new Color(232,245,253));
        ProblemUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemUpdateMouseReleased

    private void ProblemUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemUpdateActionPerformed
        
        if(PresFindingProblem.getText().trim().equals("")){}
        else
        {
            FindingProblem findingProblem = new FindingProblem();
            try {
                findingProblem.Find_FindProb_id(PrescriptionID, Prev_Problem);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            FindProb_id = findingProblem.getFindProb_id();
            
            FindingProblem_Search_if_not_found_then_insert();
            
            try {
                findingProblem.FindingProblem_Update(FindProb_id, Dis_id);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_FindingProblems_View();
            
        }
    }//GEN-LAST:event_ProblemUpdateActionPerformed

    private void ProblemDeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemDeleteMouseMoved
        ProblemDelete.setCursor(SignIN.cursor);
    }//GEN-LAST:event_ProblemDeleteMouseMoved

    private void ProblemDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemDeleteMouseClicked
        ProblemDelete.setBackground(new Color(0,0,255).brighter());
        ProblemDelete.setForeground(Color.WHITE);
    }//GEN-LAST:event_ProblemDeleteMouseClicked

    private void ProblemDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemDeleteMouseEntered
        ProblemDelete.setBackground(new Color(0,153,255).brighter());
        ProblemDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemDeleteMouseEntered

    private void ProblemDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemDeleteMouseExited
        ProblemDelete.setBackground(new Color(232,245,253));
        ProblemDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemDeleteMouseExited

    private void ProblemDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemDeleteMousePressed
        ProblemDelete.setBackground(new Color(0,0,255).brighter());
        ProblemDelete.setForeground(Color.WHITE);
    }//GEN-LAST:event_ProblemDeleteMousePressed

    private void ProblemDeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProblemDeleteMouseReleased
        ProblemDelete.setBackground(new Color(232,245,253));
        ProblemDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_ProblemDeleteMouseReleased

    private void ProblemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProblemDeleteActionPerformed
        
        if(PresFindingProblem.getText().trim().equals("")){}
        else
        {
            Disease disease = new Disease();
            FindingProblem findingProblem = new FindingProblem();
            
            disease.Find_ID_from_Details(PresFindingProblem.getText());
            Dis_id = disease.getDis_id();
            try {
                findingProblem.FindingProblem_Delete(PrescriptionID, Dis_id);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_FindingProblems_View();
        }
    }//GEN-LAST:event_ProblemDeleteActionPerformed

    private void AdviceAddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceAddMouseMoved
        AdviceAdd.setCursor(SignIN.cursor);
    }//GEN-LAST:event_AdviceAddMouseMoved

    private void AdviceAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceAddMouseClicked
        AdviceAdd.setBackground(new Color(0,0,255).brighter());
        AdviceAdd.setForeground(Color.WHITE);
    }//GEN-LAST:event_AdviceAddMouseClicked

    private void AdviceAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceAddMouseEntered
        AdviceAdd.setBackground(new Color(0,153,255).brighter());
        AdviceAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceAddMouseEntered

    private void AdviceAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceAddMouseExited
        AdviceAdd.setBackground(new Color(232,245,253));
        AdviceAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceAddMouseExited

    private void AdviceAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceAddMousePressed
        AdviceAdd.setBackground(new Color(0,0,255).brighter());
        AdviceAdd.setForeground(Color.WHITE);
    }//GEN-LAST:event_AdviceAddMousePressed

    private void AdviceAddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceAddMouseReleased
        AdviceAdd.setBackground(new Color(232,245,253));
        AdviceAdd.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceAddMouseReleased

    private void AdviceAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdviceAddActionPerformed
        
        if(PresAdvice.getText().trim().equals("")){}
        else
        {
            Advice advice = new Advice();
            
            try { 
                advice.insert_into_Advices(PrescriptionID, PresAdvice.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_Advices_View();            
        }
    }//GEN-LAST:event_AdviceAddActionPerformed

    private void AdviceUpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceUpdateMouseMoved
        AdviceUpdate.setCursor(SignIN.cursor);
    }//GEN-LAST:event_AdviceUpdateMouseMoved

    private void AdviceUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceUpdateMouseClicked
        AdviceUpdate.setBackground(new Color(0,0,255).brighter());
        AdviceUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_AdviceUpdateMouseClicked

    private void AdviceUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceUpdateMouseEntered
        AdviceUpdate.setBackground(new Color(0,153,255).brighter());
        AdviceUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceUpdateMouseEntered

    private void AdviceUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceUpdateMouseExited
        AdviceUpdate.setBackground(new Color(232,245,253));
        AdviceUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceUpdateMouseExited

    private void AdviceUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceUpdateMousePressed
        AdviceUpdate.setBackground(new Color(0,0,255).brighter());
        AdviceUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_AdviceUpdateMousePressed

    private void AdviceUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceUpdateMouseReleased
        AdviceUpdate.setBackground(new Color(232,245,253));
        AdviceUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceUpdateMouseReleased

    private void AdviceUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdviceUpdateActionPerformed
        
        if(PresAdvice.getText().trim().equals("")){}
        else
        {
            Advice advice = new Advice();
            try {
                advice.Find_Advice_id(PrescriptionID, Prev_Advice);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            FindAdv_id = 0;
            FindAdv_id = advice.getAdv_id();
            
            try {
                advice.Advice_Update(FindAdv_id, PresAdvice.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_Advices_View();            
        }
    }//GEN-LAST:event_AdviceUpdateActionPerformed

    private void AdviceDeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceDeleteMouseMoved
        AdviceDelete.setCursor(SignIN.cursor);
    }//GEN-LAST:event_AdviceDeleteMouseMoved

    private void AdviceDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceDeleteMouseClicked
        AdviceDelete.setBackground(new Color(0,0,255).brighter());
        AdviceDelete.setForeground(Color.WHITE);
    }//GEN-LAST:event_AdviceDeleteMouseClicked

    private void AdviceDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceDeleteMouseEntered
        AdviceDelete.setBackground(new Color(0,153,255).brighter());
        AdviceDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceDeleteMouseEntered

    private void AdviceDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceDeleteMouseExited
        AdviceDelete.setBackground(new Color(232,245,253));
        AdviceDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceDeleteMouseExited

    private void AdviceDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceDeleteMousePressed
        AdviceDelete.setBackground(new Color(0,0,255).brighter());
        AdviceDelete.setForeground(Color.WHITE);
    }//GEN-LAST:event_AdviceDeleteMousePressed

    private void AdviceDeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdviceDeleteMouseReleased
        AdviceDelete.setBackground(new Color(232,245,253));
        AdviceDelete.setForeground(Color.BLACK);
    }//GEN-LAST:event_AdviceDeleteMouseReleased

    private void AdviceDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdviceDeleteActionPerformed
        
        if(PresAdvice.getText().trim().equals("")){}
        else
        {
            Advice advice = new Advice();
            
            try {
                advice.Advice_Delete(PrescriptionID, PresAdvice.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            All_Advices_View();            
        }
    }//GEN-LAST:event_AdviceDeleteActionPerformed

    private void MedType_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedType_textMouseClicked

    }//GEN-LAST:event_MedType_textMouseClicked

    private void MedType_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedType_textKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedType_textKeyPressed

    private void MedType_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedType_textKeyReleased

        Medicine_Type_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!MedType_text.getText().trim().isEmpty())
        {
            mod1.removeAllElements();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT med_type FROM medicine WHERE med_type LIKE '" + MedType_text.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    mod1.addElement(res.getString("med_type"));
                }
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }

            Medicine_Type_PopupMenu.show(MedType_text, 0, MedType_text.getHeight());

        }

    }//GEN-LAST:event_MedType_textKeyReleased

    private void MedType_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedType_textKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_MedType_textKeyTyped

    private void Medicine_Type_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Medicine_Type_ViewMouseClicked

        MedType_text.setText(Medicine_Type_View.getSelectedValue());
        Medicine_Type_PopupMenu.hide();
    }//GEN-LAST:event_Medicine_Type_ViewMouseClicked

    private void PatientAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PatientAgeKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_PatientAgeKeyTyped

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
            java.util.logging.Logger.getLogger(Prescription_Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prescription_Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prescription_Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prescription_Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prescription_Create().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdviceAdd;
    private javax.swing.JButton AdviceDelete;
    private javax.swing.JTable AdviceList;
    private javax.swing.JButton AdviceUpdate;
    private javax.swing.JPanel Advice_Panel;
    private javax.swing.JPopupMenu Advice_PopupMenu;
    private javax.swing.JList<String> Advice_View;
    private javax.swing.JButton All_Prescriptions;
    private javax.swing.JLabel ChamberNameView;
    private javax.swing.JPanel Condition_Panel;
    private javax.swing.JPopupMenu Condition_PopupMenu;
    private javax.swing.JList<String> Condition_View;
    private javax.swing.JButton Confirm;
    private javax.swing.JPanel Duration_Panel;
    private javax.swing.JPopupMenu Duration_PopupMenu;
    private javax.swing.JList<String> Duration_View;
    private javax.swing.JPanel FindingProblem_Panel;
    private javax.swing.JPopupMenu FindingProblem_PopupMenu;
    private javax.swing.JList<String> FindingProblem_View;
    private javax.swing.JTextField MedType_text;
    private javax.swing.JButton MedicineAdd;
    private javax.swing.JButton MedicineDelete;
    private javax.swing.JTable MedicineList;
    private javax.swing.JButton MedicineUpdate;
    private javax.swing.JPanel Medicine_List_Panel;
    private javax.swing.JPopupMenu Medicine_List_PopupMenu;
    private javax.swing.JList<String> Medicine_List_View;
    private javax.swing.JPanel Medicine_Type_Panel;
    private javax.swing.JPopupMenu Medicine_Type_PopupMenu;
    private javax.swing.JList<String> Medicine_Type_View;
    private javax.swing.JPanel NextAppointment_Panel;
    private javax.swing.JPopupMenu NextAppointment_PopupMenu;
    private javax.swing.JList<String> NextAppointment_View;
    private javax.swing.JTextField PatID;
    private javax.swing.JTextField PatientAge;
    private javax.swing.JTextField PatientMobileNumber;
    private javax.swing.JTextField PatientName;
    private javax.swing.JTextField PatientNextAppointment;
    private javax.swing.JPanel Period_Panel;
    private javax.swing.JPopupMenu Period_PopupMenu;
    private javax.swing.JList<String> Period_View;
    private javax.swing.JTextField PresAdvice;
    private javax.swing.JTextField PresCondition;
    private javax.swing.JTextField PresDuration;
    private javax.swing.JTextField PresFindingProblem;
    private javax.swing.JTextField PresID;
    private javax.swing.JTextField PresMedicineName;
    private javax.swing.JTextField PresPeriod;
    private javax.swing.JTextField PresRoutine;
    private javax.swing.JTextField PresTest;
    private javax.swing.JButton ProblemAdd;
    private javax.swing.JButton ProblemDelete;
    private javax.swing.JTable ProblemList;
    private javax.swing.JButton ProblemUpdate;
    private javax.swing.JPanel Routine_Panel;
    private javax.swing.JPopupMenu Routine_PopupMenu;
    private javax.swing.JList<String> Routine_View;
    private javax.swing.JButton TestAdd;
    private javax.swing.JButton TestDelete;
    private javax.swing.JTable TestList;
    private javax.swing.JButton TestUpdate;
    private javax.swing.JPanel Test_Panel;
    private javax.swing.JPopupMenu Test_PopupMenu;
    private javax.swing.JList<String> Test_View;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    // End of variables declaration//GEN-END:variables
}
