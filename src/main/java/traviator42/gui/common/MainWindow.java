package traviator42.gui.common;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import traviator42.dto.Village;
import traviator42.gui.architector.Architector1Villy;
import traviator42.gui.attack.Attack1Villy;
import traviator42.gui.attack.AttackDelete;
import traviator42.gui.bandito.Bandito1Robot;
import traviator42.gui.bandito.Bandito1Villy;
import traviator42.gui.bandito.BanditoModifyTable;
import traviator42.gui.bandito.BanditoPreferenses;
import traviator42.gui.evacuator.Evacuator6Pref;
import traviator42.gui.evacuator.Evakuator2type;
import traviator42.gui.merchant.Merch1VillySender;
import traviator42.gui.misc.*;
import traviator42.gui.scout.ScoutAnalizator;
import traviator42.gui.scout.ScoutPreferenses;
import traviator42.gui.scout.ScoutTableLoad;
import traviator42.gui.search.Search;
import traviator42.gui.sergeant.SergeantvillageName;
import traviator42.gui.timer.timer1Value;
import traviator42.threads.*;

public class MainWindow extends javax.swing.JFrame {
//fighterProperties строка 187

//<editor-fold defaultstate="collapsed" desc=" потоки ">
    public static Thread TR; //thread refresh
    public static Thread TW; //thread wait
    public static Thread TE; //error thread
    public static Thread TFS;//thread farm send
    public static Thread TT; //trainUnits
    public static Thread TM; //merchant thread
    public static Thread TA; //architector thread
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="глобальные">
    public static ColorPane Console = new ColorPane();
    int laf = 0;
    public static Random rand = new Random(new Date().getTime());
    static File savefile, openFile;
    public static String server;
    public static String sound;
//villagePass - на случай, если такой деры не нашли.
    public static boolean interrupt = false;
    public static boolean waitInterrupt = false;
    static boolean stopped = false;
    public static int tribe = 0;
//static ArrayList<String> villageName = new ArrayList();
//static ArrayList<String> villageURL = new ArrayList();
    public static int reload = 0;//инт для перезапуска робота
    public static Clip clip;
    public static boolean soundAlert = false;
    public static boolean firstRefresh = true;
    public static boolean chrome = true;
    public static boolean banditoTroops = false;
    public static int count, delay = 10, slowdown = 2, showTips = 1;
    public static double accelerate = 1;
    Dimension timerDim = new Dimension(35, 25);
    Dimension largeDim = new Dimension(90, 25);
    public static boolean error = true;
    public static boolean debug = false;
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Сержант">
    public static String[] futureRow = new String[10];
    public static DefaultTableModel sergeantModel = new DefaultTableModel();
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="бандит">
    public static DefaultTableModel banditoModel = new DefaultTableModel();
    public static DefaultTableModel banditoListModel = new DefaultTableModel();
    public static DefaultTableModel banditoListModelE = new DefaultTableModel();
    public static boolean banditoMes = true;
//для копирования в аккаунт
    public static int villageNameList = 0;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="торговец">
    public static DefaultTableModel merchModel = new DefaultTableModel();
    public static int[] reso = new int[4];
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="увод">
    public static DefaultTableModel evadeModel = new DefaultTableModel();
    public static Boolean[] unitsEvade = new Boolean[11];
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="архитектор">
    public static DefaultTableModel architectorModel = new DefaultTableModel();
    public static DefaultTableModel architectorModelDouble = new DefaultTableModel();
    public static DefaultTableModel demolishModel = new DefaultTableModel();
    public static ArrayList<Village> vilList = new ArrayList<>();
    public static boolean autoBuild = false;
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Массив ресурсных полей">
    public static int resoFields[][] = new int[][]{
        //     0 - wood 1 - clay 2 - iron 3 - crop
        /*01*/{3, 3, 0, 3, 3, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*02*/ {2, 3, 0, 2, 1, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*03*/ {0, 3, 0, 2, 1, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*04*/ {0, 3, 0, 1, 1, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*05*/ {0, 3, 0, 2, 0, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*06*/ {3, 3, 0, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 3},
        /*07*/ {0, 3, 3, 0, 1, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*08*/ {2, 3, 3, 0, 1, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*09*/ {2, 3, 3, 0, 0, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*10*/ {2, 3, 0, 1, 1, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},
        /*11*/ {2, 0, 0, 2, 0, 3, 3, 2, 2, 1, 1, 2, 0, 3, 3, 1, 3, 3},
        /*12*/ {0, 3, 0, 0, 1, 1, 2, 3, 3, 2, 2, 3, 3, 0, 3, 1, 0, 1},};
    //</editor-fold>
    public static int vilNum = 0;
    public static boolean load = false;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="таймер">
    public static DefaultTableModel timerModel = new DefaultTableModel();
    public static Clip timerClip;
    public static boolean stopTimerClip = false;
    public static boolean stopTimer = false;
    public static String soundTimer;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="ратуша">
    public static DefaultTableModel celebrateModel = new DefaultTableModel();
    public static DefaultTableModel blackSmithModel = new DefaultTableModel();
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="скаут">
    public static DefaultTableModel scoutModel = new DefaultTableModel();
    public static boolean fromTableLoad = false;
    public static String firstFile, secondFile,
            newFile;
    public static String tableData;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="атаки">
    public static JPanel attackPanel = new JPanel();
    public static JScrollPane jsp = new JScrollPane(attackPanel);
    public static int browser = 0;
//</editor-fold>
// repeat - для повтора в случае если не удалоь отправить по фарм листам
    static boolean repeat = false;
    //<editor-fold defaultstate="collapsed" desc=" умолчания настроек ">
    //определяет диапазоны населения - нижний и верхний рубеж для 6 диапазонов
    public static int popBorder[][] = new int[6][2];
    public static int interval[] = new int[]{2, 5, 10, 30, 100, 300};
    public static int raidInterval = 60, reportGreen = 1,
            reportYellow = 0, reportRed = 0;
    public static ArrayList<Integer[]> troops = new ArrayList<>();
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" драйвер ">
    public static WebDriver driver, searchDriver;
    public static Wait<WebDriver> wait;
    //</editor-fold>

    public MainWindow() {
        super("Travian Chief (Travian 4.2) v 1." + Traviator42.version);

        initComponents();
        JScrollPane consSP = new JScrollPane(Console);
        getContentPane().add(consSP);
        consSP.setPreferredSize(new Dimension(741, 150));
        Console.setPreferredSize(new Dimension(741, 150));
        setSize(new Dimension(790, 650));

        for (int i = 0; i < unitsEvade.length; i++) {
            unitsEvade[i] = false;
        }
        for (int i = 0; i < 4; i++) {
            reso[i] = 1000;
        }



        //<editor-fold defaultstate="collapsed" desc=" предупреждение при выходе ">
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowListener() {
            public void windowActivated(WindowEvent event) {
            }

            public void windowClosed(WindowEvent event) {
            }

            public void windowClosing(WindowEvent event) {
                Object[] options = {messages[155][language], messages[156][language]};
                int n = JOptionPane
                        .showOptionDialog(event.getWindow(), messages[157][language],
                        messages[132][language], JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    try {
                        searchDriver.quit();
                    } catch (java.lang.NullPointerException ex) {
                    } catch (org.openqa.selenium.remote.UnreachableBrowserException ex) {
                    }
                    try {
                        driver.quit();
                    } catch (java.lang.NullPointerException ex) {
                    } catch (org.openqa.selenium.remote.UnreachableBrowserException ex) {
                    }

                    event.getWindow().setVisible(false);
                    save(true);
                    saveConfig();
                    System.exit(0);
                }

            }

            public void windowDeactivated(WindowEvent event) {
            }

            public void windowDeiconified(WindowEvent event) {
            }

            public void windowIconified(WindowEvent event) {
            }

            public void windowOpened(WindowEvent event) {
            }
        });
//</editor-fold> 

        //<editor-fold defaultstate="collapsed" desc=" количество солдат по населению ">
        popBorder[0][0] = 0;
        popBorder[0][1] = 20;

        popBorder[1][0] = 21;
        popBorder[1][1] = 50;

        popBorder[2][0] = 51;
        popBorder[2][1] = 100;

        popBorder[3][0] = 101;
        popBorder[3][1] = 200;

        popBorder[4][0] = 201;
        popBorder[4][1] = 400;

        popBorder[5][0] = 400;
        popBorder[5][1] = 5000;
        //</editor-fold>

// <editor-fold defaultstate="collapsed" desc=" загрузка всякой шляпы ">
        try {

            BufferedReader pref = new BufferedReader(new InputStreamReader(
                    new FileInputStream("src/config.txt"), "utf8"));
            String temp;
            //для  интервалов по насу
            for (int i = 0; i < 6; i++) {
                temp = pref.readLine();
                temp = temp.substring(temp.indexOf("=") + 2).trim();
                interval[i] = Integer.valueOf(temp);
            }

            //для пустой строки
            temp = pref.readLine();

            //для периода
            temp = pref.readLine();
            raidInterval = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));

            //для пустой строки   
            temp = pref.readLine();

            //для фильтра отчетов
            temp = pref.readLine();
            reportGreen = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));
            temp = pref.readLine();
            reportYellow = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));
            temp = pref.readLine();
            reportRed = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));

            //для пустой строки
            temp = pref.readLine();

            temp = pref.readLine();
            delay = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));
            temp = pref.readLine();
            slowdown = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));
            temp = pref.readLine();
            showTips = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));

            //для пустой строки
            temp = pref.readLine();

            //для звуковых записей
            for (int i = 0; i < 5; i++) {
                temp = pref.readLine();
                jComboBox2.addItem(temp.substring(temp.indexOf(" = ") + 3));
                comboboxTimer.addItem(temp.substring(temp.indexOf(" = ") + 3));
                comboboxTimer.removeItemAt(0);
                jComboBox2.removeItemAt(0);
            }
            //для пустой строки
            temp = pref.readLine();

            //для языка
            temp = pref.readLine();
            language = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));

            //для пустой строки
            temp = pref.readLine();

            //для приключений
            temp = pref.readLine();
            if (Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3)) == 1) {
                checkBoxAdventure.setSelected(true);
            }
            temp = pref.readLine();
            if (Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3)) == 1) {
                checkBoxHard.setSelected(true);
            }
            temp = pref.readLine();
            jTextField1.setText(temp.substring(temp.indexOf(" = ") + 3));
            jTextField2.setText(setTimer(jTextField1.getText()));
            //для пустой строки
            temp = pref.readLine();

            //для приключений
            temp = pref.readLine();
            accelerate = Double.parseDouble(temp.substring(temp.indexOf(" = ") + 3));
            if (accelerate <= 0) {
                accelerate = 1;
            }
            //для пустой строки
            temp = pref.readLine();

            //для браузера
            temp = pref.readLine();
            if ("false".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                chrome = false;
            }
            //для пустой строки
            temp = pref.readLine();

            //для эвакуатора
            temp = pref.readLine();
            if ("false".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                checkBoxTravianPlus.setSelected(false);
            } else {
                checkBoxTravianPlus.setSelected(true);
            }
            temp = pref.readLine();
            if ("false".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                checkBoxSound.setSelected(false);
            } else {
                checkBoxSound.setSelected(true);
            }
            temp = pref.readLine();
            if ("false".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                checkBoxOaseSound.setSelected(false);
            } else {
                checkBoxOaseSound.setSelected(true);
            }
            //для пустой строки
            temp = pref.readLine();

            //для эвакуации юнитов
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[0] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[1] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[2] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[3] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[4] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[5] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[6] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[7] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[8] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[9] = true;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                unitsEvade[10] = true;
            }
            //для пустой строки
            temp = pref.readLine();

            //для дебуга и ошибок
            temp = pref.readLine();
            if ("false".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                error = false;
            }
            temp = pref.readLine();
            if ("true".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                debug = true;
            }
            //для пустой строки
            temp = pref.readLine();

            //для браузера атак
            temp = pref.readLine();
            browser = Integer.valueOf(temp.substring(temp.indexOf(" = ") + 3));
            //для пустой строки
            temp = pref.readLine();

            //для сообщений бандита
            temp = pref.readLine();
            if ("false".equals(temp.substring(temp.indexOf(" = ") + 3))) {
                banditoMes = false;
            }
            pref.close();


        } catch (Exception ex) {
        }


        int hours = raidInterval / 60;
        textFieldHours.setText(String.valueOf(hours));
        int min = raidInterval - (raidInterval / 60) * 60;
        if (min < 10) {
            textFieldMinutes.setText("0" + String.valueOf(min));
        } else {
            textFieldMinutes.setText(String.valueOf(min));
        }
        textFieldSec.setText("00");
        //</editor-fold>

        internationalization();
        buttonStart.setIcon(natiPic[4][17]);
        buttonStart1.setIcon(natiPic[4][17]);

        //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
        //делаем чтобы приложение появилось в центре экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc=" TRAY ICO ">
        Image image = Toolkit.getDefaultToolkit().createImage("images/Chief.png");
        setIconImage(image);
        JLabel lbl;

        ActionListener exitAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {messages[155][language], messages[156][language]};
                int n = JOptionPane
                        .showOptionDialog(null, messages[157][language],
                        messages[132][language], JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    try {
                        searchDriver.quit();
                    } catch (java.lang.NullPointerException ex) {
                    } catch (org.openqa.selenium.remote.UnreachableBrowserException ex) {
                    }
                    try {
                        driver.quit();
                    } catch (java.lang.NullPointerException ex) {
                    } catch (org.openqa.selenium.remote.UnreachableBrowserException ex) {
                    }

                    setVisible(false);
                    save(true);
                    System.exit(0);
                }
            }
        };
        if (SystemTray.isSupported()) {
            PopupMenu pm = new PopupMenu();
            MenuItem miExit = new MenuItem("Exit");
            miExit.addActionListener(exitAL);
            MenuItem miRestore = new MenuItem("Restore");
            miRestore.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    restoreWindow();
                }
            });
            pm.add(miRestore);
            final TrayIcon trayIcon = new TrayIcon(image, "Travian Chief", pm);
            trayIcon.setImageAutoSize(true);
            pm.addSeparator();
            pm.add(miExit);
            lbl = new JLabel("<html><font color=\"blue\">System tray is supported</font></html>");
            SystemTray st = SystemTray.getSystemTray();

            trayIcon.addMouseListener(new TrayMouseListener());
            try {
                st.add(trayIcon);
                addWindowListener(new WindowMinimizeListener());
            } catch (AWTException ex) {
            }
        } else {
            lbl = new JLabel("<html><font color=\"red\">System tray is NOT supported</font></html>");
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc=" загрузка таблицы ">
        openfile(new File("src/autosave.xml"));

        //</editor-fold>


        sound = "sound/" + jComboBox2.getSelectedItem().toString();
        soundTimer = "sound/" + comboboxTimer.getSelectedItem().toString();
        jComboBox2.setSelectedIndex(4);
        comboboxTimer.setSelectedIndex(1);

        if (checkBoxBanditoExtend.isSelected()) {
            checkBoxBanditoExtend.doClick();
        }
// checkBoxBanditoExtend.setEnabled(false);
// checkBoxBanditoExtend.setVisible(false);
    }
    //<editor-fold defaultstate="collapsed" desc="pics">
    public static ImageIcon natiPic[][] = new ImageIcon[][]{
        {new ImageIcon("images/rome_1.png"),
            new ImageIcon("images/rome_2.png"),
            new ImageIcon("images/rome_3.png"),
            new ImageIcon("images/rome_4.png"),
            new ImageIcon("images/rome_5.png"),
            new ImageIcon("images/rome_6.png"),
            new ImageIcon("images/rome_7.png"),
            new ImageIcon("images/rome_8.png"),
            new ImageIcon("images/rome_9.png"),
            new ImageIcon("images/rome_10.png"),
            new ImageIcon("images/nati_rome.png")
        },
        {new ImageIcon("images/teut_1.png"),
            new ImageIcon("images/teut_2.png"),
            new ImageIcon("images/teut_3.png"),
            new ImageIcon("images/teut_4.png"),
            new ImageIcon("images/teut_5.png"),
            new ImageIcon("images/teut_6.png"),
            new ImageIcon("images/teut_7.png"),
            new ImageIcon("images/teut_8.png"),
            new ImageIcon("images/teut_9.png"),
            new ImageIcon("images/teut_10.png"),
            new ImageIcon("images/nati_teut.png")
        },
        {new ImageIcon("images/ghal_1.png"),
            new ImageIcon("images/ghal_2.png"),
            new ImageIcon("images/ghal_3.png"),
            new ImageIcon("images/ghal_4.png"),
            new ImageIcon("images/ghal_5.png"),
            new ImageIcon("images/ghal_6.png"),
            new ImageIcon("images/ghal_7.png"),
            new ImageIcon("images/ghal_8.png"),
            new ImageIcon("images/ghal_9.png"),
            new ImageIcon("images/ghal_10.png"),
            new ImageIcon("images/nati_ghal.png")
        },
        {
            new ImageIcon("images/hero.png"),
            new ImageIcon("images/ally.png")
        },
        //мелочи
        {
            /*[4][0]*/new ImageIcon("images/eng.png"),
            /*[4][1]*/ new ImageIcon("images/rus.png"),
            /*[4][2]*/ new ImageIcon("images/circleOrange.png"),
            /*[4][3]*/ new ImageIcon("images/circleWhite.png"),
            //ресурсы
            /*[4][4]*/ new ImageIcon("images/wood.png"),
            /*[4][5]*/ new ImageIcon("images/clay.png"),
            /*[4][6]*/ new ImageIcon("images/iron.png"),
            /*[4][7]*/ new ImageIcon("images/crop.png"),
            /*[4][8]*/ new ImageIcon("images/ph.png"),
            /*[4][9]*/ new ImageIcon("images/adventure.png"),
            /*[4][10]*/ new ImageIcon("images/adventureHard.png"),
            /*[4][11]*/ new ImageIcon("images/culture.png"),
            /*[4][12]*/ new ImageIcon("images/armor.png"),
            /*[4][13]*/ new ImageIcon("images/add.png"),
            /*[4][14]*/ new ImageIcon("images/del.png"),
            /*[4][15]*/ new ImageIcon("images/save.png"),
            /*[4][16]*/ new ImageIcon("images/copy.png"),
            /*[4][17]*/ new ImageIcon("images/start.png"),
            /*[4][18]*/ new ImageIcon("images/stop.png"),
            /*[4][19]*/ new ImageIcon("images/pref.png"),
            /*[4][20]*/ new ImageIcon("images/clock.png"),
            /*[4][21]*/ new ImageIcon("images/ref.png"),
            /*[4][22]*/ new ImageIcon("images/enter.png"),
            /*[4][23]*/ new ImageIcon("images/mod.png"),
            /*[4][24]*/ new ImageIcon("images/next.png"),
            /*[4][25]*/ new ImageIcon("images/ok.png"),
            /*[4][26]*/ new ImageIcon("images/bandito.png"),
            /*[4][27]*/ new ImageIcon("images/sarge.png"),
            /*[4][28]*/ new ImageIcon("images/merch.png"),
            /*[4][29]*/ new ImageIcon("images/arch.png"),
            /*[4][30]*/ new ImageIcon("images/bag.png"),
            /*[4][31]*/ new ImageIcon("images/vilC.png"),
            /*[4][32]*/ new ImageIcon("images/search.png"),
            /*[4][33]*/ new ImageIcon("images/routes.png"),
            /*[4][34]*/ new ImageIcon("images/play.png"),
            /*[4][35]*/ new ImageIcon("images/pause.png"),},
        //            Здания
        {
            new ImageIcon("images/g1-ltr.png"),
            new ImageIcon("images/g2-ltr.png"),
            new ImageIcon("images/g3-ltr.png"),
            new ImageIcon("images/g4-ltr.png"),
            new ImageIcon("images/g5-ltr.png"),
            new ImageIcon("images/g6-ltr.png"),
            new ImageIcon("images/g7-ltr.png"),
            new ImageIcon("images/g8-ltr.png"),
            new ImageIcon("images/g9-ltr.png"),
            new ImageIcon("images/g10-ltr.png"),
            new ImageIcon("images/g11-ltr.png"),
            new ImageIcon("images/g12-ltr.png"),
            new ImageIcon("images/g13-ltr.png"),
            new ImageIcon("images/g14-ltr.png"),
            new ImageIcon("images/g15-ltr.png"),
            new ImageIcon("images/g16-ltr.png"),
            new ImageIcon("images/g17-ltr.png"),
            new ImageIcon("images/g18-ltr.png"),
            new ImageIcon("images/g19-ltr.png"),
            new ImageIcon("images/g20-ltr.png"),
            new ImageIcon("images/g21-ltr.png"),
            new ImageIcon("images/g22-ltr.png"),
            new ImageIcon("images/g23-ltr.png"),
            new ImageIcon("images/g24-ltr.png"),
            new ImageIcon("images/g25-ltr.png"),
            new ImageIcon("images/g26-ltr.png"),
            new ImageIcon("images/g27-ltr.png"),
            new ImageIcon("images/g28-ltr.png"),
            new ImageIcon("images/g29-ltr.png"),
            new ImageIcon("images/g30-ltr.png"),
            new ImageIcon("images/g31-ltr.png"),
            new ImageIcon("images/g32-ltr.png"),
            new ImageIcon("images/g33-ltr.png"),
            new ImageIcon("images/g34-ltr.png"),
            new ImageIcon("images/g35-ltr.png"),
            new ImageIcon("images/g36-ltr.png"),
            new ImageIcon("images/g37-ltr.png"),
            new ImageIcon("images/g38-ltr.png"),
            new ImageIcon("images/g39-ltr.png"),}
    };
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" интернационализация ">
    //[0]-russian, [1] - english
    public static int language = 0;
    public static final String[][] messages = new String[][]{
        //<editor-fold defaultstate="collapsed" desc=" 0 - 100 ">
        /*0*/{"Не задан перерыв между отправками\n", "No breaks between sending\n", "Walang hinto sa pagitan ng pagpapadala\n"},
        /*1*/ {"Не задано количество отправок\n", "Do not set the number of consignments\n", "Huwag itakda ang bilang ng mga mangangalakal\n"},
        /*2*/ {"Не заданы ресурсы для отправки\n", "It is not set the resources to send\n", "Hindi nakaayos ang mga ipapadalang kayamanan\n"},
        /*3*/ {"Название деревени-отправителя и\n деревни-получателя совпадают\n", "The name of the sending villages and villages\nof the recipient are the same\n", "Ang pangalan ng magpapadalang baryo at ang pagdadalhan ay magkapareho\n"},
        /*4*/ {"Ошибка. Заполните заново поля \"Логин\" или проверьте связь\n", "Error. Try to log one more time.\n", "Error. Try to log one more time.\n"},
        /*5*/ {"Ошибка. Неверно введено название сервера\n", "Error. Server name incorrect\n", "Mali. Ang pangalan ng serber ay mali\n"},
        /*6*/ {"Загрузка...\n", "Loading...\n", "Nag lo-load...\n"},//not mistake!!!
        /*7*/ {"Заполнение поля \"Логин\"\n", "Filling login field\n", "Naglalagay sa login field\n"},
        /*8*/ {"Заполнение поля \"Пароль\"\n", "Filling password field\n", "Naglalagay sa password field\n"},
        /*9*/ {"Загрузка элементов\n", "Loading elements\n", "Nag lo-load ang mga elemento\n"},
        /*10*/ {"Загрузка завершена\n", "Loading complete\n", "Tapos na ang pag lo-load\n"},
        /*11*/ {"Ошибка", "Error", "Error"},
        /*12*/ {"Отправка успешна", "Sending  successful", "Tagumpay na naipadala"},
        //пошли названия кнопок полей и проч
        /*13*/ {"из", "from", "mula sa"},
        /*14*/ {"в", "to", "papunta sa"},
        /*15*/ {"Использовать Х/У", "Use coord", "gamiting coord"},
        /*16*/ {"Древесина", "Wood", "Troso"},
        /*17*/ {"Глина", "Clay", "Putik"},
        /*18*/ {"Железо", "Iron", "Bakal"},
        /*19*/ {"Зерно", "Crop", "Pananim"},
        /*20*/ {"Кол-во отправок", "total send", "Kabuuang maipapadala"},
        /*21*/ {"Ждать", "Wait", "Maghintay"},
        /*22*/ {"минут", "minutes", "minuto"},
        /*23*/ {"Отправить сейчас", "Send now", "Ipadala na"},
        /*24*/ {"Постоянные отправки", "Unlimited pushes", "Walang hintong pagpapadala"},
        /*25*/ {"Старт", "Start", "Simulan"},
        /*26*/ {"Стоп", "Stop", "Huminto"},
        /*27*/ {"Добавить", "Add program", "Magdagdag ng programa"},
        /*28*/ {"Удалить", "Remove", "Alisin"},
        /*29*/ {"Войти", "Login", "Login"},
        //окно логин
        /*30*/ {"Введите имя сервера", "Enter server name", "Ilagay ang pangalan ng serber"},
        /*31*/ {"Введите ваше имя", "Enter your login here", "Ilagay ang iyong login dito"},
        /*32*/ {"Введите ваш пароль", "Enter your password", "Ilagay ang iyong password"},
        /*33*/ {"Войти", "Login", "Login"},
        /*34*/ {"Запомнить меня", "Remember me", "Tandaan ito"},
        /*35*/ {"Не удалось сохранить данные\n", "Can't save personal data\n", "Hindi maaaring i-save ang personal na data\n"},
        /*36*/ {"Все сейчас", "All now", "Lahat ngayon"},
        /*37*/ {"Таблица успешно сохраненна\n", "Table data saved successful\n", "Tagumpay na na i-save ang table data\n"},
        /*38*/ {"Нельзя начать работу без заданной программы.\nЗадайте програму.\n", "Can't start without program. Add program at first\n", "Hindi maaring simulang ng wala ang programa. Unahin and programa\n"},
        /*39*/ {"Подкрепление", "Reinforcment", "Dagdag ng Hukbo"},
        /*40*/ {"Обычная", "Normal", "Normal"},
        /*41*/ {"Набег", "Raid", "Pagnakaw"},
        /*42*/ {"Фарм лист сформирован. Добавлено ", "Farm list created.", "Nalikha ang Farm List."},
        /*43*/ {" ферм.\n", "farms added.\n", "Nagdagdag ng Farms.\n"},
        /*44*/ {"Копирую лист в игру. Пожалуйста ждите", "Copying to game now. Please wait.", "Kinokopya na sa laro. Maghitnay."},
        /*45*/ {"Скопировано ", "", ""},
        /*46*/ {" строк", " strings copyed", " nakopya na ang strings"},
        /*47*/ {"Требуется перенести ", "", ""},
        /*48*/ {" строк\n", " strings need's to copy\n", "kailangang kopyahin ang strings\n"},
        /*49*/ {"Набег", "Raid", "Pagnakaw"},
        /*50*/ {"Обычная", "Normal", "Normal"},
        /*51*/ {"Набег", "Raid", "Pagnakaw"},
        /*52*/ {"Обычная", "Normal", "Normal"},
        /*53*/ {"Добавлено вручную", "Added by handle", "naidagdag gamit ang handle"},
        /*54*/ {" добавлено. Осталось ", " аdded ", " naidagdag "},
        /*55*/ {".\n", "left.\n", "natitira.\n"},
        /*56*/ {"Шеф, сделано успешно.\n", "Chief, work complete.\n", "Chief, natapos ang pag-gawa.\n"},
        /*57*/ {"Шеф, я стараюсь\n", "Chief, I do all what I can.\n", "Chief, gagawin ko lahat ng aking makakaya.\n"},
        /*58*/ {"Останови закачки.\n", "Stop your downloads\n", "Ihinto ang mga downloads\n"},
        /*59*/ {"Не дави на меня!\n", "Stop pushing me!\n", "Huwag mo akong pilitin!\n"},
        /*60*/ {"Ага, сейчас.\n", "Yup. Now.\n", "Oo. Ngayon.\n"},
        /*61*/ {"Чувак\n", "Dude\n", "Pare\n"},
        /*62*/ {"Нечего переносить. Сначала сформируйте список ферм.\n", "Nothing to copy. Create farm-list at first.\n", "Walang kokopyahin. Gumawa muna ng Farm List.\n"},
        /*63*/ {"Новый список", "New list", "Panibagong Lista"},
        /*64*/ {"Копировать", "Copy", "Kopyahin"},
        /*65*/ {"Необходимо выбрать юнитов, для отправок в набег\n", "You must select at least one type units to send \nthem into raid\n", "Dapat kang pumili ng isang uri ng mga yunit upang makapagnakaw\n"},
        /*66*/ {"Набег на ", "Raid to ", "Pagnakaw sa"},
        /*67*/ {" отправлен успешно", " sent successfully", " naipadala na"},
        /*68*/ {"Выберете деревню, для которой сформированы фарм-листы", "Select your village, where farm list's exist", "Pumili ng baryo, kung saan merong Farm List"},
        /*69*/ {"Внимание!", "Attention!", "Atensyon!"},
        /*70*/ {"Фарм по готовым листам не учитывает отчеты.", "Robot don't monitor report's when you use this option", "Robot, huwag basahin ang mga ulat pag ginamit ito"},
        /*71*/ {"Отмена", "Cancel", "Kanselahin"},
        /*72*/ {"OK", "OK", "OK"},
        /*73*/ {"Готовые листы", "Travian lists", "Listahan ng Travian"},
        /*74*/ {"У вас должен быть активирован Золотой клуб", "Gold club must be activated", "Dapat naka activate ang Gold Club"},
        /*75*/ {"Использовать настройки", "Use Preferences", "Paggamit Mga Kagustuhan"},
        /*76*/ {"Отправлять", "Send", "Ipadala"},
        /*77*/ {"юнитов", "units", "yunit"},
        /*78*/ {"Пожалуйста подождите...", "Please wait...", "Maghintay..."},
        /*79*/ {"Давай быстрее", "Let's quickly", "Bilisan natin"},
        //названия окон
        /*80*/ {"Выбор деревни", "Select village", "Pumili ng baryo"},
        /*81*/ {"Авторизация", "Authorization", "Pagpapahintulot"},
        /*82*/ {"Настройки", "Preferences", "Paggamit Mga Kagustuhan"},
        /*83*/ {"Новый фарм-лист", "New farm-list", "Panibagong Farm List"},
        /*84*/ {"Если население 0-20, отправлять", "If population 0-20, send", "Kung ang populasyon ay 0-20, ipadala"},
        /*85*/ {"Если население 21-50, отправлять", "If population 21-50, send", "Kung ang populasyon ay 21-50, ipadala"},
        /*86*/ {"Если население 51-100, отправлять", "If population 51-100, send", "Kung ang populasyon ay 51-100, ipadala"},
        /*87*/ {"Если население 101-200, отправлять", "If population 101-200, send", "Kung ang populasyon ay 101-200, ipadala"},
        /*88*/ {"Если население 201-400, отправлять", "If population 201-400, send", "Kung ang populasyon ay 201-400, ipadala"},
        /*89*/ {"Если население >400, отправлять", "If population >400, send", "Kung ang populasyon ay >400, ipadala"},
        /*90*/ {"Отправлять набеги каждые", "Send raids every", "Magpadala ng magnanakaw tuwing"},
        /*91*/ {"минут", "minutes", "minuto"},
        /*92*/ {"Только зеленые отчеты(", "Green reports only(", "Berdeng ulat lamang("},
        /*93*/ {"Включая желтые отчеты(", "Include yellow reports(", "Isama ang dilaw na ulat("},
        /*94*/ {"Все отчеты(", "All reports(", "Lahat ng ulat("},
        /*95*/ {"Сохранить", "Save", "iSave"},
        /*96*/ {"Данные успешно сохранены\n", "Data saved successfully\n", "Tagumpay na na-save ang data\n"},
        //поиск
        /*97*/ {"Включая тех, что состоят в альянсах", "Include those, who consist in ally", "Isama ang nasa alyansa"},
        /*98*/ {"Минимальное население игрока", "Minimum player's population", "Pinakamababang populasyon ng manlalaro"},
        /*99*/ {"Максимальное население игрока", "Maximum player's population", "Pinakamataas ng populasyon ng manlalaro"},
        /*100*/ {"Максимальное расстояние", "Maximum distance", "Pinakamalayo"},
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc=" 101 - 200 ">
        /*101*/ {"Минимальное расстояние", "Minimum distance", "Pinakamalapit"},
        /*102*/ {"для деревни", "for village", "para sa baryo"},
        /*103*/ {"Начать поиск", "Start search", "Simulang ang paghahanap"},
        /*104*/ {"Название листа", "Farm list name", "Pangalang ng Farm List"},
        /*105*/ {"Выберете юнита для фарма", "Select unit for farm", "Pumili ng yunit para sa pagnanakaw"},
        /*106*/ {"Далее", "Next", "Susunod"},
        /*107*/ {"Привет! Меня зовут Роман (Degradator) Смирнов. Я начинающий \nJava программист, и это мои первыйе работы. Мне 25 лет, \nи у меня есть высшее образование (к сожалению не IT).\n Если вы нашли какие-то ошибки, или хотите пригласить меня на\nработу, то напишите \n на этот ящик Degradator@bk.ru\n \nОтвечу так скоро, как смогу. ",
            "Hi! My name Roman (Degradator) Smirnov, I'm java junior developer.\nI'm 25 years old, and have high education (unfortunatly not IT).\nThis is my first programs.\nIf you find some bugs in my programs, or you want make work offer for\nme, please write to that email: Degradator@bk.ru\n\nI will answer as soon as possible.",
            "Hi! My name Roman (Degradator) Smirnov, I'm java junior developer.\nI'm 25 years old, and have high education (unfortunatly not IT).\nThis is my first programs.\nIf you find some bugs in my programs, or you want make work offer for\nme, please write to that email: Degradator@bk.ru\n\nI will answer as soon as possible.",},
        /*108*/ {"Добавить к таблице", "Add to table", "Idagdag sa hanayan"},
        /*109*/ {"Добавить в игру", "Add to game", "Idagdag sa laro"},
        /*110*/ {"Таблица 1", "Table 1", "Hanayan 1"},
        /*111*/ {"Таблица 2", "Table 2", "Hanayan 2"},
        /*112*/ {"Пожалуйста, подождите\n", "Please wait for a while\n", "Maghintay sandali\n"},
        /*113*/ {"", "", ""},
        /*114*/ {" деревень игрока ", " villages of ", " mga baryo ng "},
        /*115*/ {"Файл не содержит табличных данных", "File incorrect. Load another file.", "Mali ang File. Mag load ng panibagong file."},
        /*116*/ {"отправить не удалось\n", "failed\n", "Hindi tama\n"},
        /*117*/ {"Таблица изменена успешно\n", "Table data modified successful\n", "Tagumpay na nabago ang Hanayan\n"},
        /*118*/ {"Расстояния рассчитаны успешно\n", "Distances calculated successfuly\n", "Ang distansya ang nakalkula ng matagumpay\n"},
        /*119*/ {"", "", ""},
        /*120*/ {"Взята информация со страницы: ", "Informatioin gatheres from page: ", "Ang inpormasyon ay galing sa pahina: "},
        /*121*/ {"Объектов найдено: ", "Оbjects found: ", "Natagpuang mga gamit: "},
        /*122*/ {"Проверяем, подходят ли объекты под заданные критерии.\n", "Check the suitability of objects under selected criteria.\n", "Tingnan ang kaakmaan ng mga bagay sa ilalim ng napiling criteria.\n"},
        /*123*/ {"Работа с таблицей", "Work with table", "Gumawa tulong ang hanayan"},
        /*124*/ {"Искать все", "Search all", "Hanapin ang lahat"},
        /*125*/ {"Искать деревни", "Search villages", "Search villages"},
        /*126*/ {"Искать оазисы", "Search oasises", "Search oasises"},
        /*127*/ {"Включая оккупированные оазисы", "Include occupaded oasises", "Isama ang okupadong oasis"},
        /*128*/ {"Оазисы вверх", "oasises to top", "oasises pataas"},
        /*129*/ {"Деревни вверх", "Villages to top", "Baryo pataas"},
        /*130*/ {"Удалить оазисы", "Delete oasises", "Tanggaling ang oasis"},
        /*131*/ {"Удалить деревни", "Delete villages", "Burahin ang mga baryo"},
        /*132*/ {"Подтверждение", "Confirm", "Kumpirmahin"},
        /*133*/ {"Действительно удалить все оазисы? Отменить действие будет невозможно.",
            "Delete all oasises? You can't cancel this action in future.",
            "Tanggalin lahat ng mga oasises? Hindi mo maaaring kanselahin ang pagkilos na ito pagkatapos."},
        /*134*/ {"Действительно удалить все деревни? Отменить действие будет невозможно.",
            "Delete all villges? You can't cancel this action in future.",
            "Tanggalin lahat ng mga baryo? Hindi mo maaaring kanselahin ang pagkilos na ito sa hinaharap."},
        /*135*/ {"Таблица отсортирована.\n", "Table sorted.\n", "Naisa-ayos ang hanayan.\n"},
        /*136*/ {"Оазисы удалены.\n", "All oasises deleted\n", "Natanggal na ang mga oasis\n"},
        /*137*/ {"Деревни удалены\n", "Villages deleted\n", "Natanggal na ang mga baryo\n"},
        /*138*/ {"Зеленые отчеты", "Green reports", "Berdeng Ulat"},
        /*139*/ {"Желтые отчеты", "Yellow reports", "Dilaw na Ulat"},
        /*140*/ {"Все отчеты", "All reports", "Lahat ng Ulat"},
        /*141*/ {"Выберете список", "Select list", "Pumili ng listahan"},
        /*142*/ {"Фильтр отчетов", "Reports filter", "Salain ang Ulat"},
        /*143*/ {"Набег отправлен\n", "Raid sended\n", "Naipadala ang pagnakaw\n"},
        /*144*/ {"Список робота", "Robot list", "Listahan ng Robot"},
        /*145*/ {"Список аккаунта", "Accaunt list", "Listahan ng Account"},
        /*146*/ {"<-- переписать таблицу для этой деревни", "<-- rewrite table for that villy", "<-- Muling isulat ang hanayan para sa baryong ito"},
        /*147*/ {"Рассчитать расстояния", "Recalculate distances", "Kalkulahin muli ang distansya"},
        /*148*/ {"Мало юнитов для отправки рейда", "Too few units, to send them in raid", "Kalkulahin muli ang distansya"},
        /*149*/ {"Появились животные в ", "Animals appear in ", "Mga hayop ay lumitaw "},
        /*150*/ {"Включая деревни натар", "Include natar villages", "Isama ang mga baryo ng Natar"},
        /*151*/ {"сортировать по расстоянию", "Sort by distance", "Pagsunud-sunurin ayon sa distansya"},
        /*152*/ {"Отсортировано.", "Sorted", "Napagsunod-sunod"},
        /*153*/ {"Случайная задержка", "Random delay", "Pabago-bagong pag-antala"},
        /*154*/ {"В таблице нет строк\n", "There are no rows in table\n", "Walang hilere sa hanayan\n"},
        /*155*/ {"ДА", "YES", "OO"},
        /*156*/ {"НЕТ", "NO", "HINDI"},
        /*157*/ {"Закрыть окно?", "Close window?", "Isarado ang window?"},
        /*158*/ {"Где мы будем тренировать солдат?", "Where will we train soldiers?", "Saan magsasanay ng mga hukbo?"},
        /*159*/ {"Выбор деревни", "Village selection", "Pagpili ng baryo"},
        /*160*/ {"Каких солдат будем тренировать?", "What kind of units will we train?", "anong klaseng yunit ang aming sasanayin?"},
        /*161*/ {"Выбор солдат", "Soldiers choose", "Pumili ng hukbo"},
        /*162*/ {"Установите промежуток между циклами", "Set time between periods", "Itakda ang oras sa pagitan ng mga panahon"},
        /*163*/ {"Установите количество циклов", "Set periods count", "Itakda ang tagal ng bilang ng"},
        /*164*/ {"Бесконечно", "Unlimit", "Walang Limit"},
        /*165*/ {"Казарма", "Barrack", "Kwartel"},
        /*166*/ {"Конюшня", "Stables", "Kuwadra"},
        /*167*/ {"Мастерская", "WorkShop", "Talyer"},
        /*168*/ {"Большая казарма", "Large Barrack", "Malaking Kwartel"},
        /*169*/ {"Большая конюшня", "Large Stables", "Malaking Kuwadra"},
        /*170*/ {"Сколько солдат обучать между циклами?", "How much soldiers train between periods?", "Gaano karaming hukbo bawat panahon?"},
        /*171*/ {"Бандит", "Bandito", "Magnanakaw"},
        /*172*/ {"Сержант", "Sergeant", "Sarhento"},
        /*173*/ {"Торговец", "Merchant", "Mangangalakal"},
        /*174*/ {"Архитектор", "Architector", "Arkitekto"},
        /*175*/ {"Эвакуатор", "Evacuator", "Tiga-likas"},
        /*176*/ {"Из какой деревни отправлять?", "From what village send resources?", "Saang baryo manggagaling ang kayamanan?"},
        /*177*/ {"Куда пересылать?", "Where to send reso?", "Saan ipapadala ang kayamanan?"},
        /*178*/ {"Сколько ресурсов отправлять?", "How much reso to send?", "Gaano karaming kayamanan ang ipapadala?"},
        /*179*/ {"Все таблицы пусты\n", "All tables empty\n", "Walang laman ang lahat ng hanayan\n"},
        /*180*/ {"В какой деревне будем строить?", "Where will we construct?", "Saan kami gagawa?"},
        /*181*/ {"Ресурсные поля", "Reso fields", "Likas-yaman"},
        /*182*/ {"Центр деревни", "Village centre", "Gitnang baryo"},
        /*183*/ {"Тип сооружений", "Construction type", "Gitnang baryo"},
        /*184*/ {"Cтроим ресурсные поля", "Reso fields construction", "Konstruksyon sa likas-yaman"},
        /*185*/ {"Cтроим центр деревни", "Village center construction", "Konstruksyon sa gitnang baryo"},
        /*186*/ {"Что проверять?", "Select village for check.", "Pumili ng baryo sa pag tsek."},
        /*187*/ {"Весь аккаунт", "All accaunt", "Lahat ng account"},
        /*188*/ {"Спасать войско", "Save troops", "Iligtas ang hukbo"},
        /*189*/ {"Спасать ресурсы", "Save resources", "Iligtas ang kayamanan"},
        /*190*/ {"Куда пересылать ресурсы при атаке?", "Where hide reso when villy under attack?", "saan itatago ang kayamanan pag ang baryo ay inaatake?"},
        /*191*/ {"Куда прятать войско при атаке?", "Where hide troops when villy under attack?", "saan itatago ang hukbo pag ang baryo ay inaatake?"},
        /*192*/ {"Делать проверку каждые", "Make check each", "Gumawa ng tsek bawat isa"},
        /*193*/ {"Перерыв между проверками", "Break between checks", "Hatiin sa pamamagitan ng mga tsek"},
        /*194*/ {"Я использую \"Tavian +\"", "I use \"Travian +\"", "Ako ay gumagamit ng \"Travian Plus\""},
        /*195*/ {"Использовать звуковой сигнал", "Use sound signal", "Gumamit ng tunog para sa babala"},
        /*196*/ {"Тест сигнала", "Sound Test", "Sound Tsek"},
        /*197*/ {"***Обнаружена атака на оазис***\n", "***Oasis under attack***\n", "***Oasis ay inaatake***\n"},
        /*198*/ {"Оповещать при атаке оазиса", "Call, when oasis under attack", "Tumawag, kapag ang oasis ay inaatake"},
        /*199*/ {"Строительство в деревне ", "Construction in village ", "Konstruksyon sa baryo"},
        /*200*/ {" успешно.\n", " successful.\n", "Konstruksyon sa baryo"},
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc=" 201 - 300 ">
        /*201*/ {" не удалось\n", " failed\n", " nabigo\n"},
        /*202*/ {"К сожалению постройка с нуля не реализована. Извините :(\n", "Unfortunatly, construction from zero is not implemented. Sorry :(\n", "Paumanhin, ang konstruksyon mula sa zero ay hindi pinahihintulutan :(\n"},
        /*203*/ {"Проверять возможность постройки каждые ", "Check construction each ", "I-tsek ang bawat konstruksyon "},
        /*204*/ {"Не удалось воспроизвести тревогу.\n", "Cann't play alert sound.\n", "Hindi mapagana ang tunog pang alerto.\n"},
        /*205*/ {"Атака в деревне ", "Attack in village ", "Atake sa baryo "},
        /*206*/ {" не обнаружена\n", " not detected.\n", " hindi na detek.\n"},
        /*207*/ {"Атака на оазисы в деревне ", "Attack to oasises in village ", "Atake sa oasis ng baryo "},
        /*208*/ {" обнаружена!!!\n", " detected!!!\n", " detected!!!\n"},
        /*209*/ {"*****Эвакуатор*****", "*****Evakuator*****", "*****Tiga-likas*****"},
        /*210*/ {"*****Бандит*****", "*****Bandito*****", "*****Magnanakaw*****"},
        /*211*/ {"*****Торговец*****", "*****Merchant*****", "*****Mangangalakal*****"},
        /*212*/ {"*****Сержант*****", "*****Sergeant*****", "*****Sarhento*****"},
        /*213*/ {"*****Архитектор*****", "*****Architector*****", "*****Arkitekto*****"},
        /*214*/ {"Обучено ", "Train ", "Magsanay "},
        /*215*/ {"♫ выключить тревогу", "♫ alert mute ", "♫ tanggalin ang tunog"},
        /*216*/ {" объекта ", " object ", " bagay "},
        /*217*/ {"Попытка строительства ресурсного поля выше 10 уровня.\n Действительно продолжить?",
            "You try to construct reso field high than 10 level.\n Confirm?",
            "Ikaw ay sumusubok na gumawa ng higit sa lebel 10 na likas-yaman.\n Confirm?"},
        /*218*/ {"Старый лист", "Old list", "Lumang listahan"},
        /*219*/ {"Таймер", "Timer", "Orasan"},
        /*220*/ {"Звонить через ", "Ring throw ", "Oras ng pagtunog "},
        /*221*/ {"Примечание ", "Comment ", "Comment "},
        /*222*/ {"Открыт файл: ", "File opened: ", "File binuksan: "},
        //---------------------------------------------------------------------------------------------------------
        /*223*/ {"Изменить таблицу", "Modify table", "Ayusin ang table"},
        /*224*/ {"Случайная задержка для таймеров", "Random timers delay", "Irandom ang oras ng delay"},
        /*225*/ {"Замедление между переходами по ссылкам", "Slowdown among link redirecting", "pahinain ang pag redirekta sa mga link"},
        /*226*/ {"cекунд", "seconds", "segundo"},
        /*227*/ {"***!!!***\nНе удалось найти деревню с названием: ", "***!!!***\nCan't find village with name: ", "***!!!***\nHindi makita ang pangalan ng baryo "},
        /*228*/ {"Oбновить", "Refresh", "Refresh"},
        /*229*/ {"В результате обновления все данные таблиц Архитектора будут утеряны. Продолжить?",
            "If you will refresh, all architector data will be lost. Continue?",
            "pag iyong inirefresh, lahat ng architector data ay mawawala. Ipagpatuloy?"},
        /*230*/ {"Хотите продлить лицензию?", "You want to get license?", "You want to get license?"},
        /*231*/ {"Для продолжения, свяжитесь со мной:", "To continue, please get contact with me:", "To continue, please get contact with me:"},
        /*232*/ {"Для приобретения лицензии свяжитесь со мной:", "If you want to unlock full access, please notify me:", "Kung gusto mo ma unlock ang full access, magpatala sa akin:"},
        /*233*/ {"http://traviator.net/rus/Link.html", "http://traviator.net/eng/Link.html", "http://traviator.net/eng/Link.html"},
        /*234*/ {"Стоимость лицензии - 1$ 50с месяц (50 руб)", "License cost - 1$ 50с month", "License cost - 1$ 50с month"},
        /*235*/ {"13$ год (400 руб), 25$ навсегда (750руб).", "13$ year, 25$ lifetime", "13$ year, 25$ lifetime"},
        /*236*/ {"Внимание!", "Attention!", "Atensyon!"},
        /*237*/ {"В бесплатной версии программы, некоторые функции ограничены.", "There is some limits in a free version of program", "Mayroong limit ang pagamit sa program nang libre"},
        /*238*/ {"Эта таблица может содержать только ", "This table can contain only ", "Ang table ay maaring magkaroon lamang "},
        /*239*/ {" строк", " rows", " rows"},
        /*240*/ {"В бесплатной версии программы максимальное расстояние равно 10 клеткам.",
            "In free version maximum scan distance limited to 10 cells.",
            "Sa libreng version ang maximum scan distance ay limitado sa 10 cells lamang."},
        /*241*/ {"В бесплатной версии программы максимальное количество кормушек равно 20.",
            "In free version maximum farm count limited to 20.",
            "Sa libreng version ang maximum farm count ay limtitado sa 20 lamang."},
        /*242*/ {"В бесплатной версии программы максимальная очередь строительства 3.",
            "In free version maximum lenght of construction line 3.",
            "Sa libreng version ang maximum length ng construction line ay 3 lamang."},
        /*243*/ {"Не забудьте написать ваш ID!!!",
            "Don't forget write your ID!!!",
            "Wag kalimutan ilagay ang iyong ID!!!"},
        /*244*/ {"Обнаружена новая версия программы. Скачайте ее с сайта: http://traviator.net",
            "New version found. Download it from site: http://traviator.net",
            "May bagong version na natagpuan. idownload sa site na: http://traviator.net"},
        /*245*/ {"Только деревни Натар", "Only Natar villages", "Only Natar villages"},
        /*246*/ {"В какой деревне праздновать?", "Select village for celebrate.", "Select village for celebrate."},
        /*247*/ {"Обычное торжество", "Ordinar celebrate", "Maliit na pagdiriwang"},
        /*248*/ {"Большое торжество", "Greate celebrate", "Malaking pagdiriwang"},
        /*249*/ {"часов", "hours", "hours"},
        /*250*/ {"*****Ратуша*****", "*****Town Hall*****", "*****Bulwagan ng bayan*****"},
        /*251*/ {"Праздник не удался...\n", "Celebration failed...\n", "Celebration failed...\n"},
        /*252*/ {"Малый праздник удался!!!\n", "Small celebration successful!!!\n", "Small celebration successful!!!\n"},
        /*253*/ {"Большой праздник не удался!!!\n", "Greate celebration successful!!!\n", "Greate celebration successful!!!\n"},
        /*254*/ {"Мэрия", "City Hall", "Bulwagan"},
        /*---------------------------------------------------------------------------*/
        /*255*/ {"Текущее время", "Current time", "Current time"},
        /*256*/ {"Текущий период", "Current period", "Current period"},
        /*257*/ {"Новое время(минуты)", "New time(minutes)", "New time(minutes)"},
        /*258*/ {"Установить период(минуты)", "Set period(minutes)", "Set period(minutes)"},
        /*259*/ {"Без животных", "Without animals", "Without animals"},
        /*-------------------------------------------------------------*/
        /*260*/ {"Если у вас нет таблиц, начните сканировать", "If you have no tables, please scan at first", "If you have no tables, please scan at first"},
        /*261*/ {"Загрузите таблицы, для того чтобы найти", "Load tables, for searching", "Load tables, for searching"},
        /*262*/ {"неактивных игроков", "inacative players", "inacative players"},
        /*263*/ {"Загрузить таблицу 1", "Load 1st table", "Load 1st table"},
        /*264*/ {"Загрузить таблицу 1", "Load 2nd table", "Load 2nd table"},
        /*265*/ {"Сравнить", "Compare", "Compare"},
        /*266*/ {"Сканировать сейчас", "Scan now", "Scan now"},
        /*267*/ {"Скаут", "Scout", "Scout"},
        /*268*/ {"Найдено ", " pages found", " pages found"},
        /*269*/ {" страниц", "", ""},
        /*270*/ {"Искать начиная с ", "Search beginning from", "Search beginning from"},
        /*271*/ {" по ", " to ", " to "},
        /*272*/ {"(от большей к меньшей)", " to ", " to "},
        /*273*/ {"Начать", "Begin", "Begin"},
        /*274*/ {"Копировать в игру", "Copy to game", "Copy to game"},
        /*275*/ {"Копировать в бандита", "Copy to bandito", "Copy to bandito"},
        /*----------------------------------------------------------------------*/
        /*276*/ {"Вкладка \"Бандит\" управляет фармом. Фарм работает с золотым клубом "
            + "(ваши фарм листы) и без золотого клуба (фарм лист робота). Есть возможность "
            + "автоматически скопировать лист робота в лист аккаунта, и возможность поиска кормушек.\n",
            "\"Bandit\" tab will control your farm. You can send raids from your farm "
            + "lists (gold club) or from robot list (if you have no gold club). "
            + "Also, you can search for farms, and than copy robot list to game automatically.\n",
            "\"Bandit\" tab will control your farm. You can send raids from your farm "
            + "lists (gold club) or from robot list (if you have no gold club). "
            + "Also, you can search for farms, and than copy robot list to game automatically.\n"},
        /*277*/ {"  Вкладка \"Сержант\" управляет обучением войск.\n",
            "  \"Sergreant\" tab will control your troops train.\n",
            "  \"Sergreant\" tab will control your troops train.\n"},
        /*278*/ {"  Вкладка \"Торговец\" будет пересылать ресурсы из одной деревни в другую. Если у вас есть золотой клуб, вы при помощи этой вкладки можно создать торговые маршруты.\n",
            "  \"Merchant\" tab will send reso from one village to another. If you have gold club, you can make trade routes for your village with this tab.\n",
            "  \"Merchant\" tab will send reso from one village to another. If you have gold club, you can make trade routes for your village with this tab.\n"},
        /*279*/ {"  Вкладка \"Архитектор\" управляет очередью постройки во всех деревнях.\n",
            "  \"Architector\" tab will control your construction line in all villages.\n",
            "  \"Architector\" tab will control your construction line in all villages.\n"},
        /*280*/ {"  Вкладка \"Эвакуатор\" подаст сигнал во время атаки, и спрячет войска и ресурсы.\n",
            "  \"Evacuator\" tab will detect attack and notify you. Also, it will hide reso and troops.\n",
            "  \"Evacuator\" tab will detect attack and notify you. Also, it will hide reso and troops.\n"},
        /*281*/ {"  Вкладка \"Таймер\" это просто будильник, нужный только для игрока.\n",
            "  \"Timer\" tab it's just a sound alarm for user.\n",
            "  \"Timer\" tab it's just a sound alarm for user.\n"},
        /*282*/ {"  Вкладка \"Мэрия\" выполняет несколько функций. Первая - праздники, обыкновенные и большие. "
            + "Вторая - усовершенствованием солдат в кузнице. И треться функция - приключения героя.\n",
            "  \"City Hall\" tab will control 3 function. At first, it's village celebrations. Second - upgrades "
            + "of your units in blacksmith. And last function - hero adventures.\n",
            "  \"City Hall\" tab will control 3 function. At first, it's village celebrations. Second - upgrades "
            + "of your units in blacksmith. And last function - hero adventures.\n"},
        /*283*/ {"  Вкладка \"Скаут\" найдет брошенные аккаунты.\n"
            + "Для поиска брошенных аккаунтов, вам понадобится запустить его дважды, с интервалом в дня два-три. "
            + "После каждого сканирования, ТАБЛИЦУ СКАУТА НУЖНО СОХРАНИТЬ. Когда у вас будет 2 таблицы "
            + "то их надо сравнить, и, игроки, чье население не изменилось, будут сохранены в таблице скаута "
            + "после чего полученную таблицу можно автоматически скопировать в таблицу робота, или в аккаунт, если "
            + "у вас есть золотой клуб\n\n"
            + "Кроме этого вы можете воспользоваться сайтом http://travian.ws/. "
            + "Нажмите кнопку Анализатор и вставте ссылку на страницу с неактивом сервера.",
            "\"Scout\" tab will find dead accaunts in server.\n"
            + "For this operation, you must scan server twice, with 1-2 days for break. "
            + "After each scan, you will have table with players and with population. "
            + "DON'T FORGET TO SAVE TABLE!"
            + "When you will have 2 tables, just compare them. Robot will delete all active "
            + "players. Than you can copy inactive players to robbot list, or to accaunt list "
            + "if you have gold club.\n\n"
            + "Also, you can use Travian World analizator site: http://travian.ws/. "
            + "Press WorldAnalizator button and paste link with server inacive",
            "\"Scout\" tab will find dead accaunts in server.\n"
            + "For this operation, you must scan server twice, with 1-2 days for break. "
            + "After each scan, you will have table with players and with population. "
            + "DON'T FORGET TO SAVE TABLE! "
            + "When you will have 2 tables, just compare them. Robot will delete all active "
            + "players. Than you can copy inactive players to robbot list, or to accaunt list "
            + "if you have gold club.\n\n"
            + "Also, you can use Travian World analizator site: http://travian.ws/. "
            + "Press WorldAnalizator button and paste link with server inacive"},
        /*284*/ {"Проверьте название сервера на ошибки.",
            "Check server name for errors",
            "Check server name for errors"},
        /*285*/ {"Показывать подсказки",
            "Show tips",
            "Show tips"},
        /*286*/ {"В какой деревне сносить?",
            "Where will you demolish?",
            "Where will you demolish?"},
        /*287*/ {"Проверять каждые",
            "Check each ",
            "Check each "},
        /*288*/ {"Что сносить?",
            "What construction will be demolished?",
            "What construction will be demolished?"},
        /*289*/ {"Нельзя сносить больше одного здания за раз.\n",
            "Please wait for demolishing last task.\n",
            "Please wait for demolishing last task.\n"},
        /*290*/ {"*****Архитектор*****(снос)\n",
            "*****Architector*****(demolish)\n",
            "*****Architector*****(demolish)\n"},
        /*291*/ {"Cнесен один уровень (",
            "One level demolished (",
            "One level demolished ("},
        /*292*/ {"Здание снесено (",
            "Building demoilished totally(",
            "Building demoilished totally("},
        /*293*/ {"Снос зданий",
            "Building demoilish",
            "Building demoilish"},
        /*294*/ {"Управление праздниками",
            "Celebration managment",
            "Celebration managment"},
        /*295*/ {"Управление кузницей",
            "Blacksmith managment",
            "Blacksmith managment"},
        /*296*/ {"Выберете юнита для улучшения",
            "Select unit for upgrade",
            "Select unit for upgrade"},
        /*297*/ {"Выберете деревню, где совершать улучшения",
            "Select village for units upgrade",
            "Select village for units upgrade"},
        /*298*/ {"Совершить улучшение ",
            "Make upgrade",
            "Make upgrade"},
        /*299*/ {" раз",
            " times",
            " times"},
        /*300*/ {"*****Кузница*****", "*****Blacksmith*****", "*****Blacksmith*****"},
        //</editor-fold>
        /*301*/ {"Юнит ", "Unit ", "Unit "},
        /*302*/ {" в деревне ", " in village ", " in village "},
        /*303*/ {" был улчшен в кузнице на один уровень\n", " was upgraded in your blacksmith\n", " was upgraded in your blacksmith\n"},
        /*304*/ {"Апгрейд юнита (", "Unit upgrade (", "Unit upgrade ("},
        /*305*/ {" не удался.\n", " failed\n", " failed\n"},
        /*306*/ {"Отправлять на приключения", "Send hero to adventures", "Send hero to adventures"},
        /*307*/ {"Отправлять на сложные", "Send to difficult adventures", "Send to difficult adventures"},
        /*308*/ {"Отправлять каждые ", "Send each ", "Send each "},
        /*309*/ {"       До отправки оталось ", "       Time to adventure check ", "       Time to adventure check "},
        /*310*/ {"Внимание! Выбрана функция отправки на трудные приключения, при выключенной функции отправки на простые приключения.\n",
            "Attention! \"Difficult adventures\" functioin selected, but \"normal adventures\" functioin deselected.\n",
            "Attention! \"Difficult adventures\" functioin selected, but \"normal adventures\" functioin deselected.\n"},
        /*311*/ {"*****Приключения*****", "*****Adventures*****", "*****Adventures*****"},
        /*312*/ {"Герой отправлен на поиски приключений!\n", "Hero go for adventures!\n", "Hero go for adventures!\n"},
        /*313*/ {"Новых приключений не найдено.\n", "There is no new adventure.\n", "There is no new adventure.\n"},
        /*314*/ {"Ускорение таймеров (для серверов Х10, Х100, Х1000)", "Timers accelerate (for servers Х10, Х100, Х1000)", "Timers accelerate (for servers Х10, Х100, Х1000)"},
        /*315*/ {"Из какой деревни отправить атаку?", "Where the attack should be sent from?", "Where the attack should be sent from?"},
        /*316*/ {"Сколько волн будет в этой атаке?", "How much waves will be in this attack?", "How much waves will be in this attack?"},
        /*317*/ {"Атака будет отправлена через ", "Attack will be sended after ", "Attack will be sended after "},
        /*318*/ {"Настройка атаки. Волна: ", "Attack options. Wave: ", "Attack options. Wave: "},
        /*319*/ {"Выберете, сколько зданий атаковать: ", "Select targets count for catas: ", "Select targets count for catas: "},
        /*320*/ {"Установите координаты атаки: ", "Set coordinates for attack: ", "Set coordinates for attack: "},
        /*321*/ {"*****Атака*****", "*****Attack*****", "*****Attack*****"},
        /*322*/ {"Подготовлена волна: ", "Wave has been prepared: ", "Wave has been prepared: "},
        /*323*/ {"Отправить все запланированные атаки сейчас?", "Send all planned attacks now?", "Send all planned attacks now?"},
        /*324*/ {" Вкладка \"Генерал\" поможет вам запланировать атаку на любого игрока из любой вашей деревни в несколько волн в секунду\n",
            " \"Warlord\" tab will send multiwave attack to any player of server from any village of your accaunt.\n",
            " \"Warlord\" tab will send multiwave attack to any player of server from any village of your accaunt.\n"},
        /*325*/ {"В выбранной деревне, во время отправки волны ",
            "In selected village, in wave ", "In selected village, in wave "},
        /*326*/ {" не был найде юнит (если t11 то это герой) - ",
            " one type of units was not found (t11 = hero) - ",
            " one type of units was not found (t11 = hero) - "},
        /*327*/ {"Неверно заданы координаты.\n",
            "There is a mistake in target coordinates.\n",
            "There is a mistake in target coordinates.\n"},
        /*328*/ {"Волна № ", "Wave № ", "Wave № "},
        /*329*/ {" была отправлена в ", " was sended in ", " was sended in "},
        /*330*/ {"Генерал", "Warlord", "Warlord"},
        /*331*/ {"Список деревень не соответствует заданиям архитектора. Задания архитектора установлены по умолчанию.\n",
            "Village list not accortding to Architector's task list. Architextors task list set as default.\n",
            "Village list not accortding to Architector's task list. Architextors task list set as default.\n"},
        /*332*/ {"Строить автоматически во всех деревнях", "Build automatically in all villages", "Build automatically in all villages"},
        /*333*/ {"Установлено автоматическое строительство. Архитектор будет строить 2 уровня амбара и склада и "
            + "один уровень главного здания на каждый уровень ресурсных полей. В результате ваша деревня будет иметь "
            + "десятый уровень ресурсных полей, десятый уровень главного здания и 18 уровень амбара и склада.\n",
            "Automatic construction ON. Architector will construct one level of main building, two levels of "
            + "your store and granary for one level of each level your reso fields. In result, you will have"
            + "village with all reso fields level 10, store and granary level 18 and main building level 1.\n",
            "Automatic construction ON. Architector will construct one level of main building, two levels of "
            + "your store and granary for one level of each level your reso fields. In result, you will have"
            + "village with all reso fields level 10, store and granary level 18 and main building level 1.\n"},
        /*334*/ {"Автоматическое строительство отменено.\n", "Automatic construction OFF.\n", "Automatic construction OFF.\n"},
        /*335*/ {"Автоматическое строительство", "Automatic construction", "Automatic construction"},
        /*336*/ {"Не удалось войти в аккаунт при первом запуске. Вы уверены, что ввели верные данные?",
            "Program can't enter in your accaunt in first time. Are you sure in property of authorisation data?",
            "Program can't enter in your accaunt in first time. Are you sure in property of authorisation data?"},
        /*337*/ {"Увести", "Hide", "Hide"},
        /*338*/ {"Оставить", "Stay", "Stay"},
        /*339*/ {"Дождитесь окончания загрузки, и только потом начинайте работу с программой. "
            + "Сигналом о завершении будет появление надписи \"Загрузка завершена\"\n",
            "Wait when program will completely load, and only after it start to work with a program and browser."
            + " Bot will write \"Loading complete\" when it log in.\n",
            "Wait when program will completely load, and only after it start to work with a program and browser."
            + " Bot will write \"Loading complete\" when it log in.\n"},
        /*340*/ {"Новая кормушка добавлена успешно.\n", "New farm added successful.\n", "New farm added successful.\n"},
        /*341*/ {"Для этого рейда недостаточно юнитов.", "You have no units for this raid.", "You have no units for this raid."},
        /*342*/ {"Расширенная таблица  ", "Extended table  ", "Extended table  "},
        /*343*/ {"Маршруты будут созданы на каждый час.", "Trade routes will be created for each hour", "Trade routes will be created for each hour"},
        /*344*/ {"Сколько отправок выполнять в час?", "How much time send ", "Extended table  "},
        /*345*/ {"Успешно создан маршурт для часа: ", "Trade route was created successfully for hour: ", "Trade route was created successfully for hour: "},
        /*346*/ {"Показывать сообщения об ошибках", "Show error messages", "Show error messages"},
        /*347*/ {"Показывать счет отладчика", "Show debug count", "Show debug count"},
        /*348*/ {"Использовать браузер для Генерала: ", "Use browser for warlord: ", "Use browser for warlord: "},
        /*349*/ {"Торговые маршруты", "Trade routes", "Trade routes"},
        /*350*/ {"!!! Слоны найдены в оазисе: ", "!!! Bot find some elephants in oasis: ", "!!! Bot find some elephants in oasis: "},
        /*351*/ {"Отключить сообщения бандита (листы робота)", "Switch off bandito messages(robot lists)", "Switch off bandito messages(robot lists)"},
        /*352*/ {"Всего записей в анализаторе: ", "Total rows in analiztor: ", "Total rows in analiztor: "},
        /*353*/ {"Ищу неактив: \n", "Search for inactive: \n", "Search for inactive: \n"},
        /*354*/ {"Анализатор", "World analizer", "World analizer"},
        /*355*/ {"Добавте ссылку с сайта \"Travian World Analizator\" в таком виде: ",
            "Add link from site \"Travian World Analizator\" in that form: ",
            "Add link from site \"Travian World Analizator\" in that form: "},
        /*356*/ {"Пауза", "Pause", "Pause"},
        /*357*/ {"Продолжить", "Continue", "Continue"},
        /*358*/ {"Строительство", "Constuction", "Construcion"},
        /*359*/ {"Здания", "Constuction", "Construcion"},
        /*360*/ {"Зеленые боевые отчеты", "Green battle reports", "Green battle reports"},
        /*361*/ {"Зеленые боевые отчеты", "Green battle reports", "Green battle reports"},
        /*362*/ {"Зеленые боевые отчеты", "Green battle reports", "Green battle reports"},
        /*363*/ {"Зеленые отчеты разведки", "Green scout reports", "Green scout reports"},
        /*364*/ {"Зеленые отчеты разведки", "Green scout reports", "Green scout reports"},
        /*365*/ {"Зеленые отчеты разведки", "Green scout reports", "Green scout reports"},
        /*366*/ {"Торговые отчеты", "Trade reports", "Trade reports"},
        /*367*/ {"Отчеты о приключениях", "Adventure reports", "Adventure reports"},
        /*368*/ {"секунд", "seconds", "seconds"},};
