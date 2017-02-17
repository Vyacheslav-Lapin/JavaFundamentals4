package xml.jaxb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xml.Food;

import java.io.File;

import static com.epam.courses.jf.test.Tests.RESOURCES_FILE_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JaxbDemoTest {

    private Food food;
    private JaxbDemo<Food> foodJaxbDemo;
    private File file = new File(RESOURCES_FILE_PATH + "food.xml");

    @BeforeEach
    void setUp() throws Exception {
        food = new Food()
                .id(123)
                .name("nnn")
                .description("ddd")
                .calories(234)
                .price("333");
        foodJaxbDemo = JaxbDemo.from(Food.class);
    }

    @Test
    void marshal() throws Exception {
        foodJaxbDemo.marshal(food, file);
        assertEquals(food, foodJaxbDemo.unmarshal(file));
    }

}