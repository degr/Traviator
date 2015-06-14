package traviator42.threads;

import traviator42.gui.common.MainWindow;

import javax.swing.*;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc=" 2 потока таймера ">
public class TimerTime implements Runnable {

    Thread TT;

    public TimerTime() {
        TT = new Thread(this, "Timer thread");
        TT.start();
    }
    boolean stop = false;

    @Override
    public void run() {
        MainWindow.stopTimer = false;
        if (MainWindow.timerModel.getRowCount() > 0) {
            while (stop == false && MainWindow.stopTimer == false) {
                if (MainWindow.waitInterrupt == false) {
                    Time();
                }
                MainWindow.sleeep(1000);
            }
        }
    }

    void Time() {
        if (MainWindow.timerTable.getRowCount() > 0) {
            if (timeReduce(MainWindow.timerTable, 1) <= 0) {
                stop = true;
                TimerSound TS = new TimerSound();
            }
        }
    }

    int timeReduce(JTable table, int timerColumn) {
        for (int i = 0; i < table.getRowCount() && MainWindow.waitInterrupt == false; i++) {
            int time = MainWindow.input(table.getValueAt(i, timerColumn).toString());
            time = time - 1;
            if (time <= 0) {
                MainWindow.interrupt = true;
            }
            table.setValueAt(timer(time), i, timerColumn);
        }
        int value = MainWindow.input(table.getValueAt(0, timerColumn).toString());
        return value;
    }

    String timer(int time) {
        int hours, minutes, sec;
        hours = time / 3600;
        time = time - hours * 3600;
        minutes = time / 60;
        sec = time - minutes * 60;
        String value = MainWindow.oneTwo(hours) + ":" + MainWindow.oneTwo(minutes) + ":" + MainWindow.oneTwo(sec);
        return value;
    }
}
