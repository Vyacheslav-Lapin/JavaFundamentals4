package xml.jaxp;

import lombok.SneakyThrows;
import org.w3c.dom.Document;
import xml.Food;
import xml.dom.DomReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

public interface JaxpDomDemo {
    @SneakyThrows
    static List<Food> getFoods(File file) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(file);
        return DomReader.getFoods2(document);
    }
}
