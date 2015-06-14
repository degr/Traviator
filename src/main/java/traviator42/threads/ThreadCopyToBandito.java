package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;

import java.util.ArrayList;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="copyToBandito from scout">
class ThreadCopyToBandito implements Runnable {

    public static Thread TCTB;

    ThreadCopyToBandito() {
        TCTB = new Thread(this, "Refresh thread");
        TCTB.start();
    }

    @Override
    public void run() {
        try {
//<editor-fold defaultstate="collapsed" desc="оформление и объявление">
            String targetVillage;

            int rows = MainWindow.scoutTable.getRowCount();
            MainCopyStatus.progressBar.setStringPainted(true);
            MainCopyStatus.progressBar.setMinimum(0);
            MainCopyStatus.progressBar.setMaximum(rows);
            MainCopyStatus.progressBar.setValue(0);

            MainCopyStatus.progressBarSmall.setStringPainted(true);
            MainCopyStatus.progressBarSmall.setMinimum(0);

            MainCopyStatus.progressBarSmall.setValue(0);

            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[47][MainWindow.language] +
                    rows + MainWindow.messages[48][MainWindow.language]);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="главный цикл занесения инфы в таблицу бандита">
            targetVillage = MainWindow.vilList.get(0).name;
            for (int playersInTable = 0; playersInTable < MainWindow.scoutTable.getRowCount() && MainCopyStatus.stop == false; playersInTable++) {

//      playerInfo <ar<villyname, population, x, y>>
                ArrayList<ArrayList<String>> pInfo = gatherInfo(playersInTable);
                MainCopyStatus.progressBarSmall.setMaximum(pInfo.size());
//      цикл для занесения всех деревень игрока в таблицу
                for (int i = 0; i < pInfo.size() && MainCopyStatus.stop == false; i++) {
                    while (MainCopyStatus.buttonToggle.isSelected() == false)
                        MainWindow.sleeep(1);
                    //<editor-fold defaultstate="collapsed" desc="заносим данные в таблицу бандита">
                    String fR[] = new String[7];
                    //        первая колонка - из
                    fR[0] = targetVillage;
                    //        вторая колонка - цель
                    fR[1] = MainWindow.scoutTable.getValueAt(playersInTable, 0).toString() + " / " +
                            pInfo.get(i).get(0) + " / " + MainWindow.scoutTable.getValueAt(playersInTable, 1).toString();
                    //       расстояние и нас
                    fR[2] = "0 / " + pInfo.get(i).get(1);
                    //                 седьмая колонка - координаты
                    fR[3] = pInfo.get(i).get(2) + "/" + pInfo.get(i).get(3);

                    MainWindow.banditoModel.addRow(new Object[]{
                            fR[0], fR[1], fR[2], fR[3],
                    });

                    int pop = Integer.valueOf(pInfo.get(i).get(1));
                    String units = "";
                    for (int t = 0; t < 6; t++) {
                        if (pop >= MainWindow.popBorder[t][0] && pop < MainWindow.popBorder[t][1]) {
                            units = String.valueOf(MainWindow.interval[t]);
                            break;
                        }
                    }
                    String timer = MainWindow.setTimer(String.valueOf(MainWindow.raidInterval));
                    MainWindow.banditoListModelE.insertRow(MainWindow.rowNumber(MainWindow.banditoListModelE, 5, timer),
                            new Object[]{
                                    fR[0], fR[1], units, fR[2], fR[3], timer, String.valueOf(MainWindow.raidInterval)
                            });

                    //</editor-fold>

                    //<editor-fold defaultstate="collapsed" desc="завершение переноса">
                    playersInTable++;
                    MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue() + 1);
                    int left = rows - playersInTable;
                    MainCopyStatus.textAreaCopyConsole.append(playersInTable + MainWindow.messages[54][MainWindow.language] + left +
                            MainWindow.messages[55][MainWindow.language] + "\n");
                    MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
                    playersInTable--;
                    MainWindow.slow();
                    //</editor-fold>

                }
            }

            //</editor-fold>

            MainCopyStatus.progressBar.setValue(Integer.MAX_VALUE);
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[56][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());


            MainCopyStatus.buttonOk.setEnabled(true);
            MainCopyStatus.buttonCancel.setEnabled(false);
        } catch (org.openqa.selenium.NoSuchElementException Ex) {
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
        } catch (org.openqa.selenium.remote.UnreachableBrowserException Ex) {
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
        } catch (org.openqa.selenium.StaleElementReferenceException Ex) {
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
        }
        MainCopyStatus.buttonOk.setEnabled(true);
        MainCopyStatus.stop = false;
    }

    ArrayList<ArrayList<String>> gatherInfo(int row) {
        ArrayList<ArrayList<String>> value = new ArrayList<>();
        MainCopyStatus.progressBarSmall.setValue(0);
        int innerList = 0;
        //<editor-fold defaultstate="collapsed" desc="ищем чела в статистике">
        try {

            MainWindow.driver.navigate().to(MainWindow.server + "statistiken.php");

            MainWindow.driver.findElement(By.xpath("//input[@ class = 'text name']")).sendKeys(MainWindow.scoutTable.getValueAt(row, 0).toString());
            MainWindow.driver.findElement(By.xpath("//*[@id=\"search_navi\"]/form/div/div[10]/table/tbody/tr/td[3]/button")).click();
            MainWindow.driver.findElement(By.linkText(MainWindow.scoutTable.getValueAt(row, 0).toString())).click();
            innerList = MainWindow.driver.findElements(By.xpath("//table[@id = 'villages']/tbody/tr")).size();

            MainCopyStatus.progressBarSmall.setMaximum(innerList);

        } catch (org.openqa.selenium.NoSuchElementException Ex) {
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
        } catch (org.openqa.selenium.remote.UnreachableBrowserException Ex) {
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
        } catch (org.openqa.selenium.StaleElementReferenceException Ex) {
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainWindow.Console.getText().length());
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="цикл с доставанием инфы об игроке">
        for (int k = 1; k < innerList + 1 && MainCopyStatus.stop == false; k++) {
            //         data = villyName, population, x, y;
            ArrayList<String> data = new ArrayList<>();
            try {
                String popul = MainWindow.driver.findElement(By.xpath("//table[@id = 'villages']/tbody/tr[" + k + "]/td[3]")).getText();
                String x = MainWindow.driver.findElement(By.xpath("//table[@id = 'villages']/tbody/tr[" + k + "]/td[4]/a/span/span/span[1]")).getText();
                String y = MainWindow.driver.findElement(By.xpath("//table[@id = 'villages']/tbody/tr[" + k + "]/td[4]/a/span/span/span[3]")).getText();
                String villna = "";

                MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                villna = MainWindow.driver.findElement(By.xpath("//table[@id = 'villages']/tbody/tr[" + k + "]/td[1]")).getText();
                data.add(villna);

                x = x.substring(1);
                y = y.substring(0, y.length() - 1);
                data.add(popul);
                data.add(x);
                data.add(y);
                value.add(data);
            } catch (org.openqa.selenium.NoSuchElementException Ex) {
                MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
                MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
            } catch (org.openqa.selenium.remote.UnreachableBrowserException Ex) {
                MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
                MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
            } catch (org.openqa.selenium.StaleElementReferenceException Ex) {
                MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[11][MainWindow.language]);
                MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
            }
        }
        //</editor-fold>
        return value;
    }

}
