package UML_Mode;

import UML_Object.BasicLine;
import UML_Object.BasicShape;

import java.awt.Point;

enum ShapeType{
    ClassShape , UseCaseShape
}
enum LineType{
  AssociationLine,CompositionLine,GeneralizationLine
}

public interface FactoryInterface {
    BasicShape createShape(ShapeType shapeType,Point p);
    BasicLine  createLine(LineType lineType,Point p);
}
