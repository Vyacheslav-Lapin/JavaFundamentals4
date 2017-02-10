package xml.jaxp;

import org.junit.Test;
import xml.Food;
import xml.sax.MenuSaxHandler;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class JaxpSaxDemoTest {
    @Test
    public void main() throws Exception {
        MenuSaxHandler handler = new MenuSaxHandler();
        File file = new File("src/test/resources/menu.xml");
        List<Food> foodList = JaxpSaxDemo.parse(file, handler).getFoodList();

        assertTrue(foodList
                .contains(
                        new Food()
                                .id(1)
                                .name("Belgian Waffles")
                                .price("$5.95")
                                .description("two of our famous Belgian Waffles with plenty of real maple syrup")
                                .calories(650)));
    }
}