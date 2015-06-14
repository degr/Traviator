package traviator42.threads;

import org.openqa.selenium.By;
import traviator42.gui.common.MainWindow;
import traviator42.utils.WD;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="удаление отчетов">
class ThreadReportsDelete implements Runnable {
    Thread tr;
    boolean gSword;
    boolean ySword;
    boolean rSword;
    boolean gScout;
    boolean yScout;
    boolean rScout;
    boolean trade;
    boolean adventure;
    String server;

    ThreadReportsDelete(boolean gSword, boolean ySword, boolean rSword,
                        boolean gScout, boolean yScout, boolean rScout,
                        boolean trade, boolean adventure) {
        this.gSword = gSword;
        this.ySword = ySword;
        this.rSword = rSword;
        this.gScout = gScout;
        this.yScout = yScout;
        this.rScout = rScout;
        this.trade = trade;
        this.adventure = adventure;
        server = MainWindow.server;
        tr = new Thread(this, "ThreadReportDel");
        tr.start();
    }

    @Override
    public void run() {
        WD d = new WD(MainWindow.driver);
        d.get(server + "berichte.php");
        d.cName("last").click();
        int pages = pageCount(d);
        MainCopyStatus.progressBar.setMaximum(pages);
        MainCopyStatus.progressBar.setValue(0);
        for (int i = pages; i > 0 && MainCopyStatus.stop == false; i--) {
            String curl = d.d.getCurrentUrl();
            if (i != pages && !curl.equals(server + "berichte.php?&o=0&page=" + i))
                d.get(server + "berichte.php?&o=0&page=" + i);
            int count = reportsCount(d);
            MainCopyStatus.progressBarSmall.setMaximum(count);
            MainCopyStatus.progressBarSmall.setValue(0);

            for (int j = 0; j < count && MainCopyStatus.stop == false; j++) {
                while (MainCopyStatus.buttonToggle.isSelected() == false)
                    MainWindow.sleeep(1000);
                String report = d.xp("//*[@id=\"overview\"]/tbody/tr[" + (j + 1) + "]/td[2]/img[2]").getAttribute("class");
                switch (report) {
                    case "iReport iReport1":
                        check(gSword, d, j);
                        break;
                    case "iReport iReport2":
                        check(ySword, d, j);
                        break;
                    case "iReport iReport3":
                        check(rSword, d, j);
                        break;

                    case "iReport iReport11":
                        check(trade, d, j);
                        break;
                    case "iReport iReport12":
                        check(trade, d, j);
                        break;
                    case "iReport iReport13":
                        check(trade, d, j);
                        break;
                    case "iReport iReport14":
                        check(trade, d, j);
                        break;

                    case "iReport iReport15":
                        check(gScout, d, j);
                        break;
                    case "iReport iReport16":
                        check(yScout, d, j);
                        break;
                    case "iReport iReport17":
                        check(rScout, d, j);
                        break;
                    case "iReport iReport21":
                        check(adventure, d, j);
                        break;
                }
                MainCopyStatus.progressBarSmall.setValue(MainCopyStatus.progressBarSmall.getValue() + 1);
            }
            d.xp("//*[@id=\"del\"]/div/div[2]").click();
            MainWindow.slow();
            MainCopyStatus.progressBar.setValue(MainCopyStatus.progressBar.getValue() + 1);
        }
    }

    int pageCount(WD d) {
        String pc = d.d.getCurrentUrl();
        pc = pc.substring(pc.lastIndexOf("=") + 1);
        return Integer.valueOf(pc);
    }

    int reportsCount(WD d) {
        return d.d.findElements(By.xpath("//*[@id=\"overview\"]/tbody/tr")).size();
    }

    void check(boolean reportType, WD d, int j) {
        if (reportType == true)
            d.xp("//*[@id=\"overview\"]/tbody/tr[" + (j + 1) + "]/td[1]/input").click();
    }
}
