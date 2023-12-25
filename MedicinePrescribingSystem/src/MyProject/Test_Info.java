package MyProject;

import JClasses.Test;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.logging.*;
import javax.swing.table.*;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Test_Info extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
                
    
    public Test_Info() {
        
        initComponents();        
        All_View();
    }
    
    public void All_View(){
        
        try{
            String url = "jdbc:mysql://localhost:3306/medicine_prescribing_system";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "system", "p@ssword13");
            String sql = "SELECT * FROM test";
            PreparedStatement pst = con.prepareStatement(sql); 
            ResultSet res = pst.executeQuery();
            TestInfo.setModel(new DefaultTableModel(null, new String[] {"Test ID","Name"}));
            
            while (res.next()) {
                
                String tbData[] = {Integer.toString(res.getInt("Test_id")),
                                    res.getString("Name")};

                DefaultTableModel tbModel = (DefaultTableModel) TestInfo.getModel();
                tbModel.addRow(tbData);
        
            }
            TestName.setText("");
        } catch (SQLException e) {
            System.out.println(e);
        }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Test_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        TestInfo = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TestName = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/+.png"))); // NOI18N
        jLabel2.setText(" List of all tests ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 100));

        jSeparator12.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 310, 10));

        TestInfo.setBackground(new java.awt.Color(232, 245, 253));
        TestInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        TestInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test ID", "Name"
            }
        ));
        TestInfo.setToolTipText("");
        TestInfo.setName(""); // NOI18N
        TestInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TestInfo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 500, 190));

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
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 160, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        TestName.setBackground(new java.awt.Color(232, 245, 253));
        TestName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TestName.setToolTipText("");
        TestName.setBorder(null);
        TestName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestNameMouseClicked(evt);
            }
        });
        TestName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestNameActionPerformed(evt);
            }
        });
        getContentPane().add(TestName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 310, 20));

        Back.setBackground(new java.awt.Color(232, 245, 253));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 120, 35));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background_images/bg6.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TestInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestInfoMouseClicked
                    
    }//GEN-LAST:event_TestInfoMouseClicked
    
    
    private void TestNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TestNameActionPerformed

    private void TestNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TestNameMouseClicked

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
        
        if(TestName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the name of a test !!!");
        }
        else
        {
            Test test = new Test();
            test.Find_ID_from_Name(TestName.getText());
            
            if(test.getFound() == 1)
                JOptionPane.showMessageDialog(null, "Already exists !!!");
            else
            {
                try {
                    test.insert(TestName.getText());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Test_Info.class.getName()).log(Level.SEVERE, null, ex);
                }

                All_View();
            }
        }
    }//GEN-LAST:event_AddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test_Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Back;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTable TestInfo;
    private javax.swing.JTextField TestName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator12;
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