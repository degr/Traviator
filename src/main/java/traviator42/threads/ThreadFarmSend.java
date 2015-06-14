package traviator42.threads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import traviator42.gui.common.MainWindow;
import traviator42.utils.WD;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="farm send">
class ThreadFarmSend implements Runnable {
static int farm = 0;
    ThreadFarmSend() {
        MainWindow.TFS = new Thread(this, "Refresh thread");
        MainWindow.TFS.start();
    }
void debug(int i){
    MainWindow.debug(i);
}
    @Override
    public void run() {

        MainWindow.consoleText(Color.BLUE, MainWindow.messages[210][MainWindow.language] + "(" + MainWindow.time() + ")" + "\n");
        MainWindow.sleeep(2000);
        DefaultTableModel model = (DefaultTableModel) MainWindow.banditoTable.getModel();
        boolean stop = false;
        WD d = new WD(MainWindow.driver);
        MainWindow.interrupt = false;
        //используя готовые листы
        if (MainWindow.BanditoTables.getSelectedIndex() == 0) {

//<editor-fold defaultstate="collapsed" desc="по фарм листам">
            try {
                boolean pass = MainWindow.villageChange(MainWindow.banditoListTable.getValueAt(0, 0).toString(), "build.php", "&id=39&tt=99&gid=16");
                if (pass == true) {
debug(0);

                    ArrayList<String> raid = new ArrayList<>();
                    ArrayList<String> titles = new ArrayList<String>();
                    int rl = d.d.findElements(By.xpath("//*[@id=\"raidList\"]/div")).size();
debug(1);
                    for(int i = 1; i <= rl; i++){
                        String temp = d.d.findElement(By.xpath("//*[@id=\"raidList\"]/div["+i+"]")).getAttribute("id");
                        if(temp.indexOf("list")>-1){
                            raid.add(temp.substring(temp.indexOf("list")+4).trim());
                            titles.add(d.d.findElement(By.xpath("//*[@id=\"list"+raid.get(i-1)+"\"]/form/div[1]/div[2]")).getText());
                        }
                    }
debug(2);


//<editor-fold defaultstate="collapsed" desc=" Номер нужного нам фарм листа ">
                    int listNum = 0;
                    for (int i = 0; i < titles.size() && stop == false; i++) {
                        if (MainWindow.banditoListModel.getValueAt(0, 1).toString().equals(titles.get(i))) {
                            listNum = i;
                            stop = true;
                        }
                    }
                    stop = false;
                    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" отправка рейдов ">

//    отключаем те что не подходят
                    debug(5);
                    WebElement el = d.xp("//*[@id='list" + raid.get(listNum) + "']/form/div[2]/div[1]/table/tbody");
                    int reports = el.findElements(By.tagName("tr")).size();
                    int filter = Integer.valueOf(MainWindow.banditoListModel.getValueAt(0, 2).toString());
                    ArrayList<Integer> rep = new ArrayList<Integer>();
                    for (int i = 0; i < reports; i++) {
                        String temp;
                        try{
                            temp = d.xp("//*[@id='list" + raid.get(listNum) + "']/form/div[2]/div[1]/table/tbody/tr["+(i+1)+"]/td[6]/img[1]").getAttribute("class");
                            temp = temp.substring(temp.indexOf("iReport iReport")+15).trim();
                        }catch(org.openqa.selenium.NoSuchElementException ex){
                            temp = "0";
                        }
                        rep.add(Integer.valueOf(temp));
                    }
                    for (int i = 1; i <= reports; i++) {
                        if (filter >= rep.get(i - 1)) {
                            try {
                                debug(6);
                                el.findElement(By.xpath("tr[" + i + "]/td[1]/input")).click();
                            } catch (Exception Ex) {
                                if(Ex instanceof org.openqa.selenium.WebDriverException){
                                    try {
                                        debug(7);
                                        el.findElement(By.xpath("tr[" + i + "]/td[2]")).click();
                                    } catch (org.openqa.selenium.WebDriverException EX) {debug(8);
                                        el.findElement(By.xpath("tr[" + i + "]/td[1]")).click();
                                    }
                                }else{
                                    consoleError("error");
                                }
                            }
                        }
                    }
//Жмем кнопку
                    debug(9);
                    d.xp("//*[@id='list" + raid.get(listNum) + "']/form/div[2]/button/div/div[2]").click();

//</editor-fold>

                    MainWindow.consoleText(Color.BLACK, MainWindow.messages[143][MainWindow.language]);
                }

                String clock = MainWindow.setTimer(MainWindow.banditoListModel.getValueAt(0, 4).toString());
                String futureRow[] = new String[]{MainWindow.banditoListTable.getValueAt(0, 0).toString(),
                    MainWindow.banditoListTable.getValueAt(0, 1).toString(),
                    MainWindow.banditoListTable.getValueAt(0, 2).toString(),
                    clock,
                    MainWindow.banditoListTable.getValueAt(0, 4).toString()
                };
farm++;
                MainWindow.banditoListModel.removeRow(0);
                MainWindow.banditoListModel.insertRow(MainWindow.rowNumber(MainWindow.banditoListModel, 3, futureRow[3]),
                        new Object[]{futureRow[0], futureRow[1], futureRow[2], futureRow[3], futureRow[4]});
                MainWindow.interrupt = false;
                MainWindow.waitInterrupt = false;
                MainWindow.reload = 0;
                if (MainWindow.buttonStart.isSelected() == true) {
                    MainWindow.preWaitCheck();
                }
                //<editor-fold defaultstate="collapsed" desc="обработка исключения с перезапуском">
            } catch (Exception Ex) {
                MainWindow.errorExecution(Ex);
            }



            //</editor-fold>



//</editor-fold>

        } else {//используем таблицу

//<editor-fold defaultstate="collapsed" desc="по таблице">
            String vilName = MainWindow.banditoTable.getValueAt(0, 0).toString();

            int rows = MainWindow.banditoTable.getRowCount();

//            try { //обработчик исключений с перезапуском цикла
debug(10);
                boolean passs = MainWindow.villageChange(vilName, "build.php", "&id=39&tt=2&gid=16");
                if (passs == true) {
                    debug(11);
//<editor-fold defaultstate="collapsed" desc="проверка сколько солдат осталось">
                    ArrayList<Integer> troops = new ArrayList<>();

                    for(int tc = 0; tc < MainWindow.troops.size(); tc++){
                        Integer troop[] = MainWindow.troops.get(tc);
                        String count = d.xp("//*[@id=\"troops\"]/tbody/tr[" + troop[2] + "]/td[" + troop[1] + "]").getText();
                        count = count.substring(2);
                        troops.add(Integer.valueOf(count));
                    }
//</editor-fold>
                    boolean s = false;
                    for(int tc = 0; tc < troops.size(); tc++)
                        if(troops.get(tc)>MainWindow.interval[0])
                            s = true;


                    if (s == true) {
                        debug(12);
                        for (int i = 0; i < rows && MainWindow.interrupt == false && stop == false; i++) {
//<editor-fold defaultstate="collapsed" desc="Главный цикл">
                            String r[];
                            //<editor-fold defaultstate="collapsed" desc="будущая строка">
                            if(model == MainWindow.banditoModel){
                                debug(13);
                                r = new String[]{
                                    model.getValueAt(0, 0).toString(), model.getValueAt(0, 1).toString(),
                                    model.getValueAt(0, 2).toString(), model.getValueAt(0, 3).toString(),
                                };
                                model.removeRow(0);
                                model.addRow(r);
                            }else{
                                debug(14);
                                r = new String[]{
                                    model.getValueAt(0, 0).toString(), model.getValueAt(0, 1).toString(),
                                    model.getValueAt(0, 2).toString(), model.getValueAt(0, 3).toString(),
                                    model.getValueAt(0, 4).toString(), model.getValueAt(0, 5).toString(),
                                    model.getValueAt(0, 6).toString()
                                };
                                model.removeRow(0);
                                r[5] = MainWindow.setTimer(r[6]);
                                model.insertRow(MainWindow.rowNumber(model, 5, r[5]), r);
                            }
                            //</editor-fold>

                            try {

                                //<editor-fold defaultstate="collapsed" desc=" фильтр отчетов и животых ">
                                boolean reportCheck = false;
                                String X;
                                String Y;
                                if(model == MainWindow.banditoModel){
                                    debug(15);
                                    X = r[3].substring(0, r[3].toString().indexOf("/")).trim();
                                    Y = r[3].substring(r[3].indexOf("/") + 1).trim();
                                }else{
                                    debug(16);
                                    X = r[4].substring(0, r[4].toString().indexOf("/")).trim();
                                    Y = r[4].substring(r[4].indexOf("/") + 1).trim();
                                }
                                if (MainWindow.reportRed == 1)
                                    reportCheck = true;

                                if (MainWindow.reportYellow == 1 || MainWindow.reportGreen == 1) {
                                    debug(17);
                                    d.d.get(MainWindow.server + "position_details.php?x=" + X + "&y=" + Y);
                                    MainWindow.slow();
                                    String source = d.d.getPageSource();
debug(18);
                                    int num = source.indexOf("iReport iReport");
                                    if (num == -1) {debug(19);
                                        reportCheck = true;
                                    }else{
                                        debug(20);
                                        source = source.substring(num + 15, num + 16);
                                        if (source.equals("1") && MainWindow.reportGreen == 1)
                                            reportCheck = true;

                                        if (source.equals("2") && MainWindow.reportYellow == 1 || source.equals("1") && MainWindow.reportYellow == 1)
                                            reportCheck = true;
                                   }
                                    try {
                                        debug(21);
                                        String animalCount = d.xp("//*[@id='troop_info']/tbody/tr[1]/td[2]").getText().trim();
                                        if (Integer.valueOf(animalCount) > 0) {
                                            reportCheck = false;
                                            String c;
                                            if(model == MainWindow.banditoListModelE)
                                                c = r[4];
                                            else
                                                c = r[3];
                                            MainWindow.consoleText(Color.BLACK, MainWindow.messages[149][MainWindow.language] + c + "\n");
                                        }
                                        //пустые ексцепшоны нужны для оазов без животных
                                    } catch (org.openqa.selenium.NoSuchElementException Ex) {
                                    } catch (org.openqa.selenium.remote.UnreachableBrowserException Ex) {
                                    } catch (org.openqa.selenium.StaleElementReferenceException Ex) {
                                    }

                                }

                                //</editor-fold>
debug(22);
                                if (reportCheck == true) {
                                    vilName = r[0];
                                    MainWindow.villageChange(vilName, "build.php", "&gid=16&tt=2");
                                    MainWindow.slow();
                                    //<editor-fold defaultstate="collapsed" desc=" махинации с пехотой ">
                                    int troopNumber = -1;
                                    int unitsToSend = 0;
                                    int count = 0;
                                    if(model == MainWindow.banditoModel){
                                    debug(24);
                                    int pop = Integer.valueOf(r[2].substring(r[2].indexOf("/") + 1).trim());
                                        for (int t = 0; t < 6; t++) {
                                            if (pop >= MainWindow.popBorder[t][0] && pop < MainWindow.popBorder[t][1]) {
                                                unitsToSend = MainWindow.interval[t];
                                                break;
                                            }
                                        }
                                    }else
                                        unitsToSend = Integer.valueOf(r[2]);

                                    for(int j = 0; j < troops.size(); j++){
                                        if(troops.get(j) >= unitsToSend){
                                            troopNumber = j;
                                            break;
                                        }
                                    }
                                    for(int j = 0; j < troops.size(); j++){
                                        if(troops.get(j)>count)
                                            count = troops.get(j);
                                    }
                                       //</editor-fold>
                                    debug(25);
                                    if (count >= MainWindow.interval[0]){
                                        if(count >= unitsToSend){
                                            debug(26);
                                            int index = 0;
                                            for(int j = 0; j < troops.size(); j++)
                                                if(unitsToSend <= troops.get(j)){
                                                    index = j;
                                                    break;
                                                }
                                            d.name("t" + MainWindow.troops.get(index)[0]).clear();
                                            d.name("t" + MainWindow.troops.get(index)[0]).sendKeys(String.valueOf(unitsToSend));
                                            //рейд
                                            d.xp("//*[@id=\"build\"]/div[2]/form/div[2]/label[3]/input").click();
                                            MainWindow.sendKeysCoord("x", Integer.valueOf(X), "CoordInput");
                                            MainWindow.sendKeysCoord("y", Integer.valueOf(Y), "CoordInput");
                                            d.id("btn_ok").click();
//                                            d.id("btn_ok").click();
                                            d.id("btn_ok").click();

debug(27);
                                            String pass = MainWindow.driver.getCurrentUrl();

                                            if (pass.equals(MainWindow.server + "build.php?id=39&tt=1")) {
                                                troops.set(index, troops.get(index) - unitsToSend);
                                                if(MainWindow.banditoMes == true)
                                                MainWindow.consoleText(Color.BLACK, MainWindow.messages[66][MainWindow.language] + X + "/" + Y
                                                        + MainWindow.messages[67][MainWindow.language] + "\n");
                                            } else {
                                                if(MainWindow.banditoMes == true)
                                                MainWindow.consoleText(Color.GRAY, MainWindow.messages[66][MainWindow.language] + X + "/" + Y
                                                        + MainWindow.messages[116][MainWindow.language]);
                                            }
                                        }else{
                                            if(MainWindow.banditoMes == true)
                                            MainWindow.consoleText(Color.GRAY, MainWindow.messages[341][MainWindow.language]+" ("+X+"/"+Y+")\n");
                                        }
                                    } else {
                                        stop = true;
                                        if(MainWindow.banditoMes == true)
                                        MainWindow.consoleText(Color.GRAY, MainWindow.messages[148][MainWindow.language] +" ("+X+"/"+Y+")\n");
                                    }
                                    if(model == MainWindow.banditoListModelE)
                                        stop = true;
                                }
debug(28);
                                MainWindow.sleeep(1 + MainWindow.rand.nextInt(2));

                            } catch (Exception Ex) {
                                MainWindow.consoleError(Ex);
                            }
//                          выходим из цикла, если это расширенная модель
                            if(model != MainWindow.banditoModel)
                                break;
//</editor-fold>
                        }


                    }

                }
                if(model == MainWindow.banditoModel){
                int totalSec = MainWindow.raidInterval * 60 - MainWindow.delay * 30 + MainWindow.delay * 60;

                if (totalSec < 1) {
                    totalSec = MainWindow.rand.nextInt(10) + 5;
                }
                int hours = totalSec / 3600;
                MainWindow.textFieldHours.setText(noli(hours));
                int minutes = (totalSec - hours * 3600) / 60;
                MainWindow.textFieldMinutes.setText(noli(minutes));
                int sec = totalSec - hours * 3600 - minutes * 60;
                MainWindow.textFieldSec.setText(noli(sec));
                }

                MainWindow.interrupt = false;
                MainWindow.waitInterrupt = false;
                MainWindow.reload = 0;farm++;
MainWindow.debug(29, true);
                if (MainWindow.buttonStart.isSelected() == true) {
                    MainWindow.preWaitCheck();
                }
                //<editor-fold defaultstate="collapsed" desc="обработка исключения с перезапуском">
//            } catch (Exception ex) {
//                MainWindow.errorExecution(ex);
//            }
            //</editor-fold>
//</editor-fold>
        }

    }
    String noli(int count) {
        String value;
        if (count < 10) {
            value = "0" + count;
        } else {
            value = String.valueOf(count);
        }
        return value;
    }

 void consoleError(String code){
    MainWindow.consoleText(Color.RED,
            MainWindow.messages[78][MainWindow.language] + " " +
            MainWindow.messages[11][MainWindow.language] + " (" + code+")\n");
            MainWindow.sleeep(1000);
}

    String validName(String name) {
        return name.replaceAll("&", "&amp;");
    }
}
