package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import traviator42.dto.Village;
import traviator42.gui.common.MainWindow;
import traviator42.utils.WD;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc=" Architector ">
class ThreadConstruct implements Runnable {

    static int num;
    Thread TC;
    ArrayList<String> buildList;
    ArrayList<Integer> idList;
    String period;
    Village temp;
    boolean firstTab;
    ThreadConstruct(int vilnum, boolean firstTab) {
        this.firstTab = firstTab;
        num = vilnum;
        temp = MainWindow.vilList.get(num);
        if(firstTab == true){
             buildList = temp.buildList;
             idList = temp.idList;
             period = temp.period;
        }else{
            buildList = temp.buildListD;
            idList = temp.idListD;
            period = temp.periodDouble;
        }
        TC = new Thread(this, "construct thread");
        TC.start();

    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {
        boolean error = false;
        MainWindow.consoleText(Color.BLUE, MainWindow.messages[213][MainWindow.language] + "(" + MainWindow.time() + ")\n");
        MainWindow.sleeep(2000);
        WD d = new WD(MainWindow.driver);
//булин для того чтобы снять автостройку при задниях 10
        boolean resoLevel = false;
        debug(1);
        try {
        String name = buildList.get(0);

        String newTab = "";
        boolean fromZeroLevel = false;
        String ltr = "";
        if (name.indexOf("(N") > 0) {
            newTab = name.substring(name.indexOf("(N"));
            ltr = newTab.substring(newTab.indexOf("(N") + 3, newTab.indexOf(")"));
            name = name.substring(0, name.indexOf("(")).trim();
            fromZeroLevel = true;
        }
        debug(2);
        if (name.indexOf("auto") > -1) {
            String reso = resoCheck(num);

            if("0".equals(temp.storeLevel) ||
               "0".equals(temp.granaryLevel) ||
               "0".equals(temp.mainBuildLevel))
                buildCheck(num, temp);

            //<editor-fold defaultstate="collapsed" desc="Ауто">

            int resoLev;
            if(reso.indexOf(" ")>-1)
                resoLev = Integer.parseInt(reso.substring(reso.indexOf(" ") + 1));
            else
                resoLev = 10;
            if(resoLev == 10)
                resoLevel = true;

            int gLevel = Integer.parseInt(temp.granaryLevel.substring(0, temp.granaryLevel.indexOf(" ")));
            int newGLevel = gLevel/2;
            if(gLevel*2 != newGLevel)newGLevel++;

            int sLevel = Integer.parseInt(temp.storeLevel.substring(0, temp.storeLevel.indexOf(" ")));
            int newSLevel = sLevel/2;
            if(sLevel*2 != newSLevel)newSLevel++;

            int mLevel = Integer.parseInt(temp.mainBuildLevel.substring(0, temp.mainBuildLevel.indexOf(" ")));
            debug(3);
            if(gLevel == 30)gLevel = 0;
            if(sLevel == 30)sLevel = 0;
            if(mLevel == 30)mLevel = 0;

            name = "resoField";
            if(reso.indexOf(" ")>-1)
                idList.set(0, Integer.valueOf(reso.substring(0, reso.indexOf(" "))));
            else
                idList.set(0, 1);

            if(MainWindow.tribe == 0){
                if(firstTab==true){
                    mLevel = 20;
                    newGLevel = 20;
                    newSLevel = 20;
                }else{
                    resoLev = 10;
                }
            }
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="уровни склада, амбара, гл здания и ресов">
            int stopper = 0;
            if(firstTab == true){
                if(MainWindow.tribe != 0){
                    if(resoLev < mLevel && resoLev < newGLevel && resoLev < newSLevel)
                        stopper = 0;
                    if(mLevel <= resoLev && mLevel < newGLevel && mLevel < newSLevel)
                        stopper = 1;
                    if(newGLevel <= resoLev && newGLevel < mLevel && newGLevel < newSLevel)
                        stopper = 2;
                    if(newSLevel <= resoLev && newSLevel < mLevel && newSLevel < newGLevel)
                        stopper = 3;
                }
            }else{
                if(mLevel <= newGLevel && mLevel <= newSLevel)
                    stopper = 1;
                if(newGLevel <= mLevel && newGLevel < newSLevel)
                    stopper = 2;
                if(newSLevel <= newGLevel && newSLevel < mLevel)
                    stopper = 3;
            }

            if(stopper == 1){
                name = "MainBuilding";
                if(mLevel == 0){
                    newTab = ("(NI)");
                    fromZeroLevel = true;
                }
                idList.set(0, Integer.parseInt(temp.mainBuildLevel.substring(temp.mainBuildLevel.indexOf(" ")+1)));
                }
            if(stopper == 2){
                name = "Grannary";
                if(gLevel == 0){
                    newTab = ("(NI)");
                    ltr = "11";
                    fromZeroLevel = true;
                }
                idList.set(0, Integer.parseInt(temp.granaryLevel.substring(temp.granaryLevel.indexOf(" ")+1)));
            }
            if(stopper == 3){
                name = "store";
                if(sLevel == 0){
                    newTab = ("(NI)");
                    ltr = "10";
                    fromZeroLevel = true;
                }
                idList.set(0, Integer.parseInt(temp.storeLevel.substring(temp.storeLevel.indexOf(" ")+1)));
            }
            if(mLevel == 0){
                name = "MainBuilding";
                ltr = "15";
                newTab = ("(NI)");
                fromZeroLevel = true;
                idList.set(0, Integer.parseInt(temp.mainBuildLevel.substring(temp.mainBuildLevel.indexOf(" ")+1)));
            }
            //</editor-fold>
        }
        String tabPane = "";
        //для того, чтобы найти здание при постройке с фундамента

        if (fromZeroLevel == false) {
debug(5);
            //<editor-fold defaultstate="collapsed" desc="настройка суффикса при построке не с нуля">
            if ("Marketplace".equals(name))
                tabPane = "&t=0";
            if ("Treasury".equals(name))
                tabPane = "&s=0";
            if ("Residence".equals(name))
                tabPane = "&s=0";
            if ("Palace".equals(name))
                tabPane = "&s=0";
            if ("RallyPoint".equals(name))
                tabPane = "&tt=0";

            //</editor-fold>
debug(6);
        } else {
debug(7);
            //<editor-fold defaultstate="collapsed" desc="настройка суффикса при постройке с нуля">
            if ("(NI)".equals(newTab))
                tabPane = "&category=1";
            if ("(NM)".equals(newTab))
                tabPane = "&category=2";
            if ("(NR)".equals(newTab))
                tabPane = "&category=3";
            //</editor-fold>
debug(8);
        }

debug(9);
        String futureRow[] = new String[3];

            if (buildList.size() > 0) {
                futureRow[0] = buildList.get(0);
                futureRow[1] = MainWindow.setTimer(period);
            }

debug(10);

            boolean pass = false;
            try {
                String h = idList.get(0).toString();
                pass = MainWindow.villageChange(MainWindow.vilList.get(num).name, "build.php", "&id=" + h + tabPane);
                debug(11);
                if (pass == true) {
                    debug(12);
                    if (fromZeroLevel == false) {
                        debug(13);

                        //<editor-fold defaultstate="collapsed" desc="построка не с фундамента">
                        d.xp("//*[@id='contract']/div[3]/button/div/div[2]");
                        boolean ok = true;
                        try{
                            d.xp("//*[@id=\"contract\"]/div[3]/span");
                            ok = false;
                        }catch(org.openqa.selenium.NoSuchElementException ex){}
                        debug(14);
                        if(ok == true){
                            String nt = d.xp("//*[@id='contract']/div[2]/div/span[6]").getText().trim();
                            if (nt.length() < 8)
                                nt = "0" + nt;
                            debug(15);
                            futureRow[1] = MainWindow.setTimer(MainWindow.input(nt) + MainWindow.rand.nextInt(MainWindow.delay * 9));
                            d.xp("//*[@id=\"contract\"]/div[3]/button/div/div[2]").click();
                        }else
                            d.xp("aerjd").click();
                        //</editor-fold>

                        //<editor-fold defaultstate="collapsed" desc="акробатика с auto">
                        debug(16);
                        //</editor-fold>

                    } else {
                        debug(18);
                        //<editor-fold defaultstate="collapsed" desc="постройка с фундамента">
                        int count = MainWindow.driver.findElements(By.className("contractText")).size();
                        boolean stop = false;
                        for (int i = 2; i <= count && stop == false; i ++) {
                            debug(19);
                            String attr = d.xp("//*[@id=\"build\"]/div[" + i + "]/div[1]/a/img").getAttribute("class");
                            if (attr.indexOf(ltr) > -1) {
                                debug(20);

                                String nt = d.xp("//*[@id=\"build\"]/div[" + i + "]/div[2]/div[2]/div/span[6]").getText().trim();
                                if (nt.length() < 8)
                                    nt = "0" + nt;
                                debug(21);
                                futureRow[1] = MainWindow.setTimer(MainWindow.input(nt) + MainWindow.rand.nextInt(MainWindow.delay * 9));
                                d.xp("//*[@id=\"build\"]/div[" + i + "]/div[2]/div[3]/button").click();
                                debug(22);
                                stop = true;
                            }
                        }
                    //</editor-fold>
                    }

                    //<editor-fold defaultstate="collapsed" desc="поля деревни при успешной постройке ауто">
                    if(buildList.get(0).indexOf("auto") > -1){
                        int gLevel = Integer.parseInt(temp.granaryLevel.substring(0, temp.granaryLevel.indexOf(" ")))+1;
                        int sLevel = Integer.parseInt(temp.storeLevel.substring(0, temp.storeLevel.indexOf(" ")))+1;
                        int mLevel = Integer.parseInt(temp.mainBuildLevel.substring(0, temp.mainBuildLevel.indexOf(" ")))+1;
                        if("store".equals(name))
                            temp.storeLevel = sLevel + " "+ idList.get(0);
                        if("MainBuilding".equals(name))
                            temp.mainBuildLevel = mLevel + " "+ idList.get(0);
                        if("Grannary".equals(name))
                            temp.granaryLevel = gLevel+ " " + idList.get(0);
                        idList.set(0, 99);
                    }
                    //</editor-fold>

                    //<editor-fold defaultstate="collapsed" desc="удаляем строку, если это не ауто">
                    debug(23);
                    if(buildList.get(0).indexOf("auto") == -1 || (resoLevel == true && buildList.get(0).indexOf("auto") > -1)){
                    if(firstTab == true){
                        if (MainWindow.comboBoxArcVillages.getSelectedIndex() == num){
                            MainWindow.architectorModel.removeRow(0);
                            MainWindow.textFieldArchTime.setText(futureRow[1]);
                        }
                    }else{
                        if (MainWindow.comboBoxArcVillagesDouble.getSelectedIndex() == num){
                            MainWindow.architectorModelDouble.removeRow(0);
                            MainWindow.textFieldArchTime2.setText(futureRow[1]);
                        }
                    }
                            buildList.remove(0);
                            idList.remove(0);
                    }

                    //</editor-fold>
                    if(firstTab == true)
                        temp.time = futureRow[1];
                    else
                        temp.timeDouble = futureRow[1];
                    debug(24);
                    //<editor-fold defaultstate="collapsed" desc="сообщение - стройка успешна">
                    String t;
                    if(firstTab == true)
                        t = MainWindow.comboBoxArcVillages.getItemAt(num).toString();
                    else
                        t = MainWindow.comboBoxArcVillagesDouble.getItemAt(num).toString();
                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[199][MainWindow.language] +
                            t + " " + MainWindow.messages[216][MainWindow.language]
                            + name + MainWindow.messages[200][MainWindow.language]);
                    //</editor-fold>
                }
            } catch (org.openqa.selenium.NoSuchElementException ex) {
//     Если не нашли кнопку, то ставим задержку
debug(25);

//<editor-fold defaultstate="collapsed" desc="операции с временем">
if(firstTab == true){
    temp.time = futureRow[1];
    if (MainWindow.comboBoxArcVillages.getSelectedIndex() == num) {
        debug(26);
        MainWindow.textFieldArchTime.setText(futureRow[1]);
    }
}else{
    temp.timeDouble = futureRow[1];
    if (MainWindow.comboBoxArcVillagesDouble.getSelectedIndex() == num) {
        debug(26);
        MainWindow.textFieldArchTime2.setText(futureRow[1]);
    }
}

//</editor-fold>

                //<editor-fold defaultstate="collapsed" desc="сообщение - строка неуспешна">
                if (pass == true) {
                    debug(27);
                    String t;
                    if(firstTab == true)
                        t = MainWindow.comboBoxArcVillages.getItemAt(num).toString();
                    else
                        t = MainWindow.comboBoxArcVillagesDouble.getItemAt(num).toString();

                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[199][MainWindow.language]
                            + t
                            + " " + MainWindow.messages[216][MainWindow.language]
                            + name + MainWindow.messages[201][MainWindow.language]);
                }
                //</editor-fold>
            }
            //<editor-fold defaultstate="collapsed" desc="обработка исключений">
        } catch (Exception Ex) {
            error = true;
            MainWindow.errorExecution(Ex);
        }
        //</editor-fold>
debug(28);
        MainWindow.reload = 0;
        if (MainWindow.buttonStart.isSelected() == true && error == false) {MainWindow.debug(29, true);
            MainWindow.preWaitCheck();
        }
        MainWindow.interrupt = false;
        MainWindow.waitInterrupt = false;
    }

    String resoCheck(int num) {
        debug(30);
        MainWindow.villageChange(MainWindow.vilList.get(num).name, "dorf1.php", "");
        Integer levels[] = new Integer[19];
        debug(31);
        for (int j = 1; j < 19; j++){
            String l = MainWindow.driver.findElement(By.xpath("//*[@id=\"village_map\"]/div[" + j + "]")).getText();
            if("".equals(l))
                l="0";
            levels[j - 1] = Integer.valueOf(l);
        }
        debug(32);
        int smallest = 10;
        String code = "1";
        debug(33);
        for (int i = 0; i < 18; i++) {
            if (levels[i] < smallest) {
                smallest = levels[i];
                int j = i + 1;
                code = j + " " + smallest;
                debug(34);
            }
        }
        debug(35);
        //возвращает номер здания с уровнем в формате: "id lvl"
        return code;
    }

    void buildCheck(int num, Village temp) {
        debug(31);
        MainWindow.villageChange(MainWindow.vilList.get(num).name, "dorf2.php", "");
        ArrayList<WebElement> img = new ArrayList<>();
        for (int i = 1; i < 23; i++)
            img.add(MainWindow.driver.findElement(By.xpath("//*[@id=\"village_map\"]/img[" + i + "]")));

        buildLevel(img, temp);
    }

    void buildLevel(ArrayList<WebElement> el, Village temp) {
        //возвращает номер здания с уровнем в формате: "lvl id"
        for (int i = 0; i < 22; i++) {
            if ("building g10".equals(el.get(i).getAttribute("class"))) {
                String level = level(el.get(i));
                String checkLevel = temp.storeLevel;
                if(checkLevel.length() > 2)
                    checkLevel = checkLevel.substring(0, checkLevel.indexOf(" "));
                if(Integer.valueOf(checkLevel) < Integer.valueOf(level))
                    temp.storeLevel = level + " " + (i+19);

            }
            if ("building g11".equals(el.get(i).getAttribute("class"))) {
                String level = level(el.get(i));
                String checkLevel = temp.granaryLevel;
                if(checkLevel.length() > 2)
                    checkLevel = checkLevel.substring(0, checkLevel.indexOf(" "));
                if(Integer.valueOf(checkLevel) < Integer.valueOf(level))
                    temp.granaryLevel = level + " " + (i+19);
            }
            if ("building g15".equals(el.get(i).getAttribute("class"))) {
                String level = level(el.get(i));
                String checkLevel = temp.mainBuildLevel;
                if(checkLevel.length() > 2)checkLevel = checkLevel.substring(0, checkLevel.indexOf(" "));
                if(Integer.valueOf(checkLevel) < Integer.valueOf(level))
                    temp.mainBuildLevel = level + " " + (i+19);
            }
        }
        if("0".equals(temp.mainBuildLevel) || "0".equals(temp.granaryLevel) || "0".equals(temp.storeLevel)){
            ArrayList <Integer> constructions = new ArrayList();
            for(int i = 0; i < el.size(); i++){
                String url = el.get(i).getCssValue("background-image").trim();
                url = url.substring(url.indexOf("(")+1, url.length()-1);
                url = url.substring(url.indexOf("/g/")+3);
                if(url.indexOf("iso.png") > -1)
                    constructions.add(19+i);

            }
            if("0".equals(temp.mainBuildLevel))
                temp.mainBuildLevel = "0 " + constructions.remove(0);
            if("0".equals(temp.storeLevel) && constructions.size() > 0)
                temp.storeLevel = "0 " + constructions.remove(0);
            if("0".equals(temp.granaryLevel) && constructions.size() > 0)
                temp.granaryLevel = "0 " + constructions.remove(0);
        }
    }

    String level(WebElement el) {
        String level = el.getAttribute("alt");
        level = level.substring(level.indexOf("level"));
        level = level.substring(level.indexOf(" "), level.indexOf("<")).trim();
        return level;
    }
}
