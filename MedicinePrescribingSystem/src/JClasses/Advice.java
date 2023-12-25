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

public class Advice {
    
    int Adv_id = 0;
    
    public void insert_into_Advices(int PrescriptionID, String details) throws ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Advices (Pres_id, details) VALUES ('"+ PrescriptionID +"', '"+ details +"');";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();                    
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    
    public void Find_Advice_id(int PrescriptionID, String details) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        Adv_id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Advices WHERE Pres_id = '"+ PrescriptionID +"' and details = '"+ details +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Adv_id = res.getInt("Adv_id");           
        
            } 
        } catch (SQLException e) {
        }        
    }

    
    public void Advice_Update(int Adv_id, String details) throws ClassNotFoundException {
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "update Advices set details = '"+ details +"' WHERE Adv_id = '"+ Adv_id +"'";
                    
                PreparedStatement pst = con.prepareStatement(sql);

                pst.executeUpdate();

            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {
        }  
    }
    
    
    public void Advice_Delete(int PrescriptionID, String details) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "delete from Advices where Pres_id = '"+ PrescriptionID +"' and details = '"+ details +"'";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
                    
                
        } catch (SQLException e) {System.out.println(e);}
                
    }
    
    
    public int getAdv_id() {
        return Adv_id;
    }
}
