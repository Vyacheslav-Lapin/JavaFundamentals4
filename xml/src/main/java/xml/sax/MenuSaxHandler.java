package xml.sax;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.val;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@SuppressWarnings("WeakerAccess")
@EqualsAndHashCode(callSuper = true)
@ToString
public class MenuSaxHandler extends DefaultHandler {

    private static enum MenuTagName {
        NAME, PRICE, DESCRIPTION, CALORIES, FOOD, BREAKFAST_MENU
    }

    private List<Food> foodList = new ArrayList<>();

    private Food.FoodBuilder food;
    private StringBuilder text;

    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.printf("startElement -> uri: %s, localName: %s, qName: %s%n", uri, localName, qName);

        text = new StringBuilder();

        if (qName.equals("food"))
            food = Food.builder()
                    .id((parseInt(attributes.getValue("id"))));
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        val tagName =
                MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));

        switch (tagName) {
            case NAME:
                food.name(text.toString());
                break;
            case PRICE:
                food.price(text.toString());
                break;
            case DESCRIPTION:
                food.description(text.toString().trim());
                break;
            case CALORIES:
                food.calories(parseInt(text.toString()));
                break;
            case FOOD:
                foodList.add(food.build());
                food = null;
        }
    }

    @Override
    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": "	+ exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": "	+ exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw exception;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }
}
