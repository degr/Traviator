/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.architector;

import traviator42.dto.Village;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

import java.awt.*;

/**
 *
 * @author Ror
 */
public class Architector1Villy extends javax.swing.JDialog {
static boolean loadd = false;
boolean constr = true;
boolean firstTab;
    public Architector1Villy(java.awt.Frame parent, boolean modal, boolean constr, boolean firstTab) {
        super(parent, MainWindow.messages[159][MainWindow.language], modal);
        this.constr = constr;
        this.firstTab = firstTab;
        initComponents();
        if(constr == true){
        label.setText(MainWindow.messages[180][MainWindow.language]);
        jLabel1.setText(MainWindow.messages[203][MainWindow.language]);
        jLabel2.setText(MainWindow.messages[91][MainWindow.language]);
        }else{
        label.setText(MainWindow.messages[286][MainWindow.language]);
        jLabel1.setText(MainWindow.messages[287][MainWindow.language]);
        jLabel2.setText(MainWindow.messages[91][MainWindow.language]);   
        }
        jButton1.setText(MainWindow.messages[71][MainWindow.language]);
        jButton2.setText(MainWindow.messages[106][MainWindow.language]);
        jTextField1.setText("30");
 //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
 //делаем чтобы приложение появилось в центре экрана
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 Dimension frameSize = getSize();
 setLocation(new Point((screenSize.width - frameSize.width) / 2,
 (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
 //</editor-fold>
        jComboBox1.removeAllItems();
        for(int i = 0; i<MainWindow.vilList.size(); i++){
            jComboBox1.addItem(MainWindow.vilList.get(i).name);
            
        }
        loadd = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton(MainWindow.natiPic[4][14]);
        jButton2 = new javax.swing.JButton(MainWindow.natiPic[4][24]);
        label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

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

        label.setText("Где тренировать солдат?");

        jLabel1.setText("jLabel1");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTextField1.getText() == null || "".equals(jTextField1.getText()))jTextField1.setText("30");
        MainWindow.comboBoxArcVillages.setSelectedIndex(jComboBox1.getSelectedIndex());
        MainWindow.comboBoxArcVillagesDouble.setSelectedIndex(jComboBox1.getSelectedIndex());
        MainWindow.comboBoxArcVillagesDemolish.setSelectedIndex(jComboBox1.getSelectedIndex());

        int delay = Integer.valueOf(jTextField1.getText());
        if(delay < MainWindow.delay)
            jTextField1.setText(String.valueOf(MainWindow.delay));
        
        if(constr == true){
            Traviator42.arch2 = new Architector2Villy(Traviator42.mainWindow, true, jTextField1.getText(), firstTab);
            Traviator42.arch2.setVisible(true);
        }else{
            MainWindow.vilNum = jComboBox1.getSelectedIndex();
            
            Architector4demolish a4d = new Architector4demolish(Traviator42.mainWindow,
                                                                true,
                                                                jComboBox1.getSelectedItem().toString(), 
                                                                jTextField1.getText(),
                                                                MainWindow.vilNum
                                                                );
            a4d.setVisible(true);
        }
        dispose();
        loadd = false;
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
        if(loadd == true && jComboBox1.getSelectedIndex() != -1){
            Village temp = MainWindow.vilList.get(jComboBox1.getSelectedIndex());
            if(constr == true){
                jTextField1.setText(temp.period);
            }else{
                jTextField1.setText(temp.dPeriod);
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
