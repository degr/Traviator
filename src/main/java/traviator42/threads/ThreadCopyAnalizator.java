package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import traviator42.gui.bandito.Bandito1Robot;
import traviator42.gui.common.MainWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="copy to game from analizator">
class ThreadCopyAnalizator implements Runnable {


    public static Thread TC;
    int ML;
    int maxFarm;
    int maxFarmStep;
    int listStep = 1;
    String flName;
    String url;

    int flsize;

    ThreadCopyAnalizator(int maxLength, int maxFarmListSize, String flName, String url) {
        this.flName = flName;
        this.url = url;
        maxFarm = maxFarmListSize;
        maxFarmStep = maxFarm;
        ML = maxLength;
        TC = new Thread(this, "Copy thread");
        TC.start();
    }

    @Override
    public void run() {
        int maxLength = ML; // этот инт для значения номера последнего созданного фарм-листа
        DefaultTableModel model = (DefaultTableModel) MainWindow.banditoTable.getModel();
        MainWindow.driver.get(url);
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        int size = MainWindow.driver.findElements(By.xpath("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr")).size();

        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[352][MainWindow.language] +
                size + "\n" + MainWindow.messages[353][MainWindow.language]);

        for (int i = 1; i < size; i++) {
            while (MainCopyStatus.buttonToggle.isSelected() == false)
                MainWindow.sleeep(1);
            ArrayList<String> temp = new ArrayList<>();
            MainCopyStatus.textAreaCopyConsole.append(i + "... ");
            int pass = Integer.valueOf(MainWindow.driver.
                    findElement(By.xpath("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[8]/span")).getText().trim());
            if (pass == 0) {
                temp.add(MainWindow.driver.
                        findElement(By.xpath("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[7]")).getText().trim());
                String xy = MainWindow.driver.
                        findElement(By.xpath("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[4]")).getText().trim();
                temp.add(xy.substring(xy.indexOf("(") + 1, xy.indexOf("|")).trim());
                temp.add(xy.substring(xy.indexOf("|") + 1, xy.indexOf(")")).trim());
                data.add(temp);
            }
            if (pass > 0)
                break;
        }
        //<editor-fold defaultstate="collapsed" desc="графическое оформление">
        MainCopyStatus.progressBar.setStringPainted(true);
        MainCopyStatus.progressBar.setMinimum(0);
        MainCopyStatus.progressBar.setMaximum(data.size() + 1);
        MainCopyStatus.progressBar.setValue(0);
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[47][MainWindow.language] +
                data.size() + MainWindow.messages[48][MainWindow.language]);
        //</editor-fold>
//  try{

        int lcount = 0;
        MainWindow.driver.navigate().to(MainWindow.vilList.get(MainWindow.villageNameList).url);

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

        String question = JOptionPane.showInputDialog("Total targets count: " + data.size() + ". Begin from: ");
        int startPos;
        try {
            startPos = Integer.parseInt(question);
        } catch (Exception ex) {
            startPos = 0;
        }


        for (int i = startPos; i < data.size() && MainCopyStatus.stop == false; i++) {
            while (MainCopyStatus.buttonToggle.isSelected() == false) {
                MainWindow.sleeep(1);
            }
//<editor-fold defaultstate="collapsed" desc=" создаем лист ">
            if (i == maxFarm) {
                MainWindow.driver.navigate().to(MainWindow.server + "build.php?gid=16&tt=99&action=addList");
                MainWindow.driver.findElement(By.className("text")).sendKeys(flName + listStep);
                MainWindow.driver.findElement(By.className("text")).submit();
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
                ML = maxLength;
                maxFarm += maxFarmStep;
            }
//</editor-fold>
            String X = "", Y = "";
          //  try {
                WebDriver d = MainWindow.driver;
                int listId = -1;
                int rl = d.findElements(By.xpath("//*[@id=\"raidList\"]/div")).size();
                for(int a = 1; i <= rl; i++){
                    String temp = d.findElement(By.xpath("//*[@id=\"raidList\"]/div["+a+"]")).getAttribute("id");
                    if(temp.indexOf("list")>-1){
                        String listIdString = temp.substring(temp.indexOf("list") + 4).trim();
                        String listTitle = d.findElement(By.xpath("//*[@id=\"list"+listIdString+"\"]/form/div/div")).getText();
                        if(listTitle.equals(flName)) {
                            listId = Integer.parseInt(listIdString);
                        }
                    }
                }

                if(listId == -1) {
                    return;
                }
//<editor-fold defaultstate="collapsed" desc=" Номер нужного нам фарм листа ">



                d.findElement(By.xpath("//*[@id=\"list"+listId+"\"]/form/div[2]/div[1]/div[2]/button/div/div[1]/div/div/div")).click();
                MainWindow.sleeep(200);

                //MainWindow.driver.navigate().to(MainWindow.server + "build.php?gid=16&tt=99&action=showSlot&lid=" + maxLength + "&sort=distance&direction=asc");
                MainCopyStatus.progressBarSmall.setValue(1);

                //<editor-fold defaultstate="collapsed" desc="координаты">
                X = data.get(i).get(1);
                Y = data.get(i).get(2);

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
                //</editor-fold>

                MainCopyStatus.progressBarSmall.setValue(2);
                //<editor-fold defaultstate="collapsed" desc="количество юнитов">
                int pop = 0;
                int send = 0;


                String val = data.get(i).get(0);
                try {
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
                MainWindow.driver.findElement(By.id("t" + Bandito1Robot.selectedUnit)).clear();
                MainWindow.driver.findElement(By.id("t" + Bandito1Robot.selectedUnit)).sendKeys(String.valueOf(send));
                MainWindow.driver.findElement(By.id("t" + Bandito1Robot.selectedUnit)).submit();
                //</editor-fold>
                MainWindow.slow();

                MainCopyStatus.progressBarSmall.setValue(0);
                i++;
                MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue() + 1);
                int left = data.size() - i;
                MainCopyStatus.textAreaCopyConsole.append(i + MainWindow.messages[54][MainWindow.language] + left + " " +
                        MainWindow.messages[55][MainWindow.language]);
                MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
                i--;
           /* } catch (org.openqa.selenium.remote.UnreachableBrowserException ex) {
                error(X, Y);
                MainWindow.sleeep(10000);
            } catch (org.openqa.selenium.NoSuchElementException ex) {
                error(X, Y);
            }*/
        }

        MainCopyStatus.progressBar.setValue(Integer.MAX_VALUE);
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[56][MainWindow.language]);
        MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
        MainCopyStatus.buttonOk.setEnabled(true);
        MainCopyStatus.buttonCancel.setEnabled(false);
// }catch(org.openqa.selenium.NoSuchElementException Ex){
//    MainWindow.consoleText(Color.RED, MainWindow.messages[4][MainWindow.language]);
// }
        MainCopyStatus.stop = false;
    }

    void error(String x, String y) {
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language] + " X = " + x + ", " + " Y = " + y + "\n");
        MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
    }

}
