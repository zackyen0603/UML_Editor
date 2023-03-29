package UML_Editor;

import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        menuItem.addActionListener(new ChangeNameListener());

        menuItem = new JMenuItem("Group");
        menu.add(menuItem);
        menuItem.addActionListener(new GroupObjectListener());

        menuItem = new JMenuItem("Ungroup");
        menu.add(menuItem);
        menuItem.addActionListener(new UngroupObjectListener());
    }
    public void changeNameForm(){
        JPanel p = new JPanel();
        JTextField newName = new JTextField(10);

        p.add(new JLabel("Object name :"));
        p.add(newName);

        JOptionPane.showConfirmDialog(null, p, "Change Object Name", JOptionPane.OK_CANCEL_OPTION);
        canvas.changeShapeName(newName.getText());
    }

    class ChangeNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeNameForm();
        }
    }


    class GroupObjectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            canvas.addGroup();
        }
    }


    class UngroupObjectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            canvas.removeGroup();

        }
    }




}
