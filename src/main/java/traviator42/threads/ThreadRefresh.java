package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.dto.Village;
import traviator42.gui.common.MainLogin;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;
import traviator42.utils.WD;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="Refresh">
public class ThreadRefresh implements Runnable {

    public ThreadRefresh() {
        if (MainWindow.TR == null);
        {
            MainWindow.TR = new Thread(this, "Refresh thread");
            MainWindow.TR.start();
        }
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {
        MainWindow.sleeep(2000);
        //извлекаем корень сервера
        MainWindow.load = false;
        WD d = new WD(MainWindow.driver);
        //<editor-fold defaultstate="collapsed" desc=" авторизация ">
        if(MainWindow.showTips == 1 && MainWindow.firstRefresh == true){
            MainWindow.consoleText(new Color(27, 132, 57), MainWindow.messages[339][MainWindow.language]);
        }
        try {
            debug(1);
            d.get(MainLogin.serverText.getText());

            debug(2);

            //<editor-fold defaultstate="collapsed" desc="авторизация">
            d.name("name").clear();
            d.name("name").sendKeys(MainLogin.loginText.getText());
            MainWindow.consoleText(Color.BLACK, MainWindow.messages[7][MainWindow.language]);
            debug(3);
            d.name("password").clear();
            d.name("password").sendKeys(MainLogin.passText.getText());
            debug(4);
            MainWindow.consoleText(Color.BLACK, MainWindow.messages[8][MainWindow.language]);

            if (null == MainWindow.driver.findElement(By.id("lowRes")).getAttribute("checked")) {
                debug(5);
                try {
                    MainWindow.driver.findElement(By.id("lowRes")).click();
                } catch (org.openqa.selenium.WebDriverException ex) {
                    try {debug(6);
                    MainWindow.driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/label")).click();
                    } catch (org.openqa.selenium.WebDriverException exx) {debug(7);
                    }
                }
            }
            debug(8);
            d.name("password").submit();
            //</editor-fold>

            //</editor-fold>
            MainWindow.consoleText(Color.BLACK, MainWindow.messages[9][MainWindow.language]);
            MainWindow.sleeep(2000);
            //<editor-fold defaultstate="collapsed" desc=" картинки ">
debug(9);
            String t = d.xp("//div[@ class=\"playerName\"]/img").getAttribute("class");
            //*[@id="sidebarBoxHero"]/div[2]/div[1]/div[2]/img
            t = t.trim().substring(t.length()-1).trim();
debug(10);
            MainWindow.tribe = Integer.valueOf(t) - 1;
            MainWindow.IconCreater();
            if(MainWindow.tribe == 0)
                MainWindow.archTab.setEnabledAt(1, true);
            else{
                MainWindow.archTab.setEnabledAt(1, false);
                MainWindow.internationalization();
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc=" профиль ">
            //профиль (название)
            try {
                debug(11);
                MainWindow.profile.setText(d.xp("//*[@id=\"sidebarBoxHero\"]/div[2]/div[1]/div").getText());
                MainWindow.allyance.setText(d.xp("//*[@id=\"sidebarBoxAlliance\"]/div[2]/div[1]/div[2]").getText());
            } catch (Exception Ex) {
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc=" Лист-список деревень ">
            debug(12);
            //считаем количество деревень
            int villagCount = MainWindow.driver.findElements(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li")).size();

            while (MainWindow.demolishModel.getRowCount() > 0)
                MainWindow.demolishModel.removeRow(0);
            while (MainWindow.architectorModel.getRowCount() > 0)
                MainWindow.architectorModel.removeRow(0);
            while (MainWindow.architectorModelDouble.getRowCount() > 0)
                MainWindow.architectorModelDouble.removeRow(0);

            MainWindow.comboBoxArcVillages.removeAllItems();
            MainWindow.comboBoxArcVillagesDouble.removeAllItems();
            MainWindow.comboBoxArcVillagesDemolish.removeAllItems();

            debug(13);
            archCheck(villagCount,d);

            for (int i = 0; i < villagCount; i++) {
                debug(14);
                String villageName = d.xp("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li["+(i+1)+"]/a/div").getText();
                debug(15);
                String villageHref = d.xp("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li["+(i+1)+"]/a").getAttribute("href");

                //заносим в массив деревень название и ссылку на деру
                MainWindow.vilList.get(i).name = villageName;
                MainWindow.vilList.get(i).url = villageHref;
                MainWindow.comboBoxArcVillages.addItem(villageName);
                MainWindow.comboBoxArcVillagesDouble.addItem(villageName);
                MainWindow.comboBoxArcVillagesDemolish.addItem(villageName);
            }

            //</editor-fold>
            MainWindow.firstRefresh = false;
            MainWindow.consoleText(Color.BLUE, MainWindow.messages[10][MainWindow.language]);
            if(Traviator42.message == false){
//                ThreadMessage tm = new ThreadMessage();
                Traviator42.message = true;
            }
            if(MainWindow.chrome == false)
                MainWindow.driver.navigate().to(MainWindow.server + "dorf2.php");
            debug(16);

            if (MainWindow.buttonStart.isSelected() == true) {
                debug(17);
                MainWindow.waitInterrupt = true;
                MainWindow.sleeep(1500);
                MainWindow.waitInterrupt = false;
                ThreadWait tw = new ThreadWait();
            }

            if (MainWindow.autoBuild == true) {
                debug(18);
                MainWindow.checkBoxAutoBuild.setSelected(true);
            }
            MainWindow.debug(19, true);
            MainWindow.reload = 0;
            MainWindow.load = true;

            //<editor-fold defaultstate="collapsed" desc="перезапуск потока">
        } catch (Exception Ex) {
            errorExecution(Ex);
        }
        //</editor-fold>


    }

    void archCheck(int count, WD d) {
        ArrayList<String> villageNames = new ArrayList();
        ArrayList<String> villageHref = new ArrayList();

        for(int i = 0; i < count; i ++){
            villageNames.add(d.xp("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li["+(i+1)+"]/a/div").getText());
            villageHref.add(d.xp("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li["+(i+1)+"]/a").getText());
        }
        ArrayList<Village> newVillages = new ArrayList<>();
        for (String vilName : villageNames) {
            boolean find = false;
            for(int i = 0; i < MainWindow.vilList.size(); i++){
                if(MainWindow.vilList.get(i).name.equals(vilName)){
                    find = true;
                    MainWindow.vilList.get(i).url = villageHref.get(i);
                    newVillages.add(MainWindow.vilList.remove(i));
                     debug(14);
                //заносим в массив деревень название и ссылку на деру
                    MainWindow.comboBoxArcVillages.addItem(vilName);
                    MainWindow.comboBoxArcVillagesDouble.addItem(vilName);
                    MainWindow.comboBoxArcVillagesDemolish.addItem(vilName);
                    break;
                }
            }
            if(!find){
                newVillages.add(archAdd(vilName));
            }
        }
        MainWindow.vilList = newVillages;
    }

    Village archAdd(String name) {
            Village temp = new Village();
            temp.time = MainWindow.setTimer(temp.period);
            temp.dTime = MainWindow.setTimer(temp.dPeriod);

            if (MainWindow.autoBuild == true)
                temp.buildList.add("auto");
            if (MainWindow.autoBuild == true)
                temp.idList.add(99);

            temp.name = name;

            return temp;
    }

   private void errorExecution(Exception ex) {
        MainWindow.consoleError(ex);
        MainWindow.reload++;
        if (MainWindow.reload < 4 ) {
            check();
        } else {
            if (MainWindow.buttonStart.isSelected() == true || MainWindow.firstRefresh == true) {
                if (MainWindow.reload <= 5) {
                        MainWindow.driver.navigate().to(MainWindow.server + "dorf1.php?ok");
                        check();
                } else {
                    if (MainWindow.buttonStart.isSelected() == true) {
                        ThreadRefresh tr = new ThreadRefresh();
                    }
                }
            }
        }
    }

   private void check(){
        int n = 1;
        if(MainWindow.firstRefresh == true || MainWindow.buttonStart.isSelected() == false){
            Object[] options = {
                MainWindow.messages[156][MainWindow.language],
                MainWindow.messages[155][MainWindow.language]
            };
            n = JOptionPane.showOptionDialog(
                    Traviator42.mainWindow,
                    MainWindow.messages[336][MainWindow.language],
                    MainWindow.messages[132][MainWindow.language],
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
        }
        if(n == 1){
            ThreadRefresh tr = new ThreadRefresh();
        }else{
            Traviator42.login = new MainLogin(Traviator42.mainWindow, true);
            Traviator42.login.setVisible(true);
        }
    }
}
