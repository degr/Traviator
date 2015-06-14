package traviator42.threads;

import traviator42.gui.common.MainWindow;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.awt.*;
import java.io.File;

/**
 * Created by Ror on 10.06.2015.
 */
class TimerSound implements Runnable {

    Thread ES;

    TimerSound() {
        ES = new Thread(this, "Sound alert thread");
        ES.start();
    }

    @Override
    public void run() {
        MainWindow.timerModel.removeRow(0);
        MainWindow.stopTimerClip = false;
        while (MainWindow.stopTimerClip == false) {
            if ((MainWindow.timerClip != null && !MainWindow.timerClip.isActive()) || (MainWindow.timerClip == null)) {
                playSound(MainWindow.soundTimer);
            }

            MainWindow.buttonSound.setForeground(Color.red);
            MainWindow.sleeep(500);
            MainWindow.buttonSound.setForeground(Color.black);
            MainWindow.sleeep(500);

        }
        TimerTime tt = new TimerTime();
    }

    static void playSound(String path) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            MainWindow.timerClip = AudioSystem.getClip();
            MainWindow.timerClip.open(audioInputStream);
            MainWindow.timerClip.start();
        } catch (Exception ex) {
            MainWindow.consoleText(Color.RED, MainWindow.messages[204][MainWindow.language]);
        }
    }
}
