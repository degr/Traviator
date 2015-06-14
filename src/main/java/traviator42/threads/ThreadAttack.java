package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import traviator42.gui.common.MainLogin;
import traviator42.gui.common.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc=" атака ">
class ThreadAttack implements Runnable {

    Thread TAt;
    static int comp;

    ThreadAttack(int comp) {
        this.comp = comp;
        TAt = new Thread(this, "ThreadAdventure");
        TAt.start();
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {
        boolean error = false;
        MainWindow.consoleText(Color.BLUE, MainWindow.messages[321][MainWindow.language] + "(" + MainWindow.time() + ")\n");
        MainWindow.sleeep(2000);
        debug(1);
        try {
            ArrayList<WebDriver> drivers = new ArrayList<>();//количество волн
            ArrayList<WebElement> el = new ArrayList<>();//количество волн

            double val = Double.valueOf(((JLabel) (infoPanel(comp).getComponent(0))).getText());
            int num = (int) val;//номер атаки
            debug(2);
            for (int i = comp; i < MainWindow.attackPanel.getComponentCount(); i++) {
                val = Double.valueOf(((JLabel) (infoPanel(i).getComponent(0))).getText());
                if (num == (int) val) {
                    debug(3);
                    switch(MainWindow.browser){
                        case 1:
                            drivers.add(new ChromeDriver());
                            break;
                        case 2:
                            drivers.add(new FirefoxDriver());
                            break;
                        default:
                            drivers.add(new HtmlUnitDriver());
                            break;
                    }
                }
            }

            String village = ((JComboBox) (infoPanel(comp).getComponent(1))).getSelectedItem().toString();
            String X = ((JTextField) (infoPanel(comp).getComponent(4))).getText();
            String Y = ((JTextField) (infoPanel(comp).getComponent(6))).getText();
            int type = ((JComboBox) (infoPanel(comp).getComponent(2))).getSelectedIndex() + 1;
            debug(4);
            int cataTargets = Integer.parseInt(((JSpinner) ((JPanel)tPanel(comp).getComponent(1)).getComponent(8)).getValue().toString());
//<editor-fold defaultstate="collapsed" desc=" подготовка волны ">
            String url = "";

            for (int i = 0; i < drivers.size(); i++) {


                java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);

                // try{
                drivers.get(i).navigate().to(MainWindow.server);
                drivers.get(i).findElement(By.name("name")).clear();
                drivers.get(i).findElement(By.name("name")).sendKeys(MainLogin.loginText.getText());
                drivers.get(i).findElement(By.name("password")).clear();
                drivers.get(i).findElement(By.name("password")).sendKeys(MainLogin.passText.getText());
debug(5);
                if (null == drivers.get(i).findElement(By.name("lowRes")).getAttribute("checked")) {
                    try {
                        drivers.get(i).findElement(By.id("lowRes")).click();
                    } catch (org.openqa.selenium.WebDriverException ex) {
                        try {
                            drivers.get(i).findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/label")).click();
                        } catch (org.openqa.selenium.WebDriverException exx) {
                        }
                    }
                }
                debug(6);
                drivers.get(i).findElement(By.className("button-container")).click();
debug(7);
                boolean validVillage = villageChange(village, "build.php", "&tt=2&id=39", drivers.get(i));
debug(8);
                int troopRows = tPanel(i).getComponentCount();
                for (int j = 0; j < troopRows; j++) {
                    int troopNum = ((JPanel) tPanel(i).getComponent(j)).getComponentCount();
                    for (int k = 0; k < troopNum / 2; k++) {
                        JPanel row = ((JPanel) tPanel(i).getComponent(j));
                        String valT = ((JSpinner) row.getComponent(k * 2 + 1)).getValue().toString();
                        if (!"0".equals(valT)) {debug(9);
                            int uNum = k + 1 + j * 4;
                            try {
                                drivers.get(i).findElement(By.name("t" + uNum)).sendKeys(String.valueOf(valT));
                            } catch (org.openqa.selenium.NoSuchElementException ex) {
                                MainWindow.consoleText(Color.BLACK, MainWindow.messages[325][MainWindow.language] + j
                                        + MainWindow.messages[326][MainWindow.language] + "t" + uNum + "\n");
                            }
                        }
                    }
                }
                debug(10);
                sendCoord(drivers.get(i), "xCoordInput", X);
                sendCoord(drivers.get(i), "yCoordInput", Y);


debug(11);
                drivers.get(i).findElement(By.xpath("//*[@id=\"build\"]/div[2]/form/div[2]/label[" + type + "]")).click();
                url = drivers.get(i).getCurrentUrl();
                debug(12);
                drivers.get(i).findElement(By.id("btn_ok")).click();
                el.add(drivers.get(i).findElement(By.id("btn_ok")));
                debug(13);
                if(cataTargets == 2){
                    try{
                        debug(14);
                    WebElement selectElem = drivers.get(i).findElement(By.xpath("//*[@id=\"build\"]/div[3]/form/table[2]/tbody[2]/tr/td/select[2]"));
                    Select select = new Select(selectElem);
                    select.selectByIndex(1);
                    }catch(org.openqa.selenium.NoSuchElementException ex){
                    }
                }
                i++;
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[322][MainWindow.language] + i + "\n");
                i--;
            }

            if (!drivers.get(0).getCurrentUrl().equals(url)) {debug(15);
                for (int i = 0; i < drivers.size(); i++) {
                    ThreadSendAttack tsa = new ThreadSendAttack(drivers.get(i), i, el.get(i));
                    MainWindow.sleeep(30);
                }
                debug(16);
            } else {
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[327][MainWindow.language]);
            }
            //</editor-fold>
            int count = MainWindow.attackPanel.getComponentCount();
                debug(17);
            for (int i = count - 1; i >= 0; i--) {
                double valll = Double.valueOf(((JLabel) ((JPanel) ((JPanel) MainWindow.attackPanel.getComponent(i)).getComponent(0)).getComponent(0)).getText());
                if (comp == (((int) valll)-1))
                    MainWindow.attackPanel.remove(i);
            }
        } catch (Exception Ex) {
            error = true;
            MainWindow.errorExecution(Ex);
        }
        MainWindow.attackPanel.revalidate();
        for(int i = 5; i > 0; i--){
            MainWindow.sleeep(1000);
            MainWindow.consoleText(Color.BLACK, "" + i + "...");
        }
        MainWindow.debug(19, true);
        MainWindow.interrupt = false;
        MainWindow.waitInterrupt = false;
        if (MainWindow.buttonStart.isSelected() == true && error == false){
            MainWindow.preWaitCheck();
        }
        }
    boolean villageChange(String villyName, String suffiks, String building, WebDriver driver) {
        boolean stop = false;
        int k = 0;
        for (int i = 0; i < MainWindow.vilList.size() && stop == false; i++) {
            if (MainWindow.vilList.get(i).name.equals(villyName)) {
                k = i;
                stop = true;
            }
        }
        String url = MainWindow.vilList.get(k).url;
        String villyId = url.substring(url.indexOf("?newdid"));
        if (stop == true) {
            driver.navigate().to(MainWindow.server + suffiks + villyId + building);
            MainWindow.slow();
        } else {
            MainWindow.consoleText(Color.RED, MainWindow.messages[227][MainWindow.language] + villyName + "\n");
        }
        return stop;
    }
    void sendCoord(WebDriver driver, String id, String coord){
        int x = Integer.parseInt(coord);
        if(x<0){
             driver.findElement(By.id(id)).sendKeys(Keys.SUBTRACT);
             x = x*(-1);
        }
        driver.findElement(By.id(id)).sendKeys(x+"");
    }
    JPanel infoPanel(int i) {
        JPanel pan = ((JPanel) ((JPanel) MainWindow.attackPanel.getComponent(i)).getComponent(0));
        return pan;
    }

    JPanel tPanel(int i) {
        JPanel pan = ((JPanel) ((JPanel) MainWindow.attackPanel.getComponent(i)).getComponent(1));
        return pan;
    }
}
