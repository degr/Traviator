
package traviator42.gui.bandito;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import org.openqa.selenium.By;
import traviator42.threads.MainCopyStatus;
import traviator42.gui.common.Traviator42;
import traviator42.gui.common.MainWindow;

public class Bandito1Robot extends javax.swing.JDialog {
public static int selectedUnit = 1, banditScout = 0;
String analizator;
    public Bandito1Robot(java.awt.Frame parent, boolean modal, int banditScout, String analizator) {
        super(parent, MainWindow.messages[83][MainWindow.language], modal);
        initComponents();
        Bandito1Robot.banditScout = banditScout;
        this.analizator = analizator;
        //делаем чтобы приложение появилось в центре экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2));
         
        jLabel1.setText(MainWindow.messages[104][MainWindow.language]);
        jLabel2.setText(MainWindow.messages[105][MainWindow.language]);
        buttonPreferences.setText(MainWindow.messages[82][MainWindow.language]);
        buttonCancel.setText(MainWindow.messages[71][MainWindow.language]);
        buttonNext.setText(MainWindow.messages[106][MainWindow.language]);
        
        fighter1.setIcon(MainWindow.natiPic[MainWindow.tribe][0]);
        fighter2.setIcon(MainWindow.natiPic[MainWindow.tribe][1]);
        fighter3.setIcon(MainWindow.natiPic[MainWindow.tribe][2]);
        fighter4.setIcon(MainWindow.natiPic[MainWindow.tribe][3]);
        fighter5.setIcon(MainWindow.natiPic[MainWindow.tribe][4]);
        fighter6.setIcon(MainWindow.natiPic[MainWindow.tribe][5]);
        
       
        jComboBox1.removeAllItems();
        for(int i = 0; i < MainWindow.vilList.size(); i++){
            jComboBox1.addItem(MainWindow.vilList.get(i).name);
        }
        comboBoxOldFarmList.removeAllItems();
        comboBoxOldFarmList.setEnabled(false);
        checkBoxOldFarmList.setText(MainWindow.messages[218][MainWindow.language]);
            if (checkBoxOldFarmList.isSelected() == true) {
            comboBoxOldFarmList.setEnabled(true);
            textFieldFarmListName.setText("");
            textFieldFarmListName.setEnabled(false);
            farmList();
        } else {
            comboBoxOldFarmList.setEnabled(false);
            textFieldFarmListName.setText("");
            textFieldFarmListName.setEnabled(true);
            comboBoxOldFarmList.removeAllItems();
        }
         SpinnerModel sm1 = new SpinnerNumberModel(100, 1, 1000, 10);  
         jSpinner1.setModel(sm1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        textFieldFarmListName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonPreferences = new javax.swing.JButton(MainWindow.natiPic[4][19]);
        buttonCancel = new javax.swing.JButton(MainWindow.natiPic[4][14]);
        buttonNext = new javax.swing.JButton(MainWindow.natiPic[4][24]);
        checkBoxT3 = new javax.swing.JCheckBox();
        fighter3 = new javax.swing.JLabel();
        fighter2 = new javax.swing.JLabel();
        checkBoxT2 = new javax.swing.JCheckBox();
        chekBoxt1 = new javax.swing.JCheckBox();
        fighter1 = new javax.swing.JLabel();
        fighter4 = new javax.swing.JLabel();
        fighter5 = new javax.swing.JLabel();
        fighter6 = new javax.swing.JLabel();
        checkBoxT6 = new javax.swing.JCheckBox();
        checkBoxT5 = new javax.swing.JCheckBox();
        checkBoxT4 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        checkBoxOldFarmList = new javax.swing.JCheckBox();
        comboBoxOldFarmList = new javax.swing.JComboBox();
        villylabel = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();

        buttonGroup1.add(chekBoxt1);
        buttonGroup1.add(checkBoxT2);
        buttonGroup1.add(checkBoxT3);
        buttonGroup1.add(checkBoxT4);
        buttonGroup1.add(checkBoxT5);
        buttonGroup1.add(checkBoxT6);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textFieldFarmListName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFarmListNameActionPerformed(evt);
            }
        });

        jLabel1.setText("Название листа");

        buttonPreferences.setText("настройки");
        buttonPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreferencesActionPerformed(evt);
            }
        });

        buttonCancel.setText("отмена");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonNext.setText("продолжить");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });

        checkBoxT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT3ActionPerformed(evt);
            }
        });

        fighter3.setText("3");

        fighter2.setText("2");

        checkBoxT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT2ActionPerformed(evt);
            }
        });

        chekBoxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chekBoxt1ActionPerformed(evt);
            }
        });

        fighter1.setText("1");

        fighter4.setText("4");

        fighter5.setText("5");

        fighter6.setText("6");

        checkBoxT6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT6ActionPerformed(evt);
            }
        });

        checkBoxT5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT5ActionPerformed(evt);
            }
        });

        checkBoxT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxT4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Выберите кем производить фарм");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        checkBoxOldFarmList.setText("jCheckBox1");
        checkBoxOldFarmList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBoxOldFarmListItemStateChanged(evt);
            }
        });

        comboBoxOldFarmList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        villylabel.setText("В деревне");

        jLabel3.setText("Максимум целей в фарм листе");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldFarmListName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 116, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonPreferences)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonNext)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fighter1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chekBoxt1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fighter2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxT2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fighter3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxT3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fighter4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxT4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fighter5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxT5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fighter6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkBoxT6)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(villylabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkBoxOldFarmList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxOldFarmList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(villylabel)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxOldFarmList)
                    .addComponent(comboBoxOldFarmList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldFarmListName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fighter1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chekBoxt1)
                        .addComponent(fighter2)
                        .addComponent(checkBoxT2))
                    .addComponent(fighter3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxT3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fighter4)
                        .addComponent(checkBoxT4)
                        .addComponent(fighter5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBoxT5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fighter6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBoxT6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPreferences)
                    .addComponent(buttonCancel)
                    .addComponent(buttonNext))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldFarmListNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFarmListNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFarmListNameActionPerformed

    private void buttonPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreferencesActionPerformed
