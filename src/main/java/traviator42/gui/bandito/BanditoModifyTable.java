
package traviator42.gui.bandito;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;

import javax.swing.table.DefaultTableModel;

public class BanditoModifyTable extends javax.swing.JDialog {


    public BanditoModifyTable(java.awt.Frame parent, boolean modal) {
        super(parent, MainWindow.messages[123][MainWindow.language], modal);
        initComponents();
        
 //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
 //делаем чтобы приложение появилось в центре экрана
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 Dimension frameSize = getSize();
 setLocation(new Point((screenSize.width - frameSize.width) / 2,
 (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
 //</editor-fold>
 
 comboBoxVillageList.removeAllItems();
 for(int c = 0; c < MainWindow.vilList.size(); c++)
     comboBoxVillageList.addItem(MainWindow.vilList.get(c).name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaConsole = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        comboBoxVillageList = new javax.swing.JComboBox();
        buttonRecalculate = new javax.swing.JButton();
        buttonForVilly = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setText("close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        textAreaConsole.setColumns(20);
        textAreaConsole.setRows(5);
        jScrollPane2.setViewportView(textAreaConsole);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboBoxVillageList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonRecalculate.setText(MainWindow.messages[147][MainWindow.language]);
        buttonRecalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecalculateActionPerformed(evt);
            }
        });

        buttonForVilly.setText(MainWindow.messages[146][MainWindow.language]);
        buttonForVilly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonForVillyActionPerformed(evt);
            }
        });

        jButton6.setText(MainWindow.messages[108][MainWindow.language]);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("X");

        jLabel2.setText("Y");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboBoxVillageList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonForVilly))
                    .addComponent(buttonRecalculate)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxVillageList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonForVilly))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRecalculate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText(MainWindow.messages[130][MainWindow.language]);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText(MainWindow.messages[131][MainWindow.language]);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(MainWindow.messages[128][MainWindow.language]);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText(MainWindow.messages[129][MainWindow.language]);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText(MainWindow.messages[151][MainWindow.language]);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonForVillyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonForVillyActionPerformed
       int trc = MainWindow.banditoTable.getRowCount();
       while(trc>0){
           MainWindow.banditoTable.setValueAt(comboBoxVillageList.getSelectedItem().toString(), trc-1, 0
           );
           trc--;
       }
       textAreaConsole.append(MainWindow.messages[117][MainWindow.language]);
       textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
    }//GEN-LAST:event_buttonForVillyActionPerformed

    private void buttonRecalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecalculateActionPerformed
int rowCount = MainWindow.banditoTable.getRowCount();
boolean firstRow = true;
//цикл для перехода по строкам таблицы
    int nativeX = 0, nativeY = 0;
    int targetX = 0, targetY = 0;