//<editor-fold defaultstate="collapsed" desc="названия архитектора">
    public static String architectorColumnNames[][] = new String[][]{
        {"Объект", "Object", "Bagay"},
        {"Уровень", "level", "lebel"},};
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="названия бандита">
    public static final String[][] banditoTables = new String[][]{
        /*0*/{"Из деревни", "From villy", "mula sa Baryo"},
        /*1*/ {"Цель", "Target", "Target"},
        /*2*/ {"Игрок", "Player", "Manlalaro"},
        /*3*/ {"Альянс", "Ally", "Alyansa"},
        /*4*/ {"Расстояние", "Distance", "Distansya"},
        /*5*/ {"Население", "Population", "Populasyon"},
        /*6*/ {"Координаты", "Coordinates", "Coordinates"},//not mistake!!!
        /*7*/ {"Название листа", "Farm list name", "Pangalang ng Farm List"},
        /*8*/ {"Фильтр", "Filter", "Pagsala"},
        /*9*/ {"Время", "Time", "Oras"},
        /*10*/ {"Период", "Period", "Panahon"},};
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="названия sergant">
    public static String sargeColumnNames[][] = new String[][]{
        {"В", "To", "Papunta"},
        {"Юнит", "Unit", "Hukbo"},
        {"Количество", "Units count", "Bilang ng hukbo"},
        {"Период", "Period", "Panahon"},
        {"Время", "Time", "Oras"},
        {"Циклов", "Cycles", "Cycles"},};
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="названия торговец">
    public static String marketColumnNames[][] = new String[][]{
        {"из", "from", "galing sa"},
        {"в", "to", "papunta sa"},
        {"лес", "wood", "troso"},
        {"глина", "clay", "putik"},
        {"железо", "iron", "bakal"},
        {"зерно", "crop", "pananim"},
        {"время", "time", "oras"},
        {"отправок", "count", "bilang"},
        {"период", "period", "panahon"},
        {"координаты", "coord", "coord"},};
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="названия эвакуатор">
    public static String evadeColumnNames[][] = new String[][]{
        {"Время", "time", "oras"},
        {"Ресурсы", "Reso", "kayamanan"},
        {"Солдаты", "Troops", "hukbo"},
        {"Период", "period", "panahon"},};
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="названия скаут">
    static String scoutColumnNames[][] = new String[][]{
        {"Игрок", "Player", "Player"},
        {"Альянс", "Ally", "Ally"},
        {"Население", "Population", "Population"},};
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="названия праздники">
    static String celebNames[][] = new String[][]{
        {"Деревня", "Village", "Baryo"},
        {"Тип", "Type", "Type"},
        {"Таймер", "Timer", "Timer"},
        {"Period", "Period", "Period"},};
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="названия кузня">
    static String blackSmithNames[][] = new String[][]{
        {"Деревня", "Village", "Baryo"},
        {"Юнит", "Unit", "Unit"},
        {"Уровень", "Level", "Level"},
        {"Таймер", "Timer", "Timer"},
        {"Period", "Period", "Period"},};
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="солдаты">
    public static String[][][] units = new String[][][]{
        {
            /*1*/{"Легионер", "Legioner", "Legioner"},
            /*2*/ {"Преторианец", "Praetorian", "Praetorian"},
            /*3*/ {"Империанец", "Imperrian", "Imperrian"},
            /*4*/ {"Конный разведчик", "Equites Legati", "Equites Legati"},
            /*5*/ {"Конница императора", "Equites Imperatoris", "Equites Imperatoris"},
            /*6*/ {"Конница цезаря", "Equites Caesaris", "Equites Caesaris"},
            /*7*/ {"Таран", "Battering Ram", "Battering Ram"},
            /*8*/ {"Огненная катапульта", "Fire catapult", "Fire catapult"},
            /*9*/ {"Сенатор", "Senator", "Senator"},
            /*10*/ {"Поселенец", "Settler", "Settler"}
        },
        /*1*/ {{"Дубинщик", "Clubswinger", "Clubswinger"},
            /*2*/ {"Копейщик", "Spearman", "Clubswinger"},
            /*3*/ {"Топорщик", "Axeman", "Axeman"},
            /*4*/ {"Разведчик", "Scout", "Scout"},
            /*5*/ {"Паладин", "Palladin", "Palladin"},
            /*6*/ {"Тевтонская конница", "Teuton Knight", "Teuton Knight"},
            /*7*/ {"Таран", "Ram", "Ram"},
            /*8*/ {"Катапульта", "Catapult", "Catapult"},
            /*9*/ {"Вождь", "Chief", "Chief"},
            /*10*/ {"Поселенец", "Settler", "Settler"},},
        /*1*/ {{"Фаланга", "Phalanx", "Phalanx"},
            /*2*/ {"Мечник", "Swordsman", "Swordsman"},
            /*3*/ {"Следопыт", "Pathfinder", "Pathfinder"},
            /*4*/ {"Тевтатский Гром", "Theutates Thunder", "Theutates Thunder"},
            /*5*/ {"Друид", "Druid", "Druid"},
            /*6*/ {"Эдуйская Конница", "Haeduan", "Haeduan"},
            /*7*/ {"Таран", "Ram", "Ram"},
            /*8*/ {"Требучет", "Trebuchet", "Trebuchet"},
            /*9*/ {"Предводитель", "Chieftan", "Chieftan"},
            /*10*/ {"Поселенец", "Settler", "Settler"}
        },
        {{"Герой", "Hero", "Hero",}}
    };
