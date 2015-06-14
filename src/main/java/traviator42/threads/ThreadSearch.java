package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;
import traviator42.gui.search.Search;
import traviator42.utils.WD;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="search">
class ThreadSearch implements Runnable {

    public static Thread TS;
    static ArrayList<ArrayList<String>> targets = new ArrayList<ArrayList<String>>();
    static int maxDist = 0, minDist = 0;
    static int maxPop, minPop;
    int villageX;
    int villageY;
    WD d;
    String owner, ally, population, to, villy;
    ArrayList<String> popLimit;
    ThreadSearch(String villy) {
        this.villy = villy;
        TS = new Thread(this, "Search thread");
        TS.start();
    }

    @Override
    public void run() {
        if (MainWindow.buttonStart.isSelected() == true) {
            MainWindow.buttonStart.doClick();
        }
        String time = setTime();

        setPorgressBar();
        d = new WD(MainWindow.driver);
        //<editor-fold defaultstate="collapsed" desc=" авторизация ">

        try {
        setDistVariables();

        setPopulationVariables();

        setVillageCoord();

        largeCycle();

        progressBarGUI();

        textAreaMessages();

        //массив для игроков с большим насом и большим количеством деревень.
        popLimit = new ArrayList<String>();

        int size = targets.size();
        for (int i = 0; i < size && MainCopyStatus.stop == false; i++) {
            while (MainCopyStatus.buttonToggle.isSelected() == false) {
                MainWindow.sleeep(1);
            }
            ArrayList<String> temp;

            temp = targets.get(i);

//<editor-fold defaultstate="collapsed" desc="расстояние">
            String type = temp.get(0);
            int tarX = Integer.valueOf(temp.get(1));
            int tarY = Integer.valueOf(temp.get(2));
            int dist = MainWindow.dist(villageX, villageY, tarX, tarY);
//</editor-fold>

            int plaPop = 0;
                   try{

            if (dist < maxDist && dist > minDist) {
                boolean check = false;

                if ("oase".equals(type)) {
                    check = oaseCheck(temp, type, tarX, tarY);
                } else {
                    check = villageCheck(temp, tarX, tarY, plaPop);

//</editor-fold>

                }


//<editor-fold defaultstate="collapsed" desc="Строка в таблице">
                if (check == true) {
                    if (!"error".equals(population)) {
                        int pop = 0;
                        if (!"---".equals(population)) {
                            pop = Integer.valueOf(population);
                        }
                        String units = "";
                        for (int t = 0; t < 6; t++) {
                            if (pop >= MainWindow.popBorder[t][0] && pop < MainWindow.popBorder[t][1]) {
                                units = String.valueOf(MainWindow.interval[t]);
                                break;
                            }
                        }
                        MainWindow.banditoModel.addRow(new Object[]{
                            villy,
                            owner + " / " + to + " / " + ally,
                            dist + " / " + pop,
                            tarX + "/" + tarY
                        });

                        MainWindow.banditoListModelE.insertRow(
                                MainWindow.rowNumber(MainWindow.banditoListModelE, 5, time),
                                new Object[]{
                            villy,
                            owner + " / " + to + " / " + ally,
                            units,
                            dist + " / " + pop,
                            tarX + "/" + tarY,
                            time,
                            MainWindow.raidInterval
                        });
                        time = MainWindow.setTimer(MainWindow.input(time) + (MainWindow.rand.nextInt(5) + 3));
                    }
                }
//</editor-fold>
            }
//<editor-fold defaultstate="collapsed" desc="Исключения и сон">
                   }catch(Exception ex){
                       error(tarX, tarY);
                   }
//</editor-fold>
            MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);

        }
        MainCopyStatus.progressBar.setValue(2);
        MainCopyStatus.stop = false;
        MainCopyStatus.buttonOk.setEnabled(true);

        } catch (Exception ex) {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex1) {
                Logger.getLogger(ThreadSearch.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ThreadSearch ts = new ThreadSearch(villy);
        }
    }

