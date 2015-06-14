package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;
import traviator42.utils.WD;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="Номер листа для копирования в игру">
class ThreadCopyList implements Runnable {

    public static Thread TC;
    boolean newList = false;
    int banditoOrScout = 0;
    String flName;
    int flsize;
    String url;
    int village;

    ThreadCopyList(boolean newList /*true - new, false - old*/, int copyBanditoScout/*0 - bandito, 1 - scout, 2 - analizator*/, String flName, int flsize, String url, int village) {
        this.flsize = flsize;
        this.url = url;
        this.newList = newList;
        this.banditoOrScout = copyBanditoScout;
        this.flName = flName;
        this.village = village;

        TC = new Thread(this, "new list or old list thread");
        TC.start();
    }

    @Override
    public void run() {
        int maxLength = 0; // этот инт для значения номера последнего созданного фарм-листа


        MainCopyStatus.progressBar.setStringPainted(true);
        MainCopyStatus.progressBar.setMinimum(0);
        MainCopyStatus.progressBar.setMaximum(1);
        MainCopyStatus.progressBar.setValue(0);

        try {
            String source = "";
            int lcount = 0;
            MainWindow.driver.navigate().to(MainWindow.vilList.get(village).url);

            if (newList == true) {
                //<editor-fold defaultstate="collapsed" desc=" создаем лист ">
                createFarmList(flName);
                //*[@id="raidListCreate"]/form/button/div/div[1]/div/div/div
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
            } else {
                //<editor-fold defaultstate="collapsed" desc="ищем в который добавить">
                MainWindow.driver.navigate().to(MainWindow.server + "build.php?id=39&tt=99&gid=16");
                source = MainWindow.driver.getPageSource();
                String listCount = source;
                boolean firstList = true;
                source = MainWindow.driver.getPageSource();
                //          количество листов на странице всего
                lcount = (source + "\0").split("<div id=\"list").length;
                //           номера листов
                int listNumbers[] = new int[lcount];

                for (int i = 0; source.indexOf("<div id=\"list") > -1 && i < lcount - 1 && MainCopyStatus.stop == false; i++) {
                    if (firstList == false) {
                        listCount = source.substring(source.indexOf("<div id=\"list" + listNumbers[i - 1]) + 50);
                    }
                    listCount = listCount.substring(listCount.indexOf("<div id=\"list") + 13);
                    listCount = listCount.substring(0, listCount.indexOf("\""));
                    listNumbers[i] = Integer.valueOf(listCount);
                    firstList = false;
                }
                //  восстанавливаем до первоначального
                listCount = source;
                firstList = true;
                boolean stop = false;

                for (int i = 0; source.indexOf("<div id=\"list") > -1 && i < lcount - 1 && stop == false && MainCopyStatus.stop == false; i++) {
                    if (firstList == false) {
                        listCount = source.substring(source.indexOf("<div id=\"list" + listNumbers[i - 1]) + 50);
                        listCount = listCount.substring(listCount.indexOf("openedClosedSwitch") + 50);
                    }


                    listCount = listCount.substring(listCount.indexOf(String.valueOf(listNumbers[i])), listCount.indexOf("openedClosedSwitch"));
                    if (listCount.indexOf(flName) != -1) {
                        maxLength = listNumbers[i];
                        stop = true;
                    }

                    firstList = false;
                    listCount = source;
                }
                //</editor-fold>
            }
            switch (banditoOrScout) {
                case 0:
                    ThreadCopy tc = new ThreadCopy(maxLength, flsize, MainWindow.vilList.get(MainWindow.villageNameList).name + " - " + flName);
                    break;
                case 1:
                    ThreadCopyToGameFromScout tctgfs = new ThreadCopyToGameFromScout(maxLength);
                    break;
                case 2:
                    ThreadCopyAnalizator tca = new ThreadCopyAnalizator(maxLength, flsize, flName, url);
            }


        } catch (org.openqa.selenium.NoSuchElementException Ex) {
            MainWindow.consoleText(Color.RED, MainWindow.messages[4][MainWindow.language]);
        }
    }

    void error(String x, String y) {
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language] + " X = " + x + ", " + " Y = " + y + "\n");
        MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
    }

    public static void createFarmList(String flName){
        MainWindow.driver.navigate().to(MainWindow.server + "build.php?gid=16&tt=99");
        WD wd = new WD(MainWindow.driver);
        int count = wd.getElemsCount("//*[@id=\"raidList\"]/div");
        wd.scroll("//*[@id=\"raidList\"]/div["+count+"]/a");
        wd.forceClick("//*[@id=\"raidList\"]/div["+count+"]/a");
        wd.ajaxEl("//*[@id=\"name\"]");
        wd.xp("//*[@id=\"name\"]").sendKeys(flName);
        wd.forceClick("//*[@id=\"raidListCreate\"]/form/button/div/div[2]");
        wd.sleep(500);
    }
}
