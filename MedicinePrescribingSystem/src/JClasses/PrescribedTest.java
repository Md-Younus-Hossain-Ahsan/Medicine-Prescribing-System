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

public class PrescribedTest {
    
    int PresTest_id = 0;
    
    public void insert_into_Prescribed_Test(int PrescriptionID, int Test_id) throws ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Prescribed_Tests (Pres_id, Test_id) VALUES ('"+ PrescriptionID +"', '"+ Test_id +"');";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();                    
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    
    public void Find_PresTest_id(int PrescriptionID, String Name) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        PresTest_id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT Test.Test_id, Test.Name, Prescribed_Tests.PresTest_id, Prescribed_Tests.Pres_id FROM Test INNER JOIN Prescribed_Tests ON Test.Test_id = Prescribed_Tests.Test_id WHERE Prescribed_Tests.Pres_id = '"+ PrescriptionID +"' and Test.Name = '"+ Name +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                PresTest_id = res.getInt("Prescribed_Tests.PresTest_id");           
        
            } 
        } catch (SQLException e) {
        }        
    }

    
    public void PrescribedTest_Update(int PresTest_id, int Test_id) throws ClassNotFoundException {
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "update Prescribed_Tests set Test_id = '"+ Test_id +"' WHERE PresTest_id = '"+ PresTest_id +"'";
                    
                PreparedStatement pst = con.prepareStatement(sql);

                pst.executeUpdate();

            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {
        }  
    }
    
    
    public void PrescribedTest_Delete(int PrescriptionID, int Testid) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "delete from Prescribed_Tests where Pres_id = '"+ PrescriptionID +"' and Test_id = '"+ Testid +"'";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
                    
                
        } catch (SQLException e) {System.out.println(e);}
                
    }
    
    
    public int getPresTest_id() {
        return PresTest_id;
    }
}
