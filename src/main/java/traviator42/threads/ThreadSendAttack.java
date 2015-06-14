package traviator42.threads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import traviator42.gui.common.MainWindow;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc=" атака ">
class ThreadSendAttack implements Runnable {

    Thread TAt;
    int wave;
    WebElement el;
    WebDriver driver;

    ThreadSendAttack(WebDriver driver, int wave, WebElement el) {
        this.driver = driver;
        this.wave = wave + 1;
        this.el = el;

        TAt = new Thread(this, "Send attack thread");
        TAt.start();
    }

    @Override
    public void run() {
        el.click();
        MainWindow.consoleText(Color.BLACK, MainWindow.messages[328][MainWindow.language] + wave
                + MainWindow.messages[329][MainWindow.language] + MainWindow.time() + "\n");
        driver.quit();
    }
}
