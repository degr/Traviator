package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import traviator42.gui.bandito.Bandito1Robot;
import traviator42.gui.common.MainWindow;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="copy to game from scout">
class ThreadCopyToGameFromScout implements Runnable {

    public static Thread TC;
    int maxLength;

    ThreadCopyToGameFromScout(int maxL) {
        maxLength = maxL;
        TC = new Thread(this, "Refresh thread");
        TC.start();
    }

    @Override
    public void run() {
//        try{
//<editor-fold defaultstate="collapsed" desc="оформление и объявление">
        String targetVillage;
        int rows = MainWindow.scoutTable.getRowCount();
        MainCopyStatus.progressBar.setStringPainted(true);
        MainCopyStatus.progressBar.setMinimum(0);
        MainCopyStatus.progressBar.setMaximum(rows);
        MainCopyStatus.progressBar.setValue(0);

        MainCopyStatus.progressBarSmall.setStringPainted(true);
        MainCopyStatus.progressBarSmall.setMinimum(0);

        MainCopyStatus.progressBarSmall.setValue(0);

        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[47][MainWindow.language] +
                rows + MainWindow.messages[48][MainWindow.language]);
//</editor-fold>


        //<editor-fold defaultstate="collapsed" desc="главный цикл занесения инфы в акк">

        for (int playersInTable = 0; playersInTable < MainWindow.scoutTable.getRowCount() && MainCopyStatus.stop == false; playersInTable++) {
//       try{
            //      playerInfo <ar<villyname, population, x, y>>
            ArrayList<ArrayList<String>> pInfo = gatherInfo(playersInTable);
            MainCopyStatus.progressBarSmall.setMaximum(pInfo.size());
            MainCopyStatus.progressBarSmall.setMaximum(3);
            try {
                Thread.sleep(MainWindow.rand.nextInt(2) * 1000 + 1000);
            } catch (InterruptedException ex) {
            }
            //      цикл для занесения всех деревень игрока в таблицу
            for (int i = 0; i < pInfo.size() && MainCopyStatus.stop == false; i++) {
//               try{
                while (MainCopyStatus.buttonToggle.isSelected() == false)
                    MainWindow.sleeep(1);
                //<editor-fold defaultstate="collapsed" desc=" махинации с насом ">
                int pop = 0;
                int send = 0;

                pop = Integer.valueOf(pInfo.get(i).get(1).toString());

                if (pop <= 20) send = MainWindow.interval[0];
                if (pop > 20 && pop <= 50) send = MainWindow.interval[1];
                if (pop > 50 && pop <= 100) send = MainWindow.interval[2];
                if (pop > 100 && pop <= 200) send = MainWindow.interval[3];
                if (pop > 200 && pop <= 400) send = MainWindow.interval[4];
                if (pop > 400) send = MainWindow.interval[5];

                //</editor-fold>

                //<editor-fold defaultstate="collapsed" desc="данные в форме фарм листа">
                MainWindow.driver.navigate().to(MainWindow.server + "build.php?gid=16&tt=99&action=showSlot&lid=" + maxLength + "&sort=distance&direction=asc");
                try {
                    Thread.sleep(MainWindow.rand.nextInt(2) * 1000 + 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadCopy.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (pInfo.get(i).get(2).indexOf("-") > -1) {
                    MainWindow.driver.findElement(By.id("xCoordInput")).sendKeys(Keys.SUBTRACT);
                    MainWindow.driver.findElement(By.id("xCoordInput")).sendKeys(pInfo.get(i).get(2));
                } else {
                    MainWindow.driver.findElement(By.id("xCoordInput")).sendKeys(pInfo.get(i).get(2));
                }
                if (pInfo.get(i).get(2).indexOf("-") > -1) {
                    MainWindow.driver.findElement(By.id("yCoordInput")).sendKeys(Keys.SUBTRACT);
                    MainWindow.driver.findElement(By.id("yCoordInput")).sendKeys(pInfo.get(i).get(3));
                } else {
                    MainWindow.driver.findElement(By.id("yCoordInput")).sendKeys(pInfo.get(i).get(3));
                }

                MainWindow.driver.findElement(By.id("t" + Bandito1Robot.selectedUnit)).clear();
                MainWindow.driver.findElement(By.id("t" + Bandito1Robot.selectedUnit)).sendKeys(String.valueOf(send));
                MainWindow.driver.findElement(By.id("t" + Bandito1Robot.selectedUnit)).submit();
                try {
                    Thread.sleep(MainWindow.rand.nextInt(3) * 1000 + 3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadCopy.class.getName()).log(Level.SEVERE, null, ex);
                }
                //</editor-fold>

                //<editor-fold defaultstate="collapsed" desc="завершение переноса в игру">
                playersInTable++;
                MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue() + 1);
                int left = rows - playersInTable;
                MainCopyStatus.textAreaCopyConsole.append(playersInTable + MainWindow.messages[54][MainWindow.language] + left +
                        MainWindow.messages[55][MainWindow.language] + "\n");
                MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
                playersInTable--;
                MainWindow.slow();
                //</editor-fold>

//                  }catch(Exception Ex){
//                      MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
//                      MainCopyStatus.textAreaCopyConsole.setCaretPosition( MainCopyStatus.textAreaCopyConsole.getText().length());
//                      MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue()+1);
//                  }

            }

//          }catch(Exception Ex){
//              MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
//              MainCopyStatus.textAreaCopyConsole.setCaretPosition( MainCopyStatus.textAreaCopyConsole.getText().length());
//          }
        }
        //</editor-fold>


//          }catch(Exception Ex){
//              MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
//              MainCopyStatus.textAreaCopyConsole.setCaretPosition( MainCopyStatus.textAreaCopyConsole.getText().length());
//          }
        MainCopyStatus.buttonOk.setEnabled(true);
        MainCopyStatus.stop = false;
    }

