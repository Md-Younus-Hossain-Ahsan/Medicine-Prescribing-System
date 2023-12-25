package MyProject;

import JClasses.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Medicine_List extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    private final DefaultListModel mod1;
    
    public Medicine_List() {
        
        initComponents();        
        All_View();
        All_Type_View();
        Medicine_Type_PopupMenu.add(Medicine_Type_Panel);
        mod1 = new DefaultListModel();
        Medicine_Type_View.setModel(mod1);
        
    }
    
    public void All_Type_View(){
        
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT DISTINCT med_type FROM medicine";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                MedType.addItem(res.getString("med_type"));                
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Appointment_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void All_View(){
        
        Medicine medicine = new Medicine();
        medicine.Last_ID();
        MedicineID.setText(Integer.toString(medicine.getMedicineID()));
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM medicine";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            MedicineInfo.setModel(new DefaultTableModel(null, new String[] {"Medicine ID","Medicine Name","Category"}));
            
            while (res.next()) {
                
                String tbData[] = {Integer.toString(res.getInt("med_id")),
                                    res.getString("med_name"),
                                    res.getString("med_type")};

                DefaultTableModel tbModel = (DefaultTableModel) MedicineInfo.getModel();
                tbModel.addRow(tbData);
        
            }
            Reset();
        } catch (SQLException e) {
            System.out.println(e);
        }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Medicine_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Reset(){
        Medicine medicine = new Medicine();
        medicine.Last_ID();
        MedicineID.setText(Integer.toString(medicine.getMedicineID()));
        MedicineName.setText("");
        MedicineName_view.setText(null);
        MedType_text.setText(null);
        MedType.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Medicine_Type_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Medicine_Type_View = new javax.swing.JList<>();
        Medicine_Type_PopupMenu = new javax.swing.JPopupMenu();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        MedicineInfo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MedicineName_view = new javax.swing.JTextField();
        MedType_text = new javax.swing.JTextField();
        MedicineName = new javax.swing.JTextField();
        MedicineID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        MedType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        All_View = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        Medicine_Type_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Medicine_Type_ViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Medicine_Type_View);

        javax.swing.GroupLayout Medicine_Type_PanelLayout = new javax.swing.GroupLayout(Medicine_Type_Panel);
        Medicine_Type_Panel.setLayout(Medicine_Type_PanelLayout);
        Medicine_Type_PanelLayout.setHorizontalGroup(
            Medicine_Type_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Medicine_Type_PanelLayout.setVerticalGroup(
            Medicine_Type_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Medicine_Type_PopupMenu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator7.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 210, 10));

        jSeparator8.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 290, 10));

        jSeparator9.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 110, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 580, 10));

        jSeparator11.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 210, 10));

        MedicineInfo.setBackground(new java.awt.Color(232, 245, 253));
        MedicineInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        MedicineInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name", "Category"
            }
        ));
        MedicineInfo.setToolTipText("");
        MedicineInfo.setName(""); // NOI18N
        MedicineInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MedicineInfo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 820, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Medicine Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Category");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 150, -1));

        MedicineName_view.setBackground(new java.awt.Color(232, 245, 253));
        MedicineName_view.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MedicineName_view.setBorder(null);
        MedicineName_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineName_viewMouseClicked(evt);
            }
        });
        MedicineName_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedicineName_viewActionPerformed(evt);
            }
        });
        getContentPane().add(MedicineName_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 580, 30));

        MedType_text.setBackground(new java.awt.Color(232, 245, 253));
        MedType_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MedType_text.setBorder(null);
        MedType_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedType_textMouseClicked(evt);
            }
        });
        MedType_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MedType_textKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MedType_textKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MedType_textKeyTyped(evt);
            }
        });
        getContentPane().add(MedType_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 210, 30));

        MedicineName.setBackground(new java.awt.Color(232, 245, 253));
        MedicineName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MedicineName.setBorder(null);
        MedicineName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineNameMouseClicked(evt);
            }
        });
        MedicineName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MedicineNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MedicineNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MedicineNameKeyTyped(evt);
            }
        });
        getContentPane().add(MedicineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 290, 30));

        MedicineID.setBackground(new java.awt.Color(232, 245, 253));
        MedicineID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MedicineID.setBorder(null);
        MedicineID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineIDMouseClicked(evt);
            }
        });
        MedicineID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MedicineIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MedicineIDKeyTyped(evt);
            }
        });
        getContentPane().add(MedicineID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 110, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Medicine ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Medicine Name");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 90, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Category");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 90, 20));

        MedType.setBackground(new java.awt.Color(232, 245, 253));
        MedType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MedType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All types" }));
        MedType.setBorder(null);
        MedType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedTypeMouseClicked(evt);
            }
        });
        MedType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedTypeActionPerformed(evt);
            }
        });
        getContentPane().add(MedType, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 210, 30));

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/+.png"))); // NOI18N
        jLabel4.setText(" Medicine List ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        Close.setBackground(new java.awt.Color(232, 245, 253));
        Close.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Close.setText("Close");
        Close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Close.setContentAreaFilled(false);
        Close.setOpaque(true);
        Close.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CloseMouseMoved(evt);
            }
        });
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CloseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CloseMouseReleased(evt);
            }
        });
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 130, 40));

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
        getContentPane().add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 130, 40));

        Add.setBackground(new java.awt.Color(232, 245, 253));
        Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Add.setText("Add a new");
        Add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Add.setContentAreaFilled(false);
        Add.setOpaque(true);
        Add.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AddMouseMoved(evt);
            }
        });
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AddMouseReleased(evt);
            }
        });
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 130, 40));

        All_View.setBackground(new java.awt.Color(232, 245, 253));
        All_View.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        All_View.setText("All View");
        All_View.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        All_View.setContentAreaFilled(false);
        All_View.setOpaque(true);
        All_View.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                All_ViewMouseMoved(evt);
            }
        });
        All_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_ViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                All_ViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                All_ViewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                All_ViewMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                All_ViewMouseReleased(evt);
            }
        });
        All_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                All_ViewActionPerformed(evt);
            }
        });
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 120, 30));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg1.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MedicineInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineInfoMouseClicked
        int i = MedicineInfo.getSelectedRow();
        TableModel model = MedicineInfo.getModel();
        
        MedicineID.setText((String) model.getValueAt(i, 0));
        MedicineName_view.setText((String) model.getValueAt(i, 1));
        MedType_text.setText((String) model.getValueAt(i, 2));        
    }//GEN-LAST:event_MedicineInfoMouseClicked
    
    
    private void MedicineName_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicineName_viewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedicineName_viewActionPerformed

    private void MedicineIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineIDMouseClicked
        // TODO add your handling code here:
        All_View();
        Reset();
    }//GEN-LAST:event_MedicineIDMouseClicked

    private void MedicineNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineNameMouseClicked
        All_View();
        Reset();
    }//GEN-LAST:event_MedicineNameMouseClicked

    private void MedicineName_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineName_viewMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MedicineName_viewMouseClicked

    private void MedicineIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedicineIDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_MedicineIDKeyTyped

    private void MedicineNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedicineNameKeyTyped
             
    }//GEN-LAST:event_MedicineNameKeyTyped

    private void MedicineNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedicineNameKeyPressed
        
    }//GEN-LAST:event_MedicineNameKeyPressed

    private void MedicineNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedicineNameKeyReleased
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = "SELECT * FROM medicine WHERE med_name LIKE '" + MedicineName.getText() + "%'";
                    
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                MedicineInfo.setModel(new DefaultTableModel(null, new String[] {"Medicine ID","Medicine Name","Category"}));

                while (res.next()) {

                    String tbData[] = {Integer.toString(res.getInt("med_id")),
                                       res.getString("med_name"),
                                       res.getString("med_type")};

                    DefaultTableModel tbModel = (DefaultTableModel) MedicineInfo.getModel();
                    tbModel.addRow(tbData);

                }
                
            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {Logger.getLogger(Medicine_List.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_MedicineNameKeyReleased

    private void MedicineIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedicineIDKeyReleased
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = null;
                
                if(MedicineID.getText().trim().equals(""))
                    All_View();
                else{
                    try{
                        sql = "SELECT * FROM medicine WHERE med_id LIKE '" + Integer.valueOf(MedicineID.getText()) + "%'";
                    }catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Invalid !!!"); MedicineID.setText("");}
                }
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                MedicineInfo.setModel(new DefaultTableModel(null, new String[] {"Medicine ID","Medicine Name","Category"}));

                while (res.next()) {

                    String tbData[] = {Integer.toString(res.getInt("med_id")),
                                       res.getString("med_name"),
                                       res.getString("med_type")};

                    DefaultTableModel tbModel = (DefaultTableModel) MedicineInfo.getModel();
                    tbModel.addRow(tbData);

                }
                
            } catch (SQLException e) {System.out.println(e);}     
        } catch (ClassNotFoundException ex) {Logger.getLogger(Medicine_List.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_MedicineIDKeyReleased

    private void CloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseMoved
        Close.setCursor(SignIN.cursor);
    }//GEN-LAST:event_CloseMouseMoved

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        Close.setBackground(new Color(0,0,255).brighter());
        Close.setForeground(Color.WHITE);
    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        Close.setBackground(new Color(0,153,255).brighter());
        Close.setForeground(Color.BLACK);
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        Close.setBackground(new Color(232,245,253));
        Close.setForeground(Color.BLACK);
    }//GEN-LAST:event_CloseMouseExited

    private void CloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMousePressed
        Close.setBackground(new Color(0,0,255).brighter());
        Close.setForeground(Color.WHITE);
    }//GEN-LAST:event_CloseMousePressed

    private void CloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseReleased
        Close.setBackground(new Color(232,245,253));
        Close.setForeground(Color.BLACK);
    }//GEN-LAST:event_CloseMouseReleased

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        dispose();
    }//GEN-LAST:event_CloseActionPerformed

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
        //Update in database
        if(MedicineName_view.getText().isEmpty() || MedType_text.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            try{
                String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                    String sql = "update medicine set med_name = '"+ MedicineName_view.getText() +"', med_type = '"+ MedType_text.getText() +"' where med_id = '"+Integer.parseInt(MedicineID.getText())+"'";
                    
                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "The updated info has been added !"); 

                } catch (SQLException e) {System.out.println(e);}     
            } catch (ClassNotFoundException ex) {Logger.getLogger(Medicine_List.class.getName()).log(Level.SEVERE, null, ex);
            }              

            All_View();
        }
        
    }//GEN-LAST:event_SaveActionPerformed

    private void AddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseMoved
        Add.setCursor(SignIN.cursor);
    }//GEN-LAST:event_AddMouseMoved

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        Add.setBackground(new Color(0,0,255).brighter());
        Add.setForeground(Color.WHITE);
    }//GEN-LAST:event_AddMouseClicked

    private void AddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseEntered
        Add.setBackground(new Color(0,153,255).brighter());
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseEntered

    private void AddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseExited
        Add.setBackground(new Color(232,245,253));
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseExited

    private void AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMousePressed
        Add.setBackground(new Color(0,0,255).brighter());
        Add.setForeground(Color.WHITE);
    }//GEN-LAST:event_AddMousePressed

    private void AddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseReleased
        Add.setBackground(new Color(232,245,253));
        Add.setForeground(Color.BLACK);
    }//GEN-LAST:event_AddMouseReleased

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        //Add to database
        if(MedicineName_view.getText().isEmpty() || MedType_text.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            try{
                String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                    String sql = "INSERT INTO medicine (med_name, med_type) VALUES ('"+ MedicineName_view.getText() +"', '"+ MedType_text.getText() +"')";

                PreparedStatement pst = con.prepareStatement(sql);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "The inserted info has been added !"); 
                
                } catch (SQLException e) {System.out.println(e);}     
            } catch (ClassNotFoundException ex) {Logger.getLogger(Medicine_List.class.getName()).log(Level.SEVERE, null, ex);
            }              

            All_View();
        }
    }//GEN-LAST:event_AddActionPerformed

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(SignIN.cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

    private void All_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseClicked
        All_View.setBackground(new Color(0,0,255).brighter());
        All_View.setForeground(Color.WHITE);
    }//GEN-LAST:event_All_ViewMouseClicked

    private void All_ViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseEntered
        All_View.setBackground(new Color(0,153,255).brighter());
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseEntered

    private void All_ViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseExited
        All_View.setBackground(new Color(232,245,253));
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseExited

    private void All_ViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMousePressed
        All_View.setBackground(new Color(0,0,255).brighter());
        All_View.setForeground(Color.WHITE);
    }//GEN-LAST:event_All_ViewMousePressed

    private void All_ViewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseReleased
        All_View.setBackground(new Color(232,245,253));
        All_View.setForeground(Color.BLACK);
    }//GEN-LAST:event_All_ViewMouseReleased

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        All_View();
        Reset();
    }//GEN-LAST:event_All_ViewActionPerformed

    private void MedType_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedType_textMouseClicked
        
    }//GEN-LAST:event_MedType_textMouseClicked

    private void MedType_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedType_textKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedType_textKeyPressed

    private void MedType_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedType_textKeyReleased
        
        Medicine_Type_PopupMenu.show();
        String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";
        if(!MedType_text.getText().trim().isEmpty())
        {
            mod1.removeAllElements();            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
                String sql = "SELECT DISTINCT med_type FROM medicine WHERE med_type LIKE '" + MedType_text.getText() + "%'";
                PreparedStatement pst = con.prepareStatement(sql); 
                ResultSet res = pst.executeQuery();
                while (res.next()) {   
                    mod1.addElement(res.getString("med_type"));
                } 
            } catch (SQLException e) { } catch (ClassNotFoundException ex) {
                Logger.getLogger(Prescription_Create.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Medicine_Type_PopupMenu.show(MedType_text, 0, MedType_text.getHeight());
            
        }
            
    }//GEN-LAST:event_MedType_textKeyReleased

    private void MedType_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedType_textKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_MedType_textKeyTyped

    private void MedTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedTypeActionPerformed

        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "system", "p@ssword13");

                String sql = null;
                String Selected_Type = (String) MedType.getSelectedItem();
                if(Selected_Type.equals("All types"))
                {
                    sql = "Select * from medicine";
                }else{
                    sql = "Select * from medicine where med_type = '"+Selected_Type+"'";
                }
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                MedicineInfo.setModel(new DefaultTableModel(null, new String[] {"Medicine ID","Medicine Name","med_type"}));

                while (res.next()) {

                    String tbData[] = {Integer.toString(res.getInt("med_id")),
                        res.getString("med_name"),
                        res.getString("med_type")};

                    DefaultTableModel tbModel = (DefaultTableModel) MedicineInfo.getModel();
                    tbModel.addRow(tbData);

                }
            } catch (SQLException e) {System.out.println(e);}
        } catch (ClassNotFoundException ex) {Logger.getLogger(Medicine_List.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_MedTypeActionPerformed

    private void MedTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedTypeMouseClicked
        All_View();
        Reset();
    }//GEN-LAST:event_MedTypeMouseClicked

    private void Medicine_Type_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Medicine_Type_ViewMouseClicked

        MedType_text.setText(Medicine_Type_View.getSelectedValue());
        Medicine_Type_PopupMenu.hide();

    }//GEN-LAST:event_Medicine_Type_ViewMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Medicine_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton All_View;
    private javax.swing.JButton Close;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JComboBox<String> MedType;
    private javax.swing.JTextField MedType_text;
    private javax.swing.JTextField MedicineID;
    private javax.swing.JTable MedicineInfo;
    private javax.swing.JTextField MedicineName;
    private javax.swing.JTextField MedicineName_view;
    private javax.swing.JPanel Medicine_Type_Panel;
    private javax.swing.JPopupMenu Medicine_Type_PopupMenu;
    private javax.swing.JList<String> Medicine_Type_View;
    private javax.swing.JButton Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
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