/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Appointment {
   
    int found = 0;
    int SI = 0;
    
    public void Search(String Name, String MobileNumber) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        found = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Patient WHERE Name = '"+ Name +"' and Mobile_Number = '"+ MobileNumber +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                found = 1;    
            } 
        } catch (SQLException e) {
        }        
    }
    
    
    public void Last_SI_no(int ChamberID, String Appointment_Date) throws ClassNotFoundException{
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Appointment where Chamber_id = '"+ ChamberID +"' and App_date = '" + Appointment_Date + "'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                SI = res.getInt("SI_no");
            } 
        } catch (SQLException e) {}
    }
    
    
    public void Add_a_New_Appointment(int SI_No, int ChamberID, String AppID, String Name, int Age, String MobileNumber, String Gender, String Appointment_Date) throws ClassNotFoundException{
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Appointment (SI_no, Chamber_id, App_id, Name, Age, Mobile_Number, Gender, App_date, App_type) VALUES ('" + SI_No + "', '"+ ChamberID +"', '" + AppID + "', '" + Name + "', '" + Age + "', '" + MobileNumber + "', '" + Gender + "', '" + Appointment_Date + "', 'Pending')";
                                  
            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Added !"); 
                    
        } catch (SQLException e) {System.out.println(e);}   
    }
    
    
    public void Add_to_patient_list(String Name, int Age, String Gender, String Mobile_Number) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Patient (Name, Age, Mobile_Number, Gender) VALUES ('"+ Name +"', '"+ Age +"', '"+ Mobile_Number +"', '"+ Gender +"')";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Added to the Patient List !"); 
                    
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    
    public void Appointment_Type_Updation(String App_id) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

            String sql = "update Appointment set App_type = 'Done' WHERE App_id = '"+ App_id +"'";
                    
            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException e) {System.out.println(e);}  
                
    }
    
    
    public void Delete_All_the_Previous_Appointments(String today) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "delete from Appointment where App_date < '"+ today +"'";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
                    
                
        } catch (SQLException e) {System.out.println(e);}
                
    }

    
    public int getFound() {
        return found;
    }
    

    public int getSI() {
        return ++SI;
    }
 
}