    ArrayList<ArrayList<String>> gatherInfo(int row) {
        ArrayList<ArrayList<String>> value = new ArrayList<>();
        MainCopyStatus.progressBarSmall.setValue(0);
        int innerList = 0;
        //<editor-fold defaultstate="collapsed" desc="ищем чела в статистике">
        try {
            MainWindow.driver.navigate().to(MainWindow.server + "statistiken.php");
            MainWindow.driver.findElement(By.xpath("//input[@ class = 'text name']")).sendKeys(MainWindow.scoutTable.getValueAt(row, 0).toString());
            MainWindow.driver.findElement(By.xpath("//input[@ class = 'text name']")).submit();
            MainWindow.driver.findElement(By.linkText(MainWindow.scoutTable.getValueAt(row, 0).toString())).click();
            innerList = MainWindow.driver.findElements(By.xpath("//table[@id = 'villages']/tbody/tr")).size();
            MainCopyStatus.progressBarSmall.setMaximum(innerList);
        } catch (Exception Ex) {
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
        }
        //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="цикл с доставанием инфы об игроке">
        for (int k = 1; k < innerList + 1; k++) {
            //         data = villyName, population, x, y;
            ArrayList<String> data = new ArrayList<>();
            try {
                String popul = MainWindow.driver.findElement(By.xpath("//table[@id = 'villages']/tbody/tr[" + k + "]/td[3]")).getText();
                String x = MainWindow.driver.findElement(By.xpath("//table[@id = 'villages']/tbody/tr[" + k + "]/td[4]/a/span/span[1]")).getText().trim();
                String y = MainWindow.driver.findElement(By.xpath("//table[@id = 'villages']/tbody/tr[" + k + "]/td[4]/a/span/span[3]")).getText().trim();
                String villna = "";

                MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                villna = MainWindow.driver.findElement(By.xpath("//table[@id = 'villages']/tbody/tr[" + k + "]/td[1]")).getText();
                data.add(villna);

                x = x.substring(1).trim();
                y = y.substring(0, y.length() - 1).trim();
                data.add(popul);
                data.add(x);
                data.add(y);
                value.add(data);
            } catch (Exception Ex) {
                MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
                MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
            }
        }
        //</editor-fold>

        return value;
    }
}
