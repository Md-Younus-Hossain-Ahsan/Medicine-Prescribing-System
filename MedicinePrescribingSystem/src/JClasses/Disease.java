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

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Disease {
    
    int Dis_id;
    String details;
    
    public void Add_to_disease_list(String details) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Diseases (details) VALUES ('"+ details +"')";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();                    
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    
    public void Find_ID_from_Details(String details){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        Dis_id = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Diseases where details = '"+ details +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Dis_id = res.getInt("Dis_id");
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    public void Find_Details_from_ID(int Dis_id){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Diseases where Dis_id = '"+ Dis_id +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                details = res.getString("details");
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    public int getDis_id() {
        return Dis_id;
    }

    public String getdetails() {
        return details;
    }
}