    boolean villageCheck(ArrayList<String> temp, int tarX, int tarY, int plaPop) {
        boolean popMax = false;
        boolean check = false;
        if ("natar".equals(temp.get(3)) && Search.checkBoxNatars.isSelected() == true) {
            check = true;
            owner = "natar";
            ally = "natar";
            to = "natar";
        } else if ("player".equals(temp.get(3)) && Search.checkBoxSearchVillages.isSelected()) {
//                               проверка альянса
            getInfo(tarX, tarY, true, false);
            if ((Search.checkBoxIncludeAlly.isSelected() == true) || "".equals(ally)) {
                String yourAlly = MainWindow.allyance.getText();
                if ("".equals(ally)) {
                    ally = "---";
                }
                if (!yourAlly.equals(ally)) {
                    for (int p = 0; p < popLimit.size() && !"natar".equals(temp.get(3)); p++) {
                        if (owner.equals(popLimit.get(p))) {
                            popMax = true;
                        }
                    }
                    if (popMax == false) {
                        // смотрим сколько всего наса у владельца
                        MainWindow.driver.findElement(By.xpath("//*[@id='village_info']/tbody/tr[3]/td/a")).click();
                        if(d.ajaxEl("//*[@id='details']/tbody/tr[5]/td"))
                            plaPop = d.getInt("//*[@id='details']/tbody/tr[5]/td");
                        else
                            plaPop = 10000;

                        MainWindow.slow();
                        //если с насом беда, то вставляем его в нон грате
                        if (plaPop > maxPop || plaPop < minPop) {
                            popLimit.add(owner);
                        }

                        if (plaPop > minPop && plaPop < maxPop) {
                            check = true;
                        }
                    }
                }
            }
        }


        if (Search.checkBoxNatars.isSelected() == true && "natar".equals(temp.get(3))) {
            check = true;
            owner = "natar";
            ally = "natar";
            to = "natar";
            getInfo(tarX, tarY, true, true);
        }
        return check;
    }

