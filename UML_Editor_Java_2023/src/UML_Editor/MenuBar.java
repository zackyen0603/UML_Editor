package UML_Editor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
    private Canvas canvas;
    public MenuBar(){
        canvas = canvas.getInstance();   // Canvas is singleton

        JMenu menu;
        JMenuItem menuItem;

        /* --- File menu --- */
        menu = new JMenu("File");
        add(menu);

        /* --- Edit menu --- */
        menu = new JMenu("Edit");
        add(menu);

        menuItem = new JMenuItem("Change object name");
        menu.add(menuItem);
//        menuItem.addActionListener(new ChangeNameListener());

        menuItem = new JMenuItem("Group");
        menu.add(menuItem);
//        menuItem.addActionListener(new GroupObjectListener());

        menuItem = new JMenuItem("Ungroup");
        menu.add(menuItem);
//        menuItem.addActionListener(new UngroupObjectListener());
    }




}
