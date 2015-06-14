package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;
import traviator42.gui.scout.ScoutScanPref;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="считаем страницы">
public class ThreadSearchCount implements Runnable {

    public static Thread TSC;

    public ThreadSearchCount() {
        TSC = new Thread(this, "Refresh thread");
        TSC.start();
    }

    @Override
    public void run() {
        try {
            if (MainWindow.buttonStart.isSelected() == true) {
                MainWindow.buttonStart.doClick();
            }
            MainWindow.driver.navigate().to(MainWindow.server + "statistiken.php");
            MainWindow.consoleText(Color.BLACK, MainWindow.messages[112][MainWindow.language]);
            String pages = MainWindow.driver.findElement
                    (By.xpath("(//div [@ class = 'paginator']/a[@ class = 'number'])[4]")).getText();
            ScoutScanPref ssp = new ScoutScanPref(Traviator42.mainWindow, true, pages);
            ssp.setVisible(true);
        } catch (org.openqa.selenium.NoSuchElementException Ex) {
            MainWindow.consoleText(Color.RED, MainWindow.messages[4][MainWindow.language]);
        }
    }
}
