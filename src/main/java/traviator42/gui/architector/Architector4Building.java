/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traviator42.gui.architector;

import traviator42.gui.common.MainWindow;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JLabel;

/**
 *
 * @author Ror
 */
public class Architector4Building extends javax.swing.JDialog {
String id = "";
JLabel lab;
    public Architector4Building(java.awt.Frame parent, boolean modal, String id, JLabel lab) {
        super(parent, modal);
        this.id = id.substring(0, id.indexOf(" ")) + " ";
        this.lab = lab;
        initComponents();
        jButton2.setText(MainWindow.messages[106][MainWindow.language]);
        picGen();
        
 //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
 //делаем чтобы приложение появилось в центре экрана
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 Dimension frameSize = getSize();
 setLocation(new Point((screenSize.width - frameSize.width) / 2,
 (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
 //</editor-fold>
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        infro = new javax.swing.JPanel();
        lab1 = new javax.swing.JLabel();
        lab2 = new javax.swing.JLabel();
        lab3 = new javax.swing.JLabel();
        lab4 = new javax.swing.JLabel();
        lab5 = new javax.swing.JLabel();
        lab6 = new javax.swing.JLabel();
        lab7 = new javax.swing.JLabel();
        lab8 = new javax.swing.JLabel();
        lab9 = new javax.swing.JLabel();
        lab10 = new javax.swing.JLabel();
        lab11 = new javax.swing.JLabel();
        lab12 = new javax.swing.JLabel();
        lab13 = new javax.swing.JLabel();
        mili = new javax.swing.JPanel();
        lab14 = new javax.swing.JLabel();
        lab15 = new javax.swing.JLabel();
        lab16 = new javax.swing.JLabel();
        lab17 = new javax.swing.JLabel();
        lab18 = new javax.swing.JLabel();
        lab19 = new javax.swing.JLabel();
        lab20 = new javax.swing.JLabel();
        lab21 = new javax.swing.JLabel();
        lab22 = new javax.swing.JLabel();
        lab23 = new javax.swing.JLabel();
        lab24 = new javax.swing.JLabel();
        lab25 = new javax.swing.JLabel();
        lab26 = new javax.swing.JLabel();
        reso = new javax.swing.JPanel();
        lab27 = new javax.swing.JLabel();
        lab28 = new javax.swing.JLabel();
        lab29 = new javax.swing.JLabel();
        lab30 = new javax.swing.JLabel();
        lab31 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton(MainWindow.natiPic[4][24]);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(600, 450));

        infro.setPreferredSize(new java.awt.Dimension(500, 350));

        lab1.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab1MouseClicked(evt);
            }
        });
        infro.add(lab1);

