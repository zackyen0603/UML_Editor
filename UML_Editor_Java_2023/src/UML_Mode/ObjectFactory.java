package UML_Mode;

import UML_Object.*;

import java.awt.*;

public class ObjectFactory implements FactoryInterface{

    @Override
    public BasicShape createShape(String shapeType, Point p) {
        if(shapeType.equals("class")){
            return new ShapeClass(p.x, p.y);
        }
        else if (shapeType.equals("usecase")) {
            return new ShapeUseCase(p.x,p.y) ;
        }
        return null;
    }

    @Override
    public BasicLine createLine(String lineType, Port port1,Port port2) {
        System.out.println(lineType);
        if(lineType.equals("associate")){
            return new LineAssociation(port1,port2);
        }
        else if (lineType.equals("composite")) {
            return new LineComposition(port1,port2);

        }
        else if (lineType.equals("general")) {
            return new LineGeneralization(port1,port2);

        }


        return null;
    }
}
