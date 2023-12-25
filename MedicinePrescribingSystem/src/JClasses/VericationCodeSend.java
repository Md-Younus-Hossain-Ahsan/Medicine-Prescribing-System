/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import com.email.durgesh.Email;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class VericationCodeSend {
    
    String UserEmail = "";
    String Characters = "ABCDEFGHJLMNPQRSTUVWXYZ123456789";
    public static String Verification_Code = "";
    private String EmailID;
    private String EmailPassword;
 
    
    public void Set()
    {
        this.EmailID = MyProject.SignIN.EmailID;
        this.EmailPassword = MyProject.SignIN.EmailPassword;
    }

    public void Code_Generate()
    {
        Random rand = new Random();
        int i;
        char[] text = new char[5];
        Verification_Code = "";

        for(i=0; i<5; i++)
        {
            text[i] = Characters.charAt(rand.nextInt(Characters.length()));
        }
        
        for(i=0; i<text.length; i++)
        {
            Verification_Code += text[i];
        }
    }
    
    public void Find_Recipient(){
        
        DoctorInfo doctor_Profile = new DoctorInfo();
        try {
            doctor_Profile.search();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VericationCodeSend.class.getName()).log(Level.SEVERE, null, ex);
        }
        UserEmail = doctor_Profile.getEmail();    
    }
    
    public void Code_Send() throws UnsupportedEncodingException
    {        
        try{
            Email email = new Email(EmailID, EmailPassword);

            email.setFrom(EmailID, "Medicine Prescribing System");

            email.setSubject("This email for verification.");

            email.setContent("<h2>The verification code is : </h2>" + Verification_Code, "text/html");

            email.addRecipient(UserEmail);

            email.send();
           

        }catch(MessagingException e)
        {
            JOptionPane.showMessageDialog(null, "Enter a valid Email address !");
        }
    }
        
}