        lab2.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab2MouseClicked(evt);
            }
        });
        infro.add(lab2);

        lab3.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab3MouseClicked(evt);
            }
        });
        infro.add(lab3);

        lab4.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab4MouseClicked(evt);
            }
        });
        infro.add(lab4);

        lab5.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab5MouseClicked(evt);
            }
        });
        infro.add(lab5);

        lab6.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab6MouseClicked(evt);
            }
        });
        infro.add(lab6);

        lab7.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab7MouseClicked(evt);
            }
        });
        infro.add(lab7);

        lab8.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab8MouseClicked(evt);
            }
        });
        infro.add(lab8);

        lab9.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab9MouseClicked(evt);
            }
        });
        infro.add(lab9);

        lab10.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab10MouseClicked(evt);
            }
        });
        infro.add(lab10);

        lab11.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab11MouseClicked(evt);
            }
        });
        infro.add(lab11);

        lab12.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab12MouseClicked(evt);
            }
        });
        infro.add(lab12);

        lab13.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab13MouseClicked(evt);
            }
        });
        infro.add(lab13);

        jTabbedPane1.addTab("инфроструктура", infro);

        lab14.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab14MouseClicked(evt);
            }
        });
        mili.add(lab14);

        lab15.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab15MouseClicked(evt);
            }
        });
        mili.add(lab15);

        lab16.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab16MouseClicked(evt);
            }
        });
        mili.add(lab16);

        lab17.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab17MouseClicked(evt);
            }
        });
        mili.add(lab17);

        lab18.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab18MouseClicked(evt);
            }
        });
        mili.add(lab18);

        lab19.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab19MouseClicked(evt);
            }
        });
        mili.add(lab19);

        lab20.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab20MouseClicked(evt);
            }
        });
        mili.add(lab20);

        lab21.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab21MouseClicked(evt);
            }
        });
        mili.add(lab21);

        lab22.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab22MouseClicked(evt);
            }
        });
        mili.add(lab22);

        lab23.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab23MouseClicked(evt);
            }
        });
        mili.add(lab23);

        lab24.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab24MouseClicked(evt);
            }
        });
        mili.add(lab24);

        lab25.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab25MouseClicked(evt);
            }
        });
        mili.add(lab25);

        lab26.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab26MouseClicked(evt);
            }
        });
        mili.add(lab26);

        jTabbedPane1.addTab("веонные", mili);

        lab27.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab27MouseClicked(evt);
            }
        });
        reso.add(lab27);

        lab28.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab28MouseClicked(evt);
            }
        });
        reso.add(lab28);

        lab29.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab29MouseClicked(evt);
            }
        });
        reso.add(lab29);

        lab30.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab30MouseClicked(evt);
            }
        });
        reso.add(lab30);

        lab31.setText("jLabel1");
        lab1.setPreferredSize(new Dimension(100, 100));
        lab2.setPreferredSize(new Dimension(100, 100));
        lab3.setPreferredSize(new Dimension(100, 100));
        lab4.setPreferredSize(new Dimension(100, 100));
        lab5.setPreferredSize(new Dimension(100, 100));
        lab6.setPreferredSize(new Dimension(100, 100));
        lab7.setPreferredSize(new Dimension(100, 100));
        lab8.setPreferredSize(new Dimension(100, 100));
        lab9.setPreferredSize(new Dimension(100, 100));
        lab10.setPreferredSize(new Dimension(100, 100));
        lab11.setPreferredSize(new Dimension(100, 100));
        lab12.setPreferredSize(new Dimension(100, 100));
        lab13.setPreferredSize(new Dimension(100, 100));
        lab14.setPreferredSize(new Dimension(100, 100));
        lab15.setPreferredSize(new Dimension(100, 100));
        lab16.setPreferredSize(new Dimension(100, 100));
        lab17.setPreferredSize(new Dimension(100, 100));
        lab18.setPreferredSize(new Dimension(100, 100));
        lab19.setPreferredSize(new Dimension(100, 100));
        lab20.setPreferredSize(new Dimension(100, 100));
        lab21.setPreferredSize(new Dimension(100, 100));
        lab22.setPreferredSize(new Dimension(100, 100));
        lab23.setPreferredSize(new Dimension(100, 100));
        lab24.setPreferredSize(new Dimension(100, 100));
        lab25.setPreferredSize(new Dimension(100, 100));
        lab26.setPreferredSize(new Dimension(100, 100));
        lab27.setPreferredSize(new Dimension(100, 100));
        lab28.setPreferredSize(new Dimension(100, 100));
        lab29.setPreferredSize(new Dimension(100, 100));
        lab30.setPreferredSize(new Dimension(100, 100));
        lab31.setPreferredSize(new Dimension(100, 100));
        lab31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab31MouseClicked(evt);
            }
        });
        reso.add(lab31);

        jTabbedPane1.addTab("ресурсы", reso);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab1MouseClicked
     add(lab1);
    }//GEN-LAST:event_lab1MouseClicked

    private void lab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab2MouseClicked
     add(lab2);   // TODO add your handling code here:
    }//GEN-LAST:event_lab2MouseClicked

    private void lab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab3MouseClicked
     add(lab3);   // TODO add your handling code here:
    }//GEN-LAST:event_lab3MouseClicked

    private void lab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab4MouseClicked
     add(lab4);   // TODO add your handling code here:
    }//GEN-LAST:event_lab4MouseClicked

    private void lab5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab5MouseClicked
    add(lab5);    // TODO add your handling code here:
    }//GEN-LAST:event_lab5MouseClicked

    private void lab6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab6MouseClicked
     add(lab6);   // TODO add your handling code here:
    }//GEN-LAST:event_lab6MouseClicked

    private void lab7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab7MouseClicked
     add(lab7);   // TODO add your handling code here:
    }//GEN-LAST:event_lab7MouseClicked

    private void lab8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab8MouseClicked
    add(lab8);   // TODO add your handling code here:
    }//GEN-LAST:event_lab8MouseClicked

    private void lab9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab9MouseClicked
     add(lab9);   // TODO add your handling code here:
    }//GEN-LAST:event_lab9MouseClicked

    private void lab10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab10MouseClicked
     add(lab10);   // TODO add your handling code here:
    }//GEN-LAST:event_lab10MouseClicked

    private void lab11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab11MouseClicked
     add(lab11);   // TODO add your handling code here:
    }//GEN-LAST:event_lab11MouseClicked

    private void lab12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab12MouseClicked
      add(lab12);  // TODO add your handling code here:
    }//GEN-LAST:event_lab12MouseClicked

    private void lab13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab13MouseClicked
     add(lab13);   // TODO add your handling code here:
    }//GEN-LAST:event_lab13MouseClicked

    private void lab14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab14MouseClicked
     add(lab14);   // TODO add your handling code here:
    }//GEN-LAST:event_lab14MouseClicked

    private void lab15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab15MouseClicked
     add(lab15);   // TODO add your handling code here:
    }//GEN-LAST:event_lab15MouseClicked

    private void lab16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab16MouseClicked
     add(lab16);   // TODO add your handling code here:
    }//GEN-LAST:event_lab16MouseClicked

    private void lab17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab17MouseClicked
     add(lab17);   // TODO add your handling code here:
    }//GEN-LAST:event_lab17MouseClicked

    private void lab18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab18MouseClicked
      add(lab18);  // TODO add your handling code here:
    }//GEN-LAST:event_lab18MouseClicked

    private void lab19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab19MouseClicked
     add(lab19);   // TODO add your handling code here:
    }//GEN-LAST:event_lab19MouseClicked

    private void lab20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab20MouseClicked
     add(lab20);   // TODO add your handling code here:
    }//GEN-LAST:event_lab20MouseClicked

    private void lab21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab21MouseClicked
     add(lab21);   // TODO add your handling code here:
    }//GEN-LAST:event_lab21MouseClicked

    private void lab22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab22MouseClicked
    add(lab22);    // TODO add your handling code here:
    }//GEN-LAST:event_lab22MouseClicked

    private void lab23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab23MouseClicked
    add(lab23);    // TODO add your handling code here:
    }//GEN-LAST:event_lab23MouseClicked

    private void lab24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab24MouseClicked
    add(lab24);    // TODO add your handling code here:
    }//GEN-LAST:event_lab24MouseClicked

    private void lab25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab25MouseClicked
     add(lab25);  // TODO add your handling code here:
    }//GEN-LAST:event_lab25MouseClicked

    private void lab26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab26MouseClicked
     add(lab26);   // TODO add your handling code here:
    }//GEN-LAST:event_lab26MouseClicked

    private void lab28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab28MouseClicked
     add(lab28);   // TODO add your handling code here:
    }//GEN-LAST:event_lab28MouseClicked

    private void lab29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab29MouseClicked
     add(lab29);   // TODO add your handling code here:
    }//GEN-LAST:event_lab29MouseClicked

    private void lab30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab30MouseClicked
     add(lab30);   // TODO add your handling code here:
    }//GEN-LAST:event_lab30MouseClicked

    private void lab31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab31MouseClicked
      add(lab31);  // TODO add your handling code here:
    }//GEN-LAST:event_lab31MouseClicked

    private void lab27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab27MouseClicked
     add(lab27);   // TODO add your handling code here:
    }//GEN-LAST:event_lab27MouseClicked
