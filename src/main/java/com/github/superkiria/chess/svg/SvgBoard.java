package com.github.superkiria.chess.svg;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.github.superkiria.chess.svg.SvgUtils.createSVGDocumentFromFile;

public class SvgBoard {

    private final static int FACTOR = 60;
    
    private final SVGDocument document;

    private boolean hasPieces = false;

    public SvgBoard() throws IOException, URISyntaxException {
        document = createSVGDocumentFromFile(new File(getClass().getClassLoader().getResource("Chessboard480.svg").toString()));
    }

    public void importPiece(Node node, int x, int y) {
        Node imported = document.importNode(node, true);
        Attr transform = document.createAttribute("transform");
        transform.setNodeValue("matrix(1.33335 0 0 1.33335 " + x * FACTOR + " " + y * FACTOR + ")");
        ((Element) imported).setAttributeNode(transform);
        document.getRootElement().appendChild(imported);
        hasPieces = true;
    }

    public void highlightSquare(int x, int y) {
        Element svgRect = document.createElementNS("http://www.w3.org/2000/svg","rect");
        Attr fill = document.createAttribute("fill");
        fill.setNodeValue("#ffff00");
        Attr xAttr = document.createAttribute("x");
        xAttr.setNodeValue(String.valueOf(x * FACTOR));
        Attr yAttr = document.createAttribute("y");
        yAttr.setNodeValue(String.valueOf(y * FACTOR));
        Attr height = document.createAttribute("height");
        height.setNodeValue(String.valueOf(FACTOR));
        Attr width = document.createAttribute("width");
        width.setNodeValue(String.valueOf(FACTOR));
        Attr cl = document.createAttribute("class");
        cl.setNodeValue("highlight");
        Attr opacity = document.createAttribute("fill-opacity");
        opacity.setNodeValue("0.25");
        svgRect.setAttributeNode(fill);
        svgRect.setAttributeNode(xAttr);
        svgRect.setAttributeNode(yAttr);
        svgRect.setAttributeNode(height);
        svgRect.setAttributeNode(width);
        svgRect.setAttributeNode(cl);
        svgRect.setAttributeNode(opacity);
        document.getRootElement().getChildNodes().item(1).appendChild(svgRect);
    }

    public void flipBoard() {
        if (hasPieces) {
            throw new IllegalStateException("SvgBoard has pieces, could not be flipped");
        }
        Attr transform = document.createAttribute("transform");
        transform.setNodeValue("rotate(90), translate(0 -480)");
        ((Element) document.getRootElement().getChildNodes().item(1)).setAttributeNode(transform);
    }

    public SVGDocument getDocument() {
        return document;
    }
}
