package UML_Mode;

import UML_Object.BasicLine;
import UML_Object.BasicShape;

import java.awt.Point;



public interface FactoryInterface {
    BasicShape createShape(String shapeType,Point p);
    BasicLine  createLine(String lineType,Point p);
}