void picGen(){
   name(lab1, "store (NI", 10);
   name(lab2, "Grannary (NI", 11);
   name(lab3, "MainBuilding (NI", 15);
   name(lab4, "Marketplace (NI", 17);
   name(lab5, "Embassy (NI", 18);
   name(lab6, "Cranny (NI", 23);
   name(lab7, "TownHall (NI", 24);
   name(lab8, "Residence (NI", 25);
   name(lab9, "Palace (NI", 26);
   name(lab10, "Treasure (NI", 27);
   name(lab11, "TradeOffice (NI", 28);
   name(lab12, "LargeStore (NI", 38);
   name(lab13, "LargeGrannary (NI", 39);
   
   name(lab14, "BlackSmith (NM", 13);
   name(lab15, "Arena (NM", 14);
   name(lab16, "RallyPoint (NM", 16);
   name(lab17, "Barrack (NM", 19);
   name(lab18, "Stables (NM", 20);
   name(lab19, "Workshop (NM", 21);
   name(lab20, "Academia (NM", 22);
   name(lab21, "LargeBarrack (NM", 29);
   name(lab22, "LargeStables (NM", 30);
   if(MainWindow.tribe == 0){
       name(lab23, "Wall (NM", 31);
       name(lab24, "WateringPlace (NM", 41);
   }else if(MainWindow.tribe == 1){
       name(lab23, "ClayMound (NM", 32);
       name(lab24, "Brewery (NM", 35);
   }else if(MainWindow.tribe == 2){
       name(lab23, "Palisade (NM", 33);
       name(lab24, "Trapper (NM", 36);
   }
   name(lab25, "StoneCutter (NM", 34);
   name(lab26, "HeroMansion (NM", 37);
   
   name(lab27, "sawmill (NR", 5);
   name(lab28, "brickyard (NR", 6);
   name(lab29, "foundry (NR", 7);
   name(lab30, "windmill (NR", 8);
   name(lab31, "baker (NR", 9);
}

