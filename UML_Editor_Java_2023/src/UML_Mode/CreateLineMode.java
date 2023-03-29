package UML_Mode;

import UML_Object.BasicLine;
import UML_Object.BasicShape;
import UML_Object.LineAssociation;
import UML_Object.Port;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CreateLineMode extends BaseMode {

    ObjectFactory factory = new ObjectFactory();

    private int mouseStartX , mouseStartY ;
    private boolean vaildPoint = false ;

    private Port startPort , endPort ;
    Point mouseNow = null ;
    public CreateLineMode(String objType){

        super(objType);
    }





    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseStartX = e.getX() ;
        this.mouseStartY = e.getY() ;

        List<BasicShape> shapeCandidate = new ArrayList<BasicShape>();
        for(BasicShape shape : canvas.shapes ){
            if (shape.pointInside(e.getPoint())){
                shapeCandidate.add(shape) ;
                vaildPoint = true ;
//                System.out.println("PINSIDEEEEEEEEEEE!");
//                shape.isSelected = true ;
            }
            else {
                shape.isSelected = false;
            }
        }

        if(shapeCandidate.size()!=0) {
            BasicShape upperShape = shapeCandidate.get(shapeCandidate.size() - 1) ;
            if (upperShape.pointInside(e.getPoint())) {
                upperShape.isSelected = true;
                System.out.println(upperShape.depth);
            } else {
                shapeCandidate.get(shapeCandidate.size() - 1).isSelected = false;
            }
            startPort = upperShape.nearestPort(e.getPoint());
        }

        canvas.repaint();




    }

    @Override
    public void mouseReleased(MouseEvent e) {
        vaildPoint = false ;
        List<BasicShape> shapeCandidate = new ArrayList<BasicShape>();
        for(BasicShape shape : canvas.shapes ){
            if (shape.pointInside(e.getPoint())){
                shapeCandidate.add(shape) ;
                System.out.println("PINSIDEEEEEEEEEEE!");
//                shape.isSelected = true ;
            }
            else {
//                shape.isSelected = false;
            }
        }

        if(shapeCandidate.size()!=0) {
            BasicShape upperShape = shapeCandidate.get(shapeCandidate.size() - 1) ;
            if (upperShape.pointInside(e.getPoint())) {
                upperShape.isSelected = true;
                System.out.println(upperShape.depth);
            } else {
                shapeCandidate.get(shapeCandidate.size() - 1).isSelected = false;
            }
            endPort = upperShape.nearestPort(e.getPoint());
        }
        if(startPort!=null&&endPort!=null){
            canvas.lines.add(factory.createLine(strModeType,startPort,endPort));
        }

        canvas.tempLine = null ;
        canvas.repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if(vaildPoint) {
            canvas.setDragPoint(startPort.x1, startPort.y1, e.getX(), e.getY());
            mouseNow = e.getPoint();
            System.out.println(e.getX() + "/" + e.getY());

            canvas.tempLine =  factory.createLine(strModeType,startPort,new Port(e.getX(),e.getY(),10,10));//  LineAssociation(startPort.x1, startPort.y1, e.getX(), e.getY());

//        canvas.linkingPainting(startPort.x1,startPort.y1,e.getX(),e.getY(), canvas.getGraphics());
//        if(mouseNow==e.getPoint())
            canvas.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
