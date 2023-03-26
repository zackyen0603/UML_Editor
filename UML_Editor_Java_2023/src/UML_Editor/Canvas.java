package UML_Editor;

import javax.swing.*;

public class Canvas extends JPanel {

    private static Canvas instance = null; // for singleton

//    private EventListener listener = null;
//    protected Mode currentMode = null;
//
//    private List<Shape> shapes = new ArrayList<Shape>();
//
//    public Shape tempLine = null;
//    public Rectangle SelectedArea = new Rectangle();
//    public Shape selectedObj = null;

    /* Singleton design pattern */
    private Canvas() {
        // Exists only to defeat instantiation.
    }

    public static Canvas getInstance() {
        if (instance == null) {
            instance = new Canvas();
        }
        return instance;
    }

}
