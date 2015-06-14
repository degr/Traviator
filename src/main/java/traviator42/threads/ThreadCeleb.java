package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;

import java.awt.*;
import java.util.Random;

/**
 * Created by Ror on 10.06.2015.
 */ //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" культура ">
class ThreadCeleb implements Runnable {

    Thread TCe;

    ThreadCeleb() {
        TCe = new Thread(this, "construct thread");
        TCe.start();
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {
        boolean error = false;
String timer = "01:00:00";
        try {
            MainWindow.consoleText(Color.BLUE, MainWindow.messages[250][MainWindow.language] + "(" + MainWindow.time() + ")\n");
            MainWindow.sleeep(2000);
            debug(1);
            MainWindow.villageChange(MainWindow.celebrateTable.getValueAt(0, 0).toString(), "build.php", "&gid=24");
debug(2);
            if ("*".equals(MainWindow.celebrateTable.getValueAt(0, 1).toString())) {debug(3);
                MainWindow.driver.findElement(By.xpath("//*[@id=\"build\"]/div[4]/div/div[1]/div[3]/button/div/div[2]")).click();
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[252][MainWindow.language]);
            }
            if ("**".equals(MainWindow.celebrateTable.getValueAt(0, 1).toString())) {debug(4);
                MainWindow.driver.findElement(By.xpath("//*[@id=\"build\"]/div[4]/div[2]/div[1]/div[3]/button/div/div[2]")).click();
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[253][MainWindow.language]);
            }
        } catch (Exception Ex) {
            if(Ex instanceof org.openqa.selenium.NoSuchElementException){
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[251][MainWindow.language]);
                try{
                timer = MainWindow.driver.findElement(By.xpath("//*[@id=\"build\"]/table/tbody/tr/td[2]")).getText().trim();
                timer = MainWindow.setTimer(MainWindow.input(timer)+5 +(new Random().nextInt(55)));
                }catch(org.openqa.selenium.NoSuchElementException ex){
                }
            }else{
                error = true;
                MainWindow.errorExecution(Ex);
            }
            }
        MainWindow.sleeep(1000);
        String futureRow[] = new String[]{
            MainWindow.celebrateTable.getValueAt(0, 0).toString(),
            MainWindow.celebrateTable.getValueAt(0, 1).toString(),
            timer,
            MainWindow.celebrateTable.getValueAt(0, 3).toString(),
        };
        MainWindow.celebrateModel.removeRow(0);
        MainWindow.celebrateModel.insertRow(MainWindow.rowNumber(MainWindow.celebrateModel, 2, futureRow[2]), futureRow);
        MainWindow.interrupt = false;
        MainWindow.waitInterrupt = false;
        MainWindow.reload = 0;
        MainWindow.debug(5, true);
        if (MainWindow.buttonStart.isSelected() == true && error == false) {
            MainWindow.preWaitCheck();
        }

    }
}
