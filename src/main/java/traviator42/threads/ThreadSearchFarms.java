package traviator42.threads;

import traviator42.gui.common.MainWindow;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="поиск ферм">
class ThreadSearchFarms implements Runnable {

    public static Thread TSF;
    String pagesMax;
    int pagesMin;

    ThreadSearchFarms(int pagesMin, String pagesMax) {
        this.pagesMax = pagesMax;
        this.pagesMin = pagesMin;
        TSF = new Thread(this, "Farm searching thread");
        TSF.start();
    }

    @Override
    public void run() {

        try {
            while (MainWindow.scoutModel.getRowCount() > 0) {
                MainWindow.scoutModel.removeRow(0);
            }
            int pageNumberMin = pagesMin,
                    pageNumberMax = Integer.valueOf(pagesMax),
                    playersCount = 0;
            //<editor-fold defaultstate="collapsed" desc="оформление и объявление">
            String targetVillage;
            MainCopyStatus.progressBar.setStringPainted(true);
            MainCopyStatus.progressBar.setMinimum(0);
            MainCopyStatus.progressBar.setMaximum(pageNumberMax - pageNumberMin + 1);
            MainCopyStatus.progressBar.setValue(0);

            MainCopyStatus.progressBarSmall.setStringPainted(true);
            MainCopyStatus.progressBarSmall.setMinimum(0);
            MainCopyStatus.progressBarSmall.setMaximum(9);

            MainCopyStatus.progressBarSmall.setValue(0);
            //</editor-fold>

            int farmListCount = 0;

            for (int i = pageNumberMax; i >= pageNumberMin && MainCopyStatus.stop == false; i--) {
                while (MainCopyStatus.buttonToggle.isSelected() == false)
                    MainWindow.sleeep(1);
                MainWindow.driver.navigate().to(MainWindow.server +
                        "statistiken.php?id=0&idSub=0&page=" + i);

                String source = MainWindow.driver.getPageSource();
//     оставляем таблицу
                source = cut(source, "id=\"player\"", 0);
                source = cut(source, "<tbody>", 0);
                source = eCut(source, "</tbody>", 0);

                int rowMaxCount = (source + "\0").split("<tr class=").length - 1;

//<editor-fold defaultstate="collapsed" desc=" данные строки ">
                for (int j = 0; j <= rowMaxCount - 1 && MainCopyStatus.stop == false; j++) {
                    ArrayList<String> temp = new ArrayList<String>();
                    playersCount++;
                    String row = dCut(source, "<td class=\"pla", "<td class=\"vil", 0, 0);
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                    source = cut(source, "<td class=\"vil", 0);
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                    source = source.substring(15);
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                    row = cut(row, "<a href=", 0);
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                    temp.add(dCut(row, "\">", "</a>", 2, 0).trim());
                    row = cut(row, "</td>", 5);
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                    if (row.indexOf("<a href=") > 0) {
                        row = cut(row, "<a href=", 0);
                        temp.add(dCut(row, "\">", "</a>", 2, 0).trim());
                    } else {
                        row = cut(row, "<td class=\"al", 0);
                        temp.add(dCut(row, "\">", "</td>", 2, 0).trim());
                    }
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                    row = cut(row, "<td class=\"pop", 0);
                    row = cut(row, "\">", 2);
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                    temp.add(eCut(row, "</td>", 0).trim());
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                    MainWindow.scoutModel.addRow(new Object[]{temp.get(0), temp.get(1), temp.get(2)});
                    MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
                }
//</editor-fold>
                MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue() + 1);
                try {
                    Thread.sleep((MainWindow.rand.nextInt(3) + 1) * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadSearchFarms.class.getName()).log(Level.SEVERE, null, ex);
                }
                MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[120][MainWindow.language] + i + "\n");
                MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
                MainWindow.slow();
            }

            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[42][MainWindow.language] + playersCount + MainWindow.messages[43][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[113][MainWindow.language]);
            MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
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

    String cut(String source, String val, int i) {
        String value = source.substring(source.indexOf(val) + i);
        return value;
    }

    String eCut(String source, String val, int i) {
        String value = source.substring(0, source.indexOf(val) + i);
        return value;
    }

    String dCut(String source, String sval, String eval, int i, int j) {
        String value = source.substring(source.indexOf(sval) + i, source.indexOf(eval) + j);
        return value;
    }
}
