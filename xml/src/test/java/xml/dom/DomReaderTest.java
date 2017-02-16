package xml.dom;

import org.junit.Test;
import xml.Food;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static xml.Tests.RESOURCES_FILE_PATH;

public class DomReaderTest {
    @Test
    public void getFoods() throws Exception {
        List<Food> foods = DomReader.getFoods(new File(RESOURCES_FILE_PATH + "menu.xml"))
                .collect(Collectors.toList());
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