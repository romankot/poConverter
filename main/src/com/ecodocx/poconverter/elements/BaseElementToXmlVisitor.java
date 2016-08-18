package com.ecodocx.poconverter.elements;

/**
 * Created by Roman on 8/16/2016.
 */
public class BaseElementToXmlVisitor implements BaseElementVisitor {

    BaseElement model;

    @Override
    public void visit(BaseElement baseElement) {
        System.out.println("generating baseElement child = "  + baseElement.getChildrenNumber() );
    }

    @Override
    public void visit(Sheet sheet) {
        System.out.println("generating Sheet");
    }

    @Override
    public void visit(Block block) {

    }

    @Override
    public void visit(Date date) {

    }

    @Override
    public void visit(End end) {

    }

    @Override
    public void visit(Field field) {

    }

    @Override
    public void visit(Frame frame) {
        System.out.println("generating Frame children =" + frame.getChildrenNumber());
    }

    @Override
    public void visit(Image image) {

    }

    @Override
    public void visit(Line line) {

    }

    @Override
    public void visit(Overlay overlay) {

    }

    @Override
    public void visit(ProcPage procPage) {

    }

    @Override
    public void visit(Rect rect) {

    }

    @Override
    public void visit(Script script) {

    }

    @Override
    public void visit(Text text) {
        System.out.println("generating Text");
    }

    @Override
    public void visit(Variable variable) {

    }
}
