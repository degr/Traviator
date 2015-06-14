package traviator42.gui.search;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import traviator42.threads.MainCopyStatus;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

//</editor-fold>

//</editor-fold>
public class Search extends javax.swing.JDialog {

    public static int dist, a = 0, b = 0, n = 0, m = 0;
    public static DefaultTableModel searchModel = new DefaultTableModel();
    /*X-Y-details*/

    public Search(java.awt.Frame parent, boolean modal) {
        super(parent, MainWindow.messages[83][MainWindow.language], true);
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        initComponents();

        for (int i = 0; i < MainWindow.vilList.size(); i++) {
            comboBoxVillageName.addItem(MainWindow.vilList.get(i).name);
        }

//        checkBoxIncludeAlly.setText(MainWindow.messages[97][MainWindow.language]);
        jLabel1.setText(MainWindow.messages[98][MainWindow.language]);
        jLabel2.setText(MainWindow.messages[99][MainWindow.language]);
        jLabel3.setText(MainWindow.messages[100][MainWindow.language]);
        jLabel4.setText(MainWindow.messages[101][MainWindow.language]);
        jLabel5.setText(MainWindow.messages[102][MainWindow.language]);
        buttonStartSearch.setText(MainWindow.messages[103][MainWindow.language]);
        Dimension dim = new Dimension(60, 32);
        textFieldMaxDist.setPreferredSize(dim);
        textFieldMinDist.setPreferredSize(dim);
        textFieldMaxPlayerPop.setPreferredSize(dim);
        textFieldMinPlayerPop.setPreferredSize(dim);
        checkBoxSearchVillages.doClick();
        checkBoxOase.doClick();

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

        jPanel9 = new javax.swing.JPanel();
        checkBoxSearchVillages = new javax.swing.JCheckBox();
        checkBoxIncludeAlly = new javax.swing.JCheckBox();
        checkBoxNatars = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        checkBoxOase = new javax.swing.JCheckBox();
        checkBoxWithoutAnimals = new javax.swing.JCheckBox();
        checkBoxIncludeOcc = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        textFieldMaxPlayerPop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        textFieldMinPlayerPop = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        textFieldMaxDist = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        textFieldMinDist = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxVillageName = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        buttonStartSearch = new javax.swing.JButton(MainWindow.natiPic[4][25]);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        checkBoxSearchVillages.setText( MainWindow.messages[125][MainWindow.language]);
        checkBoxSearchVillages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSearchVillagesActionPerformed(evt);
            }
        });
        jPanel9.add(checkBoxSearchVillages);

        checkBoxIncludeAlly.setText(MainWindow.messages[97][MainWindow.language]);
        jPanel9.add(checkBoxIncludeAlly);

        checkBoxNatars.setText(MainWindow.messages[150][MainWindow.language]);
        jPanel9.add(checkBoxNatars);

        getContentPane().add(jPanel9);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        checkBoxOase.setText( MainWindow.messages[126][MainWindow.language]);
        checkBoxOase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxOaseActionPerformed(evt);
            }
        });
        jPanel1.add(checkBoxOase);

        checkBoxWithoutAnimals.setText(MainWindow.messages[259][MainWindow.language]);
        jPanel1.add(checkBoxWithoutAnimals);

        checkBoxIncludeOcc.setText( MainWindow.messages[127][MainWindow.language]);
        jPanel1.add(checkBoxIncludeOcc);

        getContentPane().add(jPanel1);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textFieldMaxPlayerPop.setText("150");
        jPanel6.add(textFieldMaxPlayerPop);

        jLabel2.setText("максимальное население игрока");
        jPanel6.add(jLabel2);

        getContentPane().add(jPanel6);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textFieldMinPlayerPop.setText("0");
        jPanel5.add(textFieldMinPlayerPop);

        jLabel1.setText("минимальное население игрока");
        jPanel5.add(jLabel1);

        getContentPane().add(jPanel5);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textFieldMaxDist.setText("30");
        jPanel7.add(textFieldMaxDist);

        jLabel3.setText("максимальное расстояние");
        jPanel7.add(jLabel3);

        getContentPane().add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textFieldMinDist.setText("0");
        jPanel8.add(textFieldMinDist);

        jLabel4.setText("минимальное расстояние");
        jPanel8.add(jLabel4);

        getContentPane().add(jPanel8);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setText("для деревни");
        jPanel4.add(jLabel5);

        comboBoxVillageName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxVillageNameActionPerformed(evt);
            }
        });
        jPanel4.add(comboBoxVillageName);

        getContentPane().add(jPanel4);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        buttonStartSearch.setText("Начать поиск");
        buttonStartSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartSearchActionPerformed(evt);
            }
        });
        jPanel3.add(buttonStartSearch);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStartSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartSearchActionPerformed

        dispose();
        String villy = comboBoxVillageName.getSelectedItem().toString();
        MainCopyStatus ddd = new MainCopyStatus(Traviator42.mainWindow, true, 1, 0, villy, false, new ArrayList<String>());
        ddd.setVisible(true);
    }//GEN-LAST:event_buttonStartSearchActionPerformed

    private void comboBoxVillageNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxVillageNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxVillageNameActionPerformed

    private void checkBoxSearchVillagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSearchVillagesActionPerformed
        if (checkBoxSearchVillages.isSelected() == true) {
            checkBoxIncludeAlly.setEnabled(true);
            checkBoxIncludeAlly.setSelected(false);
            textFieldMaxPlayerPop.setEnabled(true);
            textFieldMinPlayerPop.setEnabled(true);
            textFieldMaxPlayerPop.setText("150");
            textFieldMinPlayerPop.setText("0");
        } else {
            checkBoxIncludeAlly.setEnabled(false);
            checkBoxIncludeAlly.setSelected(false);
            textFieldMaxPlayerPop.setEnabled(false);
            textFieldMinPlayerPop.setEnabled(false);
            textFieldMaxPlayerPop.setText("150");
            textFieldMinPlayerPop.setText("0");

        }
    }//GEN-LAST:event_checkBoxSearchVillagesActionPerformed

    private void checkBoxOaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxOaseActionPerformed
        if (checkBoxOase.isSelected() == true) {
            checkBoxIncludeOcc.setEnabled(true);
            checkBoxWithoutAnimals.setEnabled(true);
            checkBoxIncludeOcc.setSelected(false);
            checkBoxWithoutAnimals.setSelected(true);
        } else {
            checkBoxIncludeOcc.setEnabled(false);
            checkBoxWithoutAnimals.setEnabled(false);
            checkBoxIncludeOcc.setSelected(false);
            checkBoxWithoutAnimals.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxOaseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStartSearch;
    public static javax.swing.JCheckBox checkBoxIncludeAlly;
    public static javax.swing.JCheckBox checkBoxIncludeOcc;
    public static javax.swing.JCheckBox checkBoxNatars;
    public static javax.swing.JCheckBox checkBoxOase;
    public static javax.swing.JCheckBox checkBoxSearchVillages;
    public static javax.swing.JCheckBox checkBoxWithoutAnimals;
    public static javax.swing.JComboBox comboBoxVillageName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField textFieldMaxDist;
    public static javax.swing.JTextField textFieldMaxPlayerPop;
    public static javax.swing.JTextField textFieldMinDist;
    public static javax.swing.JTextField textFieldMinPlayerPop;
    // End of variables declaration//GEN-END:variables
}

