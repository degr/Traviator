package traviator42.common;

import traviator42.gui.common.DebugWindow;
import traviator42.gui.common.MainLogin;
import traviator42.gui.common.MainWindow;
import traviator42.gui.common.Traviator42;

import java.awt.*;
import java.io.*;

//<editor-fold defaultstate="collapsed" desc=" полоса ">
public class ProgThread implements Runnable{
    Thread PT;
    ProgThread(){
        PT = new Thread(this, "proto thread");
        PT.start();
    }

    @Override
    public void run(){
     /*boolean error = false;
    int fdate = -1;
        wd d = new wd(new HtmlUnitDriver());
        try{
        TravianChiefHello.prog.setMaximum(8);
        TravianChiefHello.prog.setValue(1);
        TravianChiefHello.jLabel1.setText("Checking license, step 1");
        d.get("http://traviator.net/Check/form.html");
        TravianChiefHello.prog.setValue(2);
        TravianChiefHello.jLabel1.setText("Checking license, step 2");
        int version = Integer.valueOf(d.id("version42").getText());
        TravianChiefHello.prog.setValue(3);
        TravianChiefHello.jLabel1.setText("Checking license, step 3");
        d.id("text").clear();
        d.id("text").sendKeys(mac());
        TravianChiefHello.prog.setValue(4);
        TravianChiefHello.jLabel1.setText("Checking license, step 4");
        d.id("button").click();
        TravianChiefHello.prog.setValue(5);
        TravianChiefHello.jLabel1.setText("Checking license, step 5");
        String name, date, time, edate;
        name = d.id("name").getText();
        TravianChiefHello.prog.setValue(6);
        TravianChiefHello.jLabel1.setText("Checking license, step 6");
        date = d.id("date").getText();
        TravianChiefHello.prog.setValue(7);
        TravianChiefHello.jLabel1.setText("Checking license, step 7");
        time = d.id("time").getText();
        TravianChiefHello.prog.setValue(8);
        TravianChiefHello.jLabel1.setText("Checking license, step 8");
        edate = d.id("curDate").getText();
        fdate = dateTimer(date) + Integer.valueOf(time) - dateTimer(edate);
        Traviator42.tch.dispose();
                 if(version > Traviator42.version){
                     Object[] options = {MainWindow.messages[72][1] };
                     int n = JOptionPane
                             .showOptionDialog(null, MainWindow.messages[244][1],
                             MainWindow.messages[236][1], JOptionPane.YES_NO_OPTION,
                             JOptionPane.INFORMATION_MESSAGE, null, options,
                             options[0]);
                 }
        }catch(Exception ex){
            TravianChiefHello.jButton2.setText("Error. Press to exit.");
            TravianChiefHello.jButton2.setForeground(Color.red);
            error = true;
            JTextField erField = new JTextField(ex.getMessage());
            erField.setPreferredSize(new Dimension(150, 33));
            TravianChiefHello.jPanel4.add(erField);
            TravianChiefHello.jPanel4.revalidate();
        }
        try{
            d.d.quit();
        }catch(Exception ex){

        }
        if(fdate > 0){*/
        /*}else{
             if(!error){
                MainNotification nottt = new MainNotification(Traviator42.mainWindow, true);
                nottt.setVisible(true);
             }
        }*/
    }
    int dateTimer(String date){
        int val = 365*Integer.valueOf(date.substring(0, date.indexOf("-")).trim());
        date = date.substring(date.indexOf("-")+1);
        val = val + 30*Integer.valueOf(date.substring(0, date.indexOf("-")).trim());
        val = val + Integer.valueOf(date.substring(date.lastIndexOf("-")+1).trim());
        return val;
    }
    //<editor-fold defaultstate="collapsed" desc="оплочено">

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="mac adres">
    public static String mac(){

        String result = "";
        try {
            File file = new File("src/realhowto.vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    +"Set colDrives = objFSO.Drives\n"
                    +"Set objDrive = colDrives.item(\"c\")\n"
                    +"Wscript.Echo objDrive.SerialNumber";  // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input =
                    new BufferedReader
                            (new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
            file.delete();
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return result.trim();

    }
    //</editor-fold>

}