package com.github.superkiria.chess.svg;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import static com.github.superkiria.chess.svg.SvgUtils.createSVGDocumentFromFile;

public class SvgBoard {

    private final static int FACTOR = 45;
    
    private final SVGDocument document;

    private boolean hasPieces = false;

    public SvgBoard(String black, String white) throws IOException {
        document = createSVGDocumentFromFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("svg/empty.svg")).toString()));
        drawBoard(black, white);
    }

    public void importPiece(Node node, int x, int y) {
        Node imported = document.importNode(node, true);
        Attr transform = document.createAttribute("transform");
        transform.setNodeValue("matrix(1 0 0 1 " + x * FACTOR + " " + y * FACTOR + ")");
        ((Element) imported).setAttributeNode(transform);
        document.getRootElement().appendChild(imported);
        hasPieces = true;
    }

    public void highlightSquare(int x, int y) {
        drawRectangle(x * FACTOR, y * FACTOR, FACTOR, FACTOR, "ffff00", 40);
    }

    public SVGDocument getDocument() {
        return document;
    }

    private void drawRectangle(int x, int y, int width, int height, String color) {
        drawRectangle(x, y, width, height, color, 100);
    }

    private void drawRectangle(int x, int y, int width, int height, String color, int opacity) {
        Element svgRect = document.createElementNS("http://www.w3.org/2000/svg","rect");

        addAttributeToDocument(document, svgRect, "fill", "#" + color);
        addAttributeToDocument(document, svgRect, "x", String.valueOf(x));
        addAttributeToDocument(document, svgRect, "y", String.valueOf(y));
        addAttributeToDocument(document, svgRect, "height", String.valueOf(height));
        addAttributeToDocument(document, svgRect, "width", String.valueOf(width));

        if (opacity < 100) {
            addAttributeToDocument(document, svgRect, "opacity", String.valueOf(opacity / 100.));
        }

        document.getRootElement().getChildNodes().item(1).appendChild(svgRect);
    }

    private void addAttributeToDocument(SVGDocument document, Element element, String attribute, String value) {
        Attr attr = document.createAttribute(attribute);
        attr.setNodeValue(value);
        element.setAttributeNode(attr);
    }

    private void drawBoard(String black, String white) {
        drawRectangle(0,0, FACTOR * 8, FACTOR * 8, black);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    drawRectangle(i * FACTOR, j * FACTOR, FACTOR, FACTOR, white);
                }
            }
        }
    }

}
