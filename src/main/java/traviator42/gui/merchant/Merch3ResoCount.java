/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.merchant;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

/**
 *
 * @author Ror
 */
public class Merch3ResoCount extends javax.swing.JDialog {

 //<editor-fold defaultstate="collapsed" desc=" картинки с ресами ">
 ImageIcon wood = new ImageIcon("images/wood.png");
 ImageIcon clay = new ImageIcon("images/clay.png");
 ImageIcon iron = new ImageIcon("images/iron.png");
 ImageIcon crop = new ImageIcon("images/crop.png");
 //</editor-fold>
boolean tradeRoutes;
    /**
     * Creates new form villageName
     */
    public Merch3ResoCount(java.awt.Frame parent, boolean modal, boolean tradeRoutes) {
        super(parent, MainWindow.messages[82][MainWindow.language], modal);
        initComponents();
        label.setText(MainWindow.messages[178][MainWindow.language]);
        jButton1.setText(MainWindow.messages[71][MainWindow.language]);
        jButton2.setText(MainWindow.messages[106][MainWindow.language]);
        woodinPush.setIcon(MainWindow.natiPic[4][4]);
        clayinpush.setIcon(MainWindow.natiPic[4][5]);
        ironInPush.setIcon(MainWindow.natiPic[4][6]);
        cropInPush.setIcon(MainWindow.natiPic[4][7]);
        
        this.tradeRoutes = tradeRoutes;
        
        SpinnerModel sm1 = new SpinnerNumberModel(MainWindow.reso[0], 0, 999999999, 500);
        jSpinner1.setModel(sm1);
        SpinnerModel sm2 = new SpinnerNumberModel(MainWindow.reso[1], 0, 999999999, 500);
        jSpinner2.setModel(sm2);
        SpinnerModel sm3 = new SpinnerNumberModel(MainWindow.reso[2], 0, 999999999, 500);
        jSpinner3.setModel(sm3);
        SpinnerModel sm4 = new SpinnerNumberModel(MainWindow.reso[3], 0, 999999999, 500);
        jSpinner4.setModel(sm4);
        
            
        
        
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
        clayinpush = new javax.swing.JLabel(clay);
        cropInPush = new javax.swing.JLabel(crop);
        woodinPush = new javax.swing.JLabel(wood);
        ironInPush = new javax.swing.JLabel(iron);
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();

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

        clayinpush.setText(MainWindow.messages[17][MainWindow.language]);

        cropInPush.setText(MainWindow.messages[19][MainWindow.language]);

        woodinPush.setText(MainWindow.messages[16][MainWindow.language]);

        ironInPush.setText(MainWindow.messages[18][MainWindow.language]);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner2)
                            .addComponent(jSpinner3)
                            .addComponent(jSpinner4)
                            .addComponent(jSpinner1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cropInPush)
                            .addComponent(clayinpush)
                            .addComponent(woodinPush)
                            .addComponent(ironInPush)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(label))
                        .addGap(0, 73, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(woodinPush)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clayinpush)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ironInPush)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cropInPush)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
      
                        //<editor-fold defaultstate="collapsed" desc="основной блок">
                    
                    MainWindow.futureRow[2] = jSpinner1.getValue().toString();
                    MainWindow.futureRow[3] = jSpinner2.getValue().toString();
                    MainWindow.futureRow[4] = jSpinner3.getValue().toString();
                    MainWindow.futureRow[5] = jSpinner4.getValue().toString();
                    
                    MainWindow.reso[0] = Integer.parseInt(jSpinner1.getValue().toString());
                    MainWindow.reso[1] = Integer.parseInt(jSpinner2.getValue().toString());
                    MainWindow.reso[2] = Integer.parseInt(jSpinner3.getValue().toString());
                    MainWindow.reso[3] = Integer.parseInt(jSpinner4.getValue().toString());
                    
                     //</editor-fold>
                    if(tradeRoutes == false){
                    Merch4ResoProperties mrp = new Merch4ResoProperties(Traviator42.mainWindow, true);
                    mrp.setVisible(true);
                    }else{
                        Merch5TradeRoutes tr = new Merch5TradeRoutes(Traviator42.mainWindow, true);
                        tr.setVisible(true);
                    }
                    dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel clayinpush;
    public static javax.swing.JLabel cropInPush;
    public static javax.swing.JLabel ironInPush;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JLabel label;
    public static javax.swing.JLabel woodinPush;
    // End of variables declaration//GEN-END:variables
}
