package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import traviator42.gui.bandito.Bandito1Robot;
import traviator42.gui.common.MainWindow;
import traviator42.utils.WD;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="copy to game from bandito">
class ThreadCopy implements Runnable {


    public static Thread TC;
    int ML;
    int maxFarm;
    int maxFarmStep;
    int listStep = 1;
    String flName;


    int flsize;

    ThreadCopy(int maxLength, int maxFarmListSize, String flName) {
        this.flName = flName;
        maxFarm = maxFarmListSize;
        maxFarmStep = maxFarm;
        ML = maxLength;
        TC = new Thread(this, "Copy thread");
        TC.start();
    }

    @Override
    public void run() {
        int maxLength = ML; // этот инт для значения номера последнего созданного фарм-листа
        int rows = MainWindow.banditoTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) MainWindow.banditoTable.getModel();
        MainCopyStatus.progressBar.setStringPainted(true);
        MainCopyStatus.progressBar.setMinimum(0);
        MainCopyStatus.progressBar.setMaximum(rows + 1);
        MainCopyStatus.progressBar.setValue(0);
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[47][MainWindow.language] +
                rows + MainWindow.messages[48][MainWindow.language]);
        try {
            String source = "";
            int lcount = 0;
            MainWindow.driver.get(MainWindow.vilList.get(MainWindow.villageNameList).url);

            //<editor-fold defaultstate="collapsed" desc=" выбираем лучшего фармера нации">
            int troops[] = new int[5];
            if (MainWindow.tribe == 0) {
                troops[0] = 4;
                troops[1] = 6;
                troops[2] = 5;
                troops[3] = 2;
                troops[4] = 1;
            }
            if (MainWindow.tribe == 1) {
                troops[0] = 5;
                troops[1] = 6;
                troops[2] = 3;
                troops[3] = 1;
                troops[4] = 2;
            }
            if (MainWindow.tribe == 2) {
                troops[0] = 5;
                troops[1] = 6;
                troops[2] = 1;
                troops[3] = 3;
                troops[4] = 2;
            }
            int preferredTroop = 1;
            for (int j = 0; j < 5; j++) {
                if (preferredTroop < troops[j])
                    preferredTroop = troops[j];
            }


            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc=" определяем количество солдат в пачке">
            int diapazon1 = 3, diapazon2 = 3, diapazon3 = 3, diapazon4 = 3, diapazon5 = 3, diapazon6 = 3;


            diapazon1 = MainWindow.interval[0];
            diapazon2 = MainWindow.interval[1];
            diapazon3 = MainWindow.interval[2];
            diapazon4 = MainWindow.interval[3];
            diapazon5 = MainWindow.interval[4];
            diapazon6 = MainWindow.interval[5];

            //</editor-fold>

            MainCopyStatus.progressBarSmall.setMaximum(3);
            for (int i = 0; i < rows && MainCopyStatus.stop == false; i++) {
                while (MainCopyStatus.buttonToggle.isSelected() == false)
                    MainWindow.sleeep(1);
                if (i == maxFarm) {

                    //<editor-fold defaultstate="collapsed" desc=" создаем лист ">
                    ThreadCopyList.createFarmList(flName + listStep);
                    listStep++;

                    //          количество листов на странице всего
                    lcount = MainWindow.driver.findElements(By.xpath("//*[@id=\"raidList\"]/div")).size() - 1;
                    //           номера листов
                    int listNumbers[] = new int[lcount];
                    for (int h = 0; h < lcount && MainCopyStatus.stop == false; h++) {
                        String id = MainWindow.driver.findElement(By.xpath("//*[@id=\"raidList\"]/div[" + (h + 1) + "]")).getAttribute("id");
                        id = id.trim().substring(4);
                        listNumbers[h] = Integer.valueOf(id);
                    }

                    for (int h = 0; h < listNumbers.length && MainCopyStatus.stop == false; h++) {
                        if (maxLength < listNumbers[h]) {
                            maxLength = listNumbers[h];
                        }
                    }

                    //</editor-fold>

                    ML = maxLength;
                    maxFarm += maxFarmStep;
                }
                String X = "", Y = "";
                try {
                    MainWindow.driver.navigate().to(MainWindow.server + "build.php?gid=16&tt=99");

                    WebDriver d = MainWindow.driver;
                    int listId = -1;
                    int rl = d.findElements(By.xpath("//*[@id=\"raidList\"]/div")).size();
                    System.out.println("rl count: " + rl + " location: " + d.getCurrentUrl());
                    for(int a = 1; i <= rl; a++){
                        String temp = d.findElement(By.xpath("//*[@id=\"raidList\"]/div["+a+"]")).getAttribute("id");
                        System.out.println("String temp: " + temp);
                        if(temp.indexOf("list")>-1){
                            String listIdString = temp.substring(temp.indexOf("list") + 4).trim();
                            String listTitle = d.findElement(By.xpath("//*[@id=\"list"+listIdString+"\"]/form/div[1]/div[2]")).getText();
                            System.out.println("listTitle: " + listTitle+ "; flName: " + flName);
                            if(listTitle.equals(flName)) {
                                listId = Integer.parseInt(listIdString);
                                break;
                            }
                        }
                    }
                    System.out.println("List id: " + listId);
                    if(listId == -1) {
                        return;
                    }
//<editor-fold defaultstate="collapsed" desc=" Номер нужного нам фарм листа ">


                    WD wd = new WD(d);
                    wd.scroll("//*[@id=\"list"+listId+"\"]/form/div[2]/div[1]/div[2]/button/div");
                    wd.forceClick("//*[@id=\"list"+listId+"\"]/form/div[2]/div[1]/div[2]/button/div");

                    MainWindow.sleeep(200);


                   //
                    MainCopyStatus.progressBarSmall.setValue(1);

                    int col;
                    if (model == MainWindow.banditoModel)
                        col = 3;
                    else
                        col = 4;
                    X = MainWindow.banditoModel.getValueAt(i, col).toString();
                    X = X.substring(0, X.indexOf("/"));
                    Y = MainWindow.banditoModel.getValueAt(i, col).toString();
                    Y = Y.substring(Y.indexOf("/") + 1);
                    wd.ajaxEl("//*[@id=\"xCoordInput\"]");
                    MainWindow.driver.findElement(By.id("xCoordInput")).clear();
                    MainWindow.driver.findElement(By.id("yCoordInput")).clear();
                    if (Integer.valueOf(X) < 0) {
                        MainWindow.driver.findElement(By.id("xCoordInput")).sendKeys(Keys.SUBTRACT);
                        MainWindow.driver.findElement(By.id("xCoordInput")).sendKeys(X);
                    } else
                        MainWindow.driver.findElement(By.id("xCoordInput")).sendKeys(X);

                    if (Integer.valueOf(Y) < 0) {
                        MainWindow.driver.findElement(By.id("yCoordInput")).sendKeys(Keys.SUBTRACT);
                        MainWindow.driver.findElement(By.id("yCoordInput")).sendKeys(Y);
                    } else
                        MainWindow.driver.findElement(By.id("yCoordInput")).sendKeys(Y);

                    MainCopyStatus.progressBarSmall.setValue(2);
                    int pop = 0;
                    int send = 0;

                    if (model == MainWindow.banditoModel)
                        col = 2;
                    else
                        col = 3;
                    String val = MainWindow.banditoTable.getValueAt(i, col).toString();
                    try {
                        val = val.substring(0, val.indexOf("/"));
                        pop = Integer.valueOf(val);
                    } catch (Exception ex) {
                        pop = 1;
                    }
                    if (pop <= 20) send = diapazon1;
                    if (pop > 20 && pop <= 50) send = diapazon2;
                    if (pop > 50 && pop <= 100) send = diapazon3;
                    if (pop > 100 && pop <= 200) send = diapazon4;
                    if (pop > 200 && pop <= 400) send = diapazon5;
                    if (pop > 400) send = diapazon6;
                    try {
                        Thread.sleep(MainWindow.rand.nextInt(2) * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadCopy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    MainCopyStatus.progressBarSmall.setValue(3);
                    wd.id("t" + Bandito1Robot.selectedUnit).clear();
                    wd.id("t" + Bandito1Robot.selectedUnit).sendKeys(String.valueOf(send));
                    wd.forceClick("//*[@id=\"save\"]/div/div[2]");
                    MainWindow.slow();

                    MainCopyStatus.progressBarSmall.setValue(0);
                    i++;
                    MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue() + 1);
                    int left = rows - i;
                    MainCopyStatus.textAreaCopyConsole.append(i + MainWindow.messages[54][MainWindow.language] + left + " " +
                            MainWindow.messages[55][MainWindow.language]);
                    MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
                    i--;
                } catch (org.openqa.selenium.remote.UnreachableBrowserException ex) {
                    error(X, Y);
                    MainWindow.sleeep(10000);
                } catch (org.openqa.selenium.NoSuchElementException ex) {
                    error(X, Y);
                }
            }

            MainCopyStatus.progressBar.setValue(Integer.MAX_VALUE);
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[56][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
            MainCopyStatus.buttonOk.setEnabled(true);
            MainCopyStatus.buttonCancel.setEnabled(false);
        } catch (org.openqa.selenium.NoSuchElementException Ex) {
            MainWindow.consoleText(Color.RED, MainWindow.messages[4][MainWindow.language]);
        }
        MainCopyStatus.stop = false;
    }

    void error(String x, String y) {
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language] + " X = " + x + ", " + " Y = " + y + "\n");
        MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
    }
}
