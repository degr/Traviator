/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.evacuator;

import traviator42.gui.common.MainWindow;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JCheckBox;

/**
 *
 * @author Ror
 */
public class Evacuator6Pref extends javax.swing.JDialog {

    /**
     * Creates new form Evacuator6Pref
     */
    public Evacuator6Pref(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
          
 //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
 //делаем чтобы приложение появилось в центре экрана
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 Dimension frameSize = getSize();
 setLocation(new Point((screenSize.width - frameSize.width) / 2,
 (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
 //</editor-fold>
 
        
       jLabel4.setIcon(MainWindow.natiPic[MainWindow.tribe][3]);
       jLabel5.setIcon(MainWindow.natiPic[MainWindow.tribe][4]);
       jLabel6.setIcon(MainWindow.natiPic[MainWindow.tribe][5]);
       jLabel7.setIcon(MainWindow.natiPic[MainWindow.tribe][6]);
       jLabel8.setIcon(MainWindow.natiPic[MainWindow.tribe][7]);
       jLabel9.setIcon(MainWindow.natiPic[MainWindow.tribe][8]);
       jLabel10.setIcon(MainWindow.natiPic[MainWindow.tribe][9]);
       jLabel11.setIcon(MainWindow.natiPic[3][0]);
       jLabel1.setText("");
       jLabel2.setText("");
       jLabel3.setText("");
       jLabel4.setText("");
       jLabel5.setText("");
       jLabel6.setText("");
       jLabel7.setText("");
       jLabel8.setText("");
       jLabel9.setText("");
       jLabel10.setText("");
       jLabel11.setText("");
       checkBoxState(jCheckBox1, 0);
       checkBoxState(jCheckBox2, 1);
       checkBoxState(jCheckBox3,2);
       checkBoxState(jCheckBox4,3);
       checkBoxState(jCheckBox5,4);
       checkBoxState(jCheckBox6,5);
       checkBoxState(jCheckBox7,6);
       checkBoxState(jCheckBox8,7);
       checkBoxState(jCheckBox9,8);
       checkBoxState(jCheckBox10,9);
       checkBoxState(jCheckBox11,10);
       
       
       
    }

    
    void checkBoxState(JCheckBox ch, int i){
            if(MainWindow.unitsEvade[i] == true)
                ch.setSelected(true);
            else
                ch.setSelected(false);
            checkBoxName(ch, i);
    }
    
    void checkBoxName(JCheckBox ch, int i){
            if(MainWindow.unitsEvade[i] == true)
                ch.setText(MainWindow.messages[337][MainWindow.language]);
            else
                ch.setText(MainWindow.messages[338][MainWindow.language]);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bottom = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton(MainWindow.natiPic[4][25]);
        center = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 200));

        jButton2.setText(MainWindow.messages[95][MainWindow.language]);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        bottom.add(jButton2);

        getContentPane().add(bottom, java.awt.BorderLayout.PAGE_END);

        center.setLayout(new java.awt.GridLayout(3, 3));

        jLabel1.setIcon(MainWindow.natiPic[MainWindow.tribe][0]);
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);

        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);

        center.add(jPanel1);

        jLabel4.setText("jLabel1");
        jPanel4.add(jLabel4);

        jCheckBox4.setText("jCheckBox1");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckBox4);

        center.add(jPanel4);

        jLabel7.setText("jLabel1");
        jPanel7.add(jLabel7);

        jCheckBox7.setText("jCheckBox1");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        jPanel7.add(jCheckBox7);

        center.add(jPanel7);

        jLabel9.setText("jLabel1");
        jPanel9.add(jLabel9);

        jCheckBox9.setText("jCheckBox1");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });
        jPanel9.add(jCheckBox9);

        center.add(jPanel9);

        jLabel2.setIcon(MainWindow.natiPic[MainWindow.tribe][1]);
        jLabel2.setText("jLabel1");
        jPanel2.add(jLabel2);

        jCheckBox2.setText("jCheckBox1");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox2);

        center.add(jPanel2);

        jLabel5.setText("jLabel1");
        jPanel5.add(jLabel5);

        jCheckBox5.setText("jCheckBox1");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox5);

        center.add(jPanel5);

        jLabel8.setText("jLabel1");
        jPanel8.add(jLabel8);

        jCheckBox8.setText("jCheckBox1");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckBox8);

        center.add(jPanel8);

        jLabel10.setText("jLabel1");
        jPanel10.add(jLabel10);

        jCheckBox10.setText("jCheckBox1");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });
        jPanel10.add(jCheckBox10);

        center.add(jPanel10);

        jLabel3.setIcon(MainWindow.natiPic[MainWindow.tribe][2]);
        jLabel3.setText("jLabel1");
        jPanel3.add(jLabel3);

        jCheckBox3.setText("jCheckBox1");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox3);

        center.add(jPanel3);

        jLabel6.setText("jLabel1");
        jPanel6.add(jLabel6);

        jCheckBox6.setText("jCheckBox1");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox6);

        center.add(jPanel6);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        center.add(jPanel12);

        jLabel11.setText("jLabel1");
        jPanel11.add(jLabel11);

        jCheckBox11.setText("jCheckBox1");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });
        jPanel11.add(jCheckBox11);

        center.add(jPanel11);

        getContentPane().add(center, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()==true)
            MainWindow.unitsEvade[0] = true;
        else
            MainWindow.unitsEvade[0] = false;
        checkBoxName(jCheckBox1,0);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if(jCheckBox2.isSelected()==true)
            MainWindow.unitsEvade[1] = true;
        else
            MainWindow.unitsEvade[1] = false;
        checkBoxName(jCheckBox2,1);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if(jCheckBox3.isSelected()==true)
            MainWindow.unitsEvade[2] = true;
        else
            MainWindow.unitsEvade[2] = false;
        checkBoxName(jCheckBox3,2);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if(jCheckBox4.isSelected()==true)
            MainWindow.unitsEvade[3] = true;
        else
            MainWindow.unitsEvade[3] = false;
        checkBoxName(jCheckBox4,3);
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        if(jCheckBox5.isSelected()==true)
            MainWindow.unitsEvade[4] = true;
        else
            MainWindow.unitsEvade[4] = false;
        checkBoxName(jCheckBox5,4);
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        if(jCheckBox6.isSelected()==true)
            MainWindow.unitsEvade[5] = true;
        else
            MainWindow.unitsEvade[5] = false;
        checkBoxName(jCheckBox6,5);
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        if(jCheckBox7.isSelected()==true)
            MainWindow.unitsEvade[6] = true;
        else
            MainWindow.unitsEvade[6] = false;
        checkBoxName(jCheckBox7,6);
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        if(jCheckBox8.isSelected()==true)
            MainWindow.unitsEvade[7] = true;
        else
            MainWindow.unitsEvade[7] = false;
        checkBoxName(jCheckBox8,7);
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        if(jCheckBox9.isSelected()==true)
            MainWindow.unitsEvade[8] = true;
        else
            MainWindow.unitsEvade[8] = false;
        checkBoxName(jCheckBox9,8);
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        if(jCheckBox10.isSelected()==true)
            MainWindow.unitsEvade[9] = true;
        else
            MainWindow.unitsEvade[9] = false;
        checkBoxName(jCheckBox10,9);
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        if(jCheckBox11.isSelected()==true)
            MainWindow.unitsEvade[10] = true;
        else
            MainWindow.unitsEvade[10] = false;
        checkBoxName(jCheckBox11,10);
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged

        
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dispose();
            }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel center;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
