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

public class Chamber {

    int Last_Chamber_id = 0;
    int ChamberID = 0;
    String ChamberName;
    String Location;
    String Email;        
    String MobileNumbers;
    String Visiting_Time;
    String Days;
    String Fee;
    
    public void Add_a_Chamber(String Name, String Email, String Location, String Visiting_Time, String Days, int Fee, String MobileNumbers) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Chamber (Name, Email, Location, Visiting_time, Days, Fee, MobileNumbers) VALUES ('"+ Name +"', '"+ Email +"', '"+ Location +"', '"+ Visiting_Time +"', '"+ Days +"', '"+ Fee +"', '"+ MobileNumbers +"')";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Added !!!"); 
                                
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    
    public void ChamberInfo_Updation(int Chamber_id, String Name, String Email, String Location, String Visiting_Time, String Days, int Fee, String MobileNumbers) throws ClassNotFoundException {
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "update Chamber set Name = '"+ Name +"', Email = '"+ Email +"', Location = '"+ Location +"', Visiting_time = '"+ Visiting_Time +"', Days = '"+ Days +"', Fee = '"+ Fee +"', MobileNumbers = '"+ MobileNumbers +"' WHERE Chamber_id = '"+ Chamber_id +"'";
                    
                PreparedStatement pst = con.prepareStatement(sql);

                pst.executeUpdate();

            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {
        }  
    }
    
    
    public void Last_ID() throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        Last_Chamber_id = 1001;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "SELECT * FROM Chamber";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Last_Chamber_id = res.getInt("Chamber_id");
            } 
        } catch (SQLException e) {}
                       
    }
    
    
    public void Find_Name_from_ID(int ChamberID){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Chamber where Chamber_id = '"+ ChamberID +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                ChamberName = res.getString("Name");                
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    public void Find_ID_from_Name(String Name){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Chamber where Name = '"+ Name +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                ChamberID = res.getInt("Chamber_id");   
                Location = res.getString("Location");
                MobileNumbers = res.getString("MobileNumbers");
                Email = res.getString("Email");        
                Visiting_Time = res.getString("Visiting_time");
                Days = res.getString("Days");
                Fee = Integer.toString(res.getInt("Fee"));
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    

    public int getLast_Chamber_id() {
        return Last_Chamber_id;
    }

    public int getChamberID() {
        return ChamberID;
    }  

    public String getChamberName() {
        return ChamberName;
    }

    public String getLocation() {
        return Location;
    }

    public String getMobile() {
        return MobileNumbers;
    }

    public String getEmail() {
        return Email;
    }

    public String getVisiting_Time() {
        return Visiting_Time;
    }

    public String getDays() {
        return Days;
    }

    public String getFee() {
        return Fee;
    }
    
}
