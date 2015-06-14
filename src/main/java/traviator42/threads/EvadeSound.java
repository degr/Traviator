package traviator42.threads;

import traviator42.gui.common.MainWindow;

import java.awt.*;

/**
 * Created by Ror on 10.06.2015.
 */ //</editor-fold>
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" сирена ">
class EvadeSound implements Runnable {

    Thread ES;

    EvadeSound() {
        ES = new Thread(this, "Sound alert thread");
        ES.start();
    }

    @Override
    public void run() {
        MainWindow.soundAlert = false;
        while (MainWindow.soundAlert == false) {
            if ((MainWindow.clip != null && !MainWindow.clip.isActive()) || (MainWindow.clip == null)) {
                MainWindow.playSound(MainWindow.sound);
            }

            MainWindow.buttonSound.setForeground(Color.red);
            MainWindow.sleeep(500);
            MainWindow.buttonSound.setForeground(Color.black);
            MainWindow.sleeep(500);

        }
    }
}
