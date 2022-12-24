package com.github.superkiria.chess;

import com.github.superkiria.chess.color.BoardColor;
import com.github.superkiria.chess.svg.SvgFileNames;
import com.github.superkiria.chess.svg.SvgPiece;
import org.w3c.dom.svg.SVGDocument;

import java.util.EnumMap;
import java.util.Objects;

import static com.github.superkiria.chess.svg.SvgUtils.createSVGDocumentFromFile;

public class ChessPicFactory {

    private static final BoardColor DEFAULT_COLOR = BoardColor.BLUE_PURPLE;

    private final SVGDocument empty;
    private final EnumMap<SvgFileNames, SvgPiece> filesForPieces = new EnumMap<>(SvgFileNames.class);

    public ChessPicFactory() {
        empty = createSVGDocumentFromFile(Objects.requireNonNull(getClass().getClassLoader().getResource("svg/empty.svg")).toString());
        for (SvgFileNames entry : SvgFileNames.values()) {
            filesForPieces.put(entry, new SvgPiece(Objects.requireNonNull(getClass().getClassLoader().getResource(entry.getFileName())).toString()));
        }
    }

    public ChessPic empty() {
        return new ChessPic(empty, filesForPieces, DEFAULT_COLOR);
    }


}
