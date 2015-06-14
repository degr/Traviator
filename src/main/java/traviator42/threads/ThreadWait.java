package traviator42.threads;

import traviator42.dto.Village;
import traviator42.gui.common.MainWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Random;

/**
 * Created by Ror on 10.06.2015.
 */ //<editor-fold defaultstate="collapsed" desc="Wait">
public class ThreadWait implements Runnable {
//строка 343
    public static String totalTime, secS, minS, hourS;
    private int hours,
            minutes,
            sec;
//    для архитектора
    static int num = 0;
    static boolean con = false;

    public ThreadWait() {
        MainWindow.TW = new Thread(this, "Wait thread");
        MainWindow.TW.start();
    }

    @Override
    public void run() {
        MainWindow.sleeep(2000);
        num = 0;
        con = false;
        while (MainWindow.waitInterrupt == false) {
            if (MainWindow.waitInterrupt == false)
                banditoListTime();

            if (MainWindow.waitInterrupt == false)
                banditoTableTime();

            if (MainWindow.waitInterrupt == false)
                banditoTable1Time();

            if (MainWindow.waitInterrupt == false)
                standartTime(MainWindow.sargeTable, 4);

            if (MainWindow.waitInterrupt == false)
                standartTime(MainWindow.marketTable, 6);

            if (MainWindow.waitInterrupt == false)
                archTime();

            if (MainWindow.waitInterrupt == false && MainWindow.tribe == 0)
                archTime1();

            if (MainWindow.waitInterrupt == false)
                standartTime(MainWindow.evadeTable, 0);

            if (MainWindow.waitInterrupt == false)
                standartTime(MainWindow.celebrateTable, 2);

            if (MainWindow.waitInterrupt == false)
                demolishTime();

            if (MainWindow.waitInterrupt == false)
                standartTime(MainWindow.blackSmtithTable, 3);

            if (MainWindow.waitInterrupt == false)
                adventureTime();

            if (MainWindow.waitInterrupt == false)
                attackTime();

            MainWindow.sleeep((int) (1000 / MainWindow.accelerate));
        }

    }//конец метода run

