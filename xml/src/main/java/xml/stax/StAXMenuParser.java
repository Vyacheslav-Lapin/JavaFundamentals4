package xml.stax;

import lombok.val;
import xml.Food;
import xml.MenuTagName;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static javax.xml.stream.XMLStreamConstants.*;

@SuppressWarnings("WeakerAccess")
public class StAXMenuParser {
    static List<Food> process(XMLStreamReader reader) throws XMLStreamException {
        val menu = new ArrayList<Food>();
        Food food = null;
        MenuTagName elementName = null;
        while (reader.hasNext()) {
            // определение типа "прочтённого" элемента (тега)
            int type = reader.next();
            switch (type) {
                case START_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    if (elementName == MenuTagName.FOOD)
                        food = new Food()
                                .id(parseInt(reader.getAttributeValue(null, "id")));
                    break;

                case CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty())
                        break;

                    //noinspection ConstantConditions
                    switch (elementName) {
                        case NAME:
                            //noinspection ConstantConditions
                            food.name(text);
                            break;
                        case PRICE:
                            //noinspection ConstantConditions
                            food.price(text);
                            break;
                        case DESCRIPTION:
                            //noinspection ConstantConditions
                            food.description(text);
                            break;
                        case CALORIES:
                            //noinspection ConstantConditions
                            food.calories(parseInt(text));
                    }
                    break;
                case END_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    if (elementName == MenuTagName.FOOD)
                        //noinspection ConstantConditions
                        menu.add(food);
            }
        }
        return menu;
    }
}
