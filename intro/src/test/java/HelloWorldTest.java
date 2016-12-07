import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void постфиксныйИнкрементРаботаетПравильно() throws Exception {

        int i=3;
        int k = 1;
//        i = -i++ + i++ + -i;
//        System.out.println(i);

        int i2;
        int i3;
        int i4;
        int i5;

        assertEquals(-3, i2 = -i++);
        assertEquals(4, i);

        assertEquals(4, i3 = i++);
        assertEquals(5, i);

        assertEquals(-5, i4 = -i);
        assertEquals(5, i);

        assertEquals(1, i5 = i2 + i3);
        assertEquals(5, i);

        assertEquals(-4, i5 + i4);
        assertEquals(5, i);
    }
}