    //<editor-fold defaultstate="collapsed" desc="метод таймер">
    String timer(int time) {
        int hours, minutes, sec;
        hours = time / 3600;
        time = time - hours * 3600;
        minutes = time / 60;
        sec = time - minutes * 60;
        String value = MainWindow.oneTwo(hours) + ":" + MainWindow.oneTwo(minutes) + ":" + MainWindow.oneTwo(sec);
        int p = new Random().nextInt(400);
        return value;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ожидание по фарм листу аккаунта">
    void banditoListTime() {
        if (MainWindow.banditoListTable.getRowCount() > 0 && MainWindow.BanditoTables.getSelectedIndex() == 0) {
            if (timeReduce(MainWindow.banditoListTable, 3) <= 0) {
                MainWindow.waitInterrupt = true;
                if (MainWindow.buttonStart.isSelected() == true) {
                    ThreadFarmSend TFS = new ThreadFarmSend();
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ожидание по фарм листу робота">
    void banditoTableTime() {
        if (MainWindow.banditoTable.getRowCount() > 0 && MainWindow.BanditoTables.getSelectedIndex() == 1
                &&((DefaultTableModel) MainWindow.banditoTable.getModel()) == MainWindow.banditoModel) {
            hours = Integer.valueOf(MainWindow.textFieldHours.getText());
            minutes = Integer.valueOf(MainWindow.textFieldMinutes.getText());
            sec = Integer.valueOf(MainWindow.textFieldSec.getText());

            int curtime = hours * 3600 + minutes * 60 + sec;
            //<editor-fold defaultstate="collapsed" desc="цикл таймера">

            sec = sec - 1;
            //если секи равны нулю
            if (sec == -1) {
                //и если минуты равны нулю
                minutes = minutes - 1;
                if (minutes == -1) {
                    hours = hours - 1;
                    //и если часы равны нулю
                    if (hours == -1) {
                        hours = 0;
                        minutes = 0;
                        sec = 0;
                    } // если часы не равны нулю, при секундах и минутах равных нулю, то
                    else {
                        minutes = 59;
                        sec = 59;
                    }
                } //если часы и минуты не равны нулю, а секунды равны нулю
                else {
                    sec = 59;
                }
            }
            //если все не равно нулю, то начинае цикл заново
            if (sec == -1) {
                sec = 0;
            }
            if (minutes == -1) {
                minutes = 0;
            }
            if (hours == -1) {
                hours = 0;
            }

            if (sec < 10) {
                secS = "0" + String.valueOf(sec);
            } else {
                secS = String.valueOf(sec);
            }
            if (minutes < 10) {
                minS = "0" + String.valueOf(minutes);
            } else {
                minS = String.valueOf(minutes);
            }
            if (hours < 10) {
                hourS = "0" + String.valueOf(hours);
            } else {
                hourS = String.valueOf(hours);
            }
            MainWindow.textFieldHours.setText(hourS);
            MainWindow.textFieldMinutes.setText(minS);
            MainWindow.textFieldSec.setText(secS);

            if (hourS.equals("00") && minS.equals("00") && secS.equals("00")) {
                MainWindow.waitInterrupt = true;
                if (MainWindow.buttonStart.isSelected() == true) {
                    ThreadFarmSend tfs = new ThreadFarmSend();
                }
            }
            //</editor-fold>
        }
    }
     void banditoTable1Time() {
        if (MainWindow.banditoTable.getRowCount() > 0 && MainWindow.BanditoTables.getSelectedIndex() == 1
                &&((DefaultTableModel) MainWindow.banditoTable.getModel()) == MainWindow.banditoListModelE) {
            if (timeReduce(MainWindow.banditoTable, 5) <= 0) {
                MainWindow.waitInterrupt = true;
                if (MainWindow.buttonStart.isSelected() == true) {
                    ThreadFarmSend TFS = new ThreadFarmSend();
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ожидание архитектора">
    void archTime() {

        for (int i = 0; i < MainWindow.vilList.size(); i++) {
            Village temp = MainWindow.vilList.get(i);
            if (temp.buildList.size() > 0) {
                int newValue = timeReduce(temp.time);
                if (newValue < 0)
                    newValue = 0;

                temp.time = MainWindow.setTimer(newValue);
                if (MainWindow.comboBoxArcVillages.getSelectedIndex() == i && MainWindow.textFieldArchTime2.hasFocus() == false)
                    MainWindow.textFieldArchTime.setText(temp.time);

                if (newValue <= 0) {
                    MainWindow.waitInterrupt = true;
                    if (MainWindow.buttonStart.isSelected() == true){
                        ThreadConstruct TC = new ThreadConstruct(i, true);
                    }
                }
            }
        }
    }
     void archTime1() {
        for (int i = 0; i < MainWindow.vilList.size(); i++) {
            Village temp = MainWindow.vilList.get(i);

            if (temp.buildListD.size() > 0) {
                int newValue = timeReduce(temp.timeDouble);
                if (newValue < 0)
                    newValue = 0;

                temp.timeDouble = MainWindow.setTimer(newValue);
                if (MainWindow.comboBoxArcVillagesDouble.getSelectedIndex() == i && MainWindow.textFieldArchTime2.hasFocus() == false)
                    MainWindow.textFieldArchTime2.setText(temp.timeDouble);

                if (newValue <= 0) {
                    MainWindow.waitInterrupt = true;
                    if (MainWindow.buttonStart.isSelected() == true) {
                        ThreadConstruct TC = new ThreadConstruct(i, false);
                    }
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ожидание сноса">
    void demolishTime() {
        for (int i = 0; i < MainWindow.vilList.size(); i++) {
            Village temp = MainWindow.vilList.get(i);
            if (temp.demolishList.size() > 0) {
                int newValue = timeReduce(temp.dTime);
                if (newValue < 0) {
                    newValue = 0;
                }

                temp.dTime = MainWindow.setTimer(newValue);

                if (MainWindow.comboBoxArcVillages.getSelectedIndex() == i) {
                    MainWindow.demolishTimeTF.setText(temp.dTime);
                }
                if (newValue <= 0) {
                    MainWindow.waitInterrupt = true;
                    if (MainWindow.buttonStart.isSelected() == true) {
                        ThreadDemolish TC = new ThreadDemolish(i);
                    }
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ожижание приключений">
    void adventureTime() {
        if (MainWindow.checkBoxAdventure.isSelected() == true || MainWindow.checkBoxHard.isSelected() == true) {
            int time = MainWindow.input(MainWindow.jTextField2.getText()) - 1;
            MainWindow.jTextField2.setText(String.valueOf(MainWindow.setTimer(time)));
            if (time < 1) {
                time = 0;
                MainWindow.waitInterrupt = true;
                ThreadAdventure ta = new ThreadAdventure(MainWindow.driver);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ожидание атаки">
    void attackTime() {
        if (MainWindow.attackPanel.getComponentCount() > 0) {
            int count = MainWindow.attackPanel.getComponentCount();
            int cur = 0;
            String time = "";
            boolean stop = false;
            for (int i = 0; i < count && stop == false; i++) {
                JPanel temp = ((JPanel) ((JPanel) MainWindow.attackPanel.getComponent(i)).getComponent(0));

                double val = Double.valueOf(((JLabel) temp.getComponent(0)).getText());
                JTextField tField = ((JTextField) temp.getComponent(8));

                if (cur != (int) val) {
                    cur = (int) val;
                    time = tField.getText();
                    time = MainWindow.setTimer(timeReduce(time));
                    tField.setText(time);
                } else {
                    tField.setText(time);
                }
                if (MainWindow.input(time) < 1) {
                    stop = true;
                    MainWindow.waitInterrupt = true;
                    ThreadAttack ta = new ThreadAttack(i);
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="стандартное ожидание">
    void standartTime(JTable table, int col) {
        if (table.getRowCount() > 0) {
            if (timeReduce(table, col) <= 0) {
                MainWindow.waitInterrupt = true;
                if (MainWindow.buttonStart.isSelected() == true) {
                    if (table == MainWindow.sargeTable) {
                        ThreadTrain Trr = new ThreadTrain();
                    }
                    if (table == MainWindow.marketTable) {
                        ThreadMerchant TM = new ThreadMerchant();
                    }
                    if (table == MainWindow.evadeTable) {
                        ThreadEvade TE = new ThreadEvade();
                    }
                    if (table == MainWindow.celebrateTable) {
                        ThreadCeleb TCe = new ThreadCeleb();
                    }
                    if (table == MainWindow.blackSmtithTable) {
                        ThreadBlackSmith TBS = new ThreadBlackSmith();
                    }
                }
            }
        }
    }
    //</editor-fold>

    int timeReduce(JTable table, int timerColumn) {
        for (int i = 0; i < table.getRowCount() && MainWindow.waitInterrupt == false; i++) {
            int time = MainWindow.input(table.getValueAt(i, timerColumn).toString());
            time = time - 1;
            if (time <= 0) {
                MainWindow.interrupt = true;
                time = 0;
            }
            table.setValueAt(timer(time), i, timerColumn);
        }
        int value = MainWindow.input(table.getValueAt(0, timerColumn).toString());
        return value;
    }

    int timeReduce(String string) {
        int i = MainWindow.input(string) - 1;
        return i;
    }
}
