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
        // избавиться от ссылки на empty
        empty = createSVGDocumentFromFile(Objects.requireNonNull(getClass().getClassLoader().getResource("svg/empty.svg")).toString());
        for (SvgFileNames entry : SvgFileNames.values()) {
            filesForPieces.put(entry, new SvgPiece(Objects.requireNonNull(getClass().getClassLoader().getResource(entry.getFileName())).toString()));
        }
    }

    public ChessPic newPicture() {
        return new ChessPic(filesForPieces, DEFAULT_COLOR);
    }

    public ChessPic newPicture(BoardColor boardColor) {
        return new ChessPic(filesForPieces, boardColor);
    }

}
