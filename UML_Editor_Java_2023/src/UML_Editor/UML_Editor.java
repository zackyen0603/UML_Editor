package UML_Editor;

import java.awt.BorderLayout;
import javax.swing.*;

public class UML_Editor extends JFrame {
    private ToolBar toolBar;
    private Canvas canvas;
    private  MenuBar menuBar;

    public UML_Editor(){
        canvas = Canvas.getInstance();   // Canvas is singleton
        toolBar = new ToolBar();
        menuBar = new MenuBar();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(toolBar, BorderLayout.WEST);
        getContentPane().add(canvas, BorderLayout.CENTER);

    }

    public static void main(String[] args) {

        UML_Editor mainWindow = new UML_Editor();
        mainWindow.setTitle("UML editor");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 700);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}