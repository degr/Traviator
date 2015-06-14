package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import traviator42.dto.Village;
import traviator42.gui.common.MainWindow;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc=" Architector (снос) ">
class ThreadDemolish implements Runnable {

    Thread TC;
    int vilnum;

    ThreadDemolish(int vilnum) {
        this.vilnum = vilnum;
        TC = new Thread(this, "construct thread");
        TC.start();
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {
        int i = 0;
        boolean stop = false;
        MainWindow.consoleText(Color.BLUE, MainWindow.messages[290][MainWindow.language] + "(" + MainWindow.time() + ")\n");
        MainWindow.sleeep(2000);
        Village temp = MainWindow.vilList.get(vilnum);
debug(1);
        try {
            boolean pass = MainWindow.villageChange(MainWindow.comboBoxArcVillages.getItemAt(vilnum).toString(), "build.php", "&gid=15");
debug(2);
            WebElement selectElem = MainWindow.driver.findElement(By.tagName("select"));
            Select select = new Select(selectElem);
            String building = temp.demolishList.get(0);
            select.selectByValue(building.substring(0, building.indexOf(".")));
            MainWindow.driver.findElement(By.id("btn_demolish")).click();
            debug(3);
            String newTimer = MainWindow.driver.findElement(By.id("timer1")).getText();
            if (newTimer.length() == 7) {
                newTimer = "0" + newTimer;
            }
            debug(4);
            newTimer = MainWindow.setTimer(MainWindow.input(newTimer) + MainWindow.rand.nextInt(MainWindow.delay * 9));
            int level = temp.dLevel.get(0) - 1;
            temp.dLevel.set(0, level);
            if (level > 0) {debug(5);
                temp.dTime = newTimer;
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[291][MainWindow.language]
                        + MainWindow.comboBoxArcVillages.getItemAt(vilnum).toString() + " -> " + temp.demolishList.get(0) + ")\n");
            } else {debug(6);
                MainWindow.consoleText(Color.BLACK, MainWindow.messages[291][MainWindow.language]
                        + MainWindow.comboBoxArcVillages.getItemAt(vilnum).toString() + " -> " + temp.demolishList.get(0) + ")\n");
                temp.demolishList.remove(0);
                temp.dLevel.remove(0);
                if (MainWindow.comboBoxArcVillages.getSelectedItem().equals(vilnum)) {
                    MainWindow.demolishModel.removeRow(0);
                }
            }
            if (MainWindow.comboBoxArcVillages.getSelectedIndex() == vilnum) {debug(7);
                MainWindow.demolishTimeTF.setText(newTimer);
                MainWindow.demolishModel.setValueAt(level, 0, 1);
            }
            MainWindow.reload = 0;
            if (MainWindow.buttonStart.isSelected() == true){debug(8);
                MainWindow.preWaitCheck();
            }
            MainWindow.interrupt = false;
            MainWindow.waitInterrupt = false;
            MainWindow.debug(9, true);
            //<editor-fold defaultstate="collapsed" desc="обработка исключения с перезапуском">
        } catch (Exception Ex) {
            MainWindow.errorExecution(Ex);
        }
        //</editor-fold>
    }
}
