package xml.jaxp;

import org.junit.Test;
import xml.Food;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class JaxpDomDemoTest {
    @Test
    public void getFoods() throws Exception {
        File file = new File("src/test/resources/menu.xml");
        List<Food> foodList = JaxpDomDemo.getFoods(file);
        assertTrue(foodList
                .contains(
                        Food.builder()
                                .id(1)
                                .name("Belgian Waffles")
                                .price("$5.95")
                                .description("two of our famous Belgian Waffles with plenty of real maple syrup")
                                .calories(650)
                                .build()));
    }

}