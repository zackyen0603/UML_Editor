package UML_Editor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
    private JMenu file, edit;
    private JMenuItem i1, i2, i3, i4, i5;
    public MenuBar(){
//        JFrame f= new JFrame("Menu and MenuItem Example");
        JMenuBar menuBar=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");
        i1=new JMenuItem("Item 1");
        i2=new JMenuItem("Item 2");
        i3=new JMenuItem("Item 3");
        i4=new JMenuItem("Item 4");
        i5=new JMenuItem("Item 5");
        file.add(i1); edit.add(i2);
        menuBar.add(file); menuBar.add(edit);
//        menu.add(i1); menu.add(i2); menu.add(i3);
//        submenu.add(i4); submenu.add(i5);
//        menu.add(submenu);
//        menuBar.add(menu);
//        f.setJMenuBar(menuBar);
//        f.setSize(400,500);
//        f.setLayout(null);
//        f.setVisible(true);
        return;
    }
    public static void main(String args[]) {
        MenuBar test = new MenuBar();

    }




    }
