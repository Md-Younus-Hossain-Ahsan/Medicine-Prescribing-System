package MyProject;

import JClasses.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.logging.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Personal_Info extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    String Path = null;
    private static byte[] img;
    private ImageIcon format = null;
    byte[] photo = null;
    String filename = null;
    
    public Personal_Info() throws ClassNotFoundException {
        
        initComponents();
        All_Info_View();
                
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM Doctor_Info WHERE doc_id = 1001";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                byte[] image = res.getBytes("profile_pic");
                if (image != null) {
                    format = new ImageIcon(image);
                    Profile_Pic.setIcon(format);
                }
            }            
        } catch (SQLException e) {
        }
    }
    
    
    public void All_Info_View() throws ClassNotFoundException
    {
        DoctorInfo doctor = new DoctorInfo();        
        //PersonalInformation personal_info = new PersonalInformation();
        doctor.search();
        //personal_info.Search();
        Name.setText(doctor.getName());
        Username.setText(doctor.getUsername());
        Email.setText(doctor.getEmail());
        MobileNumber.setText(doctor.getMobile_number());
        Gender.setSelectedItem(doctor.getGender());
        Password.setText(doctor.getPassword());
        Qualifications.setText(doctor.getQualifications());
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        Profile_Pic = new javax.swing.JLabel();
        Upload = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Qualifications = new javax.swing.JTextArea();
        Save = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Doctor_ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        MobileNumber = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator9.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 60, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 280, 10));

        jSeparator11.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 150, 10));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 370, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 210, 10));

        jSeparator14.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator14.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 130, 10));

        jSeparator15.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator15.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 190, 10));

        Profile_Pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/doctor icon.jpg"))); // NOI18N
        Profile_Pic.setToolTipText("Image size: 136*172 px (JPG)");
        Profile_Pic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Profile_Pic.setPreferredSize(new java.awt.Dimension(136, 172));
        getContentPane().add(Profile_Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 138, 172));

        Upload.setBackground(new java.awt.Color(232, 245, 253));
        Upload.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/upload icon.png"))); // NOI18N
        Upload.setText("Upload");
        Upload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Upload.setContentAreaFilled(false);
        Upload.setOpaque(true);
        Upload.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UploadMouseMoved(evt);
            }
        });
        Upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UploadMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UploadMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UploadMouseReleased(evt);
            }
        });
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });
        getContentPane().add(Upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 281, 138, 40));

        Back.setBackground(new java.awt.Color(232, 245, 253));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setText("Back");
        Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Back.setContentAreaFilled(false);
        Back.setOpaque(true);
        Back.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BackMouseMoved(evt);
            }
        });
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BackMouseReleased(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 100, 40));

        Qualifications.setBackground(new java.awt.Color(232, 245, 253));
        Qualifications.setColumns(20);
        Qualifications.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Qualifications.setRows(5);
        Qualifications.setBorder(null);
        jScrollPane1.setViewportView(Qualifications);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 530, 140));

        Save.setBackground(new java.awt.Color(232, 245, 253));
        Save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/save icon.png"))); // NOI18N
        Save.setText("Save");
        Save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Save.setContentAreaFilled(false);
        Save.setOpaque(true);
        Save.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SaveMouseMoved(evt);
            }
        });
        Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SaveMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SaveMouseReleased(evt);
            }
        });
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        getContentPane().add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 100, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Gender");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 70, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Doctor ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        Doctor_ID.setEditable(false);
        Doctor_ID.setBackground(new java.awt.Color(232, 245, 253));
        Doctor_ID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Doctor_ID.setText("1001");
        Doctor_ID.setBorder(null);
        getContentPane().add(Doctor_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 60, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 300, -1));

        Username.setBackground(new java.awt.Color(232, 245, 253));
        Username.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Username.setBorder(null);
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 150, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Email");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 90, -1));

        Email.setBackground(new java.awt.Color(232, 245, 253));
        Email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Email.setText("@gmail.com");
        Email.setBorder(null);
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 370, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Qualifications");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 160, -1));

        MobileNumber.setBackground(new java.awt.Color(232, 245, 253));
        MobileNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MobileNumber.setBorder(null);
        MobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobileNumberActionPerformed(evt);
            }
        });
        getContentPane().add(MobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 210, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Password");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 60, -1));

        Password.setBackground(new java.awt.Color(232, 245, 253));
        Password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Password.setBorder(null);
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 190, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 300, -1));

        Name.setBackground(new java.awt.Color(232, 245, 253));
        Name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Name.setBorder(null);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 280, 20));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/+.png"))); // NOI18N
        jLabel2.setText(" Personal Information ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 90));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Mobile Number");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 140, -1));

        Gender.setBackground(new java.awt.Color(232, 245, 253));
        Gender.setEditable(true);
        Gender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        Gender.setBorder(null);
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 130, 20));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg5.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(SignIN.cursor);
    }//GEN-LAST:event_BackMouseMoved

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        Back.setBackground(new Color(0,0,255).brighter());
        Back.setForeground(Color.WHITE);
    }//GEN-LAST:event_BackMouseClicked

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        Back.setBackground(new Color(0,153,255).brighter());
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        Back.setBackground(new Color(232,245,253));
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseExited

    private void BackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMousePressed
        Back.setBackground(new Color(0,0,255).brighter());
        Back.setForeground(Color.WHITE);
    }//GEN-LAST:event_BackMousePressed

    private void BackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseReleased
        Back.setBackground(new Color(232,245,253));
        Back.setForeground(Color.BLACK);
    }//GEN-LAST:event_BackMouseReleased

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void SaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseMoved
        Save.setCursor(SignIN.cursor);
    }//GEN-LAST:event_SaveMouseMoved

    private void SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseClicked
        Save.setBackground(new Color(0,0,255).brighter());
        Save.setForeground(Color.WHITE);
    }//GEN-LAST:event_SaveMouseClicked

    private void SaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseEntered
        Save.setBackground(new Color(0,153,255).brighter());
        Save.setForeground(Color.BLACK);
    }//GEN-LAST:event_SaveMouseEntered

    private void SaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseExited
        Save.setBackground(new Color(232,245,253));
        Save.setForeground(Color.BLACK);
    }//GEN-LAST:event_SaveMouseExited

    private void SaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMousePressed
        Save.setBackground(new Color(0,0,255).brighter());
        Save.setForeground(Color.WHITE);
    }//GEN-LAST:event_SaveMousePressed

    private void SaveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseReleased
        Save.setBackground(new Color(232,245,253));
        Save.setForeground(Color.BLACK);
    }//GEN-LAST:event_SaveMouseReleased

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        
        if(Name.getText().trim().equals("") || Username.getText().trim().equals("") || Password.getText().trim().equals("") || Email.getText().trim().equals("") || MobileNumber.getText().trim().equals("") || Qualifications.getText().trim().equals(""))
        {        
        }
        else
        {   
            DoctorInfo doctor = new DoctorInfo();
            
            try {
                
                
                doctor.DoctorInfo_Updation(Integer.parseInt(Doctor_ID.getText()), Name.getText(), Username.getText(), Password.getText(), Email.getText(), (String) Gender.getSelectedItem(), MobileNumber.getText(), Qualifications.getText());
               
                JOptionPane.showMessageDialog(null, "Updated !!!"); 
                All_Info_View();
            } catch (ClassNotFoundException | FileNotFoundException ex) {
                Logger.getLogger(Personal_Info.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "UPDATE Doctor_Info SET profile_piC = ?";                      
                PreparedStatement pst = con.prepareStatement(sql);

                InputStream is = new FileInputStream(new File(Path));
                pst.setBlob(1, is);

                pst.executeUpdate(); 
                

            } catch(FileNotFoundException | ClassNotFoundException | SQLException e){}
            
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void MobileNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNumberActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void UploadMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseMoved
        Upload.setCursor(SignIN.cursor);
    }//GEN-LAST:event_UploadMouseMoved

    private void UploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseClicked
        Upload.setBackground(new Color(0,0,255).brighter());
        Upload.setForeground(Color.WHITE);
    }//GEN-LAST:event_UploadMouseClicked

    private void UploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseEntered
        Upload.setBackground(new Color(0,153,255).brighter());
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMouseEntered

    private void UploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseExited
        Upload.setBackground(new Color(232,245,253));
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMouseExited

    private void UploadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMousePressed
        Upload.setBackground(new Color(0,0,255).brighter());
        Upload.setForeground(Color.WHITE);
    }//GEN-LAST:event_UploadMousePressed

    private void UploadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadMouseReleased
        Upload.setBackground(new Color(232,245,253));
        Upload.setForeground(Color.BLACK);
    }//GEN-LAST:event_UploadMouseReleased

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        
        Profile_Pic.setIcon(new ImageIcon(f.toString()));
        Path = f.getAbsolutePath();
        try {
            BufferedImage bi = ImageIO.read(new File(Path));
            Image img = bi.getScaledInstance(136, 172, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            Profile_Pic.setIcon(icon);
            
        } catch (IOException ex) {
            Logger.getLogger(Personal_Info.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }//GEN-LAST:event_UploadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Personal_Info().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Personal_Info.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Doctor_ID;
    private javax.swing.JTextField Email;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField MobileNumber;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Password;
    private javax.swing.JLabel Profile_Pic;
    private javax.swing.JTextArea Qualifications;
    private javax.swing.JButton Save;
    private javax.swing.JButton Upload;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables

    private String getString(String fromInput) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void TicketGenerate(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getText(String format) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
