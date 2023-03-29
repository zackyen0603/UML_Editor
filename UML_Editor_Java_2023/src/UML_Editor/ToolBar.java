

package UML_Editor;

import UML_Mode.CreateShapeMode;
import UML_Mode.BaseMode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class ToolBar  extends  JToolBar{
//    private Color myColor = new Color(50, 171, 175);
//    private JButton holdBtn = null;
    private Canvas canvas;
    private int iconSize = 80 ;
    private String[] modes= {
            "select",
            "associate",
            "general",
            "composite",
            "class",
            "usecase",
            "black"
    };
    //最後一個是black物件 [modes.length-1]
    private int ToolNum = modes.length-1;
    protected ToolBtn[] bottons = new ToolBtn[ToolNum] ;

    private void setToolBtnIcon(ToolBtn[] toolBtns){
        for(int i = 0 ; i<ToolNum; i+=1){
            ImageIcon icon = new ImageIcon("image/"+this.modes[i]+".png");
            Image img = icon.getImage();
            Image newimag = img.getScaledInstance(iconSize, iconSize,  java.awt.Image.SCALE_SMOOTH ) ;
            toolBtns[i].setIcon(new ImageIcon(newimag));
        }
    }
    private void setNewToolBtn(ToolBtn[] toolBtns){
        for(int i = 0 ; i<ToolNum; i+=1){
            ImageIcon icon = new ImageIcon(this.modes[i]);
            toolBtns[i] = new ToolBtn(modes[i]);
            toolBtns[i].ToolMode = new CreateShapeMode(modes[i]);
            add(toolBtns[i]);
        }
    }

    public ToolBar() {
        canvas = Canvas.getInstance();   // Canvas is singleton
        setLayout(new GridLayout(ToolNum, 2, 1, 1));
//        setLayout(new FlowLayout(FlowLayout.RIGHT)));
        setBackground(Color.darkGray);

        //設定按鍵選取以及設定顯示圖片
        setNewToolBtn(bottons);
        setToolBtnIcon(bottons);


    }


    private class ToolBtn extends JButton/* implements MouseListener*/ {

        BaseMode ToolMode;
        String toolName ;
        public ToolBtn(String ToolName/* Mode ToolMode*/) {
//            super(ToolName);
//            this.ToolMode = ToolMode;
            this.toolName = ToolName;
            setToolTipText(ToolName);
//            setIcon(icon);
            setFocusable(false);
//            setBackground(new Color(0, 0, 0));
//            setBorderPainted(true);
            this.setContentAreaFilled(false);
            setRolloverEnabled(true);
            addActionListener(new toolBtnListener());
//            addMouseListener(this);
        }
        class toolBtnListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                //改變canvas上的模式
//                canvas.modeNow.strModeType = toolName;
                canvas.setModeNow(toolName);
                setBorderPainted(true);
                //重新繪製按鈕
                setToolBtnIcon(bottons);

                ImageIcon icon = new ImageIcon("image/black.png");
                Image img = icon.getImage();
                Image newimag = img.getScaledInstance(iconSize, iconSize,  java.awt.Image.SCALE_SMOOTH ) ;
                setIcon(new ImageIcon(newimag));
//                setIcon(new ImageIcon("image/black.png"));
                //Terminal檢查模式
                System.out.println("Mode \""+canvas.modeNow+"\" Now");



//                canvas.mod = ToolMode;
//                canvas.setCurrentMode();
//                canvas.reset();
                canvas.repaint();
            }
        }

//        @Override
//        public void mouseClicked(MouseEvent e) {
//            canvas.modeNow = this.toolName;
//            this.setBorderPainted(true);
//            setToolBtnIcon(bottons);
//            this.setIcon(new ImageIcon("image/black.png"));
//            System.out.println("Clicked");
//
//            this.setBackground(Color.black);
////            this.setIcon();
//        };
//
//        @Override
//        /**
//         * Invoked when the mouse button has been clicked (pressed
//         * and released) on a component.
//         * @param e the event to be processed
//         */
//        public void mousePressed(MouseEvent e){
//            System.out.println("Pressed");
//
//
//        };
//
//        @Override
//        public void mouseReleased(MouseEvent e){
//
//            System.out.println("Release");
//
//
//        };
//    int cnt = 0 ;
//        @Override
//        public void mouseEntered(MouseEvent e){
//
////            System.out.println("enter"+cnt);
//            cnt ++ ;
//
//
//        };
//
//        @Override
//        public void mouseExited(MouseEvent e){
//
////            System.out.println("exit");
//            cnt=0;
//        };
    }

}