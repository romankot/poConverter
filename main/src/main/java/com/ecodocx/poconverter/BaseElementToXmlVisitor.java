package com.ecodocx.poconverter;


import com.ecodocx.poconverter.XatwObjects.*;
import com.ecodocx.poconverter.elements.*;
import com.ecodocx.poconverter.elements.Field;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Roman on 8/16/2016.
 */
public class BaseElementToXmlVisitor implements BaseElementVisitor {
    private String eventName;
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document document;
    BaseElement model;
    private Element root;
    private Transformer t = null;
    private XPathFactory xPathFactory;
    private XPath xPath;
    private Node curRoot;
    private PageDimension pageDimension = new PageDimension();

    public BaseElementToXmlVisitor(String eventName){
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        document = documentBuilder.newDocument();
        try {
            t = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        xPathFactory = XPathFactory.newInstance();
        xPath = xPathFactory.newXPath();
        this.eventName = eventName;
    }
    // make xml by given path
    public void generate(String name) {
        File file = new File(name);
        FileOutputStream fileOutputStream = null;

        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        try {
            fileOutputStream = new FileOutputStream(file);
            t.transform(new DOMSource(document), new StreamResult(fileOutputStream));
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private String getOrientation(Sheet sheet) {
        if (sheet.getWidth() < sheet.getHeight() )
            return "Portrait";
        else
            return "Landscape";
    }

    private String getSize(Sheet sheet) {
        if (sheet.getWidth()== 210 )
            return "A4";
        if (sheet.getWidth()== 215.9 )
            return "Letter";
        return "A4";
    }

    @Override
    public Element visit(BaseElement baseElement, Element parent ) {
        System.out.println("generating baseElement child = "  + baseElement.getChildrenNumber() );

        root = document.createElement("XATW");
        root.setAttribute("name", "Form1");
        root.setAttribute("configFile", "Default-PDF.prt");
        curRoot = document.appendChild(root);
        return root;
    }

    @Override
    public Element visit(Sheet sheet, Element parentElement) {
        System.out.println("generating Sheet. childred = " + sheet.getChildrenNumber());
        pageDimension = new PageDimension(getSize(sheet), getOrientation(sheet));
        Element page = document.createElement("page");
        page.setAttribute("name", "Page" + sheet.getName());
        page.setAttribute("visible", "yes");
        page.setAttribute("size", getSize(sheet));
        page.setAttribute("orientation", getOrientation(sheet));

        page.appendChild(BoundingRect.createInstance(document, pageDimension));
        Node container = Container.createContainer(document);
        container.appendChild(BoundingRect.createInstance(document, pageDimension));
        container.appendChild(Border.createInstance(document));
        Element pane = Pane.createInstance(document, parentElement, eventName);
        container.appendChild(pane);
        page.appendChild(container);
        parentElement.appendChild(page);

        return pane;
    }

    @Override
    public Element visit(Block block, Element parent) {
        System.out.println("parsing Block. childred = " + block.getChildrenNumber());
        Element pane = document.createElement("pane");
        pane.setAttribute("name", block.getName());
        pane.setAttribute("section", "main");
        pane.setAttribute("alternateRowCount", "1");
        pane.setAttribute("alternateBackgroundColor", "#F4F4F4");
        pane.setAttribute("visible", "yes");
        pane.setAttribute("shading", "none" );
        pane.setAttribute("allowMultiple", "yes");
        pane.setAttribute("allowSplit", "no");
        pane.setAttribute("pageBreak", "no");
        pane.setAttribute("allowBreakBefore", "no");
        pane.setAttribute("allowBreakAfter", "yes");
        pane.setAttribute("overflowHeader", "Header");
        pane.setAttribute("overflowFooter", "OverflowFooter");
        pane.appendChild(BoundingRect.createInstance(document, 0, 0, block.getParent().getWidth()/25.4, block.getAdvY()/2) );
        pane.appendChild(Border.createInstance(document));
        parent.appendChild(pane);
        return pane;
    }

    @Override
    public Element visit(FBlock fblock, Element parent) {
        System.out.println("parsing FBlock. childred = " + fblock.getChildrenNumber());
        Element pane = document.createElement("pane");
        pane.setAttribute("name", fblock.getName());
        pane.setAttribute("section", "main");
        pane.setAttribute("alternateRowCount", "1");
        pane.setAttribute("alternateBackgroundColor", "#F4F4F4");
        pane.setAttribute("visible", "yes");
        pane.setAttribute("shading", "none" );
        pane.setAttribute("allowMultiple", "yes");
        pane.setAttribute("allowSplit", "no");
        pane.setAttribute("pageBreak", "no");
        pane.setAttribute("allowBreakBefore", "no");
        pane.setAttribute("allowBreakAfter", "yes");
        pane.setAttribute("overflowHeader", "Header");
        pane.setAttribute("overflowFooter", "OverflowFooter");
        pane.appendChild(BoundingRect.createInstance(document, 0, 0, fblock.getParent().getWidth()/25.4, fblock.getAdvY()/2) );
        pane.appendChild(Border.createInstance(document));
        parent.appendChild(pane);
        return pane;
    }

    @Override
    public Element visit(Frame frame, Element parent) {
        System.out.println("generating Frame children =" + frame.getChildrenNumber());
        return parent;
    }

    @Override
    public void visit(Date date, Element parent) {

    }

    @Override
    public void visit(End end, Element parent) {

    }

    @Override
    public void visit(Field field, Element parent) {
        parent.appendChild(com.ecodocx.poconverter.XatwObjects.Field.createInstance(document, field));
    }

    @Override
    public void visit(Image image, Element parent) {

    }

    @Override
    public void visit(Line line, Element parent) {
        parent.appendChild(XLine.getInstance(document, line));
    }

    @Override
    public void visit(Overlay overlay, Element parent) {

    }

    @Override
    public void visit(ProcPage procPage, Element parent) {

    }

    @Override
    public void visit(Rect rect, Element parent) {

    }

    @Override
    public void visit(Script script, Element parent) {

    }

    @Override
    public void visit(Text text, Element parent) {
        parent.appendChild(LabelText.createInstance(document, text));
    }

    @Override
    public void visit(Variable variable, Element parent) {

    }
}
