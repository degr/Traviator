package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import traviator42.gui.common.MainWindow;
import traviator42.utils.WD;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="merch">
class ThreadMerchant implements Runnable {

    static boolean reload = false;

    ThreadMerchant() {
        MainWindow.TM = new Thread(this, "Merch thread");
        MainWindow.TM.start();
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {

        MainWindow.consoleText(Color.BLUE, MainWindow.messages[211][MainWindow.language] + "(" + MainWindow.time() + ")\n");
        MainWindow.sleeep(2000);
        WD d = new WD(MainWindow.driver);
debug(1);
        try {
//  присваиваем значение в миллион для состаяния склада-получателя
            int storeWoodReciver = 1000000,
                    storeClayReciver = 1000000,
                    storeIronReciver = 1000000,
                    storeCropReciver = 1000000;

//переходим в деревню получателя, для учета состояния склада
            boolean pass = false;
            if (MainWindow.merchModel.getValueAt(0, 9).equals("")) {
                pass = MainWindow.villageChange(MainWindow.merchModel.getValueAt(0, 1).toString(), "build.php", "&gid=17&t=5");
                //<editor-fold defaultstate="collapsed" desc=" вычисляем сколько ресов может вместить склад ">
                String store = d.id("stockBarWarehouse").getText();
                String granary = d.id("stockBarGranary").getText();
                store = dot(store);
                granary = dot(granary);
                storeWoodReciver = storeCapacity(1, store);
                storeClayReciver = storeCapacity(2, store);
                storeIronReciver = storeCapacity(3, store);
                storeCropReciver = storeCapacity(4, granary);
                //</editor-fold>
            }else
                pass = true;

            debug(2);
            //переходим на страницу рынка деревни-отправителя
            if (pass == true) {
                pass = MainWindow.villageChange(MainWindow.merchModel.getValueAt(0, 0).toString(), "build.php", "&gid=17&t=5");
                if (pass == true) {
                    debug(3);
                    //<editor-fold defaultstate="collapsed" desc=" вычисляем сколько ресов можно отправить ">
                    int storeWoodSender = I(d.id("l1").getText()),
                        storeClaySender = I(d.id("l2").getText()),
                        storeIronSender = I(d.id("l3").getText()),
                        storeCropSender = I(d.id("l4").getText());
                    //</editor-fold>

                    int woodToSend = 0,
                        clayToSend = 0,
                        ironToSend = 0,
                        cropToSend = 0;

                    //<editor-fold defaultstate="collapsed" desc=" вычисляем сколько ресов отправить не по координатам">
                    if (MainWindow.merchModel.getValueAt(0, 9).equals("")) {
                        debug(4);
                        woodToSend = resoToSendUnCoord(storeWoodReciver, storeWoodSender, 2);
                        clayToSend = resoToSendUnCoord(storeClayReciver, storeClaySender, 3);
                        ironToSend = resoToSendUnCoord(storeIronReciver, storeIronSender, 4);
                        cropToSend = resoToSendUnCoord(storeCropReciver, storeCropSender, 5);
                    } //</editor-fold>
                    //<editor-fold defaultstate="collapsed" desc=" вычисляем сколько ресов отправить по координатам">
                    else {debug(5);
                        woodToSend = resoToSendCoord(storeWoodSender, 2);
                        clayToSend = resoToSendCoord(storeClaySender, 3);
                        ironToSend = resoToSendCoord(storeIronSender, 4);
                        cropToSend = resoToSendCoord(storeCropSender, 5);
                    }
                    //</editor-fold>

                    if ((woodToSend + clayToSend + ironToSend + cropToSend) > Integer.valueOf(d.id("merchantCapacityValue").getText())) {
                        debug(6);
                        int resoTotalToSend = woodToSend + clayToSend + ironToSend + cropToSend;
                        int merchCarry = Integer.valueOf(d.id("merchantCapacityValue").getText());
                        woodToSend = ((woodToSend) * merchCarry / resoTotalToSend);
                        clayToSend = ((clayToSend) * merchCarry / resoTotalToSend);
                        ironToSend = ((ironToSend) * merchCarry / resoTotalToSend);
                        cropToSend = ((cropToSend) * merchCarry / resoTotalToSend);
                    }

//<editor-fold defaultstate="collapsed" desc=" если после учета вышло так что больше чем в таблице ">
                    int w, c, i, cr;
                    if ("".equals(MainWindow.merchModel.getValueAt(0, 2).toString())) {
                        w = 0;
                    } else {
                        w = Integer.valueOf(MainWindow.merchModel.getValueAt(0, 2).toString());
                    }
                    if ("".equals(MainWindow.merchModel.getValueAt(0, 3).toString())) {
                        c = 0;
                    } else {
                        c = Integer.valueOf(MainWindow.merchModel.getValueAt(0, 3).toString());
                    }
                    if ("".equals(MainWindow.merchModel.getValueAt(0, 4).toString())) {
                        i = 0;
                    } else {
                        i = Integer.valueOf(MainWindow.merchModel.getValueAt(0, 4).toString());
                    }
                    if ("".equals(MainWindow.merchModel.getValueAt(0, 5).toString())) {
                        cr = 0;
                    } else {
                        cr = Integer.valueOf(MainWindow.merchModel.getValueAt(0, 5).toString());
                    }
debug(7);

                    if (woodToSend > w) {
                        int part = woodToSend - w;
                        woodToSend = w;
                        clayToSend = clayToSend + (part / 3);
                        ironToSend = clayToSend + (part / 3);
                        cropToSend = clayToSend + (part / 3);
                    }

                    if (clayToSend > c) {
                        int part = clayToSend - c;
                        clayToSend = c;
                        ironToSend = ironToSend + (part / 2);
                        cropToSend = cropToSend + (part / 2);
                    }
                    if (ironToSend > i) {
                        int part = ironToSend - i;
                        ironToSend = i;
                        cropToSend = cropToSend + part;
                    }
                    if (cropToSend > cr) {
                        cropToSend = cr;
                    }
                    debug(8);
//</editor-fold>

                    d.id("r1").sendKeys(String.valueOf(woodToSend));
                    d.id("r2").sendKeys(String.valueOf(clayToSend));
                    d.id("r3").sendKeys(String.valueOf(ironToSend));
                    d.id("r4").sendKeys(String.valueOf(cropToSend));
                    //если используем координаты, то делаем вот так вот
debug(9);
                    //<editor-fold defaultstate="collapsed" desc=" Жмем кнопку отправить ">
                    if (!"".equals(MainWindow.merchModel.getValueAt(0, 9))) {
                        int slash = MainWindow.merchModel.getValueAt(0, 9).toString().indexOf("/");
                        String X = MainWindow.merchModel.getValueAt(0, 9).toString().substring(0, slash).trim();
                        String Y = MainWindow.merchModel.getValueAt(0, 9).toString().substring(slash + 1, MainWindow.merchModel.getValueAt(0, 9).toString().length()).trim();
                        debug(10);
                        coord("xCoordInput", d, X);
                        coord("yCoordInput", d, Y);
                    } else {
                        debug(11);
                        d.id("enterVillageName").sendKeys(MainWindow.marketTable.getValueAt(0, 1).toString());
                    }
//    d.className("//*[@id=\"enabledButton\"]/div/div[1]/div[1]/div/div")).click();
                    debug(12);
                    d.id("enabledButton").click();
                    if(d.ajaxEl("//*[@id=\"button\"]/button[1]")){
                        d.ajaxEl("//*[@id=\"enabledButton\"]");
                        d.xp("//*[@id=\"enabledButton\"]").click();

                    String reciever;
                    if(MainWindow.marketTable.getValueAt(0, 1).toString().equals(""))
                        reciever = MainWindow.marketTable.getValueAt(0, 8).toString();
                    else
                        reciever = MainWindow.marketTable.getValueAt(0, 1).toString();
                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[12][MainWindow.language] + " " + MainWindow.marketTable.getValueAt(0, 0) + " -> " + reciever + "\n");
                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[16][MainWindow.language] + " " + woodToSend + "\n");
                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[17][MainWindow.language] + " " + clayToSend + "\n");
                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[18][MainWindow.language] + " " + ironToSend + "\n");
                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[19][MainWindow.language] + " " + cropToSend + "\n");
                    //</editor-fold>
                    }
                }
            }
            MainWindow.reload = 0;

            int count = Integer.valueOf(MainWindow.marketTable.getValueAt(0, 7).toString());
            if (count != 999) {
                count = count - 1;
            }
            if (count > 0) {
                if (MainWindow.merchModel.getValueAt(0, 1) == null) {
                    MainWindow.merchModel.setValueAt("", 0, 1);
                }
                if (MainWindow.merchModel.getValueAt(0, 9) == null) {
                    MainWindow.merchModel.setValueAt("", 0, 9);
                }
                MainWindow.merchModel.setValueAt(count, 0, 7);
                MainWindow.futureRow[0] = MainWindow.merchModel.getValueAt(0, 0).toString();
                MainWindow.futureRow[1] = MainWindow.merchModel.getValueAt(0, 1).toString();
                MainWindow.futureRow[2] = MainWindow.merchModel.getValueAt(0, 2).toString();
                MainWindow.futureRow[3] = MainWindow.merchModel.getValueAt(0, 3).toString();
                MainWindow.futureRow[4] = MainWindow.merchModel.getValueAt(0, 4).toString();
                MainWindow.futureRow[5] = MainWindow.merchModel.getValueAt(0, 5).toString();
                MainWindow.futureRow[7] = MainWindow.merchModel.getValueAt(0, 7).toString();
                MainWindow.futureRow[8] = MainWindow.merchModel.getValueAt(0, 8).toString();
                MainWindow.futureRow[6] = MainWindow.setTimer(MainWindow.futureRow[8]);
                MainWindow.futureRow[9] = MainWindow.merchModel.getValueAt(0, 9).toString();
debug(14);
                MainWindow.merchModel.removeRow(0);
                MainWindow.merchModel.insertRow(MainWindow.rowNumber(MainWindow.merchModel, 6, MainWindow.futureRow[6]),
                        new Object[]{MainWindow.futureRow[0],
                            MainWindow.futureRow[1],
                            MainWindow.futureRow[2],
                            MainWindow.futureRow[3],
                            MainWindow.futureRow[4],
                            MainWindow.futureRow[5],
                            MainWindow.futureRow[6],
                            MainWindow.futureRow[7],
                            MainWindow.futureRow[8],
                            MainWindow.futureRow[9]});
debug(15);
            } else {
                MainWindow.merchModel.removeRow(0);debug(16);
            }

            MainWindow.interrupt = false;
            MainWindow.waitInterrupt = false;
            if (MainWindow.buttonStart.isSelected() == true) {debug(17);
                MainWindow.preWaitCheck();
            }
            //<editor-fold defaultstate="collapsed" desc="обработка исключения с перезапуском">
        } catch (Exception Ex) {
            MainWindow.errorExecution(Ex);
        }
        //</editor-fold>

    }

    //<editor-fold defaultstate="collapsed" desc=" void'ы и сложные int ">
    void coord(String id, WD d, String value){
        int coord = Integer.parseInt(value);
        if(coord < 0){
            d.id(id).sendKeys(Keys.SUBTRACT);
            coord = -1*(coord);
        }
        d.id(id).sendKeys(coord+"");
    }


    int storeCapacity(int i, String space){
        String val = MainWindow.driver.findElement(By.id("l" + i)).getText().trim();
        int capacity = Integer.valueOf(space)- Integer.valueOf(dot(val));
        return capacity;
    }
    int I(String str){
        str = dot(str);
        return Integer.valueOf(str);
    }


    int resoToSendUnCoord(int sR /*storeReciver*/, int sS/*storeSender*/, int col/*column number in table*/) {
        int rTS = 0;
        if (!MainWindow.marketTable.getValueAt(0, col).toString().equals("")) {
            if (Integer.valueOf(MainWindow.marketTable.getValueAt(0, col).toString()) > sR)
                rTS = sR;
            else
                rTS = Integer.valueOf(MainWindow.marketTable.getValueAt(0, col).toString());
            if (rTS > sS)
                rTS = sS;
        }
        return rTS;
    }

    int resoToSendCoord(int sS/*
             * storeSender
             */, int col/*
             * column number in table
             */) {
        int rTS = 0; /*
         * resoToSend
         */

        if (!MainWindow.merchModel.getValueAt(0, col).toString().equals("")) {
            if (Integer.valueOf(
                    MainWindow.merchModel.getValueAt(0, col).toString()) > sS) {
                rTS = Integer.valueOf(MainWindow.merchModel.getValueAt(0, col).toString());
            } else {
                rTS = sS;
            }
        }
        return rTS;
    }
String dot(String str){
    while(str.indexOf(".")>-1)
        str = str.replace(".", "");
    return str.trim();
}

    //</editor-fold>
}
