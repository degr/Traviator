package traviator42.gui.misc;

import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;
import traviator42.gui.misc.BlackSmith1;
import traviator42.threads.ThreadWait;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainTroops extends javax.swing.JDialog {
    
boolean banditoStart = true; //если тру, то запуск фарма, если фалсе, то запуск улучшения

    public MainTroops(java.awt.Frame parent, boolean modal, int superNum, boolean banditoStart) {
        super(parent, modal);
        this.setTitle(MainWindow.messages[superNum][MainWindow.language]);
        initComponents();
        this.banditoStart = banditoStart;
        buttonCancel.setText(MainWindow.messages[71][MainWindow.language]);
        IconCreater();
        if(banditoStart == true){
            buttonOk.setIcon(MainWindow.natiPic[4][25]);
        }else{
            buttonOk.setIcon(MainWindow.natiPic[4][24]);
        }
 //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
 //делаем чтобы приложение появилось в центре экрана
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 Dimension frameSize = getSize();
 setLocation(new Point((screenSize.width - frameSize.width) / 2,
 (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
 //</editor-fold>
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonCancel = new javax.swing.JButton(MainWindow.natiPic[4][14]);
        buttonOk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        checkBoxT4 = new javax.swing.JCheckBox();
        fighter4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        checkBoxT8 = new javax.swing.JCheckBox();
        fighter8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        checkBoxT3 = new javax.swing.JCheckBox();
        fighter3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        fighter7 = new javax.swing.JLabel();
        checkBoxT7 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        checkBoxT1 = new javax.swing.JCheckBox();
        fighter1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        fighter5 = new javax.swing.JLabel();
        checkBoxT5 = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        fighter6 = new javax.swing.JLabel();
        checkBoxT6 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        fighter2 = new javax.swing.JLabel();
        checkBoxT2 = new javax.swing.JCheckBox();

        if(banditoStart == false){
            buttonGroup1.add(checkBoxT1);
            buttonGroup1.add(checkBoxT2);
            buttonGroup1.add(checkBoxT3);
            buttonGroup1.add(checkBoxT4);
            buttonGroup1.add(checkBoxT5);
            buttonGroup1.add(checkBoxT6);
            buttonGroup1.add(checkBoxT7);
            buttonGroup1.add(checkBoxT8);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonCancel.setText("Отмена");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonOk.setText("Ок");
        buttonOk.setEnabled(false);
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fighter4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxT4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxT4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fighter4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxT8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fighter8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxT8))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxT8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fighter8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(fighter3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxT3))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxT3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fighter3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxT7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fighter7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxT7))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxT7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fighter7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fighter1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxT1))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fighter1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxT1)))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxT5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(fighter5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxT5))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fighter5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxT5)))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxT6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fighter6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxT6))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fighter6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxT6, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fighter2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxT2))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fighter2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxT2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(buttonOk, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(buttonCancel))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(buttonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOk)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
         setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
    if(banditoStart == true){ 
       if(checkBoxT1.isSelected() ||checkBoxT2.isSelected() ||checkBoxT3.isSelected() ||
       checkBoxT4.isSelected() ||checkBoxT5.isSelected() ||checkBoxT6.isSelected() ||
       checkBoxT7.isSelected() ||checkBoxT8.isSelected()){
             if(checkBoxT1.isSelected())troops(1,1,1,0);
             if(checkBoxT2.isSelected())troops(2,2,1,1);
             if(checkBoxT3.isSelected())troops(3,3,1,2);
             if(checkBoxT4.isSelected())troops(4,1,2,3);
             if(checkBoxT5.isSelected())troops(5,2,2,4);
             if(checkBoxT6.isSelected())troops(6,2,3,5);
             if(checkBoxT7.isSelected())troops(7,1,3,6);
             if(checkBoxT8.isSelected())troops(8,2,3,7);
             MainWindow.farmTroop.setLayout(new FlowLayout());
             MainWindow.farmTroop.setPreferredSize(new Dimension(MainWindow.farmTroop.getComponentCount()*30, 26));
             MainWindow.farmTroop.revalidate();
             dispose();
             ThreadWait tw = new ThreadWait();
        }
    }else{
        String troop = "";
      if(checkBoxT1.isSelected()){troop = MainWindow.units[MainWindow.tribe][0][MainWindow.language];}
      if(checkBoxT2.isSelected()){troop = MainWindow.units[MainWindow.tribe][1][MainWindow.language];}
      if(checkBoxT3.isSelected()){troop = MainWindow.units[MainWindow.tribe][2][MainWindow.language];}
      if(checkBoxT4.isSelected()){troop = MainWindow.units[MainWindow.tribe][3][MainWindow.language];}
      if(checkBoxT5.isSelected()){troop = MainWindow.units[MainWindow.tribe][4][MainWindow.language];}
      if(checkBoxT6.isSelected()){troop = MainWindow.units[MainWindow.tribe][5][MainWindow.language];}
      if(checkBoxT7.isSelected()){troop = MainWindow.units[MainWindow.tribe][6][MainWindow.language];}
      if(checkBoxT8.isSelected()){troop = MainWindow.units[MainWindow.tribe][7][MainWindow.language];}
      
      BlackSmith1 bs = new BlackSmith1(Traviator42.mainWindow, true, troop);
      bs.setVisible(true);
        
        dispose();
    }
    }//GEN-LAST:event_buttonOkActionPerformed

    private void checkBoxT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT1ActionPerformed
      buttonOk.setEnabled(true);  // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxT1ActionPerformed

    private void checkBoxT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT2ActionPerformed
      buttonOk.setEnabled(true);   // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxT2ActionPerformed

    private void checkBoxT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT3ActionPerformed
      buttonOk.setEnabled(true);   // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxT3ActionPerformed

    private void checkBoxT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT4ActionPerformed
      buttonOk.setEnabled(true);   // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxT4ActionPerformed

    private void checkBoxT5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT5ActionPerformed
       buttonOk.setEnabled(true);  // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxT5ActionPerformed

    private void checkBoxT6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT6ActionPerformed
       buttonOk.setEnabled(true);  // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxT6ActionPerformed

    private void checkBoxT7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT7ActionPerformed
       buttonOk.setEnabled(true);  // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxT7ActionPerformed

    private void checkBoxT8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT8ActionPerformed
       buttonOk.setEnabled(true);  // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxT8ActionPerformed
    static void troops(int t, int row, int col, int img){
        MainWindow.troops.add(new Integer[]{t, row, col});
        MainWindow.farmTroop.add(new JLabel(" ", MainWindow.natiPic[MainWindow.tribe][img], SwingConstants.RIGHT));
    }
    
    
    public static void IconCreater(){
        fighter1.setIcon(MainWindow.natiPic[MainWindow.tribe][0]);
        fighter2.setIcon(MainWindow.natiPic[MainWindow.tribe][1]);
        fighter3.setIcon(MainWindow.natiPic[MainWindow.tribe][2]);
        fighter4.setIcon(MainWindow.natiPic[MainWindow.tribe][3]);
        fighter6.setIcon(MainWindow.natiPic[MainWindow.tribe][4]);
        fighter5.setIcon(MainWindow.natiPic[MainWindow.tribe][5]);
        fighter7.setIcon(MainWindow.natiPic[MainWindow.tribe][6]);
        fighter8.setIcon(MainWindow.natiPic[MainWindow.tribe][7]);
       }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton buttonCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JButton buttonOk;
    public static javax.swing.JCheckBox checkBoxT1;
    public static javax.swing.JCheckBox checkBoxT2;
    public static javax.swing.JCheckBox checkBoxT3;
    public static javax.swing.JCheckBox checkBoxT4;
    public static javax.swing.JCheckBox checkBoxT5;
    public static javax.swing.JCheckBox checkBoxT6;
    public static javax.swing.JCheckBox checkBoxT7;
    public static javax.swing.JCheckBox checkBoxT8;
    public static javax.swing.JLabel fighter1;
    public static javax.swing.JLabel fighter2;
    public static javax.swing.JLabel fighter3;
    public static javax.swing.JLabel fighter4;
    public static javax.swing.JLabel fighter5;
    public static javax.swing.JLabel fighter6;
    public static javax.swing.JLabel fighter7;
    public static javax.swing.JLabel fighter8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
