package xml.stax;

import lombok.val;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StAXFileWriter {
    static void writeToFile(File file) throws IOException, XMLStreamException {
        val factory = XMLOutputFactory.newInstance();
        val stream = new FileWriter(file);
        val writer = factory.createXMLStreamWriter(stream);
        try {
            writer.writeStartDocument();
            writer.writeStartElement("document");
            writer.writeStartElement("data");
            writer.writeAttribute("name", "value");
            writer.writeCharacters("content");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } finally {
                stream.close();
            }
        }
    }
}
