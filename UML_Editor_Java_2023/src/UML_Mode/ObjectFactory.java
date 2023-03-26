package UML_Mode;

import UML_Object.*;

import java.awt.*;

public class ObjectFactory implements FactoryInterface{

    @Override
    public BasicShape createShape(ShapeType shapeType, Point p) {
        switch (shapeType){
            case ClassShape :
                return new ShapeClass(p.x,p.y);
            case UseCaseShape:
                return new ShapeUseCase(p.x, p.y);
        }
        return null;
    }

    @Override
    public BasicLine createLine(LineType lineType, Point p) {
        switch (lineType){
            case AssociationLine :
                return new LineAssociation(p.x,p.y);
            case GeneralizationLine:
                return new LineGeneralization(p.x,p.y);
            case CompositionLine:
                return new LineComposition(p.x,p.y);
        }
        return null;
    }
}
