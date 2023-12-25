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

public class FindingProblem {
    
    int FindProb_id = 0;
    
    public void insert_into_Finding_Problem(int PrescriptionID, int Dis_id) throws ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Finding_Problems (Pres_id, Dis_id) VALUES ('"+ PrescriptionID +"', '"+ Dis_id +"');";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();                    
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    
    public void Find_FindProb_id(int PrescriptionID, String Name) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        FindProb_id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT Diseases.Dis_id, Diseases.details, Finding_Problems.FindProb_id, Finding_Problems.Pres_id FROM Diseases INNER JOIN Finding_Problems ON Diseases.Dis_id = Finding_Problems.Dis_id WHERE Finding_Problems.Pres_id = '"+ PrescriptionID +"' and Diseases.details = '"+ Name +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                FindProb_id = res.getInt("Finding_Problems.FindProb_id");           
        
            } 
        } catch (SQLException e) {
        }        
    }

    
    public void FindingProblem_Update(int FindProb_id, int Dis_id) throws ClassNotFoundException {
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "update Finding_Problems set Dis_id = '"+ Dis_id +"' WHERE FindProb_id = '"+ FindProb_id +"'";
                    
                PreparedStatement pst = con.prepareStatement(sql);

                pst.executeUpdate();

            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {
        }  
    }
    
    
    public void FindingProblem_Delete(int PrescriptionID, int Dis_id) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "delete from Finding_Problems where Pres_id = '"+ PrescriptionID +"' and Dis_id = '"+ Dis_id +"'";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
                    
                
        } catch (SQLException e) {System.out.println(e);}
                
    }
    
    
    public int getFindProb_id() {
        return FindProb_id;
    }
}
