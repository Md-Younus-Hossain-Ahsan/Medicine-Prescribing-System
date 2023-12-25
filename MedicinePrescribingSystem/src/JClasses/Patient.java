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

public class Patient {
    
    int found = 0;
    String name;
    int PatientID = 0;
    int age;
    String mobile_number;
    String gender;
    
    public void search(int Patient_ID) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        found = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Patient WHERE Patient_id = '"+ Patient_ID +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                found = 1;
                name = res.getString("Name");
                age = res.getInt("Age");
                mobile_number = res.getString("Mobile_Number");
                gender = res.getString("Gender");                
        
            } 
        } catch (SQLException e) {
        }        
    }
    
    public void Age_Update(String Name, int Age, String MobileNumber) throws ClassNotFoundException {
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "update Patient set Age = '"+ Age +"' WHERE Name = '"+ Name +"' and Mobile_Number = '"+ MobileNumber +"'";
                    
                    
                PreparedStatement pst = con.prepareStatement(sql);

                pst.executeUpdate();

            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {
        }  
    }
    
    public void Patient_ID_search(String Name, String MobileNumber) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        found = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Patient WHERE Name = '"+ Name +"' and Mobile_Number = '"+ MobileNumber +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                PatientID = res.getInt("Patient_id");            
        
            } 
        } catch (SQLException e) {
        }        
    }
    
    public int getFound() {
        return found;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return Integer.toString(age);
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getGender() {
        return gender;
    }

    public int getPatientID() {
        return PatientID;
    }
}
