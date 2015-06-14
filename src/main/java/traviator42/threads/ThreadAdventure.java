package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import traviator42.gui.common.MainWindow;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" приключения ">
class ThreadAdventure implements Runnable {

    Thread TCe;
    WebDriver driver;

    ThreadAdventure(WebDriver driver) {
        this.driver = driver;
        TCe = new Thread(this, "ThreadAdventure");
        TCe.start();
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {
boolean error = false;
        try {
            MainWindow.consoleText(Color.BLUE, MainWindow.messages[311][MainWindow.language] + "(" + MainWindow.time() + ")\n");
            MainWindow.sleeep(2000);
            debug(1);
            MainWindow.waitInterrupt = false;
            driver.navigate().to(MainWindow.server + "hero_adventure.php");
            debug(2);
            int rowCount = driver.findElements(By.xpath("//*[@id=\"adventureListForm\"]/table/tbody/tr")).size();
            boolean stop = false;
            for (int i = 1; i <= rowCount && stop == false; i++) {
                try{
                debug(3);
                String type = driver.findElement(By.xpath("//*[@id=\"adventureListForm\"]/table/tbody/tr[" + i + "]/td[4]/img")).getAttribute("class");
                if ("adventureDifficulty3".equals(type) && MainWindow.checkBoxAdventure.isSelected() == true) {
                    debug(4);
                    driver.findElement(By.xpath("//*[@id=\"adventureListForm\"]/table/tbody/tr[" + i + "]/td[6]/a")).click();
                    driver.findElement(By.id("start")).click();
                    stop = true;
                }
                if ("adventureDifficulty0".equals(type) && MainWindow.checkBoxAdventure.isSelected() == true ||
                    "adventureDifficulty1".equals(type) && MainWindow.checkBoxAdventure.isSelected() == true ||
                    "adventureDifficulty2".equals(type) && MainWindow.checkBoxAdventure.isSelected() == true) {
                    debug(5);
                    driver.findElement(By.xpath("//*[@id=\"adventureListForm\"]/table/tbody/tr[" + i + "]/td[6]/a")).click();
                    driver.findElement(By.id("start")).click();
                    stop = true;
                }
                }catch(org.openqa.selenium.NoSuchElementException ex){}
            }
            if (stop == true) {
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[312][MainWindow.language]);
            } else {
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[313][MainWindow.language]);
            }

        } catch (Exception Ex) {
            error = true;
            MainWindow.errorExecution(Ex);
        }
        MainWindow.jTextField2.setText(MainWindow.setTimer(MainWindow.jTextField1.getText()));
        MainWindow.interrupt = false;
        MainWindow.waitInterrupt = false;
        MainWindow.debug(6, true);
        if (MainWindow.buttonStart.isSelected() == true && error == false){
            MainWindow.preWaitCheck();
        }
    }

}
