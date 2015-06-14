package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="message">
class ThreadMdessage implements Runnable {
    ThreadMdessage() {
            Thread tr = new Thread(this, "ThreadMessage");
            tr.start();
    }
    @Override
    public void run() {
        WebDriver driver = new HtmlUnitDriver();
        try{
        driver.get("http://traviator.net/Message/message.html");
        String temp;
        if(MainWindow.language == 0)
            temp = "ru";
        else if(MainWindow.language == 1)
            temp = "en";
        else
            temp = "tag";
        String message = driver.findElement(By.className("" + Traviator42.version + temp + 42)).getText();
        MainWindow.consoleText(Color.red, message + "\n");
        }catch(Exception ex){
        }
        driver.quit();
        MainWindow.sleeep(14000 * 1000);
        ThreadMdessage tr = new ThreadMdessage();
    }
}
