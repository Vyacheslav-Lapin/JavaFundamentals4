package xml.dom;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import lombok.val;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import xml.Food;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomReader {

    /**
     * @deprecated use JAXP
     */
    @Deprecated
    static List<Food> getFoods(File file) throws IOException, SAXException {
        //создание DOM-анализатора (Xerces)
        DOMParser parser = new DOMParser();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            parser.parse(new InputSource(fileInputStream));
            Document document = parser.getDocument();
            return getFoods2(document);
        }
    }

    public static List<Food> getFoods2(Document document) {
        val root = document.getDocumentElement();

        val menu = new ArrayList<Food>();

        NodeList foodNodes = root.getElementsByTagName("food");
        Food food;

        for (int i = 0; i < foodNodes.getLength(); i++) {
            Element foodElement = (Element) foodNodes.item(i);
            menu.add(
                    new Food()
                            .id(Integer.parseInt(foodElement.getAttribute("id")))
                            .name(getSingleChild(foodElement, "name").getTextContent().trim())
                            .description(getSingleChild(foodElement, "description").getTextContent().trim())
                            .price(getSingleChild(foodElement, "price").getTextContent().trim())
                            .calories(Integer.parseInt(getSingleChild(foodElement, "calories").getTextContent().trim())));
        }
        return menu;
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        return (Element) nlist.item(0);
    }
}
