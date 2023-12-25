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

public class Medicine {
    
    int MedicineID;
    String MedicineName;
    String MedicineType;
    
    
    public void Last_ID(){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        MedicineID = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM medicine";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                MedicineID = res.getInt("med_id");  
            }
            MedicineID++;
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    public void Add_to_medicine_list(String MedicineName, String MedicineType) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO medicine (med_name, med_type) VALUES ('"+ MedicineName +"', '"+ MedicineType +"')";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();                    
                
        } catch (SQLException e) {System.out.println(e);}
    }
    
    
    public void Find_ID_from_Name(String MedicineName){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        MedicineID = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM medicine where med_name = '"+ MedicineName +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                MedicineID = res.getInt("med_id");  
                MedicineType = res.getString("med_type");
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    public void Find_Name_from_ID(int med_id){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM medicine where med_id = '"+ med_id +"'";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                MedicineName = res.getString("med_name");
                MedicineType = res.getString("med_type");
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    

    public int getMedicineID() {
        return MedicineID;
    }

    public String getMedicineName() {
        
        return MedicineName;
    }

    public String getMedicineType() {
        return MedicineType;
    }
    
}
