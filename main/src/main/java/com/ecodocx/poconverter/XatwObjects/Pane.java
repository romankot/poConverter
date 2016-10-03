package com.ecodocx.poconverter.XatwObjects;

import com.ecodocx.poconverter.elements.FBlock;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by Roman on 9/1/2016.
 * class represents xml node that contains dynamic fields
 */
public class Pane {
    String name;
    String section;
    String backgroundColor;
    String alternateRowCount;
    String alternateBackgroundColor;
    String visible;
    String shading;
    String allowMultiple;
    String allowSplit;
    String pageBreak;
    String allowBreakBefore;
    String allowBreakAfter;
    String overflowHeader;
    String overflowFooter;

    private Pane(FBlock fblock) {
        name = fblock.getName();
    }
    public static Element createInstance(Document document, Element parent, String paneName) {
        Element pane = document.createElement("pane");
        pane.setAttribute("name", paneName);
        pane.setAttribute("section", "main");
        return pane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getAlternateRowCount() {
        return alternateRowCount;
    }

    public void setAlternateRowCount(String alternateRowCount) {
        this.alternateRowCount = alternateRowCount;
    }

    public String getAlternateBackgroundColor() {
        return alternateBackgroundColor;
    }

    public void setAlternateBackgroundColor(String alternateBackgroundColor) {
        this.alternateBackgroundColor = alternateBackgroundColor;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getShading() {
        return shading;
    }

    public void setShading(String shading) {
        this.shading = shading;
    }

    public String getAllowMultiple() {
        return allowMultiple;
    }

    public void setAllowMultiple(String allowMultiple) {
        this.allowMultiple = allowMultiple;
    }

    public String getAllowSplit() {
        return allowSplit;
    }

    public void setAllowSplit(String allowSplit) {
        this.allowSplit = allowSplit;
    }

    public String getPageBreak() {
        return pageBreak;
    }

    public void setPageBreak(String pageBreak) {
        this.pageBreak = pageBreak;
    }

    public String getAllowBreakBefore() {
        return allowBreakBefore;
    }

    public void setAllowBreakBefore(String allowBreakBefore) {
        this.allowBreakBefore = allowBreakBefore;
    }

    public String getAllowBreakAfter() {
        return allowBreakAfter;
    }

    public void setAllowBreakAfter(String allowBreakAfter) {
        this.allowBreakAfter = allowBreakAfter;
    }

    public String getOverflowHeader() {
        return overflowHeader;
    }

    public void setOverflowHeader(String overflowHeader) {
        this.overflowHeader = overflowHeader;
    }

    public String getOverflowFooter() {
        return overflowFooter;
    }

    public void setOverflowFooter(String overflowFooter) {
        this.overflowFooter = overflowFooter;
    }
}
