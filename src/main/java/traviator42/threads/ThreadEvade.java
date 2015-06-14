package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc=" эвакуатор ">
class ThreadEvade implements Runnable {

    Thread TE;

    ThreadEvade() {
        TE = new Thread(this, "construct thread");
        TE.start();
    }
static void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {

        try {
            MainWindow.consoleText(Color.BLUE, MainWindow.messages[209][MainWindow.language] + "(" + MainWindow.time() + ")\n");
            MainWindow.sleeep(2000);
debug(1);
            MainWindow.interrupt = false;
            if (MainWindow.checkBoxTravianPlus.isSelected() == true) {
                ArrayList<String> villages = new ArrayList<>();
       debug(2);

                    for(int i = 0; i < MainWindow.vilList.size(); i++){
                        debug(3);
                        try{
                            i++;
                            //*[@id="sidebarBoxVillagelist"]/div[2]/div[2]/ul/li
                            String temp = MainWindow.driver.findElement(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li[" + i + "]")).getAttribute("class");

                            if(temp.indexOf("attack") > -1)
                                villages.add(MainWindow.driver.findElement(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li["+i+"]/a/div")).getText().trim());
                            i--;
                        }catch(org.openqa.selenium.NoSuchElementException ex){
                        }
                    }
                    debug(4);
                while (villages.size() > 0 && MainWindow.interrupt == false)
                        checkVilly(villages.remove(0));

            } else {
                debug(5);
                int count = MainWindow.vilList.size() - 1;
                while (count >= 0 && MainWindow.interrupt == false) {
                    checkVilly(MainWindow.vilList.get(count).name);
                    count--;
                }
            }debug(6);

            String futureRow[] = new String[]{
                MainWindow.setTimer(MainWindow.evadeTable.getValueAt(0, 3).toString()),
                MainWindow.evadeTable.getValueAt(0, 1).toString(),
                MainWindow.evadeTable.getValueAt(0, 2).toString(),
                MainWindow.evadeTable.getValueAt(0, 3).toString(),};
            MainWindow.evadeModel.removeRow(0);
            MainWindow.evadeModel.insertRow(MainWindow.rowNumber(MainWindow.evadeModel, 0, futureRow[0]), futureRow);
            MainWindow.interrupt = false;
            MainWindow.waitInterrupt = false;
            MainWindow.reload = 0;
            MainWindow.debug(7, true);
            if (MainWindow.buttonStart.isSelected() == true) {
                MainWindow.preWaitCheck();
            }
        } catch (Exception Ex) {
            MainWindow.errorExecution(Ex);
        }
    }

    static void checkVilly(String villy) {
        try {
            boolean pass = MainWindow.villageChange(villy, "dorf1.php", "");
            if (pass == true) {
                debug(8);
            //att1
                if (MainWindow.driver.findElement(By.className("a1")).isEnabled() == true) {
                    debug(9);
                    MainWindow.consoleText(Color.RED, MainWindow.messages[205][MainWindow.language] + villy + MainWindow.messages[208][MainWindow.language]);
                    if (MainWindow.checkBoxSound.isSelected() == true) {
                        debug(10);
                        MainWindow.soundAlert = false;
                        EvadeSound ES = new EvadeSound();
                    }
                    //<editor-fold defaultstate="collapsed" desc="спасаем ресурсы">
                    if (!"---".equals(MainWindow.evadeTable.getValueAt(0, 1).toString())) {
                        debug(10);
                        MainWindow.villageChange(villy, "build.php", "&t=5&gid=17");
                        String coord = MainWindow.evadeTable.getValueAt(0, 1).toString();
                        //*[@id="l1"]
                        int woodToSend = storeCharge(1),
                            clayToSend = storeCharge(2),
                            ironToSend = storeCharge(3),
                            cropToSend = storeCharge(4);
                        if ((woodToSend + clayToSend + ironToSend + cropToSend) > Integer.valueOf(MainWindow.driver.findElement(By.id("merchantCapacityValue")).getText())) {
                            debug(11);
                            int resoTotalToSend = woodToSend + clayToSend + ironToSend + cropToSend;
                            int merchCarry = Integer.valueOf(MainWindow.driver.findElement(By.id("merchantCapacityValue")).getText());
                            woodToSend = ((woodToSend) * merchCarry / resoTotalToSend);
                            clayToSend = ((clayToSend) * merchCarry / resoTotalToSend);
                            ironToSend = ((ironToSend) * merchCarry / resoTotalToSend);
                            cropToSend = ((cropToSend) * merchCarry / resoTotalToSend);
                        }
                        int slash = MainWindow.evadeTable.getValueAt(0, 1).toString().toString().indexOf("/");
                        String X = MainWindow.evadeTable.getValueAt(0, 1).toString().substring(0, slash);
                        String Y = MainWindow.evadeTable.getValueAt(0, 1).toString().substring(slash + 1, MainWindow.evadeModel.getValueAt(0, 1).toString().length());
                        MainWindow.driver.findElement(By.id("xCoordInput")).sendKeys(X);
                        MainWindow.driver.findElement(By.id("yCoordInput")).sendKeys(Y);
                        debug(12);
                        MainWindow.driver.findElement(By.id("r1")).sendKeys(String.valueOf(woodToSend));
                        MainWindow.driver.findElement(By.id("r2")).sendKeys(String.valueOf(clayToSend));
                        MainWindow.driver.findElement(By.id("r3")).sendKeys(String.valueOf(ironToSend));
                        MainWindow.driver.findElement(By.id("r4")).sendKeys(String.valueOf(cropToSend));
                        debug(13);
                        MainWindow.driver.findElement(By.id("enabledButton")).click();
                        MainWindow.sleeep(2000);
                        debug(14);
                        MainWindow.driver.findElement(By.id("enabledButton")).click();
                    }
                    //</editor-fold>
                    String data = MainWindow.evadeTable.getValueAt(0, 2).toString();
                    if (!"---".equals(data)) {
                        debug(15);
                        //<editor-fold defaultstate="collapsed" desc="спасаем войско">
                        int slash = data.indexOf("/");

                        int space = data.indexOf(" ");
                        String X = data.substring(0, slash);
                        String Y = data.substring(slash + 1, space);
                        String descriptor = data.substring(space).trim();
                        String type = "";
                        debug(16);
                        if ("reinf".equals(descriptor)) {
                            type = "//*[@id=\"build\"]/div[2]/form/div[2]/label[1]/input";
                        }
                        if ("norm".equals(descriptor)) {
                            type = "//*[@id=\"build\"]/div[2]/form/div[2]/label[2]/input";
                        }
                        if ("raid".equals(descriptor)) {
                            type = "//*[@id=\"build\"]/div[2]/form/div[2]/label[3]/input";
                        }
debug(17);
                        MainWindow.villageChange(villy, "build.php?", "&tt=2&gid=16");
                        int count[] = new int[12];
                        int row = 1;
                        int col = 1;
                        while (row < 4) {
                            col = 1;
                            while (col < 5) {

                                try {debug(18);
                                    String countt = MainWindow.driver.findElement(
                                        By.xpath(" //*[@id=\"troops\"]/tbody/tr[" + row + "]/td[" + col + "]/a")).getText();
                                    count[(col - 1) * 3 + row - 1] = Integer.parseInt(countt);

                                } catch (org.openqa.selenium.NoSuchElementException ex) {
                                    count[(col - 1) * 3 + row - 1] = 0;
                                };
                                col++;
                            }
                            row++;
                        }
                        count[10] = count[11];
                        row = 1;
                        for(int i = 0; i < count.length; i++)


                        while (row < 12) {
                            int mas = row - 1;
                            if(MainWindow.unitsEvade[mas] == true){
                                try {
                                    if (count[mas] != 0) {
                                        MainWindow.driver.findElement(By.name("t" + row)).clear();
                                        MainWindow.driver.findElement(By.name("t" + row)).sendKeys(String.valueOf(count[mas]));
                                    }
                                } catch (org.openqa.selenium.NoSuchElementException ex) {
                                }
                                }
                            row++;
                        }debug(19);
                        try {
                            MainWindow.driver.findElement(By.xpath(type)).click();
                        } catch (org.openqa.selenium.NoSuchElementException ex) {
                        };
                        MainWindow.sendKeysCoord("x", Integer.valueOf(X), "CoordInput");
                        MainWindow.sendKeysCoord("y", Integer.valueOf(Y), "CoordInput");
                        MainWindow.driver.findElement(By.id("btn_ok")).click();
                        MainWindow.driver.findElement(By.id("btn_ok")).click();

                        //</editor-fold>
                    }

                }
            }
        } catch (Exception ex) {
            if(ex instanceof org.openqa.selenium.NoSuchElementException)
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[205][MainWindow.language] +
                        villy + MainWindow.messages[206][MainWindow.language]);
            else
                MainWindow.errorExecution(ex);
        }
        if (MainWindow.checkBoxOaseSound.isSelected() == true) {
            try {debug(20);
                if (MainWindow.driver.findElement(By.className("a3")).isEnabled() == true) {
                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[197][MainWindow.language]);
//       entry attack   entry attack active

                    MainWindow.soundAlert = false;
                    EvadeSound ES = new EvadeSound();
                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[207][MainWindow.language] + villy + MainWindow.messages[208][MainWindow.language]);
                }
            } catch (Exception ex) {
                if(ex instanceof org.openqa.selenium.NoSuchElementException)
                 MainWindow.consoleText(Color.BLACK, MainWindow.messages[207][MainWindow.language] + villy
                         + MainWindow.messages[206][MainWindow.language]);
            else
                MainWindow.errorExecution(ex);
            }
        }
    }

    static int storeCharge(int i) {
        String str = MainWindow.driver.findElement(By.id("l"+i)).getText();
        while(str.indexOf(".")>-1)
            str = str.replace(".", "");
        int capacity = Integer.valueOf(str);
        return capacity;
    }
}
