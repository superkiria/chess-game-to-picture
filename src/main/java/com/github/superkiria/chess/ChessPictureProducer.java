package com.github.superkiria.chess;

import org.w3c.dom.svg.SVGDocument;

import java.io.ByteArrayOutputStream;

public interface ChessPictureProducer {

    String getSvg();

    SVGDocument getDocument();

    ByteArrayOutputStream getPng();

}
