/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.evacuator;

import traviator42.gui.attack.Attack2Troops;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;
import traviator42.gui.evacuator.Evakuator4TroopsDirection;
import traviator42.gui.evacuator.Evakuator5timeCount;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author Ror
 */
public class MainCoordDirection extends javax.swing.JDialog {
    int toggle;
    int wave;
    /**
     * Creates new form villageName
     */
//    boolean troops - определяет, открывать окошко с параметрами пехоты или нет

    public MainCoordDirection(java.awt.Frame parent, boolean modal, int toggle/*0 - эвакуатор с солдатами, 
     *                                                                          1 - эвакуатор без солдат
                                                                                2 - менеджер атак*/,
                                                                    int wave) {
        super(parent, MainWindow.messages[82][MainWindow.language], modal);
        initComponents();
        if(toggle < 2){
        label.setText(MainWindow.messages[190][MainWindow.language]);
        }else{
            label.setText(MainWindow.messages[320][MainWindow.language]);
        }
        jButton1.setText(MainWindow.messages[71][MainWindow.language]);
        jButton2.setText(MainWindow.messages[106][MainWindow.language]);
        jTextField1.setText("");
        jTextField2.setText("");
        this.toggle = toggle;
        this.wave = wave;
 //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
 //делаем чтобы приложение появилось в центре экрана
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 Dimension frameSize = getSize();
 setLocation(new Point((screenSize.width - frameSize.width) / 2,
 (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
 //</editor-fold>
       
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
        jButton2 = new javax.swing.JButton(MainWindow.natiPic[4][24]);
        label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

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

        jLabel1.setText("X");

        jLabel2.setText("Y");

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
                    .addComponent(label)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
       
        if(!"".equals(jTextField1.getText()) && !"".equals(jTextField2.getText())){
        MainWindow.futureRow[2] = jTextField1.getText() + "/"+jTextField2.getText();
        if(toggle == 0){
            Traviator42.eva4 = new Evakuator4TroopsDirection(Traviator42.mainWindow, true);
            Traviator42.eva4.setVisible(true);
        }else if(toggle == 1){
            MainWindow.futureRow[3] = "---";
            Traviator42.eva5 = new Evakuator5timeCount(Traviator42.mainWindow, true);
            Traviator42.eva5.setVisible(true);
        }else if(toggle == 2){
            MainWindow.futureRow[4] = MainWindow.futureRow[2];
            Attack2Troops a2t = new Attack2Troops(Traviator42.mainWindow, true, wave, 1);
            a2t.setVisible(true);
        }
        dispose();
       }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
