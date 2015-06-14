/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.architector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

/**
 *
 * @author Ror
 */
public class Architector3Villy extends javax.swing.JDialog {
    /**
     * Creates new form villageName
     */
    public Architector3Villy(java.awt.Frame parent, boolean modal) {
        super(parent, MainWindow.messages[185][MainWindow.language], modal);
        initComponents();
        jButton2.setText(MainWindow.messages[106][MainWindow.language]);
        jButton3.setText(MainWindow.messages[228][MainWindow.language]);
 //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
 //делаем чтобы приложение появилось в центре экрана
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 Dimension frameSize = getSize();
 setLocation(new Point((screenSize.width - frameSize.width) / 2,
 (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
 //</editor-fold>
 labelNames();
       constrRefresh();
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton(MainWindow.natiPic[4][25]);
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        id40 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        id20 = new javax.swing.JLabel();
        id21 = new javax.swing.JLabel();
        id22 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        id36 = new javax.swing.JLabel();
        id33 = new javax.swing.JLabel();
        id23 = new javax.swing.JLabel();
        id25 = new javax.swing.JLabel();
        id29 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        id19 = new javax.swing.JLabel();
        id24 = new javax.swing.JLabel();
        id27 = new javax.swing.JLabel();
        id28 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        id34 = new javax.swing.JLabel();
        id35 = new javax.swing.JLabel();
        id37 = new javax.swing.JLabel();
        id38 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        id39 = new javax.swing.JLabel();
        id26 = new javax.swing.JLabel();
        id30 = new javax.swing.JLabel();
        id31 = new javax.swing.JLabel();
        id32 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton(MainWindow.natiPic[4][21]);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id40.setText("jLabel1");
        id40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id40MouseClicked(evt);
            }
        });
        jPanel12.add(id40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id20.setText("jLabel1");
        id20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id20MouseClicked(evt);
            }
        });
        jPanel9.add(id20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 29));

        id21.setText("jLabel1");
        id21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id21MouseClicked(evt);
            }
        });
        jPanel9.add(id21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 29));

        id22.setText("jLabel1");
        id22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id22MouseClicked(evt);
            }
        });
        jPanel9.add(id22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 29));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id36.setText("jLabel1");
        id36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id36MouseClicked(evt);
            }
        });
        jPanel10.add(id36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 29));

        id33.setText("jLabel1");
        id33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id33MouseClicked(evt);
            }
        });
        jPanel10.add(id33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 29));

        id23.setText("jLabel1");
        id23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id23MouseClicked(evt);
            }
        });
        jPanel10.add(id23, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 29));

        id25.setText("jLabel1");
        id25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id25MouseClicked(evt);
            }
        });
        jPanel10.add(id25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 29));

        id29.setText("jLabel1");
        id29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id29MouseClicked(evt);
            }
        });
        jPanel10.add(id29, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 83, -1, 29));

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id19.setText("jLabel1");
        id19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id19MouseClicked(evt);
            }
        });
        jPanel11.add(id19, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, -1, 29));

        id24.setText("jLabel1");
        id24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id24MouseClicked(evt);
            }
        });
        jPanel11.add(id24, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, -1, 29));

        id27.setText("jLabel1");
        id27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id27MouseClicked(evt);
            }
        });
        jPanel11.add(id27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 29));

        id28.setText("jLabel1");
        id28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id28MouseClicked(evt);
            }
        });
        jPanel11.add(id28, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 107, -1, 29));

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id34.setText("jLabel1");
        id34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id34MouseClicked(evt);
            }
        });
        jPanel13.add(id34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 29));

        id35.setText("jLabel1");
        id35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id35MouseClicked(evt);
            }
        });
        jPanel13.add(id35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 29));

        id37.setText("jLabel1");
        id37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id37MouseClicked(evt);
            }
        });
        jPanel13.add(id37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 29));

        id38.setText("jLabel1");
        id38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id38MouseClicked(evt);
            }
        });
        jPanel13.add(id38, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, 29));

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id39.setText("jLabel1");
        id39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id39MouseClicked(evt);
            }
        });
        jPanel14.add(id39, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 40, 70));

        id26.setText("jLabel1");
        id26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id26MouseClicked(evt);
            }
        });
        jPanel14.add(id26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 29));

        id30.setText("jLabel1");
        id30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id30MouseClicked(evt);
            }
        });
        jPanel14.add(id30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 29));

        id31.setText("jLabel1");
        id31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id31MouseClicked(evt);
            }
        });
        jPanel14.add(id31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 29));

        id32.setText("jLabel1");
        id32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id32MouseClicked(evt);
            }
        });
        jPanel14.add(id32, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 29));

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(8, 8, 8)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void id40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id40MouseClicked
        constr(id40);
    }//GEN-LAST:event_id40MouseClicked

    private void id20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id20MouseClicked
        constr(id20);
    }//GEN-LAST:event_id20MouseClicked

    private void id21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id21MouseClicked
        constr(id21);
    }//GEN-LAST:event_id21MouseClicked

    private void id22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id22MouseClicked
        constr(id22);
    }//GEN-LAST:event_id22MouseClicked

    private void id36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id36MouseClicked
        constr(id36);
    }//GEN-LAST:event_id36MouseClicked

    private void id33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id33MouseClicked
        constr(id33);
    }//GEN-LAST:event_id33MouseClicked

    private void id23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id23MouseClicked
        constr(id23);
    }//GEN-LAST:event_id23MouseClicked

    private void id25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id25MouseClicked
        constr(id25);
    }//GEN-LAST:event_id25MouseClicked

    private void id29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id29MouseClicked
       constr(id29);
    }//GEN-LAST:event_id29MouseClicked

    private void id19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id19MouseClicked
        constr(id19);
    }//GEN-LAST:event_id19MouseClicked

    private void id24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id24MouseClicked
        constr(id24);
    }//GEN-LAST:event_id24MouseClicked

    private void id27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id27MouseClicked
        constr(id27);
    }//GEN-LAST:event_id27MouseClicked

    private void id28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id28MouseClicked
        constr(id28);
    }//GEN-LAST:event_id28MouseClicked

    private void id34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id34MouseClicked
        constr(id34);
    }//GEN-LAST:event_id34MouseClicked

    private void id35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id35MouseClicked
        constr(id35);
    }//GEN-LAST:event_id35MouseClicked

    private void id37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id37MouseClicked
        constr(id37);
    }//GEN-LAST:event_id37MouseClicked

    private void id38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id38MouseClicked
        constr(id38);
    }//GEN-LAST:event_id38MouseClicked

    private void id39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id39MouseClicked
        constr(id39);
    }//GEN-LAST:event_id39MouseClicked

    private void id26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id26MouseClicked
        constr(id26);
    }//GEN-LAST:event_id26MouseClicked

    private void id30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id30MouseClicked
        constr(id30);
    }//GEN-LAST:event_id30MouseClicked

    private void id31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id31MouseClicked
        constr(id31);
    }//GEN-LAST:event_id31MouseClicked

    private void id32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id32MouseClicked
        constr(id32);
    }//GEN-LAST:event_id32MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       constrRefresh();
    }//GEN-LAST:event_jButton3ActionPerformed

    
 //<editor-fold defaultstate="collapsed" desc="architector">
    static void constr(JLabel label){
        if(label.getName().indexOf("empty") > 0){
            Architector4Building a4B = new Architector4Building(Traviator42.mainWindow, true, label.getName(), label);
            a4B.setVisible(true);
        }else{
            if(MainWindow.tribe == 0)
                MainWindow.addRowToArchitector(label, false, 1);
            else
                MainWindow.addRowToArchitector(label, false, 0);
        }
    }
    //</editor-fold>
  
    
   static void constrFields(ArrayList <String> url){
       
   /*1*/     building(id19, url.get(0));
   /*2*/     building(id20, url.get(1));
   /*3*/     building(id21, url.get(2));
   /*4*/     building(id22, url.get(3));
   /*5*/     building(id23, url.get(4));
   /*6*/     building(id24, url.get(5));
   /*7*/     building(id25, url.get(6));
   /*8*/     building(id26, url.get(7));
   /*9*/     building(id27, url.get(8));
   /*10*/    building(id28, url.get(9));
   /*11*/    building(id29, url.get(10));
   /*12*/    building(id30, url.get(11));
   /*13*/    building(id31, url.get(12));
   /*14*/    building(id32, url.get(13));
   /*15*/    building(id33, url.get(14));
   /*16*/    building(id34, url.get(15));
   /*17*/    building(id35, url.get(16));
   /*18*/    building(id36, url.get(17));
   /*19*/    building(id37, url.get(18));
   /*20*/    building(id38, url.get(19));
   /*21*/    building(id39, url.get(20));
  
    String wall = url.get(21);
    wall = wall.substring(wall.indexOf("/g/")+3);
    wall = wall.substring(0, 3)+"-ltr.png";
    /*22*/building(id40, "url(/g/" + wall+")");
    
    
}
    static void labelNames(){
    id19.setName("id19");    id20.setName("id20");    id21.setName("id21");
    id22.setName("id22");    id23.setName("id23");    id24.setName("id24");
    id25.setName("id25");    id26.setName("id26");    id27.setName("id27");
    id28.setName("id28");    id29.setName("id29");    id30.setName("id30");
    id31.setName("id31");    id32.setName("id32");    id33.setName("id33");
    id34.setName("id34");    id35.setName("id35");    id36.setName("id36");
    id37.setName("id37");    id38.setName("id38");    id39.setName("id39");
    id40.setName("id40");
}   
    public static void constrRefresh(){
 MainWindow.villageChange(MainWindow.comboBoxArcVillages.getSelectedItem().toString(), "dorf2.php", "");
 
 ArrayList <String> constructions = new ArrayList();
 try{
    for(int i = 1; i <= 22; i++){
        constructions.add(MainWindow.driver.findElement(By.xpath(
                "(//div [@ id='village_map'])/img[" + i + "]")).getCssValue("background-image").trim());
    }
   //<editor-fold defaultstate="collapsed" desc="исключения">
     }catch(org.openqa.selenium.NoSuchElementException Ex){
         MainWindow.consoleText(Color.RED, MainWindow.messages[4][MainWindow.language]);
         constrRefresh();
     }catch(org.openqa.selenium.remote.UnreachableBrowserException Ex){
         MainWindow.consoleText(Color.RED, MainWindow.messages[4][MainWindow.language]);
         constrRefresh();
     }catch(org.openqa.selenium.StaleElementReferenceException Ex){
         MainWindow.consoleText(Color.RED, MainWindow.messages[4][MainWindow.language]);
         constrRefresh();
     }
     //</editor-fold>
 constrFields(constructions);
 MainWindow.load = true;
}

    
static void building(JLabel label, String url){
      if(MainWindow.chrome == true)
        url = url.substring(url.indexOf("(")+1, url.length()-1);
     else
        if(url.indexOf("\")") > -1)
            url = url.substring(url.indexOf("(")+1, url.lastIndexOf("\""));
        else
            url = url.substring(url.indexOf("(")+1, url.length()-1);
     url = url.substring(url.indexOf("/g/")+3);
 MainWindow.labelIco(label, null, "images/" + url);

 if("iso.png".equals(url))name(label, "empty");
 if("g1-ltr.png".equals(url))name(label, "wood");
 if("g2-ltr.png".equals(url))name(label, "clay");
 if("g3-ltr.png".equals(url))name(label, "iron");
 if("g4-ltr.png".equals(url))name(label, "crop");
 if("g5-ltr.png".equals(url))name(label, "sawmill");
 if("g6-ltr.png".equals(url))name(label, "brickyard");
 if("g7-ltr.png".equals(url))name(label, "foundry");
 if("g8-ltr.png".equals(url))name(label, "windmill");
 if("g9-ltr.png".equals(url))name(label, "baker");
 if("g10-ltr.png".equals(url))name(label, "store");
 if("g11-ltr.png".equals(url))name(label, "Grannary");
 if("g12-ltr.png".equals(url))name(label, "");
 if("g13-ltr.png".equals(url))name(label, "BlackSmith");
 if("g14-ltr.png".equals(url))name(label, "Arena");
 if("g15-ltr.png".equals(url))name(label, "MainBuilding");
 if("g16-ltr.png".equals(url))name(label, "RallyPoint");
 if("g17-ltr.png".equals(url))name(label, "Marketplace");
 if("g18-ltr.png".equals(url))name(label, "Embassy");
 if("g19-ltr.png".equals(url))name(label, "Barrack");
 if("g20-ltr.png".equals(url))name(label, "Stables");
 if("g21-ltr.png".equals(url))name(label, "Workshop");
 if("g22-ltr.png".equals(url))name(label, "Academia");
 if("g23-ltr.png".equals(url))name(label, "Cranny");
 if("g24-ltr.png".equals(url))name(label, "TownHall");
 if("g25-ltr.png".equals(url))name(label, "Residence");
 if("g26-ltr.png".equals(url))name(label, "Palace");
 if("g27-ltr.png".equals(url))name(label, "Treasure");
 if("g28-ltr.png".equals(url))name(label, "TradeOffice");
 if("g29-ltr.png".equals(url))name(label, "LargeBarrack");
 if("g30-ltr.png".equals(url))name(label, "LargeStables");
 if("g31-ltr.png".equals(url))name(label, "Wall");
 if("g32-ltr.png".equals(url))name(label, "ClayMound");
 if("g33-ltr.png".equals(url))name(label, "Palisade");
 if("g34-ltr.png".equals(url))name(label, "StoneCutter");
 if("g35-ltr.png".equals(url))name(label, "Brewery");
 if("g36-ltr.png".equals(url))name(label, "Trapper");
 if("g37-ltr.png".equals(url))name(label, "HeroMansion");
 if("g38-ltr.png".equals(url))name(label, "LargeStore");
 if("g39-ltr.png".equals(url))name(label, "LargeGrannary");
 if("g40-ltr.png".equals(url))name(label, "WorldWonder");
 if("g41-ltr.png".equals(url))name(label, "WateringPlace");
}
static void name(JLabel label, String str){
    label.setName(label.getName()+" " + str);
}
static void addNewLabel(JLabel thisLabel, String path, String name){
        try {
            BufferedImage img;
            img = ImageIO.read(new File(path));
            ImageIcon ii = new ImageIcon(img.getScaledInstance(thisLabel.getWidth(),thisLabel.getHeight(), BufferedImage.SCALE_DEFAULT));
            thisLabel.setIcon(ii);
        } catch (IOException ex) {
            addNewLabel(thisLabel,"images/error.png", "error");
        }
        thisLabel.setName(thisLabel.getName().substring(0, thisLabel.getName().indexOf(" ")));
        String nameed = name.substring(name.indexOf(" "), name.lastIndexOf(" ")).trim();
        thisLabel.setName(thisLabel.getName().trim() + " " + nameed);
}
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel id19;
    public static javax.swing.JLabel id20;
    public static javax.swing.JLabel id21;
    public static javax.swing.JLabel id22;
    public static javax.swing.JLabel id23;
    public static javax.swing.JLabel id24;
    public static javax.swing.JLabel id25;
    public static javax.swing.JLabel id26;
    public static javax.swing.JLabel id27;
    public static javax.swing.JLabel id28;
    public static javax.swing.JLabel id29;
    public static javax.swing.JLabel id30;
    public static javax.swing.JLabel id31;
    public static javax.swing.JLabel id32;
    public static javax.swing.JLabel id33;
    public static javax.swing.JLabel id34;
    public static javax.swing.JLabel id35;
    public static javax.swing.JLabel id36;
    public static javax.swing.JLabel id37;
    public static javax.swing.JLabel id38;
    public static javax.swing.JLabel id39;
    public static javax.swing.JLabel id40;
    private javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
