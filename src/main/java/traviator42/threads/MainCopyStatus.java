package traviator42.threads;

import traviator42.gui.common.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;



public class MainCopyStatus extends javax.swing.JDialog {
    static boolean stop = false;


    public MainCopyStatus(java.awt.Frame parent, boolean modal, int thread, int village, String flName, boolean newList, ArrayList<String> data) {
        super(parent, MainWindow.messages[78][MainWindow.language], modal);
        initComponents();
        internationalization();
        //делаем чтобы приложение появилось в центре экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2));
        stop = false;
        buttonToggle.doClick();
        ThreadCopyList threadCopyList;
        switch (thread) {
            case 0://копирование из бандита в игру
                threadCopyList = new ThreadCopyList(newList, 0, flName, Integer.parseInt(data.get(0)), "", village);
                break;

            case 1://поиск ферм для бандита
                ThreadSearch threadSearch = new ThreadSearch(flName);
                break;

            case 2://копирование в бандита из скаута
                ThreadCopyToBandito tctb = new ThreadCopyToBandito();
                break;

            case 3://копирование в игру из скаута
                threadCopyList = new ThreadCopyList(newList, 1, flName, Integer.parseInt(data.get(0)), "", village);
                break;

            case 4:
                ThreadSearchFarms tsf = new ThreadSearchFarms(village, flName);
                break;

            case 5:
                ThreadTradeRoutes ttr = new ThreadTradeRoutes(data);
                break;

            case 6:
                threadCopyList = new ThreadCopyList(newList, 2, flName, Integer.parseInt(data.get(0)), data.get(1), village);
                break;

            case 7:
                ThreadCopyToBanditoAnalizator tcba = new ThreadCopyToBanditoAnalizator(flName, village);
                break;

            case 8:
                boolean gSword = bool(data.get(0));
                boolean ySword = bool(data.get(1));
                boolean rSword = bool(data.get(2));
                boolean gScout = bool(data.get(3));
                boolean yScout = bool(data.get(4));
                boolean rScout = bool(data.get(5));
                boolean trade = bool(data.get(6));
                boolean adventure = bool(data.get(7));
                ThreadReportsDelete trd = new ThreadReportsDelete(gSword, ySword, rSword, gScout, yScout, rScout, trade, adventure);
                break;
        }
        //<editor-fold defaultstate="collapsed" desc=" предупреждение при выходе ">
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {

            }

            public void windowClosed(WindowEvent event) {

            }

            public void windowClosing(WindowEvent event) {
                if (buttonToggle.isSelected() == false)
                    buttonToggle.doClick();
                dispose();
                stop = true;
            }

            public void windowDeactivated(WindowEvent event) {

            }

            public void windowDeiconified(WindowEvent event) {

            }

            public void windowIconified(WindowEvent event) {

            }

            public void windowOpened(WindowEvent event) {

            }

        });
//</editor-fold> 

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaCopyConsole = new javax.swing.JTextArea();
        buttonCancel = new javax.swing.JButton(MainWindow.natiPic[4][14]);
        buttonQuick = new javax.swing.JButton();
        buttonOk = new javax.swing.JButton(MainWindow.natiPic[4][25]);
        progressBarSmall = new javax.swing.JProgressBar();
        buttonToggle = new javax.swing.JToggleButton(MainWindow.natiPic[4][34]);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textAreaCopyConsole.setColumns(20);
        textAreaCopyConsole.setLineWrap(true);
        textAreaCopyConsole.setRows(5);
        textAreaCopyConsole.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textAreaCopyConsole);

        buttonCancel.setText("Отмена");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonQuick.setText("Давай быстрее");
        buttonQuick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQuickActionPerformed(evt);
            }
        });

        buttonOk.setText("Ок");
        buttonOk.setEnabled(false);
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        buttonToggle.setText("jToggleButton1");
        buttonToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonToggleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(buttonCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                                                .addComponent(buttonOk))
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(progressBarSmall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(buttonQuick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(buttonToggle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonQuick)
                                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(progressBarSmall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonToggle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonCancel)
                                        .addComponent(buttonOk))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonQuickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQuickActionPerformed
        ThreadQuick tqqq = new ThreadQuick();
    }//GEN-LAST:event_buttonQuickActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        stop = true;
        setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonOkActionPerformed

    private void buttonToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonToggleActionPerformed
        if (buttonToggle.isSelected() == true) {
            buttonToggle.setIcon(MainWindow.natiPic[4][35]);
            buttonToggle.setText(MainWindow.messages[356][MainWindow.language]);
            textAreaCopyConsole.append(MainWindow.messages[357][MainWindow.language] + "\n");
        } else {
            buttonToggle.setIcon(MainWindow.natiPic[4][34]);
            buttonToggle.setText(MainWindow.messages[357][MainWindow.language]);
            textAreaCopyConsole.append(MainWindow.messages[356][MainWindow.language] + "\n");
        }
    }//GEN-LAST:event_buttonToggleActionPerformed

    public static void internationalization() {
        buttonQuick.setText(MainWindow.messages[79][MainWindow.language]);
        buttonCancel.setText(MainWindow.messages[71][MainWindow.language]);
        buttonOk.setText(MainWindow.messages[72][MainWindow.language]);
    }

    private boolean bool(String str) {
        boolean bool;
        if ("1".equals(str))
            bool = true;
        else
            bool = false;
        return bool;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton buttonCancel;
    public static javax.swing.JButton buttonOk;
    public static javax.swing.JButton buttonQuick;
    static javax.swing.JToggleButton buttonToggle;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JProgressBar progressBar;
    public static javax.swing.JProgressBar progressBarSmall;
    public static javax.swing.JTextArea textAreaCopyConsole;
    // End of variables declaration//GEN-END:variables
}
