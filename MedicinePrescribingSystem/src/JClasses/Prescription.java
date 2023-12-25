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

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Prescription {
    
    int Prescrition_ID = 1000;
    int Patient_Age = 0;
    String NextAppointment;
    String Visiting_Date;
    
    
    public void Last_Prescrition_ID() throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        Prescrition_ID = 1000;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Prescription";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Prescrition_ID = res.getInt("Pres_id");           
        
            } 
        } catch (SQLException e) {
        }        
    }
    
    public void Add_a_Prescription(int Chamber_id, int Patient_id, int Patient_age, String Visiting_Date, String next_appointment) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Prescription (Chamber_id, Patient_id, Patient_age, Visiting_Date, NextAppointment) VALUES ('"+ Chamber_id +"', '"+ Patient_id +"', '"+ Patient_age +"', '"+ Visiting_Date +"', '"+ next_appointment +"')";                      
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
                    
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    public void Search_Info(int Prescription_ID) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Prescription WHERE Pres_id = '"+ Prescription_ID +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                
                Patient_Age = res.getInt("Patient_age");
                NextAppointment = res.getString("NextAppointment");       
                Visiting_Date = res.getString("Visiting_Date");                   
        
            } 
        } catch (SQLException e) {
        }        
    }
    
    public void Next_Appointment_Update(int Prescription_ID, String PatientNextAppointment) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "update Prescription set NextAppointment = '"+ PatientNextAppointment +"' WHERE Pres_id = '"+ Prescription_ID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.executeUpdate();
            
        } catch (SQLException e) {System.out.println(e);}     
    }

    public int getPrescrition_ID() {
        return ++Prescrition_ID;
    }

    public int getPatient_Age() {
        return Patient_Age;
    }

    public String getVisiting_Date() {
        return Visiting_Date;
    }

    public String getNextAppointment() {
        return NextAppointment;
    }
}
