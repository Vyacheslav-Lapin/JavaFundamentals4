package xml.dom;

import org.junit.Test;
import xml.Food;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DomReaderTest {
    @Test
    public void getFoods() throws Exception {
        List<Food> foods = DomReader.getFoods(new File("src/test/resources/menu.xml"));
        assertTrue(foods
                .contains(
                        new Food()
                                .id(1)
                                .name("Belgian Waffles")
                                .price("$5.95")
                                .description("two of our famous Belgian Waffles with plenty of real maple syrup")
                                .calories(650)));
    }

}