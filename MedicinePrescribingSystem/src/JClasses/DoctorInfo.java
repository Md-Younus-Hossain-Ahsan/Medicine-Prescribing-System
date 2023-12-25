/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class DoctorInfo {
    
    String username;
    String name;
    String password;
    String email;
    String gender;
    String mobile_number;
    String qualifications;
    
    @SuppressWarnings("empty-statement")
    public void search() throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Doctor_Info WHERE doc_id = 1001";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                
                username = res.getString("username");
                name = res.getString("name");
                password = res.getString("password");
                email = res.getString("email");
                gender = res.getString("gender");
                mobile_number = res.getString("mobile_number");
                qualifications = res.getString("qualifications");
                
            } 
        } catch (SQLException e) {
        }
        
    }
    
    
    public void DoctorInfo_Updation(int Doctor_id, String Name, String Username, String Password, String Email, String Gender, String MobileNumber, String Qualifications) throws ClassNotFoundException, FileNotFoundException {
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                
                String sql = "update Doctor_Info SET username = '"+ Username +"', name = '"+ Name +"', password = '"+ Password +"', email = '"+ Email +"', gender = '"+ Gender +"', mobile_number = '"+ MobileNumber +"', qualifications = '"+ Qualifications +"' WHERE doc_id = '"+ Doctor_id +"'";
                  
                PreparedStatement pst = con.prepareStatement(sql);

                pst.executeUpdate();

            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {
        }  
    }
    

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile_number() {
        return mobile_number;
    }    

    public String getQualifications() {
        return qualifications;
    }
}
