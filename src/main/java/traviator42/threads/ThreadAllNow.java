package traviator42.threads;

import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

import javax.swing.*;

/**
 * Created by Ror on 10.06.2015.
 */ //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" all now">
public class ThreadAllNow implements Runnable {

    static int timer = 5;

    public ThreadAllNow() {
        MainWindow.TW = new Thread(this, "allNowThread thread");
        MainWindow.TW.start();
    }

    @Override
    public void run() {
//<editor-fold defaultstate="collapsed" desc=" кнопка все сейчас ">
        MainWindow.interrupt = true;
        if (MainWindow.buttonStart.isSelected() == true) {
            MainWindow.buttonStart.doClick();
            MainWindow.sleeep(2000);
        }
        timer = 5;
        if (MainWindow.BanditoTables.getSelectedIndex() == 0 && MainWindow.banditoListTable.getRowCount() > 0) {
            setTimer(MainWindow.banditoListTable, 3);
        }
        if (MainWindow.BanditoTables.getSelectedIndex() == 1 && MainWindow.banditoListModel.getRowCount() > 0) {
            String hours, minutes, sec;
            hours = String.valueOf(timer / 3600);
            minutes = String.valueOf((timer - Integer.valueOf(hours) * 3600) / 60);
            sec = String.valueOf(timer - Integer.valueOf(hours) * 3600 - Integer.valueOf(minutes) * 60);
            if (hours.length() < 2) {
                hours = "0" + hours;
            }
            if (minutes.length() < 2) {
                minutes = "0" + minutes;
            }
            if (sec.length() < 2) {
                sec = "0" + sec;
            }
            MainWindow.textFieldHours.setText(hours);
            MainWindow.textFieldMinutes.setText(minutes);
            MainWindow.textFieldSec.setText(sec);
            timerIncrease();
        }
        if (MainWindow.sergeantModel.getRowCount() > 0) {
            setTimer(MainWindow.sargeTable, 4);
        }
        if (MainWindow.merchModel.getRowCount() > 0) {
            setTimer(MainWindow.marketTable, 6);

        }
        for (int i = 0; i < MainWindow.vilList.size(); i++) {
            if (MainWindow.vilList.get(i).buildList.size() > 0) {
                String olo = MainWindow.setTimer(timer);
                MainWindow.vilList.get(i).time = olo;
                timerIncrease();
            }
        }
        if (MainWindow.archTable.getRowCount() > 0) {
            MainWindow.textFieldArchTime.setText(MainWindow.vilList.get(MainWindow.comboBoxArcVillages.getSelectedIndex()).time);
        }
        for (int i = 0; i < MainWindow.vilList.size(); i++) {
            if (MainWindow.vilList.get(i).buildListD.size() > 0) {
                String olo = MainWindow.setTimer(timer);
                MainWindow.vilList.get(i).timeDouble = olo;
                timerIncrease();
            }
        }
        if (MainWindow.archTable3.getRowCount() > 0) {
            MainWindow.textFieldArchTime2.setText(MainWindow.vilList.get(MainWindow.comboBoxArcVillagesDouble.getSelectedIndex()).time);
        }
        for (int i = 0; i < MainWindow.vilList.size(); i++) {
            if (MainWindow.vilList.get(i).demolishList.size() > 0) {
                String time = MainWindow.setTimer(timer);
                MainWindow.vilList.get(i).dTime = time;
                if (MainWindow.comboBoxArcVillages.getSelectedIndex() == i) {
                    MainWindow.demolishTimeTF.setText(time);
                }
                timerIncrease();
            }
        }
        if (MainWindow.evadeTable.getRowCount() > 0) {
            setTimer(MainWindow.evadeTable, 0);
        }
        if (MainWindow.celebrateModel.getRowCount() > 0) {
            setTimer(MainWindow.celebrateTable, 2);
        }
        if (MainWindow.blackSmithModel.getRowCount() > 0) {
            setTimer(MainWindow.blackSmtithTable, 3);
        }
        if (MainWindow.checkBoxAdventure.isSelected() == true || MainWindow.checkBoxHard.isSelected() == true) {
            MainWindow.jTextField2.setText(MainWindow.setTimer(timer));
            timerIncrease();
        }
        if (MainWindow.attackPanel.getComponentCount() > 0) {
            Object[] options = {MainWindow.messages[156][MainWindow.language],
                MainWindow.messages[155][MainWindow.language]
            };
            int n = JOptionPane.showOptionDialog(Traviator42.mainWindow,
                    MainWindow.messages[323][MainWindow.language],
                    MainWindow.messages[132][MainWindow.language],
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (n == 1) {

                for (int i = 0; i < MainWindow.attackPanel.getComponentCount(); i++) {
                    JTextField time = ((JTextField) ((JPanel) ((JPanel) MainWindow.attackPanel.getComponent(i)).getComponent(0)).getComponent(8));
                    time.setText(MainWindow.setTimer(timer));
                    timerIncrease();
                }

            }
        }
        timer = 5;
//</editor-fold>
    }

    void setTimer(JTable table, int column) {
        int i = 0;
        while (i < table.getRowCount()) {
            table.setValueAt(MainWindow.setTimer(timer), i, column);
            timerIncrease();
            i++;
        }
    }

    void timerIncrease() {
        timer = MainWindow.rand.nextInt(3) + 2 + timer;
    }
}
