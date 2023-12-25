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

public class PrescribedMedicines {
    
    int PresMed_id = 0;
    
    public void insert_into_Prescribed_Medicines(int PrescriptionID, int MedicineID, String dosage_routine, String period, String duration, String dosage_condition) throws ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "INSERT INTO Prescribed_Medicines (Pres_id, med_id, dosage_routine, period, duration, dosage_condition) VALUES ('"+ PrescriptionID +"', '"+ MedicineID +"', '"+ dosage_routine +"', '"+ period +"', '"+ duration +"', '"+ dosage_condition +"');";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();                    
                
        } catch (SQLException e) {System.out.println(e);}
    }

    
    public void PrescribedMedicine_Update(int PresMed_id, int MedicineID, String dosage_routine, String period, String duration, String dosage_condition) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            
            String sql = "update Prescribed_Medicines set med_id = '"+ MedicineID +"', dosage_routine = '"+ dosage_routine +"', period = '"+ period +"', duration = '"+ duration +"', dosage_condition = '"+ dosage_condition +"' WHERE PresMed_id = '"+ PresMed_id +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.executeUpdate();
                 
        } catch (SQLException e) {System.out.println(e);}    
    }
    
    
    public void Medicine_Delete_from_list(int PrescriptionID, int med_id) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                    
            String sql = "delete from Prescribed_Medicines where Pres_id = '"+ PrescriptionID +"' and med_id = '"+ med_id +"'";                      
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
                    
                
        } catch (SQLException e) {System.out.println(e);}
                
    }
    
    
    public void Find_PresMed_id(int PrescriptionID, String Name) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        PresMed_id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT medicine.med_id, medicine.med_name, Prescribed_Medicines.PresMed_id, Prescribed_Medicines.Pres_id FROM medicine INNER JOIN Prescribed_Medicines ON medicine.med_id = Prescribed_Medicines.med_id WHERE Prescribed_Medicines.Pres_id = '"+ PrescriptionID +"' and medicine.med_name = '"+ Name +"'";
            
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                PresMed_id = res.getInt("Prescribed_Medicines.PresMed_id");           
        
            } 
        } catch (SQLException e) {
        }        
    }

    public int getPresMed_id() {
        return PresMed_id;
    }
    
}