package traviator42.gui.attack;

import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

import java.awt.*;
import javax.swing.*;

public class Attack2Troops extends javax.swing.JDialog {
    int waveTotal;
 int waveCurrent;

    public Attack2Troops(java.awt.Frame parent, boolean modal, int waveTotal, int waveCurrent) {
        super(parent, MainWindow.messages[318][MainWindow.language], modal);
        Dimension spinDimension = new Dimension(100, 30);
        Dimension picDimension = new Dimension(30, 30);
        this.waveTotal = waveTotal;
        this.waveCurrent = waveCurrent+1;
        initComponents();
        buttonCancel.setText(MainWindow.messages[71][MainWindow.language]);
        IconCreater();
        
        this.setTitle(this.getTitle() + waveCurrent);
        
            buttonOk.setIcon(MainWindow.natiPic[4][25]);
            jLabel2.setText(MainWindow.messages[319][MainWindow.language]);
        jRadioButton2.doClick();
        jRadioButton1.setText(MainWindow.messages[39][MainWindow.language]);
        jRadioButton2.setText(MainWindow.messages[40][MainWindow.language]);
        jRadioButton3.setText(MainWindow.messages[41][MainWindow.language]);
        
        //<editor-fold defaultstate="collapsed" desc="устновка моделей">
        SpinnerModel sm1 = new SpinnerNumberModel(5000, 0, 999999999, 500);
        jSpinner1.setModel(sm1);
        SpinnerModel sm2 = new SpinnerNumberModel(5000, 0, 999999999, 500);
        jSpinner2.setModel(sm2);
        SpinnerModel sm3 = new SpinnerNumberModel(5000, 0, 999999999, 500);
        jSpinner3.setModel(sm3);
        SpinnerModel sm4 = new SpinnerNumberModel(2500, 0, 999999999, 250);
        jSpinner4.setModel(sm4);
        SpinnerModel sm5 = new SpinnerNumberModel(2500, 0, 999999999, 250);
        jSpinner5.setModel(sm5);
        SpinnerModel sm6 = new SpinnerNumberModel(2500, 0, 999999999, 250);
        jSpinner6.setModel(sm6);
        SpinnerModel sm7 = new SpinnerNumberModel(40, 0, 999999999, 10);
        jSpinner7.setModel(sm7);
        SpinnerModel sm8 = new SpinnerNumberModel(40, 0, 999999999, 10);
        jSpinner8.setModel(sm8);
        SpinnerModel sm9 = new SpinnerNumberModel(0, 0, 3, 1);
        jSpinner9.setModel(sm9);
        SpinnerModel sm10 = new SpinnerNumberModel(0, 0, 3, 1);
        jSpinner10.setModel(sm10);
        SpinnerModel sm11 = new SpinnerNumberModel(0, 0, 1, 1);
        jSpinner11.setModel(sm11);
        SpinnerModel sm12 = new SpinnerNumberModel(2, 0, 2, 1);
        jSpinner12.setModel(sm12);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="утановка размеров">
        jSpinner1.setPreferredSize(spinDimension);
        jSpinner2.setPreferredSize(spinDimension);
        jSpinner3.setPreferredSize(spinDimension);
        jSpinner4.setPreferredSize(spinDimension);
        jSpinner5.setPreferredSize(spinDimension);
        jSpinner6.setPreferredSize(spinDimension);
        jSpinner7.setPreferredSize(spinDimension);
        jSpinner8.setPreferredSize(spinDimension);
        jSpinner9.setPreferredSize(spinDimension);
        jSpinner10.setPreferredSize(spinDimension);
        jSpinner11.setPreferredSize(spinDimension);
        fighter1.setPreferredSize(picDimension);
        fighter2.setPreferredSize(picDimension);
        fighter3.setPreferredSize(picDimension);
        fighter4.setPreferredSize(picDimension);
        fighter5.setPreferredSize(picDimension);
        fighter6.setPreferredSize(picDimension);
        fighter7.setPreferredSize(picDimension);
        fighter8.setPreferredSize(picDimension);
        fighter9.setPreferredSize(picDimension);
        fighter10.setPreferredSize(picDimension);
        fighter11.setPreferredSize(picDimension);
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="установка значений">
        if(MainWindow.tribe==0){
            sm1.setValue(0);
            sm2.setValue(0);
            sm4.setValue(0);
            sm9.setValue(0);
            sm10.setValue(0);
            if(waveCurrent == 1){
                sm3.setValue(5000);
                sm5.setValue(1000);
                sm6.setValue(1000);
                sm7.setValue(100);
                sm8.setValue(40);
            }else{
                sm3.setValue(50);
                sm5.setValue(1);
                sm6.setValue(1);
                sm7.setValue(0);
                sm8.setValue(40);
            }
        }
        if(MainWindow.tribe==1){
            sm2.setValue(0);
            sm4.setValue(0);
            sm5.setValue(0);
            sm9.setValue(0);
            sm10.setValue(0);
            if(waveCurrent == 1){
                sm1.setValue(5000);
                sm3.setValue(3000);
                sm6.setValue(1500);
                sm7.setValue(100);
                sm8.setValue(40);
            }else{
                sm1.setValue(100);
                sm3.setValue(1);
                sm6.setValue(1);
                sm7.setValue(0);
                sm8.setValue(40);
            }
        }
        if(MainWindow.tribe==2){
            sm1.setValue(0);
            sm3.setValue(0);
            sm5.setValue(0);
            sm9.setValue(0);
            sm10.setValue(0);
            if(waveCurrent == 1){
                sm2.setValue(5000);
                sm4.setValue(1000);
                sm6.setValue(1000);
                sm7.setValue(100);
                sm8.setValue(40);
            }else{
                sm2.setValue(70);
                sm4.setValue(1);
                sm6.setValue(1);
                sm7.setValue(0);
                sm8.setValue(40);
            }
        }
        if(waveCurrent == 1){
            sm11.setValue(1);
        }
        //</editor-fold>
        
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
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        fighter1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        fighter4 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        fighter7 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jPanel9 = new javax.swing.JPanel();
        fighter9 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jPanel13 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fighter2 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        fighter5 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        fighter8 = new javax.swing.JLabel();
        jSpinner8 = new javax.swing.JSpinner();
        jPanel10 = new javax.swing.JPanel();
        fighter10 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        jPanel14 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        fighter3 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        fighter6 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        fighter11 = new javax.swing.JLabel();
        jSpinner11 = new javax.swing.JSpinner();
        jPanel19 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner12 = new javax.swing.JSpinner();
        jPanel16 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel18 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        buttonCancel = new javax.swing.JButton(MainWindow.natiPic[4][14]);
        buttonOk = new javax.swing.JButton();

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 400));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 5));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel1.add(fighter1);
        jPanel1.add(jSpinner1);

        jPanel12.add(jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel4.add(fighter4);
        jPanel4.add(jSpinner4);

        jPanel12.add(jPanel4);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel7.add(fighter7);
        jPanel7.add(jSpinner7);

        jPanel12.add(jPanel7);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel9.add(fighter9);
        jPanel9.add(jSpinner9);

        jPanel12.add(jPanel9);

        getContentPane().add(jPanel12);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 5));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel2.add(fighter2);
        jPanel2.add(jSpinner2);

        jPanel13.add(jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel5.add(fighter5);
        jPanel5.add(jSpinner5);

        jPanel13.add(jPanel5);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel8.add(fighter8);
        jPanel8.add(jSpinner8);

        jPanel13.add(jPanel8);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel10.add(fighter10);
        jPanel10.add(jSpinner10);

        jPanel13.add(jPanel10);

        getContentPane().add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 5));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel3.add(fighter3);
        jPanel3.add(jSpinner3);

        jPanel14.add(jPanel3);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel6.add(fighter6);
        jPanel6.add(jSpinner6);

        jPanel14.add(jPanel6);

        jLabel1.setPreferredSize(new java.awt.Dimension(134, 14));
        jPanel14.add(jLabel1);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        jPanel11.add(fighter11);
        jPanel11.add(jSpinner11);

        jPanel14.add(jPanel11);

        getContentPane().add(jPanel14);

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel19.setPreferredSize(new java.awt.Dimension(130, 40));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setText("jLabel2");
        jPanel19.add(jLabel2);
        jPanel19.add(jSpinner12);

        getContentPane().add(jPanel19);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 2);
        flowLayout1.setAlignOnBaseline(true);
        jPanel16.setLayout(flowLayout1);

        jRadioButton1.setText("jRadioButton1");
        jPanel16.add(jRadioButton1);

        getContentPane().add(jPanel16);

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 2));

        jRadioButton2.setText("jRadioButton2");
        jPanel17.add(jRadioButton2);

        getContentPane().add(jPanel17);

        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 2));

        jRadioButton3.setText("jRadioButton3");
        jPanel18.add(jRadioButton3);

        getContentPane().add(jPanel18);

        buttonCancel.setText("Отмена");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });
        jPanel15.add(buttonCancel);

        buttonOk.setText("Ок");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });
        jPanel15.add(buttonOk);

        getContentPane().add(jPanel15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
         setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        String id = MainWindow.futureRow[0] + "." + (waveCurrent - 1);
        
        //деревня
        JComboBox village = new JComboBox();
        int i = 0;
        for(i = 0; i < MainWindow.vilList.size(); i++)
            village.addItem(MainWindow.vilList.get(i).name);
        village.setSelectedItem(MainWindow.futureRow[1]);
        //юниты
        i = 0;
        JPanel units = new JPanel();
        
        
        //<editor-fold defaultstate="collapsed" desc="запись в строку всех юнитов">
            unitsPanel(jSpinner1, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
            
            unitsPanel(jSpinner2, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner3, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner4, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner5, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner6, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner7, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner8, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner9, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner10, units, MainWindow.natiPic[MainWindow.tribe][i]);
            i++;
        
            unitsPanel(jSpinner11, units, MainWindow.natiPic[3][0]);
            i=1;
        //</editor-fold>
            
        units.setLayout(new BoxLayout(units, BoxLayout.Y_AXIS));
        units.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //тип атаки
        JComboBox type = new JComboBox();
        type.addItem("reinf");
        type.addItem("normal");
        type.addItem("raid");
        if(jRadioButton1.isSelected()==true)
            i = 0;
        if(jRadioButton2.isSelected()==true)
            i = 1;
        if(jRadioButton1.isSelected()==true)
            i = 2;
        type.setSelectedIndex(i);
        
        //координаты атаки
        String X = MainWindow.futureRow[4].substring(0, MainWindow.futureRow[4].indexOf("/"));
        String Y = MainWindow.futureRow[4].substring(MainWindow.futureRow[4].indexOf("/") + 1);
        JTextField XF = new JTextField(X);
        JTextField YF = new JTextField(Y);
        XF.setPreferredSize(new Dimension(40, 25));
        YF.setPreferredSize(new Dimension(40, 25));
        
        
        //время атаки это futureRow[5]
        int rowNumber = rowNumber(MainWindow.attackPanel, MainWindow.futureRow[5]);
        
        JPanel rowPanel = new JPanel(new BorderLayout());
        JPanel left = new JPanel();
        left.setLayout(new FlowLayout(SwingConstants.CENTER));
         
        left.add(new JLabel(id));
        left.add(village);
        left.add(type);
        left.add(new JLabel("X : "));
        left.add(XF);
        left.add(new JLabel("Y : "));
        left.add(YF);
        left.add(new JLabel(MainWindow.natiPic[4][20]));
        JTextField time = new JTextField(MainWindow.futureRow[5]);
        time.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        left.add(time);
        
        rowPanel.add(left, BorderLayout.NORTH);
        rowPanel.add(units, BorderLayout.CENTER);
        
        if(waveCurrent != 2){
            for(int k = 1; k < left.getComponentCount(); k++){
                left.getComponent(k).setVisible(false);
            }
        }
        
        rowPanel.setPreferredSize(new Dimension(MainWindow.attackPanel.getWidth(), 150));
        rowPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MainWindow.attackPanel.add(rowPanel, rowNumber);
        MainWindow.jsp.revalidate();
        MainWindow.attackPanel.revalidate();
        
       
        if(waveTotal >= waveCurrent){
            Attack2Troops a2t = new Attack2Troops(Traviator42.mainWindow, true, waveTotal, waveCurrent);
            a2t.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_buttonOkActionPerformed
  public static void IconCreater(){
        fighter1.setIcon(MainWindow.natiPic[MainWindow.tribe][0]);
        fighter2.setIcon(MainWindow.natiPic[MainWindow.tribe][1]);
        fighter3.setIcon(MainWindow.natiPic[MainWindow.tribe][2]);
        fighter4.setIcon(MainWindow.natiPic[MainWindow.tribe][3]);
        fighter5.setIcon(MainWindow.natiPic[MainWindow.tribe][4]);
        fighter6.setIcon(MainWindow.natiPic[MainWindow.tribe][5]);
        fighter7.setIcon(MainWindow.natiPic[MainWindow.tribe][6]);
        fighter8.setIcon(MainWindow.natiPic[MainWindow.tribe][7]);
        fighter9.setIcon(MainWindow.natiPic[MainWindow.tribe][8]);
        fighter10.setIcon(MainWindow.natiPic[MainWindow.tribe][9]);
        fighter11.setIcon(MainWindow.natiPic[3][0]);
        
       }
 
  void unitsPanel(JSpinner spinner, JPanel panel, ImageIcon icon){
      
      JLabel lab = new JLabel(" : ", icon, SwingConstants.CENTER);
      if(panel.getComponentCount() > 0){
          if(panel.getComponent(panel.getComponentCount() - 1) instanceof JPanel){
              JPanel pan = (JPanel)panel.getComponent(panel.getComponentCount() - 1);
              String text = " : " + spinner.getValue().toString();
              if(spinner == jSpinner8)text += jSpinner12.getValue().toString();
              if(pan.getComponentCount() < 7){
                  pan.add(lab);
                  pan.add(spinner);
                  panel.add(pan);
              }else{
                  JPanel pan1 = new JPanel(new FlowLayout(SwingConstants.CENTER));
                  pan1.add(lab);
                  pan1.add(spinner);
                  panel.add(pan1);
              }
          }else{
              JPanel pan1 = new JPanel(new FlowLayout(SwingConstants.CENTER));
              pan1.add(lab);
              pan1.add(spinner);
              panel.add(pan1);
          }
      }else{
              JPanel pan1 = new JPanel(new FlowLayout(SwingConstants.CENTER));
              pan1.add(lab);
              pan1.add(spinner);
              panel.add(pan1);
      }
      if(spinner == jSpinner8){
          JPanel pan = (JPanel) panel.getComponent(panel.getComponentCount()-1);
          pan.add(jSpinner12);
      }
  }

  
   public static int rowNumber(JPanel comp, String inputTime){
      int value = 0;
      int rows = comp.getComponentCount();
      int RowTop;
      boolean stop = false;
//     если в таблице есть строки то
      int compareRow = MainWindow.input(inputTime);
      
      if(rows != 0){
        
          for(int i = 0; i < rows && stop == false; i++){
              
                JPanel pan = (JPanel)MainWindow.attackPanel.getComponent(i);
                JPanel pan1 = (JPanel)pan.getComponent(0);
                
                JTextField lab = (JTextField)(pan1.getComponent(8));
                RowTop = MainWindow.input(lab.getText());
                if(compareRow < RowTop){
                    value = i;
                    stop = true;
                }else{value = i + 1;}
          }            
      }    
        return value;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton buttonCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JButton buttonOk;
    public static javax.swing.JLabel fighter1;
    public static javax.swing.JLabel fighter10;
    public static javax.swing.JLabel fighter11;
    public static javax.swing.JLabel fighter2;
    public static javax.swing.JLabel fighter3;
    public static javax.swing.JLabel fighter4;
    public static javax.swing.JLabel fighter5;
    public static javax.swing.JLabel fighter6;
    public static javax.swing.JLabel fighter7;
    public static javax.swing.JLabel fighter8;
    public static javax.swing.JLabel fighter9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    // End of variables declaration//GEN-END:variables
}
