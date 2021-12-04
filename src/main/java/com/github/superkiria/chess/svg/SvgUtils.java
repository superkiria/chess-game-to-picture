package com.github.superkiria.chess.svg;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
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

    public static SAXSVGDocumentFactory saxsvgDocumentFactory = new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName());

    public static void saveDocumentToPng(Document document) throws Exception {

        // Create a JPEGTranscoder and set its quality hint.
        PNGTranscoder t = new PNGTranscoder();
        t.addTranscodingHint(t.KEY_HEIGHT, (float) 960);
        t.addTranscodingHint(t.KEY_WIDTH, (float) 960);

        // Set the transcoder input and output.
        TranscoderInput input = new TranscoderInput(document);
        OutputStream ostream = new FileOutputStream("target/out.png");
        TranscoderOutput output = new TranscoderOutput(ostream);

        // Perform the transcoding.
        t.transcode(input, output);
        ostream.flush();
        ostream.close();
    }

    public static ByteArrayOutputStream saveDocumentToPngByteBuffer(Document document) throws Exception {

        // Create a JPEGTranscoder and set its quality hint.
        PNGTranscoder t = new PNGTranscoder();
        t.addTranscodingHint(t.KEY_HEIGHT, (float) 960);
        t.addTranscodingHint(t.KEY_WIDTH, (float) 960);

        // Set the transcoder input and output.
        TranscoderInput input = new TranscoderInput(document);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TranscoderOutput output = new TranscoderOutput(outputStream);

        // Perform the transcoding.
        t.transcode(input, output);

        return outputStream;
    }

    public static String documentToXmlString(Document doc) throws TransformerException {
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = transfac.newTransformer();
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(doc.getDocumentElement());

        trans.transform(source, result);
        return sw.toString();
    }

    public static SVGDocument createSVGDocumentFromFile(File file) throws IOException {
        return saxsvgDocumentFactory.createSVGDocument(file.toString());
    }

}
