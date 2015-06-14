package traviator42.threads;

import traviator42.gui.common.MainWindow;
import traviator42.utils.WD;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc=" Train units ">
class ThreadTrain implements Runnable {

    ThreadTrain() {
        MainWindow.TT = new Thread(this, "wait thread");
        MainWindow.TT.start();
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {

        MainWindow.interrupt = false;
        MainWindow.consoleText(Color.BLUE, MainWindow.messages[212][MainWindow.language] + "(" + MainWindow.time() + ")\n");
        MainWindow.sleeep(2000);
        String village = MainWindow.sargeTable.getValueAt(0, 0).toString();
debug(1);
        String descriptor = MainWindow.sargeTable.getValueAt(0, 1).toString();
        String root = descriptor.substring(0, descriptor.indexOf("(") - 1);
        String suffiks = descriptor.substring(descriptor.indexOf("("));
        WD d = new WD(MainWindow.driver);
        String building[] = new String[]{"&gid=19", "&gid=20", "&gid=21", "&gid=29", "&gid=30"};
        boolean stop = false;
//                 номер здания, в котором будем строить унита
        int number = 0;
//     номер унита
        int uNumber = 0;
        for (int unit = 0; unit < 8 && stop == false && MainWindow.interrupt == false; unit++) {
            for (int lang = 0; lang < MainWindow.messages[1].length && stop == false && MainWindow.interrupt == false; lang++) {

                if (root.equals(MainWindow.units[MainWindow.tribe][unit][lang])) {

                    if (MainWindow.tribe == 0) {
//                     0 - barrack, 1 - stables,
                        if (unit < 3) {
                            number = 0;
                        }
                        if (unit > 2 && unit < 6) {
                            number = 1;
                        }
                    }
                    if (MainWindow.tribe == 1) {
//                     0 - barrack, 1 - stables,
                        if (unit < 4) {
                            number = 0;
                        }
                        if (unit > 3 && unit < 6) {
                            number = 1;
                        }
                    }
//                     2 - workshop
                    if (unit > 5) {
                        number = 2;
                    }
                    if (MainWindow.tribe == 2) {
//                     0 - barrack, 1 - stables,
                        if (unit < 2) {
                            number = 0;
                        }
                        if (unit > 1 && unit < 6) {
                            number = 1;
                        }
                    }
                    uNumber = unit + 1;
                    stop = true;
debug(2);
                }
            }
        }
        if ("(L)".equals(suffiks)) {
            number = number + 3;
        }
        try {debug(3);
//    переходим в деревню
            boolean pass = MainWindow.villageChange(MainWindow.sergeantModel.getValueAt(0, 0).toString(), "build.php", building[number]);
            debug(4);
            if (pass == true) {debug(5);
                int count = Integer.valueOf(MainWindow.sargeTable.getValueAt(0, 2).toString());
                int realCount = Integer.valueOf(d.xp("//input[@ name = 't" + uNumber + "']/../a").getText().trim());
                if (realCount < count) {
                    count = realCount;
                }
//находим элемент
                debug(6);
                d.xp("//input[@ name = 't" + uNumber + "']").clear();
                 // и посылаем туда количество солдат
                d.xp("//input[@ name = 't" + uNumber + "']").sendKeys(String.valueOf(count));

                try {
                    debug(7);
                    d.id("s1").click();
                } catch (org.openqa.selenium.NoSuchElementException ex) {
                    d.xp("//button[@ class = 'startTraining']/div[@ class = 'button-container']").click();
                }
debug(8);
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[214][MainWindow.language] + root + " "
                        + String.valueOf(count) + "\n");
            }
            int count = Integer.valueOf(MainWindow.sargeTable.getValueAt(0, 5).toString());
            if (count != 999) {
                count = count - 1;
            }
            String clock = MainWindow.setTimer(MainWindow.sargeTable.getValueAt(0, 3).toString());
            String futureRow[] = new String[]{MainWindow.sargeTable.getValueAt(0, 0).toString(),
                MainWindow.sargeTable.getValueAt(0, 1).toString(),
                MainWindow.sargeTable.getValueAt(0, 2).toString(),
                MainWindow.sargeTable.getValueAt(0, 3).toString(),
                clock,
                String.valueOf(count)};
            MainWindow.sergeantModel.removeRow(0);
debug(9);
            if (count > 1) {
                MainWindow.sergeantModel.insertRow(MainWindow.rowNumber(MainWindow.sergeantModel, 4, futureRow[4]),
                        new Object[]{futureRow[0], futureRow[1], futureRow[2], futureRow[3], futureRow[4], futureRow[5]});

            }
            MainWindow.interrupt = false;
            MainWindow.waitInterrupt = false;
            MainWindow.reload = 0;
            if (MainWindow.buttonStart.isSelected() == true) {
                MainWindow.preWaitCheck();
            }
MainWindow.debug(10, true);
            //<editor-fold defaultstate="collapsed" desc="обработка исключения с перезапуском">
        } catch (Exception Ex) {
            MainWindow.errorExecution(Ex);
        }
        //</editor-fold>


    }
}
