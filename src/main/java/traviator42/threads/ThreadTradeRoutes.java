package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import traviator42.gui.common.MainWindow;

import java.util.ArrayList;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="создаем маршруты">
class ThreadTradeRoutes implements Runnable {

    static Thread TSC;
    ArrayList<String> data;
    WebDriver dr;

    ThreadTradeRoutes(ArrayList<String> data) {
        TSC = new Thread(this, "Refresh thread");
        this.data = data;
        TSC.start();

    }

    @Override
    public void run() {

        MainCopyStatus.progressBar.setStringPainted(true);
        MainCopyStatus.progressBar.setMinimum(0);
        MainCopyStatus.progressBar.setMaximum(24);
        MainCopyStatus.progressBar.setValue(0);

        MainCopyStatus.progressBarSmall.setStringPainted(true);
        MainCopyStatus.progressBarSmall.setMinimum(0);
        MainCopyStatus.progressBarSmall.setValue(0);
        MainCopyStatus.progressBarSmall.setMaximum(6);
        dr = MainWindow.driver;

        boolean pass = MainWindow.villageChange(data.get(0), "build.php", "&t=0&gid=17");
        if (pass == true) {

            for (int j = 0; j < 24 && MainCopyStatus.stop == false; j++) {
                while (MainCopyStatus.buttonToggle.isSelected() == false)
                    MainWindow.sleeep(1);
                MainCopyStatus.progressBarSmall.setValue(0);
                MainWindow.villageChange(data.get(0), "build.php", "&t=0&gid=17&option=1");
                MainCopyStatus.progressBarSmall.setValue(1);
                //<editor-fold defaultstate="collapsed" desc="выбираем в какую деру отправлять">
                WebElement sE = dr.findElement(By.name("did_dest"));
                Select select = new Select(sE);
                String href = "";
                for (int i = 0; i < MainWindow.vilList.size(); i++)
                    if (MainWindow.vilList.get(i).name.equals(data.get(1))) {
                        href = MainWindow.vilList.get(i).url;
                        break;
                    }
                href = href.substring(href.indexOf("=") + 1);
                select.selectByValue(href);
                //</editor-fold>
                MainCopyStatus.progressBarSmall.setValue(2);

                for (int i = 1; i < 5; i++) {
                    if (!data.get(i + 1).equals("0")) {
                        dr.findElement(By.id("r" + i)).clear();
                        dr.findElement(By.id("r" + i)).sendKeys(data.get(i + 1));
                    }
                }
                MainCopyStatus.progressBarSmall.setValue(3);

                sE = dr.findElement(By.name("hour"));
                select = new Select(sE);
                select.selectByVisibleText("" + j);
                MainCopyStatus.progressBarSmall.setValue(4);
                sE = dr.findElement(By.name("repeat"));
                select = new Select(sE);
                select.selectByVisibleText(data.get(10));
                MainCopyStatus.progressBarSmall.setValue(5);
                dr.findElement(By.xpath("//*[@id=\"tradeRouteEdit\"]/p/button")).click();
                MainCopyStatus.progressBarSmall.setValue(6);
                MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue() + 1);
                MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[345][MainWindow.language] + j + "\n");
                MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
            }
            MainCopyStatus.buttonOk.setEnabled(true);
            MainCopyStatus.buttonCancel.setEnabled(false);
            MainCopyStatus.stop = false;
        }


    }
}
