/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.misc;

import traviator42.threads.MainCopyStatus;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Reports extends javax.swing.JDialog {
boolean gSword = true;
boolean ySword = false;
boolean rSword = false;
boolean gScout = false;
boolean yScout = false;
boolean rScout = true;
boolean trade = true;
boolean adventure = true;
   
    public Reports(java.awt.Frame parent, boolean modal) {
        super(parent,"Reports manager", modal);
        initComponents();
         //делаем чтобы приложение появилось в центре экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2));
        jCheckBox1.setSelected(true);
        jCheckBox6.setSelected(true);
        jCheckBox7.setSelected(true);
        jCheckBox8.setSelected(true);
        jCheckBox1.setText(MainWindow.messages[360][MainWindow.language]);
        jCheckBox2.setText(MainWindow.messages[361][MainWindow.language]);
        jCheckBox3.setText(MainWindow.messages[362][MainWindow.language]);
        jCheckBox4.setText(MainWindow.messages[363][MainWindow.language]);
        jCheckBox5.setText(MainWindow.messages[364][MainWindow.language]);
        jCheckBox6.setText(MainWindow.messages[365][MainWindow.language]);
        jCheckBox7.setText(MainWindow.messages[366][MainWindow.language]);
        jCheckBox8.setText(MainWindow.messages[367][MainWindow.language]);
        jButton1.setText(MainWindow.messages[71][MainWindow.language]);
        jButton2.setText(MainWindow.messages[106][MainWindow.language]);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton(MainWindow.natiPic[4][14]);
        jButton2 = new javax.swing.JButton(MainWindow.natiPic[4][24]);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jCheckBox1.setText("зеленые мечи");

        jCheckBox2.setText("желтые мечи");

        jCheckBox3.setText("красные мечи");

        jCheckBox4.setText("зеленая разведка");

        jCheckBox5.setText("желтая разведка");

        jCheckBox6.setText("красная разведка");

        jCheckBox7.setText("торговые отчеты");

        jCheckBox8.setText("отчеты о приключениях");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<String> arr = arr();
        dispose();
        MainCopyStatus mcp = new MainCopyStatus(Traviator42.mainWindow, true, 8, 0, "", false, arr);
 
    mcp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
ArrayList<String> arr(){
    ArrayList<String> arr = new ArrayList<>();
    arr.add(val(gSword));
    arr.add(val(ySword));
    arr.add(val(rSword));
    arr.add(val(gScout));
    arr.add(val(yScout));
    arr.add(val(rScout));
    arr.add(val(rScout));
    arr.add(val(adventure));
    return arr;
}
String val(boolean bool){
    String val;
    if(bool == true)
        val = "1";
    else
        val = "0";
    return val; 
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    // End of variables declaration//GEN-END:variables
}
