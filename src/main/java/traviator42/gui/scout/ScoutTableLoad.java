package traviator42.gui.scout;

import traviator42.threads.ThreadSearchCount;
import traviator42.gui.common.MainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

public class ScoutTableLoad extends javax.swing.JDialog {
       List<List<String>> firstFile;
       List<List<String>> secondFile;
    public ScoutTableLoad(java.awt.Frame parent, boolean modal) {
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonTable2 = new javax.swing.JButton(MainWindow.natiPic[4][24]);
        buttonCompare = new javax.swing.JButton(MainWindow.natiPic[4][25]);
        buttonScan = new javax.swing.JButton(MainWindow.natiPic[4][25]);
        checkBoxTable1 = new javax.swing.JCheckBox();
        checkBoxTable2 = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton(MainWindow.natiPic[4][14]);
        buttonTable1 = new javax.swing.JButton(MainWindow.natiPic[4][24]);
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText(MainWindow.messages[261][MainWindow.language]);

        jLabel3.setText(MainWindow.messages[262][MainWindow.language]);

        buttonTable2.setText(MainWindow.messages[264][MainWindow.language]);
        buttonTable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTable2ActionPerformed(evt);
            }
        });

        buttonCompare.setText(MainWindow.messages[265][MainWindow.language]);
        buttonCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCompareActionPerformed(evt);
            }
        });

        buttonScan.setText(MainWindow.messages[266][MainWindow.language]);
        buttonScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonScanActionPerformed(evt);
            }
        });

        checkBoxTable1.setEnabled(false);

        checkBoxTable2.setEnabled(false);

        jButton4.setText(MainWindow.messages[71][MainWindow.language]);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonTable1.setText(MainWindow.messages[263][MainWindow.language]);
        buttonTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTable1ActionPerformed(evt);
            }
        });

        jLabel4.setText(MainWindow.messages[260][MainWindow.language]);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonScan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCompare, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttonTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonTable2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxTable2)
                                    .addComponent(checkBoxTable1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel4))
                        .addGap(0, 191, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxTable1)
                    .addComponent(buttonTable1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTable2)
                    .addComponent(checkBoxTable2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCompare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonScan)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonScanActionPerformed
                       ThreadSearchCount tsc = new ThreadSearchCount();
                       dispose();
    }//GEN-LAST:event_buttonScanActionPerformed

    private void buttonTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTable1ActionPerformed

     firstFile = openfile(MainWindow.firstFile, 1);


    }//GEN-LAST:event_buttonTable1ActionPerformed

    private void buttonTable2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTable2ActionPerformed

     secondFile = openfile(MainWindow.secondFile, 2);


    }//GEN-LAST:event_buttonTable2ActionPerformed

    private void buttonCompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCompareActionPerformed
       
       while(MainWindow.scoutModel.getRowCount() > 0) 
       MainWindow.scoutModel.removeRow(0);
          
     for(int i = 0; i < firstFile.size(); i++){
         List<String> row1 = firstFile.get(i);
         boolean stop = false;
         for(int j = 0; j < secondFile.size() && stop == false; j++){
         List<String> row2 = secondFile.get(j);
         if(row1.get(0).equals(row2.get(0)) && row1.get(2).equals(row2.get(2)) ){
            
         MainWindow.scoutModel.addRow(new Object[]{
             row1.get(0),row1.get(1),row1.get(2)
         });
         stop = true;
         }   
         }
     }
        MainWindow.consoleText(Color.BLACK, MainWindow.messages[121][MainWindow.language] + " " + MainWindow.scoutModel.getRowCount());
        dispose();
    }//GEN-LAST:event_buttonCompareActionPerformed
 
    
 List<List<String>> openfile(String file, int checkBox){
     List<List<String>> value = new ArrayList<>();
  JFileChooser opener = new JFileChooser("./");
   int returnVal = opener.showOpenDialog(this);  
      File loadFile = opener.getSelectedFile();

  if(returnVal == JFileChooser.APPROVE_OPTION){

        try {
        BufferedReader openReader = new BufferedReader(new InputStreamReader(
        new FileInputStream(loadFile.getAbsolutePath()), "utf8"));
        String line;
        while((line = openReader.readLine()) != null){
            if(line.indexOf("<tr>") > -1){
                List<String> temp = new ArrayList<>();
                for(int i = 0; i < 3; i++){
                    String row = openReader.readLine();
                    row = row.substring(row.indexOf("<td>")+4, row.indexOf("</td>"));
                    temp.add(row);
                }
                value.add(temp);
            }
        }
        }catch (FileNotFoundException ex) { 
        }
        catch (UnsupportedEncodingException ex) {
        }
        catch (IOException | java.lang.StringIndexOutOfBoundsException ex) {   
        }
   }
  if(checkBox == 1){
      checkBoxTable1.setSelected(true);
      checkBoxTable1.setText(loadFile.getAbsolutePath());
  }
  if(checkBox == 2){
      checkBoxTable2.setSelected(true);
      checkBoxTable2.setText(loadFile.getAbsolutePath());
  }
    buttonScanEnable();
  return value;
   }
   
 void buttonScanEnable(){
     try{
    if(firstFile.size() > 0 && secondFile.size() > 0){
        buttonCompare.setEnabled(true);
    }
     }catch(NullPointerException ex){}
 }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCompare;
    private javax.swing.JButton buttonScan;
    private javax.swing.JButton buttonTable1;
    private javax.swing.JButton buttonTable2;
    private javax.swing.JCheckBox checkBoxTable1;
    private javax.swing.JCheckBox checkBoxTable2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
