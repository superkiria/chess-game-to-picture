package com.github.superkiria.chess.svg;

import com.github.superkiria.chess.ChessPicException;
import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.*;
import org.w3c.dom.svg.SVGDocument;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class SvgUtils {

    private static final float SIZE = 720;

    public static SAXSVGDocumentFactory saxsvgDocumentFactory = new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName());

    public static void saveDocumentToPng(Document document, String fileName) throws Exception {

        // Create a JPEGTranscoder and set its quality hint.
        PNGTranscoder transcoder = new PNGTranscoder();
        transcoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, SIZE);
        transcoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, SIZE);

        // Set the transcoder input and output.
        TranscoderInput input = new TranscoderInput(document);
        OutputStream ostream = new FileOutputStream("target/" + fileName);
        TranscoderOutput output = new TranscoderOutput(ostream);

        // Perform the transcoding.
        transcoder.transcode(input, output);
        ostream.flush();
        ostream.close();
    }

    public static ByteArrayOutputStream saveDocumentToPngByteBuffer(Document document) {

        PNGTranscoder transcoder = new PNGTranscoder();
        transcoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, SIZE);
        transcoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, SIZE);

        TranscoderInput input = new TranscoderInput(document);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TranscoderOutput output = new TranscoderOutput(outputStream);

        try {
            transcoder.transcode(input, output);
        } catch (TranscoderException e) {
            throw new ChessPicException(e);
        }

        return outputStream;
    }

    public static String documentToXmlString(Document doc) {
        try {
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer transformer = transfac.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            DOMSource source = new DOMSource(doc.getDocumentElement());

            transformer.transform(source, result);
            return writer.toString();
        } catch (TransformerException e) {
            throw new ChessPicException(e);
        }
    }

    public static SVGDocument createSVGDocumentFromFile(String uri) {
        try {
            return saxsvgDocumentFactory.createSVGDocument(uri);
        } catch (IOException e) {
            throw new ChessPicException(e);
        }
    }

}
