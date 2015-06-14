package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;
import traviator42.utils.WD;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="copy to bandito from analizator">
class ThreadCopyToBanditoAnalizator implements Runnable {


    public static Thread TC;
    int ML;
    int maxFarm;
    int maxFarmStep;
    int listStep = 1;

    String url;
    String village;
    int flsize;

    ThreadCopyToBanditoAnalizator(String url, int village) {
        this.village = MainWindow.vilList.get(village).name;
        this.url = url;
        maxFarmStep = maxFarm;
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
                size + " " + MainWindow.messages[353][MainWindow.language] + "\n");
        MainCopyStatus.progressBar.setMaximum(size);
        WD d = new WD(MainWindow.driver);
        for (int i = 1; i < size; i++) {
            while (MainCopyStatus.buttonToggle.isSelected() == false)
                MainWindow.sleeep(1);
            ArrayList<String> temp = new ArrayList<>();
            MainCopyStatus.textAreaCopyConsole.append(i + "...");

            int pass = Integer.valueOf(MainWindow.driver.
                    findElement(By.xpath("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[8]/span")).getText().trim());
            if (pass == 0) {
                temp.add(village);
                temp.add(d.xp("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[1]/a[1]").getText().trim() + " / " +
                        d.xp("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[3]/a").getText().trim() + " / " +
                        d.xp("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[6]").getText().trim());
                String dis = d.xp("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[9]").getText().trim();
                if (dis.indexOf(".") > -1)
                    dis = dis.substring(0, dis.indexOf("."));

                temp.add(dis + " / " +
                        d.xp("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[7]").getText().trim());
                String xy = MainWindow.driver.
                        findElement(By.xpath("//*[@id=\"cols\"]/div/div[1]/table/tbody/tr[" + (i + 1) + "]/td[4]")).getText().trim();
                temp.add(xy.substring(xy.indexOf("(") + 1, xy.indexOf("|")).trim());
                temp.add(xy.substring(xy.indexOf("|") + 1, xy.indexOf(")")).trim());
                MainWindow.banditoModel.addRow(new Object[]{
                        temp.get(0), temp.get(1), temp.get(2), temp.get(3) + "/" + temp.get(4),
                });

            }
            MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue() + 1);
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
        try {

            int lcount = 0;
            MainWindow.driver.navigate().to(MainWindow.vilList.get(MainWindow.villageNameList).url);

            MainCopyStatus.progressBarSmall.setMaximum(3);


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
