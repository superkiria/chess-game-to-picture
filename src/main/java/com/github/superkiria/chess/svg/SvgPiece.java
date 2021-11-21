package com.github.superkiria.chess.svg;

import org.w3c.dom.Node;
import org.w3c.dom.svg.SVGDocument;

import java.io.File;
import java.io.IOException;

import static com.github.superkiria.svg.SvgUtils.createSVGDocumentFromFile;

public class SvgPiece {

    SVGDocument document;

    public SvgPiece(File file) throws IOException {
        this.document = createSVGDocumentFromFile(file);;
    }

    public Node getDocumentNode() {
        return document.getRootElement().getChildNodes().item(1);
    }

}
