package com.github.superkiria.chess.svg;

import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

import java.io.IOException;

import static com.github.superkiria.chess.svg.SvgUtils.createSVGDocumentFromFile;

public class SvgPiece {

    SVGDocument document;

    public SvgPiece(String uri) throws IOException {
        this.document = createSVGDocumentFromFile(uri);
    }

    public Node getDocumentNode() {
        return document.getRootElement().getChildNodes().item(1);
    }

}
