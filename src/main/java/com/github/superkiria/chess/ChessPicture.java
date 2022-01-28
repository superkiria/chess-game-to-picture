package com.github.superkiria.chess;

import org.w3c.dom.svg.SVGDocument;

import java.io.File;
import java.io.IOException;

import static com.github.superkiria.chess.svg.SvgUtils.createSVGDocumentFromFile;

public class ChessPicture {
    final SVGDocument empty;


    public ChessPicture() throws IOException {
        empty = createSVGDocumentFromFile(new File(getClass().getClassLoader().getResource("svg/empty.svg").toString()));
    }

}
