//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}
package UML_Editor;

import java.awt.*;
import javax.swing.*;

public class UML_Editor extends JFrame {
    private ToolBar toolBar;
    private Canvas canvas;
    private  MenuBar menuBar;

    public UML_Editor(){
        canvas = Canvas.getInstance();   // Canvas is singleton
        toolBar = new ToolBar();
        menuBar = new MenuBar();

    }
    public static void main(String[] args) {

        UML_Editor mainWindow = new UML_Editor();
        mainWindow.setTitle("UML editor");




//        JFrame demo = new JFrame();
//        demo.setSize(400, 300);
//        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JCheckBox checkbox = new JCheckBox("JCheckBox");
//        JRadioButton radiobutton = new JRadioButton("JRadiobutton");
//        JButton button = new JButton("JButton");
//        JLabel label = new JLabel("JLabel");
//        JTextArea textarea = new JTextArea("JTextArea");
//
//        demo.getContentPane().add(BorderLayout.EAST, checkbox);
//        demo.getContentPane().add(BorderLayout.WEST, radiobutton);
//        demo.getContentPane().add(BorderLayout.SOUTH, button);
//        demo.getContentPane().add(BorderLayout.NORTH , label);
//        demo.getContentPane().add(BorderLayout.CENTER, textarea);
//
//        demo.setVisible(true);
    }
}