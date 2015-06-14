package traviator42.threads;

import traviator42.gui.common.MainWindow;

import java.util.Date;
import java.util.Random;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="поток с разговором с ботом">
class ThreadQuick implements Runnable {

    public static Thread TQ;

    ThreadQuick() {
        TQ = new Thread(this, "Refresh thread");
        TQ.start();
    }

    @Override
    public void run() {
        Random rand = new Random(new Date().getTime());
        MainCopyStatus.textAreaCopyConsole.append(MainWindow.messages[57 + rand.nextInt(5)][MainWindow.language]);
        MainCopyStatus.textAreaCopyConsole.setCaretPosition(MainCopyStatus.textAreaCopyConsole.getText().length());
    }
}