    boolean oaseCheck(ArrayList<String> temp, String type, int tarX, int tarY) {
        boolean check = false;
        if (Search.checkBoxOase.isSelected() == true) {

            if (("free".equals(temp.get(3)) || ("occupied".equals(temp.get(3))) && Search.checkBoxIncludeOcc.isSelected())) {
                if ("occupied".equals(temp.get(3))) {
                    getInfo(tarX, tarY, false, false);
                } else {
                    owner = "---";
                    ally = "---";
                    to = "oasis";
                }
                if (Search.checkBoxWithoutAnimals.isSelected() == true) {
                    d.get(MainWindow.server + "position_details.php?x=" + tarX + "&y=" + tarY);
                    try {
                        String animalCount = MainWindow.driver.findElement(By.xpath("//*[@id='troop_info']/tbody/tr[1]/td[2]")).getText().trim();

                        String el = MainWindow.driver.getPageSource();
                        int che = el.indexOf("unit u40");
                        if (che != -1) {
                            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[350][MainWindow.language] + tarX + "/" + tarY + "\n");
                            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
                        }

                        if (Integer.valueOf(animalCount) > 0) {
                            MainWindow.slow();
                            check = false;
                        }
                        //       пустые ексцепшоны нужны для оазов без животных
                    } catch (org.openqa.selenium.NoSuchElementException Ex) {
                        check = true;
                        MainWindow.slow();
                    } catch (org.openqa.selenium.remote.UnreachableBrowserException Ex) {
                    } catch (org.openqa.selenium.StaleElementReferenceException Ex) {
                    }
                } else {
                    check = true;
                }
                population = "---";
            }
        }
        return check;
    }

    void setDistVariables() {
        minDist = Integer.valueOf(Search.textFieldMinDist.getText());
        maxDist = Integer.valueOf(Search.textFieldMaxDist.getText());
        if (maxDist < minDist) {
            int f = maxDist;
            maxDist = minDist;
            minDist = f;
        }
        if (maxDist > 400) {
            maxDist = 400;
            Search.textFieldMaxDist.setText("400");
        }
    }

    void textAreaMessages() {
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[121][MainWindow.language] + targets.size() + "\n");
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[122][MainWindow.language]);
        MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
    }

    void progressBarGUI() {
        MainCopyStatus.progressBar.setValue(1);
        MainCopyStatus.progressBarSmall.setValue(0);
        MainCopyStatus.progressBarSmall.setMaximum(targets.size());

    }

    void largeCycle() {
        //<editor-fold defaultstate="collapsed" desc="исходные координаты">
//     ищем точку откуда начнется сканирование
        int X = Integer.valueOf(MainWindow.driver.findElement(By.xpath("//*[@id='mapContainer']/div[1]/div[8]/div/div[5]")).getText()) - maxDist;
        int Y = Integer.valueOf(MainWindow.driver.findElement(By.xpath("//*[@id='mapContainer']/div[1]/div[9]/div/div[4]")).getText()) + maxDist;
        MainWindow.slow();
//  сверяем ее с тороидными координатами
        X = MainWindow.torCoord(X, maxDist);
        Y = MainWindow.torCoord(Y, maxDist);
//</editor-fold>


//<editor-fold defaultstate="collapsed" desc="большие циклы">
        int xcount = maxDist * 2 / 9 + 1;
        int ycount = maxDist * 2 / 7 + 1;
//по Y
        int x1 = X;

        MainCopyStatus.progressBarSmall.setValue(0);
        MainCopyStatus.progressBarSmall.setMaximum(xcount * ycount);
        String lastSource = "";
        for (int i = 0; i < ycount && MainCopyStatus.stop == false; i++) {
//    по Х
//    для того чтобы восстанавливать Х при переходе на строку ниже
            X = x1;
            for (int j = 0; j < xcount && MainCopyStatus.stop == false; j++) {
                while (MainCopyStatus.buttonToggle.isSelected() == false) {
                    MainWindow.sleeep(1);
                }
                MainWindow.sendKeysCoord("x", Integer.valueOf(X), "CoordInputMap");
                MainWindow.sendKeysCoord("y", Integer.valueOf(Y), "CoordInputMap");
                MainWindow.driver.findElement(By.xpath("//*[@id=\"mapCoordEnter\"]/div/div/div/div/div[2]/../button")).click();
                lastSource = targets(lastSource, 0);
                X = X + 9;
                X = MainWindow.torCoord(X, 9);
                MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                MainCopyStatus.textAreaCopyConsole.append("*   ");
//        конец большого цикла по Х
            }
            MainCopyStatus.textAreaCopyConsole.append("\n");
            Y = Y - 7;
            Y = MainWindow.torCoord(Y, 7);
//конец большого цикла по У
        }
//</editor-fold>

    }

    void setVillageCoord() {
        //<editor-fold defaultstate="collapsed" desc="координаты родной деры">
        MainWindow.villageChange(Search.comboBoxVillageName.getSelectedItem().toString(), "karte.php", "");
        villageX = Integer.valueOf(MainWindow.driver.findElement(By.xpath("//div[@class='ruler x']/div[@ class = 'rulerContainer']/div[5]")).getText());
        villageY = Integer.valueOf(MainWindow.driver.findElement(By.xpath("//div[@class='ruler y']/div[@ class = 'rulerContainer']/div[4]")).getText());
//</editor-fold>
    }

    void setPopulationVariables() {
        maxPop = Integer.valueOf(Search.textFieldMaxPlayerPop.getText());
        minPop = Integer.valueOf(Search.textFieldMinPlayerPop.getText());
        if (maxPop < minPop) {
            int f = maxPop;
            maxPop = minPop;
            minPop = f;
        }
        Search.textFieldMaxPlayerPop.setText(String.valueOf(maxPop));
        Search.textFieldMinPlayerPop.setText(String.valueOf(minPop));
    }

    String setTime() {
        String time = "00:00:05";
        if (MainWindow.banditoListModelE.getRowCount() > 0) {
            time = MainWindow.banditoListModelE.getValueAt(MainWindow.banditoListModelE.getRowCount() - 1, 5).toString();
            time = MainWindow.setTimer(MainWindow.input(time) + (MainWindow.rand.nextInt(5) + 3));
        }
        return time;
    }

    void setPorgressBar() {
        MainCopyStatus.progressBar.setStringPainted(true);
        MainCopyStatus.progressBar.setMinimum(0);
        MainCopyStatus.progressBar.setMaximum(2);
        MainCopyStatus.progressBar.setValue(0);
        MainCopyStatus.progressBarSmall.setStringPainted(true);
        MainCopyStatus.progressBarSmall.setMinimum(0);
    }

    //<editor-fold defaultstate="collapsed" desc=" Метод доствания информации с карты ">
    String targets(String lastSource, int step) {
        ArrayList<String> data = new ArrayList<>();
        boolean pass = true;

        if (step != 0) {
            String s = MainWindow.driver.getPageSource();
            if (s.equals(lastSource)) {
                pass = false;
            } else {
                lastSource = s;
            }
        }
//  добавляем в массив всю инфу о текущем квадрате карты
        if (pass || step > 3) {
            for (int y = 1; y < 8; y++) {
                for (int x = 1; x < 10; x++) {
                    try {
                        data.add(MainWindow.driver.findElement(By.xpath("//*[@id=\"mapContainer\"]/div[1]/div[" + y + "]/div[" + x + "]")).getAttribute("class"));
                    } catch (Exception ex) {
                    }
                }
            }
//сравниваем полученный результат с интересующим, с занесением в массив целей
            for (int i = 0; i < data.size(); i++) {
                int v = data.get(i).toString().indexOf("village");
                int o = data.get(i).toString().indexOf("oasis");
                if (v > -1 || (o > -1)) {
                    String X, Y, type, state = "";
                    String d = data.get(i);
                    X = d.substring(d.indexOf("{") + 1, d.indexOf("}"));
                    d = d.substring(d.indexOf("}") + 1);
                    Y = d.substring(d.indexOf("{") + 1, d.indexOf("}"));

                    if (v > -1) {
                        type = "village";
                        if (d.indexOf("village5") > -1) {
                            state = "natar";
                        } else {
                            state = "player";
                        }
                    } else {
                        type = "oase";
                        if (d.indexOf("occupied") > -1) {
                            state = "occupied";
                        } else {
                            state = "free";
                        }
                    }
                    ArrayList<String> target = new ArrayList<String>();
                    target.add(type);
                    target.add(X);
                    target.add(Y);
                    target.add(state);
                    targets.add(target);
                }
            }
        } else {
            MainWindow.sleeep(3000);
            lastSource = targets(lastSource, step++);
        }
        return lastSource;
    }

    Boolean source(String source, String firstSource) {
        Boolean check = true;
        if (source.equals(firstSource)) {
            check = false;
            MainWindow.sleeep(2000);
        }
        return check;
    }

    ArrayList<String> substr(int j, String source, ArrayList<String> arr, String begin, String end) {
        for (int i = 0; i < j; i++) {
            String data = source.substring(source.indexOf(begin), source.indexOf(end));
            arr.add(data);
            source = source.substring(source.indexOf(end) + 6);
        }
        return arr;
    }

    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" Метод владельца с альянсом ">
    void getInfo(int tarX, int tarY, boolean vill, boolean natar) {
        try {
            MainWindow.driver.navigate().to(MainWindow.server + "position_details.php?x=" + tarX + "&y=" + tarY);
            if (natar == true) {
                owner = "natar";
                ally = "natar";
            } else {
                owner = MainWindow.driver.findElement(By.xpath("//*[@id='village_info']/tbody/tr[3]/td/a")).getText();
                ally = MainWindow.driver.findElement(By.xpath("//*[@id='village_info']/tbody/tr[2]/td/a")).getText();
            }
            to = MainWindow.driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
            if (vill == true) {
                population = MainWindow.driver.findElement(By.xpath("//*[@id='village_info']/tbody/tr[4]/td")).getText();
            } else {
                population = MainWindow.driver.findElement(By.xpath("//*[@id='village_info']/tbody/tr[4]/td")).getText();
            }
            MainWindow.slow();
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            error(tarX, tarY);
            owner = "error";
            ally = "error";
            to = "error";
            population = "error";
        } catch (org.openqa.selenium.remote.UnreachableBrowserException ex) {
            error(tarX, tarY);
            owner = "error";
            ally = "error";
            to = "error";
            population = "error";
        }
    }

    static void error(int x, int y) {
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language] + " X = " + x + ", " + " Y = " + y + "\n");
        MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
        MainWindow.sleeep(10000);
    }
}