void name(JLabel label, String str, int i){
    MainWindow.labelIco(label, null, "images/g"+i+"-ltr.png");
    label.setName(id + str + i + ")" + "images/g"+i+"-ltr.png");
}

void add(JLabel label){
    dispose();
    String path = label.getName().substring(label.getName().indexOf("images"));
    label.setName(label.getName().substring(0, label.getName().indexOf("images")));
    if(MainWindow.tribe == 0)
        MainWindow.addRowToArchitector(label, false, 1);
    else
        MainWindow.addRowToArchitector(label, false, 0);
    Architector3Villy.addNewLabel(lab, path, label.getName());
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel infro;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab10;
    private javax.swing.JLabel lab11;
    private javax.swing.JLabel lab12;
    private javax.swing.JLabel lab13;
    private javax.swing.JLabel lab14;
    private javax.swing.JLabel lab15;
    private javax.swing.JLabel lab16;
    private javax.swing.JLabel lab17;
    private javax.swing.JLabel lab18;
    private javax.swing.JLabel lab19;
    private javax.swing.JLabel lab2;
    private javax.swing.JLabel lab20;
    private javax.swing.JLabel lab21;
    private javax.swing.JLabel lab22;
    private javax.swing.JLabel lab23;
    private javax.swing.JLabel lab24;
    private javax.swing.JLabel lab25;
    private javax.swing.JLabel lab26;
    private javax.swing.JLabel lab27;
    private javax.swing.JLabel lab28;
    private javax.swing.JLabel lab29;
    private javax.swing.JLabel lab3;
    private javax.swing.JLabel lab30;
    private javax.swing.JLabel lab31;
    private javax.swing.JLabel lab4;
    private javax.swing.JLabel lab5;
    private javax.swing.JLabel lab6;
    private javax.swing.JLabel lab7;
    private javax.swing.JLabel lab8;
    private javax.swing.JLabel lab9;
    private javax.swing.JPanel mili;
    private javax.swing.JPanel reso;
    // End of variables declaration//GEN-END:variables
}
