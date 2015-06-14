package traviator42.gui.common;

import traviator42.gui.misc.ColorPane;
import traviator42.utils.WD;
import traviator42.utils.commands.ICommand;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ror on 10.06.2015.
 */
public class DebugWindow extends javax.swing.JFrame {
    ColorPane output = new ColorPane();
    ColorPane input = new ColorPane();
    JButton execute = new JButton("Execute");
    JButton clear = new JButton("Clear");
    Color red = Color.red;
    Color black = Color.black;
    WD d = null;
    private static final String separator = "::";
    private static final String line = "---------------------------------";

    public DebugWindow() {
        super("debugger");

        JPanel main = new JPanel();
        new BoxLayout(main, BoxLayout.X_AXIS);

        JPanel panel = new JPanel();
        new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.add(clear);
        panel.add(execute);
        clear.addActionListener(evt -> {
            output.setText("");
        });

        execute.addActionListener(evt -> {
            if(d == null && MainWindow.driver != null) {
                d = new WD(MainWindow.driver);
            }
            execute();
        });


        JScrollPane outputWrapper = new JScrollPane(output);
        JScrollPane inputWrapper = new JScrollPane(input);

        inputWrapper.setPreferredSize(new Dimension(741, 150));
        inputWrapper.setPreferredSize(new Dimension(741, 150));

        outputWrapper.setPreferredSize(new Dimension(741, 150));
        outputWrapper.setPreferredSize(new Dimension(741, 150));

        main.add(inputWrapper);
        main.add(panel);
        main.add(outputWrapper);

        getContentPane().add(main);

        setSize(new Dimension(790, 650));


        //<editor-fold defaultstate="collapsed" desc=" Центр экрана ">
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2));
///////////////////////////////////////////////////
        //</editor-fold>

    }

    class Dto{
        boolean isPresent = false;
        Object o;
    }

    public void execute(){
        String[] commands = input.getText().split("\n");
        Dto previous = new Dto();
        for(String com : commands) {
            String[] args = com.split(separator);
            for(int i = 0; i < args.length; i++) {
                args[i] = args[i].trim();
            }
            try {
                execute(args, previous, previous.isPresent);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
                out(e.getMessage(), red);
            }
        }
    }

    private void execute(String[] args, Dto dto, boolean useDto) throws InvocationTargetException, IllegalAccessException {
        Method method;
        if(useDto) {
            method = getMethod(args[0], dto.o.getClass(), args.length);
        } else {
            method = getMethod(args[0], WD.class, args.length);
        }
        String[] newArgs = new String[args.length - 1];
        for(int i = 0; i < newArgs.length && !useDto; i++) {
            newArgs[i] = args[i+1];
        }
        if(method.getReturnType() != null && !"void".equals(method.getReturnType().getName())) {
            dto.isPresent = true;
            dto.o = method.invoke(useDto ? dto.o : d, newArgs);
            out("Returned object: " + dto.o);
        } else {
            method.invoke(useDto ? dto.o : d, newArgs);
            dto.isPresent = false;
            dto.o = null;
            out("method "+args[0] +" executed.");
        }
    }

    private Method getMethod(String arg, Class aClass, int length) {
        Class[] params = new Class[length - 1];
        for(int i = 0; i < params.length; i++) {
            params[i] = String.class;
        }
        try {
            return aClass.getMethod(arg, params);
        } catch (NoSuchMethodException e) {
            for(StackTraceElement el : e.getStackTrace()) {
                out(el.toString(), red);
            }
            return null;
        }
    }

    public void out(String str){
        out(str, black);
    }
    public void out(String str, Color color) {
        output.append(color, str+"\n");
    }
}