for(int i = 0; i<rowCount; i++){
     if(i != 0)firstRow = false;
     //переходим в деру которая указана в первой строке
     //если дера во Х строке отличается от деры в Х-1 строке, то переходим туда 
     if(firstRow == false){
         if(!MainWindow.banditoTable.getValueAt(i-1, 0).toString().equals(
                 MainWindow.banditoTable.getValueAt(i, 0).toString())){
             villyChange(MainWindow.banditoTable.getValueAt(i, 0).toString());
             nativeX = nativeCoordX();
             nativeY = nativeCoordY();
         }
     }
     if(firstRow == true){
         villyChange(MainWindow.banditoTable.getValueAt(i, 0).toString());
         nativeX = nativeCoordX();
         nativeY = nativeCoordY();
         firstRow = false;
         
     }
     String target;
     if(MainWindow.banditoTable.getModel() == MainWindow.banditoModel)
          target = MainWindow.banditoTable.getValueAt(i, 3).toString();
     else
          target = MainWindow.banditoTable.getValueAt(i, 4).toString();
     targetX = Integer.valueOf(target.substring(0, target.indexOf("/")));
     targetY = Integer.valueOf(target.substring(target.indexOf("/")+1));
     
     int dist = calculate(nativeX, nativeY, targetX, targetY);
     MainWindow.banditoTable.setValueAt(dist, i, 4);
     
}
textAreaConsole.append(MainWindow.messages[118][MainWindow.language]);
       textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
    }//GEN-LAST:event_buttonRecalculateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//       оазисы вверх
          int limit =  MainWindow.banditoTable.getRowCount();
        for(int j = 0; j < limit; j++){
          String type = MainWindow.banditoTable.getValueAt(j, 1).toString();
          if(type.indexOf("oasis") < 0){
              Object row[];
              if(MainWindow.banditoTable.getModel() == MainWindow.banditoModel)
                    row = new Object[]{
                        MainWindow.banditoTable.getValueAt(j, 0),
                        MainWindow.banditoTable.getValueAt(j, 1),
                        MainWindow.banditoTable.getValueAt(j, 2),
                        MainWindow.banditoTable.getValueAt(j, 3)
                    };
              else
                    row = new Object[]{
                        MainWindow.banditoTable.getValueAt(j, 0),
                        MainWindow.banditoTable.getValueAt(j, 1),
                        MainWindow.banditoTable.getValueAt(j, 2),
                        MainWindow.banditoTable.getValueAt(j, 3),
                        MainWindow.banditoTable.getValueAt(j, 4),
                        MainWindow.banditoTable.getValueAt(j, 5),
                        MainWindow.banditoTable.getValueAt(j, 6)
                    };
              
              ((DefaultTableModel) MainWindow.banditoTable.getModel()).removeRow(j);
              ((DefaultTableModel) MainWindow.banditoTable.getModel()).addRow(row);
              j--;
              limit--;
          }
        }
        textAreaConsole.append(MainWindow.messages[152][MainWindow.language]+ "\n");
  textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//       деры вверх
        int limit =  MainWindow.banditoTable.getRowCount();
        for(int j = 0; j < limit; j++){
          String type = MainWindow.banditoTable.getValueAt(j, 1).toString();
          if(type.indexOf("oasis") > 0){
              Object row[];
              if(MainWindow.banditoTable.getModel() == MainWindow.banditoModel)
                    row = new Object[]{
                        MainWindow.banditoTable.getValueAt(j, 0),
                        MainWindow.banditoTable.getValueAt(j, 1),
                        MainWindow.banditoTable.getValueAt(j, 2),
                        MainWindow.banditoTable.getValueAt(j, 3)
                    };
              else
                    row = new Object[]{
                        MainWindow.banditoTable.getValueAt(j, 0),
                        MainWindow.banditoTable.getValueAt(j, 1),
                        MainWindow.banditoTable.getValueAt(j, 2),
                        MainWindow.banditoTable.getValueAt(j, 3),
                        MainWindow.banditoTable.getValueAt(j, 4),
                        MainWindow.banditoTable.getValueAt(j, 5),
                        MainWindow.banditoTable.getValueAt(j, 6)
                    };
              
              ((DefaultTableModel) MainWindow.banditoTable.getModel()).removeRow(j);
              ((DefaultTableModel) MainWindow.banditoTable.getModel()).addRow(row);
              j--;
              limit--;
          }
        }
         textAreaConsole.append(MainWindow.messages[152][MainWindow.language]+ "\n");
  textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//     удалить оазы
           Object[] options = { MainWindow.messages[130][MainWindow.language], MainWindow.messages[71][MainWindow.language] };
				int n = JOptionPane
						.showOptionDialog(this, MainWindow.messages[133][MainWindow.language],
								MainWindow.messages[132][MainWindow.language], 
                                                                JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);
            if (n == 0) 
            for(int i = MainWindow.banditoTable.getRowCount()-1; i >= 0; i--){
                String type =  MainWindow.banditoTable.getValueAt(i, 1).toString();
                if(type.indexOf("oasis") > -1)
                    MainWindow.banditoModel.removeRow(i);
            }
            textAreaConsole.append(MainWindow.messages[136][MainWindow.language]);
       textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//     удалить деры
        Object[] options = { MainWindow.messages[131][MainWindow.language], MainWindow.messages[71][MainWindow.language] };
	int n = JOptionPane
			.showOptionDialog(this, MainWindow.messages[133][MainWindow.language],
					MainWindow.messages[132][MainWindow.language], 
                                                             JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options,
					options[0]);
	if (n == 0) 
            for(int i = MainWindow.banditoTable.getRowCount()-1; i >= 0; i--){
                String type =  MainWindow.banditoTable.getValueAt(i, 1).toString();
                if(type.indexOf("oasis") == -1)
                    MainWindow.banditoModel.removeRow(i);
            }
        textAreaConsole.append(MainWindow.messages[137][MainWindow.language]);
       textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    
        if(!"".equals(jTextField1.getText()) && !"".equals(jTextField2.getText())){
String tarX = jTextField1.getText(), tarY = jTextField2.getText();
            //<editor-fold defaultstate="collapsed" desc="координаты родной деры">
            MainWindow.villageChange(comboBoxVillageList.getSelectedItem().toString(), "karte.php", "");
                int VillageX = Integer.valueOf(MainWindow.driver.findElement
                    (By.xpath("//div[@class='ruler x']/div[@ class = 'rulerContainer']/div[5]")).getText());
                int VillageY = Integer.valueOf(MainWindow.driver.findElement
                    (By.xpath("//div[@class='ruler y']/div[@ class = 'rulerContainer']/div[4]")).getText());
            //</editor-fold>
            String dist = String.valueOf(MainWindow.dist(VillageX, VillageY, 
                    Integer.valueOf(tarX), Integer.valueOf(tarY)));
            
try{
       MainWindow.driver.navigate().to(MainWindow.server+"position_details.php?x="+tarX+"&y="+tarY);
       
       String owner = xpathException("//*[@id='village_info']/tbody/tr[3]/td/a", "---");
       String ally = xpathException("//*[@id='village_info']/tbody/tr[2]/td/a", "---");
       String to =  MainWindow.driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
       String population = xpathException("//*[@id='village_info']/tbody/tr[4]/td", "0");
       
      MainWindow.banditoModel.addRow(new Object[]{
                    comboBoxVillageList.getSelectedItem().toString(),
                    owner + " / " + to + " / " + ally,
                    dist + " / " + population, 
                    jTextField1.getText() + "/" + jTextField2.getText()
                });
      int pop = 0;
      if(!"---".equals(population))
           pop = Integer.valueOf(population);
      String units = "";
      for (int t = 0; t < 6; t++) {
          if (pop >= MainWindow.popBorder[t][0] && pop < MainWindow.popBorder[t][1]) {
              units = String.valueOf(MainWindow.interval[t]);
              break;
          }
      }
      String time = "00:00:05";
        if(MainWindow.banditoListModelE.getRowCount()>0){
            time = MainWindow.banditoListModelE.getValueAt(MainWindow.banditoListModelE.getRowCount()-1, 5).toString();
            time = MainWindow.setTimer(MainWindow.input(time)+(MainWindow.rand.nextInt(5)+3));
        }
      MainWindow.banditoListModelE.addRow(new Object[]{
          comboBoxVillageList.getSelectedItem().toString(),
          owner + " / " + to + " / " + ally,
          units,
          dist + " / " + population,
          jTextField1.getText() + "/" + jTextField2.getText(),
          time,
          MainWindow.raidInterval
      }); 
      textAreaConsole.append(MainWindow.messages[340][MainWindow.language]);
       textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
      
    }catch(org.openqa.selenium.NoSuchElementException ex){
    }catch(org.openqa.selenium.remote.UnreachableBrowserException ex){
    }
    }
   
   
      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    if(MainWindow.banditoTable.getModel() == MainWindow.banditoModel)
        sortcol(2);
    else
        sortcol(3);
    }//GEN-LAST:event_jButton7ActionPerformed
   String xpathException(String xpath, String exception){
       String value;
       try{
           value = MainWindow.driver.findElement(By.xpath(xpath)).getText();
       }catch(org.openqa.selenium.NoSuchElementException ex){
           value = exception;
       }
       return value;
   }
    void sortcol(int col){
        ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
        
        for(int k = MainWindow.banditoTable.getRowCount()-1; k >= 0; k--){
            ArrayList<String> row = new ArrayList<String>();
            for(int j = 0; j < MainWindow.banditoTable.getColumnCount(); j++){
                row.add(MainWindow.banditoTable.getValueAt(k, j).toString());
            }
            table.add(row);
        }
        
 while(((DefaultTableModel)MainWindow.banditoTable.getModel()).getRowCount()> 0)
    ((DefaultTableModel)MainWindow.banditoTable.getModel()).removeRow(0);
  
 //<editor-fold defaultstate="collapsed" desc="добавляем первую строку">
 if(MainWindow.banditoTable.getModel() == MainWindow.banditoModel)
     ((DefaultTableModel)MainWindow.banditoTable.getModel()).addRow(
             new Object[]{
                 table.get(0).get(0),
                 table.get(0).get(1),
                 table.get(0).get(2),
                 table.get(0).get(3)
             });
 else
     ((DefaultTableModel)MainWindow.banditoTable.getModel()).addRow(
             new Object[]{
                 table.get(0).get(0),
                 table.get(0).get(1),
                 table.get(0).get(2),
                 table.get(0).get(3),
                 table.get(0).get(4),
                 table.get(0).get(5),
                 table.get(0).get(6)
             });
 //</editor-fold>
  for(int i = 1; i < table.size(); i++){
      int value = value(table, i, col);
          if(value(MainWindow.banditoTable.getValueAt(0, col).toString()) > value)
            addrow(table, i,  0);
          else{  
             int rc = MainWindow.banditoTable.getRowCount();
             
             for(int g = rc-1; g >= 0; g--){
                if(value(MainWindow.banditoTable.getValueAt(g, col).toString()) <= value){
                   addrow(table, i,  g+1);
                   break;
                }
             }  
          }
  }
  textAreaConsole.append(MainWindow.messages[152][MainWindow.language]+ "\n");
  textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
 
    }
    
    int value(ArrayList<ArrayList<String>> table, int i, int col){
        return value(table.get(i).get(col));
    }
    
    int value(String val){
       int value = Integer.valueOf(val.substring(0, val.indexOf(" / ")));
       return value;
    }
    
    
    void addrow(ArrayList<ArrayList<String>> table, int row, int rowT){
        if(MainWindow.banditoTable.getModel() == MainWindow.banditoModel)
         MainWindow.banditoModel.insertRow( rowT, new Object[]{
             table.get(row).get(0),
             table.get(row).get(1),
             table.get(row).get(2),
             table.get(row).get(3)
         });
        else
        MainWindow.banditoListModelE.insertRow( rowT, new Object[]{
             table.get(row).get(0),
             table.get(row).get(1),
             table.get(row).get(2),
             table.get(row).get(3),
             table.get(row).get(4),
             table.get(row).get(5),
             table.get(row).get(6),
        });
    }
    void sort(JTable table){
        ArrayList<ArrayList<String>> tableData = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < table.getRowCount(); i++){
            ArrayList<String> data = new ArrayList<String>();
            for(int j = 0; j<table.getColumnCount(); j++)
                data.add(table.getValueAt(i, j).toString());
        }
    }
    
    public void villyChange(String villyName){
    boolean breakK = false;
     for(int i = 0; i < MainWindow.vilList.size() && breakK == false; i++){
        if(villyName.equals(MainWindow.vilList.get(i).name)){
            MainWindow.driver.navigate().to(MainWindow.vilList.get(i).url);  
            breakK = true;
        }
}
}

