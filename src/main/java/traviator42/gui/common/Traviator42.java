/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.common;

import traviator42.gui.architector.Architector1Villy;
import traviator42.gui.architector.Architector2Villy;
import traviator42.gui.architector.Architector3Reso;
import traviator42.gui.architector.Architector3Villy;
import traviator42.gui.bandito.BanditoPreferenses;
import traviator42.gui.evacuator.Evakuator2type;
import traviator42.gui.evacuator.Evakuator4TroopsDirection;
import traviator42.gui.evacuator.Evakuator5timeCount;
import traviator42.gui.evacuator.MainCoordDirection;
import traviator42.gui.sergeant.SergeantFighterProperties;
import traviator42.gui.sergeant.SergeantFighterSelection;
import traviator42.gui.sergeant.SergeantvillageName;
import traviator42.gui.timer.timer1Value;

import java.awt.*;
import java.io.*;


public class Traviator42 {
public static int version = 20;
/*исправлена загрузка таблицы, иконка при сохранении таблицы измененна с вопроса на "i"*/
  public static boolean payment = false;
  public static boolean message = false;
  public static MainWindow mainWindow;
  public static MainLogin login;
  
  static BanditoPreferenses banditoPref;
  public static SergeantvillageName villageFrame;
     public static SergeantFighterSelection fSelection;
     public static SergeantFighterProperties fProperties;
     static Architector1Villy arch1;
     public static Architector2Villy arch2;
     public static Architector3Reso arch3Reso;
     public static Architector3Villy arch3Villy;
     static Evakuator2type eva2;
     public static MainCoordDirection eva3;
     public static Evakuator4TroopsDirection eva4;
     public static Evakuator5timeCount eva5;
     static timer1Value timer;
     
     
     static int laf = 0;
    public static void main(String[] args) {
        
       //<editor-fold defaultstate="collapsed" desc="Nimbus Look and feel">
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(javax.swing.JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(javax.swing.JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(javax.swing.JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(javax.swing.JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     //</editor-fold> 
   
         System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        int days = 9999;
        try {
            BufferedReader lang = new BufferedReader(new InputStreamReader(
                    new FileInputStream("src/language.txt"), "utf8"));

            String saveServer = lang.readLine().trim();
            if("".equals(saveServer))saveServer = "1";
            MainWindow.language = Integer.valueOf(saveServer);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Traviator42.mainWindow = new MainWindow();
        Traviator42.mainWindow.setVisible(true);


        MainWindow.consoleText(Color.BLACK, "Your program will work during next " + days + " days.\n");
        MainLogin ml = new MainLogin(Traviator42.mainWindow, true);
        ml.setVisible(true);

    }
}