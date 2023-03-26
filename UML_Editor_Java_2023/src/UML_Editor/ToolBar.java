

package UML_Editor;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

//import UMLeditor_mode.Mode;
//import UMLeditor_mode.createLineMode;
//import UMLeditor_mode.createObjMode;
//import UMLeditor_mode.selectMode;

@SuppressWarnings("serial")
public class ToolBar  extends  JToolBar{
    private int ToolNum = 6;
    private Color myColor = new Color(50, 171, 175);
    private JButton holdBtn = null;
    private Canvas canvas;
    protected ToolBtn[] bottons = new ToolBtn[6] ;
    private String[] modes= {
            "select",
            "associate",
            "general",
            "composite",
            "class",
            "usecase",
            "black"
    };

    public void setToolBtnIcon(ToolBtn[] toolBtns){
        for(int i = 0 ; i<ToolNum; i+=1){
            ImageIcon icon = new ImageIcon("image/"+this.modes[i]+".png");
            toolBtns[i].setIcon(icon);
        }
    };
    private void setNewToolBtn(ToolBtn[] toolBtns){
        for(int i = 0 ; i<ToolNum; i+=1){
            ImageIcon icon = new ImageIcon(this.modes[i]);
            toolBtns[i] = new ToolBtn(modes[i]);
            add(toolBtns[i]);
        }
    };

    public ToolBar() {
        canvas = canvas.getInstance();   // Canvas is singleton
        setLayout(new GridLayout(ToolNum, 2, 10, 10));
//        setLayout(new FlowLayout(FlowLayout.RIGHT)));
        setBackground(Color.darkGray);

        //設定按鍵選取以及設定顯示圖片
        setNewToolBtn(bottons);
        setToolBtnIcon(bottons);


    }


    private class ToolBtn extends JButton implements MouseListener {

//        Mode ToolMode;
        String toolName ;
        public ToolBtn(String ToolName/* Mode ToolMode*/) {
            super(ToolName);
//            this.ToolMode = ToolMode;
            this.toolName = ToolName;
            setToolTipText(ToolName);
//            setIcon(icon);
            setFocusable(true);
            setBackground(new Color(0, 0, 0));
            setBorderPainted(false);
//            setRolloverEnabled(true);
//            addActionListener(new toolListener());
            addMouseListener(this);
        }
//        class toolListener implements ActionListener {
//            public void actionPerformed(ActionEvent e) {
//                if(holdBtn != null)
//                    holdBtn.setBackground(Color.blue);
//                holdBtn = (JButton) e.getSource();
//                holdBtn.setBackground(myColor);
////                canvas.currentMode = ToolMode;
////                canvas.setCurrentMode();
////                canvas.reset();
////                canvas.repaint();
//            }
//        }

        @Override
        public void mouseClicked(MouseEvent e) {
            canvas.modeNow = this.toolName;
            this.setBorderPainted(true);
            this.setBackground(Color.red);
            setToolBtnIcon(bottons);
            this.setIcon(new ImageIcon("image/black.png"));
            System.out.println("Clicked");
//            this.setIcon();
        };

        @Override
        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         * @param e the event to be processed
         */
        public void mousePressed(MouseEvent e){
            System.out.println("Pressed");


        };

        @Override
        public void mouseReleased(MouseEvent e){

            System.out.println("Release");


        };
    int cnt = 0 ;
        @Override
        public void mouseEntered(MouseEvent e){

//            System.out.println("enter"+cnt);
            cnt ++ ;


        };

        @Override
        public void mouseExited(MouseEvent e){

//            System.out.println("exit");
            cnt=0;
        };
    }

}