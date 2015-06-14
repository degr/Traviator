package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" кузница ">
class ThreadBlackSmith implements Runnable {

    Thread TCe;

    ThreadBlackSmith() {
        TCe = new Thread(this, "construct thread");
        TCe.start();
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {
boolean error = false;
        try {
            MainWindow.consoleText(Color.BLUE, MainWindow.messages[300][MainWindow.language] + "(" + MainWindow.time() + ")\n");
            MainWindow.sleeep(2000);
            debug(1);
            MainWindow.villageChange(MainWindow.blackSmithModel.getValueAt(0, 0).toString(), "build.php", "&gid=13");
            String unitName = MainWindow.blackSmithModel.getValueAt(0, 1).toString();
            boolean stop = false;
            MainWindow.interrupt = false;
//                 номер здания, в котором будем строить унита
            int number = 0;
//     номер унита
            int uNumber = 0;
            debug(2);
            for (int unit = 0; unit < 8 && stop == false && MainWindow.interrupt == false; unit++) {
                for (int lang = 0; lang < MainWindow.messages[1].length && stop == false && MainWindow.interrupt == false; lang++) {
                    if (unitName.equals(MainWindow.units[MainWindow.tribe][unit][lang])) {
                        uNumber = unit + 1 + MainWindow.tribe * 10;
                        stop = true;
                        debug(3);
                    }
                }
            }
            debug(4);
            int count = MainWindow.driver.findElements(By.className("research")).size();
            for (int i = 1; i <= count; i++) {debug(5);
                String attr = MainWindow.driver.findElement(By.xpath("//*[@id=\"build\"]/div[4]/div[" + i + "]/div[2]/div[1]/a[1]/img")).getAttribute("class");
                if (attr.equals("unit u" + uNumber)) {debug(6);
                    MainWindow.driver.findElement(By.xpath("//*[@id=\"build\"]/div[4]/div[" + i + "]/div[2]/div[3]/button")).click();
                }
            }
            MainWindow.consoleText(Color.BLACK, MainWindow.messages[301][MainWindow.language] + MainWindow.blackSmithModel.getValueAt(0, 1).toString()
                    + MainWindow.messages[302][MainWindow.language] + MainWindow.blackSmithModel.getValueAt(0, 0).toString()
                    + MainWindow.messages[303][MainWindow.language]);
        } catch (Exception Ex) {
            if(Ex instanceof org.openqa.selenium.NoSuchElementException)
            MainWindow.consoleText(Color.BLACK, MainWindow.messages[304][MainWindow.language] + MainWindow.blackSmithModel.getValueAt(0, 1).toString() + ")"
                    + MainWindow.messages[302][MainWindow.language] + MainWindow.blackSmithModel.getValueAt(0, 0).toString()
                    + MainWindow.messages[305][MainWindow.language]);
            else{
                error = true;
                MainWindow.errorExecution(Ex);
            }
        }
        String futureRow[] = new String[]{
            MainWindow.blackSmithModel.getValueAt(0, 0).toString(),
            MainWindow.blackSmithModel.getValueAt(0, 1).toString(),
            MainWindow.blackSmithModel.getValueAt(0, 2).toString(),
            MainWindow.setTimer(MainWindow.blackSmithModel.getValueAt(0, 4).toString()),
            MainWindow.blackSmithModel.getValueAt(0, 4).toString(),};
        MainWindow.blackSmithModel.removeRow(0);
        MainWindow.blackSmithModel.insertRow(MainWindow.rowNumber(MainWindow.blackSmithModel, 2, futureRow[3]), futureRow);
        MainWindow.interrupt = false;
        MainWindow.waitInterrupt = false;
        MainWindow.reload = 0;
        MainWindow.debug(7, true);
        if (MainWindow.buttonStart.isSelected() == true && error == false) {
            MainWindow.preWaitCheck();
        }

    }

}
