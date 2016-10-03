package com.ecodocx.poconverter;

import com.ecodocx.poconverter.elements.*;
import org.w3c.dom.Element;

/**
 * Created by Roman on 8/16/2016.
 */
public interface BaseElementVisitor {
    Element visit(BaseElement baseElement, Element parent);
    Element visit(Sheet sheet, Element parent);
    Element visit(Block block, Element parent);
    Element visit(FBlock fblock, Element parent);
    Element visit(Frame frame, Element parent);
    void visit(Date date, Element parent);
    void visit(End end, Element parent);
    void visit(Field field, Element parent);
    void visit(Image image, Element parent);
    void visit(Line line, Element parent);
    void visit(Overlay overlay, Element parent);
    void visit(ProcPage procPage, Element parent);
    void visit(Rect rect, Element parent);
    void visit(Script script, Element parent);
    void visit(Text text, Element parent);
    void visit(Variable variable, Element parent);
}
