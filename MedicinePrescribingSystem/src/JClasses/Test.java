/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import MyProject.Appointment_List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Test {
    
    int Test_id;
    int found;
    String Name;
    
    public void Add_to_test_list(String Name) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Test (Name) VALUES ('"+ Name +"')";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();                    
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    
    public void insert(String name) throws ClassNotFoundException{
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
            
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

            String sql = "INSERT INTO Test (Name) VALUES ('"+ name +"')";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "The inserted info has been added !"); 

        } catch (SQLException e) {System.out.println(e);}     
    }
    
    
    public void Find_ID_from_Name(String Name){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        Test_id = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Test where Name = '"+ Name +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            found = 0;
            while(res.next())
            {
                found = 1;
                Test_id = res.getInt("Test_id");
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    public void Find_Name_from_ID(int Test_id){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Test where Test_id = '"+ Test_id +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Name = res.getString("Name");
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    public int getTest_id() {
        return Test_id;
    }

    public String getName() {
        return Name;
    }

    public int getFound() {
        return found;
    }
}
