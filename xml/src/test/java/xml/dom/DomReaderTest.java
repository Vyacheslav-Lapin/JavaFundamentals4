package xml.dom;

import org.junit.jupiter.api.Test;
import xml.Food;

import java.io.File;
import java.util.List;

import static com.epam.courses.jf.test.Tests.RESOURCES_FILE_PATH;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DomReaderTest {
    @Test
    void getFoods() throws Exception {
        List<Food> foods = DomReader.getFoods(new File(RESOURCES_FILE_PATH + "menu.xml"))
                .collect(toList());

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