//</editor-fold>
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel(natiPic[4][1]);
        jLabel7 = new javax.swing.JLabel(natiPic[4][0]);
        jLabel9 = new javax.swing.JLabel(natiPic[4][8]);
        profile = new javax.swing.JLabel();
        allyance = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        buttonSound = new javax.swing.JButton();
        buttonAllNow = new javax.swing.JButton();
        buttonStart = new javax.swing.JToggleButton();
        jPanel14 = new javax.swing.JPanel();
        buttonLogin = new javax.swing.JButton(natiPic[4][22]);
        refreshButton = new javax.swing.JButton(natiPic[4][21]);
        tabbedMainPanel = new javax.swing.JTabbedPane();
        BanditoTables = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove1 = new javax.swing.JButton(natiPic[4][14]);
        buttonPreferences1 = new javax.swing.JButton(natiPic[4][19]);
        jScrollPane2 = new javax.swing.JScrollPane();
        banditoListTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        banditoTable = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        checkBoxBanditoExtend = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        textFieldHours = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textFieldMinutes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textFieldSec = new javax.swing.JTextField();
        farmTroop = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        buttonNewList = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove = new javax.swing.JButton(natiPic[4][14]);
        buttonCopyToTravian = new javax.swing.JButton(natiPic[4][16]);
        buttonPreferences = new javax.swing.JButton(natiPic[4][19]);
        buttonModify = new javax.swing.JButton(natiPic[4][23]);
        SargePane = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sargeTable = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        buttonAddProgram = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove2 = new javax.swing.JButton(natiPic[4][14]);
        MerchPane = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        marketTable = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        buttonAddProgram1 = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove3 = new javax.swing.JButton(natiPic[4][14]);
        buttonTradeRoutes = new javax.swing.JButton(natiPic[4][33]);
        archTab = new javax.swing.JTabbedPane();
        ArchPane = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        archTable = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        textFieldArchTime = new javax.swing.JTextField();
        labelArchTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textFieldArchPeriod = new javax.swing.JTextField();
        labelArchPeriod = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        comboBoxArcVillages = new javax.swing.JComboBox();
        buttonArchAdd = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove4 = new javax.swing.JButton(natiPic[4][14]);
        checkBoxAutoBuild = new javax.swing.JCheckBox();
        ArchPane1 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        archTable3 = new javax.swing.JTable();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        textFieldArchTime2 = new javax.swing.JTextField();
        labelArchTime2 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        textFieldArchPeriod2 = new javax.swing.JTextField();
        labelArchPeriod2 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel53 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jPanel54 = new javax.swing.JPanel();
        comboBoxArcVillagesDouble = new javax.swing.JComboBox();
        buttonArchAdd1 = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove7 = new javax.swing.JButton(natiPic[4][14]);
        checkBoxAutoBuild1 = new javax.swing.JCheckBox();
        demolish = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        archTable1 = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        comboBoxArcVillagesDemolish = new javax.swing.JComboBox();
        buttonDemolishAdd1 = new javax.swing.JButton(natiPic[4][13]);
        buttonDemolishRemove = new javax.swing.JButton(natiPic[4][14]);
        jPanel37 = new javax.swing.JPanel();
        demolishTimeTF = new javax.swing.JTextField();
        labelDemolishTime = new javax.swing.JLabel();
        demolishPeriodTF = new javax.swing.JTextField();
        labelDemolishPeriod = new javax.swing.JLabel();
        EvaPane = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        evadeTable = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton(natiPic[4][13]);
        jButton4 = new javax.swing.JButton(natiPic[4][14]);
        checkBoxTravianPlus = new javax.swing.JCheckBox();
        buttonPreferences3 = new javax.swing.JButton(natiPic[4][19]);
        jPanel28 = new javax.swing.JPanel();
        checkBoxSound = new javax.swing.JCheckBox();
        checkBoxOaseSound = new javax.swing.JCheckBox();
        jPanel29 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        TimerPane = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        timerTable = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton(natiPic[4][13]);
        jButton6 = new javax.swing.JButton(natiPic[4][14]);
        comboboxTimer = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        buttonStart1 = new javax.swing.JToggleButton();
        HallPane = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        buttonAddProgram2 = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove5 = new javax.swing.JButton(natiPic[4][14]);
        jLabel2 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        celebrateTable = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        buttonAddProgram3 = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove8 = new javax.swing.JButton(natiPic[4][14]);
        jLabel3 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        blackSmtithTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        checkBoxAdventure = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        checkBoxHard = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        labelSendEach = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        labelMin1 = new javax.swing.JLabel();
        labelTimeToadventure = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        ScoutPane = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        scoutTable = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        buttonGatherInfo = new javax.swing.JButton(natiPic[4][17]);
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        analizator = new javax.swing.JButton(natiPic[4][32]);
        buttonRemove6 = new javax.swing.JButton(natiPic[4][14]);
        buttonPreferences2 = new javax.swing.JButton(natiPic[4][19]);
        jLabel20 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        buttonCopyToTravian1 = new javax.swing.JButton(natiPic[4][16]);
        buttonAddToBandito = new javax.swing.JButton(natiPic[4][16]);
        jLabel17 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton(natiPic[4][15]);
        jPanel9 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        buttonAddProgram4 = new javax.swing.JButton(natiPic[4][13]);
        buttonRemove9 = new javax.swing.JButton(natiPic[4][14]);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuOpen = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jPanel12.setPreferredSize(new java.awt.Dimension(644, 90));

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allyance, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(allyance, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        buttonSound.setText("sound");
        buttonSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSoundActionPerformed(evt);
            }
        });
        jPanel7.add(buttonSound);

        buttonAllNow.setText(MainWindow.messages[36][MainWindow.language]);
        buttonAllNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAllNowActionPerformed(evt);
            }
        });
        jPanel7.add(buttonAllNow);

        buttonStart.setText("jToggleButton1");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });
        jPanel7.add(buttonStart);

        jPanel14.setPreferredSize(new java.awt.Dimension(246, 56));

        buttonLogin.setText(MainWindow.messages[29][MainWindow.language]);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        refreshButton.setText("jButton7");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(buttonLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonLogin)
                .addComponent(refreshButton))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel12);

        tabbedMainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        tabbedMainPanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedMainPanel.setToolTipText("");
        tabbedMainPanel.setPreferredSize(new Dimension(750, 350));
        tabbedMainPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedMainPanelStateChanged(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton1.setText(messages[108][language]);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton1);

        buttonRemove1.setText(MainWindow.messages[28][MainWindow.language]);
        buttonRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemove1ActionPerformed(evt);
            }
        });
        jPanel16.add(buttonRemove1);

        buttonPreferences1.setText(messages[82][language]);
        buttonPreferences1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreferences1ActionPerformed(evt);
            }
        });
        jPanel16.add(buttonPreferences1);

        jPanel4.add(jPanel16, java.awt.BorderLayout.PAGE_START);

        banditoListTable.setModel(banditoListModel);
        banditoListTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(banditoListTable);
        banditoListModel.addColumn("villy Name");
        banditoListModel.addColumn("farm list");
        banditoListModel.addColumn("filter");
        banditoListModel.addColumn("timer");
        banditoListModel.addColumn("period");

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        BanditoTables.addTab("tab3", jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        banditoTable.setModel(banditoModel);
        banditoTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(banditoTable);
        banditoModel.addColumn("from");             //0
        banditoModel.addColumn("Player/to/Ally");   //1
        banditoModel.addColumn("road/population");  //2
        banditoModel.addColumn("coord");            //3

        banditoListModelE.addColumn("from");           //0
        banditoListModelE.addColumn("Player/to/ally"); //1(villageName, oasis)
        banditoListModelE.addColumn("troops");         //2
        banditoListModelE.addColumn("road/population");//3
        banditoListModelE.addColumn("coord");          //4
        banditoListModelE.addColumn("timer");          //5
        banditoListModelE.addColumn("period");         //6

        Dimension d = new Dimension(600, 180);
        banditoTable.setPreferredScrollableViewportSize(d);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel18.setLayout(new java.awt.BorderLayout());

        checkBoxBanditoExtend.setText("Расширить");
        checkBoxBanditoExtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxBanditoExtendActionPerformed(evt);
            }
        });
        jPanel18.add(checkBoxBanditoExtend, java.awt.BorderLayout.EAST);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textFieldHours.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldHours.setPreferredSize(timerDim);
        jPanel10.add(textFieldHours);

        jLabel5.setText(":");
        jPanel10.add(jLabel5);

        textFieldMinutes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldMinutes.setPreferredSize(timerDim);
        jPanel10.add(textFieldMinutes);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText(":");
        jPanel10.add(jLabel6);

        textFieldSec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldSec.setPreferredSize(timerDim);
        jPanel10.add(textFieldSec);
        jPanel10.add(farmTroop);

        jPanel18.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        buttonNewList.setText(messages[63][language]);
        buttonNewList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewListActionPerformed(evt);
            }
        });
        jPanel19.add(buttonNewList);

        buttonRemove.setText(MainWindow.messages[28][MainWindow.language]);
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });
        jPanel19.add(buttonRemove);

        buttonCopyToTravian.setText(messages[64][language]);
        buttonCopyToTravian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCopyToTravianActionPerformed(evt);
            }
        });
        jPanel19.add(buttonCopyToTravian);

        buttonPreferences.setText(messages[82][language]);
        buttonPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreferencesActionPerformed(evt);
            }
        });
        jPanel19.add(buttonPreferences);

        buttonModify.setText("jButton7");
        buttonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyActionPerformed(evt);
            }
        });
        jPanel19.add(buttonModify);

        jPanel18.add(jPanel19, java.awt.BorderLayout.SOUTH);

        jPanel17.add(jPanel18, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        BanditoTables.addTab("tab3", jPanel5);

        tabbedMainPanel.addTab("бандито", natiPic[4][26], BanditoTables);

        SargePane.setLayout(new java.awt.BorderLayout());

        sargeTable.setModel(sergeantModel);
        sargeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(sargeTable);

        SargePane.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        buttonAddProgram.setText(MainWindow.messages[27][MainWindow.language]);
        buttonAddProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProgramActionPerformed(evt);
            }
        });
        jPanel15.add(buttonAddProgram);

        buttonRemove2.setText(MainWindow.messages[28][MainWindow.language]);
        buttonRemove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemove2ActionPerformed(evt);
            }
        });
        jPanel15.add(buttonRemove2);

        SargePane.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        tabbedMainPanel.addTab("сержант", natiPic[4][27], SargePane, "");

        MerchPane.setLayout(new java.awt.BorderLayout());

        marketTable.setModel(merchModel);
        marketTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(marketTable);

        MerchPane.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        buttonAddProgram1.setText(MainWindow.messages[27][MainWindow.language]);
        buttonAddProgram1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProgram1ActionPerformed(evt);
            }
        });
        jPanel20.add(buttonAddProgram1);

        buttonRemove3.setText(MainWindow.messages[28][MainWindow.language]);
        buttonRemove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemove3ActionPerformed(evt);
            }
        });
        jPanel20.add(buttonRemove3);

        buttonTradeRoutes.setText("создать маршруты");
        buttonTradeRoutes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTradeRoutesActionPerformed(evt);
            }
        });
        jPanel20.add(buttonTradeRoutes);

        MerchPane.add(jPanel20, java.awt.BorderLayout.PAGE_START);

        tabbedMainPanel.addTab("мерч", natiPic[4][28], MerchPane);

        ArchPane.setLayout(new java.awt.BorderLayout());

        jPanel22.setLayout(new java.awt.BorderLayout());

        archTable.setModel(architectorModel);
        archTable.getTableHeader().setReorderingAllowed(false);
        architectorModel.addColumn(architectorColumnNames[0][language]);
        jScrollPane5.setViewportView(archTable);

        jPanel22.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel24.setLayout(new javax.swing.BoxLayout(jPanel24, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textFieldArchTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldArchTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldArchTimeFocusLost(evt);
            }
        });
        jPanel1.add(textFieldArchTime);
        textFieldArchTime.setPreferredSize(largeDim);

        labelArchTime.setText("текущее время");
        labelArchTime.setPreferredSize(largeDim);
        jPanel1.add(labelArchTime);

        jPanel24.add(jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textFieldArchPeriod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldArchPeriod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldArchPeriodFocusLost(evt);
            }
        });
        jPanel2.add(textFieldArchPeriod);
        textFieldArchPeriod.setPreferredSize(largeDim);

        labelArchPeriod.setText("текущий период");
        jPanel2.add(labelArchPeriod);

        jPanel24.add(jPanel2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton8.setText("/\\");
            jButton8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton8ActionPerformed(evt);
                }
            });
            jPanel11.add(jButton8);

            jPanel3.add(jPanel11);

            jPanel30.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

            jButton9.setText("\\/");
            jButton9.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton9ActionPerformed(evt);
                }
            });
            jPanel30.add(jButton9);

            jPanel3.add(jPanel30);

            jPanel24.add(jPanel3);

            jPanel22.add(jPanel24, java.awt.BorderLayout.EAST);

            ArchPane.add(jPanel22, java.awt.BorderLayout.CENTER);

            jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

            comboBoxArcVillages.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            comboBoxArcVillages.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    comboBoxArcVillagesItemStateChanged(evt);
                }
            });
            jPanel21.add(comboBoxArcVillages);

            buttonArchAdd.setText("jButton3");
            buttonArchAdd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonArchAddActionPerformed(evt);
                }
            });
            jPanel21.add(buttonArchAdd);

            buttonRemove4.setText(MainWindow.messages[28][MainWindow.language]);
            buttonRemove4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonRemove4ActionPerformed(evt);
                }
            });
            jPanel21.add(buttonRemove4);

            checkBoxAutoBuild.setText("строить автоматом");
            checkBoxAutoBuild.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    checkBoxAutoBuildItemStateChanged(evt);
                }
            });
            jPanel21.add(checkBoxAutoBuild);

            ArchPane.add(jPanel21, java.awt.BorderLayout.NORTH);

            archTab.addTab("архи", ArchPane);

            ArchPane1.setLayout(new java.awt.BorderLayout());

            jPanel47.setLayout(new java.awt.BorderLayout());

            archTable3.setModel(architectorModelDouble);
            archTable3.getTableHeader().setReorderingAllowed(false);
            jScrollPane13.setViewportView(archTable3);
            architectorModelDouble.addColumn(architectorColumnNames[0][language]);

            jPanel47.add(jScrollPane13, java.awt.BorderLayout.CENTER);

            jPanel48.setLayout(new javax.swing.BoxLayout(jPanel48, javax.swing.BoxLayout.Y_AXIS));

            jPanel49.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

            textFieldArchTime2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            textFieldArchTime2.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    textFieldArchTime2FocusLost(evt);
                }
            });
            jPanel49.add(textFieldArchTime2);
            textFieldArchTime2.setPreferredSize(largeDim);

            labelArchTime2.setText("текущее время");
            labelArchTime.setPreferredSize(largeDim);
            jPanel49.add(labelArchTime2);

            jPanel48.add(jPanel49);

            jPanel50.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

            textFieldArchPeriod2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            textFieldArchPeriod2.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    textFieldArchPeriod2FocusLost(evt);
                }
            });
            jPanel50.add(textFieldArchPeriod2);
            textFieldArchPeriod2.setPreferredSize(largeDim);

            labelArchPeriod2.setText("текущий период");
            jPanel50.add(labelArchPeriod2);

            jPanel48.add(jPanel50);

            jPanel51.setLayout(new javax.swing.BoxLayout(jPanel51, javax.swing.BoxLayout.Y_AXIS));

            jPanel52.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

            jButton13.setText("/\\");
                jButton13.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton13ActionPerformed(evt);
                    }
                });
                jPanel52.add(jButton13);

                jPanel51.add(jPanel52);

                jPanel53.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                jButton14.setText("\\/");
                jButton14.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton14ActionPerformed(evt);
                    }
                });
                jPanel53.add(jButton14);

                jPanel51.add(jPanel53);

                jPanel48.add(jPanel51);

                jPanel47.add(jPanel48, java.awt.BorderLayout.EAST);

                ArchPane1.add(jPanel47, java.awt.BorderLayout.CENTER);

                jPanel54.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                comboBoxArcVillagesDouble.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
                comboBoxArcVillagesDouble.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        comboBoxArcVillagesDoubleItemStateChanged(evt);
                    }
                });
                jPanel54.add(comboBoxArcVillagesDouble);

                buttonArchAdd1.setText("jButton3");
                buttonArchAdd1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonArchAdd1ActionPerformed(evt);
                    }
                });
                jPanel54.add(buttonArchAdd1);

                buttonRemove7.setText(MainWindow.messages[28][MainWindow.language]);
                buttonRemove7.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonRemove7ActionPerformed(evt);
                    }
                });
                jPanel54.add(buttonRemove7);

                checkBoxAutoBuild1.setText("строить автоматом");
                checkBoxAutoBuild1.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        checkBoxAutoBuild1ItemStateChanged(evt);
                    }
                });
                jPanel54.add(checkBoxAutoBuild1);

                ArchPane1.add(jPanel54, java.awt.BorderLayout.NORTH);

                archTab.addTab("Здания(рим)", ArchPane1);

                jPanel23.setPreferredSize(new java.awt.Dimension(605, 107));
                jPanel23.setLayout(new java.awt.BorderLayout());

                jScrollPane10.setPreferredSize(new java.awt.Dimension(252, 300));

                archTable1.setModel(demolishModel);
                archTable1.getTableHeader().setReorderingAllowed(false);
                demolishModel.addColumn(architectorColumnNames[0][language]);
                demolishModel.addColumn(architectorColumnNames[1][language]);
                jScrollPane10.setViewportView(archTable1);

                jPanel23.add(jScrollPane10, java.awt.BorderLayout.CENTER);

                jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.Y_AXIS));

                jPanel38.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                comboBoxArcVillagesDemolish.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
                comboBoxArcVillagesDemolish.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        comboBoxArcVillagesDemolishItemStateChanged(evt);
                    }
                });
                jPanel38.add(comboBoxArcVillagesDemolish);

                buttonDemolishAdd1.setText("jButton3");
                buttonDemolishAdd1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonDemolishAdd1ActionPerformed(evt);
                    }
                });
                jPanel38.add(buttonDemolishAdd1);

                buttonDemolishRemove.setText(MainWindow.messages[28][MainWindow.language]);
                buttonDemolishRemove.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonDemolishRemoveActionPerformed(evt);
                    }
                });
                jPanel38.add(buttonDemolishRemove);

                jPanel25.add(jPanel38);

                jPanel37.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                demolishTimeTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                demolishTimeTF.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        demolishTimeTFFocusLost(evt);
                    }
                });
                jPanel37.add(demolishTimeTF);
                demolishTimeTF.setPreferredSize(largeDim);

                labelDemolishTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labelDemolishTime.setText("Время");
                jPanel37.add(labelDemolishTime);

                demolishPeriodTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                demolishPeriodTF.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        demolishPeriodTFFocusLost(evt);
                    }
                });
                jPanel37.add(demolishPeriodTF);
                demolishPeriodTF.setPreferredSize(largeDim);

                labelDemolishPeriod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labelDemolishPeriod.setText("период");
                jPanel37.add(labelDemolishPeriod);

                jPanel25.add(jPanel37);

                jPanel23.add(jPanel25, java.awt.BorderLayout.PAGE_START);

                javax.swing.GroupLayout demolishLayout = new javax.swing.GroupLayout(demolish);
                demolish.setLayout(demolishLayout);
                demolishLayout.setHorizontalGroup(
                    demolishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 781, Short.MAX_VALUE)
                    .addGroup(demolishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
                );
                demolishLayout.setVerticalGroup(
                    demolishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 191, Short.MAX_VALUE)
                    .addGroup(demolishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                );

                archTab.addTab("Снос", demolish);

                tabbedMainPanel.addTab("Архитектор", natiPic[4][29], archTab);

                EvaPane.setLayout(new java.awt.BorderLayout());

                evadeTable.setModel(evadeModel);
                evadeModel.addColumn("checking demolishTimeTF");
                evadeModel.addColumn("reso");
                evadeModel.addColumn("troops");
                evadeModel.addColumn("period");
                jScrollPane7.setViewportView(evadeTable);
                evadeTable.getTableHeader().setReorderingAllowed(false);

                EvaPane.add(jScrollPane7, java.awt.BorderLayout.CENTER);

                jPanel26.setLayout(new javax.swing.BoxLayout(jPanel26, javax.swing.BoxLayout.Y_AXIS));

                jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                jButton3.setText("addtota");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton3ActionPerformed(evt);
                    }
                });
                jPanel27.add(jButton3);

                jButton4.setText("removerow");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton4ActionPerformed(evt);
                    }
                });
                jPanel27.add(jButton4);

                checkBoxTravianPlus.setText("istravianPlus");
                jPanel27.add(checkBoxTravianPlus);

                buttonPreferences3.setText(messages[82][language]);
                buttonPreferences3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonPreferences3ActionPerformed(evt);
                    }
                });
                jPanel27.add(buttonPreferences3);

                jPanel26.add(jPanel27);

                jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                checkBoxSound.setSelected(true);
                checkBoxSound.setText("Sound Signal");
                jPanel28.add(checkBoxSound);

                checkBoxOaseSound.setText("oase attack");
                jPanel28.add(checkBoxOaseSound);

                jPanel26.add(jPanel28);

                jPanel29.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                jComboBox2.setEditable(true);
                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "001.wav", "002.wav", "003.wav", "004.wav", "005.wav" }));
                jComboBox2.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        jComboBox2ItemStateChanged(evt);
                    }
                });
                jPanel29.add(jComboBox2);

                jButton2.setText("sound signal test");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton2ActionPerformed(evt);
                    }
                });
                jPanel29.add(jButton2);

                jPanel26.add(jPanel29);

                EvaPane.add(jPanel26, java.awt.BorderLayout.PAGE_START);

                tabbedMainPanel.addTab("эвак", natiPic[4][30], EvaPane);

                TimerPane.setLayout(new java.awt.BorderLayout());

                timerTable.setModel(timerModel);
                jScrollPane6.setViewportView(timerTable);
                timerModel.addColumn("comment");
                timerModel.addColumn("timer");
                timerTable.getTableHeader().setReorderingAllowed(false);

                TimerPane.add(jScrollPane6, java.awt.BorderLayout.CENTER);

                jPanel31.setLayout(new java.awt.GridLayout(1, 6));

                jButton5.setText("addtota");
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton5ActionPerformed(evt);
                    }
                });
                jPanel31.add(jButton5);

                jButton6.setText("removerow");
                jButton6.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton6ActionPerformed(evt);
                    }
                });
                jPanel31.add(jButton6);

                comboboxTimer.setEditable(true);
                comboboxTimer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "001.wav", "002.wav", "003.wav", "004.wav", "005.wav" }));
                comboboxTimer.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        comboboxTimerItemStateChanged(evt);
                    }
                });
                jPanel31.add(comboboxTimer);
                jPanel31.add(jLabel12);
                jPanel31.add(jLabel13);

                buttonStart1.setText("jToggleButton1");
                buttonStart1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonStart1ActionPerformed(evt);
                    }
                });
                jPanel31.add(buttonStart1);

                TimerPane.add(jPanel31, java.awt.BorderLayout.PAGE_START);

                tabbedMainPanel.addTab("будило", natiPic[4][20], TimerPane);

                HallPane.setLayout(new javax.swing.BoxLayout(HallPane, javax.swing.BoxLayout.PAGE_AXIS));

                jPanel34.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                buttonAddProgram2.setText(MainWindow.messages[27][MainWindow.language]);
                buttonAddProgram2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonAddProgram2ActionPerformed(evt);
                    }
                });
                jPanel34.add(buttonAddProgram2);

                buttonRemove5.setText(MainWindow.messages[28][MainWindow.language]);
                buttonRemove5.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonRemove5ActionPerformed(evt);
                    }
                });
                jPanel34.add(buttonRemove5);

                jLabel2.setIcon(natiPic[4][11]);
                jLabel2.setText("jLabel2");
                jPanel34.add(jLabel2);

                HallPane.add(jPanel34);

                celebrateTable.setModel(celebrateModel);
                celebrateModel.addColumn("village");
                celebrateModel.addColumn("type");
                celebrateModel.addColumn("timer");
                celebrateModel.addColumn("period");
                jScrollPane8.setViewportView(celebrateTable);
                celebrateTable.getTableHeader().setReorderingAllowed(false);

                HallPane.add(jScrollPane8);

                jPanel33.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                buttonAddProgram3.setText(MainWindow.messages[27][MainWindow.language]);
                buttonAddProgram3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonAddProgram3ActionPerformed(evt);
                    }
                });
                jPanel33.add(buttonAddProgram3);

                buttonRemove8.setText(MainWindow.messages[28][MainWindow.language]);
                buttonRemove8.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonRemove8ActionPerformed(evt);
                    }
                });
                jPanel33.add(buttonRemove8);

                jLabel3.setIcon(natiPic[4][12]);
                jLabel3.setText("jLabel3");
                jPanel33.add(jLabel3);

                HallPane.add(jPanel33);

                blackSmtithTable.setModel(blackSmithModel);
                blackSmithModel.addColumn("village");
                blackSmithModel.addColumn("unit");
                blackSmithModel.addColumn("level");
                blackSmithModel.addColumn("timer");
                blackSmithModel.addColumn("period");
                jScrollPane11.setViewportView(blackSmtithTable);
                blackSmtithTable.getTableHeader().setReorderingAllowed(false);

                HallPane.add(jScrollPane11);

                jPanel6.setLayout(new java.awt.GridLayout(2, 0));

                jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                checkBoxAdventure.add(jLabel4);
                checkBoxAdventure.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        checkBoxAdventureItemStateChanged(evt);
                    }
                });
                jPanel8.add(checkBoxAdventure);

                jLabel4.setIcon(natiPic[4][9]);
                jLabel4.setText("отправлять на приключения");
                jPanel8.add(jLabel4);

                checkBoxHard.add(jLabel10);
                checkBoxHard.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        checkBoxHardItemStateChanged(evt);
                    }
                });
                jPanel8.add(checkBoxHard);

                jLabel10.setIcon(natiPic[4][10]);
                jLabel10.setText("не отправлять на сложные");
                jPanel8.add(jLabel10);

                jPanel6.add(jPanel8);

                jPanel32.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                labelSendEach.setText("отправлять каждые");
                jPanel32.add(labelSendEach);

                jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jTextField1.setText("300");
                jPanel32.add(jTextField1);

                labelMin1.setText("минут");
                jPanel32.add(labelMin1);

                labelTimeToadventure.setText("             до отправки осталось");
                jPanel32.add(labelTimeToadventure);

                jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                jTextField2.setText("05:00:00");
                jTextField2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jTextField2ActionPerformed(evt);
                    }
                });
                jPanel32.add(jTextField2);

                jPanel6.add(jPanel32);

                HallPane.add(jPanel6);

                tabbedMainPanel.addTab("мэрия", natiPic[4][31], HallPane);

                ScoutPane.setLayout(new java.awt.BorderLayout());

                scoutTable.setModel(scoutModel);
                scoutTable.getTableHeader().setReorderingAllowed(false);
                jScrollPane9.setViewportView(scoutTable);
                scoutModel.addColumn("Player");      //1
                scoutModel.addColumn("Ally");        //2
                scoutModel.addColumn("population");  //3

                ScoutPane.add(jScrollPane9, java.awt.BorderLayout.CENTER);

                jPanel35.setLayout(new java.awt.GridLayout(3, 6));

                buttonGatherInfo.setText(MainWindow.messages[25][MainWindow.language]);
                buttonGatherInfo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonGatherInfoActionPerformed(evt);
                    }
                });
                jPanel35.add(buttonGatherInfo);
                jPanel35.add(jLabel16);
                jPanel35.add(jLabel15);

                analizator.setText("анализатор");
                analizator.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        analizatorActionPerformed(evt);
                    }
                });
                jPanel35.add(analizator);

                buttonRemove6.setText(MainWindow.messages[28][MainWindow.language]);
                buttonRemove6.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonRemove6ActionPerformed(evt);
                    }
                });
                jPanel35.add(buttonRemove6);

                buttonPreferences2.setText(messages[82][language]);
                buttonPreferences2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonPreferences2ActionPerformed(evt);
                    }
                });
                jPanel35.add(buttonPreferences2);
                jPanel35.add(jLabel20);
                jPanel35.add(jLabel11);

                buttonCopyToTravian1.setText(messages[109][language]);
                buttonCopyToTravian1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonCopyToTravian1ActionPerformed(evt);
                    }
                });
                jPanel35.add(buttonCopyToTravian1);

                buttonAddToBandito.setText(MainWindow.messages[108][MainWindow.language]);
                buttonAddToBandito.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonAddToBanditoActionPerformed(evt);
                    }
                });
                jPanel35.add(buttonAddToBandito);
                jPanel35.add(jLabel17);

                jButton7.setText("CoxpaHuTb");
                jButton7.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton7ActionPerformed(evt);
                    }
                });
                jPanel35.add(jButton7);

                ScoutPane.add(jPanel35, java.awt.BorderLayout.PAGE_START);

                tabbedMainPanel.addTab("скаут", natiPic[4][32], ScoutPane);

                jPanel9.setEnabled(false);
                jPanel9.setLayout(new java.awt.BorderLayout());

                jPanel36.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

                buttonAddProgram4.setText(MainWindow.messages[27][MainWindow.language]);
                buttonAddProgram4.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonAddProgram4ActionPerformed(evt);
                    }
                });
                jPanel36.add(buttonAddProgram4);

                buttonRemove9.setText(MainWindow.messages[28][MainWindow.language]);
                buttonRemove9.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonRemove9ActionPerformed(evt);
                    }
                });
                jPanel36.add(buttonRemove9);

                jPanel9.add(jPanel36, java.awt.BorderLayout.PAGE_START);

                tabbedMainPanel.addTab("Атаки", new ImageIcon("images/att3.jpg"), jPanel9);
                attackPanel.setLayout(new BoxLayout(attackPanel, BoxLayout.Y_AXIS));

                jPanel9.add(jsp, BorderLayout.CENTER);

                getContentPane().add(tabbedMainPanel);

                jMenu1.setText("File");

                jMenuItem1.setText("Login");
                jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem1ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem1);
                jMenu1.add(jSeparator1);

                menuOpen.setText("open");
                menuOpen.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        menuOpenActionPerformed(evt);
                    }
                });
                jMenu1.add(menuOpen);

                jMenuItem4.setText("save");
                jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jMenuItem4MouseClicked(evt);
                    }
                });
                jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem4ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem4);

                jMenuItem5.setText("save as");
                jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem5ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem5);
                jMenu1.add(jSeparator2);

                jMenuItem2.setText("Exit");
                jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem2ActionPerformed(evt);
                    }
                });
                jMenu1.add(jMenuItem2);

                jMenuBar1.add(jMenu1);

                jMenu2.setText("Options");

                jMenuItem3.setText("Options");
                jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem3ActionPerformed(evt);
                    }
                });
                jMenu2.add(jMenuItem3);

                jMenuItem7.setText("ReportsManager");
                jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem7ActionPerformed(evt);
                    }
                });
                jMenu2.add(jMenuItem7);

                jMenuBar1.add(jMenu2);

                jMenu4.setText("Payment");

                jMenuItem6.setText("Pay conditions");
                jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem6ActionPerformed(evt);
                    }
                });
                jMenu4.add(jMenuItem6);

                jMenuItem8.setText("Grid");
                jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem8ActionPerformed(evt);
                    }
                });
                jMenu4.add(jMenuItem8);

                jMenuBar1.add(jMenu4);

                jMenu3.setText("About me");
                jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jMenu3MouseClicked(evt);
                    }
                });
                jMenuBar1.add(jMenu3);

                setJMenuBar(jMenuBar1);

                pack();
            }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc=" МЕТОДЫ КНОПОК ">
    private void buttonPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreferencesActionPerformed
        Traviator42.banditoPref = new BanditoPreferenses(this, true);
        Traviator42.banditoPref.setVisible(true);
    }//GEN-LAST:event_buttonPreferencesActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed

        //<editor-fold defaultstate="collapsed" desc=" кнопка удалить строку ">

        if (banditoTable.getModel() == banditoModel) {
            deleteRow(banditoTable, banditoModel);
        } else {
            deleteRow(banditoTable, banditoListModelE);
        }
        //</editor-fold>

    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonAllNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAllNowActionPerformed
        ThreadAllNow ALN = new ThreadAllNow();
    }//GEN-LAST:event_buttonAllNowActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        MainLogin lll = new MainLogin(this, true);
        lll.setVisible(true);

    }//GEN-LAST:event_buttonLoginActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        language = 1;
        internationalization();
    }//GEN-LAST:event_jLabel7MouseClicked
    static String ban = "Wscript.Echo objDrive.SerialNumber";
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        language = 0;
        internationalization();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MainLogin lll = new MainLogin(this, true);
        lll.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        MainAboutMe ab = new MainAboutMe(this, true);
        ab.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        saveChooser();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenActionPerformed
        openChooser();        // TODO add your handling code here:
    }//GEN-LAST:event_menuOpenActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (savefile == null) {
            saveChooser();
        } else {
            save(false);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed

        //<editor-fold defaultstate="collapsed" desc=" кнопка старт ">
        //если кликаем по не утопленой кнопке, то
        if (buttonStart.isSelected() == true) {
            boolean archFill = false;
            for (int i = 0; i < vilList.size(); i++) {
                if (vilList.get(i).buildList.size() > 0) {
                    archFill = true;
                    break;
                }
            }
            if (sergeantModel.getRowCount() > 0 || merchModel.getRowCount() > 0
                    || banditoListModel.getRowCount() > 0 || banditoModel.getRowCount() > 0
                    || archFill == true || evadeModel.getRowCount() > 0
                    || celebrateModel.getRowCount() > 0 || blackSmithModel.getRowCount() > 0
                    || attackPanel.getComponentCount() > 0 || archTable1.getRowCount() > 0) {
                if (BanditoTables.getSelectedIndex() == 0) {
                    BanditoTables.setEnabledAt(1, false);
                    interrupt = false;
                    waitInterrupt = false;
                    buttonStart.setText(messages[26][language]);
                    ThreadWait tw = new ThreadWait();
                } else {
                    buttonStart.setText(messages[26][language]);
                    buttonStart.setForeground(Color.red);
                    BanditoTables.setEnabledAt(0, false);
                    waitInterrupt = false;
                    interrupt = false;
                    MainTroops sft = new MainTroops(this, true, 105, true);
                    sft.setVisible(true);
                }
            } else {//если все таблицы пусты
                consoleText(Color.RED, messages[179][language]);
                buttonStart.doClick();
            }
        } else {//если кликаем по утопленой кнопке то
            interrupt = true;
            waitInterrupt = true;
            BanditoTables.setEnabledAt(0, true);
            BanditoTables.setEnabledAt(1, true);
            buttonStart.setText(messages[25][language]);
            while (farmTroop.getComponentCount() > 0) {
                farmTroop.remove(0);
                troops.remove(0);
            }
        }
        toggle(buttonStart);
//</editor-fold>

    }//GEN-LAST:event_buttonStartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Bandito1Villy cff = new Bandito1Villy(this, true, true, "");
        cff.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonCopyToTravianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCopyToTravianActionPerformed
        if (banditoTable.getRowCount() > 0) {
            new Bandito1Robot(this, true, 0, "").setVisible(true);
        } else {
            consoleText(Color.BLACK, messages[62][language]);
        }
    }//GEN-LAST:event_buttonCopyToTravianActionPerformed

    private void buttonNewListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewListActionPerformed
        Search fff = new Search(this, true);
        fff.setVisible(true);
    }//GEN-LAST:event_buttonNewListActionPerformed

    private void buttonRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove1ActionPerformed
        if (banditoListTable.getRowCount() > 0) {
            int sell[] = banditoListTable.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    banditoListModel.removeRow(sell[i] - i);
                }
            } else {
                banditoListModel.removeRow(0);
            }
        }
        if (banditoListModel.getRowCount() == 0) {
        }
    }//GEN-LAST:event_buttonRemove1ActionPerformed

    private void buttonPreferences1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreferences1ActionPerformed
        Traviator42.banditoPref = new BanditoPreferenses(this, true);
        Traviator42.banditoPref.setVisible(true);
    }//GEN-LAST:event_buttonPreferences1ActionPerformed

    private void buttonAddProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProgramActionPerformed
        Traviator42.villageFrame = new SergeantvillageName(this, true);
        Traviator42.villageFrame.setVisible(true);
    }//GEN-LAST:event_buttonAddProgramActionPerformed

    private void buttonRemove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove2ActionPerformed
        if (sargeTable.getRowCount() > 0) {
            int sell[] = sargeTable.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    sergeantModel.removeRow(sell[i] - i);
                }
            } else {
                sergeantModel.removeRow(0);
            }
        }
    }//GEN-LAST:event_buttonRemove2ActionPerformed

    private void buttonAddProgram1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProgram1ActionPerformed
        Merch1VillySender mvs = new Merch1VillySender(this, true, false);
        mvs.setVisible(true);
    }//GEN-LAST:event_buttonAddProgram1ActionPerformed

    private void buttonRemove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove3ActionPerformed
        if (marketTable.getRowCount() > 0) {
            int sell[] = marketTable.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    merchModel.removeRow(sell[i] - i);
                }
            } else {
                merchModel.removeRow(0);
            }
        }
    }//GEN-LAST:event_buttonRemove3ActionPerformed

    private void buttonRemove4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove4ActionPerformed
        if (archTable.getRowCount() > 0) {
            Village temp = vilList.get(comboBoxArcVillages.getSelectedIndex());

            int sell[] = archTable.getSelectedRows();
            archDelete(temp, sell);

        }
    }//GEN-LAST:event_buttonRemove4ActionPerformed

    private void buttonArchAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArchAddActionPerformed
        Traviator42.arch1 = new Architector1Villy(this, true, true, true);
        Traviator42.arch1.setVisible(true);

    }//GEN-LAST:event_buttonArchAddActionPerformed

    private void comboBoxArcVillagesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxArcVillagesItemStateChanged
        if (load == true) {
            if (comboBoxArcVillages.getSelectedIndex() != -1) {
                Village temp = vilList.get(comboBoxArcVillages.getSelectedIndex());
                int i = 0;
                while (architectorModel.getRowCount() > 0) {
                    architectorModel.removeRow(0);
                }
                while (i < temp.buildList.size()) {
                    architectorModel.addRow(new Object[]{"id" + temp.idList.get(i) + " " + temp.buildList.get(i)});
                    i++;
                }

                textFieldArchPeriod.setText(temp.period);
                textFieldArchTime.setText(temp.time);

                while (demolishModel.getRowCount() > 0) {
                    demolishModel.removeRow(0);
                }
                i = 0;
                while (i < temp.demolishList.size()) {
                    demolishModel.addRow(new Object[]{
                        temp.demolishList.get(i), temp.dLevel.get(i)
                    });
                    i++;
                }
                demolishPeriodTF.setText(temp.dPeriod);
                demolishTimeTF.setText(temp.dTime);
            }
        }
    }//GEN-LAST:event_comboBoxArcVillagesItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Traviator42.eva2 = new Evakuator2type(this, true);
        Traviator42.eva2.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (evadeTable.getRowCount() > 0) {
            int sell[] = evadeTable.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    evadeModel.removeRow(sell[i] - i);
                }
            } else {
                evadeModel.removeRow(0);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        playSound(sound);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if (jComboBox2.getSelectedIndex() != -1) {
            sound = "sound/" + jComboBox2.getSelectedItem().toString();
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void buttonSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSoundActionPerformed
        soundAlert = true;
        stopTimerClip = true;
        if (clip != null) {
            clip.close();
        }
        if (timerClip != null) {
            timerClip.close();
        }
    }//GEN-LAST:event_buttonSoundActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Traviator42.timer = new timer1Value(this, true);
        Traviator42.timer.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (timerTable.getRowCount() > 0) {

            int sell[] = timerTable.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    timerModel.removeRow(sell[i] - i);
                }
            } else {
                timerModel.removeRow(0);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void comboboxTimerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxTimerItemStateChanged
        if (comboboxTimer.getSelectedIndex() != -1) {
            soundTimer = "sound/" + comboboxTimer.getSelectedItem().toString();
        }
    }//GEN-LAST:event_comboboxTimerItemStateChanged

    private void buttonStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStart1ActionPerformed
        if (buttonStart1.isSelected() == true) {
            if (timerTable.getRowCount() > 0) {
                stopTimer = false;
                TimerTime tt = new TimerTime();
            } else {
                consoleText(Color.RED, messages[154][language]);
                buttonStart1.doClick();
            }
        } else {
            stopTimer = true;
        }
        toggle(buttonStart1);
    }//GEN-LAST:event_buttonStart1ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        language = 2;
        internationalization();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed
        BanditoModifyTable mt = new BanditoModifyTable(this, true);
        mt.setVisible(true);
    }//GEN-LAST:event_buttonModifyActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        MainDelay md = new MainDelay(this, true);
        md.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        Object[] options = {messages[156][language], messages[155][language]};
        int n = JOptionPane
                .showOptionDialog(null, messages[229][language],
                messages[132][language], JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, options,
                options[0]);
        if (n == 0) {
            refresh();
        }

    }//GEN-LAST:event_refreshButtonActionPerformed

    private void buttonAddProgram2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProgram2ActionPerformed
        Celebrate1VillyAndType cvat = new Celebrate1VillyAndType(this, true);
        cvat.setVisible(true);
    }//GEN-LAST:event_buttonAddProgram2ActionPerformed

    private void buttonRemove5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove5ActionPerformed
        if (celebrateTable.getRowCount() > 0) {

            int sell[] = celebrateTable.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    celebrateModel.removeRow(sell[i] - i);
                }
            } else {
                celebrateModel.removeRow(0);
            }
        }
    }//GEN-LAST:event_buttonRemove5ActionPerformed

    private void buttonGatherInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGatherInfoActionPerformed
        ScoutTableLoad tl = new ScoutTableLoad(this, true);
        tl.setVisible(true);
    }//GEN-LAST:event_buttonGatherInfoActionPerformed

    private void buttonRemove6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove6ActionPerformed
        if (scoutTable.getRowCount() > 0) {
            int sell[] = scoutTable.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    scoutModel.removeRow(sell[i] - i);
                }
            } else {
                scoutModel.removeRow(0);
            }
        }
    }//GEN-LAST:event_buttonRemove6ActionPerformed

    private void buttonAddToBanditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddToBanditoActionPerformed
        if (scoutTable.getRowCount() > 0) {
            MainCopyStatus ccc = new MainCopyStatus(this, true, 2, 0, "", false, new ArrayList<String>());
            ccc.setVisible(true);
        } else {
            consoleText(Color.RED, messages[62][language]);
        }
    }//GEN-LAST:event_buttonAddToBanditoActionPerformed

    private void buttonPreferences2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreferences2ActionPerformed
        ScoutPreferenses sp = new ScoutPreferenses(this, true);
        sp.setVisible(true);
    }//GEN-LAST:event_buttonPreferences2ActionPerformed

    private void buttonCopyToTravian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCopyToTravian1ActionPerformed
        if (scoutTable.getRowCount() > 0) {
            Bandito1Robot ggg = new Bandito1Robot(this, true, 3, "");
            ggg.setVisible(true);
        } else {
            consoleText(Color.RED, messages[62][language]);
        }
    }//GEN-LAST:event_buttonCopyToTravian1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (scoutModel.getRowCount() > 0) {
            JFileChooser saver = new JFileChooser("./");

            int returnVal = saver.showSaveDialog(this);
            savefile = saver.getSelectedFile();

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                saveScout();
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tabbedMainPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedMainPanelStateChanged
        if (showTips == 1 && load == true) {
            if (tabbedMainPanel.getSelectedIndex() != 8) {
                consoleText(new Color(27, 132, 57), messages[276 + tabbedMainPanel.getSelectedIndex()][language]);
            } else {
                consoleText(new Color(27, 132, 57), messages[324][language]);
            }
        }
    }//GEN-LAST:event_tabbedMainPanelStateChanged

    private void buttonDemolishAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDemolishAdd1ActionPerformed
        Architector1Villy a1vd = new Architector1Villy(this, true, false, true);
        a1vd.setVisible(true);
    }//GEN-LAST:event_buttonDemolishAdd1ActionPerformed

    private void buttonDemolishRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDemolishRemoveActionPerformed
        if (archTable1.getRowCount() > 0) {
            int sell[] = archTable1.getSelectedRows();
            Village temp = vilList.get(comboBoxArcVillagesDemolish.getSelectedIndex());
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    temp.demolishList.remove(sell[i] - i);
                    temp.dLevel.remove(sell[i] - i);
                    demolishModel.removeRow(sell[i] - i);
                }
            } else {
                demolishModel.removeRow(0);
                temp.demolishList.remove(0);
                temp.dLevel.remove(0);
            }
        }
    }//GEN-LAST:event_buttonDemolishRemoveActionPerformed

    private void buttonAddProgram3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProgram3ActionPerformed
        MainTroops mt = new MainTroops(this, true, 296, false);
        mt.setVisible(true);
    }//GEN-LAST:event_buttonAddProgram3ActionPerformed

    private void buttonRemove8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove8ActionPerformed
        if (blackSmtithTable.getRowCount() > 0) {
            int sell[] = blackSmtithTable.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    blackSmithModel.removeRow(sell[i] - i);
                }
            } else {
                blackSmithModel.removeRow(0);
            }
        }
    }//GEN-LAST:event_buttonRemove8ActionPerformed

    private void checkBoxAdventureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxAdventureItemStateChanged
        if (checkBoxAdventure.isSelected() == true) {
            checkBoxHard.setSelected(true);
        } else {
            checkBoxHard.setSelected(false);
        }
    }//GEN-LAST:event_checkBoxAdventureItemStateChanged

    private void checkBoxHardItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxHardItemStateChanged
        if (checkBoxAdventure.isSelected() == false && checkBoxHard.isSelected() == true) {
            consoleText(Color.RED, messages[310][language]);
        }
    }//GEN-LAST:event_checkBoxHardItemStateChanged

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        MainNotification mn = new MainNotification(this, true);
        mn.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        MainPaymentGrid mpg = new MainPaymentGrid(this, true);
        mpg.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void buttonAddProgram4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProgram4ActionPerformed
        Attack1Villy a1v = new Attack1Villy(this, true);
        a1v.setVisible(true);
    }//GEN-LAST:event_buttonAddProgram4ActionPerformed

    private void buttonRemove9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove9ActionPerformed
        if (attackPanel.getComponentCount() > 0) {
            AttackDelete ad = new AttackDelete(this, true);
            ad.setVisible(true);
        }
    }//GEN-LAST:event_buttonRemove9ActionPerformed

    private void demolishTimeTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_demolishTimeTFFocusLost
        if (load == true) {
            if (comboBoxArcVillages.getSelectedIndex() != -1) {
                Village temp = vilList.get(comboBoxArcVillages.getSelectedIndex());
                temp.dTime = demolishTimeTF.getText();
            }
        }
    }//GEN-LAST:event_demolishTimeTFFocusLost

    private void demolishPeriodTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_demolishPeriodTFFocusLost
        if (load == true) {
            if (comboBoxArcVillages.getSelectedIndex() != -1) {
                Village temp = vilList.get(comboBoxArcVillages.getSelectedIndex());
                temp.dPeriod = demolishPeriodTF.getText();
            }
        }
    }//GEN-LAST:event_demolishPeriodTFFocusLost

    private void checkBoxAutoBuildItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxAutoBuildItemStateChanged
        if (checkBoxAutoBuild.isSelected()) {
            autoBuild = true;
            for (int i = 0; i < vilList.size(); i++) {
                Village temp = vilList.get(i);
                boolean detected = false;
                for (int j = 0; j < temp.buildList.size(); j++) {
                    if ("auto".equals(temp.buildList.get(j))) {
                        detected = true;
                    }
                }
                if (detected == false) {
                    temp.buildList.add("auto");
                    temp.idList.add(99);
                    if ("".equals(temp.time)) {
                        temp.time = MainWindow.setTimer(temp.period);
                    }
                }
                if (detected == false && i == comboBoxArcVillages.getSelectedIndex()) {
                    architectorModel.addRow(new Object[]{"id99 auto"});
                    textFieldArchTime.setText(temp.time);
                    textFieldArchPeriod.setText(temp.period);
                }
            }
            if (showTips == 1) {
                consoleText(new Color(27, 132, 57), messages[333][language]);
            }
        } else {
            autoBuild = false;
            for (int i = 0; i < vilList.size(); i++) {
                Village temp = vilList.get(i);
                boolean detected = false;
                int deletedRow = 0;
                for (int j = 0; j < temp.buildList.size(); j++) {
                    if ("auto".equals(temp.buildList.get(j))) {
                        detected = true;
                        temp.buildList.remove(j);
                        temp.idList.remove(j);
                        deletedRow = j;
                    }
                }
                if (detected == true && i == comboBoxArcVillages.getSelectedIndex()) {
                    architectorModel.removeRow(deletedRow);
                }
            }
            if (showTips == 1) {
                consoleText(new Color(27, 132, 57), messages[334][language]);
            }
        }
    }//GEN-LAST:event_checkBoxAutoBuildItemStateChanged

    private void buttonPreferences3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreferences3ActionPerformed
        Evacuator6Pref eva6 = new Evacuator6Pref(this, true);
        eva6.setVisible(true);
    }//GEN-LAST:event_buttonPreferences3ActionPerformed

    private void checkBoxBanditoExtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxBanditoExtendActionPerformed
        if (checkBoxBanditoExtend.isSelected()) {
            banditoTable.setModel(banditoListModelE);
        } else {
            banditoTable.setModel(banditoModel);
        }
        textFieldOperation(textFieldHours, checkBoxBanditoExtend.isSelected());
        textFieldOperation(textFieldMinutes, checkBoxBanditoExtend.isSelected());
        textFieldOperation(textFieldSec, checkBoxBanditoExtend.isSelected());
    }//GEN-LAST:event_checkBoxBanditoExtendActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (archTable.getRowCount() > 0) {
            int s[] = archTable.getSelectedRows();
            Village temp = vilList.get(comboBoxArcVillages.getSelectedIndex());
            if (s.length > 0) {
                ArrayList<String> buildList = new ArrayList<>();
                ArrayList<Integer> idList = new ArrayList<>();

                String mas[] = new String[s.length];
                for (int b = 0; b < s.length; b++) {
                    mas[b] = architectorModel.getValueAt(s[b], 0).toString();
                }

                for (int i = 0; i < s.length; i++) {
                    architectorModel.removeRow(s[i] - i);
                    buildList.add(temp.buildList.remove(s[i] - i));
                    idList.add(temp.idList.remove(s[i] - i));
                }
                for (int i = 0; i < s.length; i++) {
                    architectorModel.insertRow(s[i] - 1, new Object[]{mas[i]});
                    temp.buildList.add(s[i] - 1, buildList.get(i));
                    temp.idList.add(s[i] - 1, idList.get(i));
                }
            } else {
                temp.buildList.add(temp.buildList.remove(0));
                temp.idList.add(temp.idList.remove(0));
                architectorModel.addRow(new Object[]{architectorModel.getValueAt(0, 0)});
                architectorModel.removeRow(0);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (archTable.getRowCount() > 0) {
            int s[] = archTable.getSelectedRows();
            Village temp = vilList.get(comboBoxArcVillages.getSelectedIndex());
            if (s.length > 0) {
                ArrayList<String> buildList = new ArrayList<>();
                ArrayList<Integer> idList = new ArrayList<>();

                String mas[] = new String[s.length];
                for (int b = 0; b < s.length; b++) {
                    mas[b] = architectorModel.getValueAt(s[b], 0).toString();
                }

                for (int i = 0; i < s.length; i++) {
                    architectorModel.removeRow(s[i] - i);
                    buildList.add(temp.buildList.remove(s[i] - i));
                    idList.add(temp.idList.remove(s[i] - i));
                }
                for (int i = 0; i < s.length; i++) {
                    architectorModel.insertRow(s[i] + 1, new Object[]{mas[i]});
                    temp.buildList.add(s[i] + 1, buildList.get(i));
                    temp.idList.add(s[i] + 1, idList.get(i));
                }
            } else {
                temp.buildList.add(0, temp.buildList.remove(temp.buildList.size() - 1));
                temp.idList.add(0, temp.idList.remove(temp.idList.size() - 1));
                architectorModel.insertRow(0, new Object[]{architectorModel.getValueAt(architectorModel.getRowCount() - 1, 0)});
                architectorModel.removeRow(architectorModel.getRowCount() - 1);
            }
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void buttonTradeRoutesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTradeRoutesActionPerformed
        Merch1VillySender mvs = new Merch1VillySender(this, true, true);
        mvs.setVisible(true);
    }//GEN-LAST:event_buttonTradeRoutesActionPerformed

    private void textFieldArchTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldArchTimeFocusLost
        vilList.get(comboBoxArcVillages.getSelectedIndex()).time = textFieldArchTime.getText();
    }//GEN-LAST:event_textFieldArchTimeFocusLost

    private void textFieldArchPeriodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldArchPeriodFocusLost
        vilList.get(comboBoxArcVillages.getSelectedIndex()).period = textFieldArchPeriod.getText();
    }//GEN-LAST:event_textFieldArchPeriodFocusLost

    private void analizatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizatorActionPerformed
        ScoutAnalizator sa = new ScoutAnalizator(Traviator42.mainWindow, true);
        sa.setVisible(true);
    }//GEN-LAST:event_analizatorActionPerformed

    private void textFieldArchTime2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldArchTime2FocusLost
        vilList.get(comboBoxArcVillagesDouble.getSelectedIndex()).timeDouble = textFieldArchTime2.getText();
    }//GEN-LAST:event_textFieldArchTime2FocusLost

    private void textFieldArchPeriod2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldArchPeriod2FocusLost
        vilList.get(comboBoxArcVillagesDouble.getSelectedIndex()).periodDouble = textFieldArchPeriod2.getText();
    }//GEN-LAST:event_textFieldArchPeriod2FocusLost

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (archTable3.getRowCount() > 0) {
            int s[] = archTable3.getSelectedRows();
            Village temp = vilList.get(comboBoxArcVillagesDouble.getSelectedIndex());
            if (s.length > 0) {
                ArrayList<String> buildList = new ArrayList<>();
                ArrayList<Integer> idList = new ArrayList<>();

                String mas[] = new String[s.length];
                for (int b = 0; b < s.length; b++) {
                    mas[b] = architectorModelDouble.getValueAt(s[b], 0).toString();
                }

                for (int i = 0; i < s.length; i++) {
                    architectorModelDouble.removeRow(s[i] - i);
                    buildList.add(temp.buildListD.remove(s[i] - i));
                    idList.add(temp.idListD.remove(s[i] - i));
                }
                for (int i = 0; i < s.length; i++) {
                    architectorModelDouble.insertRow(s[i] - 1, new Object[]{mas[i]});
                    temp.buildListD.add(s[i] - 1, buildList.get(i));
                    temp.idListD.add(s[i] - 1, idList.get(i));
                }
            } else {
                temp.buildListD.add(temp.buildListD.remove(0));
                temp.idListD.add(temp.idListD.remove(0));
                architectorModelDouble.addRow(new Object[]{architectorModelDouble.getValueAt(0, 0)});
                architectorModelDouble.removeRow(0);
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (archTable3.getRowCount() > 0) {
            int s[] = archTable3.getSelectedRows();
            Village temp = vilList.get(comboBoxArcVillagesDouble.getSelectedIndex());
            if (s.length > 0) {
                ArrayList<String> buildList = new ArrayList<>();
                ArrayList<Integer> idList = new ArrayList<>();

                String mas[] = new String[s.length];
                for (int b = 0; b < s.length; b++) {
                    mas[b] = architectorModelDouble.getValueAt(s[b], 0).toString();
                }

                for (int i = 0; i < s.length; i++) {
                    architectorModelDouble.removeRow(s[i] - i);
                    buildList.add(temp.buildListD.remove(s[i] - i));
                    idList.add(temp.idListD.remove(s[i] - i));
                }
                for (int i = 0; i < s.length; i++) {
                    architectorModelDouble.insertRow(s[i] + 1, new Object[]{mas[i]});
                    temp.buildListD.add(s[i] + 1, buildList.get(i));
                    temp.idListD.add(s[i] + 1, idList.get(i));
                }
            } else {
                temp.buildListD.add(0, temp.buildListD.remove(temp.buildListD.size() - 1));
                temp.idListD.add(0, temp.idListD.remove(temp.idListD.size() - 1));
                architectorModelDouble.insertRow(0, new Object[]{architectorModelDouble.getValueAt(architectorModelDouble.getRowCount() - 1, 0)});
                architectorModelDouble.removeRow(architectorModelDouble.getRowCount() - 1);
            }
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void comboBoxArcVillagesDoubleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxArcVillagesDoubleItemStateChanged
        if (load == true) {
            if (comboBoxArcVillagesDouble.getSelectedIndex() != -1) {
                Village temp = vilList.get(comboBoxArcVillagesDouble.getSelectedIndex());
                int i = 0;
                while (architectorModelDouble.getRowCount() > 0) {
                    architectorModelDouble.removeRow(0);
                }
                while (i < temp.buildListD.size()) {
                    architectorModelDouble.addRow(new Object[]{"id" + temp.idListD.get(i) + " " + temp.buildListD.get(i)});
                    i++;
                }
                textFieldArchPeriod2.setText(temp.periodDouble);
                textFieldArchTime2.setText(temp.timeDouble);
            }
        }
    }//GEN-LAST:event_comboBoxArcVillagesDoubleItemStateChanged

    private void buttonArchAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArchAdd1ActionPerformed
        Traviator42.arch1 = new Architector1Villy(this, true, true, false);
        Traviator42.arch1.setVisible(true);
    }//GEN-LAST:event_buttonArchAdd1ActionPerformed

    private void buttonRemove7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemove7ActionPerformed
        if (archTable3.getRowCount() > 0) {
            Village temp = vilList.get(comboBoxArcVillagesDouble.getSelectedIndex());
            int sell[] = archTable3.getSelectedRows();
            archDelete1(temp, sell);
        }
    }//GEN-LAST:event_buttonRemove7ActionPerformed

    private void checkBoxAutoBuild1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxAutoBuild1ItemStateChanged
        if (checkBoxAutoBuild1.isSelected()) {
            autoBuild = true;
            for (int i = 0; i < vilList.size(); i++) {
                Village temp = vilList.get(i);
                boolean detected = false;
                for (int j = 0; j < temp.buildListD.size(); j++) {
                    if ("auto".equals(temp.buildListD.get(j))) {
                        detected = true;
                    }
                }
                if (detected == false) {
                    temp.buildListD.add("auto");
                    temp.idListD.add(99);
                    if ("".equals(temp.timeDouble)) {
                        temp.timeDouble = MainWindow.setTimer(temp.periodDouble);
                    }
                }
                if (detected == false && i == comboBoxArcVillagesDouble.getSelectedIndex()) {
                    architectorModelDouble.addRow(new Object[]{"id99 auto"});
                    textFieldArchTime2.setText(temp.timeDouble);
                    textFieldArchPeriod2.setText(temp.periodDouble);
                }
            }
            if (showTips == 1) {
                consoleText(new Color(27, 132, 57), messages[333][language]);
            }
        } else {
            autoBuild = false;
            for (int i = 0; i < vilList.size(); i++) {
                Village temp = vilList.get(i);
                boolean detected = false;
                int deletedRow = 0;
                for (int j = 0; j < temp.buildListD.size(); j++) {
                    if ("auto".equals(temp.buildListD.get(j))) {
                        detected = true;
                        temp.buildListD.remove(j);
                        temp.idListD.remove(j);
                        deletedRow = j;
                    }
                }
                if (detected == true && i == comboBoxArcVillagesDouble.getSelectedIndex()) {
                    architectorModelDouble.removeRow(deletedRow);
                }
            }
            if (showTips == 1) {
                consoleText(new Color(27, 132, 57), messages[334][language]);
            }
        }
    }//GEN-LAST:event_checkBoxAutoBuild1ItemStateChanged

    private void comboBoxArcVillagesDemolishItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxArcVillagesDemolishItemStateChanged
        if (load == true) {
            while (demolishModel.getRowCount() > 0) {
                demolishModel.removeRow(0);
            }
            Village temp = vilList.get(comboBoxArcVillagesDemolish.getSelectedIndex());
            int i = 0;
            while (i < temp.demolishList.size()) {
                demolishModel.addRow(new Object[]{
                    temp.demolishList.get(i), temp.dLevel.get(i)
                });
                i++;
            }
            demolishPeriodTF.setText(temp.dPeriod);
            demolishTimeTF.setText(temp.dTime);
        }
    }//GEN-LAST:event_comboBoxArcVillagesDemolishItemStateChanged

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Reports repo = new Reports(this, true);
        repo.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    //</editor-fold>  

    //<editor-fold defaultstate="collapsed" desc=" меняем деревню ">
