

package UML_Editor;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

//import UMLeditor_mode.Mode;
//import UMLeditor_mode.createLineMode;
//import UMLeditor_mode.createObjMode;
//import UMLeditor_mode.selectMode;

public class ToolBar {
    private int ToolNum = 6;
    private Color myColor = new Color(50, 171, 175);
    private JButton holdBtn = null;
    private Canvas canvas;

    public ToolBar() {
        canvas = Canvas.getInstance();   // Canvas is singleton
//        setLayout(new GridLayout(ToolNum, 1, 2, 2));
//        this.setBackground(new Color(83, 85, 87));
//
//        ImageIcon selectIcon = new ImageIcon("img/select.png");
//        ToolBtn selectBtn = new ToolBtn("select", selectIcon, new selectMode());
//        add(selectBtn);
//
//        ImageIcon associateIcon = new ImageIcon("img/associate.png");
//        ToolBtn associateBtn = new ToolBtn("associate", associateIcon, new createLineMode("associate"));
//        add(associateBtn);
//
//        ImageIcon generalIcon = new ImageIcon("img/general.png");
//        ToolBtn generalBtn = new ToolBtn("general", generalIcon, new createLineMode("general"));
//        add(generalBtn);
//
//        ImageIcon compositeIcon = new ImageIcon("img/composite.png");
//        ToolBtn compositeBtn = new ToolBtn("composite", compositeIcon, new createLineMode("composite"));
//        add(compositeBtn);
//
//        ImageIcon classIcon = new ImageIcon("img/class.png");
//        ToolBtn classBtn = new ToolBtn("class", classIcon, new createObjMode("class"));
//        add(classBtn);
//
//        ImageIcon usecaseIcon = new ImageIcon("img/usecase.png");
//        ToolBtn usecaseBtn = new ToolBtn("usecase", usecaseIcon, new createObjMode("usecase"));
//        add(usecaseBtn);

    }

}