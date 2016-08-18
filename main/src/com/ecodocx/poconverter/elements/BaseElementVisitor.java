package com.ecodocx.poconverter.elements;

/**
 * Created by Roman on 8/16/2016.
 */
public interface BaseElementVisitor {
    void visit(BaseElement baseElement);
    void visit(Sheet sheet);
    void visit(Block block);
    void visit(Date date);
    void visit(End end);
    void visit(Field field);
    void visit(Frame frame);
    void visit(Image image);
    void visit(Line line);
    void visit(Overlay overlay);
    void visit(ProcPage procPage);
    void visit(Rect rect);
    void visit(Script script);
    void visit(Text text);
    void visit(Variable variable);
}