dispose();
MainWindow.buttonPreferences.doClick();
    }//GEN-LAST:event_buttonPreferencesActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
dispose();    
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
if(chekBoxt1.isSelected() || checkBoxT2.isSelected() || checkBoxT3.isSelected()
         || checkBoxT4.isSelected() || checkBoxT5.isSelected() || checkBoxT6.isSelected()){
 //если выбран новый лист, но нет названия
    if(textFieldFarmListName.getText().equals("") && checkBoxOldFarmList.isSelected() == false){
        textFieldFarmListName.setText("farmList");
    }else{
        String farmListName; boolean newOrOld;
        if(checkBoxOldFarmList.isSelected() == false)
            farmListName = textFieldFarmListName.getText();
        else
            farmListName = comboBoxOldFarmList.getSelectedItem().toString();
        
        newOrOld = !checkBoxOldFarmList.isSelected();
        dispose();
        ArrayList<String> olo = new ArrayList<>();
        olo.add(jSpinner1.getValue().toString().trim());
        olo.add(analizator);
        MainWindow.villageChange(jComboBox1.getSelectedItem().toString(), "dorf1.php", "");
        MainCopyStatus ccc = new MainCopyStatus(Traviator42.mainWindow, true, banditScout, jComboBox1.getSelectedIndex(), farmListName, newOrOld, olo);
        ccc.setVisible(true);
        MainWindow.consoleText(Color.BLACK, MainWindow.messages[44][MainWindow.language]);
    }
}else{
    chekBoxt1.doClick();
}
    }//GEN-LAST:event_buttonNextActionPerformed

    private void chekBoxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chekBoxt1ActionPerformed
      if(chekBoxt1.isSelected())
          selectedUnit = 1;
    }//GEN-LAST:event_chekBoxt1ActionPerformed

    private void checkBoxT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT2ActionPerformed
            if(checkBoxT2.isSelected())
          selectedUnit = 2;
    }//GEN-LAST:event_checkBoxT2ActionPerformed

    private void checkBoxT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT3ActionPerformed
         if(checkBoxT3.isSelected())
          selectedUnit = 3;
    }//GEN-LAST:event_checkBoxT3ActionPerformed

    private void checkBoxT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT4ActionPerformed
         if(checkBoxT4.isSelected())
          selectedUnit = 4;
    }//GEN-LAST:event_checkBoxT4ActionPerformed

    private void checkBoxT5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT5ActionPerformed
   if(checkBoxT5.isSelected())
          selectedUnit = 5;       
    }//GEN-LAST:event_checkBoxT5ActionPerformed

    private void checkBoxT6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxT6ActionPerformed
          if(checkBoxT6.isSelected())
          selectedUnit = 6;
    }//GEN-LAST:event_checkBoxT6ActionPerformed

    private void checkBoxOldFarmListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxOldFarmListItemStateChanged
        if (checkBoxOldFarmList.isSelected() == true) {
            comboBoxOldFarmList.setEnabled(true);
            textFieldFarmListName.setText("");
            textFieldFarmListName.setEnabled(false);
            farmList();
        } else {
            comboBoxOldFarmList.setEnabled(false);
            textFieldFarmListName.setText("");
            textFieldFarmListName.setEnabled(true);
            comboBoxOldFarmList.removeAllItems();
        }
    }//GEN-LAST:event_checkBoxOldFarmListItemStateChanged
 void farmList(){
        villageChange(jComboBox1.getSelectedItem().toString(), "build.php", "&id=39&tt=99&gid=16"); 
        int i =  MainWindow.driver.findElements(By.className("listTitleText")).size();
        comboBoxOldFarmList.removeAllItems();
        for(int j = 1; j<=i; j++){
            comboBoxOldFarmList.addItem(MainWindow.driver.findElement(By.xpath("(//div [@ class = 'listTitleText'])["+j+"]")).getText());
        }
    }
    static void villageChange(String villyName, String suffiks, String building){
        boolean stop = false;  int k = 0;
        for(int i = 0; i < MainWindow.vilList.size() && stop == false; i++){
            if(MainWindow.vilList.get(i).name.equals(villyName)){
                k = i; 
            }
        }
        String villyId = MainWindow.vilList.get(k).url.substring(MainWindow.vilList.get(k).url.indexOf("?newdid"));
        MainWindow.driver.navigate().to(MainWindow.server + suffiks +villyId + building);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonPreferences;
    private javax.swing.JCheckBox checkBoxOldFarmList;
    public static javax.swing.JCheckBox checkBoxT2;
    public static javax.swing.JCheckBox checkBoxT3;
    public static javax.swing.JCheckBox checkBoxT4;
    public static javax.swing.JCheckBox checkBoxT5;
    public static javax.swing.JCheckBox checkBoxT6;
    public static javax.swing.JCheckBox chekBoxt1;
    private javax.swing.JComboBox comboBoxOldFarmList;
    public static javax.swing.JLabel fighter1;
    public static javax.swing.JLabel fighter2;
    public static javax.swing.JLabel fighter3;
    public static javax.swing.JLabel fighter4;
    public static javax.swing.JLabel fighter5;
    public static javax.swing.JLabel fighter6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField textFieldFarmListName;
    private javax.swing.JLabel villylabel;
    // End of variables declaration//GEN-END:variables
}
