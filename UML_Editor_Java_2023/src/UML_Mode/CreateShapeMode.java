package UML_Mode;

import UML_Object.BasicShape;

import java.awt.event.MouseEvent;

public class CreateShapeMode extends BaseMode {

    //private String objType = null;
    private FactoryInterface factory = new ObjectFactory();
    public CreateShapeMode(String objType) {
        super(objType);
        System.out.println("Shape "+objType+" Created");
    }
    public void mousePressed(MouseEvent e) {
        BasicShape basicShape = factory.createShape(this.strModeType, e.getPoint());
        canvas.addShape(basicShape);
        System.out.println("CLASSSSSeeeeeeeee");

        canvas.repaint();
    }
}
