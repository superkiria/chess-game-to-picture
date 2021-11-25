package com.github.superkiria.chess.svg;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

import java.io.File;
import java.io.IOException;

import static com.github.superkiria.chess.svg.SvgUtils.createSVGDocumentFromFile;

public class SvgBoard {

    private SVGDocument document = createSVGDocumentFromFile(new File("src/main/resources/Chessboard480.svg"));

    private boolean hasPieces = false;

    public SvgBoard() throws IOException {
    }

    public void importPiece(Node node, int x, int y) {
        Node imported = document.importNode(node, true);
        Attr transform = document.createAttribute("transform");
        transform.setNodeValue("matrix(1.3333 0 0 1.3333 " + x * 60 + " " + y * 60 + ")");
        ((Element) imported).setAttributeNode(transform);
        document.getRootElement().appendChild(imported);
        hasPieces = true;
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