public int nativeCoordX(){
    MainWindow.driver.navigate().to(MainWindow.server + "karte.php");
    int x = Integer.valueOf(MainWindow.driver.findElement(By.xpath("//div[@ class = 'ruler x']/div[@ class = 'rulerContainer']/div[5]")).getText());
    return x;
}
public int nativeCoordY(){
    int y = Integer.valueOf(MainWindow.driver.findElement(By.xpath("//div[@ class = 'ruler y']/div[@ class = 'rulerContainer']/div[4]")).getText());
    return y;
}
public int calculate(int natX,int natY,int tarX,int tarY){
//                   рассчитываем расстояние
                   double moduleX = natX - tarX,
                          moduleY = natY - tarY;
//                   если расстояние больше чем 401, то идем по карте вокруг, и персчитываем расстояние
                   if(moduleX > 401 || moduleX < -401){
                       moduleX = 401 - Math.sqrt(Math.pow((double)(natX), 2)) + 401 - Math.sqrt(Math.pow((double)(tarX), 2));
                   }
                   if(moduleY > 401 || moduleY < -401){
                       moduleY = 401 - Math.sqrt(Math.pow((double)(natY), 2)) + 401 - Math.sqrt(Math.pow((double)(tarY), 2));
                   }
//                   рассчитываем искомую гипотенузу
                   int calculation = (int)Math.sqrt(Math.pow(moduleX, 2) + Math.pow(moduleY, 2));
    
    return calculation;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonForVilly;
    private javax.swing.JButton buttonRecalculate;
    private javax.swing.JComboBox comboBoxVillageList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextArea textAreaConsole;
    // End of variables declaration//GEN-END:variables
}
