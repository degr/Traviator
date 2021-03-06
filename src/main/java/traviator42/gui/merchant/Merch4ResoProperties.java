/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.merchant;

import traviator42.gui.common.MainWindow;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Ror
 */
public class Merch4ResoProperties extends javax.swing.JDialog {

 //<editor-fold defaultstate="collapsed" desc=" картинки с ресами ">
 ImageIcon wood = new ImageIcon("images/wood.png");
 ImageIcon clay = new ImageIcon("images/clay.png");
 ImageIcon iron = new ImageIcon("images/iron.png");
 ImageIcon crop = new ImageIcon("images/crop.png");
 //</editor-fold>

    /**
     * Creates new form villageName
     */
    public Merch4ResoProperties(java.awt.Frame parent, boolean modal) {
        super(parent, MainWindow.messages[82][MainWindow.language], modal);
        initComponents();
        label.setText(MainWindow.messages[82][MainWindow.language]);
        jButton1.setText(MainWindow.messages[71][MainWindow.language]);
        jButton2.setText(MainWindow.messages[106][MainWindow.language]);
 //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
 //делаем чтобы приложение появилось в центре экрана
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 Dimension frameSize = getSize();
 setLocation(new Point((screenSize.width - frameSize.width) / 2,
 (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
 //</editor-fold>
        checkboxUnlimitedPushes.doClick();
        textfieldWait.setText("60");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton(MainWindow.natiPic[4][14]);
        jButton2 = new javax.swing.JButton(MainWindow.natiPic[4][25]);
        label = new javax.swing.JLabel();
        minutes = new javax.swing.JLabel();
        textfieldWait = new javax.swing.JTextField();
        wairt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        textFieldPushesTotal = new javax.swing.JTextField();
        pushesTotal = new javax.swing.JLabel();
        checkboxUnlimitedPushes = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        minutes.setText(MainWindow.messages[22][MainWindow.language]);

        textfieldWait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldWaitActionPerformed(evt);
            }
        });

        wairt.setText(MainWindow.messages[21][MainWindow.language]);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pushesTotal.setText(MainWindow.messages[20][MainWindow.language]);

        checkboxUnlimitedPushes.setText(MainWindow.messages[24][MainWindow.language]);
        checkboxUnlimitedPushes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxUnlimitedPushesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkboxUnlimitedPushes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldPushesTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pushesTotal)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPushesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pushesTotal)
                    .addComponent(checkboxUnlimitedPushes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(wairt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textfieldWait, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minutes))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldWait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wairt)
                    .addComponent(minutes))
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
     
  if(   !"".equals(textfieldWait.getText())){
      if(   !"".equals(textFieldPushesTotal.getText())){
     
        MainWindow.futureRow[6] = MainWindow.setTimer(textfieldWait.getText());
        MainWindow.futureRow[7] = textFieldPushesTotal.getText();
        MainWindow.futureRow[8] = textfieldWait.getText();
                    //если количество строк равно нулю, то просто вставляем
        MainWindow.merchModel.insertRow(MainWindow.rowNumber(MainWindow.merchModel, 6, MainWindow.futureRow[6]),
               new Object[]{ MainWindow.futureRow[0], MainWindow.futureRow[1], MainWindow.futureRow[2], 
                             MainWindow.futureRow[3], MainWindow.futureRow[4], MainWindow.futureRow[5],
                             MainWindow.futureRow[6], MainWindow.futureRow[7], MainWindow.futureRow[8],
                             MainWindow.futureRow[9]});          
                    
        dispose();
      }else{textFieldPushesTotal.setText("5");}
      }else{textfieldWait.setText("60");}
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textfieldWaitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldWaitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldWaitActionPerformed

    private void checkboxUnlimitedPushesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkboxUnlimitedPushesItemStateChanged
        if (checkboxUnlimitedPushes.isSelected()) {
            textFieldPushesTotal.setText("999");
            textFieldPushesTotal.setEnabled(false);
        } else {
            textFieldPushesTotal.setText("");
            textFieldPushesTotal.setEnabled(true);
        }
    }//GEN-LAST:event_checkboxUnlimitedPushesItemStateChanged

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox checkboxUnlimitedPushes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    public static javax.swing.JLabel minutes;
    public static javax.swing.JLabel pushesTotal;
    private static javax.swing.JTextField textFieldPushesTotal;
    private static javax.swing.JTextField textfieldWait;
    public static javax.swing.JLabel wairt;
    // End of variables declaration//GEN-END:variables
}
