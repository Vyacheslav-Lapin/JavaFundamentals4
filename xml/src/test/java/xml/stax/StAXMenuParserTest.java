package xml.stax;

import org.junit.Test;
import xml.Food;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StAXMenuParserTest {
    @Test
    public void process() throws Exception {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream("src/test/resources/menu.xml");

            XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(input);

            List<Food> foodList = StAXMenuParser.process(reader);
            assertTrue(foodList != null &&
                    foodList.contains(
                            new Food()
                                    .id(1)
                                    .name("Belgian Waffles")
                                    .price("$5.95")
                                    .description("two of our famous Belgian Waffles with plenty of real maple syrup")
                                    .calories(650)));

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}