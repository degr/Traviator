/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.common;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import traviator42.threads.ThreadRefresh;

public class MainLogin extends javax.swing.JDialog {


    public MainLogin(java.awt.Frame parent, boolean modal) {
        super(parent, MainWindow.messages[81][MainWindow.language], true);
           initComponents();
        
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //делаем чтобы приложение появилось в центре экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2));
        jComboBox1.removeAllItems();
        jComboBox1.addItem("GoogeChrome");
        jComboBox1.addItem("Moz FireFox");
        if(MainWindow.chrome == false){
            jComboBox1.setSelectedIndex(1);
        }
       
       FileInputStream fis;
        
        try {
               fis = new FileInputStream("src/Player.txt");
               BufferedReader read = new BufferedReader(new InputStreamReader(fis, "UTF8"));
     
               String temp = read.readLine();
               serverText.setText(temp.substring(temp.indexOf(":")+2));
               temp = read.readLine();
               loginText.setText(temp.substring(temp.indexOf(":")+2));
               temp = read.readLine();
               passText.setText(temp.substring(temp.indexOf(":")+2));
             
                read.close();
            } catch (IOException ex) {
                
            }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        checkBoxRemember = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        buttonLogin = new javax.swing.JButton(MainWindow.natiPic[4][22]);
        jPanel1 = new javax.swing.JPanel();
        serverText = new javax.swing.JTextField();
        loginText = new javax.swing.JTextField();
        passText = new javax.swing.JPasswordField();
        password = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        server = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel(MainWindow.natiPic[4][0]);
        jLabel8 = new javax.swing.JLabel(MainWindow.natiPic[4][1]);
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel(MainWindow.natiPic[4][8]);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        checkBoxRemember.setSelected(true);
        checkBoxRemember.setText(MainWindow.messages[34][MainWindow.language]);
        jPanel3.add(checkBoxRemember);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox1);

        buttonLogin.setText(MainWindow.messages[33][MainWindow.language]);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        jPanel2.add(buttonLogin);

        jPanel3.add(jPanel2);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        password.setText(MainWindow.messages[32][MainWindow.language]);

        login.setText(MainWindow.messages[31][MainWindow.language]);

        server.setText(MainWindow.messages[30][MainWindow.language]);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(login)
                    .addComponent(server)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serverText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(loginText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(server))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
   


        boolean serverError = false;
        String server = serverText.getText();
        if(server.indexOf("dorf") > 0){
            server = server.substring(0, server.indexOf("dorf"));
            serverError = true;
        }
        if(server.indexOf("http://") < 0){
            server = "http://" + server;
            serverError = true;
        }
        int a = server.length();
        if(!(server.substring(a-1, a)).equals("/")){
            server = server + "/";
            serverError = true;
        }
         serverText.setText(server); 
        
         if(serverError == false){
             
            MainWindow.server = server;
            try {
                BufferedWriter writer;
                FileOutputStream fos;
                fos = new FileOutputStream("src/Player.txt");
                writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));
                String data = "";
                if (checkBoxRemember.isSelected()) {
                    data = data + "server: " + serverText.getText() + "\n";
                    data = data + "login: " + loginText.getText() + "\n";
                    data = data + "pass: " + passText.getText() + "\n";
                }
                writer.write(data); 
                writer.close();

            }catch (Exception ex) {
            }  

            MainWindow.consoleText(Color.BLACK, MainWindow.messages[6][MainWindow.language]);

            try{
                MainWindow.driver.quit();
            }catch(java.lang.NullPointerException ex){

            }catch(org.openqa.selenium.WebDriverException ex){

            }
           if(jComboBox1.getSelectedIndex()==0){
                    MainWindow.chrome = true;
                    MainWindow.driver = new ChromeDriver();
           }else{
               MainWindow.driver = new FirefoxDriver();
               MainWindow.chrome = false;
           }
            ThreadRefresh threadRefresh = new ThreadRefresh();
            dispose();
         }else{
             jLabel1.setText(MainWindow.messages[284][MainWindow.language]);
             jLabel1.setForeground(Color.red);
         }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        MainWindow.language = 1;
        MainWindow.internationalization();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        MainWindow.language = 0;
        MainWindow.internationalization();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        MainWindow.language = 2;
        MainWindow.internationalization();
    }//GEN-LAST:event_jLabel9MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton buttonLogin;
    public static javax.swing.JCheckBox checkBoxRemember;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel login;
    public static javax.swing.JTextField loginText;
    public static javax.swing.JPasswordField passText;
    public static javax.swing.JLabel password;
    public static javax.swing.JLabel server;
    public static javax.swing.JTextField serverText;
    // End of variables declaration//GEN-END:variables
}