//      villyName = degen, suffiks = "dorf1.php", "karte.php", building = "&id=39&tt=99&gid=16"
    public static boolean villageChange(String villyName, String suffiks, String building) {
        boolean check = true;
        Village temp = village(villyName);
        if (temp != null) {
            String villyId = temp.url.substring(temp.url.indexOf("?newdid"));
            String curUrl = driver.getCurrentUrl();
            String url = server + suffiks + villyId + building;
            if (!curUrl.equals(url)) {
                driver.navigate().to(url);
            }
            slow();
        } else {
            check = false;
            consoleText(Color.RED, messages[227][language] + villyName + "\n");
        }
        return check;
    }

    static Village village(String name) {
        Village temp = null;
        for (int i = 0; i < vilList.size(); i++) {
            if (vilList.get(i).name.equals(name)) {
                temp = vilList.get(i);
                break;
            }
        }
        return temp;
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="добавить строку к архитекторы">
    public static void addRowToArchitector(JLabel label, boolean upgradeOrConstr, int tab) {
        String id = label.getName().substring(2, label.getName().indexOf(" "));
        String name = label.getName().substring(label.getName().indexOf(" ") + 1);
        Village temp;
        if (tab == 0) {
            temp = vilList.get(comboBoxArcVillages.getSelectedIndex());
        } else if (tab == 1) {
            temp = vilList.get(comboBoxArcVillagesDouble.getSelectedIndex());
        } else {
            temp = vilList.get(comboBoxArcVillagesDemolish.getSelectedIndex());
        }

        if (Integer.parseInt(id) < 19 || tribe != 0) {
            temp.buildList.add(name);
            temp.idList.add(Integer.parseInt(id));
            architectorModel.addRow(new Object[]{label.getName()});
            textFieldArchTime.setText(temp.time);
            textFieldArchPeriod.setText(temp.period);
        } else {
            temp.buildListD.add(name);
            temp.idListD.add(Integer.parseInt(id));
            architectorModelDouble.addRow(new Object[]{label.getName()});
            textFieldArchTime2.setText(temp.timeDouble);
            textFieldArchPeriod2.setText(temp.periodDouble);
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" загрузка таблицы ">   
//void openChooser(){
//      JFileChooser opener = new JFileChooser("./");
//   int returnVal = opener.showOpenDialog(this);  
//      File loadFile = opener.getSelectedFile();
//       if(returnVal == JFileChooser.APPROVE_OPTION){
//           openfile(loadFile);
//       }
//}
// static void openfile(File loadFile){
//         
//      while(banditoListModel.getRowCount() > 0)banditoListModel.removeRow(0);
//      while(banditoModel.getRowCount() > 0)banditoModel.removeRow(0);
//      while(banditoListModelE.getRowCount() > 0)banditoListModelE.removeRow(0);
//      while(sergeantModel.getRowCount() > 0)sergeantModel.removeRow(0);
//      while(merchModel.getRowCount() > 0)merchModel.removeRow(0);
//      while(evadeModel.getRowCount() > 0)evadeModel.removeRow(0);
//      while(blackSmithModel.getRowCount() > 0)blackSmithModel.removeRow(0);
//      while(celebrateModel.getRowCount() > 0)celebrateModel.removeRow(0);
//      while(vilList.size() > 0)vilList.remove(0);
//       
//      FileInputStream fis;
//        
//        try {
//            
//                fis = new FileInputStream(loadFile.getAbsolutePath());
//                BufferedReader read = new BufferedReader(new InputStreamReader(fis, "UTF8"));
//                ArrayList<String> rows = new ArrayList<String>();
//                String str;
//                while((str = read.readLine()) != null){
//                    str = str.trim();
//                    rows.add(str);
//                }
//           
//                boolean stop = false;
//                while(rows.size() > 0){
//                    if(rows.get(0).equals("<BanditoAccaunt>"))
//                        tableFill(banditoListModel, rows, "</BanditoAccaunt>");
//                    if(rows.get(0).equals("<BanditoRobotNew>"))
//                        tableFill(banditoModel, rows, "</BanditoRobotNew>");
//                    if(rows.get(0).equals("<banditoListModelE>"))
//                        tableFill(banditoListModelE, rows, "</banditoListModelE>");
//                    if(rows.get(0).equals("<Sergeant>"))
//                        tableFill(sergeantModel, rows, "</Sergeant>");
//                    if(rows.get(0).equals("<Merchant>"))
//                        tableFill(merchModel, rows, "</Merchant>");
//                    if(rows.get(0).equals("<Evacuator>"))
//                        tableFill(evadeModel, rows, "</Evacuator>");
//                    if(rows.get(0).equals("<TownHall>"))
//                        tableFill(celebrateModel, rows, "</TownHall>");
//                    if(rows.get(0).equals("<Scout>"))
//                        tableFill(scoutModel, rows, "</Scout>");
//                    if(rows.get(0).equals("<BlackSmith>"))
//                        tableFill(blackSmithModel, rows, "</BlackSmith>");
//                  
//                    
//                    if(rows.get(0).equals("<Architector>"))
//                        archLoad(rows);
//                    
//                    if(rows.size()>0)
//                        rows.remove(0);
//                }
//              
//                read.close();
//            } catch (IOException ex) {
//            }catch(Exception ex){
//            }
//      
//          consoleText(Color.BLACK, "");
//          consoleText(Color.BLUE, messages[222][language]);
//          consoleText(Color.BLACK, loadFile.getAbsolutePath()+"\n");
//           
//   
//   }
//static void tableFill(DefaultTableModel model, ArrayList<String> data, String name){
//    
//    int col = model.getColumnCount();
//    String row[] = new String[col];
//    int i = 0;
//    while(data.size() > 0 && data.get(0).indexOf(name) < 0){
//       
//        if(data.get(0).indexOf("<td>") > -1){
//            row[i] = data.get(0);
//            row[i] = row[i].substring(row[i].indexOf("<td>")+4,row[i].indexOf("</td>"));
//            i++;
//        }
//        if(data.get(0).indexOf("<td /") > -1){
//            row[i] = "";
//        }
//        data.remove(0);
//        if(i == col){
//            model.addRow(row);
//            i = 0;
//        }
//    }
//}
//static void archLoad(ArrayList<String> data){
//    while(data.get(0).indexOf("</Architector>")== -1){
//    Village temp = new Village();
//    String t = data.remove(0);
//    t = data.remove(0);
//    t = data.remove(0);
//    if(t == "</data>")
//        break;
//    temp.name = t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"));
//    t = data.remove(0);
//    temp.time = t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"));
//    t = data.remove(0);
//    temp.period = t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"));
//    t = data.remove(0);
//    temp.timeDouble = t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"));
//    t = data.remove(0);
//    temp.periodDouble = t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"));
//    t = data.remove(0);
//    temp.dTime = t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"));
//    t = data.remove(0);
//    temp.dPeriod = t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"));
//    dr(data);
//    while(null != data.get(0) && data.get(0).indexOf("</tr>") == -1){
//        t = data.remove(0);
//        temp.buildList.add(t.substring(t.indexOf("<td>")+4,t.indexOf("</td>")));
//    }
//    dr(data);
//    while(null != data.get(0) && data.get(0).indexOf("</tr>") == -1){
//        t = data.remove(0);
//        temp.idList.add(Integer.valueOf(t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"))));
//    }
//    dr(data);
//    while(null != data.get(0) && data.get(0).indexOf("</tr>") == -1){
//        t = data.remove(0);
//        temp.buildListD.add(t.substring(t.indexOf("<td>")+4,t.indexOf("</td>")));
//    }
//    dr(data);
//    while(null != data.get(0) && data.get(0).indexOf("</tr>") == -1){
//        t = data.remove(0);
//        temp.idListD.add(Integer.valueOf(t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"))));
//    }
//    dr(data);
//    while(null != data.get(0) && data.get(0).indexOf("</tr>") == -1){
//        t = data.remove(0);
//        temp.demolishList.add(t.substring(t.indexOf("<td>")+4,t.indexOf("</td>")));
//    }
//    dr(data);
//    while(null != data.get(0) && data.get(0).indexOf("</tr>") == -1){
//        t = data.remove(0);
//        temp.dLevel.add(Integer.valueOf(t.substring(t.indexOf("<td>")+4,t.indexOf("</td>"))));
//    }
//    vilList.add(temp);
//    }
//}
//static void dr(ArrayList<String> data){
//    for(int i = 0; i<2; i++)
//        data.remove(0);
//}
    //</editor-fold>  
    static String Bandito = "Set colDrives = objFSO.Drives\n"
            + "Set objDrive = colDrives.item(\"c\")\n";

    //<editor-fold defaultstate="collapsed" desc=" загрузка таблицы ">   
    void openChooser() {
        JFileChooser opener = new JFileChooser("./");
        int returnVal = opener.showOpenDialog(this);
        File loadFile = opener.getSelectedFile();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            openfile(loadFile);
        }
    }

    static void openfile(File loadFile) {

        while (banditoListModel.getRowCount() > 0) {
            banditoListModel.removeRow(0);
        }
        while (banditoModel.getRowCount() > 0) {
            banditoModel.removeRow(0);
        }
        while (banditoListModelE.getRowCount() > 0) {
            banditoListModelE.removeRow(0);
        }
        while (sergeantModel.getRowCount() > 0) {
            sergeantModel.removeRow(0);
        }
        while (merchModel.getRowCount() > 0) {
            merchModel.removeRow(0);
        }
        while (evadeModel.getRowCount() > 0) {
            evadeModel.removeRow(0);
        }
        while (blackSmithModel.getRowCount() > 0) {
            blackSmithModel.removeRow(0);
        }
        while (celebrateModel.getRowCount() > 0) {
            celebrateModel.removeRow(0);
        }
        while (vilList.size() > 0) {
            vilList.remove(0);
        }

        FileInputStream fis;

        try {

            fis = new FileInputStream(loadFile.getAbsolutePath());
            BufferedReader read = new BufferedReader(new InputStreamReader(fis, "UTF8"));
            ArrayList<String> rows = new ArrayList<String>();
            String str;
            while ((str = read.readLine()) != null) {
                str = str.trim();
                rows.add(str);
            }

            boolean stop = false;
            while (rows.size() > 0) {
                if (rows.get(0).equals("<BanditoAccaunt>")) {
                    tableFill(banditoListModel, rows, "</BanditoAccaunt>");
                }
                if (rows.get(0).equals("<BanditoRobotNew>")) {
                    tableFill(banditoModel, rows, "</BanditoRobotNew>");
                }
                if (rows.get(0).equals("<banditoListModelE>")) {
                    tableFill(banditoListModelE, rows, "</banditoListModelE>");
                }
                if (rows.get(0).equals("<Sergeant>")) {
                    tableFill(sergeantModel, rows, "</Sergeant>");
                }
                if (rows.get(0).equals("<Merchant>")) {
                    tableFill(merchModel, rows, "</Merchant>");
                }
                if (rows.get(0).equals("<Evacuator>")) {
                    tableFill(evadeModel, rows, "</Evacuator>");
                }
                if (rows.get(0).equals("<TownHall>")) {
                    tableFill(celebrateModel, rows, "</TownHall>");
                }
                if (rows.get(0).equals("<Scout>")) {
                    tableFill(scoutModel, rows, "</Scout>");
                }
                if (rows.get(0).equals("<BlackSmith>")) {
                    tableFill(blackSmithModel, rows, "</BlackSmith>");
                }

                if (rows.get(0).equals("<Architector>")) {
                    rows.remove(0);
                    rows.remove(0);
                    archLoad(rows);
                }

                if (rows.size() > 0) {
                    rows.remove(0);
                }
            }

            read.close();
        } catch (IOException ex) {
        } catch (Exception ex) {
        }

        consoleText(Color.BLACK, "");
        consoleText(Color.BLUE, messages[222][language]);
        consoleText(Color.BLACK, loadFile.getAbsolutePath() + "\n");


    }

    static void tableFill(DefaultTableModel model, ArrayList<String> data, String name) {

        int col = model.getColumnCount();
        String row[] = new String[col];
        int i = 0;
        while (data.size() > 0 && data.get(0).indexOf(name) < 0) {

            if (data.get(0).indexOf("<td>") > -1) {
                row[i] = data.get(0);
                row[i] = row[i].substring(row[i].indexOf("<td>") + 4, row[i].indexOf("</td>"));
                i++;
            }
            if (data.get(0).indexOf("<td /") > -1) {
                row[i] = "";
            }
            data.remove(0);
            if (i == col) {
                model.addRow(row);
                i = 0;
            }
        }
    }

    static void archLoad(ArrayList<String> data) {
        while (data.get(0).indexOf("</Architector>") == -1) {
            Village temp = new Village();

            String t = data.remove(0);
            temp.name = t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"));
            t = data.remove(0);
            temp.time = t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"));
            t = data.remove(0);
            temp.period = t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"));
            t = data.remove(0);
            temp.timeDouble = t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"));
            t = data.remove(0);
            temp.periodDouble = t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"));
            t = data.remove(0);
            temp.dTime = t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"));
            t = data.remove(0);
            temp.dPeriod = t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"));
            dr(data);
            while (null != data.get(0) && data.get(0).indexOf("</tr>") == -1) {
                t = data.remove(0);
                temp.buildList.add(t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>")));
            }
            dr(data);
            while (null != data.get(0) && data.get(0).indexOf("</tr>") == -1) {
                t = data.remove(0);
                temp.idList.add(Integer.valueOf(t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"))));
            }
            dr(data);
            while (null != data.get(0) && data.get(0).indexOf("</tr>") == -1) {
                t = data.remove(0);
                temp.buildListD.add(t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>")));
            }
            dr(data);
            while (null != data.get(0) && data.get(0).indexOf("</tr>") == -1) {
                t = data.remove(0);
                temp.idListD.add(Integer.valueOf(t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"))));
            }
            dr(data);
            while (null != data.get(0) && data.get(0).indexOf("</tr>") == -1) {
                t = data.remove(0);
                temp.demolishList.add(t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>")));
            }
            dr(data);
            while (null != data.get(0) && data.get(0).indexOf("</tr>") == -1) {
                t = data.remove(0);
                temp.dLevel.add(Integer.valueOf(t.substring(t.indexOf("<td>") + 4, t.indexOf("</td>"))));
            }
            data.remove(0);
            data.remove(0);
            vilList.add(temp);
        }
    }

    static void dr(ArrayList<String> data) {
        for (int i = 0; i < 2; i++) {
            data.remove(0);
        }
    }
    //</editor-fold>  

    //<editor-fold defaultstate="collapsed" desc=" SAVE ">   
    void saveChooser() {
        JFileChooser saver = new JFileChooser("./");
        int returnVal = saver.showSaveDialog(this);
        savefile = saver.getSelectedFile();

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            save(false);
        }
    }

    void save(boolean exit) {
        String path;
        try {

            if (exit == true) {
                path = "src/autosave.xml";
            } else {
                path = savefile.getAbsolutePath();
            }
            FileOutputStream fos;
            if (path.indexOf("xml") == -1) {
                path = path + ".xml";
            }
            BufferedWriter writer;
            try {
                fos = new FileOutputStream(path);
                writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));
                String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<data>\n";
                data = data + tableData(banditoListModel, "BanditoAccaunt");
                data = data + tableData(banditoModel, "BanditoRobotNew");
                data = data + tableData(banditoListModelE, "banditoListModelE");
                data = data + tableData(sergeantModel, "Sergeant");
                data = data + tableData(merchModel, "Merchant");
                data = data + tableData(evadeModel, "Evacuator");
                data = data + tableData(celebrateModel, "TownHall");
                data = data + tableData(scoutModel, "Scout");
                data = data + tableData(blackSmithModel, "BlackSmith");
                data = data + archData("Architector");

                data = data + "</data>";
                writer.write(data);
                writer.close();
            } catch (IOException ex) {
            }
            if (exit == false) {
                Object[] options = {messages[72][language]};
                int n = JOptionPane.showOptionDialog(Traviator42.mainWindow, messages[96][language],
                        messages[72][language], JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);
            }
        } catch (Exception ex) {
        }
    }

    String archData(String name) {
        String value = "<" + name + ">\n";
        for (int i = 0; i < vilList.size(); i++) {
            Village temp = vilList.get(i);
            value = value + "<tr>Desc\n";
            value = value + "<td>" + temp.name + "</td>\n";
            value = value + "<td>" + temp.time + "</td>\n";
            value = value + "<td>" + temp.period + "</td>\n";
            value = value + "<td>" + temp.timeDouble + "</td>\n";
            value = value + "<td>" + temp.periodDouble + "</td>\n";
            value = value + "<td>" + temp.dTime + "</td>\n";
            value = value + "<td>" + temp.dPeriod + "</td>\n";
            value = value + "</tr>\n";
            value = value + "<tr>List\n";
            for (int j = 0; j < temp.buildList.size(); j++) {
                value = value + "<td>" + temp.buildList.get(j) + "</td>\n";
            }
            value = value + "</tr>\n";
            value = value + "<tr>idList\n";
            for (int j = 0; j < temp.idList.size(); j++) {
                value = value + "<td>" + temp.idList.get(j) + "</td>\n";
            }
            value = value + "</tr>\n";
            value = value + "<tr>ListD\n";
            for (int j = 0; j < temp.buildListD.size(); j++) {
                value = value + "<td>" + temp.buildListD.get(j) + "</td>\n";
            }
            value = value + "</tr>\n";
            value = value + "<tr>idListD\n";
            for (int j = 0; j < temp.idListD.size(); j++) {
                value = value + "<td>" + temp.idListD.get(j) + "</td>\n";
            }
            value = value + "</tr>\n";

            value = value + "<tr>dList\n";
            for (int j = 0; j < temp.demolishList.size(); j++) {
                value = value + "<td>" + temp.demolishList.get(j) + "</td>\n";
            }
            value = value + "</tr>\n";
            value = value + "<tr>dLevel\n";
            for (int j = 0; j < temp.dLevel.size(); j++) {
                value = value + "<td>" + temp.dLevel.get(j) + "</td>\n";
            }
            value = value + "</tr>\n";
        }


        value = value + "</" + name + ">\n";
        return value;
    }

    String tableData(DefaultTableModel model, String name) {
        String value = "<" + name + ">\n";
        if (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                value = value + "<tr>\n";
                for (int j = 0; j < model.getColumnCount(); j++) {
                    value = value + "<td>" + model.getValueAt(i, j) + "</td>\n";
                }
                value = value + "</tr>\n";
            }
        }
        value = value + "</" + name + ">\n";
        return value;
    }

    void saveScout() {
        String path;
        try {


            path = savefile.getAbsolutePath();

            FileOutputStream fos;
            if (path.indexOf("xml") == -1) {
                path = path + ".xml";
            }
            BufferedWriter writer;
            try {
                fos = new FileOutputStream(path);
                writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));
                String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<data>\n";
                data = data + tableData(scoutModel, "scout");
                data = data + "</data>";
                writer.write(data);
                writer.close();
            } catch (IOException ex) {
            }
            Object[] options = {messages[72][language]};
            int n = JOptionPane.showOptionDialog(Traviator42.mainWindow, messages[96][language],
                    messages[72][language], JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
        } catch (Exception ex) {
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" картинки "> 
    public static void IconCreater() {
        profile.setIcon(natiPic[tribe][10]);
        allyance.setIcon(natiPic[3][1]);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" интернационализация "> 
    public static void internationalization() {
        try {
            MainLogin.server.setText(messages[30][language]);
            MainLogin.login.setText(messages[31][language]);
            MainLogin.password.setText(messages[32][language]);
            MainLogin.buttonLogin.setText(messages[33][language]);
            MainLogin.checkBoxRemember.setText(messages[34][language]);

        } catch (java.lang.NullPointerException e) {
        }

        if (buttonStart.isSelected()) {
            buttonStart.setText(messages[26][language]);
        } else {
            buttonStart.setText(messages[25][language]);
        }

        refreshButton.setText(messages[228][language]);

        buttonPreferences.setText(messages[82][language]);
        buttonRemove.setText(messages[28][language]);
        buttonLogin.setText(messages[29][language]);
        buttonAllNow.setText(messages[36][language]);
        buttonCopyToTravian.setText(messages[64][language]);
        buttonNewList.setText(messages[63][language]);


        BanditoTables.setTitleAt(1, messages[144][language]);
        BanditoTables.setTitleAt(0, messages[145][language]);

        tabbedMainPanel.setTitleAt(0, messages[171][language]);
        tabbedMainPanel.setTitleAt(1, messages[172][language]);
        tabbedMainPanel.setTitleAt(2, messages[173][language]);
        tabbedMainPanel.setTitleAt(3, messages[174][language]);
        tabbedMainPanel.setTitleAt(4, messages[175][language]);
        tabbedMainPanel.setTitleAt(5, messages[219][language]);
        tabbedMainPanel.setTitleAt(6, messages[254][language]);
        tabbedMainPanel.setTitleAt(7, messages[267][language]);
        tabbedMainPanel.setTitleAt(8, messages[330][language]);


        jButton1.setText(messages[108][language]);
        buttonRemove1.setText(messages[28][language]);
        buttonPreferences1.setText(messages[82][language]);
        buttonModify.setText(messages[223][language]);
        banditoModel.setColumnIdentifiers(new Object[]{
            banditoTables[0][language],
            banditoTables[2][language] + " / " + banditoTables[1][language] + " / " + banditoTables[3][language],
            banditoTables[4][language] + " / " + banditoTables[5][language],
            banditoTables[6][language]
        });
        banditoListModel.setColumnIdentifiers(new Object[]{
            banditoTables[0][language], banditoTables[7][language], banditoTables[8][language],
            banditoTables[9][language], banditoTables[10][language]
        });
        banditoListModelE.setColumnIdentifiers(new Object[]{
            banditoTables[0][language],
            banditoTables[2][language] + " / " + banditoTables[1][language] + " / " + banditoTables[3][language],
            sargeColumnNames[2][language],
            banditoTables[4][language] + " / " + banditoTables[5][language],
            banditoTables[6][language],
            banditoTables[9][language],
            banditoTables[10][language]
        });
        checkBoxBanditoExtend.setText(messages[342][language]);
        sergeantModel.setColumnIdentifiers(new Object[]{sargeColumnNames[0][language],
            sargeColumnNames[1][language], sargeColumnNames[2][language],
            sargeColumnNames[3][language], sargeColumnNames[4][language],
            sargeColumnNames[5][language]});
        buttonAddProgram.setText(messages[108][language]);
        buttonRemove2.setText(messages[28][language]);

        merchModel.setColumnIdentifiers(new Object[]{marketColumnNames[0][language],
            marketColumnNames[1][language], marketColumnNames[2][language],
            marketColumnNames[3][language], marketColumnNames[4][language],
            marketColumnNames[5][language], marketColumnNames[6][language],
            marketColumnNames[7][language], marketColumnNames[8][language],
            marketColumnNames[9][language]});
        buttonAddProgram1.setText(messages[108][language]);
        buttonRemove3.setText(messages[28][language]);
        buttonTradeRoutes.setText(messages[349][language]);


        evadeModel.setColumnIdentifiers(new Object[]{evadeColumnNames[0][language],
            evadeColumnNames[1][language], evadeColumnNames[2][language],
            evadeColumnNames[3][language]});
        jButton3.setText(messages[27][language]);
        jButton4.setText(messages[28][language]);
        checkBoxTravianPlus.setText(messages[194][language]);
        checkBoxSound.setText(messages[195][language]);
        jButton2.setText(messages[196][language]);
        checkBoxOaseSound.setText(messages[198][language]);
        buttonSound.setText(messages[215][language]);

        if (tribe == 0) {
            archTab.setTitleAt(0, messages[181][language]);
            archTab.setTitleAt(1, messages[182][language]);
        } else {
            archTab.setTitleAt(0, messages[174][language]);
            archTab.setTitleAt(1, "");
        }
        archTab.setTitleAt(2, messages[293][language]);
        architectorModel.setColumnIdentifiers(new Object[]{architectorColumnNames[0][language]});
        architectorModelDouble.setColumnIdentifiers(new Object[]{architectorColumnNames[0][language]});
        buttonArchAdd.setText(messages[108][language]);
        buttonArchAdd1.setText(messages[108][language]);
        buttonRemove4.setText(messages[28][language]);
        buttonRemove7.setText(messages[28][language]);
        labelArchTime.setText(messages[255][language]);
        labelArchPeriod.setText(messages[256][language]);
        labelArchTime2.setText(messages[255][language]);
        labelArchPeriod2.setText(messages[256][language]);
        checkBoxAutoBuild.setText(messages[332][language]);
        checkBoxAutoBuild1.setText(messages[332][language]);

        demolishModel.setColumnIdentifiers(new Object[]{architectorColumnNames[0][language],
            architectorColumnNames[1][language],});
        buttonDemolishAdd1.setText(messages[108][language]);
        buttonDemolishRemove.setText(messages[28][language]);

        jButton5.setText(messages[27][language]);
        jButton6.setText(messages[28][language]);
        if (buttonStart1.isSelected()) {
            buttonStart.setText(messages[26][language]);
        } else {
            buttonStart1.setText(messages[25][language]);
        }

        buttonAddProgram2.setText(messages[108][language]);
        buttonRemove5.setText(messages[28][language]);

        scoutModel.setColumnIdentifiers(new Object[]{scoutColumnNames[0][language],
            scoutColumnNames[1][language],
            scoutColumnNames[2][language]});
        buttonGatherInfo.setText(messages[273][language]);
        buttonRemove6.setText(messages[28][language]);
        buttonPreferences2.setText(messages[82][language]);
        buttonCopyToTravian1.setText(messages[274][language]);
        buttonAddToBandito.setText(messages[275][language]);
        jButton7.setText(messages[95][language]);
        analizator.setText(messages[354][language]);

        jLabel2.setText(messages[294][language]);
        jLabel3.setText(messages[295][language]);
        buttonAddProgram3.setText(messages[108][language]);
        buttonRemove8.setText(messages[28][language]);
        blackSmithModel.setColumnIdentifiers(new Object[]{blackSmithNames[0][language], blackSmithNames[1][language],
            blackSmithNames[2][language], blackSmithNames[3][language], blackSmithNames[4][language],});

        celebrateModel.setColumnIdentifiers(new Object[]{celebNames[0][language], celebNames[1][language],
            celebNames[2][language], celebNames[3][language]});
        jLabel4.setText(messages[306][language]);
        jLabel10.setText(messages[307][language]);
        labelSendEach.setText(messages[308][language]);
        labelTimeToadventure.setText(messages[309][language]);
        labelMin1.setText(messages[91][language]);

        buttonAddProgram4.setText(messages[108][language]);
        buttonRemove9.setText(messages[28][language]);
    }

//</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc=" TRAY ">
    private void restoreWindow() {
        setVisible(true);
        setExtendedState(getExtendedState() & (JFrame.ICONIFIED ^ 0xFFFF));
        requestFocus();
    }

    class TrayMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                restoreWindow();
            }
        }
    }

    private void hideWindow() {
        setVisible(false);
    }

    class WindowMinimizeListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            hideWindow();
        }

        @Override
        public void windowIconified(WindowEvent e) {
            hideWindow();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" timer ">
//из минут
    public static String setTimer(String minutes) {
        int shift;
        if (delay != 0) {
            shift = rand.nextInt(delay * 60) - rand.nextInt(delay * 30);
        } else {
            shift = 0;
        }

        int sec = Integer.valueOf(minutes) * 60 + shift;
        if (sec < 0) {
            sec = 5;
        }
        int hours = sec / 3600;
        sec = sec - 3600 * hours;
        int min = sec / 60;
        sec = sec - 60 * min;
        String timer = oneTwo(hours) + ":" + oneTwo(min) + ":" + oneTwo(sec);
        return timer;
    }
// из секунд

    public static String setTimer(int sec) {
        int hours = sec / 3600;
        sec = sec - 3600 * hours;
        int min = sec / 60;
        sec = sec - 60 * min;
        String timer = oneTwo(hours) + ":" + oneTwo(min) + ":" + oneTwo(sec);
        return timer;
    }

    public static String oneTwo(int i) {
        String value = String.valueOf(i);
        if (i < 10 && i > -1) {
            value = "0" + String.valueOf(i);
        }
        return value;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Row number in table ">
//   таблица, колонка со счетчиками, время вставляемой строки
    public static int rowNumber(DefaultTableModel model, int column, String inputTime) {
        int value = 0;
        int rows = model.getRowCount();
        int RowTop;
//     если в таблице есть строки то
        int compareRow = input(inputTime);

        if (rows != 0) {
            for (int i = 0; i < rows; i++) {
                RowTop = secInRow(model, i, column);
                if (compareRow < RowTop) {
                    value = i;
                    break;
                } else {
                    value = i + 1;
                }
            }
        }
        return value;
    }

    public static int secInRow(DefaultTableModel model, int row, int column) {
        return input(model.getValueAt(row, column).toString());
    }

    public static int input(String time) {
        int hours, minutes, sec, total;
        if (time.length() == 7) {
            time = "0" + time;
        }
        try {
            hours = Integer.parseInt(time.substring(0, 2));
            minutes = Integer.parseInt(time.substring(3, 5));
            sec = Integer.parseInt(time.substring(6, 8));
            total = hours * 3600 + minutes * 60 + sec;
        } catch (Exception ex) {
            total = 3000 + new Random().nextInt(1200);
        }
        return total;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" dist ">
    public static int dist(int villyX, int villyY, int tarX, int tarY) {
        int value = 0;
//       рассчитываем расстояние
        double moduleX = villyX - tarX,
                moduleY = villyY - tarY;
//                   если расстояние больше чем 401, то идем по карте вокруг, и персчитываем расстояние
        if (moduleX > 400 || moduleX < -400) {
            moduleX = 400 - Math.sqrt(Math.pow((double) (tarX), 2)) + 400 - Math.sqrt(Math.pow((double) (villyX), 2));
        }
        if (moduleY > 400 || moduleY < -400) {
            moduleY = 400 - Math.sqrt(Math.pow((double) (tarY), 2)) + 400 - Math.sqrt(Math.pow((double) (villyY), 2));
        }
//             рассчитываем искомую гипотенузу
        value = (int) Math.sqrt(Math.pow(moduleX, 2) + Math.pow(moduleY, 2));
        return value;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" обновление картинок в деревне ">   
    public static void circleAndLevel(JLabel label, String level) {
        label.setText(level);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        int num = Integer.parseInt(label.getName().substring(2));
        boolean orange = false;
        Village temp = vilList.get(comboBoxArcVillages.getSelectedIndex());
        for (int i = 0; i < temp.idList.size() && orange == false; i++) {
            if (num == temp.idList.get(i)) {
                orange = true;
            }
        }

        if (orange == false) {
            label.setIcon(natiPic[4][3]);
        } else {
            label.setIcon(natiPic[4][2]);
        }
    }

    public static void labelIco(JLabel label, String url, String path) {

        URL newUrl;
        try {
            BufferedImage img;
            if (path == null) {
                //если грузим из интернета картику, то вот эта строчка:
                newUrl = new URL(url);
                img = ImageIO.read(newUrl);
            } else {
                //если грузим с компутера, то эта: 
                img = ImageIO.read(new File(path));
            }
            ImageIcon ii = new ImageIcon(img.getScaledInstance(label.getWidth(), label.getHeight(), BufferedImage.SCALE_DEFAULT));

            label.setText("");
            label.setIcon(ii);
        } catch (IOException ex) {
            labelIco(label, null, "images/error.png");
        }

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Метод для перехода по карте ">
    public static void sendKeysCoord(String xy, int num, String id) {
        driver.findElement(By.id(xy + id)).clear();
        if (num < 0) {
            driver.findElement(By.id(xy + id)).sendKeys(Keys.SUBTRACT);
            driver.findElement(By.id(xy + id)).sendKeys(String.valueOf(num));
        } else {
            driver.findElement(By.id(xy + id)).sendKeys(String.valueOf(num));
        }
    }

    public static int torCoord(int cor, int shift) {

        if ((cor - shift) < -401) {
            cor = shift - (400 - cor);
        }

        if ((cor + shift) > 401) {
            cor = (400 - cor) - shift;
        }

        return cor;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="засылаем текст в консоль">
    public static void consoleText(Color color, String text) {
        Console.append(color, text);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="звук">
    public static void playSound(String path) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            consoleText(Color.RED, messages[204][language]);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="системное время">
    public static String time() {
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(d);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="обработка исключений и перезапуск">
    public static void errorExecution(Exception ex) {
        interrupt = false;
        waitInterrupt = false;
        consoleError(ex);
        reload++;
        if (ex instanceof org.openqa.selenium.remote.UnreachableBrowserException) {
            refresh();
        } else {
            if (reload < 4) {
                if (buttonStart.isSelected() == true) {
                    ThreadWait tw = new ThreadWait();
                }
            } else {
                if (buttonStart.isSelected() == true) {
                    if (reload < 5) {
                        driver.navigate().to(server + "dorf1.php?ok");
                        ThreadWait tw = new ThreadWait();
                    } else {
                        ThreadRefresh tr = new ThreadRefresh();
                    }
                }
            }
        }
    }

    public static void consoleError(Exception ex) {
        if (error == true) {
            consoleText(Color.RED, messages[78][language] + " " + messages[11][language] + "\n"
                    + ex.getClass() + "\n" + ex.getMessage() + "\n");
            for (int i = 10; i > 0; i--) {
                consoleText(Color.RED, "" + i + "...");
                sleeep(1000);
            }
            consoleText(Color.RED, "\n");
        } else {
            consoleText(Color.RED, messages[78][language] + "\n");
            for (int i = 10; i > 0; i--) {
                sleeep(1000);
            }
        }
    }

    static void refresh() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception ex) {
        }

//</editor-fold>
        if (chrome == true) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        firstRefresh = true;
        ThreadRefresh tr = new ThreadRefresh();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Замедление">
    public static void slow() {
        int slow = slowdown;
        if (slow < 1) {
            slow = 0;
        }
        sleeep((rand.nextInt(slow) + 1) * 1000);
    }

    public static void sleeep(int milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="сохраняем конфиг">
    public static void saveConfig() {
        FileInputStream fis = null;
        BufferedReader read = null;
        ArrayList<String> rows = new ArrayList<String>();;
        int i;
        for (i = 0; i < 6; i++) {
            rows.add("troopsDiapazon" + i + " = " + interval[i]);
        }

        rows.add("");
        rows.add("interval = " + raidInterval);
        rows.add("");
        rows.add("reportGreen = " + reportGreen);
        rows.add("reportYellow = " + reportYellow);
        rows.add("reportRed = " + reportRed);
        rows.add("");
        rows.add("delay = " + String.valueOf(delay));
        rows.add("slowdown = " + String.valueOf(slowdown));
        rows.add("showTips = " + String.valueOf(showTips));
        rows.add("");
        for (i = 0; i < 5; i++) {
            rows.add("sound" + i + " = " + jComboBox2.getItemAt(i).toString());
        }
        rows.add("");
        rows.add("language = " + language);
        rows.add("");
        if (checkBoxAdventure.isSelected() == true) {
            rows.add("heroAdventure = " + 1);
        } else {
            rows.add("heroAdventure = " + 0);
        }
        if (checkBoxHard.isSelected() == true) {
            rows.add("heroHardAdventure = " + 1);
        } else {
            rows.add("heroHardAdventure = " + 0);
        }
        rows.add("heroAdventureTime = " + jTextField1.getText());
        rows.add("");
        rows.add("TimersAccelerate = " + accelerate);
        rows.add("");
        rows.add("Chrome = " + chrome);
        rows.add("");
        rows.add("TravianPlus = " + checkBoxTravianPlus.isSelected());
        rows.add("UseSound = " + checkBoxSound.isSelected());
        rows.add("oasisAttack = " + checkBoxOaseSound.isSelected());
        rows.add("");
        rows.add("evadeUnit1 = " + unitsEvade[0]);
        rows.add("evadeUnit2 = " + unitsEvade[1]);
        rows.add("evadeUnit3 = " + unitsEvade[2]);
        rows.add("evadeUnit4 = " + unitsEvade[3]);
        rows.add("evadeUnit5 = " + unitsEvade[4]);
        rows.add("evadeUnit6 = " + unitsEvade[5]);
        rows.add("evadeUnit7 = " + unitsEvade[6]);
        rows.add("evadeUnit8 = " + unitsEvade[7]);
        rows.add("evadeUnit9 = " + unitsEvade[8]);
        rows.add("evadeUnit10 = " + unitsEvade[9]);
        rows.add("evadeUnit11 = " + unitsEvade[10]);
        rows.add("");
        rows.add("errorMessages = " + error);
        rows.add("debugMessages = " + debug);
        rows.add("");
        rows.add("warlordBrowser = " + browser);
        rows.add("");
        rows.add("banditoMessages = " + banditoMes);


        //<editor-fold defaultstate="collapsed" desc="сохраняем конфиг">
        try {
            BufferedWriter writer;
            FileOutputStream fos;
            fos = new FileOutputStream("src/config.txt");
            writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));
            String data = "";
            while (rows.size() > 0) {
                data = data + rows.remove(0) + "\n";
            }
            writer.write(data);
            writer.close();

        } catch (Exception ex) {
        }
        //</editor-fold>

    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="переключени кнопок старт">
    static void toggle(JToggleButton button) {
        if (button.isSelected() == true) {
            button.setIcon(natiPic[4][18]);
            button.setForeground(Color.red);
        } else {
            button.setForeground(Color.black);
            button.setIcon(natiPic[4][17]);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="удаление строки архитектора">
    void archDelete(Village temp, int sell[]) {
        if (sell.length > 0) {
            for (int i = 0; i < sell.length; i++) {
                architectorModel.removeRow(sell[i] - i);
                temp.buildList.remove(sell[i] - i);
                temp.idList.remove(sell[i] - i);
            }
        } else {
            architectorModel.removeRow(0);
            temp.buildList.remove(0);
            temp.idList.remove(0);
        }
    }

    void archDelete1(Village temp, int sell[]) {
        if (sell.length > 0) {
            for (int i = 0; i < sell.length; i++) {
                architectorModelDouble.removeRow(sell[i] - i);
                temp.buildListD.remove(sell[i] - i);
                temp.idListD.remove(sell[i] - i);
            }
        } else {
            architectorModelDouble.removeRow(0);
            temp.buildListD.remove(0);
            temp.idListD.remove(0);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="debug">
    public static void debug(int i) {
        if (MainWindow.debug == true) {
            consoleText(new Color(27, 132, 57), "" + i + "..");
        }
    }

    public static void debug(int i, boolean end) {
        if (MainWindow.debug == true) {
            consoleText(new Color(27, 132, 57), "" + i + "..\n");
        }
    }
//</editor-fold>

//static String JText = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n";
//<editor-fold defaultstate="collapsed" desc="for BanditoTextField">
    void textFieldOperation(JTextField tf, Boolean bool) {
        tf.setEditable(!bool);
        if (bool == true) {
            tf.setBackground(new Color(200, 191, 231));
            tf.setForeground(Color.GRAY);
        } else {
            tf.setBackground(Color.WHITE);
            tf.setForeground(Color.BLACK);
        }
    }
//</editor-fold>

    void deleteRow(JTable table, DefaultTableModel model) {
        if (table.getRowCount() > 0) {
            int sell[] = table.getSelectedRows();
            if (sell.length > 0) {
                for (int i = 0; i < sell.length; i++) {
                    model.removeRow(sell[i] - i);
                }
            } else {
                model.removeRow(0);
            }
        }
    }
//<editor-fold defaultstate="collapsed" desc=" ОБЪЯВЛЕНИЕ ПЕРЕМЕННЫХ ">   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArchPane;
    private javax.swing.JPanel ArchPane1;
    public static javax.swing.JTabbedPane BanditoTables;
    private javax.swing.JPanel EvaPane;
    private javax.swing.JPanel HallPane;
    private javax.swing.JPanel MerchPane;
    private javax.swing.JPanel SargePane;
    private javax.swing.JPanel ScoutPane;
    private javax.swing.JPanel TimerPane;
    public static javax.swing.JLabel allyance;
    static javax.swing.JButton analizator;
    public static javax.swing.JTabbedPane archTab;
    public static javax.swing.JTable archTable;
    public static javax.swing.JTable archTable1;
    public static javax.swing.JTable archTable3;
    public static javax.swing.JTable banditoListTable;
    public static javax.swing.JTable banditoTable;
    public static javax.swing.JTable blackSmtithTable;
    public static javax.swing.JButton buttonAddProgram;
    public static javax.swing.JButton buttonAddProgram1;
    public static javax.swing.JButton buttonAddProgram2;
    public static javax.swing.JButton buttonAddProgram3;
    public static javax.swing.JButton buttonAddProgram4;
    public static javax.swing.JButton buttonAddToBandito;
    public static javax.swing.JButton buttonAllNow;
    public static javax.swing.JButton buttonArchAdd;
    public static javax.swing.JButton buttonArchAdd1;
    public static javax.swing.JButton buttonCopyToTravian;
    public static javax.swing.JButton buttonCopyToTravian1;
    public static javax.swing.JButton buttonDemolishAdd1;
    public static javax.swing.JButton buttonDemolishRemove;
    public static javax.swing.JButton buttonGatherInfo;
    public static javax.swing.JButton buttonLogin;
    public static javax.swing.JButton buttonModify;
    public static javax.swing.JButton buttonNewList;
    public static javax.swing.JButton buttonPreferences;
    public static javax.swing.JButton buttonPreferences1;
    public static javax.swing.JButton buttonPreferences2;
    public static javax.swing.JButton buttonPreferences3;
    public static javax.swing.JButton buttonRemove;
    public static javax.swing.JButton buttonRemove1;
    public static javax.swing.JButton buttonRemove2;
    public static javax.swing.JButton buttonRemove3;
    public static javax.swing.JButton buttonRemove4;
    public static javax.swing.JButton buttonRemove5;
    public static javax.swing.JButton buttonRemove6;
    public static javax.swing.JButton buttonRemove7;
    public static javax.swing.JButton buttonRemove8;
    public static javax.swing.JButton buttonRemove9;
    public static javax.swing.JButton buttonSound;
    public static javax.swing.JToggleButton buttonStart;
    public static javax.swing.JToggleButton buttonStart1;
    static javax.swing.JButton buttonTradeRoutes;
    public static javax.swing.JTable celebrateTable;
    public static javax.swing.JCheckBox checkBoxAdventure;
    public static javax.swing.JCheckBox checkBoxAutoBuild;
    static javax.swing.JCheckBox checkBoxAutoBuild1;
    static javax.swing.JCheckBox checkBoxBanditoExtend;
    public static javax.swing.JCheckBox checkBoxHard;
    public static javax.swing.JCheckBox checkBoxOaseSound;
    public static javax.swing.JCheckBox checkBoxSound;
    public static javax.swing.JCheckBox checkBoxTravianPlus;
    public static javax.swing.JComboBox comboBoxArcVillages;
    public static javax.swing.JComboBox comboBoxArcVillagesDemolish;
    public static javax.swing.JComboBox comboBoxArcVillagesDouble;
    public static javax.swing.JComboBox comboboxTimer;
    private javax.swing.JPanel demolish;
    static javax.swing.JTextField demolishPeriodTF;
    public static javax.swing.JTextField demolishTimeTF;
    public static javax.swing.JTable evadeTable;
    public static javax.swing.JLabel farmTroop;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static javax.swing.JComboBox jComboBox2;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
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
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public static javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JLabel labelArchPeriod;
    public static javax.swing.JLabel labelArchPeriod2;
    public static javax.swing.JLabel labelArchTime;
    public static javax.swing.JLabel labelArchTime2;
    private javax.swing.JLabel labelDemolishPeriod;
    private javax.swing.JLabel labelDemolishTime;
    public static javax.swing.JLabel labelMin1;
    public static javax.swing.JLabel labelSendEach;
    public static javax.swing.JLabel labelTimeToadventure;
    public static javax.swing.JTable marketTable;
    private javax.swing.JMenuItem menuOpen;
    public static javax.swing.JLabel profile;
    public static javax.swing.JButton refreshButton;
    public static javax.swing.JTable sargeTable;
    public static javax.swing.JTable scoutTable;
    public static javax.swing.JTabbedPane tabbedMainPanel;
    public static javax.swing.JTextField textFieldArchPeriod;
    public static javax.swing.JTextField textFieldArchPeriod2;
    public static javax.swing.JTextField textFieldArchTime;
    public static javax.swing.JTextField textFieldArchTime2;
    public static javax.swing.JTextField textFieldHours;
    public static javax.swing.JTextField textFieldMinutes;
    public static javax.swing.JTextField textFieldSec;
    public static javax.swing.JTable timerTable;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    public static void preWaitCheck() {
        boolean check = true;
        try {
            driver.findElement(By.name("password"));
            check = false;
        } catch (org.openqa.selenium.NoSuchElementException ex) {
        }
        if (check == true) {
            String url = driver.getCurrentUrl();
            if (url.indexOf("travian") == -1) {
                if (url.indexOf("TRAVIAN") == -1) {
                    if (url.indexOf("Travian") == -1) {
                        check = false;
                    }
                }
            }

            if (url.indexOf("logout") > 0) {
                check = false;
            }
        }
        if (check == true) {
            ThreadWait tw = new ThreadWait();
        } else {
            ThreadRefresh tr = new ThreadRefresh();
        }
    }
}
